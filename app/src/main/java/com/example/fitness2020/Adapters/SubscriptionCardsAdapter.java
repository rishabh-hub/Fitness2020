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

public class SubscriptionCardsAdapter extends RecyclerView.Adapter<SubscriptionCardsAdapter.SubscriptionCardsAdapterVH> {

    Context context;
    int code;
    ArrayList<TrendingRvModel> imageModels;
    //add your arraylist of type whatever model class


    public SubscriptionCardsAdapter(Context context, int code, ArrayList<TrendingRvModel> imageModels) {
        this.context = context;
        this.code = code;
        this.imageModels = imageModels;
    }

    //delete this constructor and remake one after adding the global variables

    @NonNull
    @Override
    public SubscriptionCardsAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//write if else block
        return new SubscriptionCardsAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trialcard_imagerv_xml,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionCardsAdapterVH holder, int position) {
//write if else block

        holder.populate(imageModels.get(position));

    }

    @Override
    public int getItemCount() {
        //write if else block

        return imageModels.size();
    }

    public class SubscriptionCardsAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        //define your data types

        public SubscriptionCardsAdapterVH(@NonNull View itemView) {
            super(itemView);
            //write if else block to link ids wrt the corresponding codes received
                imageView=itemView.findViewById(R.id.rv_item_trailcard_imgvw);

        }
      //make a separate populate func which receives your class type object as arguments

        void populate(TrendingRvModel imageModel)
        {
            imageView.setImageResource(imageModel.getImageUrl());
        }

    }
}
