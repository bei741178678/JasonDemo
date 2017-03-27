package com.jason.demo.jasondemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.entity.FastEmailInfo;

import java.util.List;

/**
 * Created by jason on 2017-3-23.
 */

public class FastEmailAdapter extends BaseAdapter {
    private Context context;
    private List<FastEmailInfo> list;
    private LayoutInflater inflater;

    public FastEmailAdapter(Context context, List<FastEmailInfo> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_fastemail,null);
            holder.tv_mark = (TextView) convertView.findViewById(R.id.tv_remark);
            holder.tv_zone = (TextView) convertView.findViewById(R.id.tv_zone);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_mark.setText("");
        holder.tv_zone.setText("");
        holder.tv_time.setText("");

        if(!TextUtils.isEmpty(list.get(position).getRemark())){
            holder.tv_mark.setText(list.get(position).getRemark());
        }
        if(!TextUtils.isEmpty(list.get(position).getZone())){
            holder.tv_zone.setText(list.get(position).getZone());
        }
        if(!TextUtils.isEmpty(list.get(position).getDatetime())){
            holder.tv_time.setText(list.get(position).getDatetime());
        }


        return convertView;
    }

    class ViewHolder {
        private TextView tv_mark;
        private TextView tv_zone;
        private TextView tv_time;

    }
}
