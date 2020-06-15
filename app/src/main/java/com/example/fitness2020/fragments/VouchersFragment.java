package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.EventsAdapter;
import com.example.fitness2020.Adapters.VouchersInternalAdapter;
import com.example.fitness2020.Models.EventsModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VouchersFragment extends Fragment {
    View view;
    Context context;
    RecyclerView imageRv,offerZoneRV,pleasureRV,healthRV,experienceRV,shoppingRV,travelRV;
    ArrayList<VideoModel> imageModels;
    ArrayList<VouchersModel>  offerZoneModels, pleasureModels,healthModels,experienceModels,shoppingModels,travelModels;
    VouchersInternalAdapter offerZoneAdapter,pleasureAdapter,healthAdapter,experienceAdapter,shoppingAdapter,travelAdapter,videoAdapter;
    public VouchersFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_vouchers,container,false);
        attachId();

        setLayoutManager();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        updateData();

        return view;

    }

    private void attachId() {
        imageRv = view.findViewById(R.id.voucher_head_banner_rv);
        offerZoneRV = view.findViewById(R.id.voucher_offer_zone_rv);
        pleasureRV = view.findViewById(R.id.voucher_pleasure_rv);
        healthRV = view.findViewById(R.id.voucher_health_rv);
        experienceRV = view.findViewById(R.id.voucher_experiences_rv);
        shoppingRV = view.findViewById(R.id.voucher_shopping_rv);
        travelRV = view.findViewById(R.id.voucher_travel_rv);
    }
    private void setLayoutManager() {
        imageRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        offerZoneRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        pleasureRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        healthRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        experienceRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        shoppingRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        travelRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

    }
    private void initArrayList() {
        offerZoneModels = new ArrayList<>();
        pleasureModels = new ArrayList<>();
        healthModels = new ArrayList<>();
        experienceModels = new ArrayList<>();
        shoppingModels = new ArrayList<>();
        travelModels = new ArrayList<>();
        imageModels = new ArrayList<>();
    }
    private void addData() {
        for(int i=0;i<5;i++)
        {
            offerZoneModels.add(new VouchersModel("Flat 50% OFF","Gym Company","4","Till Jun '20",R.drawable.gym_voucher,"FREE"));
            pleasureModels.add(new VouchersModel("Flat 50% OFF","Gym Company","4","Till Jun '20",R.drawable.gym_voucher,"FREE"));
            healthModels.add(new VouchersModel("Flat 50% OFF","Gym Company","4","Till Jun '20",R.drawable.gym_voucher,"FREE"));
            experienceModels.add(new VouchersModel("Flat 50% OFF","Gym Company","4","Till Jun '20",R.drawable.gym_voucher,"FREE"));
            shoppingModels.add(new VouchersModel("Flat 50% OFF","Gym Company","4","Till Jun '20",R.drawable.gym_voucher,"FREE"));
            travelModels.add(new VouchersModel("Flat 50% OFF","Gym Company","4","Till Jun '20",R.drawable.gym_voucher,"FREE"));
            imageModels.add(new VideoModel(R.drawable.brand_video_dummy));
        }
    }
    private void initAdapter() {
        offerZoneAdapter = new VouchersInternalAdapter(context,6,pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels,imageModels);
        pleasureAdapter = new VouchersInternalAdapter(context,1,pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels,imageModels);
        healthAdapter = new VouchersInternalAdapter(context,2,pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels,imageModels);
        experienceAdapter = new VouchersInternalAdapter(context,3,pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels,imageModels);
        shoppingAdapter = new VouchersInternalAdapter(context,4,pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels,imageModels);
        travelAdapter = new VouchersInternalAdapter(context,5,pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels,imageModels);
        videoAdapter = new VouchersInternalAdapter(context,0,pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels,imageModels);
    }
    private void attachAdapter() {
        offerZoneRV.setAdapter(offerZoneAdapter);
        pleasureRV.setAdapter(pleasureAdapter);
        healthRV.setAdapter(healthAdapter);
        experienceRV.setAdapter(experienceAdapter);
        shoppingRV.setAdapter(shoppingAdapter);
        travelRV.setAdapter(travelAdapter);
        imageRv.setAdapter(videoAdapter);
    }
    private void updateData() {
        offerZoneAdapter.notifyDataSetChanged();
        pleasureAdapter.notifyDataSetChanged();
        healthAdapter.notifyDataSetChanged();
        experienceAdapter.notifyDataSetChanged();
        shoppingAdapter.notifyDataSetChanged();
        travelAdapter.notifyDataSetChanged();


    }
}
