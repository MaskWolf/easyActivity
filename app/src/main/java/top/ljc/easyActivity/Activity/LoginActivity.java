package top.ljc.easyActivity.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.Utils.SharedPreferencesUtils;
import top.ljc.easyActivity.View.EditTextPlus;
import top.ljc.easyActivity.View.mToolbar;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class LoginActivity extends Activity implements View.OnClickListener{

    private Boolean loginStatus = false;

    private Boolean isPwdRemember = false;

    private final static int LOGIN = 1;
    private final static int NO_NET = 2;

    private Context context;

    private mToolbar mToolbar;
    private TextView tvRegister;
    private EditTextPlus etUser;
    private EditTextPlus etPassword;
    private Button btLogin;
    private CheckBox cbPwdRemember;

    private SharedPreferencesUtils sharedPreferencesUtils;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case LOGIN:
                    parseJSONWithJSONObject((String) msg.obj);
                    break;
                case NO_NET:
                    Toast.makeText(context,"请检查网络连接！",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_login);

        initData();

        findViews();

        initViews();
    }

    private void initData() {
        sharedPreferencesUtils = new SharedPreferencesUtils(this,"data");
        isPwdRemember = sharedPreferencesUtils.getBoolean("isPwdRemember",false);
    }

    private void findViews() {
        etUser = (EditTextPlus)findViewById( R.id.et_user );
        etPassword = (EditTextPlus)findViewById( R.id.et_password );
        btLogin = (Button) findViewById( R.id.bt_login );
        tvRegister = (TextView)findViewById(R.id.tv_register);
        mToolbar = (mToolbar)findViewById(R.id.toolbar_login);
        cbPwdRemember = (CheckBox)findViewById(R.id.cb_pwd_remember);

        tvRegister.setOnClickListener(this);
        btLogin.setOnClickListener( this );
        mToolbar.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackPreActivity();
            }
        });
    }

    private void initViews() {
        if (isPwdRemember){
            cbPwdRemember.setChecked(true);
            etUser.setEditText(sharedPreferencesUtils.getString("uName"));
            etPassword.setEditText(sharedPreferencesUtils.getString("uPassword"));
        }
    }

    @Override
    public void onClick(View v) {
        if (v == tvRegister){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }else if (v == btLogin){
            login();
        }
    }

    private void login() {
        String username = etUser.getText();
        String password = etPassword.getText();
        if (username == null|| username.equals("")){
            Toast.makeText(this,"请输入用户名！",Toast.LENGTH_SHORT).show();
            return;
        }else if (password == null|| password.equals("")){
            Toast.makeText(this,"请输入密码！",Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .connectTimeout(1, TimeUnit.SECONDS);
                    OkHttpClient okHttpClient = builder.build();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("uName", username)
                            .add("uPassword",password)
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/user/login")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            handler.sendEmptyMessage(NO_NET);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Message message = new Message();
                            message.what = LOGIN;
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
        try{
            User user = new User();
            JSONObject jsonObject = new JSONObject(jsonData);
            Boolean loginSuccess = jsonObject.getBoolean("loginSuccess");
            user.setAvatar(jsonObject.getString("userImage"));
            loginStatus = loginSuccess;
            String loginMessage = jsonObject.getString("loginMessage");
            if (loginSuccess){
                jsonObject = jsonObject.getJSONObject("userData");
                user.setPhone(jsonObject.getString("uPhone"));
                user.setUid(jsonObject.getInt("uId"));
                user.setUname(jsonObject.getString("uName"));
                user.setSignature(jsonObject.getString("uSignature"));
                user.setSex(jsonObject.getBoolean("uSex"));

                isPwdRemember = cbPwdRemember.isChecked();
                sharedPreferencesUtils.putValues(new SharedPreferencesUtils.ContentValue("isPwdRemember",isPwdRemember));
                //将用户名和密码存储到本地
                if (isPwdRemember){
                    sharedPreferencesUtils.putValues(new SharedPreferencesUtils.ContentValue("uName",etUser.getText()));
                    sharedPreferencesUtils.putValues(new SharedPreferencesUtils.ContentValue("uPassword",etPassword.getText()));
                }

                BackPreActivity();
            }else{
                Toast.makeText(context,loginMessage,Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        BackPreActivity();
    }

    /**
     * 返回上一个活动
     */
    private void BackPreActivity() {
        Intent intent = new Intent();
        intent.putExtra("loginStatus", loginStatus);
        setResult(RESULT_OK, intent);
        finish();
    }
}
