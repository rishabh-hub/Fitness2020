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

import com.bumptech.glide.Glide;
import com.example.fitness2020.R;

public class EventsFragment extends Fragment {
    View view;
    TextView textView;
    ImageView imageView;
    Context context;
    public EventsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_events,container,false);
        textView=view.findViewById(R.id.events_tv);
        imageView=view.findViewById(R.id.events_iv);

        Glide.with(getContext()).load(R.mipmap.ic_launcher).into(imageView);
        return view;
    }
}
