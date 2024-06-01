package com.example.midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class Congratulation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);
        final Button btn_congrats = findViewById(R.id.btn_congrats);
        MediaPlayer cheer = MediaPlayer.create(this, R.raw.cheer);


        cheer.start();
btn_congrats.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent congrats = new Intent(Congratulation.this, MainActivity.class);
        String url = "https://www.youtube.com/watch?v=xvFZjo5PgG0";
        congrats.putExtra("url", url);
        congrats.setData(Uri.parse(url));

        cheer.stop();
            startActivity(congrats);
    }
});

    }
}