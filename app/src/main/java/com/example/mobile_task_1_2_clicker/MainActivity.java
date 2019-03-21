package com.example.mobile_task_1_2_clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainBtn;
    Button mainBtn2;
    Button mainBtn3;
    ImageButton imgBtn;

    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainText);
        mainBtn = (Button) findViewById(R.id.button);
        mainBtn2 = (Button) findViewById(R.id.button2);
        mainBtn3 = (Button) findViewById(R.id.button3);
        imgBtn = (ImageButton) findViewById(R.id.imageButton);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score ++;
                String s = "Кнопка нажата " + score;
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };

        mainBtn.setOnClickListener(clickListener);

        View.OnClickListener clickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score --;
                String s = "Кнопка нажата " + score;
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };

        mainBtn2.setOnClickListener(clickListener2);

        View.OnClickListener clickListener3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                String s = "Кнопка нажата " + score;
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };

        mainBtn3.setOnClickListener(clickListener3);

        View.OnClickListener clickListener4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 555;
                String s = "Кнопка нажата " + score;
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };

        imgBtn.setOnClickListener(clickListener4);
    }
}

