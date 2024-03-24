package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Question10Activity extends AppCompatActivity {

    private ArrayList<String> options;
    private String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);

        // Initialize options array
        options = new ArrayList<>();

        // Set up question and options
        setUpQuestion();

        // Set up confirm button click listener
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmAnswer();
            }
        });
        setUpRadioGroupListener();
    }

    private void setUpQuestion() {
        // Set question text and options
        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText("Q:10 Which country won the ICC Cricket World Cup in 1996?");

        options.add("Australia");
        options.add("Pakistan");
        options.add("Sri lanka");
        options.add("Ireland");

        RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        for (String option : options) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            optionsRadioGroup.addView(radioButton);
        }

        // Set correct answer
        correctAnswer = "Sri lanka";
    }

    private void confirmAnswer() {
        // Get the selected radio button id
        RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();

        // Check if any option is selected
        if (selectedRadioButtonId != -1) {
            // Find the selected radio button
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

            // Get the text of the selected option
            String selectedOption = selectedRadioButton.getText().toString();

            // Check if the selected option is correct
            if (selectedOption.equals(correctAnswer)) {
                // If correct, display a toast confirming the answer
                Toast.makeText(Question10Activity.this, "Correct answer!You Earned $1,000,000", Toast.LENGTH_SHORT).show();
                // Move to next question or handle winning
                Intent intent = new Intent(Question10Activity.this, YouWonActivity.class);
                startActivity(intent);

            } else {
                // If incorrect, display a toast informing the user
                Toast.makeText(Question10Activity.this, "Incorrect answer!", Toast.LENGTH_SHORT).show();
                // Move to YouLostActivity or handle loss
                Intent intent = new Intent(Question10Activity.this, YouLostActivity.class);
                startActivity(intent);
            }
        } else {
            // If no option is selected, display a toast informing the user to select an option
            Toast.makeText(Question10Activity.this, "Please select an option!", Toast.LENGTH_SHORT).show();
        }
    }
    private void setUpRadioGroupListener() {
        RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        optionsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Clear background color of all radio buttons
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    radioButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                }

                // Get the selected radio button
                RadioButton selectedRadioButton = findViewById(checkedId);
                if (selectedRadioButton != null) {
                    // Change background color of the selected radio button
                    int backgroundColor = getResources().getColor(R.color.selected_option_background);
                    selectedRadioButton.setBackgroundColor(backgroundColor);
                }
            }
        });
    }
}