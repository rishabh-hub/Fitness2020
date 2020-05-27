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

import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeTrendingRVAdapter extends RecyclerView.Adapter<HomeTrendingRVAdapter.HomeTrendingRVAdapterVH> {

    ArrayList<TrendingRvModel> trendingRvModels;
    ArrayList<PopularHorizontalRvModel> popularHorizontalRvModels;
    Context context;
    int code;

    public HomeTrendingRVAdapter(ArrayList<TrendingRvModel> trendingRvModels, Context context,int code,ArrayList<PopularHorizontalRvModel> popularHorizontalRvModels) {
        this.trendingRvModels = trendingRvModels;
        this.context = context;
        this.code=code;
        this.popularHorizontalRvModels=popularHorizontalRvModels;
    }



    @NonNull
    @Override
    public HomeTrendingRVAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//here code is used to differentiate bw which layout to inflate in the 2 rvs i.e the top trending one and the horizontal popular one
        if (code==1) {
            return new HomeTrendingRVAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_rv_xml, parent, false));
        }

        else {
            return new HomeTrendingRVAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner2_rv_xml,parent,false));

        }
        }

    @Override
    public void onBindViewHolder(@NonNull HomeTrendingRVAdapterVH holder, int position) {

        if (code==1)
        holder.populate(trendingRvModels.get(position));
        else
        holder.populateBanner(popularHorizontalRvModels.get(position));

    }

    @Override
    public int getItemCount() {
        if(code==1)
        return trendingRvModels.size();

        else
            return popularHorizontalRvModels.size();
    }

    public  class HomeTrendingRVAdapterVH extends RecyclerView.ViewHolder
    {

        ImageView trendingimageView;
        ImageView bannerImageview;
        TextView bannerGymName;
        TextView bannerGymCategory;
        TextView bannerGymSchedule;
        TextView bannerGymRating;

        public HomeTrendingRVAdapterVH(@NonNull View itemView) {
            super(itemView);
            if (code==1) {
                trendingimageView = itemView.findViewById(R.id.rv_item_cardview_imgvw);
            }
            else {
                bannerImageview = itemView.findViewById(R.id.banner2_rv_item_cardview_imgvw);
                bannerGymName=itemView.findViewById(R.id.banner2_rv_item_cardview_gym_name);
                bannerGymCategory=itemView.findViewById(R.id.banner2_rv_item_cardview_gym_category);
                bannerGymSchedule=itemView.findViewById(R.id.banner2_rv_item_cardview_gym_schedule);
                bannerGymRating=itemView.findViewById(R.id.popular_rv_xml_rating);
            }
        }

        void populate(TrendingRvModel trendingRvModel)
        {
                trendingimageView.setImageResource(trendingRvModel.getImageUrl());
                //uncomment this when setting images

            //Glide.with(itemView.getContext()).load(trendingRvModel.getImageUrl()).into(imageView);//using glide
            //here, the itemView.getContext thing is very important as otherwise, the image is loaded after fragment is destroyed or before fragment is created
            //Toast.makeText(itemView.getContext(),""+trendingRvModel.getImageUrl(),Toast.LENGTH_SHORT).show();
        }

        void populateBanner(PopularHorizontalRvModel popularHorizontalRvModel)
        {
            bannerImageview.setImageResource(popularHorizontalRvModel.getImageurl());
            bannerGymName.setText(popularHorizontalRvModel.getGymName());
            bannerGymCategory.setText(popularHorizontalRvModel.getCategory());
            bannerGymSchedule.setText(popularHorizontalRvModel.getGymSchedule());
            bannerGymRating.setText(popularHorizontalRvModel.getGymRating());
        }
    }


}
