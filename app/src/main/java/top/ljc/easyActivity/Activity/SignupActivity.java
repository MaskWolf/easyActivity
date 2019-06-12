package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.mToolbar;

public class SignupActivity extends AppCompatActivity {

    private Context context;

    private mToolbar toolbarSignup;
    private RecyclerView recyclerviewSignup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        setContentView(R.layout.activity_signup);

        initData();

        findViews();

        initView();
    }

    private void initData() {

    }

    private void findViews() {
        toolbarSignup = (mToolbar) findViewById(R.id.toolbar_signup);
        recyclerviewSignup = (RecyclerView) findViewById(R.id.recyclerview_signup);

        toolbarSignup.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbarSignup.setOnClickRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {

    }
}
