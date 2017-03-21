package com.jason.demo.jasondemo.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.fragment.ButlerFragment;
import com.jason.demo.jasondemo.fragment.GirlFragment;
import com.jason.demo.jasondemo.fragment.UserFragment;
import com.jason.demo.jasondemo.fragment.WechatFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //TabLayout
    private TabLayout mTablayout;
    //ViewPager
    private ViewPager mViewPager;
    //Title
    private List<String> mTitle;
    //Fragment
    private List<Fragment> mFragment;
    //悬浮窗
    private FloatingActionButton tab_settint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去掉阴影
        getSupportActionBar().setElevation(0);

        initData();
        initView();
    }
    //初始化数据
    private void initData() {
        //头部标题
        mTitle = new ArrayList<>();
        mTitle.add(getResources().getString(R.string.tab01));
        mTitle.add(getResources().getString(R.string.tab02));
        mTitle.add(getResources().getString(R.string.tab03));
        mTitle.add(getResources().getString(R.string.tab04));

        //Fragment
        mFragment = new ArrayList<>();
        mFragment.add(new ButlerFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());


    }
    //初始化View
    private void initView() {
        tab_settint = (FloatingActionButton) findViewById(R.id.tab_setting);
        mTablayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);

        tab_settint.setOnClickListener(this);



        //ViewPager预加载
        if(mFragment.size()>=1){
            mViewPager.setOffscreenPageLimit(mFragment.size());
        }
        //Viewpager设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        //绑定
        mTablayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tab_setting:
                startActivity(new Intent(this,SettingActivity.class));
                break;
            default:
                break;
        }
    }
}
