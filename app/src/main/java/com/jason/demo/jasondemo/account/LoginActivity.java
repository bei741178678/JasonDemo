package com.jason.demo.jasondemo.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.activity.MainActivity;
import com.jason.demo.jasondemo.view.CustomDialog;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * 登录页面
 * Created by jason on 2017-3-21.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private Button btn_login;
    private Button btn_regist;
    private EditText et_user;
    private EditText et_pass;
    private CustomDialog dialog;

    private void initView() {
        et_user = (EditText) findViewById(R.id.et_user);
        et_pass = (EditText) findViewById(R.id.et_pass);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_regist = (Button) findViewById(R.id.btn_regist);
        btn_login.setOnClickListener(this);
        btn_regist.setOnClickListener(this);

        dialog = new CustomDialog(this,200,200,R.layout.dialog_loading,R.style.Theme_dialog, Gravity.CENTER,R.style.pop_anim_style);
        dialog.setCancelable(false);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String user = et_user.getText().toString().trim();
                String pass = et_pass.getText().toString().trim();
                if(TextUtils.isEmpty(user)){
                    Toast.makeText(LoginActivity.this, "用戶名不能爲空", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "密碼不能爲空", Toast.LENGTH_LONG).show();
                    return;
                }
                dialog.show();
                MyUser myUser = new MyUser();
                myUser.setUsername(user);
                myUser.setPassword(pass);

                myUser.login(new SaveListener<MyUser>() {
                    @Override
                    public void done(MyUser myUser, BmobException e) {
                        if(e==null){
                            dialog.dismiss();
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

                break;
            case R.id.btn_regist:
                startActivity(new Intent(this, RegistActivity.class));
                break;
            default:
                break;
        }
    }
}
