package com.jason.demo.jasondemo.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.utils.ShareUtils;
import com.jason.demo.jasondemo.utils.StaticClass;
import com.jason.demo.jasondemo.utils.Tools;

/**
 * Created by jason on 2017-3-21.
 */
public class SplashActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case StaticClass.HANDLER_SPLASH:
                    if (isFirst()) {
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initFont();
    }

    /**
     * 设置字体
     */
    private void initFont() {
        Tools.setFont(this,tv);

    }
    private TextView tv;
    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH, 10000);
    }

    /**
     * 判断是否是第一次运行
     * @return
     */
    private boolean isFirst() {
        boolean isfirst = ShareUtils.getBoolean(this, StaticClass.SHARE_ISFIRST, true);
        if(isfirst){
            ShareUtils.putBoolean(this,StaticClass.SHARE_ISFIRST,false);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();  禁止返回键
    }
}

