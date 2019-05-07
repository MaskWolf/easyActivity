package top.ljc.easyActivity.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import top.ljc.easyActivity.R;

public class ItemView extends LinearLayout {

    private final boolean isShowRightArrow;
    private TextView tvLeft;
    private TextView tvRight;
    private ImageView ivArrow;


    private void findViews() {
        tvLeft = (TextView)findViewById( R.id.tv_left );
        tvRight = (TextView)findViewById( R.id.tv_right );
        ivArrow = (ImageView)findViewById( R.id.iv_arrow );
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.view_item,this);
        findViews();
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemView);

        isShowRightArrow = ta.getBoolean(R.styleable.ItemView_show_right_arrow, true);//得到是否显示右侧图标属性标识
        ivArrow.setVisibility(isShowRightArrow ? View.VISIBLE : View.INVISIBLE);//设置右侧箭头图标是否显示
        tvLeft.setText(ta.getString(R.styleable.ItemView_left_text));//设置左侧标题文字
        tvRight.setText(ta.getString(R.styleable.ItemView_right_text));//设置右侧文字描述
        ta.recycle();
    }

    public void setRightText(String string){
        tvRight.setText(string);
    }
}
