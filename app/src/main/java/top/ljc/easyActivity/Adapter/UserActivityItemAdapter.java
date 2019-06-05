package top.ljc.easyActivity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.R;

public class UserActivityItemAdapter extends RecyclerView.Adapter<UserActivityItemAdapter.ViewHolder> {

    private Context context;

    private ArrayList<ActivityItem> arrayList;

    /**
     * 对外暴露点击事件的接口
     */
    private OnitemClick onitemClick;

    public void setOnitemClick(OnitemClick onitemClick) {
        this.onitemClick = onitemClick;
    }

    public UserActivityItemAdapter(ArrayList<ActivityItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (null == context){
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_activity, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ActivityItem activityItem = arrayList.get(i);
        viewHolder.activityName.setText(activityItem.getaName());
        viewHolder.activityMsg.setText("参与人数:"+ activityItem.getaParticipation() + ",赞数:" + activityItem.getPraiseCount());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemClick.onItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private View itemView;
        private TextView activityName;
        private TextView activityMsg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            activityName = (TextView) itemView.findViewById(R.id.activity_name);
            activityMsg = (TextView) itemView.findViewById(R.id.activity_msg);
        }
    }

    //定义一个点击事件的接口
    public interface OnitemClick {
        void onItemClick(int position);
    }
}
