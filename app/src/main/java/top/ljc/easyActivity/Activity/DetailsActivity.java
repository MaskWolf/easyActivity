package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.ljc.easyActivity.Adapter.CommentExpandAdapter;
import top.ljc.easyActivity.Data.ActivityItem;
import top.ljc.easyActivity.Data.CommentDetailBean;
import top.ljc.easyActivity.Data.ReplyDetailBean;
import top.ljc.easyActivity.Data.User;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.CommentExpandableListView;

import static top.ljc.easyActivity.Utils.Constants.SERVER_ADDRESS;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "DetailsActivity";

    private static final int UPDATE_OMMENT = 1;

    private Context context;
    private User user;
    private Banner banner;
    private Toolbar toolbar;
    private Button btSignup;
    private TextView bt_comment;
    private CollapsingToolbarLayout collapsingToolbar;
    private CommentExpandableListView expandableListView;
    private CommentExpandAdapter adapter;
    private List<CommentDetailBean> commentsList;
    private BottomSheetDialog dialog;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_OMMENT:
                    adapter.notifyDataSetChanged();
                    for(int i = 0; i<commentsList.size(); i++){
                        expandableListView.expandGroup(i);
                    }
                    break;
            }
        }
    };

    private ActivityItem activityItem;
    private ArrayList<String> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_details);

        findViews();

        initData();

        initView();

    }

    private void findViews() {
        banner = (Banner)findViewById(R.id.banner);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        expandableListView = (CommentExpandableListView) findViewById(R.id.detail_page_lv_comment);
        bt_comment = (TextView) findViewById(R.id.detail_page_do_comment);
        bt_comment.setOnClickListener(this);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        btSignup = (Button) findViewById(R.id.bt_signup);

        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignupActivity.class);
                intent.putExtra("activityitem",activityItem);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        user = new User();
        activityItem = (ActivityItem) getIntent().getSerializableExtra("activityitem");
        images = activityItem.getImages();
        if (images == null){
            images = new ArrayList<>();
        }
        images.add("http://img2.imgtn.bdimg.com/it/u=2260937709,2065328859&fm=26&gp=0.jpg");
        images.add("http://img0.imgtn.bdimg.com/it/u=1842273078,3771452716&fm=200&gp=0.jpg");
        images.add("http://img4.imgtn.bdimg.com/it/u=2365173552,1600985734&fm=26&gp=0.jpg");
        commentsList = new ArrayList<>();
        getComments();
    }

    private void initView() {
        collapsingToolbar.setTitle(activityItem.getaName());
        banner.setImages(images)//设置图集
                .setDelayTime(3000)//轮播间隔时间
                .setImageLoader(new GlideImageLoader())//设置图片加载器
                .start();
        initExpandableListView(commentsList);
    }

    static class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);
        }
    }

    /**
     * 初始化评论和回复列表
     */
    private void initExpandableListView(final List<CommentDetailBean> commentList){
        expandableListView.setGroupIndicator(null);
        //默认展开所有回复
        adapter = new CommentExpandAdapter(this, commentList);
        expandableListView.setAdapter(adapter);
        for(int i = 0; i<commentList.size(); i++){
            expandableListView.expandGroup(i);
        }
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                boolean isExpanded = expandableListView.isGroupExpanded(groupPosition);
                Log.e(TAG, "onGroupClick: 当前的评论id>>>"+commentList.get(groupPosition).getId());
//                if(isExpanded){
//                    expandableListView.collapseGroup(groupPosition);
//                }else {
//                    expandableListView.expandGroup(groupPosition, true);
//                }
                showReplyDialog(groupPosition);
                return true;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                Toast.makeText(context,"点击了回复",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //toast("展开第"+groupPosition+"个分组");

            }
        });

    }

    /**
     * 获得该活动下的所有评论
     */
    private void getComments(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("pId", activityItem.getpId()+"")
                            .build();
                    Request request = new Request.Builder()
                            .url(SERVER_ADDRESS+"/manager/getComments")
                            .post(requestBody)
                            .build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            try{
                                String string = response.body().string();
                                Log.e(TAG, "onResponse: "+ string);
                                JSONObject jsonObject = new JSONObject(string);
                                JSONArray jsonArray = jsonObject.getJSONArray("commentData");
                                for (int i=0;i<jsonArray.length();i++){
                                    JSONObject comment = jsonArray.getJSONObject(i);
                                    int toCid = comment.getInt("toCid");
                                    if (toCid == 0){
                                        CommentDetailBean commentDetailBean = new CommentDetailBean(
                                                comment.getJSONObject("fromUser").getString("uName")
                                                ,comment.getString("content")
                                                ,comment.getString("commentTime"));
                                        commentDetailBean.setId(comment.getInt("cId"));
                                        commentDetailBean.setUserLogo(comment.getString("fromUserImage"));
                                        commentsList.add(commentDetailBean);
                                    }
                                }
                                for (int i=0;i<jsonArray.length();i++){
                                    JSONObject comment = jsonArray.getJSONObject(i);
                                    int toCid = comment.getInt("toCid");
                                    if (toCid != 0){
                                        for (CommentDetailBean temp:commentsList){
                                            if (temp.getId() == toCid){
                                                ReplyDetailBean replyDetailBean = new ReplyDetailBean(comment.getJSONObject("fromUser").getString("uName"),
                                                        comment.getString("content"));
                                                temp.addReplyListItem(replyDetailBean);
                                                break;
                                            }
                                        }
                                    }
                                }
                                handler.sendEmptyMessage(UPDATE_OMMENT);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.detail_page_do_comment){
            showCommentDialog();
        }
    }

    /**
     * func:弹出评论框
     */
    private void showCommentDialog(){
        dialog = new BottomSheetDialog(this);
        View commentView = LayoutInflater.from(this).inflate(R.layout.comment_dialog_layout,null);
        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
        dialog.setContentView(commentView);
        /**
         * 解决bsd显示不全的情况
         */
        View parent = (View) commentView.getParent();
        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
        commentView.measure(0,0);
        behavior.setPeekHeight(commentView.getMeasuredHeight());

        bt_comment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String commentContent = commentText.getText().toString().trim();
                if(!TextUtils.isEmpty(commentContent)){
                    if (user.getUid()!=0){
                        //commentOnWork(commentContent);
                        dialog.dismiss();
                        CommentDetailBean detailBean = new CommentDetailBean(User.getUname(), commentContent,"刚刚");
                        detailBean.setUserLogo(user.getAvatar());
                        adapter.addTheCommentData(detailBean);
                        Toast.makeText(context,"评论成功",Toast.LENGTH_SHORT).show();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    OkHttpClient okHttpClient = new OkHttpClient();
                                    RequestBody requestBody = new FormBody.Builder()
                                            .add("pId", activityItem.getpId()+"")
                                            .add("fromUid",user.getUid()+"")
                                            .add("toCid", "0")
                                            .add("content", commentContent)
                                            .build();
                                    Log.e(TAG, "run: " + activityItem.getpId() +","+user.getUid()+","+ commentContent);
                                    Request request = new Request.Builder()
                                            .url(SERVER_ADDRESS+"/manager/comment")
                                            .post(requestBody)
                                            .build();
                                    okHttpClient.newCall(request).enqueue(new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {
                                            Log.d(TAG, "onFailure: ");
                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            Log.e(TAG, "onResponse: "+ response.body().string());
                                            handler.sendEmptyMessage(UPDATE_OMMENT);
                                        }
                                    });
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        Toast.makeText(context,"评论成功",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context,"请先登陆账号", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(context,"评论内容不能为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        commentText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
                }else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dialog.show();
    }

    /**
     * func:弹出回复框
     */
    private void showReplyDialog(final int position){
        dialog = new BottomSheetDialog(this);
        View commentView = LayoutInflater.from(this).inflate(R.layout.comment_dialog_layout,null);
        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
        commentText.setHint("回复 " + commentsList.get(position).getNickName() + " 的评论:");
        dialog.setContentView(commentView);
        bt_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String replyContent = commentText.getText().toString().trim();
                if(!TextUtils.isEmpty(replyContent)){
                    if (user.getUid()!=0){
                        dialog.dismiss();
                        ReplyDetailBean detailBean = new ReplyDetailBean(User.getUname(),replyContent);
                        adapter.addTheReplyData(detailBean, position);
                        expandableListView.expandGroup(position);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    OkHttpClient okHttpClient = new OkHttpClient();
                                    RequestBody requestBody = new FormBody.Builder()
                                            .add("pId", activityItem.getpId()+"")
                                            .add("fromUid",user.getUid()+"")
                                            .add("toCid", commentsList.get(position).getId()+"")
                                            .add("content", replyContent)
                                            .build();
                                    Request request = new Request.Builder()
                                            .url(SERVER_ADDRESS+"/manager/comment")
                                            .post(requestBody)
                                            .build();
                                    okHttpClient.newCall(request).enqueue(new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {
                                            Log.d(TAG, "onFailure: ");
                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            handler.sendEmptyMessage(UPDATE_OMMENT);
                                        }
                                    });
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        Toast.makeText(context,"回复成功",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context,"请先登陆账号", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(context,"回复内容不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
        commentText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
                }else {
                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        dialog.show();
    }
}
