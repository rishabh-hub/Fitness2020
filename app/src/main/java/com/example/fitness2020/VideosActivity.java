package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitness2020.Models.VideoModel;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {
    ArrayList<VideoModel> fitnessPassVideos = new ArrayList<>();
    ArrayList<VideoModel> dailyWorkoutVideos = new ArrayList<>();
    ArrayList<VideoModel> studioVideos = new ArrayList<>();
    ArrayList<VideoModel> corporateVideos = new ArrayList<>();
    RecyclerView passRV,workoutRV,studioRV,corporateRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        attachID();
        addDummyData();
        setLayoutManagers();
        initAdapter();
        setAdapters();

    }

    private void addDummyData() {
        for (int i=0;i<6;i++)
        {
//            fitnessPassVideos.add();
//            dailyWorkoutVideos.add();
//            studioVideos.add();
//            corporateVideos.add();
        }
    }

    private void setAdapters() {
    }

    private void initAdapter() {
    }

    private void setLayoutManagers() {
        passRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
        workoutRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
        studioRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
        corporateRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void attachID() {
//        passRV = findViewById();
//        workoutRV = findViewById();
//        studioRV = findViewById();
//        corporateRV = findViewById();
    }
}