package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Admin_users_view extends AppCompatActivity {
    private TextView tvViewText;

    private Button btnBack;

    String tableName;
    String users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_users_view);

        DatabaseHelper dbhelper = new DatabaseHelper(this);
        tvViewText = findViewById(R.id.tvViewText);

        users = dbhelper.getAllUserAccounts();
        tvViewText.setText(users);
    }
}