package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.TimeModel;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class WebinarTabActivity extends AppCompatActivity {

    TabLayout timeSlotTab;
    TabItem morningTab,eveningTab;
    Fragment fragment;
    ArrayList<DateModel> dateModels;
    ArrayList<TimeModel> timeModels;
    RecyclerView dateRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_tab);

        attachId();

    }

    void attachId()
    {
        dateRv=findViewById(R.id.webinar_date_selected_rv);
    }
}