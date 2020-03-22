package com.example.lsy_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    int add = 0,timer = 1;
    private TextView textView,textView2;
    private Button button,button2;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.number);
        textView2 = findViewById(R.id.textView2);
        checkBox = findViewById(R.id.checkBox);

        checkBox.setOnClickListener(L4_checkBox_listener);



        button.setOnClickListener(L2_button_listener);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar progressBar=(ProgressBar)findViewById(R.id.progressBar);//获取控件
                if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                    button2.setText("开始");
                    textView2.setText("暂停中...");

                    add = 0;

                }
                else{

                    add = timer;
                    button2.setText("暂停");
                    textView2.setText("计数中...");

                    progressBar.setVisibility(View.GONE);//setVisibility设置控件可见性
                    //View.GONE不可见 View.VISIBLE可见 View.INVISIBLE透明性质，不可见在还占空间
                }
            }
        });

    }

    CheckBox.OnClickListener L4_checkBox_listener = new CheckBox.OnClickListener(){
        @Override
        public void onClick(View v) {


            if (timer == 1)
                timer = 2;
            else
                timer = 1;

            if(add != 0)
                add = timer;
        }
    };

    Button.OnClickListener L2_button_listener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
             count += add;
             textView.setText(count+"");
        }
    };


}
