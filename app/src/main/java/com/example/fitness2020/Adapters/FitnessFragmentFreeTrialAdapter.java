package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.TopTrainersModel;
import com.example.fitness2020.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class FitnessFragmentFreeTrialAdapter extends RecyclerView.Adapter<FitnessFragmentFreeTrialAdapter.FitnessFragmentFreeTrialVH> {

    ArrayList<FitnessFragmentFreeTrialModel> fitnessFragmentFreeTrialModels;
    ArrayList<FitnessFragmentFreeTrialModel> fitnessPassModels;
    ArrayList<TopTrainersModel> topTrainersModels;
    Context context;
    int code;

    public FitnessFragmentFreeTrialAdapter(ArrayList<FitnessFragmentFreeTrialModel> fitnessFragmentFreeTrialModels, ArrayList<FitnessFragmentFreeTrialModel> fitnessPassModels, ArrayList<TopTrainersModel> topTrainersModels, Context context, int code) {
        this.fitnessFragmentFreeTrialModels = fitnessFragmentFreeTrialModels;
        this.fitnessPassModels = fitnessPassModels;
        this.topTrainersModels = topTrainersModels;
        this.context = context;
        this.code = code;
    }

    @NonNull
    @Override
    public FitnessFragmentFreeTrialVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code==1)
            return new FitnessFragmentFreeTrialVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_fragment_top_fitness_centre_rv_item,parent,false));
        else if (code==0)
            return new FitnessFragmentFreeTrialVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_fragment_live_workout_rv_item,parent,false));

        else
            return new FitnessFragmentFreeTrialVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_fragment_top_trainer_rv_item,parent,false));
        //for trainers
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessFragmentFreeTrialVH holder, int position) {
        if(code==1)
            holder.populate(fitnessFragmentFreeTrialModels.get(position));
        else if (code==0)
            holder.populateBanner(fitnessPassModels.get(position));
        else
            holder.populateTrainers(topTrainersModels.get(position));
    }

    @Override
    public int getItemCount() {
        if(code==1)
            return fitnessFragmentFreeTrialModels.size();
        else if (code==0)
            return fitnessPassModels.size();

        else
            return topTrainersModels.size();
    }

    public class FitnessFragmentFreeTrialVH extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView gymName,gymAddress,category,gymRating;
        ImageView bannerImageview;
        TextView bannerGymName;
        TextView bannerGymCategory;
        ImageView trainerImage;
        TextView trainerName;

        public FitnessFragmentFreeTrialVH(@NonNull View itemView) {
            super(itemView);
            if(code==1)
            {
                imageView=itemView.findViewById(R.id.rv_item_cardview1_imgvw);
                gymName=itemView.findViewById(R.id.rv_item1_cardview_gym_name);
                gymAddress=itemView.findViewById(R.id.rv_item1_cardview_gym_address);
                category=itemView.findViewById(R.id.rv_item1_cardview_category);
                gymRating=itemView.findViewById(R.id.top_fitness_centre_rating);
            }
            else if (code==0){
                bannerImageview = itemView.findViewById(R.id.fitnesspass_rv_item_cardview1_imgvw);
                bannerGymName=itemView.findViewById(R.id.fitnesspass_rv_item1_cardview_gym_name);
                bannerGymCategory=itemView.findViewById(R.id.fitnesspass_rv_item1_cardview_category);
//                bannerGymSchedule=itemView.findViewById(R.id.banner2_rv_item_cardview_gym_schedule);
            }

            else
            {
                trainerImage=itemView.findViewById(R.id.fitnesspass_rv_item_cardview1_imgvw);
                trainerName=itemView.findViewById(R.id.top_trainer_name);
            }


        }

        void populate(FitnessFragmentFreeTrialModel fitnessFragmentFreeTrialModel)
        {
            imageView.setImageResource(fitnessFragmentFreeTrialModel.getImageId());
            gymName.setText(fitnessFragmentFreeTrialModel.getGymName());
            gymAddress.setText(fitnessFragmentFreeTrialModel.getGymAddress());
            category.setText(fitnessFragmentFreeTrialModel.getCategory());
            gymRating.setText(fitnessFragmentFreeTrialModel.getRating());
        }

        public void populateBanner(FitnessFragmentFreeTrialModel fitnessFragmentFreeTrialModel) {
            bannerImageview.setImageResource(fitnessFragmentFreeTrialModel.getImageId());
            bannerGymName.setText(fitnessFragmentFreeTrialModel.getGymName());
            bannerGymCategory.setText(fitnessFragmentFreeTrialModel.getCategory());
        }

        public void populateTrainers(TopTrainersModel topTrainersModel) {
            trainerImage.setImageResource(topTrainersModel.getImageUrl());
            trainerName.setText(topTrainersModel.getTrainerName());
        }
    }
}
