package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitness2020.Adapters.GymAdapter;
import com.example.fitness2020.Models.GymFacilityModel;
import com.example.fitness2020.Models.GymOfferingModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.R;

import java.util.ArrayList;


public class GymOfferTab extends Fragment {
    Context context;
    View view;
    ArrayList<GymFacilityModel> facilityModels = new ArrayList<>();
    ArrayList<GymOfferingModel> offeringModels = new ArrayList<>();
    ArrayList<ReviewModel> reviewModels = new ArrayList<>();
    RecyclerView facilityRV,offeringRV,reviewRV;
    GymAdapter facilityAdapter,offeringAdapter,reviewAdapter;

    public GymOfferTab() {
    }

    public static GymOfferTab newInstance(String param1, String param2) {
        GymOfferTab fragment = new GymOfferTab();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gym_offer_tab, container, false);
        attachID();
        facilityRV.setLayoutManager(new GridLayoutManager(context,2));
        offeringRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        reviewRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        addData();

        offeringAdapter = new GymAdapter(context,4,facilityModels,offeringModels,reviewModels);
        facilityAdapter = new GymAdapter(context,5,facilityModels,offeringModels,reviewModels);
        reviewAdapter = new GymAdapter(context,6,facilityModels,offeringModels,reviewModels);

        offeringRV.setAdapter(offeringAdapter);
        facilityRV.setAdapter(facilityAdapter);
        reviewRV.setAdapter(reviewAdapter);

        offeringAdapter.notifyDataSetChanged();
        facilityAdapter.notifyDataSetChanged();
        reviewAdapter.notifyDataSetChanged();
        
        return view;
    }

    private void addData() {
        for(int i=0;i<5;i++)
        {
            offeringModels.add(new GymOfferingModel("Yoga Classes","One Yoga Class","Free","200"));
            facilityModels.add(new GymFacilityModel("Yoga"));
            reviewModels.add(new ReviewModel("XYZ","ABC","Very Good Product."));
        }
    }

    private void attachID() {
        facilityRV = view.findViewById(R.id.gym_facilities_rv);
        offeringRV = view.findViewById(R.id.gym_offers_rv);
        reviewRV = view.findViewById(R.id.gym_tab_reviews_rv);
        context=view.getContext();
    }
}
