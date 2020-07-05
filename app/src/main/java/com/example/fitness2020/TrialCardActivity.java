package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.fitness2020.Adapters.MembershipInternalAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.BenefitsModel;
import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Models.MembershipInternalModel;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.TrendingRvModel;

import java.util.ArrayList;

public class TrialCardActivity extends AppCompatActivity {

    ArrayList<MembershipInternalModel> membershipInternalModels;
    ArrayList<BenefitsModel> benefitsModels;
    RecyclerView membershipRv;
    RecyclerView benefitsRv;
    MembershipInternalAdapter benefitsAdapter,membershipAdapter;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_card);

        attachId();

        membershipRv.setLayoutManager(new LinearLayoutManager(TrialCardActivity.this,LinearLayoutManager.VERTICAL,false));
        benefitsRv.setLayoutManager(new LinearLayoutManager(TrialCardActivity.this,LinearLayoutManager.VERTICAL,false));

        membershipInternalModels=new ArrayList<>(3);
        benefitsModels=new ArrayList<>(3);

        addData();

        benefitsAdapter=new MembershipInternalAdapter(1,membershipInternalModels,benefitsModels);
        membershipAdapter=new MembershipInternalAdapter(0,membershipInternalModels,benefitsModels);

        benefitsRv.setAdapter(benefitsAdapter);
        membershipRv.setAdapter(membershipAdapter);

        benefitsAdapter.notifyDataSetChanged();
        membershipAdapter.notifyDataSetChanged();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void attachId()
    {
        backButton=findViewById(R.id.memberships_page_back_btn);
        membershipRv=findViewById(R.id.membership_internal_rv);
        benefitsRv=findViewById(R.id.membership_benefit_rv);
    }

    void addData()
    {
        for (int i=0;i<=5;i++)
        {
            membershipInternalModels.add(new MembershipInternalModel("Heading","₹999","6 months"));
            benefitsModels.add(new BenefitsModel("Unrestricted access to 20+ Fitness Activities"));
        }
    }
}
