package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FitAtWorkForm extends AppCompatActivity {

    ImageView backButton;
    EditText individualName,companyName,emailId,phoneNo,comments;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_at_work_form);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent submitIntent
//                pass intent to wherever needed
            }
        });
    }

    private void attachId() {

        backButton=findViewById(R.id.get_started_page_back_btn);
        individualName=findViewById(R.id.get_started_page_individual_name);
        companyName=findViewById(R.id.get_started_page_company_name);
        emailId=findViewById(R.id.get_started_page_email_id);
        phoneNo=findViewById(R.id.get_started_page_phone_no);
        comments=findViewById(R.id.get_started_page_comments);
        submitButton=findViewById(R.id.get_started_page_submit_button);
    }
}