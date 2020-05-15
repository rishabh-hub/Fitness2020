package com.example.fitness2020.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.fitness2020.Adapters.FitnessFragmentFreeTrialAdapter;
import com.example.fitness2020.Adapters.FitnessVideoAdapter;
import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class PassFragment extends Fragment {

    View view;
    TextView textView;
    RecyclerView fitnessPassRV;
    ArrayList<PopularHorizontalRvModel> fitnessPassModels ;

    RecyclerView freeTrialRV;
    ArrayList<FitnessFragmentFreeTrialModel> fragmentFreeTrialModels;

    RecyclerView videoRV;
    ArrayList<VideoModel> videos;
    FitnessVideoAdapter videoAdapter;

    FitnessFragmentFreeTrialAdapter fragmentFreeTrialAdapter,fitnessPassAdapter;
    Context context;
    CardView trialCard,workoutCard,validityCard;

    public PassFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_pass,container,false);

        attachId();

        freeTrialRV.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false));
        fitnessPassRV.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        videoRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        fragmentFreeTrialModels=new ArrayList<>(3);
        fitnessPassModels = new ArrayList<>(3);
        videos = new ArrayList<>(3);

        addData();

        fragmentFreeTrialAdapter=new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,context,fitnessPassModels,1);
        fitnessPassAdapter = new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,context,fitnessPassModels,0);
        videoAdapter = new FitnessVideoAdapter(videos,context);

        freeTrialRV.setAdapter(fragmentFreeTrialAdapter);
        fitnessPassRV.setAdapter(fitnessPassAdapter);
        videoRV.setAdapter(videoAdapter);

        fragmentFreeTrialAdapter.notifyDataSetChanged();
        fitnessPassAdapter.notifyDataSetChanged();
        videoAdapter.notifyDataSetChanged();

        trialCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trialIntent =new Intent(getContext(),TrialCardActivity.class);

                startActivity(trialIntent);
            }
        });

        return view;
    }

    void addData() {

        for (int i = 0; i < 10; i++)
        {
            fragmentFreeTrialModels.add(new FitnessFragmentFreeTrialModel(R.drawable.trending_activity,"One More Rep","Mumbai,Maharashtra ,400022"));

        }
        for (int i=0;i<5;i++)
        {
            fitnessPassModels.add(new PopularHorizontalRvModel(R.drawable.trending_activity,"Gym name","Gym Category","Available on thi day from time -"));
        }
    }

    void attachId()
    {
        freeTrialRV=view.findViewById(R.id.pass_fragment_fitness_pass_rv);
        fitnessPassRV = view.findViewById(R.id.fitness_pass_banner2_rv);
        videoRV = view.findViewById(R.id.fitness_pass_video_rv);
        trialCard=view.findViewById(R.id.trial_card);
        workoutCard=view.findViewById(R.id.workout_card);
        validityCard=view.findViewById(R.id.validity_card);
    }
}
