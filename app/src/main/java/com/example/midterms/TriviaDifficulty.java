package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class TriviaDifficulty extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private TextView tvCoinsCounter;
    private TextView tvScorex2Counter;
    private TextView tvSkipCounter;
    private TextView tv30SecCounter;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_difficulty);

        final Button btnEasy = findViewById(R.id.btnEasy);
        final Button btnMedium = findViewById(R.id.btnMedium);
        final Button btnHard = findViewById(R.id.btnHard);

// Get references to the TextViews

        tvScorex2Counter = findViewById(R.id.tvScorex2Counter);
        tvSkipCounter = findViewById(R.id.tvSkipCounter);
        tv30SecCounter = findViewById(R.id.tv30SecCounter);

        databaseHelper = new DatabaseHelper(this);

        // Retrieve the username from shared preferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        username = preferences.getString("username", "");

        // Update the counters
        updateCounters();


        final Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TriviaDifficulty.this, Home.class);
                startActivity(intent);
            }
        });



        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent easyintent = new Intent(TriviaDifficulty.this, TriviaEasyQuiz.class);
                startActivity(easyintent);
            }

        });
        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mediumintent = new Intent(TriviaDifficulty.this, TriviaMediumQuiz.class);
                startActivity(mediumintent);
            }
        });
        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hardintent = new Intent(TriviaDifficulty.this, TriviaHardQuiz.class);
                startActivity(hardintent);
            }
        });
    }

    private void updateCounters() {

        int scorex2 = databaseHelper.getX2Score(username);
        int skip = databaseHelper.getSkip(username);
        int thirtySec = databaseHelper.getThirtySeconds(username);

        // Update the TextViews with the new counter values

        tvScorex2Counter.setText(" : " + scorex2);
        tvSkipCounter.setText(" : " + skip);
        tv30SecCounter.setText(" : " + thirtySec);
    }
}