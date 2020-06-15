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
//    VoucherInternalAdapter offerzoneAdapter,pleasureAdapter,healthAdapter,experienceAdapter,shoppingAdapter,travelAdapter,videoAdapter;
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
        //        offerzoneAdapter = new VoucherInternalAdapter();
//        pleasureAdapter = new VoucherInternalAdapter();
//        healthAdapter = new VoucherInternalAdapter();
//        experienceAdapter = new VoucherInternalAdapter();
//        shoppingAdapter = new VoucherInternalAdapter();
//        travelAdapter = new VoucherInternalAdapter();
//        videoAdapter = new VoucherInternalAdapter();
    }
    private void attachAdapter() {
//        offerZoneRV.setAdapter();
//        pleasureRV.setAdapter();
//        healthRV.setAdapter();
//        experienceRV.setAdapter();
//        shoppingRV.setAdapter();
//        travelRV.setAdapter();
//        imageRv.setAdapter();
    }
    private void updateData() {
//        offerZoneAdapter.notifyDataSetChanged();
//        pleasureAdapter.notifyDataSetChanged();
//        healthAdapter.notifyDataSetChanged();
//        experienceAdapter.notifyDataSetChanged();
//        shoppingAdapter.notifyDataSetChanged();
//        travelAdapter.notifyDataSetChanged();


    }
}
