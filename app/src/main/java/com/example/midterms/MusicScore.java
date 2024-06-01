package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MusicScore extends AppCompatActivity {
    private TextView textViewScore;

    private TextView textViewScoreText;
    private TextView textViewPreviousScore;
    private TextView textViewPreviousScoreText;
    private Button buttonHome;
    private Button buttonTryAgain;

    private int previousScore;
    private int currentScore;
    private MediaPlayer mediaPlayerFinish;
    private MediaPlayer mediaPlayerPowerUp;


    private Button buttonScore2x;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_score);

        textViewPreviousScore = findViewById(R.id.textViewPreviousScore);
        textViewPreviousScoreText = findViewById(R.id.textViewPreviousScoreText);
        buttonHome = findViewById(R.id.buttonHome);
        buttonTryAgain = findViewById(R.id.buttonTryAgain);
        textViewScore = findViewById(R.id.textViewScore);
        textViewScoreText = findViewById(R.id.textViewScoreText);
        buttonScore2x = findViewById(R.id.buttonScore2x);

        mediaPlayerFinish= MediaPlayer.create(this, R.raw.finish);
        mediaPlayerPowerUp= MediaPlayer.create(this, R.raw.powerup);

        mediaPlayerFinish.start();
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        String quiz = intent.getStringExtra("quiz");
        textViewScore.setText(String.valueOf(score));

        currentScore = score;

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        // Retrieve the username from shared preferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        username = preferences.getString("username", "");

        int score2x = databaseHelper.getX2Score(username);
        if (score2x == 0){
            buttonScore2x.setEnabled(false);
        }

        if (quiz != null) {
            if (quiz.equals("music_easy")) {
                previousScore = databaseHelper.getMusicEasyScore(username);
            } else if (quiz.equals("music_medium")) {
                previousScore = databaseHelper.getMusicMediumScore(username);
            } else if (quiz.equals("music_hard")) {
                previousScore = databaseHelper.getMusicHardScore(username);
            }
        }

        // Update the previous score TextView
        textViewPreviousScore.setText(String.valueOf(previousScore));

        // Store the score if it is higher than the previous score
        if (currentScore > previousScore) {
            if (quiz != null) {
                if (quiz.equals("music_easy")) {
                    databaseHelper.updateMusicEasyScore(username, currentScore);
                } else if (quiz.equals("music_medium")) {
                    databaseHelper.updateMusicMediumScore(username, currentScore);
                } else if (quiz.equals("music_hard")) {
                    databaseHelper.updateMusicHardScore(username, currentScore);
                }
            }
            textViewScoreText.setText("New High Score:");
        } else {
            textViewScoreText.setText("Your Score:");
        }

        buttonScore2x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentScore *= 2;
                mediaPlayerPowerUp.start();

                int get2xScore= databaseHelper.getX2Score(username);
                get2xScore--;
                databaseHelper.updateThirtySeconds(username, get2xScore);

                // Store the score if it is higher than the previous score
                if (currentScore > previousScore) {
                    if (quiz != null) {
                        if (quiz.equals("music_easy")) {
                            databaseHelper.updateMusicEasyScore(username, currentScore);
                        } else if (quiz.equals("music_medium")) {
                            databaseHelper.updateMusicMediumScore(username, currentScore);
                        } else if (quiz.equals("music_hard")) {
                            databaseHelper.updateMusicHardScore(username, currentScore);
                        }
                    }

                    textViewScoreText.setText("New High Score!");
                } else {
                    textViewScoreText.setText("Your Score:");
                }
                textViewScore.setText(String.valueOf(currentScore));
                buttonScore2x.setEnabled(false);
            }
        });
        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quiz != null) {
                    if (quiz.equals("music_easy")) {
                        Intent tryAgain = new Intent(MusicScore.this, MusicEasyQuiz.class);
                        startActivity(tryAgain);
                    } else if (quiz.equals("music_medium")) {
                        Intent tryAgain = new Intent(MusicScore.this, MusicMediumQuiz.class);
                        startActivity(tryAgain);
                    } else if (quiz.equals("music_hard")) {
                        Intent tryAgain = new Intent(MusicScore.this, MusicHardQuiz.class);
                        startActivity(tryAgain);
                    }
                }
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home;


                home = new Intent(MusicScore.this, Home.class);


                startActivity(home);
            }
        });


    }

}