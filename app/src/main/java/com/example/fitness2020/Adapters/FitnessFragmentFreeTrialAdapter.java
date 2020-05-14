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
import com.example.fitness2020.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class FitnessFragmentFreeTrialAdapter extends RecyclerView.Adapter<FitnessFragmentFreeTrialAdapter.FitnessFragmentFreeTrialVH> {

    ArrayList<FitnessFragmentFreeTrialModel> fitnessFragmentFreeTrialModels;
    Context context;

    public FitnessFragmentFreeTrialAdapter(ArrayList<FitnessFragmentFreeTrialModel> fitnessFragmentFreeTrialModels, Context context) {
        this.fitnessFragmentFreeTrialModels = fitnessFragmentFreeTrialModels;
        this.context = context;
    }

    @NonNull
    @Override
    public FitnessFragmentFreeTrialVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new FitnessFragmentFreeTrialVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_fragment_freetrial_rv_xml,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull FitnessFragmentFreeTrialVH holder, int position) {

        holder.populate(fitnessFragmentFreeTrialModels.get(position));
    }

    @Override
    public int getItemCount() {
        return fitnessFragmentFreeTrialModels.size();
    }

    public class FitnessFragmentFreeTrialVH extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView gymName,gymAddress;

        public FitnessFragmentFreeTrialVH(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.rv_item_cardview1_imgvw);
            gymName=itemView.findViewById(R.id.rv_item1_cardview_gym_name);
            gymAddress=itemView.findViewById(R.id.rv_item1_cardview_gym_address);
        }

        void populate(FitnessFragmentFreeTrialModel fitnessFragmentFreeTrialModel)
        {
            imageView.setImageResource(fitnessFragmentFreeTrialModel.getImageId());
            gymName.setText(fitnessFragmentFreeTrialModel.getGymName());
            gymAddress.setText(fitnessFragmentFreeTrialModel.getGymAddress());
        }
    }
}
