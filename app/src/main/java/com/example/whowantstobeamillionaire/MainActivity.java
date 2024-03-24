package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Set the toolbar as the ActionBar
        setSupportActionBar(toolbar);

        // Set title
        getSupportActionBar().setTitle(R.string.app_name);
        // Display splash screen for a certain duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start GameActivity after splash screen
                Intent intent = new Intent(MainActivity.this, Question1Activity.class);
                startActivity(intent);

                finish(); // Finish MainActivity so that it's not accessible after navigating to GameActivity
            }
        }, SPLASH_TIME_OUT);
    }
}
