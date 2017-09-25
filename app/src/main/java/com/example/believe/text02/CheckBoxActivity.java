package com.example.believe.text02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CheckBoxActivity extends AppCompatActivity {

    @Bind(R.id.checkbox1)
    CheckBox checkbox1;
    @Bind(R.id.checkbox2)
    CheckBox checkbox2;
    @Bind(R.id.checkbox3)
    CheckBox checkbox3;
    @Bind(R.id.checkbox4)
    CheckBox checkbox4;
    @Bind(R.id.checkbox5)
    CheckBox checkbox5;
    @Bind(R.id.checkbox6)
    CheckBox checkbox6;
    @Bind(R.id.check_but)
    Button checkBut;
    @Bind(R.id.check_text)
    TextView checkText;
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);
        checkbox1.setOnCheckedChangeListener(new MyCheckedChangeListener());
        checkbox2.setOnCheckedChangeListener(new MyCheckedChangeListener());
        checkbox3.setOnCheckedChangeListener(new MyCheckedChangeListener());
        checkbox4.setOnCheckedChangeListener(new MyCheckedChangeListener());
        checkbox5.setOnCheckedChangeListener(new MyCheckedChangeListener());
        checkbox6.setOnCheckedChangeListener(new MyCheckedChangeListener());
        checkBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    checkText.setText(list.toString());

            }
        });
    }


    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                //获得checkedBox的文本内容
                String text1 = buttonView.getText().toString();
                list.add(text1);
            } else {
                list.remove(buttonView.getText());
            }
        }
    }
}
