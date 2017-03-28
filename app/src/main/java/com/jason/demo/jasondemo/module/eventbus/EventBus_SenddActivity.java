package com.jason.demo.jasondemo.module.eventbus;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * EventBus发送页面
 */

public class EventBus_SenddActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus__secoend);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn01) {
            DataInfo dataInfo = new DataInfo();
            dataInfo.msg = "this is sended message！！！";
            EventBus.getDefault().post(dataInfo);
            finish();

        } else if (v.getId() == R.id.btn02) {
            EventBus.getDefault().register(this);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void receiveStickMessage(DataInfo info){
            tv.setText(info.msg);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
