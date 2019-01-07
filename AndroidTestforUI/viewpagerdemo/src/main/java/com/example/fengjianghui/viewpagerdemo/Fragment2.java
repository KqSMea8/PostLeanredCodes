package com.example.fengjianghui.viewpagerdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * FragmentPagerAdapter的fragment
 * Fragment导的是support.v4的包  可以向下兼容到3点多
 * Created by fengjianghui on 2015/9/25.
 */
public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view2,container,false);
    }
}
