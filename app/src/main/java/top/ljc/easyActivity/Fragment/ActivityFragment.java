package top.ljc.easyActivity.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import top.ljc.easyActivity.Adapter.ActivityItemAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.R;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class ActivityFragment extends Fragment {
    private static final int UPDATE_ACTIVITYLIST = 1;
    private Context context;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ArrayList<ActivityItem> activities;
    private ActivityItemAdapter activityAdapter;
    private TextView participatedActivity;
    private TextView managingActivity;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_ACTIVITYLIST:
                    activityAdapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();

        View view = inflater.inflate(R.layout.fragmet_activity,container,false);

        findViews(view);

        initData();

        initViews();

        return view;
    }

    private void findViews(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_activity);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swiperefreshlayout_activity);
        participatedActivity = (TextView)view.findViewById(R.id.activity_participated);
        managingActivity = (TextView)view.findViewById(R.id.activity_managing);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(UPDATE_ACTIVITYLIST,1000);
            }
        });
        participatedActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                participatedActivity.setBackgroundColor(getResources().getColor(R.color.smssdk_white));
                managingActivity.setBackgroundColor(getResources().getColor(R.color.WhiteSmoke));
                activities.clear();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient okHttpClient = new OkHttpClient();
                        try{
                            Request request = new Request.Builder()
                                    .url(SERVER_ADDRESS + "/activity/participation?uName=zhangsan")
                                    .build();
                            Response response = okHttpClient.newCall(request).execute();
                            String jsonData = response.body().string();
                            try{
                                JSONObject jsonObject = new JSONObject(jsonData);
                                JSONArray jsonArray = jsonObject.getJSONArray("participationData");
                                for (int i=0;i<jsonArray.length();i++){
                                    JSONObject jsonObjectItem = (JSONObject) jsonArray.get(i);
                                    ActivityItem activityItem = new ActivityItem();
                                    activityItem.setTitle(jsonObjectItem.getString("aName"));
                                    activityItem.setImageUrl(jsonObjectItem.getString("aPicturePath"));
                                    activityItem.setDesc(jsonObjectItem.getString("aAbstract"));
                                    activities.add(activityItem);
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
                swipeRefreshLayout.setRefreshing(true);
                handler.sendEmptyMessageDelayed(UPDATE_ACTIVITYLIST,1000);
            }
        });
        managingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                participatedActivity.setBackgroundColor(getResources().getColor(R.color.WhiteSmoke));
                managingActivity.setBackgroundColor(getResources().getColor(R.color.smssdk_white));
                activities.clear();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient okHttpClient = new OkHttpClient();
                        try{
                            Request request = new Request.Builder()
                                    .url(SERVER_ADDRESS + "/activity/manage?uName=zhangsan")
                                    .build();
                            Response response = okHttpClient.newCall(request).execute();
                            String jsonData = response.body().string();
                            try{
                                JSONObject jsonObject = new JSONObject(jsonData);
                                JSONArray jsonArray = jsonObject.getJSONArray("manageData");
                                for (int i=0;i<jsonArray.length();i++){
                                    JSONObject jsonObjectItem = (JSONObject) jsonArray.get(i);
                                    ActivityItem activityItem = new ActivityItem();
                                    activityItem.setTitle(jsonObjectItem.getString("aName"));
                                    activityItem.setImageUrl(jsonObjectItem.getString("aPicturePath"));
                                    activityItem.setDesc(jsonObjectItem.getString("aAbstract"));
                                    activities.add(activityItem);
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
                swipeRefreshLayout.setRefreshing(true);
                handler.sendEmptyMessageDelayed(UPDATE_ACTIVITYLIST,1000);
            }
        });
    }

    public void initData(){
        activities = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                try{
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS + "/activity/participation?uName=zhangsan")
                            .build();
                    Response response = okHttpClient.newCall(request).execute();
                    String jsonData = response.body().string();
                    try{
                        JSONObject jsonObject = new JSONObject(jsonData);
                        JSONArray jsonArray = jsonObject.getJSONArray("participationData");
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObjectItem = (JSONObject) jsonArray.get(i);
                            ActivityItem activityItem = new ActivityItem();
                            activityItem.setTitle(jsonObjectItem.getString("aName"));
                            activityItem.setImageUrl(jsonObjectItem.getString("aPicturePath"));
                            activityItem.setDesc(jsonObjectItem.getString("aAbstract"));
                            activities.add(activityItem);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        activityAdapter = new ActivityItemAdapter(activities);
        swipeRefreshLayout.setRefreshing(true);
        handler.sendEmptyMessageDelayed(UPDATE_ACTIVITYLIST,1000);
    }

    public void initViews(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(activityAdapter);
    }
}
