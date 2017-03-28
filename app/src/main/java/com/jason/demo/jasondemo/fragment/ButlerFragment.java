package com.jason.demo.jasondemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.module.eventbus.EventBus_MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButlerFragment extends Fragment {


    public ButlerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_butler, container, false);
        initView(view);
        return view;
    }

    private ListView lv;

    private void initView(View view) {
        lv = (ListView) view.findViewById(R.id.lv);
        List<String> list = new ArrayList<>();
        list.add("EventBus");
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(getActivity(), EventBus_MainActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
