package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.EventsModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsAdapterRvVH> {

    ArrayList<VideoModel> imageModels;
    ArrayList<EventsModel>  fitnessModels, recreationModels,specialTalkModels,weekendModels;
    Context context;
    int code;

    public EventsAdapter(ArrayList<VideoModel> imageModels, ArrayList<EventsModel> fitnessModels, ArrayList<EventsModel> recreationModels, ArrayList<EventsModel> specialTalkModels, ArrayList<EventsModel> weekendModels, Context context, int code) {
        this.imageModels = imageModels;
        this.fitnessModels = fitnessModels;
        this.recreationModels = recreationModels;
        this.specialTalkModels = specialTalkModels;
        this.weekendModels = weekendModels;
        this.context = context;
        this.code = code;
    }

    @NonNull
    @Override
    public EventsAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        {
            return new EventsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_large_layout,parent,false));
        }
        else if (code==1)
        {
            return new EventsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_event_rv_item,parent,false));
        }

        else if (code==2)
        {
            return new EventsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_event_rv_item,parent,false));
        }
        else if (code==3)
        {
            return new EventsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_event_rv_item,parent,false));
        }

        else
            return new EventsAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_event_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populateImage(imageModels.get(position));
        }
        else if (code==1)
        {
            holder.populateFitness(fitnessModels.get(position));
        }

        else if (code==2)
        {
            holder.populateRecreation(recreationModels.get(position));
        }
        else if (code==3)
        {
            holder.populateSpecialTalk(specialTalkModels.get(position));
        }

        else
            holder.populateWeekend(weekendModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (code==0)
        {
            return imageModels.size();
        }
        else if (code==1)
        {
            return fitnessModels.size();
        }

        else if (code==2)
        {
            return recreationModels.size();
        }
        else if (code==3)
        {
            return specialTalkModels.size();
        }

        else
            return weekendModels.size();
    }

    public class EventsAdapterRvVH extends RecyclerView.ViewHolder
    {
        ImageView topImage,fitnessImage,recreationImage,specialTalkImage,weekendImage;
        TextView fitnessName,recreationName,specialTalkName,weekendName;
        TextView fitnessPrice,recreationPrice,specialTalkPrice,weekendPrice;
        TextView fitnessLocation,recreationLocation,specialTalkLocation,weekendLocation;
        TextView fitnessHost,recreationHost,specialTalkHost,weekendHost;

        public EventsAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0)
            {
                topImage=itemView.findViewById(R.id.video_large_item);

            }
            else if (code==1)
            {
                fitnessImage=itemView.findViewById(R.id.event_item_image);
                fitnessName=itemView.findViewById(R.id.event_item_name);
                fitnessPrice=itemView.findViewById(R.id.event_item_price);
                fitnessLocation=itemView.findViewById(R.id.event_item_location);
                fitnessHost=itemView.findViewById(R.id.event_item_host);
            }

            else if (code==2)
            {
                recreationImage=itemView.findViewById(R.id.event_item_image);
                recreationName=itemView.findViewById(R.id.event_item_name);
                recreationPrice=itemView.findViewById(R.id.event_item_price);
                recreationLocation=itemView.findViewById(R.id.event_item_location);
                recreationHost=itemView.findViewById(R.id.event_item_host);
            }
            else if (code==3)
            {
                specialTalkImage=itemView.findViewById(R.id.event_item_image);
                specialTalkName=itemView.findViewById(R.id.event_item_name);
                specialTalkPrice=itemView.findViewById(R.id.event_item_price);
                specialTalkLocation=itemView.findViewById(R.id.event_item_location);
                specialTalkHost=itemView.findViewById(R.id.event_item_host);
            }

            else
            {
                weekendImage=itemView.findViewById(R.id.event_item_image);
                weekendName=itemView.findViewById(R.id.event_item_name);
                weekendPrice=itemView.findViewById(R.id.event_item_price);
                weekendLocation=itemView.findViewById(R.id.event_item_location);
                weekendHost=itemView.findViewById(R.id.event_item_host);
            }


        }

        public void populateFitness(EventsModel eventsModel) {

            fitnessImage.setImageResource(eventsModel.getImageId());
            fitnessName.setText(eventsModel.getName());
            fitnessPrice.setText(eventsModel.getPrice());
            fitnessLocation.setText(eventsModel.getLocation());
            fitnessHost.setText(eventsModel.getHost());

        }

        public void populateRecreation(EventsModel eventsModel) {

            recreationImage.setImageResource(eventsModel.getImageId());
            recreationName.setText(eventsModel.getName());
            recreationPrice.setText(eventsModel.getPrice());
            recreationLocation.setText(eventsModel.getLocation());
            recreationHost.setText(eventsModel.getHost());
        }

        public void populateImage(VideoModel videoModel) {

            topImage.setImageResource(videoModel.getVideoImageResource());
        }

        public void populateSpecialTalk(EventsModel eventsModel) {

            specialTalkImage.setImageResource(eventsModel.getImageId());
            specialTalkName.setText(eventsModel.getName());
            specialTalkPrice.setText(eventsModel.getPrice());
            specialTalkLocation.setText(eventsModel.getLocation());
            specialTalkHost.setText(eventsModel.getHost());
        }

        public void populateWeekend(EventsModel eventsModel) {

            weekendImage.setImageResource(eventsModel.getImageId());
            weekendName.setText(eventsModel.getName());
            weekendPrice.setText(eventsModel.getPrice());
            weekendLocation.setText(eventsModel.getLocation());
            weekendHost.setText(eventsModel.getHost());
        }
    }
}
