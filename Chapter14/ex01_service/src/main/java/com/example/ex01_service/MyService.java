package com.example.ex01_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("test", "서비스 시작");
        Toast.makeText(this, "서비스 시작", Toast.LENGTH_SHORT).show();
        ThreadClass thread = new ThreadClass();
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("test", "서비스 종료");
        Toast.makeText(this, "서비스 종료", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class ThreadClass extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                SystemClock.sleep(1000);
                long time = System.currentTimeMillis();
                Log.d("test", "Service Running... " + time);
            }
        }
    }
}
