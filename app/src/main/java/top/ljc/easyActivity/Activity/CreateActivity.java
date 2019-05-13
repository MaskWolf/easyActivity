package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.mToolbar;

public class CreateActivity extends AppCompatActivity {
    private Context context;
    private mToolbar mToolbar;

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
        mToolbar = (mToolbar) findViewById(R.id.toolbar_create);

        mToolbar.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setOnClickRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"下一步",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findViews() {
    }
}
