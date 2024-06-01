package com.example.midterms;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Admin_quiz extends AppCompatActivity {

    private Button btnC_easy;
    private Button btnC_medium;
    private Button btnC_hard;
    private Button btnT_easy;
    private Button btnT_medium;
    private Button btnT_hard;
    private Button btnM_easy;
    private Button btnM_medium;
    private Button btnM_hard;



    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_quiz);


        btnC_easy = findViewById(R.id.btnC_easy);
        btnC_medium = findViewById(R.id.btnC_medium);
        btnC_hard = findViewById(R.id.btnC_hard);
        btnT_easy = findViewById(R.id.btnT_easy);
        btnT_medium = findViewById(R.id.btnT_medium);
        btnT_hard = findViewById(R.id.btnT_hard);
        btnM_easy = findViewById(R.id.btnM_easy);
        btnM_medium = findViewById(R.id.btnM_medium);
        btnM_hard = findViewById(R.id.btnM_hard);

        QuizDBHelper dbHelper = new QuizDBHelper(this);

        btnC_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "computer_easy_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });

        btnC_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "computer_medium_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });

        btnC_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "computer_hard_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });

        btnT_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "trivia_easy_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });

        btnT_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "trivia_medium_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });

        btnT_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "trivia_hard_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });
        btnM_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "music_easy_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });
        btnM_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "music_medium_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });
        btnM_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_quiz.this, Admin_quiz_crud.class);
                String tableName = "music_hard_questions";
                intent.putExtra("tableName", tableName);
                startActivity(intent);
            }
        });
    }
}
