package com.example.example6_13_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.linearlayout1);

        for (int i = 0; i < 100; i++) {
            Button btn = new Button(this);
            btn.setTextSize(30);
            btn.setText("버튼"+String.valueOf(i+1));
            linearLayout.addView(btn);
        }
    }
}
