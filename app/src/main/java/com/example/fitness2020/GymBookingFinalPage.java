package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import java.sql.Time;
import java.util.ArrayList;

public class GymBookingFinalPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView gymName,offeringName,offeringSubscription,netAmount;
    EditText promoCode,groupNum;
    Button payButton;
    RecyclerView dateRv,timeRv;
    ArrayList<DateModel> dateModels;
    ArrayList<TimeModel> timeModels;
    DateTimeAdapter timeAdapter,dateAdapter;
    ImageView backButton;
    Spinner groupNo;

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
        for (int i=1;i<=25;i++)
        {
            groupNoData.add(""+i);
        }
        ArrayAdapter<String> groupNoAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,groupNoData);
        groupNoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groupNo.setAdapter(groupNoAdapter);
    }

    void attachId()
    {
//        gymName=findViewById(R.id.final_booking_page_gym_name);
        offeringName=findViewById(R.id.final_booking_page_gym_activity);
        offeringSubscription=findViewById(R.id.final_booking_page_gym_offer);
        dateRv=findViewById(R.id.final_booking_page_gym_date_rv);
        timeRv=findViewById(R.id.final_booking_page_gym_time_rv);
        promoCode=findViewById(R.id.final_booking_page_gym_promoET);
        payButton=findViewById(R.id.final_booking_page_gym_book_btn);
        groupNum = findViewById(R.id.final_booking_page_gym_groupET);
        netAmount = findViewById(R.id.final_booking_page_gym_amount);
        backButton=findViewById(R.id.final_booking_page_back_btn);
//        groupNo=findViewById(R.id.);
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