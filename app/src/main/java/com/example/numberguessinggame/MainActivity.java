package com.example.numberguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnEnterGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnterGame = findViewById(R.id.btnEnterGame);
        btnEnterGame.setOnClickListener(enterSplash);
    }

    Button.OnClickListener enterSplash = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SplashActivity.class);
            startActivity(intent);
        }
    };
}