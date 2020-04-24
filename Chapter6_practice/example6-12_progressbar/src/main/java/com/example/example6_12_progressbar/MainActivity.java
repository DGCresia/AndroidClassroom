package com.example.example6_12_progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressbar;
    SeekBar seekbar;
    RatingBar ratingbar;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressbar = findViewById(R.id.progressbar2);
        seekbar = findViewById(R.id.seekbar);
        ratingbar = findViewById(R.id.ratingbar);
        textview = findViewById(R.id.textview);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textview.setText(String.valueOf(progress));
                progressbar.setProgress(progress);
                ratingbar.setRating(progress/20);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
