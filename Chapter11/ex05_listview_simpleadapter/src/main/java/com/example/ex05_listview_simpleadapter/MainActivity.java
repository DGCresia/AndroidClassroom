package com.example.ex05_listview_simpleadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity{

    TextView textView;
    ListView listView;

    ArrayList<String> titleData = getStringList("title",50);
    ArrayList<String> contentsData = getStringList("contents", 50);
    int[] imagesArray = {R.drawable.kakao01, R.drawable.kakao02, R.drawable.kakao03, R.drawable.kakao04, R.drawable.kakao05, R.drawable.kakao06, R.drawable.kakao07, R.drawable.kakao08, R.drawable.kakao09};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i < titleData.size(); i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("title", titleData.get(i));
            map.put("contents", contentsData.get(i));

            arrayList.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, android.R.layout.simple_list_item_2, new String[]{"title","contents"}, new int[]{android.R.id.text1, android.R.id.text2});

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(titleData.get(position)+", "+contentsData.get(position));
            }
        });

    }

    private ArrayList<String> getStringList(String str, int count) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= count; i++) {
            list.add(str+i);
        }
        return list;
    }

    /*@Override
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
    }*/
}
