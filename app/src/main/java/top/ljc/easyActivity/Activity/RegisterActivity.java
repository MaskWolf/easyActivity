package top.ljc.easyActivity.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.mToolbar;

public class RegisterActivity extends Activity implements View.OnClickListener{

    private mToolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_register);

        mToolbar = (mToolbar)findViewById(R.id.toolbar_register);

        mToolbar.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
