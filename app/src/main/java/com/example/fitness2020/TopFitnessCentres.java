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

public class TopFitnessCentres extends AppCompatActivity {

    RecyclerView verticalRv;
    ImageButton back;
    TextView head;
    HomePopularRVAdapter itemsAdapter;
    ArrayList<PopularRvModel> itemsModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_fitness_centres);

        attachId();

        verticalRv.setLayoutManager(new LinearLayoutManager(TopFitnessCentres.this,LinearLayoutManager.VERTICAL,false));

        itemsModel=new ArrayList<>(3);

        addData();

        itemsAdapter=new HomePopularRVAdapter(itemsModel,TopFitnessCentres.this);

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
        verticalRv=findViewById(R.id.top_fitness_centres_page_rv);
        head = findViewById(R.id.top_fitness_centres_main_head);
        back = findViewById(R.id.top_fitness_centres_back_button);
    }
    void addData()
    {
        for (int i=0;i<8;i++)
            itemsModel.add(new PopularRvModel(R.drawable.gym_photo,"One More Rep","Crossfit, Zumba","Mumbai,Maharashtra ,400022","50 % OFF","4.9"));

    }
}