package com.example.practice3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnWrite, btnRead;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnRead = findViewById(R.id.read);
        btnWrite = findViewById(R.id.write);
        textView = findViewById(R.id.textView);
        
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outputStream = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = editText.getText().toString();
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(), "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inputStream = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inputStream.read(txt);
                    String str = new String(txt);
                    textView.setText(str);
                    inputStream.close();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
