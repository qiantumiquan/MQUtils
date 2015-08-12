package com.miquan.mqutils.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.miquan.mqutils.fragment.SampleFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> mDatas = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setDatas(List<String> datas) {
        if (datas != null) {
            mDatas = datas;
            notifyDataSetChanged();
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SampleFragment.newInstance(position);
            case 1:
                return SampleFragment.newInstance(position);
        }
        return null;
    }

    public CharSequence getPageTitle(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }
}
