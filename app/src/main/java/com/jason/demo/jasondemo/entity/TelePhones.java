package com.jason.demo.jasondemo.entity;

import java.io.File;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by jason on 2017-3-28.
 */

public class TelePhones extends BmobObject{
    private String phoneName;
    private BmobFile pic01;
    private BmobFile pic02;
    private String description;

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public BmobFile getPic01() {
        return pic01;
    }

    public void setPic01(BmobFile pic01) {
        this.pic01 = pic01;
    }

    public BmobFile getPic02() {
        return pic02;
    }

    public void setPic02(BmobFile pic02) {
        this.pic02 = pic02;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
