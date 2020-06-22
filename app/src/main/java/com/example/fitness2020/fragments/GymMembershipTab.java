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

import com.example.fitness2020.Adapters.MembershipActivityAdapter;
import com.example.fitness2020.Models.Fitness2020Model;
import com.example.fitness2020.Models.GymMembershipModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class GymMembershipTab extends Fragment {

    View view;
    Context context;
    RecyclerView membershipGymRV;
    MembershipActivityAdapter adapter;
    ArrayList<Fitness2020Model> dummylist;
    ArrayList<GymMembershipModel> models;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_gym_membership,container,false);
        attachId();

        setLayout();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        updateAdapter();

        return view;
    }
    private void attachId() {
        membershipGymRV = view.findViewById(R.id.gym_membership_RV);
    }

    private void setLayout() {
        membershipGymRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrayList() {
        models = new ArrayList<>();
        dummylist = new ArrayList<>();
    }

    private void addData() {
        for (int i=0;i<3;i++)
            models.add(new GymMembershipModel(R.drawable.gym_dummy,"Unlimited Workouts","ABC Fitness Center","₹12999","21 Jan 2020","21 Aug 2020","+91 9818541722","221 Baker Street,New Delhi"));
    }

    private void initAdapter() {
        adapter = new MembershipActivityAdapter(0,models,dummylist);
    }

    private void attachAdapter() {
        membershipGymRV.setAdapter(adapter);
    }

    private void updateAdapter() {
        adapter.notifyDataSetChanged();
    }
}
