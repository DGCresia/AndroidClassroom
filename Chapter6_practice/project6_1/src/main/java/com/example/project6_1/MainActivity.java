package com.example.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    RadioButton rdocal, rdotime;
    DatePicker dateview;
    TimePicker timepick;
    TextView tvyear, tvmonth, tvday, tvhour, tvminute;
    LinearLayout linear;
    int selyear, selmonth, selday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = findViewById(R.id.chrono);
        rdocal = findViewById(R.id.rdocal);
        rdotime = findViewById(R.id.rdoTime);
        timepick = findViewById(R.id.timepick1);
        dateview = findViewById(R.id.dateview);
        tvyear = findViewById(R.id.tvyear);
        tvmonth = findViewById(R.id.tvmonth);
        tvday = findViewById(R.id.tvday);
        tvhour = findViewById(R.id.tvhour);
        tvminute = findViewById(R.id.tvminute);
        linear = findViewById(R.id.linear);

        rdotime.setVisibility(View.INVISIBLE);
        rdocal.setVisibility(View.INVISIBLE);
        timepick.setVisibility(View.INVISIBLE);
        dateview.setVisibility(View.INVISIBLE);

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdocal.setVisibility(View.VISIBLE);
                rdotime.setVisibility(View.VISIBLE);
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        rdocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepick.setVisibility(View.INVISIBLE);
                dateview.setVisibility(View.VISIBLE);
            }
        });

        rdotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepick.setVisibility(View.VISIBLE);
                dateview.setVisibility(View.INVISIBLE);
            }
        });

        linear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rdotime.setVisibility(View.INVISIBLE);
                rdocal.setVisibility(View.INVISIBLE);
                timepick.setVisibility(View.INVISIBLE);
                dateview.setVisibility(View.INVISIBLE);
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                tvyear.setText(Integer.toString(selyear));
                tvmonth.setText(Integer.toString(selmonth));
                tvday.setText(Integer.toString(selday));
                tvhour.setText(Integer.toString(timepick.getCurrentHour()));
                tvminute.setText(Integer.toString(timepick.getCurrentMinute()));
                tvminute.setText(Integer.toString(timepick.getCurrentMinute()));
                return false;
            }
        });

        dateview.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                selyear = year;
                selmonth = monthOfYear;
                selday = dayOfMonth;
            }
        });

    }
}
