package com.example.fitness2020.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.fitness2020.Adapters.FitnessFragmentFreeTrialAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class TrialCardActivity extends AppCompatActivity {

    RecyclerView imageRv;
    ArrayList<FaqModel> faqs;
    ArrayList<TrendingRvModel> imageModels;
    SubscriptionCardsAdapter imageRvAdapter;
    RelativeLayout membershipcard1,membershipcard2,membershipcard3,membershipcard4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_card);

        attachId();

        imageRv.setLayoutManager(new LinearLayoutManager(TrialCardActivity.this,LinearLayoutManager.HORIZONTAL,false));

        imageModels=new ArrayList<>(3);

        addData();

        imageRvAdapter=new SubscriptionCardsAdapter(TrialCardActivity.this,0,imageModels,faqs);

        imageRv.setAdapter(imageRvAdapter);

        imageRvAdapter.notifyDataSetChanged();


    }

    void attachId()
    {
        imageRv=findViewById(R.id.trial_card_imagerv);
        membershipcard1 = findViewById(R.id.trial_membership_1);
        membershipcard2 = findViewById(R.id.trial_membership_2);
        membershipcard3 = findViewById(R.id.trial_membership_3);
        membershipcard4 = findViewById(R.id.trial_membership_4);
    }

    void addData()
    {
        for (int i=0;i<=5;i++)
        {
            imageModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
        }
    }
}
