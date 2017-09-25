package com.example.believe.text02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button button;
    private ImageButton imgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        button = (Button) findViewById(R.id.but_1);
        imgbtn = (ImageButton)findViewById(R.id.img_but);
//        外部类实现按钮点击事件
        button.setOnClickListener(new MyOnclickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(ButtonActivity.this,"我是普通按钮",Toast.LENGTH_SHORT).show();
            }
        });
        imgbtn.setOnClickListener(new MyOnclickListener(){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(ButtonActivity.this,"我是图片按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
class MyOnclickListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {
//        两个按钮共同要做的动作
        Log.w("beli","两个按钮共同要做的动作");
    }
}
