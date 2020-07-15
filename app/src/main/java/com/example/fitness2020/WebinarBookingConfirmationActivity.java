package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class WebinarBookingConfirmationActivity extends AppCompatActivity {

    ImageView closeButton;
    Button followButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_booking_confirmation);

        attachId();

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri=Uri.parse("https://www.instagram.com/oauth/authorize?client_id=1486092204916874&redirect_uri=https://httpstat.us/200&scope=user_profile,user_media&response_type=code");
                Intent instaIntent=new Intent(Intent.ACTION_VIEW,uri);

                startActivity(instaIntent);

            }
        });
    }

    private void attachId() {
        closeButton=findViewById(R.id.webinar_confirmation_cut_btn);
        followButton=findViewById(R.id.follow_button);
    }

}