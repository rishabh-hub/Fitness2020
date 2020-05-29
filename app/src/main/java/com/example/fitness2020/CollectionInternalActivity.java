package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.fitness2020.Adapters.CollectionsAdapter;
import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.PopularRvModel;

import java.util.ArrayList;

public class CollectionInternalActivity extends AppCompatActivity {
    RecyclerView verticalRv;
    ImageView topImage;
    HomePopularRVAdapter itemsAdapter;
    ArrayList<PopularRvModel> itemsModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_internal);

        attachId();

        verticalRv.setLayoutManager(new LinearLayoutManager(CollectionInternalActivity.this,LinearLayoutManager.VERTICAL,false));

        itemsModel=new ArrayList<>(3);

        addData();

        itemsAdapter=new HomePopularRVAdapter(itemsModel,CollectionInternalActivity.this);

        verticalRv.setAdapter(itemsAdapter);

        itemsAdapter.notifyDataSetChanged();
    }

    void attachId()
    {
        //verticalRv=findViewById(R.id.);
    }

    void addData()
    {

    }
}
