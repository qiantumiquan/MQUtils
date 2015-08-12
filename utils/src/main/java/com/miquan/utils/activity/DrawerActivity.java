package com.miquan.utils.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.view.ViewGroup;

import com.miquan.utils.R;

/**
 * Created by mq on 2015/8/12.
 * --- 流弊 ---
 * 1 继承DrawerActivity
 * 2 实现initView
 * 3 删除setContentView
 */
public abstract class DrawerActivity extends SuperActivity {
    // DrawerLayout
    private DrawerLayout mDrawerLayout;
    // 侧边栏
    private ViewGroup mDrawerContainer;
    // 主页面
    private ViewGroup mMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(com.miquan.utils.R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                getToolbar(), R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(drawerToggle);

        // 侧边栏
        mDrawerContainer = (ViewGroup) findViewById(R.id.drawer_container);
        mDrawerContainer.addView(getDrawerContainer());

        // 主页面
        mMainContainer = (ViewGroup) findViewById(R.id.main_container);
        mMainContainer.addView(getMainContainer());
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_drawer;
    }

    /**
     * 传入侧滑界面。
     */
    protected abstract View getDrawerContainer();

    /**
     * 传入主界面。
     */
    protected abstract View getMainContainer();

    /**
     * 关闭侧边栏
     */
    protected void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }
}
