package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import top.ljc.easyActivity.R;

public class NormalManageActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_manage_normal);

        initData();

        findViews();

        initViews();
    }

    private void initViews() {

    }

    private void findViews() {

    }

    private void initData() {

    }
}
