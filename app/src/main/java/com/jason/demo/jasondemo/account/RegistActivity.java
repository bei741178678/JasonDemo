package com.jason.demo.jasondemo.account;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.activity.BaseActivity;
import com.jason.demo.jasondemo.utils.L;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by jason on 2017-3-22.
 */

public class RegistActivity extends BaseActivity implements View.OnClickListener {
    private boolean isGender = true;//默认男生

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    private EditText et_user;
    private EditText et_age;
    private EditText et_desc;
    private RadioGroup rg;
    private EditText et_pass;
    private EditText et_psw;
    private EditText et_email;
    private Button btn_reg;
    private RadioButton rb_boy;
    private RadioButton rb_girl;

    private void initView() {
        et_user = (EditText) findViewById(R.id.et_user);
        et_age = (EditText) findViewById(R.id.et_age);
        et_desc = (EditText) findViewById(R.id.et_desc);
        rg = (RadioGroup) findViewById(R.id.rg);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_psw = (EditText) findViewById(R.id.et_psw);
        et_email = (EditText) findViewById(R.id.et_email);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(this);
        rb_boy = (RadioButton) findViewById(R.id.rb_boy);
        rb_girl = (RadioButton) findViewById(R.id.rb_girl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reg:
                String user = et_user.getText().toString().trim();
                String age = et_age.getText().toString().trim();
                String desc = et_desc.getText().toString().trim();
                String pass = et_pass.getText().toString().trim();
                String psw = et_psw.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(age)) {
                    Toast.makeText(this, "请输入年龄", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(desc)) {
                    Toast.makeText(this, "请输入个人简介", Toast.LENGTH_LONG).show();
                    return;
                }
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                        if (checkedId == R.id.rb_boy) {
                            isGender = true;
                        } else if (checkedId == R.id.rb_girl) {
                            isGender = false;

                        }
                    }
                });


                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(psw)) {
                    Toast.makeText(this, "请再次输入密码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!pass.equals(psw)) {
                    Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(this, "请输入个人邮箱", Toast.LENGTH_LONG).show();
                    return;
                }

                MyUser myUser = new MyUser();
                myUser.setUsername(user);
                myUser.setPassword(pass);
                myUser.setEmail(email);
                myUser.setAge(Integer.parseInt(age));
                myUser.setSex(isGender);
                myUser.setDesc(desc);
                myUser.signUp(new SaveListener<MyUser>() {
                    @Override
                    public void done(MyUser myUser, BmobException e) {
                        if(e==null){
                            Toast.makeText(RegistActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                            finish();
                        }else {
                            Toast.makeText(RegistActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });


                break;
            default:
                break;
        }
    }
}
