package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.CarousalsAdapter1;
import com.example.fitness2020.Adapters.GymAdapter;
import com.example.fitness2020.Models.CompanyModel;
import com.example.fitness2020.Models.GymActivitiesModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.Models.WebinarModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class EveningFragmentTab extends Fragment {

    View view;
    Context context;
    ArrayList<GymActivitiesModel> gymActivitiesModels=new ArrayList<>();
    ArrayList<WebinarModel> webinarModels= new ArrayList<>();
    ArrayList<CompanyModel> companyModels=new ArrayList<>();
    ArrayList<VouchersModel> vouchersModels=new ArrayList<>();
    ArrayList<VideoModel> videoModels=new ArrayList<>();
    ArrayList<TrendingRvModel> trendingRvModels=new ArrayList<>();
    RecyclerView webinarRv,activitiesRv;
    CarousalsAdapter1 webinarAdapter;
    GymAdapter activitiesAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.webinar_evening_tab_layout,container,false);

        attachId();

        webinarRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        activitiesRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        addData();

        webinarAdapter=new CarousalsAdapter1(context,companyModels,vouchersModels,webinarModels,0,1);
        activitiesAdapter=new GymAdapter(context,trendingRvModels,3,videoModels,gymActivitiesModels);

        webinarRv.setAdapter(webinarAdapter);
        activitiesRv.setAdapter(activitiesAdapter);

        webinarAdapter.notifyDataSetChanged();
        activitiesAdapter.notifyDataSetChanged();

        return view;
    }

    void attachId()
    {
        activitiesRv=view.findViewById(R.id.webinar_evening_activity_rv);
        webinarRv=view.findViewById(R.id.webinar_evening_rv);
    }

    void addData()
    {
        for (int i=0;i<=6;i++)
        {
            webinarModels.add(new WebinarModel("Functional Training", "21:00 - 22:00", "INTERMEDIATE", "Crossfit/Zumba", R.drawable.gym_dummy));
            gymActivitiesModels.add(new GymActivitiesModel("Crossfit"));
        }
    }
}
