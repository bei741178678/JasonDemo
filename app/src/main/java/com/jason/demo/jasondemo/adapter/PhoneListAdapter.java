package com.jason.demo.jasondemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.entity.TelePhones;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by jason on 2017-3-28.
 */

public class PhoneListAdapter extends RecyclerView.Adapter<PhoneListAdapter.ViewHolder> {

    private Context mContext;
    private List<TelePhones> mList;

    public PhoneListAdapter(Context context, List<TelePhones> list) {
        this.mContext = context;
        this.mList = list;
    }

    //相当于getView
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_recyclerview_phone,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(!TextUtils.isEmpty(mList.get(position).getPhoneName())){
            holder.getTv_title().setText(mList.get(position).getPhoneName());
        }
        if(!TextUtils.isEmpty(mList.get(position).getDescription())){
            holder.getTv_content().setText("\t\t\t\t"+mList.get(position).getDescription());
        }
        if(mList.get(position).getPic01()!=null){
            BmobFile file = mList.get(position).getPic01();
            String url = file.getUrl();
            ImageView iv = new ImageView(mContext);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.getLl_pics().addView(iv);
            ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
            layoutParams.width = 400;
            layoutParams.height = 200;
            iv.setLayoutParams(layoutParams);
            Picasso.with(mContext).load(url).into(iv);
        }
        if(mList.get(position).getPic02()!=null){
            BmobFile file = mList.get(position).getPic02();
            String url = file.getUrl();
            ImageView iv = new ImageView(mContext);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.getLl_pics().addView(iv);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iv.getLayoutParams();
            layoutParams.width = 400;
            layoutParams.height = 200;
            layoutParams.leftMargin = 20;
            iv.setLayoutParams(layoutParams);
            Picasso.with(mContext).load(url).into(iv);
        }

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private TextView tv_content;
        private LinearLayout ll_pics;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_context);
            this.ll_pics = (LinearLayout) itemView.findViewById(R.id.ll_pics);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        public TextView getTv_title() {
            return tv_title;
        }

        public void setTv_title(TextView tv_title) {
            this.tv_title = tv_title;
        }

        public TextView getTv_content() {
            return tv_content;
        }

        public void setTv_content(TextView tv_content) {
            this.tv_content = tv_content;
        }

        public LinearLayout getLl_pics() {
            return ll_pics;
        }

        public void setLl_pics(LinearLayout ll_pics) {
            this.ll_pics = ll_pics;
        }
    }
}
