package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button start = findViewById(R.id.start_button);
        final Button btnExit = findViewById(R.id.btnExit);

        Intent congrats = getIntent();
        String url;
        url = congrats.getStringExtra("url");
        if (url != null) {
            Intent reward = new Intent(Intent.ACTION_VIEW);
            reward.setData(Uri.parse(url));
            startActivity(reward);
            finishAffinity();
        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);

                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }
}