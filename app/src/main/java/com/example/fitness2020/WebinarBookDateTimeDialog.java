package com.example.fitness2020;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.TimeModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class WebinarBookDateTimeDialog extends Dialog {

    Button confirmBtn;
    Context context;
    ChipGroup dateGroup,timeGroup;
    ArrayList<TimeModel> timeModels;
    ArrayList<DateModel> dateModels;
    String date,time;


    public WebinarBookDateTimeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check if the user has a fitness pass only then open the activity
        //otherwise display the other dialog box.which has xml name webinar_not_a_member_dialog

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_webinar_booking_final);

        attachId();

        initArrayList();

        addData();

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),WebinarBookingConfirmationActivity.class);
                getContext().startActivity(intent);
                dismiss();
            }
        });

        dateGroup=new ChipGroup(getContext());
        timeGroup=new ChipGroup(getContext());

        timeGroup.isSingleSelection();
        dateGroup.isSingleSelection();

        for (int i=0;i<=dateModels.size()-1;i++)
        {
            date=dateModels.get(i).getDate();
            Chip chip=new Chip(getContext());
            chip.setText(date);
            dateGroup.addView(chip);
        }

        for (int i=0;i<=timeModels.size()-1;i++)
        {
            time=timeModels.get(i).getTime();
            Chip chip=new Chip(getContext());
            chip.setText(date);
            timeGroup.addView(chip);
        }
    }

    private void addData() {
        for(int i=0;i<=9;i++)
        {
            timeModels.add(new TimeModel("9:00"));
            dateModels.add(new DateModel("20 July"));
        }
    }

    private void initArrayList() {
        dateModels=new ArrayList<>(3);
        timeModels=new ArrayList<>(3);
    }

    private void attachId() {
        confirmBtn = findViewById(R.id.final_booking_page_webinar_book_btn);
        dateGroup=findViewById(R.id.final_booking_page_webinar_date_chipgrp);
        timeGroup=findViewById(R.id.final_booking_page_webinar_time_chipgrp);
    }
}
