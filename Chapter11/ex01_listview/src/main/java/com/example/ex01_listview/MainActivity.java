package com.example.ex01_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

//    String[] dataArray = getStringArray(100);
    ArrayList<String> dataList = getStringList(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, dataList);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataList.get(position));
            }
        });

    }

    private String[] getStringArray(int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = "배열 데이터 "+(i+1);
        }
        return strings;
    }

    private ArrayList<String> getStringList(int count) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= count; i++) {
            list.add("리스트 데이터 "+i);
        }
        return list;
    }
}
