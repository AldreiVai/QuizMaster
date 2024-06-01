package com.example.midterms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.midterms.UserScore;

import java.util.ArrayList;
import java.util.List;

public class Leaderboards extends AppCompatActivity {

    private ListView leaderboardListView;
    private List<UserScore> leaderboardList;
    private ArrayAdapter<UserScore> leaderboardAdapter;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);

        dbHelper = new DatabaseHelper(this);
        leaderboardListView = findViewById(R.id.leaderboard_list);
        leaderboardList = new ArrayList<>();
        leaderboardAdapter = new LeaderboardAdapter();
        leaderboardListView.setAdapter(leaderboardAdapter);

        final Button btnHome = findViewById(R.id.btnHome);
        // Retrieve leaderboard data from the database
        leaderboardList.addAll(dbHelper.getLeaderboard());

        leaderboardAdapter.notifyDataSetChanged();

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Leaderboards.this, Home.class);
                startActivity(intent);
            }
        });
    }
    private class LeaderboardAdapter extends ArrayAdapter<UserScore> {
        LeaderboardAdapter() {
            super(Leaderboards.this, R.layout.leaderboard_item, leaderboardList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.leaderboard_item, parent, false);
            }

            UserScore userScore = getItem(position);

            TextView usernameTextView = convertView.findViewById(R.id.username_text);
            TextView scoreTextView = convertView.findViewById(R.id.score_text);

            if (userScore != null) {
                usernameTextView.setText(userScore.getUsername());
                scoreTextView.setText(String.valueOf(userScore.getTotalScore()));
            }

            return convertView;
        }
    }
}