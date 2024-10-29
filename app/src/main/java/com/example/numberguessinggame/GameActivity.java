package com.example.numberguessinggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int randomNumber;
    private int attemptsLeft = 4;

    private TextView feedbackText;
    private TextView attemptsText;
    private EditText guessInput;

    private Button btnSubtmit, btnHint, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        feedbackText = findViewById(R.id.game_feedback);
        attemptsText = findViewById(R.id.game_attempts);
        guessInput = findViewById(R.id.game_txtGuess);
        btnSubtmit = findViewById(R.id.game_btnSubmit);
        btnHint = findViewById(R.id.game_btnHint);
        btnBack = findViewById(R.id.btnBack);

        randomNumber = new Random().nextInt(10) + 1;

        attemptsText.setText(getString(R.string.game_attempts) + " " + attemptsLeft);

        btnSubtmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeGuess();
            }
        });

        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giveHint();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void makeGuess() {
        String userInput = guessInput.getText().toString();

        if (userInput.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        int userGuess = Integer.parseInt(userInput);
        attemptsLeft--;

        if (userGuess < randomNumber) {
            feedbackText.setText("Too low!");
        } else if (userGuess > randomNumber) {
            feedbackText.setText("Too high!");
        } else {
            feedbackText.setText("Correct! You guessed the number!");
            guessInput.setEnabled(false);
            return;
        }

        attemptsText.setText(getString(R.string.game_attempts) + " " + attemptsLeft);

        if (attemptsLeft == 0) {
            feedbackText.setText("Game Over! The number was: " + randomNumber);
            guessInput.setEnabled(false);
        }

        guessInput.setText("");
    }

    private void giveHint() {
        feedbackText.setText("The random number is: " + randomNumber);
    }
}
