package top.ljc.easyActivity.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import top.ljc.easyActivity.Fragment.ActivityFragment;
import top.ljc.easyActivity.Fragment.HomeFragment;
import top.ljc.easyActivity.Fragment.UserFragment;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    private final int PAGER_COUNT = 3;

    private HomeFragment homeFragment;
    private ActivityFragment activityFragment;
    private UserFragment userFragment;

    public MyFragmentPagerAdapter(FragmentManager fm){
        super(fm);
        homeFragment = new HomeFragment();
        activityFragment = new ActivityFragment();
        userFragment = new UserFragment();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            default:
                fragment = homeFragment;
                break;
            case 1:
                fragment = activityFragment;
                break;
            case 2:
                fragment = userFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
