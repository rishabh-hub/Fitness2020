package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fitness2020.Adapters.BookingsAdapter;
import com.example.fitness2020.Adapters.FitnessFragmentFreeTrialAdapter;
import com.example.fitness2020.Models.MembershipModel;
import com.example.fitness2020.fragments.BookingEventTab;
import com.example.fitness2020.fragments.BookingLiveTab;
import com.example.fitness2020.fragments.BookingStudioTab;
import com.example.fitness2020.fragments.BookingVoucherTab;
import com.example.fitness2020.fragments.Fitness2020MembershipTab;
import com.example.fitness2020.fragments.GymMembershipTab;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.io.FileReader;
import java.util.ArrayList;

public class MembershipActivity extends AppCompatActivity {
    RecyclerView membershipRV;
    ArrayList<MembershipModel> membershipModels = new ArrayList<>();
    BookingsAdapter membershipAdapter;

    Fragment fragment;
    TabLayout membershipTab;
    TabItem gymMembership,ftiness2020Menmbership;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        attachId();

        membershipTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch(tab.getPosition())
                {
                    case 0: fragment=new Fitness2020MembershipTab();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new GymMembershipTab();
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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        membershipRV = findViewById(R.id.membership_rv);
//        membershipRV.setLayoutManager(new LinearLayoutManager(MembershipActivity.this,LinearLayoutManager.VERTICAL,false));
//        membershipAdapter = new BookingsAdapter(membershipModels,MembershipActivity.this);
//        addData();
//        membershipRV.setAdapter(membershipAdapter);
//        membershipAdapter.notifyDataSetChanged();

    }

    void attachId()
    {
        backButton=findViewById(R.id.membership_activity_back_btn);
        membershipTab=findViewById(R.id.);
        ftiness2020Menmbership=findViewById(R.id.);
        gymMembership=findViewById(R.id.);
    }

    void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

    }

//    private void addData() {
//        for (int i=0;i<5;i++)
//            membershipModels.add(new MembershipModel(R.drawable.gym_photo,"2020 Lite","22 March,2020","10000012","4800","-0","4800","Trials: Unlimited","20","20 Sep,2020","20 Sep,2020"));
//    }
}
