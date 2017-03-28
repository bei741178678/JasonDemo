package com.jason.demo.jasondemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jason.demo.jasondemo.R;

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
        return view;
    }

}
