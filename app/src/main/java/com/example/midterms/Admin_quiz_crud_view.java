package com.example.midterms;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Admin_quiz_crud_view extends AppCompatActivity {

    private TextView tvViewText;

    private Button btnBack;

    String tableName;
    String questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_quiz_crud_view);

        tvViewText = findViewById(R.id.tvViewText);




        Intent intentView = getIntent();
        questions = intentView.getStringExtra("questions");
        tvViewText.setText(questions);



    }
}
