package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.EditTextPlus;
import top.ljc.easyActivity.View.mToolbar;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class CreateActivity extends AppCompatActivity {
    private Context context;
    private mToolbar mToolbar;
    private EditTextPlus etpName;
    private EditTextPlus etpLocation;
    private EditTextPlus etpAbstract;
    private EditText etDescription;

    private final static int ADDACTIVITY = 1;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ADDACTIVITY:
                    parseJSONWithJSONObject((String) msg.obj);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_create);
        findViews();

        initView();
    }

    private void initView() {

    }

    private void findViews() {
        mToolbar = (mToolbar) findViewById(R.id.toolbar_create);
        etpName = (EditTextPlus) findViewById(R.id.etp_name);
        etpLocation = (EditTextPlus) findViewById(R.id.etp_location);
        etpAbstract = (EditTextPlus) findViewById(R.id.etp_abstract);
        etDescription = (EditText) findViewById(R.id.et_description);


        mToolbar.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setOnClickRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"发送数据",Toast.LENGTH_SHORT).show();
                addActivity();
                /*Intent intent = new Intent(context,TableActivity.class);
                startActivity(intent);*/
            }
        });
    }

    private void addActivity() {
        String aName = etpName.getText();
        if (aName==null||aName.equals("")){
            Toast.makeText(context,"请输入活动名称",Toast.LENGTH_SHORT).show();
            return;
        }
        String aLocation = etpLocation.getText();
        if (aLocation==null||aLocation.equals("")){
            Toast.makeText(context,"请输入活动举办位置",Toast.LENGTH_SHORT).show();
            return;
        }
        String aAbstract = etpName.getText();
        if (aAbstract==null||aAbstract.equals("")){
            Toast.makeText(context,"请输入对活动一句话简介",Toast.LENGTH_SHORT).show();
            return;
        }
        String aDescription = etDescription.getText().toString();
        if (aDescription==null||aDescription.equals("")){
            Toast.makeText(context,"请输入对活动的详细描述",Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("uName","zhangsan")
                            .add("aName", aName)
                            .add("aDeadlineTime","2019-5-30")
                            .add("aAbstract",aAbstract)
                            .add("aDescription",aDescription)
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/activity/addActivity")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Message message = new Message();
                            message.what = ADDACTIVITY;
                            message.obj = response.body().string();
                            handler.sendMessage(message);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithJSONObject(String jsonData){
        Toast.makeText(context,jsonData,Toast.LENGTH_SHORT).show();
        /*try{
            JSONObject jsonObject = new JSONObject(jsonData);
            Boolean loginSuccess = jsonObject.getBoolean("loginSuccess");
            loginStatus = loginSuccess;
            String loginMessage = jsonObject.getString("loginMessage");
            if (loginSuccess){
                User user = new User();
                jsonObject = jsonObject.getJSONObject("userData");
                user.setPhone(jsonObject.getString("uPhone"));
                user.setUid(jsonObject.getInt("uId"));
                user.setUname(jsonObject.getString("uName"));
                user.setAvatar(jsonObject.getString("uAvatarUrl"));
                user.setSignature(jsonObject.getString("uSignature"));
                user.setSex(jsonObject.getBoolean("uSex"));

                BackPreActivity();
            }else{
                Toast.makeText(this,loginMessage,Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
