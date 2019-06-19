package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Adapter.FieldAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.Data.ChildActivityItem;
import top.ljc.easyActivity.Data.Field;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.ItemView;
import top.ljc.easyActivity.View.mToolbar;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class SignupActivity extends AppCompatActivity {

    private Context context;
    private static final String TAG = "SignupActivity";

    private mToolbar toolbarSignup;
    private RecyclerView recyclerviewSignup;
    private ItemView itemView;

    private final static int UPDATE_LIST = 1;
    private ActivityItem activityItem;
    private List<Field> fieldList;
    private ArrayList<ChildActivityItem> childActivityItems;

    private FieldAdapter fieldAdapter;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_LIST:
                    fieldAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_signup);

        initData();

        findViews();

        initView();
    }

    private void initData() {
        activityItem = (ActivityItem) getIntent().getSerializableExtra("activityitem");
        fieldList = new ArrayList<>();
        getFieldList();
        childActivityItems = new ArrayList<>();
        getAllChildActivity();
    }

    private void findViews() {
        toolbarSignup = (mToolbar) findViewById(R.id.toolbar_signup);
        recyclerviewSignup = (RecyclerView) findViewById(R.id.recyclerview_signup);
        itemView = (ItemView) findViewById(R.id.itemview_child);

        toolbarSignup.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbarSignup.setOnClickRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"报名成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popDialog();
            }
        });
    }

    private void initView() {
        fieldAdapter = new FieldAdapter(fieldList);
        recyclerviewSignup.setLayoutManager(new LinearLayoutManager(context));
        recyclerviewSignup.setAdapter(fieldAdapter);
    }

    /**
     * 从服务器获取报名字段信息
     */
    private void getFieldList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .connectTimeout(1, TimeUnit.SECONDS);
                    OkHttpClient okHttpClient = builder.build();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("aId", activityItem.getaId()+"")
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/manager/getActivityFields")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Gson gson = new Gson();
                            JsonObject jsonObject = gson.fromJson(response.body().string(),JsonObject.class);
                            JsonArray jsonArray = jsonObject.getAsJsonArray("fields");
                            for (JsonElement jsonElement:jsonArray){
                                fieldList.add(gson.fromJson(jsonElement,Field.class));
                            }
                            handler.sendEmptyMessage(UPDATE_LIST);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
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

    private void popDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("选择一个活动项目");
        //    指定下拉列表的显示数据
        String[] cities = new String[childActivityItems.size()];
        for (int i=0;i<childActivityItems.size();i++){
            cities[i] = childActivityItems.get(i).getName();
        }

        //    设置一个下拉的列表选择项
        builder.setItems(cities, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "选择的活动是：" + cities[which], Toast.LENGTH_SHORT).show();
                itemView.setRightText(cities[which]);
            }
        });
        builder.show();
    }
}
