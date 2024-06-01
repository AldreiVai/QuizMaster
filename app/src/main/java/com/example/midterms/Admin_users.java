package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_users extends AppCompatActivity {

    private Button btnView;
    private EditText etDeleteUserId;
    private Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_users);

        btnView = findViewById(R.id.btnView);
        btnDelete = findViewById(R.id.btnDelete);
        etDeleteUserId = findViewById(R.id.etDeleteUserId);

        DatabaseHelper dbhelper = new DatabaseHelper(this);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userIdString = etDeleteUserId.getText().toString().trim();

                if (!userIdString.isEmpty()) {
                    int userId = Integer.parseInt(userIdString);

                    // Check if the question ID exists in the table
                    boolean isQuestionExists = dbhelper.isUserExists(userId);

                    if (isQuestionExists) {
                        // Delete the question from the specified table
                        dbhelper.deleteUserAccount(userId);

                        // Display success message
                        Toast.makeText(Admin_users.this, "User ID " + userId + " deleted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        // Display error message if the question ID does not exist
                        Toast.makeText(Admin_users.this, "User ID does not exist", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Display error message if the question ID is empty
                    Toast.makeText(Admin_users.this, "Please enter a User ID to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(Admin_users.this, Admin_users_view.class);

                startActivity(intentView);
            }
        });
    }
}