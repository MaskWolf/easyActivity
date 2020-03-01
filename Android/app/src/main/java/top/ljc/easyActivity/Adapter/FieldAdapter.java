package top.ljc.easyActivity.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import top.ljc.easyActivity.Data.Field;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.EditTextPlus;

public class FieldAdapter extends RecyclerView.Adapter<FieldAdapter.ViewHolder>{

    private List<Field> fieldList;

    public FieldAdapter(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_signup, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Field field = fieldList.get(i);
        viewHolder.editTextPlus.setHeadText(field.getFieldName());
        viewHolder.editTextPlus.setHeadText(field.getFieldNotice());
    }

    @Override
    public int getItemCount() {
        return fieldList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private EditTextPlus editTextPlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextPlus = itemView.findViewById(R.id.etp_signup);
        }
    }

    //定义一个列表每个item点击事件的接口
    public interface OnitemClick {
        void onItemClick(int position);
    }
}
