package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitness2020.Adapters.DateTimeAdapter;
import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.TimeModel;

import java.sql.Time;
import java.util.ArrayList;

public class GymBookingFinalPage extends AppCompatActivity {

    TextView gymName,offeringName,offeringSubscription,netAmount;
    EditText promoCode,groupNum;
    Button payButton;
    RecyclerView dateRv,timeRv;
    ArrayList<DateModel> dateModels;
    ArrayList<TimeModel> timeModels;
    DateTimeAdapter timeAdapter,dateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_booking_final_page);

        attachId();

        dateRv.setLayoutManager(new LinearLayoutManager(GymBookingFinalPage.this,LinearLayoutManager.HORIZONTAL,false));
        timeRv.setLayoutManager(new LinearLayoutManager(GymBookingFinalPage.this,LinearLayoutManager.HORIZONTAL,false));

        timeModels=new ArrayList<>(3);
        dateModels=new ArrayList<>(3);

        addData();

        timeAdapter=new DateTimeAdapter(GymBookingFinalPage.this,1,dateModels,timeModels);
        dateAdapter=new DateTimeAdapter(GymBookingFinalPage.this,0,dateModels,timeModels);

        dateRv.setAdapter(dateAdapter);
        timeRv.setAdapter(timeAdapter);

        dateAdapter.notifyDataSetChanged();
        timeAdapter.notifyDataSetChanged();

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    void attachId()
    {
        gymName=findViewById(R.id.final_booking_page_gym_name);
        offeringName=findViewById(R.id.final_booking_page_gym_activity);
        offeringSubscription=findViewById(R.id.final_booking_page_gym_offer);
        dateRv=findViewById(R.id.final_booking_page_gym_date_rv);
        timeRv=findViewById(R.id.final_booking_page_gym_time_rv);
        promoCode=findViewById(R.id.final_booking_page_gym_promoET);
        payButton=findViewById(R.id.final_booking_page_gym_book_btn);
        groupNum = findViewById(R.id.final_booking_page_gym_groupET);
        netAmount = findViewById(R.id.final_booking_page_gym_amount);
    }

    void addData()
    {
        for (int i=0;i<=6;i++)
        {
            timeModels.add(new TimeModel("10:00-11:00"));
            dateModels.add(new DateModel("2 June", "June"));
        }

    }
}