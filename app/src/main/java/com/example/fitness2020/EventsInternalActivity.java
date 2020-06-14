package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitness2020.Adapters.EventsInternalAdapter;
import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class EventsInternalActivity extends AppCompatActivity {

    RecyclerView imageRv,videoRv,categoryRv;
    ArrayList<VideoModel> imageModels,videoModels;
    ArrayList<DateModel> categorymodels;
    EventsInternalAdapter imageAdapter,videoAdapter,categoryAdapter;

    TextView eventName,eventPrice,eventLocation;
    ImageView locationIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_internal);

        attachId();

        setLayoutManager();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        updateData();
    }

    private void updateData() {
        imageAdapter.notifyDataSetChanged();
        videoAdapter.notifyDataSetChanged();
        categoryAdapter.notifyDataSetChanged();
    }

    private void attachAdapter() {
        imageRv.setAdapter(imageAdapter);
        videoRv.setAdapter(videoAdapter);
        categoryRv.setAdapter(categoryAdapter);
    }

    private void initAdapter() {
        imageAdapter=new EventsInternalAdapter(EventsInternalActivity.this,0,imageModels,videoModels,categorymodels);
        videoAdapter=new EventsInternalAdapter(EventsInternalActivity.this,1,imageModels,videoModels,categorymodels);
        categoryAdapter=new EventsInternalAdapter(EventsInternalActivity.this,2,imageModels,videoModels,categorymodels);
    }

    private void addData() {

        for (int i=0;i<=5;i++)
        {
            imageModels.add(new VideoModel(R.drawable.gym_video_dummy));
            videoModels.add(new VideoModel(R.drawable.gym_video_dummy));
            categorymodels.add(new DateModel("Premium"));
        }
    }

    private void initArrayList() {
        imageModels=new ArrayList<>(3);
        videoModels=new ArrayList<>(3);
        categorymodels=new ArrayList<>(3);
    }

    private void setLayoutManager() {
        imageRv.setLayoutManager(new LinearLayoutManager(EventsInternalActivity.this,LinearLayoutManager.HORIZONTAL,false));
        videoRv.setLayoutManager(new LinearLayoutManager(EventsInternalActivity.this,LinearLayoutManager.HORIZONTAL,false));
        categoryRv.setLayoutManager(new LinearLayoutManager(EventsInternalActivity.this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void attachId() {
//        imageRv=findViewById(R.id.event_internal_image_rv);
    }
}