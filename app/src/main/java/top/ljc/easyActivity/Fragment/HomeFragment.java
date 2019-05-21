package top.ljc.easyActivity.Fragment;

import android.content.Context;
import android.content.Intent;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import top.ljc.easyActivity.Activity.DetailsActivity;
import top.ljc.easyActivity.Adapter.ActivityItemAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.R;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class HomeFragment extends Fragment {

    private static final int UPDATE_ACTIVITYLIST = 1;
    private Context context;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ArrayList<ActivityItem> activities;
    private ActivityItemAdapter activityAdapter;

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

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        findViews(view);

        initData();

        initViews();

        return view;
    }

    private void findViews(View view){
        recyclerView = (RecyclerView)view.findViewById(R.id.home_recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.home_swiperefreshlayout);
    }

    private void initViews(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(activityAdapter);

        activityAdapter.setOnRecyclerItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                startActivity(intent);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                activities.clear();
                getAllActivities();
                handler.sendEmptyMessageDelayed(UPDATE_ACTIVITYLIST,1000);
            }
        });
    }

    private void initData(){
        activities = new ArrayList<>();

        swipeRefreshLayout.setRefreshing(true);
        getAllActivities();
        activityAdapter = new ActivityItemAdapter(activities);
        handler.sendEmptyMessageDelayed(UPDATE_ACTIVITYLIST,1000);

    }

    /**
     * 向服务器端请求所有活动的json数据
     */
    private void getAllActivities() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                try{
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS + "/activity/getAllActivity")
                            .build();
                    Response response = okHttpClient.newCall(request).execute();
                    String jsonData = response.body().string();
                    parseJSONWithJSONObject(jsonData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 解析服务器端返回的所有活动的json数据并添加到ArrayList集合中
     * @param jsonData
     */
    private void parseJSONWithJSONObject(String jsonData){
        try{
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("activityData");
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
    }
}
