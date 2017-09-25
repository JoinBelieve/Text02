package com.example.believe.text02.okHttpText;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.believe.text02.R;
import com.example.believe.text02.service.MyMessageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AddMessageActivity extends AppCompatActivity {

    @Bind(R.id.edit_title)
    EditText editTitle;
    @Bind(R.id.type)
    Spinner spinner;
    @Bind(R.id.edit_content)
    EditText editContent;
    @Bind(R.id.add)
    Button add;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private int mPosition;
    private MyBroadcast receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);
        ButterKnife.bind(this);
        if (receiver==null){
            receiver = new MyBroadcast();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("com.beli.addMessageAction");
            registerReceiver(receiver,intentfilter);
        }
        initData();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AddMessageActivity.this,"你选择的是"+list.get(position),Toast.LENGTH_SHORT).show();
                mPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String content = editContent.getText().toString();
                Log.e("beli",title+"/"+content);
                if (!title.equals("")&&!content.equals("")){
                    Intent intent = new Intent(AddMessageActivity.this, MyMessageService.class);
                    intent.putExtra("num",0);
                    intent.putExtra("title",title);
                    intent.putExtra("content",content);
                    intent.putExtra("type",list.get(mPosition));
                    startService(intent);
                }else {
                    Toast.makeText(AddMessageActivity.this,"标题或内容不能为空",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private void initData() {
        list = new ArrayList<String>();
        list.add("猫星人");
        list.add("阿拉斯加");
        list.add("柯基");
        list.add("吉娃娃");
    }
//注册广播
    private class MyBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent!=null){
                String code_error = intent.getStringExtra("code_error");
                if (code_error.equals("0")){
                    Toast.makeText(AddMessageActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
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
