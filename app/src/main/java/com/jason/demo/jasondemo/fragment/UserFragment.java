package com.jason.demo.jasondemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.account.LoginActivity;
import com.jason.demo.jasondemo.account.MyUser;
import com.jason.demo.jasondemo.activity.FastEmailActivity;

import org.w3c.dom.Text;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment implements View.OnClickListener {


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);


        return view;
    }

    private Button btn_exit_user;
    private EditText et_user;
    private EditText et_sex;
    private EditText et_age;
    private EditText et_desc;
    private TextView tv_edit;
    private Button btn_update_user;
    private CircleImageView civ_user;
    private TextView tv_fastEmail;//快递查询

    private void initView(View view) {
        civ_user = (CircleImageView) view.findViewById(R.id.civ_user);
        civ_user.setOnClickListener(this);
        btn_exit_user = (Button) view.findViewById(R.id.btn_exit_user);
        btn_update_user = (Button) view.findViewById(R.id.btn_update_user);
        btn_update_user.setOnClickListener(this);
        btn_exit_user.setOnClickListener(this);
        tv_edit = (TextView) view.findViewById(R.id.tv_edit);
        et_user = (EditText) view.findViewById(R.id.et_user);
        et_sex = (EditText) view.findViewById(R.id.et_sex);
        et_age = (EditText) view.findViewById(R.id.et_age);
        et_desc = (EditText) view.findViewById(R.id.et_desc);
        tv_edit.setOnClickListener(this);
        tv_fastEmail = (TextView) view.findViewById(R.id.tv_fastEmail);
        tv_fastEmail.setOnClickListener(this);

        //设置不可点击
        setEnable(false);

        //设置具体的值
        updateInfo();


    }

    private void updateInfo() {
        MyUser myUser = BmobUser.getCurrentUser(MyUser.class);
        if (myUser != null) {

            et_user.setText(myUser.getUsername());
            et_sex.setText(myUser.isSex() ? "男" : "女");
            et_age.setText(myUser.getAge() + "");
            et_desc.setText(myUser.getDesc());
        }
    }

    private void setEnable(boolean is) {

        et_user.setEnabled(is);
        et_sex.setEnabled(is);
        et_age.setEnabled(is);
        et_desc.setEnabled(is);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exit_user:
                MyUser.logOut();
                BmobUser currentUser = MyUser.getCurrentUser();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
                break;
            case R.id.tv_edit:
                btn_update_user.setVisibility(View.VISIBLE);
                setEnable(true);
                break;
            case R.id.btn_update_user:
                String username = et_user.getText().toString().trim();
                String age = et_age.getText().toString().trim();
                String sex = et_sex.getText().toString().trim();
                String desc = et_desc.getText().toString().trim();
                if (!TextUtils.isEmpty(username) & !TextUtils.isEmpty(age) & !TextUtils.isEmpty(sex)) {
                    MyUser myUser = new MyUser();
                    myUser.setUsername(username);
                    myUser.setAge(Integer.parseInt(age));
                    if (sex.equals("男")) {
                        myUser.setSex(true);
                    } else {
                        myUser.setSex(false);
                    }
                    if (TextUtils.isEmpty(desc)) {
                        desc = "这个人很懒，什么都没有写";
                    }
                    BmobUser bombUser = BmobUser.getCurrentUser();
                    myUser.update(bombUser.getObjectId(), new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {
                                setEnable(false);
                                btn_update_user.setVisibility(View.GONE);
                                Toast.makeText(getActivity(), "修改成功", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "输入框不能为空", Toast.LENGTH_LONG).show();
                    return;
                }

                break;
            case R.id.civ_user:
                break;
            case R.id.tv_fastEmail:
                startActivity(new Intent(getActivity(), FastEmailActivity.class));
                break;


            default:
                break;
        }
    }
}
