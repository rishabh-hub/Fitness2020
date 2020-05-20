package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class SignupInternalActivity extends AppCompatActivity {
    ImageView backButon;
    Button signupButton;
    EditText nameEt,emailEt,numberEt,passwordEt;
    CheckBox termsCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_internal);

        attachId();

        backButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(SignupInternalActivity.this,MainActivity.class);
                startActivity(backIntent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent=new Intent(SignupInternalActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

    }

    void attachId()
    {
        backButon=findViewById(R.id.signup_internal_page_back_btn);
        signupButton=findViewById(R.id.signup_internal_page_signup_btn);
        nameEt=findViewById(R.id.signup_internal_page_name_et);
        emailEt=findViewById(R.id.signup_internal_page_email_et);
        passwordEt=findViewById(R.id.signup_internal_page_password_et);
        numberEt=findViewById(R.id.signup_internal_page_number_et);
        termsCb=findViewById(R.id.signup_internal_page_terms_cb);
    }
}
