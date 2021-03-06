package com.example.ex06_listview_customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd;
    ListView listView;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);
        dataList = getDataArrayList(5);

        final CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "문자를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                dataList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        }); 
    }

    private ArrayList<String> getDataArrayList(int count) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 1; i <= count; i++) {
            arrayList.add("리스트 아이템 "+i);
        }
        return arrayList;
    }
}
