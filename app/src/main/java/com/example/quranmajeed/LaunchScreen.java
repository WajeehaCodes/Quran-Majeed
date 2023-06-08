package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LaunchScreen extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_launch);

        timer = new Timer();
        //hello
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchScreen.this, MenuScreen.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}