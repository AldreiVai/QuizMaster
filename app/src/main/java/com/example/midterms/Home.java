package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Home extends AppCompatActivity {


    private String username;
    private DatabaseHelper databaseHelper;

    private TextView tvCoinsCounter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize tvCoinsCounter
        tvCoinsCounter = findViewById(R.id.tvCoinsCounter);
        TextView tvWelcome = findViewById(R.id.tvWelcome);
        // Retrieve the username from shared preferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        username = preferences.getString("username", "");

        databaseHelper = new DatabaseHelper(this);

        if (username != null && !username.isEmpty()) {
            tvWelcome.setText("Welcome! " + username);
        } else {
            Intent intent = new Intent(Home.this, Login.class);
            startActivity(intent);
        }


        final Button btnProfile = findViewById(R.id.btnProfile);
        final Button btnTriviaQuiz = findViewById(R.id.btnTriviaQuiz);
        final Button btnComputerQuiz = findViewById(R.id.btnComputerQuiz);
        final Button btnMusicQuiz = findViewById(R.id.btnMusicQuiz);
        final Button btnLeaderboards = findViewById(R.id.btnLeaderboards);
        final Button btnInfo = findViewById(R.id.btnInfo);
        final Button btnShop = findViewById(R.id.btnShop);
        updateCounters();


        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Profile.class);
                startActivity(intent);
            }

        });

        btnComputerQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ComputerDifficulty.class);
                startActivity(intent);
            }

        });

        btnTriviaQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, TriviaDifficulty.class);
                startActivity(intent);
            }
        });

        btnMusicQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, MusicDifficulty.class);
                startActivity(intent);
            }
        });
        btnLeaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Leaderboards.class);
                startActivity(intent);
            }

        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Shop.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, info.class);
                startActivity(intent);
            }
        });

    }

    private void updateCounters() {
        int coins = databaseHelper.getCoins(username);

        // Update the TextViews with the new counter values
        tvCoinsCounter.setText(" : " + coins);

    }

}