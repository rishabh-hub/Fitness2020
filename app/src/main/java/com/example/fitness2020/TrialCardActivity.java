package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Models.TrendingRvModel;

import java.util.ArrayList;

public class TrialCardActivity extends AppCompatActivity {

    RecyclerView imageRv;
    ArrayList<FaqModel> faqs;
    ArrayList<TrendingRvModel> imageModels;
    SubscriptionCardsAdapter imageRvAdapter;
    RelativeLayout membershipcard1,membershipcard2,membershipcard3,membershipcard4;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_card);

        attachId();

        imageRv.setLayoutManager(new LinearLayoutManager(TrialCardActivity.this,LinearLayoutManager.HORIZONTAL,false));

        imageModels=new ArrayList<>(3);

        addData();

        membershipcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrialCardActivity.this, TrialMembershipBooking.class);
                startActivity(intent);
            }
        });
        membershipcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrialCardActivity.this, TrialMembershipBooking.class);
                startActivity(intent);
            }
        });
        membershipcard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrialCardActivity.this, TrialMembershipBooking.class);
                startActivity(intent);
            }
        });
        membershipcard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrialCardActivity.this, TrialMembershipBooking.class);
                startActivity(intent);
            }
        });

        imageRvAdapter=new SubscriptionCardsAdapter(TrialCardActivity.this,0,imageModels,faqs);

        imageRv.setAdapter(imageRvAdapter);

        imageRvAdapter.notifyDataSetChanged();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void attachId()
    {
        imageRv=findViewById(R.id.trial_card_imagerv);
        membershipcard1 = findViewById(R.id.trial_membership_1);
        membershipcard2 = findViewById(R.id.trial_membership_2);
        membershipcard3 = findViewById(R.id.trial_membership_3);
        membershipcard4 = findViewById(R.id.trial_membership_4);
        backButton=findViewById(R.id.memberships_page_back_btn);
    }

    void addData()
    {
        for (int i=0;i<=5;i++)
        {
            imageModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
        }
    }
}