package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness2020.Adapters.DateTimeAdapter;
import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.TimeModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Time;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class GymBookingFinalPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView gymName,offeringName,offeringSubscription,netAmount;
    EditText promoCode;
    TextInputLayout promo;
    Button payButton;
    RecyclerView dateRv,timeRv;
    ArrayList<DateModel> dateModels;
    ArrayList<TimeModel> timeModels;
    DateTimeAdapter timeAdapter,dateAdapter;
    ImageView backButton;
    Spinner groupNo;
    ChipGroup dateGroup,timeGroup;
    String date,time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_booking_final_page);

        attachId();

        promo.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promo.clearFocus();
                promoCode.clearFocus();
                promoCode.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(promo.getWindowToken(), 0);

            }
        });

//        dateRv.setLayoutManager(new LinearLayoutManager(GymBookingFinalPage.this,LinearLayoutManager.HORIZONTAL,false));
//        timeRv.setLayoutManager(new LinearLayoutManager(GymBookingFinalPage.this,LinearLayoutManager.HORIZONTAL,false));

        timeModels=new ArrayList<>(3);
        dateModels=new ArrayList<>(3);

        addData();

//        timeAdapter=new DateTimeAdapter(GymBookingFinalPage.this,1,dateModels,timeModels);
//        dateAdapter=new DateTimeAdapter(GymBookingFinalPage.this,0,dateModels,timeModels);

//        dateRv.setAdapter(dateAdapter);
//        timeRv.setAdapter(timeAdapter);
//
//        dateAdapter.notifyDataSetChanged();
//        timeAdapter.notifyDataSetChanged();


        timeGroup.isSingleSelection();
        dateGroup.isSingleSelection();

        for (DateModel d:dateModels)
        {
            date=d.getDate();
            Log.i(TAG, "onCreate:  "+date);
            Chip chip=new Chip(dateGroup.getContext());
            chip.setText(date);
            dateGroup.addView(chip);
        }

        for (int i=0;i<=timeModels.size()-1;i++)
        {
            time=timeModels.get(i).getTime();
            Chip chip=new Chip(timeGroup.getContext());
            chip.setText(time);
            timeGroup.addView(chip);
        }

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(GymBookingFinalPage.this,GymActivity.class);
                startActivity(backIntent);
            }
        });

        populateGroupNoSpinner();

        groupNo.setOnItemSelectedListener(this);
    }

    private void populateGroupNoSpinner() {
        ArrayList<String> groupNoData=new ArrayList<>();
        groupNoData.add("On My Own");
        for (int i=2;i<=5;i++)
        {
            groupNoData.add(""+i);
        }
        ArrayAdapter<String> groupNoAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,groupNoData);
        groupNoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groupNo.setAdapter(groupNoAdapter);
    }

    void attachId()
    {
        offeringName=findViewById(R.id.final_booking_page_gym_activity);
        offeringSubscription=findViewById(R.id.final_booking_page_gym_offer);
        promoCode=findViewById(R.id.final_booking_page_gym_promoET);
        payButton=findViewById(R.id.final_booking_page_gym_book_btn);
        netAmount = findViewById(R.id.final_booking_page_gym_amount);
        backButton=findViewById(R.id.final_booking_page_back_btn);
        groupNo=findViewById(R.id.squad_spinner);
        promo = findViewById(R.id.promo_layout);
        dateGroup=findViewById(R.id.final_booking_page_gym_date_chipgrp);
        timeGroup=findViewById(R.id.final_booking_page_gym_time_chipgrp);

    }

    void addData()
    {
        for (int i=0;i<=6;i++)
        {
            timeModels.add(new TimeModel("10:00-11:00"));
            dateModels.add(new DateModel("2 June"));
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        if(parent.getId()==R.id.)
//        {
//            Toast.makeText(this, "Selected "+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}