package top.ljc.easyActivity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.Interface.OnRecyclerItemClickListener;
import top.ljc.easyActivity.R;

public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.ViewHolder> {

    private Context context;

    private List<ActivityItem> activityList;

    private OnRecyclerItemClickListener onItemClickListener;

    public ActivityListAdapter(List<ActivityItem> activityList) {
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (null == context){
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_activity, viewGroup,false);
        ViewHolder holder = new ViewHolder(view, onItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ActivityItem activity = activityList.get(i);
        viewHolder.activityTitle.setText(activity.getTitle());
        viewHolder.activityDesc.setText(activity.getDesc());
        Glide.with(context).load(activity.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.image_activity_default)
                .error(R.drawable.image_activity_default)
                .into(viewHolder.activityImage);
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView activityImage;
        TextView activityTitle;
        TextView activityDesc;
        OnRecyclerItemClickListener onItemClickListener;// 声明自定义的接口

        public ViewHolder(@NonNull View itemView, OnRecyclerItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
            activityImage = (ImageView)itemView.findViewById(R.id.activity_image);
            activityTitle = (TextView)itemView.findViewById(R.id.activity_title);
            activityDesc = (TextView) itemView.findViewById(R.id.activity_desc);
        }

        @SuppressWarnings({"deprecation"})
        @Override
        public void onClick(View v) {
            if (onItemClickListener!=null){
                onItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
}
