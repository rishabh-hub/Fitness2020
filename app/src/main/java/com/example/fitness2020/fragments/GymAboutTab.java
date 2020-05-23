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
import com.example.fitness2020.Models.GymActivitiesModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GymAboutTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GymAboutTab extends Fragment {

    View view;
    Context context;
    RecyclerView gymActivityRv,gymPhotosRv,gymVideosRv;
    ArrayList<TrendingRvModel> imageModels;
    ArrayList<VideoModel> videoModels;
    ArrayList<GymActivitiesModel> gymActivitiesModels;
    GymAdapter gymPhotosAdapter;
    GymAdapter gymVideosAdapter,gymActivityAdapter;


    public GymAboutTab() {
    }

    public static GymAboutTab newInstance(String param1, String param2) {
        GymAboutTab fragment = new GymAboutTab();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_gym_about_tab,container,false);

        gymActivityRv=view.findViewById(R.id.gym_tab_activity_rv);
        gymPhotosRv=view.findViewById(R.id.gym_photos_rv);
        gymVideosRv=view.findViewById(R.id.gym_tab_videos_rv);

        gymPhotosRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        gymVideosRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        gymActivityRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        imageModels=new ArrayList<>(3);
        videoModels=new ArrayList<>(3);
        gymActivitiesModels=new ArrayList<>(3);

        addData();

        gymPhotosAdapter =new GymAdapter(context,imageModels,1,videoModels,gymActivitiesModels);
        gymVideosAdapter=new GymAdapter(context,imageModels,2,videoModels,gymActivitiesModels);
        gymActivityAdapter=new GymAdapter(context,imageModels,3,videoModels,gymActivitiesModels);

        gymPhotosRv.setAdapter(gymPhotosAdapter);
        gymVideosRv.setAdapter(gymVideosAdapter);
        gymActivityRv.setAdapter(gymActivityAdapter);

        gymPhotosAdapter.notifyDataSetChanged();
        gymVideosAdapter.notifyDataSetChanged();
        gymActivityAdapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return view;
    }

    void addData()
    {
        for(int i=0;i<=5;i++)
        {
            imageModels.add(new TrendingRvModel(R.mipmap.ic_launcher));
            videoModels.add(new VideoModel(R.mipmap.ic_launcher));

        }

        for(int i=0;i<=8;i++)
            gymActivitiesModels.add(new GymActivitiesModel("Crossfit"));

    }
}
