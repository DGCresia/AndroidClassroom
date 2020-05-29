package com.example.chapter7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button layoutinf;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutinf = findViewById(R.id.layoutinf);
        linear = findViewById(R.id.linear);

        layoutinf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View sampleLayoutView = layoutInflater.inflate(R.layout.sample_layout, null);
                linear.addView(sampleLayoutView);
            }
        });
    }
}
