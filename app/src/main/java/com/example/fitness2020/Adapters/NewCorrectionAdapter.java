package com.example.fitness2020.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;
import com.example.fitness2020.VideoInternalPage;

import java.util.ArrayList;

public class NewCorrectionAdapter extends RecyclerView.Adapter<NewCorrectionAdapter.NewCorrectionAdapterRvVH> {

    int code;
    ArrayList<TrendingRvModel> webinarVideos,trendingRvModels;

    public NewCorrectionAdapter(int code, ArrayList<TrendingRvModel> webinarVideos, ArrayList<TrendingRvModel> trendingRvModels) {
        this.code = code;
        this.webinarVideos = webinarVideos;
        this.trendingRvModels = trendingRvModels;
    }

    @NonNull
    @Override
    public NewCorrectionAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
            return new NewCorrectionAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));
        else
            return new NewCorrectionAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewCorrectionAdapterRvVH holder, int position) {

        if (code==0)
        holder.populateWebinarVideos(webinarVideos.get(position));

        else
            holder.populateTrending(trendingRvModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (code==0)
        return webinarVideos.size();
        else
            return trendingRvModels.size();
    }

    public class NewCorrectionAdapterRvVH extends RecyclerView.ViewHolder
    {
        ImageView trendingImage,webinarVideos;

        public NewCorrectionAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0) {
                webinarVideos = itemView.findViewById(R.id.home_fitness_at_work_video);
            }
            else {
                trendingImage = itemView.findViewById(R.id.trending_image_item);
            }
        }

        public void populateWebinarVideos(TrendingRvModel trendingRvModel) {
            webinarVideos.setImageResource(trendingRvModel.getImageUrl());

            webinarVideos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent videoInternalIntent=new Intent(itemView.getContext(), VideoInternalPage.class);
                    itemView.getContext().startActivity(videoInternalIntent);
                }
            });
        }

        public void populateTrending(TrendingRvModel trendingRvModel) {
            trendingImage.setImageResource(trendingRvModel.getImageUrl());
        }
    }
}
