package com.miquan.utils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.miquan.utils.R;

import java.util.ArrayList;
import java.util.List;

public class DrawerListAdapter extends BaseAdapter {
    private Context context;
    private List<String> mDatas = new ArrayList<>();

    public DrawerListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_drawer_list, null);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String title = mDatas.get(position);
        holder.tv_title.setText(title);

        return convertView;
    }

    private class ViewHolder {
        public TextView tv_title;
    }

    public void setDatas(List<String> datas) {
        if (datas != null) {
            mDatas = datas;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public String getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
