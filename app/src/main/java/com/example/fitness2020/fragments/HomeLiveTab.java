package com.example.fitness2020.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.CarousalsAdapter1;
import com.example.fitness2020.Adapters.HomePageClientAdapter;
import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Adapters.NewCorrectionAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.CompanyModel;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.PopularRvModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.Models.WebinarModel;
import com.example.fitness2020.R;
import com.example.fitness2020.VideosActivity;
import com.example.fitness2020.WebinarTabActivity;

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
    ArrayList<PopularRvModel> popularRvModels;
    ArrayList<PopularHorizontalRvModel> popularHorizontalRvModels;

    RecyclerView liveTopBannerRv;
    RecyclerView liveMembershiRv;
    RecyclerView liveTrendingRv;
    RecyclerView liveWebinarRv1, liveWebinarRv2,liveWebinarRv3;
    RecyclerView liveReviewRv;
    ArrayList<ReviewModel> liveReviewModel;
    ArrayList<TrendingRvModel> liveTopBannerModel;
    ArrayList<PackModel> packModels;
    ArrayList<TrendingRvModel> liveTrendingModel;
    ArrayList<WebinarModel> liveWebinarModels1, liveWebinarModels2,liveWebinarModels3;
    ArrayList<VouchersModel> liveVouchersModels;
    ArrayList<CompanyModel> liveCompanyModels;
    HomeTrendingRVAdapter liveTrendingRvAdapter;
    HomeTrendingRVAdapter liveTopBannerAdapter;
    SubscriptionCardsAdapter liveMembershipAdapter;
    HomePageClientAdapter liveReviewAdapter;
    CarousalsAdapter1 liveWebinarAdapter1, liveWebinarAdapter2,liveWebinarAdapter3;

    NewCorrectionAdapter newCorrectionAdapter;
    ArrayList<TrendingRvModel> webinarVideos,trendingRvModels;
    TextView webinarViewMore;
    TextView buzzingViewMoreButton;



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
        liveTrendingRv=view.findViewById(R.id.live_trending_rv);//This is for videos
        liveWebinarRv1=view.findViewById(R.id.live_webinar_rv_1);
        liveWebinarRv2=view.findViewById(R.id.live_webinar_rv_2);
        liveWebinarRv3=view.findViewById(R.id.live_webinar_rv_3);
        liveReviewRv=view.findViewById(R.id.live_reviews_rv);
        webinarViewMore=view.findViewById(R.id.webinar_live_view_more_btn);
        buzzingViewMoreButton=view.findViewById(R.id.live_buzzing_viewmore_btn);

        liveTopBannerRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        liveMembershiRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        liveTrendingRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        liveWebinarRv1.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        liveWebinarRv2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        liveReviewRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        liveWebinarRv3.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));


        liveTopBannerModel=new ArrayList<>(3);
        packModels=new ArrayList<>(3);
        liveTrendingModel=new ArrayList<>(3);
        liveWebinarModels1 =new ArrayList<>(3);
        liveWebinarModels2 =new ArrayList<>(3);
        liveReviewModel=new ArrayList<>(3);
        liveWebinarModels3=new ArrayList<>(3);
        trendingRvModels=new ArrayList<>(3);
        webinarVideos=new ArrayList<>(3);

        addData();

        liveTopBannerAdapter=new HomeTrendingRVAdapter(liveTopBannerModel,context,1,popularHorizontalRvModels);
        liveMembershipAdapter=new SubscriptionCardsAdapter(context,2,packModels);
        newCorrectionAdapter=new NewCorrectionAdapter(0,webinarVideos,trendingRvModels);//new correction  adapter
        liveWebinarAdapter1 =new CarousalsAdapter1(context,liveCompanyModels,liveVouchersModels,liveWebinarModels1,0);
        liveWebinarAdapter2 =new CarousalsAdapter1(context,liveCompanyModels,liveVouchersModels,liveWebinarModels2,0);
        liveReviewAdapter=new HomePageClientAdapter(liveReviewModel,context,1);
        liveWebinarAdapter3=new CarousalsAdapter1(context,liveCompanyModels,liveVouchersModels,liveWebinarModels3,0);

        liveTopBannerRv.setAdapter(liveTopBannerAdapter);
        liveMembershiRv.setAdapter(liveMembershipAdapter);
        liveTrendingRv.setAdapter(newCorrectionAdapter);
        liveWebinarRv1.setAdapter(liveWebinarAdapter1);
        liveWebinarRv2.setAdapter(liveWebinarAdapter2);
        liveReviewRv.setAdapter(liveReviewAdapter);
        liveWebinarRv3.setAdapter(liveWebinarAdapter3);

        liveTopBannerAdapter.notifyDataSetChanged();
        liveMembershipAdapter.notifyDataSetChanged();
        newCorrectionAdapter.notifyDataSetChanged();
        liveWebinarAdapter1.notifyDataSetChanged();
        liveWebinarAdapter2.notifyDataSetChanged();
        liveReviewAdapter.notifyDataSetChanged();
        liveWebinarAdapter3.notifyDataSetChanged();

        buzzingViewMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videosIntent=new Intent(getContext(), VideosActivity.class);
                startActivity(videosIntent);
            }
        });

        webinarViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), WebinarTabActivity.class);
                startActivity(intent);
            }
        });

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

            liveTrendingModel.add(new TrendingRvModel(R.drawable.trending_activity));



            liveReviewModel.add(new ReviewModel("Tiger Shroff","ABC GYM","lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores lorem ipsum dolores."));


            webinarVideos.add(new TrendingRvModel(R.drawable.trending_activity));
//            trendingRvModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
//
//            popularRvModels.add(new PopularRvModel(R.mipmap.ic_launcher,"Gym name","Category"," Gym Address","Recommended","4.9"));
//
//            popularHorizontalRvModels.add(new PopularHorizontalRvModel(R.drawable.trending_activity,"Gym name","Gym Category","Available on thi day from time -","4.9"));

        }

        for (int i=0;i<3;++i)
        {
            liveWebinarModels1.add(new WebinarModel("Functional Training","9:00 - 10:00","INTERMEDIATE","Crossfit/Zumba",R.drawable.gym_dummy));

            liveWebinarModels2.add(new WebinarModel("Functional Training 2","10:00 - 11:00","ADVANCED","Swimming",R.drawable.gym_dummy));

            liveWebinarModels3.add(new WebinarModel("Functional Training","9:00 - 10:00","INTERMEDIATE","Crossfit/Zumba",R.drawable.gym_dummy));
        }

    }
}
