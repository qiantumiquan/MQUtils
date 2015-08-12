package com.miquan.mqutils.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miquan.utils.R;
import com.miquan.utils.fragment.SuperFragment;
import com.miquan.utils.view.FloatingActionButton;
import com.miquan.utils.view.ProgressBarCircular;

public class SampleFragment extends SuperFragment {

    private int position;

    public static SampleFragment newInstance(int position) {
        SampleFragment f = new SampleFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return mRootView;
    }

    @Override
    protected void readArgs(Bundle args) {
        position = args.getInt("position");
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_simple;
    }

    @Override
    protected void initView(View rootView) {
        ProgressBarCircular progressBarCircular = (ProgressBarCircular) rootView.findViewById(R.id.progress);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.float_button);
        fab.setDrawableIcon(getResources().getDrawable(R.drawable.plus));
    }

    @Override
    protected void initViewData() {

    }
}