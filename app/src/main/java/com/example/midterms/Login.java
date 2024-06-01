package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button signupButton;

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);


        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        signupButton = findViewById(R.id.buttonSignUp);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               username = editTextUsername.getText().toString().trim();
               password = editTextPassword.getText().toString().trim();


                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (databaseHelper.login(username, password)) {
                        // Login successful
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();

                        // Store the username in shared preferences
                        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("username", username);
                        editor.apply();

                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    } else if (username.equals("admin") || password.equals("admin")) {
                        Intent intent = new Intent(Login.this, Admin.class);
                        startActivity(intent);
                    } else {
                        // Login failed
                        Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the signup activity
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });


    }
}