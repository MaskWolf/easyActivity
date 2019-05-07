package top.ljc.easyActivity.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import top.ljc.easyActivity.R;

public class EditItemView extends LinearLayout {

    private TextView tvTitle;
    private EditText etContent;

    public EditItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.view_edititem,this);

        findViews();

        /*Drawable background = getBackground();
        if (null == background) {
            setBackgroundResource(R.drawable.drawable_default_edititemview);
        }*/

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.EditItemView);

        //设置左边的标题栏
        tvTitle.setText(ta.getString(R.styleable.EditItemView_head_text));
        //设置右边EditView的输入文本类型
        switch (ta.getInteger(R.styleable.EditItemView_edit_input_type, 0)) {
            case 0:
                etContent.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case 1:
                etContent.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            case 2:
                etContent.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            case 3:
                etContent.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            default:
                break;
        }
        //设置右边EditView的提示文字
        etContent.setHint(ta.getString(R.styleable.EditItemView_edit_hint_text));

        ta.recycle();
    }

    private void findViews() {
        tvTitle = (TextView)findViewById( R.id.tv_title );
        etContent = (EditText)findViewById( R.id.et_content );
    }
}
