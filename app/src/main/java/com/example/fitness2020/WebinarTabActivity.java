package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.fitness2020.Adapters.DateTimeAdapter;
import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.TimeModel;
import com.example.fitness2020.fragments.EveningFragmentTab;
import com.example.fitness2020.fragments.EventsFragment;
import com.example.fitness2020.fragments.HomeAtTheStudioTab;
import com.example.fitness2020.fragments.HomeLiveTab;
import com.example.fitness2020.fragments.MorningFragmentTab;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class WebinarTabActivity extends AppCompatActivity {

    TabLayout timeSlotTab;
    TabItem morningTab,eveningTab;
    Fragment fragment;
    ImageButton back;
    FrameLayout frameLayout;
    ArrayList<DateModel> dateModels=new ArrayList<>();
    ArrayList<TimeModel> timeModels=new ArrayList<>();
    RecyclerView dateRv;
    DateTimeAdapter dateAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webinar_tab);

        attachId();

        loadFragment(new MorningFragmentTab());
        dateRv.setLayoutManager(new LinearLayoutManager(WebinarTabActivity.this,LinearLayoutManager.HORIZONTAL,false));

        timeModels=new ArrayList<>(3);
        dateModels=new ArrayList<>(3);

        addData();

        dateAdapter=new DateTimeAdapter(WebinarTabActivity.this,0,dateModels,timeModels);

        dateRv.setAdapter(dateAdapter);

        dateAdapter.notifyDataSetChanged();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebinarTabActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        timeSlotTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch(tab.getPosition())
                {
                    case 0: fragment=new MorningFragmentTab();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new EveningFragmentTab();
                        loadFragment(fragment);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    void attachId()
    {
        dateRv=findViewById(R.id.webinar_date_selected_rv);
        morningTab=findViewById(R.id.webinar_tab_morning);
        eveningTab=findViewById(R.id.webinar_tab_evening);
        timeSlotTab=findViewById(R.id.webinar_tab_layout);
        frameLayout = findViewById(R.id.webinar_frame);
        back = findViewById(R.id.webinar_internal_back_btn);
    }

    void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.webinar_frame,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    void addData()
    {
        for (int i=0;i<4;i++)
        dateModels.add(new DateModel("2 June"));
    }
}