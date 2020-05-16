package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    ImageView backButton,profileImage;
    TextView logoutButton,profileName;
    EditText emailId,phoneNo,dateOfBirth;
    CheckBox male,female;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logout of the current user account
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update the details and return to the previous screen

                Toast.makeText(ProfileActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get image from either gallery or the camera directly
            }
        });

        //also check how to disable check on the other gender if one gender is selected

    }

    void attachId()
    {
        backButton=findViewById(R.id.profile_page_back_btn);
        profileImage=findViewById(R.id.profile_page_profile_image);
        logoutButton=findViewById(R.id.profile_page_logout_tv);
        profileName=findViewById(R.id.profile_page_profile_name);
        emailId=findViewById(R.id.profile_page_email_et);
        phoneNo=findViewById(R.id.profile_page_number_et);
        dateOfBirth=findViewById(R.id.profile_page_dob_et);
        male=findViewById(R.id.profile_page_male_cb);
        female=findViewById(R.id.profile_page_female_cb);
        updateButton=findViewById(R.id.profile_page_update_btn);
    }
}
