package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WebinarBookingFinalActivity extends AppCompatActivity {
    ImageView backBtn;
    Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_booking_final);

        attachID();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebinarBookingFinalActivity.this,WebinarBookingConfirmationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void attachID() {
        backBtn = findViewById(R.id.webinar_booking_page_back_btn);
        confirmBtn = findViewById(R.id.final_booking_page_webinar_book_btn);
    }
}