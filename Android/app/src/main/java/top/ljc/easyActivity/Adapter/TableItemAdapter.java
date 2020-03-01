package top.ljc.easyActivity.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;

import top.ljc.easyActivity.Data.TableItem;
import top.ljc.easyActivity.R;

public class TableItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //item类型是底部item
    public static final int TYPE_FOOTER_VIEW = 1;

    private ArrayList<TableItem> arrayList;

    //对外暴露删除、设置、底部item点击事件
    OnitemClick onDeleteClickListener;
    onSettingClickListener onSettingClickListener;
    View.OnClickListener onFooterClickListener;

    public void setOnDeleteClickListener(OnitemClick onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public void setOnSettingClickListener(TableItemAdapter.onSettingClickListener onSettingClickListener) {
        this.onSettingClickListener = onSettingClickListener;
    }

    public void setOnFooterClickListener(View.OnClickListener onFooterClickListener) {
        this.onFooterClickListener = onFooterClickListener;
    }

    public TableItemAdapter(ArrayList<TableItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType ) {
        if (viewType == TYPE_FOOTER_VIEW){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_footer,viewGroup, false);
            FooterViewHolder footerViewHolder = new FooterViewHolder(view,onFooterClickListener);
            return footerViewHolder;
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tableitem, viewGroup,false);
        ContentViewHolder contentViewHolder = new ContentViewHolder(view);
        return contentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder instanceof ContentViewHolder){
            ContentViewHolder contentViewHolder = (ContentViewHolder)viewHolder;
            TableItem tableItem = arrayList.get(position);
            contentViewHolder.tvData.setText(tableItem.getData());
            contentViewHolder.tvExample.setText(tableItem.getExample());
            contentViewHolder.btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDeleteClickListener.onItemClick(position);
                }
            });
            contentViewHolder.ivSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSettingClickListener.onSettingClick(position);
                }
            });
            //设置展示模式
            contentViewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
            //添加监听器
            contentViewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
                @Override
                public void onClose(SwipeLayout layout) {
                    //when the SurfaceView totally cover the BottomView.
                }

                @Override
                public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                    //you are swiping.
                }

                @Override
                public void onStartOpen(SwipeLayout layout) {

                }

                @Override
                public void onOpen(SwipeLayout layout) {
                    //when the BottomView totally show.
                    YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
                }

                @Override
                public void onStartClose(SwipeLayout layout) {

                }

                @Override
                public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                    //when user's hand released.
                }
            });
        }else{

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        //当position是最后一个的时候，也就是比list的数量多一个的时候，则表示FooterView
        if (position + 1 == arrayList.size() + 1) {
            return TYPE_FOOTER_VIEW;
        }
        return super.getItemViewType(position);
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder{

        SwipeLayout swipeLayout;
        Button btDelete;
        TextView tvData;
        TextView tvExample;
        ImageView ivSetting;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            swipeLayout = (SwipeLayout)itemView.findViewById(R.id.swipe);
            btDelete = (Button)itemView.findViewById( R.id.bt_delete );
            tvData = (TextView)itemView.findViewById( R.id.tv_data );
            tvExample = (TextView)itemView.findViewById( R.id.tv_example );
            ivSetting = (ImageView)itemView.findViewById( R.id.iv_setting );
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder{
        LinearLayout footer;
        View.OnClickListener onFooterClickListener;

        public FooterViewHolder(@NonNull View itemView, View.OnClickListener onFooterClickListener) {
            super(itemView);
            this.onFooterClickListener = onFooterClickListener;
            footer = (LinearLayout)itemView.findViewById(R.id.footer_recylerview);

            footer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFooterClickListener.onClick(v);
                }
            });
        }
    }

    //定义一个列表每个item点击事件的接口
    public interface OnitemClick {
        void onItemClick(int position);
    }

    //定义一个列表每个设置被点击的接口
    public interface onSettingClickListener {
        void onSettingClick(int position);
    }
}
