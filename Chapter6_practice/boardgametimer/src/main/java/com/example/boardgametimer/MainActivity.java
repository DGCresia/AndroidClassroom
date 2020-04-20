package com.example.boardgametimer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //region
    EditText editText;
    Button timer, reset, pauseRestart;
    TextView corpyright;
    CountDownTimer countDownTimer;
    long fullTime, halfTime;
    boolean isPaused;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isPaused = false;

        //region
        editText = findViewById(R.id.editTextEnteredSeconds);
        timer = findViewById(R.id.btnTimerSwitch);
        reset = findViewById(R.id.btnReset);
        pauseRestart = findViewById(R.id.btnPauseRestart);
        corpyright = findViewById(R.id.textViewCopyright);
        //endregion

        //region
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer.create(getApplicationContext(), R.raw.bell_sound2).start();

                cancelTimer();
                resetTimer();

                countDownTimer = countDownTimer(fullTime);
                countDownTimer.start();
            }
        });
        //endregion

        //region
        reset.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                resetTimer();
                cancelTimer();

                timer.setEnabled(true);
                return false;
            }
        });
        //endregion

        //region
        pauseRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPaused == true) {
                    pauseRestart.setText(R.string.pause);
                    countDownTimer = countDownTimer(Long.parseLong(timer.getText().toString()));
                    countDownTimer.start();
                    isPaused = false;
                }
                else {
                    countDownTimer.cancel();
                    pauseRestart.setText(R.string.restart);
                    isPaused = true;
                }
            }
        });
    }

    private CountDownTimer countDownTimer(long t) {
        return new CountDownTimer(t*1000+1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long currentTime = millisUntilFinished/1000;
                timer.setText(String.valueOf(currentTime));
            }

            @Override
            public void onFinish() {
                timer.setBackgroundColor(Color.LTGRAY);
                timer.setTextColor(Color.GRAY);
                MediaPlayer.create(getApplicationContext(), R.raw.gameover_sound).start();
                timer.setEnabled(false);
            }
        };
    }

    private void cancelTimer() {
        if (countDownTimer != null) countDownTimer.cancel();
    }

    private void resetTimer() {
        fullTime = Long.parseLong(editText.getText().toString());
        halfTime = Math.round(fullTime/2);

        timer.setBackgroundColor(Color.YELLOW);
        timer.setTextColor(Color.BLACK);
        timer.setText(String.valueOf(fullTime));
    }
}
