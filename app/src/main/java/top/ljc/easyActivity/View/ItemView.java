package top.ljc.easyActivity.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import top.ljc.easyActivity.R;

public class ItemView extends LinearLayout {

    private final boolean isShowRightArrow;
    private RelativeLayout itemView;
    private TextView tvLeft;
    private TextView tvRight;
    private ImageView ivArrow;


    private void findViews() {
        itemView = (RelativeLayout)findViewById(R.id.itemview);
        tvLeft = (TextView)findViewById( R.id.tv_left );
        tvRight = (TextView)findViewById( R.id.tv_right );
        ivArrow = (ImageView)findViewById( R.id.iv_arrow );
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.view_item,this);
        findViews();
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemView);
        itemView.setBackground(ta.getDrawable(R.styleable.ItemView_background));
        ivArrow.setImageResource(ta.getResourceId(R.styleable.ItemView_right_arrow,R.drawable.arrow_right));  //设置右侧箭头图片资源
        isShowRightArrow = ta.getBoolean(R.styleable.ItemView_show_right_arrow, true);//得到是否显示右侧图标属性标识
        ivArrow.setVisibility(isShowRightArrow ? View.VISIBLE : View.INVISIBLE);//设置右侧箭头图标是否显示
        tvLeft.setText(ta.getString(R.styleable.ItemView_left_text));//设置左侧标题文字
        tvRight.setText(ta.getString(R.styleable.ItemView_right_text));//设置右侧文字描述
        ta.recycle();
    }

    /**
     * 设置右侧文本
     * @param string
     */
    public void setRightText(String string){
        tvRight.setText(string);
    }

    /**
     * 得到右侧文本
     * @return
     */
    public String getRightText(){
        return tvRight.getText().toString();
    }

    /**
     * 设置右侧图片的文件资源
     * @param resId
     */
    public void setArrowImage(@DrawableRes int resId){
        ivArrow.setImageResource(resId);
    }
}
