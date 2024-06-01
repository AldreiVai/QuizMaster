package com.example.midterms;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_quiz_crud extends AppCompatActivity {
    private TextView tvViewText;
    private Button btnView;
    private String questions;

    private String tableName;
    private EditText etQuestion;
    private EditText etAnswer1;
    private EditText etAnswer2;
    private EditText etAnswer3;
    private EditText etAnswer4;
    private EditText etCorrectAnswer;
    private EditText etDeleteQuestionId;
    private Button btnDelete;
    private Button btnInsert;
    private EditText etEditQuestionId;
    private Button btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_quiz_crud);

        tvViewText = findViewById(R.id.tvViewText);
        btnView = findViewById(R.id.btnView);
        etQuestion = findViewById(R.id.etQuestion);
        etAnswer1 = findViewById(R.id.etAnswer1);
        etAnswer2 = findViewById(R.id.etAnswer2);
        etAnswer3 = findViewById(R.id.etAnswer3);
        etAnswer4 = findViewById(R.id.etAnswer4);
        etCorrectAnswer = findViewById(R.id.etCorrectAnswer);
        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);
        etDeleteQuestionId = findViewById(R.id.etDeleteQuestionId);
        etEditQuestionId = findViewById(R.id.etEditQuestionId);

        Intent intent = getIntent();
        tableName = intent.getStringExtra("tableName");

        tvViewText.setText(tableName);
        QuizDBHelper dbHelper = new QuizDBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = etQuestion.getText().toString().trim();
                String answer1 = etAnswer1.getText().toString().trim();
                String answer2 = etAnswer2.getText().toString().trim();
                String answer3 = etAnswer3.getText().toString().trim();
                String answer4 = etAnswer4.getText().toString().trim();
                String correctAnswer = etCorrectAnswer.getText().toString().trim();






                if (question.isEmpty() || answer1.isEmpty() || answer2.isEmpty() || answer3.isEmpty() || answer4.isEmpty() || correctAnswer.isEmpty()) {
                    Toast.makeText(Admin_quiz_crud.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    // Insert the question into the specified table
                    dbHelper.insertQuestion(tableName, question, answer1, answer2, answer3, answer4, correctAnswer);
                    // Check if the insertion was successful
                    boolean isInserted = dbHelper.isQuestionInserted(tableName, question);
                    if (isInserted) {
                        Toast.makeText(Admin_quiz_crud.this, "Question inserted successfully", Toast.LENGTH_SHORT).show();

                        // Clear the EditText fields
                        etQuestion.setText("");
                        etAnswer1.setText("");
                        etAnswer2.setText("");
                        etAnswer3.setText("");
                        etAnswer4.setText("");
                        etCorrectAnswer.setText("");
                    } else {
                        Toast.makeText(Admin_quiz_crud.this, "Failed to insert question", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String questionIdString = etDeleteQuestionId.getText().toString().trim();

                if (!questionIdString.isEmpty()) {
                    int questionId = Integer.parseInt(questionIdString);

                    // Check if the question ID exists in the table
                    boolean isQuestionExists = dbHelper.isQuestionExists(tableName, questionId);

                    if (isQuestionExists) {
                        // Delete the question from the specified table
                        dbHelper.deleteQuestion(tableName, questionId);
                        // Clear the EditText fields
                        etDeleteQuestionId.setText("");
                        // Display success message
                        Toast.makeText(Admin_quiz_crud.this, "Question " + questionId + " deleted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // Display error message if the question ID does not exist
                        Toast.makeText(Admin_quiz_crud.this, "Question ID does not exist", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Display error message if the question ID is empty
                    Toast.makeText(Admin_quiz_crud.this, "Please enter a question ID to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Retrieve the questions from the specified table
                questions = dbHelper.displayQuestions(tableName);

                Intent intentView = new Intent(Admin_quiz_crud.this, Admin_quiz_crud_view.class);
                intentView.putExtra("questions", questions);
                startActivity(intentView);

            }
        });



        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String questionId = etEditQuestionId.getText().toString().trim();

                if (!questionId.isEmpty()) {
                    int questionIdInt = Integer.parseInt(questionId);

                    // Check if the question ID exists in the table
                    boolean isQuestionExists = dbHelper.isQuestionExists(tableName, questionIdInt);

                    if (isQuestionExists) {
                        Intent intentEdit = new Intent(Admin_quiz_crud.this, Admin_quiz_crud_edit.class);
                        intentEdit.putExtra("tableName", tableName);
                        intentEdit.putExtra("questionId", questionId);
                        etEditQuestionId.setText("");
                        startActivity(intentEdit);
                    } else {
                        // Display error message if the question ID does not exist
                        Toast.makeText(Admin_quiz_crud.this, "Question ID does not exist", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Display error message if the question ID is empty
                    Toast.makeText(Admin_quiz_crud.this, "Please enter a question ID to edit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
