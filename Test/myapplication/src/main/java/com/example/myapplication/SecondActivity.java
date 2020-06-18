package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.service.media.MediaBrowserService;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    RadioButton radio1, radio2;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("2104류가미");

        textView = findViewById(R.id.textView);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        btnReturn = findViewById(R.id.btnReturn);

        Intent inIntent = getIntent();
        textView.setText(inIntent.getStringExtra("EditText"));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (v.getId()) {
                    case R.id.radio1:
                        Uri uri = Uri.parse("tel:0629496800");
                        intent = new Intent(Intent.ACTION_DIAL, uri);
                        startActivityForResult(intent, 1);
                        break;
                    case R.id.radio2:
                        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                        startActivityForResult(intent, 1);
                        break;
                    case R.id.btnReturn:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
        radio1.setOnClickListener(listener);
        radio2.setOnClickListener(listener);
        btnReturn.setOnClickListener(listener);
    }
}
