package com.diablo.jsonanalysis;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bluelinelabs.logansquare.LoganSquare;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView countTime;
    private EditText editTextCount;
    private RadioGroup group;
    long startTime;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            countTime.setText(String.valueOf(msg.what));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        countTime = (TextView) findViewById(R.id.tv_counttime);
        editTextCount = (EditText) findViewById(R.id.et_count);
        group = (RadioGroup) findViewById(R.id.rg_group);
        findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        parsJson();
    }

    private void parsJson() {
        final int count = Integer.parseInt(editTextCount.getText().toString());
        startTime = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyJsonObj jsonObj = null;
                try {
                    for (int i = 0; i < count; i++) {
                        if (group.getCheckedRadioButtonId() == R.id.rb_logansquare) {
                            jsonObj = LoganSquare.parse(JsonStr.JSON_STR, MyJsonObj.class);
                        } else if (group.getCheckedRadioButtonId() == R.id.rb_gson) {
                            jsonObj = new Gson().fromJson(JsonStr.JSON_STR, MyJsonObj.class);
                        } else if (group.getCheckedRadioButtonId() == R.id.rb_fastjson) {
                            jsonObj = JSON.parseObject(JsonStr.JSON_STR, MyJsonObj.class);
                        }
                    }
                    handler.sendEmptyMessage((int) (System.currentTimeMillis() - startTime));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
