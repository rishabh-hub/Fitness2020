package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class FitnessFragmentFreeTrialAdapter extends RecyclerView.Adapter<FitnessFragmentFreeTrialAdapter.FitnessFragmentFreeTrialVH> {

    ArrayList<FitnessFragmentFreeTrialModel> fitnessFragmentFreeTrialModels;
    ArrayList<PopularHorizontalRvModel> fitnessPassModels;
    Context context;
    int code;

    public FitnessFragmentFreeTrialAdapter(ArrayList<FitnessFragmentFreeTrialModel> fitnessFragmentFreeTrialModels, Context context,ArrayList<PopularHorizontalRvModel> fitnessPassModels,int code) {
        this.fitnessFragmentFreeTrialModels = fitnessFragmentFreeTrialModels;
        this.context = context;
        this.fitnessPassModels = fitnessPassModels;
        this.code = code;
    }

    @NonNull
    @Override
    public FitnessFragmentFreeTrialVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code==1)
            return new FitnessFragmentFreeTrialVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_fragment_freetrial_rv_xml,parent,false));
        else
            return new FitnessFragmentFreeTrialVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner2_rv_xml,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull FitnessFragmentFreeTrialVH holder, int position) {
        if(code==1)
            holder.populate(fitnessFragmentFreeTrialModels.get(position));
        else
            holder.populateBanner(fitnessPassModels.get(position));
    }

    @Override
    public int getItemCount() {
        if(code==1)
            return fitnessFragmentFreeTrialModels.size();
        else
            return fitnessPassModels.size();
    }

    public class FitnessFragmentFreeTrialVH extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView gymName,gymAddress;
        ImageView bannerImageview;
        TextView bannerGymName;
        TextView bannerGymCategory;
        TextView bannerGymSchedule;

        public FitnessFragmentFreeTrialVH(@NonNull View itemView) {
            super(itemView);
            if(code==1)
            {
                imageView=itemView.findViewById(R.id.rv_item_cardview1_imgvw);
                gymName=itemView.findViewById(R.id.rv_item1_cardview_gym_name);
                gymAddress=itemView.findViewById(R.id.rv_item1_cardview_gym_address);
            }
            else {
                bannerImageview = itemView.findViewById(R.id.banner2_rv_item_cardview_imgvw);
                bannerGymName=itemView.findViewById(R.id.banner2_rv_item_cardview_gym_name);
                bannerGymCategory=itemView.findViewById(R.id.banner2_rv_item_cardview_gym_category);
                bannerGymSchedule=itemView.findViewById(R.id.banner2_rv_item_cardview_gym_schedule);
            }


        }

        void populate(FitnessFragmentFreeTrialModel fitnessFragmentFreeTrialModel)
        {
            imageView.setImageResource(fitnessFragmentFreeTrialModel.getImageId());
            gymName.setText(fitnessFragmentFreeTrialModel.getGymName());
            gymAddress.setText(fitnessFragmentFreeTrialModel.getGymAddress());
        }

        public void populateBanner(PopularHorizontalRvModel popularHorizontalRvModel) {
            bannerImageview.setImageResource(popularHorizontalRvModel.getImageurl());
            bannerGymName.setText(popularHorizontalRvModel.getGymName());
            bannerGymCategory.setText(popularHorizontalRvModel.getCategory());
            bannerGymSchedule.setText(popularHorizontalRvModel.getGymSchedule());
        }
    }
}
