package com.example.ex07_listview_customadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    Button btnAdd;

    ArrayList<ItemVO> dataList = new ArrayList<ItemVO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);

        dataList.add(new ItemVO("doc", "Document 1", "Sample Data"));
        dataList.add(new ItemVO("img", "Image 1", "Sample Data"));
        dataList.add(new ItemVO("file", "File 1", "Sample Data"));

        final CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(dataList.get(position).getTitleStr());
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                final View view = inflater.inflate(R.layout.alertdialog_view, null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("리스트 아이템 추가")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String type = null, title, content;

                                int checkedId = ((RadioGroup)view.findViewById(R.id.radioGroup)).getCheckedRadioButtonId();

                                switch (checkedId) {
                                    case R.id.rbDoc:
                                        type = "doc";
                                        break;
                                    case R.id.rbImg:
                                        type = "img";
                                        break;
                                    case R.id.rbFile:
                                        type = "file";
                                        break;
                                    default:
                                        break;
                                }
                                title = ((EditText)view.findViewById(R.id.editTextTitle)).getText().toString();
                                content = ((EditText)view.findViewById(R.id.editTextContent)).getText().toString();
                                dataList.add(new ItemVO(type, title, content));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
    }
}
