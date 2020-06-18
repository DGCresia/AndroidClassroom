package com.example.ex02_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;

    ArrayList<String> dataList = getStringList(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.row, R.id.textView, dataList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataList.get(position));
            }
        });

    }

    private ArrayList<String> getStringList(int count) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= count; i++) {
            list.add("리스트 데이터 "+i);
        }
        return list;
    }
}
