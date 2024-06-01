package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_quiz_crud_edit extends AppCompatActivity {
    private String tableName;
    private EditText etQuestion;
    private EditText etAnswer1;
    private EditText etAnswer2;
    private EditText etAnswer3;
    private EditText etAnswer4;
    private EditText etCorrectAnswer;
    private Button btnEdit;
    private String questionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_quiz_crud_edit);
        etQuestion = findViewById(R.id.etQuestion);
        etAnswer1 = findViewById(R.id.etAnswer1);
        etAnswer2 = findViewById(R.id.etAnswer2);
        etAnswer3 = findViewById(R.id.etAnswer3);
        etAnswer4 = findViewById(R.id.etAnswer4);
        etCorrectAnswer = findViewById(R.id.etCorrectAnswer);
        btnEdit = findViewById(R.id.btnEdit);

        Intent intentEdit = getIntent();
        tableName = intentEdit.getStringExtra("tableName");
        questionId = intentEdit.getStringExtra("questionId");


        QuizDBHelper dbHelper = new QuizDBHelper(this);

        // Retrieve the question details from the database
        Question question = dbHelper.selectQuestion(tableName, Integer.parseInt(questionId));

        // Set the acquired data to the corresponding TextViews
        etQuestion.setText(question.getQuestion());
        etAnswer1.setText(question.getOption1());
        etAnswer2.setText(question.getOption2());
        etAnswer3.setText(question.getOption3());
        etAnswer4.setText(question.getOption4());
        etCorrectAnswer.setText(question.getCorrectAnswer());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newQuestion = etQuestion.getText().toString().trim();
                String newOption1 = etAnswer1.getText().toString().trim();
                String newOption2 = etAnswer2.getText().toString().trim();
                String newOption3 = etAnswer3.getText().toString().trim();
                String newOption4 = etAnswer4.getText().toString().trim();
                String newCorrectAnswer = etCorrectAnswer.getText().toString().trim();


                if (!newQuestion.isEmpty() && !newOption1.isEmpty() && !newOption2.isEmpty() &&
                        !newOption3.isEmpty() && !newOption4.isEmpty() && !newCorrectAnswer.isEmpty()) {
                    int id = Integer.parseInt(questionId);

                    // Update the question in the specified table
                    dbHelper.updateQuestion(tableName, id, newQuestion, newOption1, newOption2,
                            newOption3, newOption4, newCorrectAnswer);

                    // Display success message or handle the result as needed
                    Toast.makeText(Admin_quiz_crud_edit.this, "Question updated successfully", Toast.LENGTH_SHORT).show();

                } else {
                    // Display error message if any field is empty
                    Toast.makeText(Admin_quiz_crud_edit.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}