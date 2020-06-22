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

public class Fitness2020MembershipTab extends Fragment {

    View view;
    Context context;
    RecyclerView membershipFitness2020RV;
    MembershipActivityAdapter adapter;
    ArrayList<Fitness2020Model> models;
    ArrayList<GymMembershipModel> dummylist;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_fitness2020_membership,container,false);

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
        membershipFitness2020RV = view.findViewById(R.id.fitness2020_membership_RV);
    }

    private void setLayout() {
        membershipFitness2020RV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrayList() {
        models = new ArrayList<>();
        dummylist = new ArrayList<>();
    }

    private void addData() {
        for (int i=0;i<3;i++)
            models.add(new Fitness2020Model(R.drawable.gym_dummy,"6 Month Subscription","1003112","₹1299","21 Jan 2020","20 Aug 2020","13 Sep 2020","12 Sep 2020","+91 9318458933","20 Jul 2020"));
    }

    private void initAdapter() {
        adapter = new MembershipActivityAdapter(0,dummylist,models);
    }

    private void attachAdapter() {
        membershipFitness2020RV.setAdapter(adapter);
    }

    private void updateAdapter() {
        adapter.notifyDataSetChanged();
    }

}
