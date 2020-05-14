package com.example.practice01_intenalmemoryfileinputoutput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

    Button btnWrite, btnRead;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnWrite:
                        FileOutputStream fos = null;
                        try {
                            fos = openFileOutput("myText.txt", Context.MODE_PRIVATE);

                            String string = editText.getText().toString();
                            fos.write(string.getBytes());

                            Toast.makeText(MainActivity.this, "myFile.txt에 문자열 써짐", Toast.LENGTH_SHORT).show();
                            editText.setText(null);
                        }catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                fos.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case R.id.btnRead:
                        try (FileInputStream fis = new FileInputStream(getFileStreamPath("myFile.txt"))) {

                            /*textView.setText(String.valueOf(fis.read()));
                            String str = "";
                            int temp;
                            while ((temp=fis.read()) != -1) {
                                str += (char)fis.read();
                            }
                            textView.setText(str);*/

                            byte[] byteArray = new byte[20];
                            fis.read(byteArray);
                            textView.setText(new String(byteArray));

                        }catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        };
        btnWrite.setOnClickListener(listener1);
        btnRead.setOnClickListener(listener1);
    }
}
