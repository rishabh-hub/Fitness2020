package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.PopularRvModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class HomeLiveTab extends Fragment {


    View view;
    Context context;
    HomeTrendingRVAdapter adapter;
    HomeTrendingRVAdapter banner2Adapter;
    HomePopularRVAdapter homePopularRVAdapter;
    RecyclerView trendingRv;
    RecyclerView banner2Rv;
    RecyclerView popularRv;
    ArrayList<TrendingRvModel> trendingRvModels;
    ArrayList<PopularRvModel> popularRvModels;
    ArrayList<PopularHorizontalRvModel> popularHorizontalRvModels;

    RecyclerView liveTopBannerRv;
    ArrayList<TrendingRvModel> liveTopBannerModel;
    HomeTrendingRVAdapter liveTopBannerAdapter;
    SubscriptionCardsAdapter liveMembershipAdapter;
    RecyclerView liveMembershiRv;
    ArrayList<PackModel> packModels;


    public HomeLiveTab() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_fragment_free_trials_tab,container,false);


        liveTopBannerRv=view.findViewById(R.id.live_workout_rv);
        liveMembershiRv=view.findViewById(R.id.live_membership_rv);

        liveTopBannerRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        liveMembershiRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));


        liveTopBannerModel=new ArrayList<>(3);
        packModels=new ArrayList<>(3);

        addData();

        liveTopBannerAdapter=new HomeTrendingRVAdapter(liveTopBannerModel,context,1,popularHorizontalRvModels);
        liveMembershipAdapter=new SubscriptionCardsAdapter(context,2,packModels);

        liveTopBannerRv.setAdapter(liveTopBannerAdapter);
        liveMembershiRv.setAdapter(liveMembershipAdapter);

//        trendingRv=view.findViewById(R.id.home_trending_rv);
//        popularRv=view.findViewById(R.id.home_popular_rv);
//        banner2Rv=view.findViewById(R.id.home_banner2_rv);
//
//        banner2Rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
//        popularRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
//        trendingRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
//
//        popularRvModels=new ArrayList<>(3);
//        trendingRvModels=new ArrayList<TrendingRvModel>(3);
//        popularHorizontalRvModels=new ArrayList<>(3);
//
//
//        addData();
//
//        homePopularRVAdapter=new HomePopularRVAdapter(popularRvModels,context);
//        adapter=new HomeTrendingRVAdapter(trendingRvModels,context,1,popularHorizontalRvModels);
//        banner2Adapter=new HomeTrendingRVAdapter(trendingRvModels,context,2,popularHorizontalRvModels);
//
//
//        popularRv.setAdapter(homePopularRVAdapter);
//        trendingRv.setAdapter(adapter);
//        banner2Rv.setAdapter(banner2Adapter);
//        homePopularRVAdapter.notifyDataSetChanged();
//        adapter.notifyDataSetChanged();
//        banner2Adapter.notifyDataSetChanged();

        return view;
    }

    void addData()//when using api, add data from api here.
    {
        for(int i=0;i<=5;i++)
        {


            liveTopBannerModel.add(new TrendingRvModel(R.drawable.workout_carousel_dummy));

            packModels.add(new PackModel("Unlimited Workouts",99));
//            trendingRvModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
//
//            popularRvModels.add(new PopularRvModel(R.mipmap.ic_launcher,"Gym name","Category"," Gym Address","Recommended","4.9"));
//
//            popularHorizontalRvModels.add(new PopularHorizontalRvModel(R.drawable.trending_activity,"Gym name","Gym Category","Available on thi day from time -","4.9"));

        }

    }
}
