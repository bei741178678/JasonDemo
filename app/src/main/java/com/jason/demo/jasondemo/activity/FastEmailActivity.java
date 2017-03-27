package com.jason.demo.jasondemo.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.jason.demo.jasondemo.R;
import com.jason.demo.jasondemo.adapter.FastEmailAdapter;
import com.jason.demo.jasondemo.entity.FastEmailInfo;
import com.jason.demo.jasondemo.utils.StaticClass;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jason on 2017-3-23.
 */

public class FastEmailActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastemail);
        initView();

    }

    private Button btn_query;
    private EditText et_com;
    private EditText et_no;
    private ListView lv;

    private void initView() {
        et_com = (EditText) findViewById(R.id.et_com);
        et_com.setText("yt");
        et_no = (EditText) findViewById(R.id.et_no);
        et_no.setText("884348988616892682");
        btn_query = (Button) findViewById(R.id.btn_query);
        btn_query.setOnClickListener(this);
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_query:
                String com = et_com.getText().toString().trim();
                String no = et_no.getText().toString().trim();
                if (!TextUtils.isEmpty(com) & !TextUtils.isEmpty(no)) {
                    String url = "http://v.juhe.cn/exp/index?key=" + StaticClass.KUIDI_KEY + "&com=" + com + "&no=" + no;
                    RxVolley.get(url, new HttpCallback() {
                        @Override
                        public void onSuccess(String t) {
                            super.onSuccess(t);
                            try {
                                List<FastEmailInfo> fastEmailInfos = parseJson(t);
                                Collections.reverse(fastEmailInfos);
                                FastEmailAdapter adapter = new FastEmailAdapter(FastEmailActivity.this,fastEmailInfos);
                                lv.setAdapter(adapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }


                    });
                }

                break;
            default:
                break;

        }
    }

    //解析数据
    private List<FastEmailInfo> parseJson(String t) throws JSONException {
        JSONObject o = new JSONObject(t);
        JSONObject result = o.getJSONObject("result");
        JSONArray list = result.getJSONArray("list");
        List<FastEmailInfo> l = new ArrayList<>();
        for (int i = 0; i < list.length(); i++) {
            JSONObject o2 = (JSONObject) list.get(i);
            FastEmailInfo info = new FastEmailInfo();
            info.setRemark(o2.getString("remark"));
            info.setZone(o2.getString("zone"));
            info.setDatetime(o2.getString("datetime"));
            l.add(info);
        }


        return l;
    }
}
