package com.example.ex05_diy10_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editNum1, editNum2;
    Button btnCalc;
    RadioButton plus, minus, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        btnCalc = findViewById(R.id.btnCalc);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        setContentView(R.layout.activity_main);

        /*View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.plus:
                        break;
                    case R.id.minus:
                        break;
                    case R.id.mul:
                        break;
                    case R.id.div:
                        break;
                    case R.id.btnCalc:
                        break;
                    default:
                        break;
                }
            }
        };*/
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(editNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(editNum2.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            int result = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "계산 결과 : "+result, Toast.LENGTH_SHORT).show();
        }
    }


}
