package com.example.fragment02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button showfrag01, showfrag02;
    LinearLayout linear;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showfrag01 = findViewById(R.id.showfrag01);
        showfrag02 = findViewById(R.id.showfrag02);
        linear = findViewById(R.id.linear);

        fragmentManager = getSupportFragmentManager();
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        showfrag01.setOnClickListener(this);
        showfrag02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showfrag01:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linear, fragmentOne);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.showfrag02:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linear, fragmentTwo);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
