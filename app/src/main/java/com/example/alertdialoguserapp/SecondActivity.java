package com.example.alertdialoguserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

// View.OnClickListener - Implementation of the function "onClick"
public class SecondActivity extends AppCompatActivity {

    private TextView tvWelcomeUser; // Set TextView
    private String name; // Set String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // The design of SecondActivity

        initUI();
    }

    private void initUI() {
        // Id of TextView
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);

        // Get data from MainActivity
        name = getIntent().getStringExtra("name");

        // Set name into tvWelcomeUser
        tvWelcomeUser.setText("Welcome\n" + name);
    }

}