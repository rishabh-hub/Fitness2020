package com.example.fitness2020;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Models.TrendingRvModel;

import java.util.ArrayList;

public class ValidityCardActivity extends AppCompatActivity {

    RecyclerView imageRv;
    ArrayList<FaqModel> faqs;
    ArrayList<TrendingRvModel> imageModels;
    SubscriptionCardsAdapter imageRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validity_card);

        attachId();

        imageRv.setLayoutManager(new LinearLayoutManager(ValidityCardActivity.this,LinearLayoutManager.HORIZONTAL,false));

        imageModels=new ArrayList<>(3);
        faqs = new ArrayList<>(3);

        addData();

        imageRvAdapter=new SubscriptionCardsAdapter(ValidityCardActivity.this,0,imageModels,faqs);

        imageRv.setAdapter(imageRvAdapter);

        imageRvAdapter.notifyDataSetChanged();

    }

    void attachId()
    {
        imageRv=findViewById(R.id.validity_card_imagerv);
    }

    void addData()
    {
        for (int i=0;i<=5;i++)
        {
            imageModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
        }
    }
}
