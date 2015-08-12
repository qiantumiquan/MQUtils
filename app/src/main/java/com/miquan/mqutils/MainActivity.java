package com.miquan.mqutils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miquan.mqutils.adapter.DrawerListAdapter;
import com.miquan.mqutils.adapter.ViewPagerAdapter;
import com.miquan.utils.activity.DrawerActivity;
import com.miquan.utils.utils.ToastUtils;
import com.miquan.utils.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends DrawerActivity {
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
    protected void init() {
    }

    @Override
    protected void initToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            toolbar.setLogo(R.mipmap.ic_launcher);
            toolbar.setTitle("什么鬼");
            toolbar.setSubtitle("小标题");
            toolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);
        }
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initViewData() {
        updateDrawer();
        updatePager();
    }

    @Override
    protected View getDrawerContainer() {
        // 侧边栏
        View view = LayoutInflater.from(context).inflate(R.layout.layout_container_drawer, null);
        mDrawerList = (ListView) view.findViewById(R.id.drawer_container);
        mDrawerAdapter = new DrawerListAdapter(context);
        mDrawerList.setAdapter(mDrawerAdapter);
        mDrawerList.setOnItemClickListener(mOnDrawerItemClickListener);
        return view;
    }

    @Override
    protected View getMainContainer() {
        // 主页面
        View view = LayoutInflater.from(context).inflate(R.layout.layout_container_main, null);
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tab_layout);
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.WHITE;
            }
        });
        mPager = (ViewPager) view.findViewById(R.id.viewpager);
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mSlidingTabLayout.setViewPager(mPager);
        return view;
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_edit:
                    ToastUtils.showToast(context, item.getTitle().toString());
                    break;
                case R.id.action_settings:
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
                    closeDrawer();
                    break;
                case 1:
                    closeDrawer();
                    break;
            }
        }
    };
}

