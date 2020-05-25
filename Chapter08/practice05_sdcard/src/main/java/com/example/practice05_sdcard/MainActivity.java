package com.example.practice05_sdcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnRead, btnWrite;
    TextView textView;
    EditText editText;

    String[] permissionList = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    File appSpecificExternalDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        checkPermissions();

        if (isExternalStorageWritable()) {
            Toast.makeText(this, "외부 저장소 쓰기 가능", Toast.LENGTH_SHORT).show();
        }
        if (isExternalStorageReadable()) {
            Toast.makeText(this, "외부 저장소 읽기 가능", Toast.LENGTH_SHORT).show();
        }

        File[] externalStorageVolumes = ContextCompat.getExternalFilesDirs(this, null);
        File primaryExternalStorage = externalStorageVolumes[0];
        Log.d("MainActivity", String.valueOf(primaryExternalStorage.isFile()));
        Log.d("MainActivity", String.valueOf(primaryExternalStorage.isDirectory()));
        Log.d("MainActivity", primaryExternalStorage.getName());
        Log.d("MainActivity", primaryExternalStorage.getAbsolutePath());
        Log.d("MainActivity", primaryExternalStorage.getPath());
        Log.d("MainActivity", String.valueOf(primaryExternalStorage.canRead()));
        Log.d("MainActivity", String.valueOf(primaryExternalStorage.canWrite()));

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appSpecificExternalDir = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "myDocuments");
                Log.d("MainActivity", appSpecificExternalDir.getAbsolutePath());

                if (appSpecificExternalDir.mkdir() == false) {
                    Log.d("MainActivity", "myDocuments 디렉토리 생성 실패");
                }

                File myDocumentFile1 = new File(appSpecificExternalDir, "document1.txt");
                try (FileOutputStream fos = new FileOutputStream(myDocumentFile1, false)) {
                    fos.write(editText.getText().toString().getBytes());
                    editText.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        /*btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File readFile = new File(appSpecificExternalDir, "document1.txt");
                try (FileInputStream fis = new FileInputStream(readFile)) {
                    int i;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((i=fis.read())!= -1) {
                        stringBuilder.append((char)i);
                    }
                    textView.setText(stringBuilder.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File readFile = new File(appSpecificExternalDir, "document1.txt");
                try (FileReader fileRead = new FileReader(readFile)) {
                    int i;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((i=fileRead.read())!= -1) {
                        stringBuilder.append((char)i);
                    }
                    textView.setText(stringBuilder.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void checkPermissions() {
        for (String permission : permissionList) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, permission+" 권한 없음", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, permissionList, 0);
            }
            else {
                Toast.makeText(this, permission+" 권한 있음", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}