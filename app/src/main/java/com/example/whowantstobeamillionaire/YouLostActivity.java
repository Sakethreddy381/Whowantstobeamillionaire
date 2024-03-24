package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class YouLostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lost);

        // Find the restart button
        findViewById(R.id.buttonRestart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart the game by navigating to Question1Activity
                Intent intent = new Intent(YouLostActivity.this, Question1Activity.class);
                startActivity(intent);
                finish(); // Finish the current activity
            }
        });
    }
}
