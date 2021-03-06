package top.ljc.easyActivity.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Activity.DetailsActivity;
import top.ljc.easyActivity.Activity.LoginActivity;
import top.ljc.easyActivity.Activity.NormalManageActivity;
import top.ljc.easyActivity.Activity.SuperManageActivity;
import top.ljc.easyActivity.Adapter.UserActivityItemAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.Utils.SharedPreferencesUtils;
import top.ljc.easyActivity.View.EditTextPlus;
import top.ljc.easyActivity.View.ItemView;

import static android.app.Activity.RESULT_OK;
import static android.support.constraint.Constraints.TAG;
import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class UserFragment extends Fragment implements View.OnClickListener{

    private static final int REQUEST_CODE = 2;

    private static final int UPDATE_LIST_JOINED = 11;
    private static final int UPDATE_LIST_MANAGED = 12;
    private static final int NO_NET = 13;
    private static final int UPDATE_USERINFO = 14;

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
    private ItemView ivMail;
    private ItemView ivAbout;
    private ItemView ivCache;
    private ItemView ivVersion;

    private Boolean isSpreadActivityJoined = false;
    private LinearLayout llActivityJoined;
    private ItemView itemviewActivityJoined;
    private RecyclerView recyclerviewActivityJoined;
    private ArrayList<ActivityItem> arrayListJoined;
    private UserActivityItemAdapter adapterJoined;

    private Boolean isSpreadActivityManaged = false;
    private LinearLayout llActivityManaged;
    private RecyclerView recyclerviewActivityManaged;
    private ItemView itemviewActivityManaged;
    private ArrayList<ActivityItem> arrayListManaged;
    private UserActivityItemAdapter adapterManaged;
    private ArrayList<Integer> flags;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE_LIST_JOINED:
                    adapterJoined.notifyDataSetChanged();
                    break;
                case UPDATE_LIST_MANAGED:
                    adapterManaged.notifyDataSetChanged();
                    break;
                case NO_NET:
                    Toast.makeText(context,"请检查网络连接！",Toast.LENGTH_SHORT).show();
                    break;
                case UPDATE_USERINFO:
                    updateUserInfo((String)msg.obj);
                    break;
                default:
                    break;
            }
        }
    };

    private void updateUserInfo(String string) {
        try {
            JSONObject jsonObject = new JSONObject(string);
            Toast.makeText(context,jsonObject.getString("updateMessage"),Toast.LENGTH_SHORT).show();
            if (jsonObject.getBoolean("updateSuccess")){
                loginSuccess();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();

        View view = inflater.inflate(R.layout.fragment_user,container,false);

        findViews(view);

        initData();

        initView(view);

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
        ivMail = (ItemView)view.findViewById( R.id.iv_mail );
        ivAbout = (ItemView)view.findViewById( R.id.iv_about );
        ivCache = (ItemView)view.findViewById( R.id.iv_cache );
        ivVersion = (ItemView)view.findViewById( R.id.iv_version );
        llActivityJoined = (LinearLayout) view.findViewById(R.id.ll_activity_joined);
        recyclerviewActivityJoined = (RecyclerView) view.findViewById(R.id.recyclerview_activity_joined);
        llActivityManaged = (LinearLayout) view.findViewById(R.id.ll_activity_managed);
        recyclerviewActivityManaged = (RecyclerView) view.findViewById(R.id.recyclerview_activity_managed);
        itemviewActivityJoined = (ItemView) view.findViewById(R.id.itemview_activity_joined);
        itemviewActivityManaged = (ItemView) view.findViewById(R.id.itemview_activity_managed);

        ivUsrename.setOnClickListener(this);
        ivPhone.setOnClickListener(this);
        ivMail.setOnClickListener(this);
        btExit.setOnClickListener(this);
        ivAvatar.setOnClickListener(this);
        userSignature.setOnClickListener(this);
        llActivityJoined.setOnClickListener(this);
        llActivityManaged.setOnClickListener(this);
        ivAbout.setOnClickListener(this);
    }

    public void initData() {
        user = new User();

        arrayListJoined = new ArrayList<>();
        arrayListManaged = new ArrayList<>();

        adapterJoined = new UserActivityItemAdapter(arrayListJoined);
        adapterManaged = new UserActivityItemAdapter(arrayListManaged);
        flags = new ArrayList<>();
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

        if (loginStatus){
            setUserInfoDisplay(true);
        }else {
            setUserInfoDisplay(false);
        }

        recyclerviewActivityJoined.setLayoutManager(new LinearLayoutManager(context));
        recyclerviewActivityJoined.setAdapter(adapterJoined);

        recyclerviewActivityManaged.setLayoutManager(new LinearLayoutManager(context));
        recyclerviewActivityManaged.setAdapter(adapterManaged);

        adapterJoined.setOnitemClick(new UserActivityItemAdapter.OnitemClick() {
            @Override
            public void onItemClick(int position) {
                //打开活动详情界面
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("activityitem",arrayListJoined.get(position));
                startActivity(intent);
            }
        });
        adapterManaged.setOnitemClick(new UserActivityItemAdapter.OnitemClick() {
            @Override
            public void onItemClick(int position) {
                if (flags.get(position) == 0){
                    //如果是创建者，打开超级管理员界面
                    Intent intent = new Intent(context, SuperManageActivity.class);
                    intent.putExtra("activityitem",arrayListManaged.get(position));
                    startActivity(intent);
                }else {
                    //打开普通管理员界面
                    Intent intent = new Intent(context, NormalManageActivity.class);
                    intent.putExtra("activityitem",arrayListManaged.get(position));
                    startActivity(intent);
                }
            }
        });
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
                popUpdateDialog("签名", userSignature.getText().toString(),2);
            }else {
                //跳转登陆界面
                Intent intent = new Intent(context, LoginActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        }else if (v == llActivityJoined){
            if (isSpreadActivityJoined){
                itemviewActivityJoined.setArrowImage(R.drawable.filter_down);
                recyclerviewActivityJoined.setVisibility(View.GONE);
                isSpreadActivityJoined = false;
                arrayListJoined.clear();
            }else {
                itemviewActivityJoined.setArrowImage(R.drawable.filter_up);
                recyclerviewActivityJoined.setVisibility(View.VISIBLE);
                isSpreadActivityJoined = true;
                getActivityList(2);
            }
        }else if (v == llActivityManaged){
            if (isSpreadActivityManaged){
                itemviewActivityManaged.setArrowImage(R.drawable.filter_down);
                recyclerviewActivityManaged.setVisibility(View.GONE);
                isSpreadActivityManaged = false;
                arrayListManaged.clear();
            }else {
                itemviewActivityManaged.setArrowImage(R.drawable.filter_up);
                recyclerviewActivityManaged.setVisibility(View.VISIBLE);
                isSpreadActivityManaged = true;
                getActivityList(0);
                getActivityList(1);
            }
        }else if (v == ivAbout){
            Intent intent = new Intent(context,NormalManageActivity.class);
            startActivity(intent);
        }else if (v == ivUsrename){
            //修改用户名
            popUpdateDialog("用户名", ivUsrename.getRightText(),0);
        }else if (v == ivPhone){
            //修改手机号
            popUpdateDialog("手机号", ivPhone.getRightText(),3);
        }else if (v == ivSex){
            //修改性别
        }else if (v == ivMail){
            //修改邮箱
            popUpdateDialog("邮箱", ivMail.getRightText(),4);
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

        //清除用户信息缓存
        new SharedPreferencesUtils(context,"data").clear();

        //用户信息回归初始值
        user.setUid(0);
        user.setAvatar("");
        user.setUname("");
        user.setPhone("");
        user.setSex(false);
        user.setSignature("");
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
            ivMail.setVisibility(View.VISIBLE);
            btExit.setVisibility(View.VISIBLE);
            llActivityJoined.setVisibility(View.VISIBLE);
            llActivityManaged.setVisibility(View.VISIBLE);
        }else {
            ivUsrename.setVisibility(View.GONE);
            ivSex.setVisibility(View.GONE);
            ivPhone.setVisibility(View.GONE);
            ivMail.setVisibility(View.GONE);
            btExit.setVisibility(View.GONE);
            llActivityJoined.setVisibility(View.GONE);
            llActivityManaged.setVisibility(View.GONE);
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
        ivMail.setRightText(user.getEmail());

        setUserInfoDisplay(true);
    }

    /**
     * 得到用户参与/管理/创建的活动列表,添加到对应的容器中
     * @param status
     * 0:创建 1:管理 2:参与
     */
    private void getActivityList(int status){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("uId", user.getUid()+"")
                            .add("flag",status+"")
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/activity/getActivity")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d(TAG,"联网获取列表数据失败");
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            JsonObject jsonObject = gson.fromJson(response.body().string(),JsonObject.class);
                            JsonArray jsonArray = jsonObject.getAsJsonArray("activityData");

                            if (status == 2){
                                //请求的数据是参与列表
                                for (JsonElement activity:jsonArray){
                                    arrayListJoined.add(gson.fromJson(activity,new TypeToken<ActivityItem>(){}.getType()));
                                }
                                handler.sendEmptyMessage(UPDATE_LIST_JOINED);
                            }else if (status == 1){
                                //请求的数据是管理的活动
                                for (JsonElement activity:jsonArray){
                                    synchronized (arrayListManaged){
                                        arrayListManaged.add(gson.fromJson(activity,new TypeToken<ActivityItem>(){}.getType()));
                                        flags.add(1);
                                    }
                                }
                                handler.sendEmptyMessage(UPDATE_LIST_MANAGED);
                            }else {
                                //请求的数据是创建的活动
                                for (JsonElement activity:jsonArray){
                                    synchronized (arrayListManaged){
                                        arrayListManaged.add(gson.fromJson(activity,new TypeToken<ActivityItem>(){}.getType()));
                                        flags.add(0);
                                    }
                                }
                                handler.sendEmptyMessage(UPDATE_LIST_MANAGED);
                            }
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


    /**
     * 弹出更新用户信息的弹窗
     * @param title 弹出框标题文字
     * @param string 编辑框文字
     * @param flag  改变的哪个用户信息的标志
     */
    private void popUpdateDialog(String title,String string,int flag){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //通过LayoutInflater来加载一个xml的布局文件作为一个View对象
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_update, null);

        //设置Dialog界面初始状态
        TextView tvMsgTitle = (TextView) view.findViewById(R.id.tv_msg_title);
        EditTextPlus etpContent = (EditTextPlus) view.findViewById(R.id.etp_content);
        Button btPositive = (Button) view.findViewById(R.id.bt_positive);

        tvMsgTitle.setText("修改"+ title);
        etpContent.setHeadText(title);
        etpContent.setEditText(string);

        //设置我们自己定义的布局文件作为弹出框的Content
        builder.setView(view);

        AlertDialog dialog = builder.show();
        btPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etpContent.getText();
                if (content == null||content.equals("")){
                    Toast.makeText(context,"请输入修改的信息内容！",Toast.LENGTH_SHORT).show();
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                                    .connectTimeout(1, TimeUnit.SECONDS);
                            OkHttpClient okHttpClient = builder.build();
                            RequestBody requestBody = new FormBody.Builder()
                                    .add("uId",user.getUid()+"")
                                    .add("flag", flag+"")
                                    .add("content",content)
                                    .build();
                            Request request = new Request.Builder()
                                    .url(SERVER_ADDRESS+"/user/updateUserInfo")
                                    .post(requestBody)
                                    .build();
                            okHttpClient.newCall(request).enqueue(new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                    handler.sendEmptyMessage(NO_NET);
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    String str = response.body().string();
                                    try {
                                        JSONObject jsonObject = new JSONObject(str);
                                        if (jsonObject.getBoolean("updateSuccess")){
                                            switch (flag){
                                                case 0:
                                                    user.setUname(content);
                                                    break;
                                                case 2:
                                                    user.setSignature(content);
                                                    break;
                                                case 3:
                                                    user.setPhone(content);
                                                    break;
                                                case 4:
                                                    user.setEmail(content);
                                                    break;
                                            }
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    Message message = new Message();
                                    message.what = UPDATE_USERINFO;
                                    message.obj = str;
                                    handler.sendMessage(message);
                                }
                            });
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
                dialog.dismiss();
            }
        });
    }
}