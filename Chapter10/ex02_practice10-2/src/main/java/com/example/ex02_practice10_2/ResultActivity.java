package com.example.ex02_practice10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnReturn = findViewById(R.id.btnReturn);
        Intent intent = getIntent();
        String[] imageNames = intent.getStringArrayExtra("nameData");
        int[] voteResult = intent.getIntArrayExtra("voteData");
    }
}
