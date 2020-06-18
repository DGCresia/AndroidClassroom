package com.example.ex07_listview_customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<ItemVO> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<ItemVO> dataList) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.row, null);
        }
        ImageView imageViewIcon = convertView.findViewById(R.id.imageViewIcon);
        TextView textViewTitle = convertView.findViewById(R.id.tvTitle);
        TextView textViewContent = convertView.findViewById(R.id.tvContent);
        ImageView imageViewMenu = convertView.findViewById(R.id.imageViewMenu);
        switch (dataList.get(position).getTypeStr()) {
            case "doc":
                imageViewIcon.setImageResource(R.drawable.ic_type_doc);
                break;
            case "img":
                imageViewIcon.setImageResource(R.drawable.ic_type_image);
                break;
            case "file":
                imageViewIcon.setImageResource(R.drawable.ic_type_file);
                break;
            default:
                break;
        }
        textViewTitle.setText(dataList.get(position).getTitleStr());
        textViewContent.setText(dataList.get(position).getContentStr());
        imageViewMenu.setImageResource(R.drawable.ic_menu);

        return convertView;
    }
}
