package top.ljc.easyActivity.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import top.ljc.easyActivity.R;

public class mToolbar extends LinearLayout {

    private ImageView ivBack;
    private TextView tvTitle;
    private TextView tvRight;
    private Boolean isShowRightText;
    private OnClickListener onClickBackListener;
    private OnClickListener onClickRightListener;

    private void findViews() {
        ivBack = (ImageView)findViewById( R.id.iv_back );
        tvTitle = (TextView)findViewById( R.id.tv_title );
        tvRight = (TextView)findViewById(R.id.tv_right);
    }

    public mToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.view_mtoolbar,this);
        findViews();
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.mToolbar);
        //设置标题文字
        tvTitle.setText(ta.getString(R.styleable.mToolbar_title));
        //设置是否展示右侧文字
        isShowRightText = ta.getBoolean(R.styleable.mToolbar_show_right,false);
        if (isShowRightText){
            tvRight.setVisibility(View.VISIBLE);
            //设置右侧文字
            tvRight.setText(ta.getString(R.styleable.mToolbar_right));
        }else {
            tvRight.setVisibility(View.GONE);
        }

        ta.recycle();

        ivBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBackListener.onClick(v);
            }
        });

        tvRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRightListener.onClick(v);
            }
        });
    }

    /**
     * 设置右侧文字的点击事件的监听并对外暴露
     * @param onClickRightListener
     */
    public void setOnClickRightListener(OnClickListener onClickRightListener) {
        this.onClickRightListener = onClickRightListener;
    }

    /**
     * 设置返回按钮点击事件的监听并对外暴露
     * @param onClickBackListener
     */
    public void setOnClickBackListener(OnClickListener onClickBackListener) {
        this.onClickBackListener = onClickBackListener;
    }

    /**
     * 设置显示的标题栏文字
     * @param title
     */
    public void setTitle(String title) {
        tvTitle.setText(title);
    }
}
