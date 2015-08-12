package com.miquan.utils.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.miquan.utils.R;

/**
 * Created by mq on 2015/8/11.
 * --- 流弊 ---
 */
public abstract class SuperActivity extends AppCompatActivity {
    protected Context context;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        context = this;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("What?");
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }

        init();
        initToolbar(toolbar);
        initView();
        initViewData();
    }

    protected Toolbar getToolbar() {
        return toolbar;
    }

    protected abstract int getLayoutResource();

    /**
     * 初始化一些变量等。
     */
    protected abstract void init();

    /**
     * 初始化Toolbar。
     */
    protected abstract void initToolbar(Toolbar toolbar);

    /**
     * 取得view，添加一些监听器等等。
     */
    protected abstract void initView();

    /**
     * 给view赋值。
     */
    protected abstract void initViewData();
}
