package top.ljc.easyActivity.Activity;

import android.app.Activity;
import android.content.Context;
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
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
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

public class RegisterActivity extends Activity implements View.OnClickListener{

    private mToolbar mToolbar;
    private EditTextPlus etpUname;
    private CheckBox cbMan;
    private CheckBox cbWoman;
    private EditTextPlus etpPassword;
    private EditTextPlus etpPasswordVerify;
    private EditTextPlus etpPhone;
    private TextView tvGetcdoe;
    private EditTextPlus etpCode;
    private Button btRegister;

    /**
     * 获取验证码后的60秒倒计时
     */
    private int countdown = 60;
    private static final int UPDATE_COUNTDOWN = 1;

    /**
     * 注册后解析返回数据并更新界面
     */
    private static final int REGISTER = 2;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_COUNTDOWN:
                    if (countdown>=0){
                        tvGetcdoe.setText(countdown+"秒");
                        countdown--;
                        removeMessages(UPDATE_COUNTDOWN);
                        sendEmptyMessageDelayed(UPDATE_COUNTDOWN,1000);
                    }else {
                        tvGetcdoe.setText("获取验证码");
                        countdown = 60;
                        tvGetcdoe.setTextColor(getResources().getColor(R.color.colorPrimary));
                        tvGetcdoe.setEnabled(true);
                        removeMessages(UPDATE_COUNTDOWN);
                    }
                    break;
                case REGISTER:
                    parseJSONWithJSONObject((String)msg.obj);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_register);

        findViews();
    }

    private void findViews() {
        mToolbar = (mToolbar)findViewById(R.id.toolbar_register);
        etpUname = (EditTextPlus)findViewById( R.id.etp_uname );
        cbMan = (CheckBox)findViewById( R.id.cb_man );
        cbWoman = (CheckBox)findViewById( R.id.cb_woman );
        etpPassword = (EditTextPlus)findViewById( R.id.etp_password );
        etpPasswordVerify = (EditTextPlus)findViewById( R.id.etp_password_verify );
        etpPhone = (EditTextPlus)findViewById( R.id.etp_phone );
        tvGetcdoe = (TextView)findViewById( R.id.tv_getcdoe );
        etpCode = (EditTextPlus)findViewById( R.id.etp_code );
        btRegister = (Button)findViewById( R.id.bt_register );

        mToolbar.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cbMan.setOnClickListener(this);
        cbWoman.setOnClickListener(this);
        tvGetcdoe.setOnClickListener(this);
        btRegister.setOnClickListener( this );

    }

    @Override
    public void onClick(View v) {
        if (v == btRegister){
            register();
        }else if (v == tvGetcdoe){
            getCode();
        }else if (v == cbMan){
            cbMan.setTextColor(getResources().getColor(R.color.smssdk_black));
            cbWoman.setTextColor(getResources().getColor(R.color.smssdk_gray));
            cbWoman.setChecked(false);
        }else if(v == cbWoman){
            cbWoman.setTextColor(getResources().getColor(R.color.smssdk_black));
            cbMan.setTextColor(getResources().getColor(R.color.smssdk_gray));
            cbMan.setChecked(false);
        }
    }

    /**
     * 获得手机验证码
     */
    private void getCode() {
        String phone = etpPhone.getText();
        if (phone.equals("")||phone == null){
            Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        tvGetcdoe.setEnabled(false);
        tvGetcdoe.setTextColor(getResources().getColor(R.color.smssdk_gray));
        handler.sendEmptyMessage(UPDATE_COUNTDOWN);
    }

    /**
     * 使用SMSSDK发送手机验证码到用户
     * @param context
     */
    public void sendCode(final Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country"); // 国家代码，如“86”
                    String phone = (String) phoneMap.get("phone"); // 手机号码，如“13800138000”
                    // TODO 利用国家代码和手机号码进行后续的操作
                    Toast.makeText(context,"验证成功",Toast.LENGTH_SHORT).show();
                } else{
                    // TODO 处理错误的结果
                    Toast.makeText(context,"验证失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
        page.show(context);
    }

    private void register(){
        String username = etpUname.getText();
        String password = etpPassword.getText();
        if (username == null|| username.equals("")){
            Toast.makeText(this,"请输入用户名！",Toast.LENGTH_SHORT).show();
            return;
        }else if (password == null|| password.equals("")){
            Toast.makeText(this,"请输入密码！",Toast.LENGTH_SHORT).show();
            return;
        }
        Boolean sex = cbMan.isChecked();
        if (!cbWoman.isChecked()&&!cbMan.isChecked()){
            Toast.makeText(this,"请选择性别！",Toast.LENGTH_SHORT).show();
            return;
        }
        String phone = etpPhone.getText();
        if (phone == null|| phone.equals("")){
            Toast.makeText(this,"请输入手机号！",Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("uName", username)
                            .add("uSex",sex.toString())
                            .add("uPassword",password)
                            .add("uPhone",phone)
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/user/register")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Message message = new Message();
                            message.what = REGISTER;
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
            Boolean registerSuccess = jsonObject.getBoolean("registerSuccess");
            user.setAvatar(jsonObject.getString("userImage"));
            String registerMessage = jsonObject.getString("registerMessage");
            if (registerSuccess){
                jsonObject = jsonObject.getJSONObject("registerUser");
                user.setPhone(jsonObject.getString("uPhone"));
                user.setUid(jsonObject.getInt("uId"));
                user.setUname(jsonObject.getString("uName"));
                user.setSignature(jsonObject.getString("uSignature"));
                user.setSex(jsonObject.getBoolean("uSex"));
            }else{
                Toast.makeText(this,registerMessage,Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
