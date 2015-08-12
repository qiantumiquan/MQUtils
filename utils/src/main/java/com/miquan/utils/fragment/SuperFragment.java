package com.miquan.utils.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mq on 2015/8/12.
 * --- 流弊 ---
 */
public abstract class SuperFragment extends Fragment {
    protected Context context;

    protected View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        readArgs(getArguments());
        mRootView = inflater.inflate(getLayoutResource(), container, false);
        initView(mRootView);
        initViewData();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract void readArgs(Bundle args);
    protected abstract int getLayoutResource();
    protected abstract void initView(View rootView);
    protected abstract void initViewData();
}
