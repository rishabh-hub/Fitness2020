package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.FitnessVideoAdapter;
import com.example.fitness2020.Adapters.HomePageClientAdapter;
import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Models.ClientModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.PopularRvModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class HomeFitnessatWorkTab extends Fragment {

    View view;
    Context context;
   RecyclerView clientRV,videoRV,reviewRV;
   HomePageClientAdapter clientAdapter,reviewAdapter;
   FitnessVideoAdapter videoAdapter;
   ArrayList<VideoModel> videoModels = new ArrayList<>();
   ArrayList<ReviewModel> reviews = new ArrayList<>();
   ArrayList<ClientModel> clients = new ArrayList<>();

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

        clientRV = view.findViewById(R.id.fitness_at_work_clients_rv);
        videoRV = view.findViewById(R.id.home_fitness_at_work_video_rv);
        reviewRV = view.findViewById(R.id.fitness_at_work_reviews_rv);

        reviewRV.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        clientRV.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
        videoRV.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));

        for (int i = 0;i<10;i++)
            clients.add(new ClientModel(R.drawable.company_logo));

        for (int i=0;i<5;i++)
            videoModels.add(new VideoModel(R.drawable.gym_video_dummy));

        for (int i=0;i<5;i++)
            reviews.add(new ReviewModel("Tiger Shroff","ABC GYM","lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores."));





        reviewAdapter = new HomePageClientAdapter(reviews,context,1);
        clientAdapter = new HomePageClientAdapter(clients,context);
        videoAdapter = new FitnessVideoAdapter(videoModels,context);

        reviewRV.setAdapter(reviewAdapter);
        clientRV.setAdapter(clientAdapter);
        videoRV.setAdapter(videoAdapter);

//        popularRvModels=new ArrayList<>(3);
//        trendingRvModels=new ArrayList<TrendingRvModel>(3);
//        popularHorizontalRvModels=new ArrayList<>(3);

//        addData();

//        homePopularRVAdapter=new HomePopularRVAdapter(popularRvModels,context);
//        adapter=new HomeTrendingRVAdapter(trendingRvModels,context,1,popularHorizontalRvModels);
//        banner2Adapter=new HomeTrendingRVAdapter(trendingRvModels,context,2,popularHorizontalRvModels);


//        popularRv.setAdapter(homePopularRVAdapter);
//        trendingRv.setAdapter(adapter);
//        banner2Rv.setAdapter(banner2Adapter);
//        homePopularRVAdapter.notifyDataSetChanged();
//        adapter.notifyDataSetChanged();
//        banner2Adapter.notifyDataSetChanged();

        return view;
    }

//    void addData()//when using api, add data from api here.
//    {
//        for(int i=0;i<4;i++)
//        {
//
//            trendingRvModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
//
//            popularRvModels.add(new PopularRvModel(R.mipmap.ic_launcher,"Gym name","Category"," Gym Address","Recommended","4.9"));
//
//            popularHorizontalRvModels.add(new PopularHorizontalRvModel(R.drawable.trending_activity,"Gym name","Gym Category","Available on thi day from time -"));
//
//        }
//
//    }
}
