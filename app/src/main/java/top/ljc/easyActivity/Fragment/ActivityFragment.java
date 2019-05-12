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

import java.util.ArrayList;

import top.ljc.easyActivity.Adapter.ActivityListAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.R;

public class ActivityFragment extends Fragment {
    private static final int UPDATE_ACTIVITYLIST = 1;
    private Context context;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ArrayList<ActivityItem> activities;
    private ActivityListAdapter activityAdapter;
    private TextView participatedActivity;
    private TextView managingActivity;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_ACTIVITYLIST:
                    refreshActivityData();
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
            }
        });
        managingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                participatedActivity.setBackgroundColor(getResources().getColor(R.color.WhiteSmoke));
                managingActivity.setBackgroundColor(getResources().getColor(R.color.smssdk_white));
            }
        });
    }

    /**
     * 刷新活动列表数据
     */
    private void refreshActivityData() {
        activities.clear();
        activities.add(new ActivityItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1555952443076&di=28ca061d05d6f67d64ed57de35b3279a&imgtype=0&src=http%3A%2F%2Fnews.mydrivers.com%2FImg%2F20120217%2F2012021709492293.jpg","新图灵运动挑战赛","计算机科学与技术学院主办“三走”系列活动"));

        activityAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void initData(){
        activities = new ArrayList<>();
        activities.add(new ActivityItem("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1555952443076&di=28ca061d05d6f67d64ed57de35b3279a&imgtype=0&src=http%3A%2F%2Fnews.mydrivers.com%2FImg%2F20120217%2F2012021709492293.jpg","图灵运动挑战赛","计算机科学与技术学院主办“三走”系列活动"));
        activityAdapter = new ActivityListAdapter(activities);
    }

    public void initViews(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(activityAdapter);
    }
}
