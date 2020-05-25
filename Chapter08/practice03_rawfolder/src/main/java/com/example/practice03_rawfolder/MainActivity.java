package com.example.practice03_rawfolder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button btnISR, btnBR;
    TextView textView;
    Long startTime, endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnISR = findViewById(R.id.btnISR);
        btnBR = findViewById(R.id.btnBR);
        textView = findViewById(R.id.textView);

        btnISR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try(InputStreamReader inputStreamReader = new InputStreamReader(getResources().openRawResource(R.raw.android))) {
                    startTime = System.currentTimeMillis();
                    int i;
                    StringBuilder stringBuilder = new StringBuilder();
                    while((i = inputStreamReader.read()) != -1) {
                        stringBuilder.append((char)i);
                    }
                    endTime = System.currentTimeMillis();
                    Toast.makeText(MainActivity.this, String.format("%d ms", endTime-startTime), Toast.LENGTH_SHORT).show();
                    textView.setText(stringBuilder.toString());
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnBR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.android)))) {
                    startTime = System.currentTimeMillis();
                    int i;
                    StringBuilder stringBuilder = new StringBuilder();
                    while((i = bufferedReader.read()) != -1) {
                        stringBuilder.append((char)i);
                    }
                    endTime = System.currentTimeMillis();
                    Toast.makeText(MainActivity.this, String.format("%d ms", endTime-startTime), Toast.LENGTH_SHORT).show();
                    textView.setText(stringBuilder.toString());
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
