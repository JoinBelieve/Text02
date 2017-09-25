package com.example.believe.text02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.but1)
    Button but1;
    @Bind(R.id.but2)
    Button but2;
    @Bind(R.id.but3)
    Button but3;
    @Bind(R.id.but4)
    Button but4;
    @Bind(R.id.but5)
    Button but5;
    @Bind(R.id.but6)
    Button but6;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn1 = (Button) findViewById(R.id.but1);
        btn2 = (Button) findViewById(R.id.but2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AutoCompleteTextView
                Intent intent = new Intent(MainActivity.this, AutoCompleteTextViewActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });
    }


    @OnClick({R.id.but3, R.id.but4, R.id.but5, R.id.but6})
    public void onViewClicked(View view) {
        Intent intent = null ;
        switch (view.getId()) {
            case R.id.but3:
                intent = new Intent(MainActivity.this,ToggleButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.but4:
                intent = new Intent(MainActivity.this,CheckBoxActivity.class);
                startActivity(intent);
                break;
            case R.id.but5:
                intent = new Intent(MainActivity.this,CalculatorActivity.class);
                startActivity(intent);
                break;
            case R.id.but6:
//                okHttp网络框架
                intent = new Intent(MainActivity.this,OkHttpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
