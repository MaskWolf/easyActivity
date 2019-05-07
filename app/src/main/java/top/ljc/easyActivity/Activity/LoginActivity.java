package top.ljc.easyActivity.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;
import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class LoginActivity extends Activity implements View.OnClickListener{

    private Boolean loginStatus = false;

    private final static int LOGIN = 1;
    private TextView tvRegister;
    private EditText etUser;
    private EditText etPassword;
    private Button btLogin;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case LOGIN:
                    parseJSONWithJSONObject((String) msg.obj);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        findViews();
    }

    private void findViews() {
        etUser = (EditText)findViewById( R.id.et_user );
        etPassword = (EditText)findViewById( R.id.et_password );
        btLogin = (Button)findViewById( R.id.bt_login );
        tvRegister = (TextView)findViewById(R.id.tv_register);


        tvRegister.setOnClickListener(this);
        btLogin.setOnClickListener( this );
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
        String username = etUser.getText().toString();
        String password = etPassword.getText().toString();
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
                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("uName", username)
                            .add("uPassword",password)
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/loginServlet")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.e(TAG, "onFailure: " + e.getMessage());
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

                Intent intent = new Intent();
                intent.putExtra("loginStatus",loginStatus);
                setResult(RESULT_OK,intent);
                finish();
            }else{
                Toast.makeText(this,loginMessage,Toast.LENGTH_SHORT).show();
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("loginStauts",loginStatus);
        setResult(RESULT_OK,intent);
        finish();
    }
}
