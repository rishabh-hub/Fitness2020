package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.GymActivitiesModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GymAdapter extends RecyclerView.Adapter<GymAdapter.GymAdapterVH> {

    Context context;
    ArrayList<TrendingRvModel> imageModels;
    int code;
    ArrayList<VideoModel> videoModels;
    ArrayList<GymActivitiesModel> gymActivitiesModels;

    public GymAdapter(Context context, ArrayList<TrendingRvModel> imageModels, int code, ArrayList<VideoModel> videoModels, ArrayList<GymActivitiesModel> gymActivitiesModels) {
        this.context = context;
        this.imageModels = imageModels;
        this.code = code;
        this.videoModels = videoModels;
        this.gymActivitiesModels = gymActivitiesModels;
    }

    @NonNull
    @Override
    public GymAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code==1)
        return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trialcard_imagerv_xml,parent,false));

        else if(code==2)
            return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));

        else
            return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_activities_rv_item,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull GymAdapterVH holder, int position) {

        if (code==1)
            holder.imagePopulate(imageModels.get(position));
        else if(code==2)
            holder.videoPopulate(videoModels.get(position));
        else
            holder.gymActivityPopulate(gymActivitiesModels.get(position));

    }

    @Override
    public int getItemCount() {
        if (code ==1)
        return imageModels.size();
        else if(code==2)
            return  videoModels.size();
        else
            return gymActivitiesModels.size();
    }

    public class GymAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView gymImage, gymVideo;
        TextView gymActivity;

        public GymAdapterVH(@NonNull View itemView) {
            super(itemView);

            if (code==1)
                gymImage=itemView.findViewById(R.id.rv_item_trailcard_imgvw);

            else if(code==2)
                gymVideo=itemView.findViewById(R.id.home_fitness_at_work_video);

            else
             gymActivity=itemView.findViewById(R.id.gym_activity_rv_activity);

        }

        void imagePopulate(TrendingRvModel trendingRvModel)
        {
            gymImage.setImageResource(trendingRvModel.getImageUrl());
        }

        void videoPopulate(VideoModel videoModel)
        {
            gymVideo.setImageResource(videoModel.getVideoImageResource());
        }

        void gymActivityPopulate(GymActivitiesModel gymActivitiesModel)
        {
            gymActivity.setText(gymActivitiesModel.getActivity());
        }
    }
}
