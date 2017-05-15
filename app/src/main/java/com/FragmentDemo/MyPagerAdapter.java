package com.our_company.FragmentDemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by little star on 2017/3/21.
 */

public class MyPagerAdapter extends PagerAdapter{
    private List<View>viewList;
    private List<String> titleList;
    public MyPagerAdapter(List<View>viewList,List<String> titleList){
    this.viewList=viewList;
    this.titleList=titleList;
    }   //适配器构造方法
    @Override
    public int getCount() {//a返回页卡数量
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//判断view是否来自于对象
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//实例化页卡
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//销毁页卡
       // super.destroyItem(container, position, object);
        container.removeView(viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);//设置viewpager页卡标题
    }
}
