package com.example.fitness2020.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitness2020.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GymAboutTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GymAboutTab extends Fragment {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gym_about_tab, container, false);
    }
}
