package com.example.ex03_listview_addmodifydelete;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    TextView textView;
    ListView listView;
    Button btnAdd, btnModify, btnDelete;

    ArrayList<String> dataList = getStringList(5);
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnModify = findViewById(R.id.btnModify);
        btnDelete = findViewById(R.id.btnDelete);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, dataList);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataList.get(position));
            }
        });

        btnAdd.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

    }

    private ArrayList<String> getStringList(int count) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= count; i++) {
            list.add("리스트 데이터 "+i);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        final int checkedIndex = listView.getCheckedItemPosition();
        switch (v.getId()) {
            case R.id.btnAdd:
                int count = adapter.getCount();
                dataList.add("리스트 데이터 "+(count+1));
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnModify:
                final EditText editText = new EditText(getApplicationContext());
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("리스트 아이템 수정")
                        .setMessage("현재 데이터 : "+dataList.get(checkedIndex))
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(editText)
                        .setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataList.set(checkedIndex, editText.getText().toString());
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                break;
            case R.id.btnDelete:
                dataList.remove(checkedIndex);
                break;
            default:
                break;
        }
        adapter.notifyDataSetChanged();
        listView.clearChoices();
    }
}
