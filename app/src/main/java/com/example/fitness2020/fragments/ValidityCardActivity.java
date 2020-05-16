package com.example.fitness2020.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class ValidityCardActivity extends AppCompatActivity {

    RecyclerView imageRv,faqRV;
    ArrayList<FaqModel> faqs;
    ArrayList<TrendingRvModel> imageModels;
    SubscriptionCardsAdapter imageRvAdapter,faqAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validity_card);

        attachId();

        imageRv.setLayoutManager(new LinearLayoutManager(ValidityCardActivity.this,LinearLayoutManager.HORIZONTAL,false));
        faqRV.setLayoutManager(new LinearLayoutManager(ValidityCardActivity.this,LinearLayoutManager.VERTICAL,false));

        imageModels=new ArrayList<>(3);
        faqs = new ArrayList<>(3);

        addData();

        imageRvAdapter=new SubscriptionCardsAdapter(ValidityCardActivity.this,0,imageModels,faqs);
        faqAdapter = new SubscriptionCardsAdapter(ValidityCardActivity.this,1,imageModels,faqs);

        imageRv.setAdapter(imageRvAdapter);
        faqRV.setAdapter(faqAdapter);

        imageRvAdapter.notifyDataSetChanged();
        faqAdapter.notifyDataSetChanged();

    }

    void attachId()
    {
        imageRv=findViewById(R.id.validity_card_imagerv);
        faqRV = findViewById(R.id.validity_card_faq_rv);
    }

    void addData()
    {
        for (int i=0;i<=5;i++)
        {
            imageModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
            faqs.add(new FaqModel("Q. Some Question about MemberShip?","A. Corresponding answer about MemberShip"));
        }
    }
}
