package com.jason.demo.jasondemo.application;

import android.app.Application;

import com.jason.demo.jasondemo.utils.StaticClass;

import cn.bmob.v3.Bmob;

/**
 * Created by jason on 2017-3-21.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Bmob
        Bmob.initialize(this, StaticClass.BMOB_APPLICATION_ID);
    }
}
