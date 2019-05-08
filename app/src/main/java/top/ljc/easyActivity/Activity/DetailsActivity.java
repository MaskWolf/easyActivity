package top.ljc.easyActivity.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import top.ljc.easyActivity.R;

public class DetailsActivity extends Activity {

    private Banner banner;
    private ArrayList<String> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_details);

        findViews();

        initData();

        initView();

    }

    private void findViews() {
        banner = (Banner)findViewById(R.id.banner);
    }

    private void initData() {
        images = new ArrayList<>();
        images.add("http://img2.imgtn.bdimg.com/it/u=2260937709,2065328859&fm=26&gp=0.jpg");
        images.add("http://img0.imgtn.bdimg.com/it/u=1842273078,3771452716&fm=200&gp=0.jpg");
        images.add("http://img4.imgtn.bdimg.com/it/u=2365173552,1600985734&fm=26&gp=0.jpg");
    }

    private void initView() {
        banner.setImages(images)//设置图集
                .setDelayTime(3000)//轮播间隔时间
                .setImageLoader(new GlideImageLoader())//设置图片加载器
                .start();
    }

    static class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);
        }
    }
}
