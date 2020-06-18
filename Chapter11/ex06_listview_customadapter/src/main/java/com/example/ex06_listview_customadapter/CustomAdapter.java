package com.example.ex06_listview_customadapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<String> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<String> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, null);
        }
        TextView textView = convertView.findViewById(R.id.textViewRow);
        textView.setText(dataList.get(position));
        Button btnModify = convertView.findViewById(R.id.btnModify);
        final Button btnDelete = convertView.findViewById(R.id.btnDelete);

        //region btnModify
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(context);
                new AlertDialog.Builder(context)
                        .setTitle("리스트 아이템 수정")
                        .setMessage("현재 데이터: "+dataList.get(position))
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(editText)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataList.set(position, editText.getText().toString());
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
        //endregion

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("리스트 아이템 삭제")
                        .setMessage("현재 데이터를 삭제하시겠습니까?")
                        .setIcon(R.mipmap.ic_launcher_remove)
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataList.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
        return null;
    }
}