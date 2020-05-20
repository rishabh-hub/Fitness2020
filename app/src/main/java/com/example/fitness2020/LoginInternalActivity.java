package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginInternalActivity extends AppCompatActivity {

    EditText usernameEt,passwordEt;
    Button loginButton,googleButton,facebookButton;
    TextView signupButton;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_internal);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity=new Intent(LoginInternalActivity.this,MainActivity.class);
                startActivity(mainActivity);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupIntent=new Intent(LoginInternalActivity.this,SignupInternalActivity.class);
            }
        });


    }

    void attachId()
    {
        usernameEt=findViewById(R.id.login_internal_page_username_et);
        passwordEt=findViewById(R.id.login_internal_page_password_et);
        backButton=findViewById(R.id.login_internal_page_back_btn);
        loginButton=findViewById(R.id.login_internal_page_login_btn);
        googleButton=findViewById(R.id.login_internal_page_google_btn);
        facebookButton=findViewById(R.id.login_internal_page_facebook_btn);
        signupButton=findViewById(R.id.login_internal_page_signup_btn);

    }
}
