package com.example.ex06_example10_20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDial, btnWeb, btnMap, btnSearch, btnSms, btnPhoto, btnIntentTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnWeb = findViewById(R.id.btnWeb);
        btnMap = findViewById(R.id.btnMap);
        btnSearch = findViewById(R.id.btnSearch);
        btnSms = findViewById(R.id.btnSms);
        btnPhoto = findViewById(R.id.btnPhoto);
        btnIntentTest = findViewById(R.id.intentFilter);

        btnIntentTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.ex06_example10_20.ACTION_VIEW");
                startActivity(intent);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()) {
                    case R.id.btnDial:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"));
                        startActivity(intent);
                        break;
                    case R.id.btnWeb:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hanbit.co.kr"));
                        startActivity(intent);
                        break;
                    case R.id.btnMap:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/peD4WmXHHEavp4487"));
                        startActivity(intent);
                        break;
                    case R.id.btnSearch:
                        intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY, "광주소프트웨어마이스터고등학교");
                        startActivity(intent);
                        break;
                    case R.id.btnSms:
                        intent = new Intent(Intent.ACTION_SENDTO);
                        intent.putExtra("sms_body", "안녕하세요?");
                        intent.setData(Uri.parse("smsto : "+Uri.encode("010-1234-4567")));
                        startActivity(intent);
                        break;
                    case R.id.btnPhoto:
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        };

        btnDial.setOnClickListener(listener);
        btnWeb.setOnClickListener(listener);
        btnMap.setOnClickListener(listener);
        btnSearch.setOnClickListener(listener);
        btnSms.setOnClickListener(listener);
        btnPhoto.setOnClickListener(listener);
    }
}
