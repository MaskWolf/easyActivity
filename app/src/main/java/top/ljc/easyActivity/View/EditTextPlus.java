package top.ljc.easyActivity.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import top.ljc.easyActivity.R;

public class EditTextPlus extends FrameLayout {
    private Context mContext;
    private TextView tvHead;
    private EditText etInput;
    private ImageView ivDelete;

    private float mHeadTextSize = 13;
    private int mHeadTextColor;
    private String mHeadText;

    private float mEditTextSize = 13;
    private int mEditTextColor;
    private String mEditHintText;

    private int mInputType = 0;
    private int mEditorOption = 0;
    private OnDeleteListener onDeleteListener;
    private OnInputTextListener onInputTextListener;
    private OnEditorOptActionListener onEditorOptActionListener;

    private boolean mHasDeleteAnimator = true;


    public void setmHasDeleteAnimator(boolean mHasDeleteAnimator) {
        this.mHasDeleteAnimator = mHasDeleteAnimator;
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }

    public void setOnInputTextListener(OnInputTextListener onInputTextListener) {
        this.onInputTextListener = onInputTextListener;
    }


    public void setOnEditorOptActionListener(OnEditorOptActionListener onEditorOptActionListener) {
        this.onEditorOptActionListener = onEditorOptActionListener;
    }

    public EditTextPlus(Context context) {
        this(context, null);
    }

    public EditTextPlus(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditTextPlus(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_edittext_plus, this);
        this.mContext = context;
        initAttr(attrs);
        initView();
    }

    private void initView() {
        tvHead = this.findViewById(R.id.tv_head);
        etInput = this.findViewById(R.id.et_input);
        ivDelete = this.findViewById(R.id.iv_delete);
        //
        tvHead.setText(mHeadText);
        tvHead.setTextColor(mHeadTextColor);
        tvHead.setTextSize(TypedValue.COMPLEX_UNIT_PX, mHeadTextSize);

        etInput.setHint(mEditHintText);
        etInput.setTextColor(mEditTextColor);
        etInput.setTextSize(TypedValue.COMPLEX_UNIT_PX, mEditTextSize);
        switch (mInputType) {
            case 0:
                etInput.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case 1:
                etInput.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            case 2:
                etInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            case 3:
                etInput.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            default:
                break;
        }
        switch (mEditorOption) {
            case 0:
                etInput.setImeOptions(EditorInfo.IME_ACTION_NONE);
                break;
            case 1:
                etInput.setImeOptions(EditorInfo.IME_ACTION_DONE);
                break;
            case 2:
                etInput.setImeOptions(EditorInfo.IME_ACTION_GO);
                break;
            case 3:
                etInput.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                break;
            case 4:
                etInput.setImeOptions(EditorInfo.IME_ACTION_PREVIOUS);
                break;
            case 5:
                etInput.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
                break;
            case 6:
                etInput.setImeOptions(EditorInfo.IME_ACTION_SEND);
                break;
            case 7:
                etInput.setImeOptions(EditorInfo.IME_ACTION_UNSPECIFIED);
                break;
            default:
                break;
        }

        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (null != onInputTextListener) {
                    onInputTextListener.onTextChanged(charSequence.toString(), start, before, count);
                }

                if (0 < charSequence.length()) {
                    ivDelete.setVisibility(VISIBLE);
                } else {
                    ivDelete.setVisibility(GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (null != onInputTextListener) {
                    onInputTextListener.afterTextChanged(editable.toString());
                }
            }
        });

        etInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (null != onEditorOptActionListener) {
                    onEditorOptActionListener.onEditorAction(textView, actionId, keyEvent);
                }
                return false;
            }
        });

        etInput.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    //得到焦点
                    ivDelete.setVisibility(VISIBLE);
                }else{
                    //失去焦点
                    ivDelete.setVisibility(GONE);
                }
            }
        });

        //
        ivDelete.setVisibility(GONE);
        ivDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                etInput.setText("");
                if (mHasDeleteAnimator) {
                    EditTextPlus.this.animate().translationX(5).setInterpolator(new CycleInterpolator(3)).setDuration(500).start();
                }
                if (null != onDeleteListener) {
                    onDeleteListener.onDelete();
                }
            }
        });
    }

    private void initAttr(AttributeSet attrs) {
        Drawable background = getBackground();
        if (null == background) {
            setBackgroundResource(R.drawable.drawable_default_edittext_plus);
        }
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.EditTextPlus);
        //
        mEditTextSize = typedArray.getDimension(R.styleable.EditTextPlus_edit_text_size, sp2px(mEditTextSize));
        mEditHintText = typedArray.getString(R.styleable.EditTextPlus_edit_hint_text);
        if (TextUtils.isEmpty(mEditHintText)) {
            mEditHintText = "";
        }
        mEditTextColor = typedArray.getColor(R.styleable.EditTextPlus_edit_text_color, ContextCompat.getColor(mContext, R.color.EditTextPlusDefaultTextColor));
        mInputType = typedArray.getInt(R.styleable.EditTextPlus_edit_input_type, mInputType);
        mEditorOption = typedArray.getInt(R.styleable.EditTextPlus_edit_editor_option, mEditorOption);
        //
        mHeadTextSize = typedArray.getDimension(R.styleable.EditTextPlus_head_titile_text_size, sp2px(mHeadTextSize));
        mHeadText = typedArray.getString(R.styleable.EditTextPlus_head_title_text);
        if (TextUtils.isEmpty(mHeadText)) {
            mHeadText = "未设置";
        }
        mHeadTextColor = typedArray.getColor(R.styleable.EditTextPlus_head_title_text_color, mEditTextColor);
        //
        typedArray.recycle();
    }

    private float sp2px(float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }


    /**
     * 设置输入框文字
     * @param string
     */
    public void setEditText(String string){
        etInput.setText(string);
    }

    /**
     * 设置输入框的字体大小(单位:sp)
     *
     * @param editorTextSize
     */
    public void setEditorTextSize(float editorTextSize) {
        this.mEditTextSize = sp2px(editorTextSize);
        etInput.setTextSize(TypedValue.COMPLEX_UNIT_PX, mEditTextSize);
    }

    /**
     * 设置输入框的字体颜色(资源Id)
     *
     * @param resId
     */
    public void setEditTextColor(int resId) {
        this.mEditTextColor = ContextCompat.getColor(mContext, resId);
        etInput.setTextColor(mEditTextColor);
    }

    /**
     * 设置输入框提示文字
     *
     * @param hintText
     */
    public void setEditHintText(String hintText) {
        this.mEditHintText = hintText;
        etInput.setHint(mEditHintText);
    }

    /**
     * @param editorOption EditorInfor.editorOption
     */
    public void setEditorOPtion(int editorOption) {
        etInput.setImeOptions(editorOption);
    }

    /**
     * 设置头部文本字体大小(单位:sp)
     *
     * @param headTextSize
     */
    public void setHeadTextSize(float headTextSize) {
        this.mHeadTextSize = sp2px(headTextSize);
        tvHead.setTextSize(TypedValue.COMPLEX_UNIT_PX, mHeadTextSize);
    }

    /**
     * 设置头部文本字体颜色(资源Id)
     *
     * @param resId
     */
    public void setHeadTextColor(int resId) {
        this.mHeadTextColor = ContextCompat.getColor(mContext, resId);
        tvHead.setTextColor(mHeadTextColor);
    }

    /**
     * 设置头部文本字体
     *
     * @param headText
     */
    public void setHeadText(String headText) {
        this.mHeadText = headText;
        tvHead.setText(headText);
    }

    public interface OnDeleteListener {
        void onDelete();
    }

    public interface OnInputTextListener {
        /**
         * @param text
         * @param start
         * @param before
         * @param count
         */
        void onTextChanged(String text, int start, int before, int count);

        /**
         * @param text
         */
        void afterTextChanged(String text);
    }

    public interface OnEditorOptActionListener {
        void onEditorAction(TextView textView, int actionId, KeyEvent keyEvent);
    }

    public String getText(){
        return etInput.getText().toString();
    }

}
