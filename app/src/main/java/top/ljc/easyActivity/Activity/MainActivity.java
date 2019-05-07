package top.ljc.easyActivity.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;

import top.ljc.easyActivity.Adapter.MyFragmentPagerAdapter;
import top.ljc.easyActivity.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private ViewPager vpMain;
    private RadioButton rbHome;
    private RadioButton rbActivity;
    private RadioButton rbUser;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        findViews();

        initData();

        initView();
    }

    private void initData() {
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
    }

    private void initView() {
        vpMain.setAdapter(myFragmentPagerAdapter);
        vpMain.setCurrentItem(0);
        vpMain.addOnPageChangeListener(this);
        vpMain.setOffscreenPageLimit(2);

        rbHome.setChecked(true);
    }

    private void findViews() {
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
