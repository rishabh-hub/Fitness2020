package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class GymBookingFinalPage extends AppCompatActivity {

    TextView gymName,offeringName,offeringSubscription;
    RecyclerView dateRv,timeRv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_booking_final_page);
    }
}