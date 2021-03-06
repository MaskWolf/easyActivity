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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import top.ljc.easyActivity.Activity.DetailsActivity;
import top.ljc.easyActivity.Adapter.HomeActivityItemAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.R;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private static final int UPDATE_ACTIVITYLIST = 1;

    private Context context;

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private TextView ivNoNetwork;

    private ArrayList<ActivityItem> activities;
    private HomeActivityItemAdapter activityAdapter;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_ACTIVITYLIST:
                    //网络不畅时显示提示文本
                    if (activities.size()<=0){
                        ivNoNetwork.setVisibility(View.VISIBLE);
                    }else {
                        ivNoNetwork.setVisibility(View.GONE);
                    }
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
        ivNoNetwork = (TextView)view.findViewById(R.id.tv_no_network);
    }

    private void initViews(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(activityAdapter);

        activityAdapter.setOnRecyclerItemClickListener(new HomeActivityItemAdapter.OnitemClick() {
            @Override
            public void onItemClick(int position) {
                //打开活动详情界面
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("activityitem",activities.get(position));
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
        ActivityItem activityItem = new ActivityItem();

        swipeRefreshLayout.setRefreshing(true);
        getAllActivities();
        activityAdapter = new HomeActivityItemAdapter(activities);
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
     * 使用JSONObject解析服务器端返回的所有活动的json数据并添加到ArrayList集合中
     * @param jsonData
     */
    private void parseJSONWithJSONObject(String jsonData){
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("activityData");
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObjectItem = jsonArray.getJSONObject(i);
                ActivityItem activityItem = new ActivityItem();
                activityItem.setaId(jsonObjectItem.getInt("aId"));
                activityItem.setpId(jsonObjectItem.getInt("pId"));
                activityItem.setPraiseCount(jsonObjectItem.getInt("praiseCount"));
                activityItem.setaName(jsonObjectItem.getString("aName"));
                activityItem.setaCreationTime(dateFormat.parse(jsonObjectItem.getString("aCreationTime")));
                activityItem.setaDeadlineTime(dateFormat.parse(jsonObjectItem.getString("aDeadlineTime")));
                activityItem.setaParticipation(jsonObjectItem.getInt("aParticipation"));
                activityItem.setaAbstract(jsonObjectItem.getString("aAbstract"));
                activityItem.setaDescription(jsonObjectItem.getString("aDescription"));
                activityItem.setaStatus(jsonObjectItem.getBoolean("aStatus"));
                activityItem.setaNotice(jsonObjectItem.getString("aNotice"));
                activityItem.setaAddress(jsonObjectItem.getString("aAddress"));

                JSONArray images = jsonObjectItem.getJSONArray("images");
                for (int j=0;j<images.length();j++){
                    activityItem.addImage(images.getString(j));
                }

                activities.add(activityItem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
