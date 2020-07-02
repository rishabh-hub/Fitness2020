package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitness2020.Adapters.LocationAdapter;
import com.example.fitness2020.Models.AddressModel;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {

    SearchView locationSearch;
    RecyclerView popularLocations;
    LocationAdapter locationAdapter;
    ArrayList<AddressModel> addressModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        attachId();
        locationSearch.setIconifiedByDefault(true);
        locationSearch.setFocusable(true);
        locationSearch.setIconified(false);
        locationSearch.requestFocusFromTouch();
        locationSearch.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                finish();
                return false;
            }
        });

        popularLocations.setLayoutManager(new LinearLayoutManager(LocationActivity.this,LinearLayoutManager.VERTICAL,false));

        addressModels=new ArrayList<>(3);

        addData();

        locationAdapter=new LocationAdapter(addressModels);

        popularLocations.setAdapter(locationAdapter);

        locationAdapter.notifyDataSetChanged();
    }

    private void addData() {

        for (int i=0;i<=5;i++)
        {
            addressModels.add(new AddressModel("221 Baker Street, New Delhi"));
        }
    }

    private void attachId() {
        locationSearch=findViewById(R.id.location_searvh_view);
        popularLocations=findViewById(R.id.location_rv);

    }


}