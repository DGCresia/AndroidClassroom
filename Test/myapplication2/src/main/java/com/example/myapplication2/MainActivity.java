package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnAdd, btnEdit, btnDel;
    ListView listView;

    int selNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.selectedListItem);
        btnAdd = findViewById(R.id.addBtn);
        btnEdit = findViewById(R.id.editBtn);
        btnDel = findViewById(R.id.delBtn);
        listView = findViewById(R.id.listView);

        final ArrayList<String> dataset = new ArrayList<>();
        dataset.add("리스트 데이터 1"); dataset.add("리스트 데이터 2");
        dataset.add("리스트 데이터 3"); dataset.add("리스트 데이터 4");
        dataset.add("리스트 데이터 5");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, dataset);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataset.get(position));
                selNum = position;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.add("리스트 데이터 "+(dataset.size()+1));
                adapter.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                final EditText et = new EditText(getApplicationContext());
                builder.setTitle("리스트 아이템 수정")
                        .setMessage(dataset.get(selNum))
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(et)
                        .setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataset.add(selNum, et.getText().toString());
                                dataset.remove(selNum+1);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.remove(selNum);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
