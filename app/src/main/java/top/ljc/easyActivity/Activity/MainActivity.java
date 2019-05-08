package top.ljc.easyActivity.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;

import top.ljc.easyActivity.Adapter.MyFragmentPagerAdapter;
import top.ljc.easyActivity.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private Toolbar toolbar;
    private ViewPager vpMain;
    private RadioButton rbHome;
    private RadioButton rbActivity;
    private RadioButton rbUser;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_main);
        findViews();

        initData();

        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.more){

        }
        return true;
    }

    private void initData() {
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
    }

    private void initView() {
        setSupportActionBar(toolbar);
        vpMain.setAdapter(myFragmentPagerAdapter);
        vpMain.setCurrentItem(0);
        vpMain.addOnPageChangeListener(this);
        vpMain.setOffscreenPageLimit(2);

        rbHome.setChecked(true);
    }

    private void findViews() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        vpMain = (ViewPager)findViewById( R.id.vp_main );
        rbHome = (RadioButton)findViewById( R.id.rb_home );
        rbActivity = (RadioButton)findViewById( R.id.rb_activity );
        rbUser = (RadioButton)findViewById( R.id.rb_user );

        rbHome.setOnClickListener( this );
        rbActivity.setOnClickListener( this );
        rbUser.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == rbHome ) {
            // Handle clicks for rbHome
            vpMain.setCurrentItem(0);
        } else if ( v == rbActivity ) {
            // Handle clicks for rbActivity
            vpMain.setCurrentItem(1);
        } else if ( v == rbUser ) {
            // Handle clicks for rbUser
            vpMain.setCurrentItem(2);
        }
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2){
            switch (vpMain.getCurrentItem()){
                default:
                    rbHome.setChecked(true);
                    break;
                case 1:
                    rbActivity.setChecked(true);
                    break;
                case 2:
                    rbUser.setChecked(true);
                    break;
            }
        }
    }

}
