package com.example.believe.text02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoCompleteTextViewActivity extends AppCompatActivity {
    private AutoCompleteTextView AtextView;
    private MultiAutoCompleteTextView MtextView;
    private String[] texts = {
      "我是本文",
            "天津",
            "北京",
            "福建",
            "四川",
            "湖南",
            "湖北"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        /**
         * 第一步：初始化控件
         * 第二步:需要一个适配器
         * 第三步：初始化数据源--这数据源去匹配文本框输入的内容
         * 第四步：将adapter与当前AutoCompleteTextView绑定
         */
        AtextView = (AutoCompleteTextView) findViewById(R.id.complete_textview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
                ,android.R.layout.simple_list_item_1,texts);
        AtextView.setAdapter(adapter);

        /**
         * 第一步：初始化控件
         * 第二步:需要一个适配器
         * 第三步：初始化数据源--这数据源去匹配文本框输入的内容
         * 第四步：将adapter与当前AutoCompleteTextView绑定
         * 第五步：设置分隔符
         */
        MtextView = (MultiAutoCompleteTextView) findViewById(R.id.multi_textView);
        MtextView.setAdapter(adapter);
//        设置以逗号为分隔符为结束符号
        MtextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
