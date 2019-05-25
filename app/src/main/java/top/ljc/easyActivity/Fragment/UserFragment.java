package top.ljc.easyActivity.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import top.ljc.easyActivity.Activity.LoginActivity;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.ItemView;

import static android.app.Activity.RESULT_OK;

public class UserFragment extends Fragment implements View.OnClickListener{

    private static final int REQUEST_CODE = 2;

    private Boolean loginStatus = false;
    private User user;

    private Context context;
    private ImageView topBgk;
    private Button btExit;
    private ImageView ivAvatar;
    private TextView userSignature;
    private ItemView ivUsrename;
    private ItemView ivSex;
    private ItemView ivPhone;
    private ItemView ivQq;
    private ItemView ivAbout;
    private ItemView ivCache;
    private ItemView ivVersion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();

        View view = inflater.inflate(R.layout.fragment_user,container,false);

        findViews(view);

        initData();

        initView(view);

        btExit.setOnClickListener(this);
        ivAvatar.setOnClickListener(this);
        userSignature.setOnClickListener(this);

        return view;
    }

    private void findViews(View view) {
        topBgk = (ImageView) view.findViewById(R.id.top_bgk);
        btExit = (Button)view.findViewById(R.id.bt_exit);
        ivAvatar = (ImageView)view.findViewById( R.id.iv_avatar );
        userSignature = (TextView)view.findViewById( R.id.user_signature );
        ivUsrename = (ItemView)view.findViewById( R.id.iv_usrename );
        ivSex = (ItemView)view.findViewById( R.id.iv_sex );
        ivPhone = (ItemView)view.findViewById( R.id.iv_phone );
        ivQq = (ItemView)view.findViewById( R.id.iv_qq );
        ivAbout = (ItemView)view.findViewById( R.id.iv_about );
        ivCache = (ItemView)view.findViewById( R.id.iv_cache );
        ivVersion = (ItemView)view.findViewById( R.id.iv_version );
    }

    public void initData() {
        user = new User();
    }

    private void initView(View view) {
        //加载圆形头像
        Glide.with(view.getContext()).load(R.drawable.avatar_default)
                .bitmapTransform(new CropCircleTransformation(view.getContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.avatar_default)
                .error(R.drawable.avatar_default)
                .into(ivAvatar);

        //加载磨砂背景
        Glide.with(view.getContext()).load(R.drawable.bgk_default)
                .bitmapTransform(new BlurTransformation(context, 25), new CenterCrop(view.getContext()))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bgk_default)
                .error(R.drawable.bgk_default)
                .into(topBgk);

        if (!loginStatus){
            setUserInfoDisplay(false);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btExit){
            //退出登陆
            exitLogin();
        }else if (v == ivAvatar ){
            if (loginStatus){
                //更改头像
            }else {
                //跳转登陆界面
                Intent intent = new Intent(context, LoginActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        }else if (v == userSignature){
            if (loginStatus){
                //更改个性签名
            }else {
                //跳转登陆界面
                Intent intent = new Intent(context, LoginActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        }
    }

    private void exitLogin() {
        //隐藏用户属性界面的展示
        setUserInfoDisplay(false);

        loginStatus = false;

        //加载圆形头像为默认
        Glide.with(context).load(R.drawable.avatar_default)
                .bitmapTransform(new CropCircleTransformation(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.avatar_default)
                .error(R.drawable.avatar_default)
                .into(ivAvatar);

        //加载磨砂背景为默认
        Glide.with(context).load(R.drawable.bgk_default)
                .bitmapTransform(new BlurTransformation(context, 25), new CenterCrop(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bgk_default)
                .error(R.drawable.bgk_default)
                .into(topBgk);

        //设置个性签名为提示登陆
        userSignature.setText("登陆获取更多内容");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                loginStatus = data.getBooleanExtra("loginStatus",false);
                if (loginStatus){
                    loginSuccess();
                }
            }
        }
    }

    private void setUserInfoDisplay(boolean status) {
        if (status){
            ivUsrename.setVisibility(View.VISIBLE);
            ivSex.setVisibility(View.VISIBLE);
            ivPhone.setVisibility(View.VISIBLE);
            ivQq.setVisibility(View.VISIBLE);
            btExit.setVisibility(View.VISIBLE);
        }else {
            ivUsrename.setVisibility(View.GONE);
            ivSex.setVisibility(View.GONE);
            ivPhone.setVisibility(View.GONE);
            ivQq.setVisibility(View.GONE);
            btExit.setVisibility(View.GONE);
        }
    }

    private void loginSuccess() {

        //加载圆形头像
        Glide.with(context).load(user.getAvatar())
                .bitmapTransform(new CropCircleTransformation(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.avatar_default)
                .error(R.drawable.avatar_default)
                .into(ivAvatar);

        //加载磨砂背景
        Glide.with(context).load(user.getAvatar())
                .bitmapTransform(new BlurTransformation(context, 25), new CenterCrop(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.bgk_default)
                .error(R.drawable.bgk_default)
                .into(topBgk);

        userSignature.setText(user.getSignature());

        ivUsrename.setRightText(user.getUname());

        if (user.getSex()){
            ivSex.setRightText("男");
        }else {
            ivSex.setRightText("女");
        }

        ivPhone.setRightText(user.getPhone());
        setUserInfoDisplay(true);
    }
}