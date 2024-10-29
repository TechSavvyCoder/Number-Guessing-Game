package com.example.numberguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    TextView timerTextView;
    CountDownTimer countDownTimer;
    long timeLeftInMillis = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        timerTextView = findViewById(R.id.splash_countdown);
        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            int seconds = 3;

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimerText(seconds);
                seconds--;
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, GameActivity.class);
                startActivity(intent);
            }
        }.start();
    }

    private void updateTimerText(int seconds) {
        timerTextView.setText(String.valueOf(seconds));
    }
}
