package com.our_company.FragmentDemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by little star on 2017/3/22.
 */

public class MyFragmentpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> titleList;
    public MyFragmentpagerAdapter(FragmentManager fragmentManager,List<String>titleList){
        super(fragmentManager);

    }
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
