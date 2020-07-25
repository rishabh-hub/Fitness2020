package com.example.fitness2020.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.ActivityModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityAdapterRvVH> {

    ArrayList<ActivityModel> activityModels,activityModels1;
    int code;

    public ActivityAdapter(ArrayList<ActivityModel> activityModels, ArrayList<ActivityModel> activityModels1, int code) {
        this.activityModels = activityModels;
        this.activityModels1 = activityModels1;
        this.code = code;
    }

    @NonNull
    @Override
    public ActivityAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (code==0)
        {
            return new ActivityAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_filter_layout,parent,false));
        }

        else
        {
            return new ActivityAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_filter_layout,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populateDialog(activityModels.get(position));
        }

        else
        {
            holder.populateActivity(activityModels1.get(position));
        }
    }

    @Override
    public int getItemCount() {

        if (code==0)
        {
            return activityModels.size();
        }

        else
        {
            return activityModels1.size();
        }

    }

    public class ActivityAdapterRvVH extends RecyclerView.ViewHolder
    {
        ImageView activityImage,dialogActivityImage;
        TextView activityName,dialogActivityName;

        public ActivityAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0)
            {
                dialogActivityImage=itemView.findViewById(R.id.activity_filter_icon);
                dialogActivityName=itemView.findViewById(R.id.activity_filter_name);
            }

            else
            {

                activityImage=itemView.findViewById(R.id.activity_filter_icon);
                activityName=itemView.findViewById(R.id.activity_filter_name);
            }

        }


        public void populateDialog(ActivityModel activityModel) {

            dialogActivityName.setText(activityModel.getActivityName());
            dialogActivityImage.setImageResource(activityModel.getImageUrl());
        }

        public void populateActivity(ActivityModel activityModel) {

            activityName.setText(activityModel.getActivityName());
            activityImage.setImageResource(activityModel.getImageUrl());
        }
    }
}
