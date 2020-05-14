package com.example.fitness2020.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class FitnessVideoAdapter extends RecyclerView.Adapter<FitnessVideoAdapter.VideoVH> {
    ArrayList<VideoModel> videos;
    Context context;

    public FitnessVideoAdapter(ArrayList<VideoModel> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public FitnessVideoAdapter.VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessVideoAdapter.VideoVH holder, int position) {
        holder.populate(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class VideoVH extends RecyclerView.ViewHolder {
        VideoView videoView;
        MediaController mediaController;
        public VideoVH(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.home_fitness_at_work_video);
            mediaController=new MediaController(context);
        }

        public void populate(VideoModel videoModel) {
           // Uri uri=Uri.parse()
        }
    }
}
