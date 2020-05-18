package com.example.practice02_practice8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editText;
    Button btnWriter;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        btnWriter = findViewById(R.id.button);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = String.format("%d_%d_%d.txt", year, monthOfYear, dayOfMonth);
                String str = readDiary(fileName);
                editText.setText(str);
                btnWriter.setEnabled(true);
            }
        });
        btnWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editText.getText().toString();
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(), fileName+"이 저장됨", Toast.LENGTH_SHORT).show();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private String readDiary(String fileName) {
        String diaryStr = null;
        FileInputStream inputStream;
        try {
            inputStream = openFileInput(fileName);
            byte[] txt = new byte[500];
            inputStream.read(txt);
            inputStream.close();
            diaryStr = (new String(txt)).trim();
            btnWriter.setText("수정하기");
        }catch (IOException e) {
            editText.setHint("일기 없음");
            btnWriter.setText("새로 저장");
        }
        return diaryStr;
    }
}
