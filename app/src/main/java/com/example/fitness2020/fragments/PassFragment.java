package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.FitnessFragmentFreeTrialAdapter;
import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class PassFragment extends Fragment {

    View view;
    TextView textView;
    RecyclerView freeTrialRV;
    ArrayList<FitnessFragmentFreeTrialModel> fragmentFreeTrialModels;
    FitnessFragmentFreeTrialAdapter fragmentFreeTrialAdapter;
    Context context;

    public PassFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_pass,container,false);

        freeTrialRV=view.findViewById(R.id.pass_fragment_fitness_pass_rv);

        freeTrialRV.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false));

        fragmentFreeTrialModels=new ArrayList<>(3);

        addData();

        fragmentFreeTrialAdapter=new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,context);

        freeTrialRV.setAdapter(fragmentFreeTrialAdapter);

        fragmentFreeTrialAdapter.notifyDataSetChanged();

        return view;
    }

    void addData() {

        for (int i = 0; i < 10; i++)
        {
            fragmentFreeTrialModels.add(new FitnessFragmentFreeTrialModel(R.drawable.trending_activity,"One More Rep","Mumbai,Maharashtra ,400022"));

        }
    }
}
