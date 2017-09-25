package com.example.believe.text02;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.believe.text02.okHttpText.AddMessageActivity;
import com.example.believe.text02.pojo.uMessage;
import com.example.believe.text02.service.MyMessageService;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;

/**
 * Created by BELIEVE on 2017/9/6.
 */

public class OkHttpActivity extends Activity {

    @Bind(R.id.doget)
    Button doget;
    @Bind(R.id.dopost)
    Button dopost;
    @Bind(R.id.btn_add)
    Button btnAdd;
    private MyBroadcastReceiver receiver;
    private ArrayList<uMessage> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp_activity);
        ButterKnife.bind(this);
        if (receiver == null) {
            receiver = new MyBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.beli.message");
            registerReceiver(receiver, intentFilter);
        }
    }




    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        Intent intent = new Intent(OkHttpActivity.this, AddMessageActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick({R.id.doget, R.id.dopost})
    public void onViewClicked(View view) {
        Intent intent = new Intent(OkHttpActivity.this, MyMessageService.class);
        switch (view.getId()) {
            case R.id.doget:
//                查询所有用户发布论坛的信息
                intent.putExtra("num",1);
                startService(intent);
                break;
            case R.id.dopost:
//                查询某一个论坛的信息
                intent.putExtra("num",2);
                startService(intent);
                break;
        }
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent!=null){
               int flag =  intent.getIntExtra("flag",-1);
                if (flag==1){
                    String error_code = intent.getStringExtra("code_error");
                    if (error_code.equals("0")){
                        list = intent.getParcelableArrayListExtra("list");
                        Log.e("beli","list="+list.toString());
                        Toast.makeText(OkHttpActivity.this,list.toString(),Toast.LENGTH_LONG).show();
                    }else {
//                        查询失败
                    }
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
