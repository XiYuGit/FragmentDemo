package com.our_company.FragmentDemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static com.our_company.FragmentDemo.R.id.btn2;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Fragment fragment;//当前展示的Fragment
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_fragment,fragment1).commit();
        fragment=fragment1;
    }
    void initView(){
        radioGroup= (RadioGroup) findViewById(R.id.radiogroup);
        radioButton1= (RadioButton) findViewById(R.id.btn1);
        radioButton2= (RadioButton) findViewById(btn2);
        radioButton3= (RadioButton) findViewById(R.id.btn3);
        radioButton4= (RadioButton) findViewById(R.id.btn4);
        radioGroup.setOnCheckedChangeListener(this);
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.btn1:
                radioButton1.setChecked(true);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
                switchFragment(fragment1);
                break;
            case btn2:
                radioButton1.setChecked(false);
                radioButton2.setChecked(true);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
                switchFragment(fragment2);
                break;
            case R.id.btn3:
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(true);
                radioButton4.setChecked(false);
                switchFragment(fragment3);
                break;
            case R.id.btn4:
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(true);
                switchFragment(fragment4);
                break;

        }
    }

    private void switchFragment(Fragment fragments) {
        Log.i("1","1");
        if(fragment != fragments) {         //判断当前显示的Fragment是不是切换的Fragment
            Log.i("2","2");
            if (!fragments.isAdded()) {      //判断切换的Fragment是否已经添加过
                                            //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                Log.i("3","3");
                getSupportFragmentManager().beginTransaction().hide(fragment).add(R.id.main_fragment,fragments).commit();
            } else {
                                            //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                Log.i("4","4");
                getSupportFragmentManager().beginTransaction().hide(fragment).show(fragments).commit();
            }
            fragment = fragments;
        }
    }


}
