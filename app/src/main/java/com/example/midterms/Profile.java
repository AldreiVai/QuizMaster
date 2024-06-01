package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    private TextView tvUsername;
    private TextView tvScoreTriviaEasy;
    private TextView tvScoreTriviaMedium;
    private TextView tvScoreTriviaHard;
    private TextView tvScoreComputerEasy;
    private TextView tvScoreComputerMedium;
    private TextView tvScoreComputerHard;
    private TextView tvScoreMusicEasy;
    private TextView tvScoreMusicMedium;
    private TextView tvScoreMusicHard;
    private Button btnLogout;
    String username;


    private TextView tvCoinsCounter;
    private TextView tvScorex2Counter;
    private TextView tvSkipCounter;
    private TextView tv30SecCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvUsername = findViewById(R.id.tvUsername);
        tvScoreTriviaEasy = findViewById(R.id.tvScoreTriviaEasy);
        tvScoreTriviaMedium = findViewById(R.id.tvScoreTriviaMedium);
        tvScoreTriviaHard = findViewById(R.id.tvScoreTriviaHard);
        tvScoreComputerEasy = findViewById(R.id.tvScoreComputerEasy);
        tvScoreComputerMedium = findViewById(R.id.tvScoreComputerMedium);
        tvScoreComputerHard = findViewById(R.id.tvScoreComputerHard);
        tvScoreMusicEasy = findViewById(R.id.tvScoreMusicEasy);
        tvScoreMusicMedium = findViewById(R.id.tvScoreMusicMedium);
        tvScoreMusicHard = findViewById(R.id.tvScoreMusicHard);
        btnLogout = findViewById(R.id.btnLogout);

        // Get references to the TextViews
        tvCoinsCounter = findViewById(R.id.tvCoinsCounter);
        tvScorex2Counter = findViewById(R.id.tvScorex2Counter);
        tvSkipCounter = findViewById(R.id.tvSkipCounter);
        tv30SecCounter = findViewById(R.id.tv30SecCounter);



        databaseHelper = new DatabaseHelper(this);
        final Button btnHome = findViewById(R.id.btnHome);



        // Retrieve the username from shared preferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        username = preferences.getString("username", "");
        updateCounters();

        if (username.isEmpty()) {
            Toast.makeText(Profile.this, "Login again", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Profile.this, Login.class);
            startActivity(intent);
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Login.class);

                startActivity(intent);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);
            }
        });
        displayUsername(username);

        // Get and set the scores for each category and difficulty level
        int scoreTriviaEasy = databaseHelper.getTriviaEasyScore(username);
        tvScoreTriviaEasy.setText("Easy Trivia: " + scoreTriviaEasy);

        int scoreTriviaMedium = databaseHelper.getTriviaMediumScore(username);
        tvScoreTriviaMedium.setText("Medium Trivia: " + scoreTriviaMedium);

        int scoreTriviaHard = databaseHelper.getTriviaHardScore(username);
        tvScoreTriviaHard.setText("Hard Trivia: " + scoreTriviaHard);

        int scoreComputerEasy = databaseHelper.getComputerEasyScore(username);
        tvScoreComputerEasy.setText("Easy Computer: " + scoreComputerEasy);

        int scoreComputerMedium = databaseHelper.getComputerMediumScore(username);
        tvScoreComputerMedium.setText("Medium Computer: " + scoreComputerMedium);

        int scoreComputerHard = databaseHelper.getComputerHardScore(username);
        tvScoreComputerHard.setText("Hard Computer: " + scoreComputerHard);

        int scoreMusicEasy = databaseHelper.getMusicEasyScore(username);
        tvScoreMusicEasy.setText("Easy Music: " + scoreMusicEasy);

        int scoreMusicMedium = databaseHelper.getMusicMediumScore(username);
        tvScoreMusicMedium.setText("Medium Music: " + scoreMusicMedium);

        int scoreMusicHard = databaseHelper.getMusicHardScore(username);
        tvScoreMusicHard.setText("Hard Music: " + scoreMusicHard);
    }




    private void displayUsername(String username) {
        TextView tvUsername = findViewById(R.id.tvUsername);
        tvUsername.setText(username);
    }

    private void updateCounters() {
        int coins = databaseHelper.getCoins(username);
        int scorex2 = databaseHelper.getX2Score(username);
        int skip = databaseHelper.getSkip(username);
        int thirtySec = databaseHelper.getThirtySeconds(username);

        // Update the TextViews with the new counter values
        tvCoinsCounter.setText(" : " + coins);
        tvScorex2Counter.setText(" : " + scorex2);
        tvSkipCounter.setText(" : " + skip);
        tv30SecCounter.setText(" : " + thirtySec);
    }
}
