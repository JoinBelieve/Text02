package com.example.believe.text02.service;

import android.app.IntentService;
import android.content.Intent;
import android.media.audiofx.LoudnessEnhancer;
import android.util.Log;
import android.view.View;

import com.example.believe.text02.globle.Conf;
import com.example.believe.text02.pojo.uMessage;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyMessageService extends IntentService {
    //    1.拿到OkHttpClient对象
    private OkHttpClient client = new OkHttpClient();
    public MyMessageService() {
        super("MyMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            int num = intent.getIntExtra("num",-1);
            if (num==0){
//                添加论坛信息
                String title = intent.getStringExtra("title");
                String content = intent.getStringExtra("content");
                String type = intent.getStringExtra("type");
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//                自定义的一个用户名,实际使用要获取当前登录的用户名
                String uName = "丹丹";
                addMessage(title,content,type,uName,time);
            }else if (num==1){
//                查询所有
                selectAllMessage();
            }else if (num ==2){
//                查询一个
                selectOneMessage();
            }
        }
    }
    public void selectOneMessage() {
//        id会变得
        String url = "http://"+ Conf.IP+":8080/GraduationProject/pages/selectOneMessageActionByJson";
        FormBody body = new FormBody.Builder()
                .add("id","8")
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.e("beli",res);
            }
        });
    }

    public void addMessage(String title,String content,String type,String uName,String time){

        String url = "http://"+ Conf.IP+":8080/GraduationProject/pages/addMessageActionByJson";
//        填写请求体
        FormBody body = new FormBody.Builder()
                .add("title", title)
                .add("time", time)
                .add("content", content)
                .add("type", type)
                .add("uName", uName)
                .build();

        Request.Builder builder = new Request.Builder();
        Request request = builder
                .post(body)
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //                执行完成
                Log.e("beli", "onResponse:");
                String res = response.body().string();
                try {
                    JSONObject root = new JSONObject(res);
                    Log.e("beli", res);
                    String code_error = root.getString("code_error");
                    Intent intent = new Intent("com.beli.addMessageAction");
                    intent.putExtra("code_error",code_error);
                    sendBroadcast(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void selectAllMessage() {

//        2.构造Request
        Request.Builder builder = new Request.Builder();

        Request request = builder
                .get()
                .url("http://"+ Conf.IP+":8080/GraduationProject/pages/selectAllMessageActionByJson")
                .build();
//        3.将Request封装为call
        Call call = client.newCall(request);
//        4.执行call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("beli", "onFailure:" + e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                执行完成
                Log.e("beli", "onResponse:");
                String res = response.body().string();
//                Log.e("beli", res);
                try {
                    Gson gson = new Gson();
                    ArrayList<uMessage> list = new ArrayList<uMessage>();
                    JSONObject root = new JSONObject(res);
                    String code_error = root.getString("code_error");
                    Intent intent = new Intent("com.beli.message");
                    intent.putExtra("flag",1);
                    intent.putExtra("code_error",code_error);
                    if (code_error.equals("0")){
                        String messages = root.getString("messages");
                        uMessage[] msg = gson.fromJson(messages,uMessage[].class);
                        for (uMessage m : msg){
                            list.add(m);
                        }
                        intent.putParcelableArrayListExtra("list",list);

                    }
                    sendBroadcast(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
