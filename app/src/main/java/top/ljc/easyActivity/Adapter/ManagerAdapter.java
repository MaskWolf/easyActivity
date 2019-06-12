package top.ljc.easyActivity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import top.ljc.easyActivity.Data.Manager;
import top.ljc.easyActivity.R;

public class ManagerAdapter extends RecyclerView.Adapter<ManagerAdapter.ViewHolder>{

    private Context context;
    /**
     * 管理员的数据
     */
    private List<Manager> list;
    /**
     * 对外暴露点击、删除事件的接口
     */
    private OnitemClick onitemClick;
    private OnitemClick onDeleteClickListener;

    public void setOnitemClick(OnitemClick onitemClick) {
        this.onitemClick = onitemClick;
    }

    public void setOnDeleteClickListener(OnitemClick onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public ManagerAdapter(List<Manager> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ManagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (null == context){
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_manager, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Manager manager = list.get(i);
        viewHolder.swipelayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.swipelayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });

        viewHolder.trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteClickListener.onItemClick(i);
            }
        });

        viewHolder.llTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemClick.onItemClick(i);
            }
        });

        viewHolder.remarknameManager.setText(manager.getRemarkName());

        //加载圆形头像
        Glide.with(context).load(R.drawable.avatar_default)
                .bitmapTransform(new CropCircleTransformation(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.avatar_default)
                .error(R.drawable.avatar_default)
                .into(viewHolder.avatarManager);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        SwipeLayout swipelayout;
        LinearLayout llTop;
        ImageView trash;
        ImageView avatarManager;
        TextView remarknameManager;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            swipelayout = (SwipeLayout) itemView.findViewById(R.id.swipelayout);
            trash = (ImageView) itemView.findViewById(R.id.trash);
            avatarManager = (ImageView) itemView.findViewById(R.id.avatar_manager);
            remarknameManager = (TextView) itemView.findViewById(R.id.remarkname_manager);
            llTop = (LinearLayout) itemView.findViewById(R.id.ll_top);
        }
    }

    //定义一个点击事件的接口
    public interface OnitemClick {
        void onItemClick(int position);
    }
}
