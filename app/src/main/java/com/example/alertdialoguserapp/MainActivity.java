package com.example.alertdialoguserapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// View.OnClickListener - Implementation of the function "onClick"
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName, etPassportNo, etYearOfBirth; // Set EditText
    private Button btnNext; // Set Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // The design of MainActivity

        initUI();
        initListeners();
    }

    private void initUI() {
        // Id of EditText
        etName = findViewById(R.id.etName);
        etPassportNo = findViewById(R.id.etPassportNo);
        etYearOfBirth = findViewById(R.id.etYearOfBirth);
        // Id of Button
        btnNext = findViewById(R.id.btnNext);
    }

    private void initListeners() {
        // Give access to elements to be clicked
        btnNext.setOnClickListener(this);
    }

    // Show AlertDialog
    private void startAlertDialog(String text) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        TextView textView = new TextView(this);
        textView.setText(text);
        alert.setView(textView);

        alert.setPositiveButton("Ok", (dialog, whichButton) -> {

        });

        alert.show();
    }

    // Performs tasks after click on the elements
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Intent to SecondActivity and pass to SecondActivity data / Start the method startAlertDialog()
            case R.id.btnNext:
                if (etName.getText().toString().isEmpty()) {
                    startAlertDialog("Write your name");
                }
                if (etPassportNo.getText().toString().isEmpty() ||
                        etPassportNo.getText().toString().length() != 9) {
                    startAlertDialog("Write your passport number");
                }
                if (etYearOfBirth.getText().toString().isEmpty() ||
                        etYearOfBirth.getText().toString().length() != 4) {
                    startAlertDialog("Write your year of birth");
                } else if (!etYearOfBirth.getText().toString().isEmpty()) {
                    if (Integer.parseInt(etYearOfBirth.getText().toString()) > 2010 ||
                            Integer.parseInt(etYearOfBirth.getText().toString()) < 1990) {
                        startAlertDialog("Write your birth date");
                    }
                }
                if (!etName.getText().toString().isEmpty() &&
                        !etPassportNo.getText().toString().isEmpty() &&
                        !etYearOfBirth.getText().toString().isEmpty() &&
                        etPassportNo.getText().toString().length() == 9 &&
                        etYearOfBirth.getText().toString().length() == 4) {
                    if (Integer.parseInt(etYearOfBirth.getText().toString()) <= 2010 &&
                            Integer.parseInt(etYearOfBirth.getText().toString()) >= 1990) {
                        Intent intent = new Intent(this, SecondActivity.class);
                        intent.putExtra("name", etName.getText().toString());
                        startActivity(intent);
                    }
                }
                break;
        }
    }

}