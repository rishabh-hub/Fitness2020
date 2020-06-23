package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText oldNumber,newNumber,confirmNumber;
    Button saveButton;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void attachId() {
        backButton = findViewById(R.id.change_number_page_back_btn);
        oldNumber = findViewById(R.id.old_number);
        newNumber = findViewById(R.id.new_number);
        confirmNumber = findViewById(R.id.confirm_number);
        saveButton = findViewById(R.id.change_number_button);
    }
}
