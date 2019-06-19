package top.ljc.easyActivity.Activity;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Adapter.MyFragmentPagerAdapter;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.Utils.AnimUtil;
import top.ljc.easyActivity.View.EditTextPlus;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener{

    private Context context;

    private ImageView ivMore;
    private TextView tv_1, tv_2, tv_3, tv_4;
    private PopupWindow mPopupWindow;
    private AnimUtil animUtil;

    private User user;
    private float bgAlpha = 1f;
    private boolean bright = false;
    private static final int REQUEST_CODE = 1;
    private static final int FAILURE = 2;
    private static final int SUCCESS = 3;
    private static final long DURATION = 500;
    private static final float START_ALPHA = 0.7f;
    private static final float END_ALPHA = 1f;

    private Toolbar toolbar;
    private ViewPager vpMain;
    private RadioButton rbHome;
    private RadioButton rbActivity;
    private RadioButton rbUser;

    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case FAILURE:
                    Toast.makeText(context, "获取管理员权限失败，请检查网络连接！", Toast.LENGTH_LONG).show();
                    break;
                case SUCCESS:
                    Toast.makeText(context, "获取管理员权限成功！", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //初始化Zxing二维码扫描生成框架
        ZXingLibrary.initDisplayOpinion(this);

        context = this;

        setContentView(R.layout.activity_main);
        findViews();

        initData();

        initView();
    }

    private void initData() {
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        user = new User();
    }

    private void initView() {
        toolbar.setTitle("");
        //隐藏title
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mPopupWindow = new PopupWindow(this);
        animUtil = new AnimUtil();

        vpMain.setAdapter(myFragmentPagerAdapter);
        vpMain.setCurrentItem(0);
        vpMain.addOnPageChangeListener(this);
        vpMain.setOffscreenPageLimit(2);

        rbHome.setChecked(true);
    }

    private void findViews() {
        ivMore = (ImageView) findViewById(R.id.iv_more);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        vpMain = (ViewPager)findViewById( R.id.vp_main );
        rbHome = (RadioButton)findViewById( R.id.rb_home );
        rbActivity = (RadioButton)findViewById( R.id.rb_activity );
        rbUser = (RadioButton)findViewById( R.id.rb_user );

        ivMore.setOnClickListener(this);
        rbHome.setOnClickListener( this );
        rbActivity.setOnClickListener( this );
        rbUser.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.iv_more:
                showPop();
                toggleBright();
                break;
            case R.id.tv_1:
                mPopupWindow.dismiss();
                Toast.makeText(this, tv_1.getText(), Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.tv_2:
                mPopupWindow.dismiss();
                Toast.makeText(this, tv_2.getText(), Toast.LENGTH_SHORT).show();
                intent = new Intent(this,CreateActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_3:
                mPopupWindow.dismiss();
                Toast.makeText(this, tv_3.getText(), Toast.LENGTH_SHORT).show();
                addManager();
                break;
            case R.id.tv_4:
                mPopupWindow.dismiss();
                Toast.makeText(this, tv_4.getText(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        if ( v == rbHome ) {
            // Handle clicks for rbHome
            vpMain.setCurrentItem(0);
            toolbar.setVisibility(View.VISIBLE);
        } else if ( v == rbActivity ) {
            // Handle clicks for rbActivity
            vpMain.setCurrentItem(1);
            toolbar.setVisibility(View.VISIBLE);
        } else if ( v == rbUser ) {
            // Handle clicks for rbUser
            vpMain.setCurrentItem(2);
            toolbar.setVisibility(View.GONE);
        }
    }

    /**
     * 扫描二维码获取管理员权限
     */
    private void getManagerPermission(String arguments){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .connectTimeout(1, TimeUnit.SECONDS);
                    OkHttpClient okHttpClient = builder.build();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("uId", user.getUid()+"")
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/manager/addManager?"+arguments)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            handler.sendEmptyMessage(FAILURE);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            handler.sendEmptyMessage(SUCCESS);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 添加管理员
     */
    private void addManager() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //通过LayoutInflater来加载一个xml的布局文件作为一个View对象
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_picture, null);

        //设置Dialog界面初始状态
        ImageView imageView = (ImageView) view.findViewById(R.id.picture_qr_code);
        imageView.setImageBitmap(CodeUtils.createImage( "addManager:aId=1&deadline=2019-6-20",
                600, 600, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));

        //设置我们自己定义的布局文件作为弹出框的Content
        builder.setView(view);

        builder.show();
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
                    toolbar.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    rbActivity.setChecked(true);
                    toolbar.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    rbUser.setChecked(true);
                    toolbar.setVisibility(View.GONE);
                    break;
            }
        }
    }

    private void showPop() {
        // 设置布局文件
        mPopupWindow.setContentView(LayoutInflater.from(this).inflate(R.layout.pop_more, null));
        // 为了避免部分机型不显示，我们需要重新设置一下宽高
        mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置pop透明效果
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x0000));
        // 设置pop出入动画
        mPopupWindow.setAnimationStyle(R.style.pop_more);
        // 设置pop获取焦点，如果为false点击返回按钮会退出当前Activity，如果pop中有Editor的话，focusable必须要为true
        mPopupWindow.setFocusable(true);
        // 设置pop可点击，为false点击事件无效，默认为true
        mPopupWindow.setTouchable(true);
        // 设置点击pop外侧消失，默认为false；在focusable为true时点击外侧始终消失
        mPopupWindow.setOutsideTouchable(true);
        // 相对于 + 号正下面，同时可以设置偏移量
        mPopupWindow.showAsDropDown(ivMore, -100, 0);
        // 设置pop关闭监听，用于改变背景透明度
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                toggleBright();
            }
        });

        tv_1 = mPopupWindow.getContentView().findViewById(R.id.tv_1);
        tv_2 = mPopupWindow.getContentView().findViewById(R.id.tv_2);
        tv_3 = mPopupWindow.getContentView().findViewById(R.id.tv_3);
        tv_4 = mPopupWindow.getContentView().findViewById(R.id.tv_4);

        tv_1.setOnClickListener(this);
        tv_2.setOnClickListener(this);
        tv_3.setOnClickListener(this);
        tv_4.setOnClickListener(this);
    }

    private void toggleBright() {
        // 三个参数分别为：起始值 结束值 时长，那么整个动画回调过来的值就是从0.5f--1f的
        animUtil.setValueAnimator(START_ALPHA, END_ALPHA, DURATION);
        animUtil.addUpdateListener(new AnimUtil.UpdateListener() {
            @Override
            public void progress(float progress) {
                // 此处系统会根据上述三个值，计算每次回调的值是多少，我们根据这个值来改变透明度
                bgAlpha = bright ? progress : (START_ALPHA + END_ALPHA - progress);
                backgroundAlpha(bgAlpha);
            }
        });
        animUtil.addEndListner(new AnimUtil.EndListener() {
            @Override
            public void endUpdate(Animator animator) {
                // 在一次动画结束的时候，翻转状态
                bright = !bright;
            }
        });
        animUtil.startAnimator();
    }

    /**
     * 此方法用于改变背景的透明度，从而达到“变暗”的效果
     */
    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        // 0.0-1.0
        lp.alpha = bgAlpha;
        getWindow().setAttributes(lp);
        // everything behind this window will be dimmed.
        // 此方法用来设置浮动层，防止部分手机变暗无效
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    String[] strings = result.split(":");
                    if (strings[0].equals("addManager")){
                        getManagerPermission(strings[1]);
                    }
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
