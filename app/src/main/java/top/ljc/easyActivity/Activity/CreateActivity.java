package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Adapter.ChildActivityItemAdapter;
import top.ljc.easyActivity.Adapter.TableItemAdapter;
import top.ljc.easyActivity.Data.ChildActivityItem;
import top.ljc.easyActivity.Data.TableItem;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.EditTextPlus;
import top.ljc.easyActivity.View.mToolbar;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class CreateActivity extends AppCompatActivity {
    private Context context;
    private static final String TAG = "CreateActivity";

    private mToolbar mToolbar;
    private EditTextPlus etpName;
    private EditTextPlus etpLocation;
    private EditTextPlus etpAbstract;
    private TextView tvDeadline;
    private EditText etDescription;
    private TimePickerView pvTime;

    private RecyclerView rvChildActivity;
    private ArrayList<ChildActivityItem> childActivityItems;
    private ChildActivityItemAdapter childActivityItemAdapter;

    private RecyclerView rvTable;
    private ArrayList<TableItem> tableItems;
    private TableItemAdapter tableItemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_create);

        findViews();

        initData();

        initViews();
    }

    private void findViews() {
        mToolbar = (mToolbar) findViewById(R.id.toolbar_create);
        etpName = (EditTextPlus) findViewById(R.id.etp_name);
        etpLocation = (EditTextPlus) findViewById(R.id.etp_location);
        etpAbstract = (EditTextPlus) findViewById(R.id.etp_abstract);
        tvDeadline = (TextView) findViewById(R.id.tv_deadline);
        etDescription = (EditText) findViewById(R.id.et_description);
        rvChildActivity = (RecyclerView) findViewById(R.id.rv_child_activity);
        rvTable = (RecyclerView) findViewById(R.id.rv_table);

        //时间选择器
        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date,View v) {//选中事件回调
                tvDeadline.setTextColor(getResources().getColor(R.color.smssdk_black));
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                tvDeadline.setText(dateFormat.format(date));
            }
        }).build();

        //设置标题栏点击事件
        mToolbar.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setOnClickRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addActivity();
            }

        });

        //设置截止日期文本框点击事件
        tvDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show();
            }
        });
    }

    private void initData() {
        childActivityItems = new ArrayList<>();
        childActivityItems.add(new ChildActivityItem("活动项目一","活动项目一的描述"));

        tableItems = new ArrayList<>();
        tableItems.add(new TableItem("邮箱","example@example.com"));
    }

    private void initViews() {
        childActivityItemAdapter = new ChildActivityItemAdapter(childActivityItems);
        rvChildActivity.setLayoutManager(new LinearLayoutManager(this));
        rvChildActivity.setAdapter(childActivityItemAdapter);
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

        tableItemAdapter = new TableItemAdapter(tableItems);
        rvTable.setLayoutManager(new LinearLayoutManager(this));
        rvTable.setAdapter(tableItemAdapter);
        tableItemAdapter.setOnDeleteClickListener(new TableItemAdapter.OnitemClick() {
            @Override
            public void onItemClick(int position) {
                tableItems.remove(position);
                tableItemAdapter.notifyDataSetChanged();
            }
        });
        tableItemAdapter.setOnSettingClickListener(new TableItemAdapter.onSettingClickListener() {
            @Override
            public void onSettingClick(int position) {
                showTableSettingDialog(position);
            }
        });
        tableItemAdapter.setOnFooterClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoiceDialog();
            }
        });
    }

    /**
     * 弹出一个报名项目的单选列表框
     */
    private void showSingleChoiceDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("选择一个报名项");
        //    指定下拉列表的显示数据
        final String[] list = {"姓名", "学号","QQ", "邮箱", "手机号", "自定义"};
        final String[] listDes = {"请输入姓名", "请输入学号","330****766", "example@example.com", "136****1006", "自定义"};
        //    设置一个下拉的列表选择项
        builder.setItems(list, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                if (which == list.length-1){
                    showTableSettingDialog(-1);
                    return;
                }
                tableItems.add(new TableItem(list[which],listDes[which]));
                tableItemAdapter.notifyDataSetChanged();
            }
        });
        builder.show();
    }

    /**
     * 弹出报名项设置框
     * @param position
     * -1表示直接添加到集合中，0-length表示更改容器中对应位置的值
     */
    private void showTableSettingDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_table, null);

        //设置Dialog界面初始状态
        EditTextPlus name = (EditTextPlus)view.findViewById(R.id.etp_item_name);
        EditTextPlus hint = (EditTextPlus)view.findViewById(R.id.etp_item_hint);
        if (-1 != position){
            TableItem tableItem = tableItems.get(position);
            name.setEditText(tableItem.getData());
            hint.setEditText(tableItem.getExample());
        }

        //    设置我们自己定义的布局文件作为弹出框的Content
        builder.setView(view);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String a = name.getText().toString().trim();
                String b = hint.getText().toString().trim();
                if (a==null||a.equals("")||b==null||b.equals("")){
                    return;
                }
                if (-1 == position){
                    tableItems.add(new TableItem(a,b));
                }else {
                    TableItem tableItem = tableItems.get(position);
                    tableItem.setData(a);
                    tableItem.setExample(b);
                }
                tableItemAdapter.notifyDataSetChanged();
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

    private void addActivity() {
        String aName = etpName.getText();
        if (aName==null||aName.equals("")){
            Toast.makeText(context,"请输入活动名称",Toast.LENGTH_SHORT).show();
            return;
        }
        String aLocation = etpLocation.getText();
        if (aLocation==null||aLocation.equals("")){
            Toast.makeText(context,"请输入活动举办位置",Toast.LENGTH_SHORT).show();
            return;
        }
        String aAbstract = etpAbstract.getText();
        if (aAbstract==null||aAbstract.equals("")){
            Toast.makeText(context,"请输入对活动一句话简介",Toast.LENGTH_SHORT).show();
            return;
        }
        String aDeadline = tvDeadline.getText().toString();
        if (aDeadline.equals("请选择活动截止日期")){
            Toast.makeText(context,"请选择活动截止日期",Toast.LENGTH_SHORT).show();
            return;
        }
        String aDescription = etDescription.getText().toString();
        if (aDescription==null||aDescription.equals("")){
            Toast.makeText(context,"请输入对活动的详细描述",Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                String json = "";
                //使用Gson与JsonObject生成提交的json数据
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                try {
                    JSONObject jsonObject = new JSONObject();

                    JSONObject activityJsonObject = new JSONObject();
                    activityJsonObject.put("uId",user.getUid());
                    activityJsonObject.put("aName",aName);
                    activityJsonObject.put("aAddress",aLocation);
                    activityJsonObject.put("aAbstract",aAbstract);
                    activityJsonObject.put("aDeadlineTime",aDeadline);
                    activityJsonObject.put("aDescription",aDescription);
                    jsonObject.put("activity",activityJsonObject);

                    jsonObject.put("fieldList",new JSONArray(gson.toJson(tableItems)));

                    jsonObject.put("childActivityList",new JSONArray(gson.toJson(childActivityItems)));

                    json = jsonObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d(TAG,json);

                //MediaType  设置Content-Type 标头中包含的媒体类型值
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                Request request = new Request.Builder()
                        .url(SERVER_ADDRESS+"/activity/createActivity")
                        .post(RequestBody.create(mediaType, json))
                        .build();
                OkHttpClient okHttpClient = new OkHttpClient();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d(TAG, "onFailure: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d(TAG, "onResponse: " + response.body().string());
                    }
                });
            }
        }).start();
    }
}
