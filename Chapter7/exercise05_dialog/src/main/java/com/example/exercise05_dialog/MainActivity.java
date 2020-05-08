package com.example.exercise05_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnd1, btnd2, btnd3, btnd4, btnd5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnd1 = findViewById(R.id.btnd1);
        btnd2 = findViewById(R.id.btnd2);
        btnd3 = findViewById(R.id.btnd3);
        btnd4 = findViewById(R.id.btnd4);
        btnd5 = findViewById(R.id.btnd5);

        btnd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("제목입니다");
                builder.setMessage("내용입니다");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.show();
            }
        });

        /*DialogInterface.onClickListener dialogListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("제목입니다")
                        .setMessage("내용입니다")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setNeutralButton("Neutral", dialogListener)
                        .setNegativeButton("Negative", dialogListener)
                        .setPositiveButton("Positive", dialogListener)
                        .show();
            }
        };*/
        btnd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"누가", "오레오", "파이"};
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("좋아하는 버전은?")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setItems(versionArray, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, versionArray[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("닫기", null)
                        .show();
            }
        });
        btnd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"누가", "오레오", "파이"};
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("좋아하는 버전은?")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, versionArray[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("닫기", null)
                        .show();
            }
        });
        btnd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] versionArray = new String[] {"누가", "오레오", "파이"};
                boolean[] checkArray = new boolean[] {true, false, true};
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("좋아하는 버전은?")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setMultiChoiceItems(versionArray, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isCheckde) {
                                if (isCheckde) Toast.makeText(MainActivity.this, versionArray[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("닫기", null)
                        .show();
            }
        });
    }
}
