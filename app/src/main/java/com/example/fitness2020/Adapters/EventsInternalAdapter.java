package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class EventsInternalAdapter extends RecyclerView.Adapter<EventsInternalAdapter.EventsInternalAdapterRvVH> {

    Context context;
    int code;
    ArrayList<VideoModel> imageModels,videoModels;
    ArrayList<DateModel> categoryModels;

    public EventsInternalAdapter(Context context, int code, ArrayList<VideoModel> imageModels, ArrayList<VideoModel> videoModels, ArrayList<DateModel> categoryModels) {
        this.context = context;
        this.code = code;
        this.imageModels = imageModels;
        this.videoModels = videoModels;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public EventsInternalAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if (code==0)
//        return new EventsInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.,parent,false));
//
//        else if (code==1)
//            return new EventsInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.,parent,false));
//
//        else
//            return new EventsInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.,parent,false));
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EventsInternalAdapterRvVH holder, int position) {

        if (code==0)
            holder.populateImage(imageModels.get(position));

        else if (code==1)
            holder.populateVideo(videoModels.get(position));
        else
            holder.populateCategory(categoryModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (code==0)
            return imageModels.size();

        else if (code==1)
            return videoModels.size();
        else
            return categoryModels.size();
    }

    public class EventsInternalAdapterRvVH extends RecyclerView.ViewHolder
    {
        ImageView image,video;
        TextView category;

        public EventsInternalAdapterRvVH(@NonNull View itemView) {
            super(itemView);

//            if (code==0) {
//                image=itemView.findViewById(R.id.);
//            }
//
//            else if (code==1) {
//                video =itemView.findViewById(R.id.);
//            }
//            else {
//                category=itemView.findViewById(R.id.);
//            }
        }

        public void populateImage(VideoModel videoModel) {
            image.setImageResource(videoModel.getVideoImageResource());
        }

        public void populateVideo(VideoModel videoModel) {
            video.setImageResource(videoModel.getVideoImageResource());
        }

        public void populateCategory(DateModel dateModel) {
            category.setText(dateModel.getDate());
        }
    }
}
