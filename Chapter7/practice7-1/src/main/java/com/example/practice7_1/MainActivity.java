package com.example.practice7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("배경색 바꾸기");
        linear = findViewById(R.id.linear);
        btn = findViewById(R.id.btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                linear.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:
                linear.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:
                linear.setBackgroundColor(Color.BLUE);
                break;
            case R.id.subRotate:
                btn.setRotation(btn.getRotation()+45);
                break;
            case R.id.subSizeUp:
                btn.setScaleX(btn.getScaleX() * 2);
                btn.setScaleY(btn.getScaleY() * 2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
