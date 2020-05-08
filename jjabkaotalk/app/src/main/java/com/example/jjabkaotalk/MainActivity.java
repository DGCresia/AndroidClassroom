package com.example.jjabkaotalk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout mylinear, f1linear, f2linear;
    TextView myName, myMsg;
    View dialog;
    EditText input;
    int selectFriends = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mylinear = findViewById(R.id.my);
        f1linear = findViewById(R.id.f1);
        f2linear = findViewById(R.id.f2);

        registerForContextMenu(mylinear);
        registerForContextMenu(f1linear);
        registerForContextMenu(f2linear);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.om_daf:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setMessage("친구를 모두 삭제하시겠습니까?");
                dlg.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        f1linear.setVisibility(View.GONE);
                        f2linear.setVisibility(View.GONE);
                    }
                });
                dlg.setNegativeButton("아니요", null);
                return true;
            case R.id.om_raf:
                f1linear.setVisibility(View.VISIBLE);
                f2linear.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == mylinear) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.my_context_menu, menu);
        }
        else if (v == f1linear) {
            selectFriends = 1;
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.friends_context_menu, menu);
        }
        else if (v == f2linear) {
            selectFriends = 2;
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.friends_context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mcm_cN:
                dialog = (View)View.inflate(MainActivity.this, R.layout.input_dialog, null);
                AlertDialog.Builder changeName = new AlertDialog.Builder(MainActivity.this);
                changeName.setTitle("이름을 입력하세요");
                changeName.setView(dialog);
                changeName.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        input = (EditText)dialog.findViewById(R.id.inputArea);
                        myName = (TextView)findViewById(R.id.myName);
                        myName.setText(input.getText().toString());
                    }
                });
                changeName.setNegativeButton("취소", null);
                return true;
            case R.id.mcm_cM:
                dialog = (View)View.inflate(MainActivity.this, R.layout.input_dialog, null);
                AlertDialog.Builder changeMsg = new AlertDialog.Builder(MainActivity.this);
                changeMsg.setTitle("이름을 입력하세요");
                changeMsg.setView(dialog);
                changeMsg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        input = (EditText)dialog.findViewById(R.id.inputArea);
                        myName = (TextView)findViewById(R.id.myName);
                        myName.setText(input.getText().toString());
                    }
                });
                return true;case
                    R.id.fcm_cN:
                if(selectFriends == 1)
                    f1linear.setVisibility(View.GONE);
                if(selectFriends == 2)
                    f2linear.setVisibility(View.GONE);
                return true;
            default:
                return super.onContextItemSelected(item);

            default:
                return super.onContextItemSelected(item);
        }
    }
}
