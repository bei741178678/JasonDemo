package com.jason.demo.jasondemo.module.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBus_MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus__main);
        EventBus.getDefault().register(this);
        initView();
    }
    private Button btn01;
    private Button btn02;
    private TextView tv;
    private void initView() {
        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        tv = (TextView) findViewById(R.id.tv);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void messageEventBus(DataInfo info){
        tv.setText(info.msg);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn01){
            startActivity(new Intent(this,EventBus_SenddActivity.class));
        }else if(v.getId()==R.id.btn02){
            DataInfo info = new DataInfo();
            info.msg = "这是粘性事件数据";
            EventBus.getDefault().postSticky(info);
            startActivity(new Intent(this,EventBus_SenddActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
