package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Models.PopularRvModel;

import java.util.ArrayList;

public class PopularActivity extends AppCompatActivity {

    RecyclerView verticalRv;
    ImageButton back;
    TextView head;
    HomePopularRVAdapter itemsAdapter;
    ArrayList<PopularRvModel> itemsModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);

        attachId();

        verticalRv.setLayoutManager(new LinearLayoutManager(PopularActivity.this,LinearLayoutManager.VERTICAL,false));

        itemsModel=new ArrayList<>(3);

        addData();

        itemsAdapter=new HomePopularRVAdapter(itemsModel,PopularActivity.this);

        verticalRv.setAdapter(itemsAdapter);

        itemsAdapter.notifyDataSetChanged();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void attachId()
    {
        verticalRv=findViewById(R.id.popular_gyms_rv);
        head = findViewById(R.id.popular_page_main_head);
        back = findViewById(R.id.popular_page_back_btn);
    }
    void addData()
    {
        for (int i=0;i<8;i++)
            itemsModel.add(new PopularRvModel(R.drawable.gym_photo,"One More Rep","Crossfit, Zumba","Mumbai,Maharashtra ,400022","50 % OFF","4.9"));

    }
}