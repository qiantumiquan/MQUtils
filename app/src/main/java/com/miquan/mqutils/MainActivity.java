package com.miquan.mqutils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miquan.mqutils.activity.SuperActivity;
import com.miquan.mqutils.adapter.DrawerListAdapter;
import com.miquan.mqutils.adapter.ViewPagerAdapter;
import com.miquan.mqutils.utils.ToastUtils;
import com.miquan.mqutils.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends SuperActivity {

    // DrawerLayout
    private DrawerLayout mDrawerLayout;

    // 侧边栏
    private ListView mDrawerList;
    private DrawerListAdapter mDrawerAdapter;

    // 主页面
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mPager;
    private ViewPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            toolbar.setLogo(com.miquan.utils.R.mipmap.ic_launcher);
            toolbar.setTitle("什么鬼");
            toolbar.setSubtitle("小标题");
            toolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);
        }
    }

    @Override
    protected void initView() {
        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(com.miquan.utils.R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                getToolbar(), com.miquan.utils.R.string.app_name, com.miquan.utils.R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);

        // 侧边栏
        mDrawerList = (ListView) findViewById(com.miquan.utils.R.id.drawer_view);
        mDrawerAdapter = new DrawerListAdapter(context);
        mDrawerList.setAdapter(mDrawerAdapter);
        mDrawerList.setOnItemClickListener(mOnDrawerItemClickListener);

        // 主页面
        mSlidingTabLayout = (SlidingTabLayout) findViewById(com.miquan.utils.R.id.sliding_tab_layout);
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.WHITE;
            }
        });
        mPager = (ViewPager) findViewById(com.miquan.utils.R.id.viewpager);
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mSlidingTabLayout.setViewPager(mPager);
    }

    @Override
    protected void initViewData() {
        updateDrawer();
        updatePager();
    }

    @Override
    protected int getLayoutResource() {
        return com.miquan.utils.R.layout.activity_main;
    }

    private void updateDrawer() {
        List<String> drawerTitles = new ArrayList<>();
        drawerTitles.add("VIEWS");
        drawerTitles.add("银河系");
        mDrawerAdapter.setDatas(drawerTitles);
        mDrawerAdapter.notifyDataSetChanged();
    }

    private void updatePager() {
        List<String> titles = new ArrayList<>();
        titles.add("VIEWS");
        titles.add("月球");
        mPagerAdapter.setDatas(titles);
        mSlidingTabLayout.setViewPager(mPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.miquan.utils.R.menu.menu_main, menu);
        return true;
    }

    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case com.miquan.utils.R.id.action_edit:
                    ToastUtils.showToast(context, item.getTitle().toString());
                    break;
                case com.miquan.utils.R.id.action_settings:
                    ToastUtils.showToast(context, item.getTitle().toString());
                    break;
            }
            return false;
        }
    };

    private AdapterView.OnItemClickListener mOnDrawerItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case 1:
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
        }
    };
}

