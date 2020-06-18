package com.example.practice4;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear);
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                textView.setText("메뉴1 선택");
                return true;
            case R.id.menu2:
                textView.setText("메뉴2 선택");
                return true;
            case R.id.menu3:
                textView.setText("메뉴3 선택");
                return true;
            case R.id.sub1:
                textView.setText("서브메뉴1 선택");
                return true;
            case R.id.sub2:
                textView.setText("서브메뉴2 선택");
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item, menu);
        return true;
    }
}
