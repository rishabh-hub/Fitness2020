package com.example.fitness2020;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.GymAdapter;
import com.example.fitness2020.Models.GymFacilityModel;
import com.example.fitness2020.Models.GymOfferingModel;
import com.example.fitness2020.Models.ReviewModel;

import java.util.ArrayList;

public class CustomDialogClass extends Dialog {

    public Context context;
    public Dialog dialog;
    public Button button;
    RecyclerView offeringsRv;
    ArrayList<GymOfferingModel> gymOfferingModels;
    ArrayList<GymFacilityModel> facilityModels = new ArrayList<>();
    ArrayList<ReviewModel> reviewModels = new ArrayList<>();
    GymAdapter offeringsAdapter;

    public CustomDialogClass(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.offering_dialog);

        attachId();

        offeringsRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

        gymOfferingModels=new ArrayList<>(3);

        addData();

        offeringsAdapter=new GymAdapter(context,4,facilityModels,gymOfferingModels,reviewModels);

        offeringsRv.setAdapter(offeringsAdapter);

        offeringsAdapter.notifyDataSetChanged();
    }

    void attachId()
    {
        offeringsRv=findViewById(R.id.offerings_rv);
    }

    void addData()
    {
        for (int i=0;i<=6;i++)
            gymOfferingModels.add(new GymOfferingModel("OFFER NAME","Idk","DATA","DATA"));
    }
}
