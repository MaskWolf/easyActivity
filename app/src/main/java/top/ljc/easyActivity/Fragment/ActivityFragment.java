package top.ljc.easyActivity.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.ljc.easyActivity.R;

public class ActivityFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmet_activity,container,false);

        findViews(view);

        initData();

        initViews();

        return view;
    }

    private void findViews(View view) {

    }

    public void initData(){

    }


    public void initViews(){

    }
}
