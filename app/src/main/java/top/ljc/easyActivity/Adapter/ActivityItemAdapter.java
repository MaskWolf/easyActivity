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
import top.ljc.easyActivity.R;

public class ActivityItemAdapter extends RecyclerView.Adapter<ActivityItemAdapter.ViewHolder> {

    private Context context;

    private List<ActivityItem> activityList;

    private View.OnClickListener OnRecyclerItemClickListener;

    public void setOnRecyclerItemClickListener(View.OnClickListener onRecyclerItemClickListener) {
        OnRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public ActivityItemAdapter(List<ActivityItem> activityList) {
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (null == context){
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_activity, viewGroup,false);
        ViewHolder holder = new ViewHolder(view, OnRecyclerItemClickListener);
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


    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView activityImage;
        TextView activityTitle;
        TextView activityDesc;
        View.OnClickListener OnRecyclerItemClickListener;

        public ViewHolder(@NonNull View itemView, View.OnClickListener onItemClickListener) {
            super(itemView);
            this.OnRecyclerItemClickListener = onItemClickListener;
            activityImage = (ImageView)itemView.findViewById(R.id.activity_image);
            activityTitle = (TextView)itemView.findViewById(R.id.activity_title);
            activityDesc = (TextView) itemView.findViewById(R.id.activity_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(v);
                }
            });
        }
    }
}
