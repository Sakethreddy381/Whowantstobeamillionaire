package com.example.whowantstobeamillionaire;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class YouWonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the status bar and action bar to make the activity fullscreen
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        // Create a FrameLayout to hold the GIFImageView and TextView
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        frameLayout.setLayoutParams(layoutParams);

        // Create a GifImageView
        GifImageView imageViewGif = new GifImageView(this);
        FrameLayout.LayoutParams gifLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        imageViewGif.setLayoutParams(gifLayoutParams);
        imageViewGif.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageViewGif.setImageResource(R.drawable.celebration); // Change to your GIF resource

        // Create a TextView for the overlay
        TextView textViewOverlay = new TextView(this);
        FrameLayout.LayoutParams textLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        textLayoutParams.gravity = Gravity.CENTER;
        textViewOverlay.setLayoutParams(textLayoutParams);
        textViewOverlay.setText("Congratulations! You Won $1,000,000");
        textViewOverlay.setTextColor(getResources().getColor(android.R.color.white));
        textViewOverlay.setTextSize(24);// Adjust text size as needed
        textViewOverlay.setGravity(Gravity.CENTER);
        // Add the GifImageView and TextView to the FrameLayout
        frameLayout.addView(imageViewGif);
        frameLayout.addView(textViewOverlay);

        // Set the content view to the FrameLayout
        setContentView(frameLayout);
    }
}
