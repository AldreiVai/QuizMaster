package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Shop extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private TextView tvCoinsCounter;
    private TextView tvScorex2Counter;
    private TextView tvSkipCounter;
    private TextView tv30SecCounter;
    private String username;
private Button btnHelp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        databaseHelper = new DatabaseHelper(this);

        // Get references to the TextViews
        tvCoinsCounter = findViewById(R.id.tvCoinsCounter);
        tvScorex2Counter = findViewById(R.id.tvScorex2Counter);
        tvSkipCounter = findViewById(R.id.tvSkipCounter);
        tv30SecCounter = findViewById(R.id.tv30SecCounter);
        final Button btnHome = findViewById(R.id.btnHome);

        btnHelp = findViewById(R.id.btnHelp);


        // Retrieve the username from shared preferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        username = preferences.getString("username", "");

        // Update the counters
        updateCounters();

        Button btnCoins10 = findViewById(R.id.btnCoins10);
        Button btnCoins50 = findViewById(R.id.btnCoins50);
        Button btnCoins100 = findViewById(R.id.btnCoins100);
        Button btnScorex2_5 = findViewById(R.id.btnScorex2_5);
        Button btnScorex2_10 = findViewById(R.id.btnScorex2_10);
        Button btnSkip5 = findViewById(R.id.btnSkip5);
        Button btnSkip10 = findViewById(R.id.btnSkip10);
        Button btn30Sec_5 = findViewById(R.id.btn30Sec_5);
        Button btn30Sec_10 = findViewById(R.id.btn30Sec_10);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shop.this, Home.class);
                startActivity(intent);
            }
        });
        btnCoins10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedCoins = databaseHelper.getCoins(username) + 10;
                databaseHelper.updateCoins(username, updatedCoins);
                updateCounters();
                Toast.makeText(getApplicationContext(), "Coins increased by 10", Toast.LENGTH_SHORT).show();
            }
        });

        btnCoins50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedCoins = databaseHelper.getCoins(username) + 50;
                databaseHelper.updateCoins(username, updatedCoins);
                updateCounters();
                Toast.makeText(getApplicationContext(), "Coins increased by 50", Toast.LENGTH_SHORT).show();
            }
        });

        btnCoins100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedCoins = databaseHelper.getCoins(username) + 100;
                databaseHelper.updateCoins(username, updatedCoins);
                updateCounters();
                Toast.makeText(getApplicationContext(), "Coins increased by 100", Toast.LENGTH_SHORT).show();
            }
        });



        //Power-Ups
        btnScorex2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCoins = databaseHelper.getCoins(username);
                int scorex2Amount = 5;
                int updatedScorex2 = databaseHelper.getX2Score(username) + scorex2Amount;
                int requiredCoins = scorex2Amount; // Same as scorex2Amount, change if needed

                if (currentCoins >= requiredCoins) {
                    // Deduct coins and update scorex2 counter
                    databaseHelper.updateCoins(username, currentCoins - requiredCoins);
                    databaseHelper.updateX2Score(username, updatedScorex2);
                    updateCounters();
                    Toast.makeText(getApplicationContext(), "2x Score increased by 5", Toast.LENGTH_SHORT).show();
                } else {
                    // Show an error message or perform some other action
                    Toast.makeText(Shop.this, "Insufficient coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnScorex2_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCoins = databaseHelper.getCoins(username);
                int scorex2Amount = 10;
                int updatedScorex2 = databaseHelper.getX2Score(username) + scorex2Amount;
                int requiredCoins = scorex2Amount; // Same as scorex2Amount, change if needed

                if (currentCoins >= requiredCoins) {
                    // Deduct coins and update scorex2 counter
                    databaseHelper.updateCoins(username, currentCoins - requiredCoins);
                    databaseHelper.updateX2Score(username, updatedScorex2);
                    updateCounters();
                    Toast.makeText(Shop.this, "2x Score increased by 10", Toast.LENGTH_SHORT).show();
                } else {
                    // Show an error message or perform some other action
                    Toast.makeText(Shop.this, "Insufficient coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSkip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCoins = databaseHelper.getCoins(username);
                int skipAmount = 5;
                int updatedSkip = databaseHelper.getSkip(username) + skipAmount;
                int requiredCoins = skipAmount;

                if (currentCoins >= requiredCoins) {
                    // Deduct coins and update skip counter
                    databaseHelper.updateCoins(username, currentCoins - requiredCoins);
                    databaseHelper.updateSkip(username, updatedSkip);
                    updateCounters();
                    Toast.makeText(Shop.this, "Skip increased by 10", Toast.LENGTH_SHORT).show();
                } else {
                    // Show an error message or perform some other action
                    Toast.makeText(Shop.this, "Insufficient coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSkip10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCoins = databaseHelper.getCoins(username);
                int skipAmount = 10;
                int updatedSkip = databaseHelper.getSkip(username) + skipAmount;
                int requiredCoins = skipAmount;

                if (currentCoins >= requiredCoins) {
                    // Deduct coins and update skip counter
                    databaseHelper.updateCoins(username, currentCoins - requiredCoins);
                    databaseHelper.updateSkip(username, updatedSkip);
                    updateCounters();
                    Toast.makeText(Shop.this, "Skip increased by 10", Toast.LENGTH_SHORT).show();
                } else {
                    // Show an error message or perform some other action
                    Toast.makeText(Shop.this, "Insufficient coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn30Sec_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCoins = databaseHelper.getCoins(username);
                int thirtySecondsAmount = 5;
                int updatedThirtySeconds = databaseHelper.getThirtySeconds(username) + thirtySecondsAmount;
                int requiredCoins = thirtySecondsAmount;

                if (currentCoins >= requiredCoins) {
                    // Deduct coins and update thirtySeconds counter
                    databaseHelper.updateCoins(username, currentCoins - requiredCoins);
                    databaseHelper.updateThirtySeconds(username, updatedThirtySeconds);
                    updateCounters();
                    Toast.makeText(Shop.this, "30 Sec increased by 5", Toast.LENGTH_SHORT).show();
                } else {
                    // Show an error message or perform some other action
                    Toast.makeText(Shop.this, "Insufficient coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn30Sec_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCoins = databaseHelper.getCoins(username);
                int thirtySecondsAmount = 10;
                int updatedThirtySeconds = databaseHelper.getThirtySeconds(username) + thirtySecondsAmount;
                int requiredCoins = thirtySecondsAmount;

                if (currentCoins >= requiredCoins) {
                    // Deduct coins and update thirtySeconds counter
                    databaseHelper.updateCoins(username, currentCoins - requiredCoins);
                    databaseHelper.updateThirtySeconds(username, updatedThirtySeconds);
                    updateCounters();
                    Toast.makeText(Shop.this, "30 Sec increased by 10", Toast.LENGTH_SHORT).show();
                } else {
                    // Show an error message or perform some other action
                    Toast.makeText(Shop.this, "Insufficient coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shop.this, Help.class);
                startActivity(intent);

            }
        });

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
