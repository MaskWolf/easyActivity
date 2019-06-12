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

public class HomeActivityItemAdapter extends RecyclerView.Adapter<HomeActivityItemAdapter.ViewHolder> {

    private Context context;

    private List<ActivityItem> activityList;

    private HomeActivityItemAdapter.OnitemClick OnRecyclerItemClickListener;

    public void setOnRecyclerItemClickListener(OnitemClick onRecyclerItemClickListener) {
        OnRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public HomeActivityItemAdapter(List<ActivityItem> activityList) {
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (null == context){
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_activity, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ActivityItem activity = activityList.get(i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnRecyclerItemClickListener.onItemClick(i);
            }
        });
        viewHolder.activityTitle.setText(activity.getaName());
        viewHolder.activityDesc.setText(activity.getaAbstract());
        Glide.with(context).load(activity.getImage(0))
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
        View itemView;
        ImageView activityImage;
        TextView activityTitle;
        TextView activityDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            activityImage = (ImageView)itemView.findViewById(R.id.activity_image);
            activityTitle = (TextView)itemView.findViewById(R.id.activity_title);
            activityDesc = (TextView) itemView.findViewById(R.id.activity_desc);
        }
    }

    //定义一个点击事件的接口
    public interface OnitemClick {
        void onItemClick(int position);
    }
}
