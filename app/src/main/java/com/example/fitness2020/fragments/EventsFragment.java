package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitness2020.Adapters.EventsAdapter;
import com.example.fitness2020.Models.EventsModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class EventsFragment extends Fragment {
    View view;
    Context context;
    RecyclerView imageRv,fitnessRv,recreationRv,specialTalksRv,weekendRv;
    ArrayList<VideoModel> imageModels;
    ArrayList<EventsModel>  fitnessModels, recreationModels,specialTalkModels,weekendModels;
    EventsAdapter imageEvents,fitnessEvents,recreationEvents,specialTalkEvents,weekendEvents;


    public EventsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_events,container,false);

        attachId();

        setLayoutManager();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        updateData();

        return view;
    }

    private void updateData() {
        imageEvents.notifyDataSetChanged();
        fitnessEvents.notifyDataSetChanged();
        recreationEvents.notifyDataSetChanged();
        specialTalkEvents.notifyDataSetChanged();
        weekendEvents.notifyDataSetChanged();
    }

    private void attachAdapter() {
        imageRv.setAdapter(imageEvents);
        fitnessRv.setAdapter(fitnessEvents);
        recreationRv.setAdapter(recreationEvents);
        specialTalksRv.setAdapter(specialTalkEvents);
        weekendRv.setAdapter(weekendEvents);
    }

    private void addData() {
        for (int i=0;i<=5;i++) {
            imageModels.add(new VideoModel(R.drawable.gym_video_dummy));
            fitnessModels.add(new EventsModel(R.drawable.gym_dummy, "Event 1", "999 Rs", "Mumbai", "Host Name"));
            recreationModels.add(new EventsModel(R.drawable.gym_dummy, "Event 1", "999 Rs", "Mumbai", "Host Name"));
            specialTalkModels.add(new EventsModel(R.drawable.gym_dummy, "Event 1", "999 Rs", "Mumbai", "Host Name"));
            weekendModels.add(new EventsModel(R.drawable.gym_dummy, "Event 1", "999 Rs", "Mumbai", "Host Name"));
        }
    }

    private void initAdapter() {

        imageEvents=new EventsAdapter(imageModels,fitnessModels,recreationModels,specialTalkModels,weekendModels,context,0);
        fitnessEvents=new EventsAdapter(imageModels,fitnessModels,recreationModels,specialTalkModels,weekendModels,context,1);
        recreationEvents=new EventsAdapter(imageModels,fitnessModels,recreationModels,specialTalkModels,weekendModels,context,2);
        specialTalkEvents=new EventsAdapter(imageModels,fitnessModels,recreationModels,specialTalkModels,weekendModels,context,3);
        weekendEvents=new EventsAdapter(imageModels,fitnessModels,recreationModels,specialTalkModels,weekendModels,context,4);
    }

    private void initArrayList() {
        imageModels=new ArrayList<>(3);
        fitnessModels=new ArrayList<>(3);
        recreationModels=new ArrayList<>(3);
        specialTalkModels=new ArrayList<>(3);
        weekendModels=new ArrayList<>(3);
    }

    private void setLayoutManager() {
        imageRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        fitnessRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        recreationRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        specialTalksRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        weekendRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
    }

    void attachId()
    {
        imageRv=view.findViewById(R.id.event_head_banner_rv);
        fitnessRv=view.findViewById(R.id.event_fitness_rv);
        recreationRv=view.findViewById(R.id.event_recreation_rv);
        specialTalksRv=view.findViewById(R.id.event_talks_rv);
        weekendRv=view.findViewById(R.id.event_weekend_rv);
    }
}
