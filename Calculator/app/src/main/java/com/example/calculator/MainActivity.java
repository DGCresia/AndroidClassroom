package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button add, sub, mul, div;
    TextView textresult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Calculator");

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        mul = (Button)findViewById(R.id.mul);
        div = (Button)findViewById(R.id.div);
        textresult = (TextView)findViewById(R.id.result);

        View.OnClickListener listner = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.add:
                        num1 = et1.getText().toString();
                        num2 = et2.getText().toString();
                        result = Integer.parseInt(num1) + Integer.parseInt(num2);
                        textresult.setText("계산 결과(더하기) : "+result.toString());
                        break;
                    case R.id.sub:
                        num1 = et1.getText().toString();
                        num2 = et2.getText().toString();
                        result = Integer.parseInt(num1) - Integer.parseInt(num2);
                        textresult.setText("계산 결과(빼기) : "+result.toString());
                        break;
                    case R.id.mul:
                        num1 = et1.getText().toString();
                        num2 = et2.getText().toString();
                        result = Integer.parseInt(num1) * Integer.parseInt(num2);
                        textresult.setText("계산 결과(곱하기) : "+result.toString());
                        break;
                    case R.id.div:
                        num1 = et1.getText().toString();
                        num2 = et2.getText().toString();
                        result = Integer.parseInt(num1) / Integer.parseInt(num2);
                        textresult.setText("계산 결과(나누기) : "+result.toString());
                        break;
                }
            }
        };

        add.setOnClickListener(listner);
        sub.setOnClickListener(listner);
        mul.setOnClickListener(listner);
        div.setOnClickListener(listner);

        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for (i = 0; i < numBtnIDs.length; i++) {
            final int index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et1.isFocused() == true) {
                        num1 = et1.getText().toString() + numButtons[index].getText().toString();
                        et1.setText(num1);
                    }
                    else if (et1.isFocused() == true) {
                        num2 = et2.getText().toString() + numButtons[index].getText().toString();
                        et2.setText(num2);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
