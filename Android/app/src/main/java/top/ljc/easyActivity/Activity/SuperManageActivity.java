package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Adapter.ChildActivityItemAdapter;
import top.ljc.easyActivity.Adapter.ManagerAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.Data.ChildActivityItem;
import top.ljc.easyActivity.Data.Manager;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.EditTextPlus;
import top.ljc.easyActivity.View.ItemView;
import top.ljc.easyActivity.View.mToolbar;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class SuperManageActivity extends AppCompatActivity {

    private User user;
    private ActivityItem activityItem;

    private Boolean isSpreadBasic = false;
    private Boolean isSpreadDes = false;

    private Context context;
    private mToolbar toolbarManage;
    private ItemView itemviewBasic;
    private TextView tvBasicName;
    private ImageView ivBasicQrcode;
    private TextView tvBasicLocation;
    private TextView tvBasicAbstract;
    private TextView tvBasicDeadline;
    private ItemView itemviewDes;
    private TextView tvDes;
    private ItemView itemviewSwitchJoin;

    private RecyclerView recyclerviewManager;
    private List<Manager> managerItems;
    private ManagerAdapter managerAdapter;

    private RecyclerView recyclerviewChildActivity;
    private ArrayList<ChildActivityItem> childActivityItems;
    private ChildActivityItemAdapter childActivityItemAdapter;

    private static final String TAG = "SuperManageActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_manage_super);

        initData();

        findViews();

        initViews();
    }

    private void findViews() {
        toolbarManage = (mToolbar) findViewById(R.id.toolbar_manage);
        itemviewBasic = (ItemView) findViewById(R.id.itemview_basic);
        tvBasicName = (TextView) findViewById(R.id.tv_basic_name);
        ivBasicQrcode = (ImageView) findViewById(R.id.iv_basic_qrcode);
        tvBasicLocation = (TextView) findViewById(R.id.tv_basic_location);
        tvBasicAbstract = (TextView) findViewById(R.id.tv_basic_abstract);
        tvBasicDeadline = (TextView) findViewById(R.id.tv_basic_deadline);
        itemviewDes = (ItemView) findViewById(R.id.itemview_des);
        tvDes = (TextView) findViewById(R.id.tv_des);
        itemviewSwitchJoin = (ItemView) findViewById(R.id.itemview_switch_join);
        recyclerviewManager = (RecyclerView) findViewById(R.id.recyclerview_manager);
        recyclerviewChildActivity = (RecyclerView) findViewById(R.id.recyclerview_child_activity);

        toolbarManage.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        itemviewBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSpreadBasic){
                    itemviewBasic.setArrowImage(R.drawable.filter_down);
                    tvBasicName.setVisibility(View.GONE);
                    ivBasicQrcode.setVisibility(View.GONE);
                    tvBasicLocation.setVisibility(View.GONE);
                    tvBasicAbstract.setVisibility(View.GONE);
                    tvBasicDeadline.setVisibility(View.GONE);
                    isSpreadBasic = false;
                }else {
                    itemviewBasic.setArrowImage(R.drawable.filter_up);
                    tvBasicName.setVisibility(View.VISIBLE);
                    ivBasicQrcode.setVisibility(View.VISIBLE);
                    tvBasicLocation.setVisibility(View.VISIBLE);
                    tvBasicAbstract.setVisibility(View.VISIBLE);
                    tvBasicDeadline.setVisibility(View.VISIBLE);
                    isSpreadBasic = true;
                }
            }
        });

        itemviewDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSpreadDes){
                    itemviewDes.setArrowImage(R.drawable.filter_down);
                    tvDes.setVisibility(View.GONE);
                    isSpreadDes = false;
                }else {
                    itemviewDes.setArrowImage(R.drawable.filter_up);
                    tvDes.setVisibility(View.VISIBLE);
                    isSpreadDes = true;
                }
            }
        });

        itemviewSwitchJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                final String[] str = {"开启", "关闭"};
                int checkeditem = activityItem.getaStatus()?0:1;
                //    设置一个单项选择下拉框
                /**
                 * 第一个参数指定我们要显示的一组下拉单选框的数据集合
                 * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'关闭' 会被勾选上
                 * 第三个参数给每一个单选项绑定一个监听器
                 */
                builder.setSingleChoiceItems(str, checkeditem, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        itemviewSwitchJoin.setRightText(str[which]);
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.show();
            }
        });
    }

    private void initData(){
        //获取上一个界面传过来的活动数据
        activityItem = (ActivityItem) getIntent().getSerializableExtra("activityitem");

        user = new User();

        childActivityItems = new ArrayList<>();
        getAllChildActivity();

        managerItems = new ArrayList<>();
        managerItems.add(new Manager("http://img2.imgtn.bdimg.com/it/u=2260937709,2065328859&fm=26&gp=0.jpg","一"));
        managerItems.add(new Manager("http://img0.imgtn.bdimg.com/it/u=1842273078,3771452716&fm=200&gp=0.jpg","二"));
        managerItems.add(new Manager("http://img0.imgtn.bdimg.com/it/u=1842273078,3771452716&fm=200&gp=0.jpg","三"));
        managerItems.add(new Manager("http://img0.imgtn.bdimg.com/it/u=1842273078,3771452716&fm=200&gp=0.jpg","四"));
        managerItems.add(new Manager("http://img0.imgtn.bdimg.com/it/u=1842273078,3771452716&fm=200&gp=0.jpg","五"));
        managerItems.add(new Manager("http://img0.imgtn.bdimg.com/it/u=1842273078,3771452716&fm=200&gp=0.jpg","六"));
    }

    /**
     * 从服务器端得到该大活动下的所有小活动的信息
     */
    private void getAllChildActivity() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("aId", activityItem.getaId()+"")
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/activity/getAllChildActivity")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d(TAG,"联网获取列表数据失败");
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                            JsonObject jsonObject = gson.fromJson(response.body().string(),JsonObject.class);
                            JsonArray jsonArray = jsonObject.getAsJsonArray("childActivityData");
                            for (JsonElement jsonElement:jsonArray){
                                childActivityItems.add(gson.fromJson(jsonElement,new TypeToken<ChildActivityItem>(){}.getType()));
                            }
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initViews(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        itemviewBasic.setRightText(activityItem.getaName());
        tvBasicName.setText("活动名称："+activityItem.getaName());
        tvBasicLocation.setText("活动地点："+activityItem.getaAddress());
        tvBasicAbstract.setText("活动摘要："+activityItem.getaAbstract());
        tvBasicDeadline.setText("活动截止日期："+dateFormat.format(activityItem.getaDeadlineTime()));
        tvDes.setText(activityItem.getaDescription());
        itemviewSwitchJoin.setRightText(activityItem.getaStatus()?"开启":"关闭");

        childActivityItemAdapter = new ChildActivityItemAdapter(childActivityItems);
        recyclerviewChildActivity.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewChildActivity.setAdapter(childActivityItemAdapter);
        childActivityItemAdapter.setOnDeleteClickListener(new ChildActivityItemAdapter.OnitemClick() {
            @Override
            public void onItemClick(int position) {
                childActivityItems.remove(position);
                childActivityItemAdapter.notifyDataSetChanged();
            }
        });
        childActivityItemAdapter.setOnSettingClickListener(new ChildActivityItemAdapter.onSettingClickListener() {
            @Override
            public void onSettingClick(int position) {
                showChildActivitySettingDialog(position);
            }
        });
        childActivityItemAdapter.setOnFooterClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChildActivitySettingDialog(-1);
            }
        });

        managerAdapter = new ManagerAdapter(managerItems);
        recyclerviewManager.setLayoutManager(new GridLayoutManager(this,4));
        recyclerviewManager.setAdapter(managerAdapter);

        managerAdapter.setOnitemClick(new ManagerAdapter.OnitemClick() {
            @Override
            public void onItemClick(int position) {
                if (managerItems.size()-1 == position){
                    addManager();
                }
            }
        });
    }

    /**
     * 弹出子活动属性设置框
     * @param position
     * -1表示直接添加到集合中，0-length表示更改容器中对应位置的值
     */
    private void showChildActivitySettingDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_child_activity, null);

        //设置Dialog界面初始状态
        EditTextPlus etpActivityName = (EditTextPlus) view.findViewById(R.id.etp_activity_name);
        EditTextPlus etpItemNotice = (EditTextPlus) view.findViewById(R.id.etp_item_notice);
        EditTextPlus etpItemScore = (EditTextPlus) view.findViewById(R.id.etp_item_score);
        EditTextPlus etpItemDaymaxjoin = (EditTextPlus) view.findViewById(R.id.etp_item_daymaxjoin);
        if (-1 != position){
            ChildActivityItem childActivityItem = childActivityItems.get(position);
            etpActivityName.setEditText(childActivityItem.getName());
            etpItemNotice.setEditText(childActivityItem.getNotice());
            etpItemScore.setEditText(childActivityItem.getScore()+"");
            etpItemDaymaxjoin.setEditText(childActivityItem.getDaymaxjoin()+"");
        }

        //    设置我们自己定义的布局文件作为弹出框的Content
        builder.setView(view);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String a = etpActivityName.getText();
                String b = etpItemNotice.getText();
                int c;
                int d;

                if(etpItemScore.getText()==null||etpItemScore.getText().equals("")){
                    c = 0;
                }else {
                    c = Integer.parseInt(etpItemScore.getText());
                }
                if (etpItemDaymaxjoin.getText()==null||etpItemDaymaxjoin.getText().equals("")){
                    d = 1;
                }else {
                    d = Integer.parseInt(etpItemDaymaxjoin.getText());
                }

                if (a==null||a.equals("")||b==null||b.equals("")){
                    return;
                }

                if (-1 == position){
                    childActivityItems.add(new ChildActivityItem(a,b,c,d));
                }else {
                    ChildActivityItem childActivityItem = childActivityItems.get(position);
                    childActivityItem.setName(a);
                    childActivityItem.setNotice(b);
                    childActivityItem.setScore(c);
                    childActivityItem.setDaymaxjoin(d);
                }
                childActivityItemAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        builder.show();
    }

    /**
     * 添加管理员
     */
    private void addManager() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //通过LayoutInflater来加载一个xml的布局文件作为一个View对象
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_manager, null);

        //设置Dialog界面初始状态
        RadioButton rbTime2 = (RadioButton) view.findViewById(R.id.rb_time2);
        RadioButton rbTime4 = (RadioButton) view.findViewById(R.id.rb_time4);
        RadioButton rbTime8 = (RadioButton) view.findViewById(R.id.rb_time8);
        RadioButton rbTime = (RadioButton) view.findViewById(R.id.rb_time);
        ImageView ivManagerQrcode = (ImageView) view.findViewById(R.id.iv_manager_qrcode);
        rbTime2.setChecked(true);
        ivManagerQrcode.setImageBitmap(CodeUtils.createImage( "addManager:aId="+ user.getUid() +"&deadline=2h",
                600, 600, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));

        //设置我们自己定义的布局文件作为弹出框的Content
        builder.setView(view);

        rbTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivManagerQrcode.setImageBitmap(CodeUtils.createImage( "addManager:aId="+ user.getUid() +"&deadline=2h",
                        600, 600, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));
            }
        });
        rbTime4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivManagerQrcode.setImageBitmap(CodeUtils.createImage( "addManager:aId="+ user.getUid() +"&deadline=4h",
                        600, 600, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));
            }
        });
        rbTime8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivManagerQrcode.setImageBitmap(CodeUtils.createImage( "addManager:aId="+ user.getUid() +"&deadline=8h",
                        600, 600, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));
            }
        });
        rbTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivManagerQrcode.setImageBitmap(CodeUtils.createImage( "addManager:aId="+ user.getUid() +"&deadline=-1",
                        600, 600, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)));
            }
        });

        builder.show();
    }
}
