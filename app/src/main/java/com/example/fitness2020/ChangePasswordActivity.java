package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText oldNumber,newNumber,confirmNumber;
    Button backButton,saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        attachId();

    }

    private void attachId() {
//        backButton.findViewById(R.id.);
        oldNumber=findViewById(R.id.old_number);
        newNumber=findViewById(R.id.new_number);
        confirmNumber=findViewById(R.id.confirm_number);
        saveButton=findViewById(R.id.change_number_button);
    }
}
