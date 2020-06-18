package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button plus, minus, mul, div;
    TextView textView;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2104류가미");

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        textView = findViewById(R.id.tv);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.plus:
                        result = Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString());
                        textView.setText("계산결과: "+result);
                        break;
                    case R.id.minus:
                        result = Integer.parseInt(et1.getText().toString()) - Integer.parseInt(et2.getText().toString());
                        textView.setText("계산결과: "+result);
                        break;
                    case R.id.mul:
                        result = Integer.parseInt(et1.getText().toString()) * Integer.parseInt(et2.getText().toString());
                        textView.setText("계산결과: "+result);
                        break;
                    case R.id.div:
                        result = Double.parseDouble(et1.getText().toString()) / Double.parseDouble(et2.getText().toString());
                        textView.setText("계산결과: "+result);
                        break;
                    default:
                        break;
                }
            }
        };
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        mul.setOnClickListener(listener);
        div.setOnClickListener(listener);
    }
}
