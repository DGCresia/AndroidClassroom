package com.example.exercise01_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "Java 코드에서 추가한 메뉴");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                tv.setText("메뉴1이 선택됨.");
                break;
            case R.id.item2:
                tv.setText("메뉴2이 선택됨.");
                break;
            case R.id.item3:
                tv.setText("메뉴3이 선택됨.");
                break;
            case R.id.subitem1:
                tv.setText("서브메뉴1이 선택됨.");
                break;
            case R.id.subitem2:
                tv.setText("서브메뉴2이 선택됨.");
                break;
        }

        return true;
    }
}
