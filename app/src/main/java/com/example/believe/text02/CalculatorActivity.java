package com.example.believe.text02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorActivity extends AppCompatActivity {

    @Bind(R.id.edit_input)
    EditText editInput;
    @Bind(R.id.but_c)
    Button butC;
    @Bind(R.id.but_del)
    Button butDel;
    @Bind(R.id.but_chu)
    Button butChu;
    @Bind(R.id.but_cheng)
    Button butCheng;
    @Bind(R.id.but_7)
    Button but7;
    @Bind(R.id.but_8)
    Button but8;
    @Bind(R.id.but_9)
    Button but9;
    @Bind(R.id.but_jian)
    Button butJian;
    @Bind(R.id.but_4)
    Button but4;
    @Bind(R.id.but_5)
    Button but5;
    @Bind(R.id.but_6)
    Button but6;
    @Bind(R.id.but_jia)
    Button butJia;
    @Bind(R.id.but_1)
    Button but1;
    @Bind(R.id.but_2)
    Button but2;
    @Bind(R.id.but_3)
    Button but3;
    @Bind(R.id.but_0)
    Button but0;
    @Bind(R.id.but_dian)
    Button butDian;
    @Bind(R.id.but_equal)
    Button butEqual;
    StringBuffer sb = new StringBuffer();
    String str2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.but_c, R.id.but_del, R.id.but_chu, R.id.but_cheng, R.id.but_7, R.id.but_8, R.id.but_9, R.id.but_jian, R.id.but_4, R.id.but_5, R.id.but_6, R.id.but_jia, R.id.but_1, R.id.but_2, R.id.but_3, R.id.but_0, R.id.but_dian, R.id.but_equal})
    public void onViewClicked(View view) {
        String str = null ;

        switch (view.getId()) {
            case R.id.but_7:
                str = "7";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_8:
                str = "8";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_9:
                str = "9";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_4:
                str = "4";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_5:
                str = "5";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_6:
                str = "6";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_1:
                str = "1";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_2:
                str = "2";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_3:
                str = "3";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_0:
                str = "0";
                sb.append(str);
                editInput.setText(sb);
                break;
            case R.id.but_dian:
                str = ".";
                sb.append(str);
                editInput.setText(sb);
                break;

            case R.id.but_jian:
                str2 = "-";
                sb.append(str2);
                editInput.setText(sb);
                break;
            case R.id.but_jia:
                str2 = "+";
                sb.append(str2);
                editInput.setText(sb);
                break;
            case R.id.but_chu:
                break;
            case R.id.but_cheng:
                break;
            case R.id.but_equal:
                getResult(str2);
                break;

            case R.id.but_c:
                editInput.setText("");
                sb.delete(0,sb.length());
                break;
            case R.id.but_del:

                break;


        }
    }

//    单独运算最后结果
    private void getResult(String type){
        String d1 = null;
        String d2 = null;
        switch (type){
            case "+":
                 d1 = sb.substring(0,sb.indexOf("+"));
                 d2= sb.substring(sb.indexOf("+")+1,sb.length());
                Log.e("beli","d1="+d1+":"+"d2="+d2);

                break;
        }

    }
}
