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
import com.example.fitness2020.Models.PopularRvModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class HomeFitnessatWorkTab extends Fragment {

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

    public HomeFitnessatWorkTab() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_fragment_fitnessat_work_tab,container,false);

        trendingRv=view.findViewById(R.id.home_trending_rv);
        popularRv=view.findViewById(R.id.home_popular_rv);
        banner2Rv=view.findViewById(R.id.home_banner2_rv);

        banner2Rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        popularRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        trendingRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        popularRvModels=new ArrayList<>(3);
        trendingRvModels=new ArrayList<TrendingRvModel>(3);

        addData();

        homePopularRVAdapter=new HomePopularRVAdapter(popularRvModels,context);
        adapter=new HomeTrendingRVAdapter(trendingRvModels,context,1);
        banner2Adapter=new HomeTrendingRVAdapter(trendingRvModels,context,2);


        popularRv.setAdapter(homePopularRVAdapter);
        trendingRv.setAdapter(adapter);
        banner2Rv.setAdapter(banner2Adapter);
        homePopularRVAdapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
        banner2Adapter.notifyDataSetChanged();

        return view;
    }

    void addData()//when using api, add data from api here.
    {
        for(int i=0;i<4;i++)
        {

            trendingRvModels.add(new TrendingRvModel(R.mipmap.ic_launcher));

            popularRvModels.add(new PopularRvModel(R.mipmap.ic_launcher,"Gym name","Category"," Gym Address","Recommended"));
        }

    }
}
