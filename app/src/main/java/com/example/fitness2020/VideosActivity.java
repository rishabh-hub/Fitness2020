package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.fitness2020.Adapters.VideosAdapter;
import com.example.fitness2020.Models.VideoModel;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {
    ArrayList<VideoModel> fitnessPassVideos = new ArrayList<>();
    ArrayList<VideoModel> dailyWorkoutVideos = new ArrayList<>();
    ArrayList<VideoModel> studioVideos = new ArrayList<>();
    ArrayList<VideoModel> corporateVideos = new ArrayList<>();
//    ArrayList<VideosActivity> fitnesspassFragmentVideos=new ArrayList<>();
    RecyclerView passRV,workoutRV,studioRV,corporateRV;
    VideosAdapter fitnessPassVideoAdapter,dailyWorkoutVideoAdapter,studioVideoAdapter,corporateVideoAdapter;

    ImageButton backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        attachID();
        addDummyData();
        setLayoutManagers();
        initAdapter();
        setAdapters();


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(VideosActivity.this,MainActivity.class);
                startActivity(backIntent);
            }
        });

    }

    private void addDummyData() {
        for (int i=0;i<6;i++)
        {
            fitnessPassVideos.add(new VideoModel(R.drawable.gym_video_dummy));
            dailyWorkoutVideos.add(new VideoModel(R.drawable.brand_video_dummy));
            studioVideos.add(new VideoModel(R.drawable.gym_photo));
            corporateVideos.add(new VideoModel(R.drawable.gym_video_dummy));
        }
    }

    private void setAdapters() {
        passRV.setAdapter(fitnessPassVideoAdapter);
        workoutRV.setAdapter(dailyWorkoutVideoAdapter);
        studioRV.setAdapter(studioVideoAdapter);
        corporateRV.setAdapter(corporateVideoAdapter);
    }

    private void initAdapter() {
        fitnessPassVideoAdapter=new VideosAdapter(fitnessPassVideos,dailyWorkoutVideos,studioVideos,corporateVideos,VideosActivity.this,1);
        dailyWorkoutVideoAdapter=new VideosAdapter(fitnessPassVideos,dailyWorkoutVideos,studioVideos,corporateVideos,VideosActivity.this,2);
        studioVideoAdapter=new VideosAdapter(fitnessPassVideos,dailyWorkoutVideos,studioVideos,corporateVideos,VideosActivity.this,3);
        corporateVideoAdapter=new VideosAdapter(fitnessPassVideos,dailyWorkoutVideos,studioVideos,corporateVideos,VideosActivity.this,4);

    }

    private void setLayoutManagers() {
        passRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
        workoutRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
        studioRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
        corporateRV.setLayoutManager(new LinearLayoutManager(VideosActivity.this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void attachID() {
        passRV = findViewById(R.id.video_page_fitnesspass_rv);
        workoutRV = findViewById(R.id.video_page_dailyworkout_rv);
        studioRV = findViewById(R.id.video_page_studio_rv);
        corporateRV = findViewById(R.id.video_page_corporate_rv);
        backButton=findViewById(R.id.videos_activity_back_btn);
    }
}