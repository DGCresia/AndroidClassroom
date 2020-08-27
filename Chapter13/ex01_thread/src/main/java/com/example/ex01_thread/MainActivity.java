package com.example.ex01_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button btnThread;
    ProgressBar progressBar1, progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        btnThread = findViewById(R.id.btnThread);

        //region 1.
        /*btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 100; i++) {
                    progressBar1.setProgress(progressBar1.getProgress()+2);
                    progressBar2.setProgress(progressBar2.getProgress()+1);
                    SystemClock.sleep(100);
                }
            }
        });*/
        //endregion

        //region 2.
        /*btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressThread pt1 = new ProgressThread(progressBar1, 2);
                pt1.start();

                ProgressThread pt2 = new ProgressThread(progressBar2, 1);
                pt2.start();
            }
        });*/
        //endregion

        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = progressBar1.getProgress(); i <= 100; i++) {
                            progressBar1.setProgress(progressBar1.getProgress()+2);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread() {
                    @Override
                    public void run() {
                        for (int i = progressBar2.getProgress(); i <= 100; i++) {
                            progressBar2.setProgress(progressBar2.getProgress()+1);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });

        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = progressBar1.getProgress(); i <= 100; i++) {
                            progressBar1.setProgress(progressBar1.getProgress() + 2);
                            SystemClock.sleep(100);
                        }
                    }
                }.run();
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = progressBar1.getProgress(); i <= 100; i++) {
                            progressBar1.setProgress(progressBar1.getProgress() + 2);
                            SystemClock.sleep(100);
                        }
                    }
                }.run();
            }
        });
    }

    private class ProgressThread extends Thread {
        ProgressBar progressBar;
        int increaseValue;

        public ProgressThread(ProgressBar progressBar, int increaseValue) {
            this.progressBar = progressBar;
            this.increaseValue = increaseValue;
        }

        @Override
        public void run() {
            for (int i = progressBar.getProgress(); i <= 100; i++) {
                progressBar.setProgress(progressBar.getProgress()+increaseValue);
                SystemClock.sleep(100);
            }
        }
    }
}
