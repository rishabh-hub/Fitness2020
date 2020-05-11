package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class HomeTrendingRVAdapter extends RecyclerView.Adapter<HomeTrendingRVAdapter.HomeTrendingRVAdapterVH> {

    ArrayList<TrendingRvModel> trendingRvModels;
    Context context;
    int code;

    public HomeTrendingRVAdapter(ArrayList<TrendingRvModel> trendingRvModels, Context context,int code) {
        this.trendingRvModels = trendingRvModels;
        this.context = context;
        this.code=code;
    }



    @NonNull
    @Override
    public HomeTrendingRVAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (code==1) {
            return new HomeTrendingRVAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_rv_xml, parent, false));
        }

        else{
            return new HomeTrendingRVAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner2_rv_xml,parent,false));
        }
        }

    @Override
    public void onBindViewHolder(@NonNull HomeTrendingRVAdapterVH holder, int position) {
        holder.populate(trendingRvModels.get(position));
    }

    @Override
    public int getItemCount() {
        return trendingRvModels.size();
    }

    public  class HomeTrendingRVAdapterVH extends RecyclerView.ViewHolder
    {

        ImageView trendingimageView;
        ImageView bannerImageview;
        public HomeTrendingRVAdapterVH(@NonNull View itemView) {
            super(itemView);
            if (code==1) {
                trendingimageView = itemView.findViewById(R.id.rv_item_cardview_imgvw);
            }
            else {
                bannerImageview = itemView.findViewById(R.id.banner2_rv_item_cardview_imgvw);
            }
        }

        void populate(TrendingRvModel trendingRvModel)
        {
            if (code==1) {
                trendingimageView.setImageResource(trendingRvModel.getImageUrl());
                //uncomment these two when setting images
            }
            else {
                bannerImageview.setImageResource(trendingRvModel.getImageUrl());
            }
            //Glide.with(itemView.getContext()).load(trendingRvModel.getImageUrl()).into(imageView);//using glide
            //here, the itemView.getContext thing is very important as otherwise, the image is loaded after fragment is destroyed or before fragment is created
            //Toast.makeText(itemView.getContext(),""+trendingRvModel.getImageUrl(),Toast.LENGTH_SHORT).show();
        }
    }


}
