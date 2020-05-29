package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitness2020.Adapters.CollectionsAdapter;
import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.PopularRvModel;

import java.util.ArrayList;

public class CollectionInternalActivity extends AppCompatActivity {
    RecyclerView verticalRv;
    ImageView topImage;
    ImageButton back;
    TextView head,subhead,numberOfPlaces;
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
        verticalRv=findViewById(R.id.collections_internal_page_rv);
        topImage = findViewById(R.id.collections_internal_image);
        head = findViewById(R.id.collections_internal_main_head);
        subhead = findViewById(R.id.collections_internal_sub_head);
        numberOfPlaces = findViewById(R.id.collections_internal_number_places);
        back = findViewById(R.id.collections_internal_back_button);
    }

    void addData()
    {
        for (int i=0;i<8;i++)
        itemsModel.add(new PopularRvModel(R.drawable.gym_photo,"One More Rep","Crossfit, Zumba","Mumbai,Maharashtra ,400022","50 % OFF","4.9"));

    }
}
