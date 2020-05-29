package com.example.ex03_diy10_2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    Button btnReturn;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnReturn = findViewById(R.id.btnReturn);
        Intent intent = getIntent();
        String[] imageNames = intent.getStringArrayExtra("nameData");
        int[] voteResult = intent.getIntArrayExtra("voteData");
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        TextView[] textViews = new TextView[imageNames.length];
        RatingBar[] ratingBars = new RatingBar[voteResult.length];
        int max;

        int[] textViewIDs = {
                R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9
        };
        int[] ratingBarIDs = {
                R.id.ratingBar1, R.id.ratingBar2, R.id.ratingBar3, R.id.ratingBar4, R.id.ratingBar5, R.id.ratingBar6, R.id.ratingBar7, R.id.ratingBar8, R.id.ratingBar9
        };
        Integer imageFileID[] = {
                R.drawable.kakao01, R.drawable.kakao02, R.drawable.kakao03, R.drawable.kakao04, R.drawable.kakao05, R.drawable.kakao06, R.drawable.kakao07, R.drawable.kakao08, R.drawable.kakao09
        };

        for (int i = 0; i < textViews.length; i++) {
            textViews[i] = findViewById(textViewIDs[i]);
            ratingBars[i] = findViewById(ratingBarIDs[i]);
        }

        for (int i = 0; i < voteResult.length; i++) {
            textViews[i].setText(imageNames[i]);
            ratingBars[i].setRating(voteResult[i]);
        }

        for (int i = 1; i < imageNames.length; i++) {
            if (voteResult[i] > voteResult[i-1]) {
                imageView.setImageResource(imageFileID[i]);
                textView.setText("kakao"+i);
            }
        }

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
