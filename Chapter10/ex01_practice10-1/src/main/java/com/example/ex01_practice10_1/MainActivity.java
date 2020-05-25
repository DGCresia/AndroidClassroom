package com.example.ex01_practice10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton selectSecond, selectThird;
    boolean num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewActivity = findViewById(R.id.btnNewActivity);

        selectSecond = findViewById(R.id.selectSecond);
        selectThird = findViewById(R.id.selectThird);

        selectSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = true;
            }
        });
        selectThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = false;
            }
        });

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
