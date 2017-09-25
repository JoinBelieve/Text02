package com.example.believe.text02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToggleButtonActivity extends AppCompatActivity {

    @Bind(R.id.toggleButton)
    ToggleButton toggleButton;
    @Bind(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        ButterKnife.bind(this);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /*
                    buttonView:代表被点击控件的本身
                    isChecked：代表点击的控件的状态
                    当点击这个tb得时候，更换img的背景
                 */

                image.setBackgroundResource(isChecked?R.mipmap.img2:R.mipmap.img1);
            }
        });
    }


}
