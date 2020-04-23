package com.example.boardgametimer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //region
    EditText editText;
    Button timer, reset, pauseRestart;
    TextView corpyright;
    CountDownTimer countDownTimer;
    TextToSpeech textToSpeech;

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
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });
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
                if (editText.getText().equals("")) {
                    Toast.makeText(MainActivity.this, "입력값이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (editText.hasFocus()) {
                        editText.clearFocus();
                        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    }

                    resetTimer();
                    cancelTimer();

                    String msg = String.format("Reset to %d seconds", fullTime);
                    textToSpeech.speak(msg, TextToSpeech.QUEUE_FLUSH, null);

                    timer.setEnabled(true);
                }
                return true;
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
                changeTextSize(currentTime);

                if (currentTime == halfTime) {
                    MediaPlayer.create(getApplicationContext(), R.raw.warning_sound).start();
                }
                if (currentTime <= 10) {
                    timer.setTextColor(Color.RED);
                    textToSpeech.speak(String.valueOf(currentTime), TextToSpeech.QUEUE_FLUSH, null);
                }

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
        if (editText.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "입력값이 없습니다.", Toast.LENGTH_SHORT).show();
            editText.setText(String.valueOf(fullTime));
            return;
        }
        fullTime = Long.parseLong(editText.getText().toString());
        halfTime = Math.round(fullTime/2);

        changeTextSize(fullTime);

        timer.setBackgroundColor(Color.YELLOW);
        timer.setTextColor(Color.BLACK);
        timer.setText(String.valueOf(fullTime));
    }
    private void changeTextSize(long seconds) {
        if (seconds>=100) {
            timer.setTextSize(200);
        }
        else if(seconds>=10) {
            timer.setTextSize(300);
        }
        else timer.setTextSize(400);
    }
}
