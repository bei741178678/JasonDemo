package com.jason.demo.jasondemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.adapter.PhoneListAdapter;
import com.jason.demo.jasondemo.entity.TelePhones;
import com.jason.demo.jasondemo.view.ListDivider;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends Fragment {


    public WechatFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        initView(view);
        return view;
    }
    private RecyclerView rv;
    private void initView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.rv);
        BmobQuery<TelePhones> query = new BmobQuery<TelePhones>();
        query.findObjects(new FindListener<TelePhones>() {
            @Override
            public void done(List<TelePhones> list, BmobException e) {
                PhoneListAdapter adapter = new PhoneListAdapter(getActivity(),list);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                //添加分割线
                rv.addItemDecoration(new ListDivider(getActivity(),4));
            }
        });


    }

}
