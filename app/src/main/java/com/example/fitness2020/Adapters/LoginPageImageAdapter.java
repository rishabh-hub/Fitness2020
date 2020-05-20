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
import java.util.TreeSet;

public class LoginPageImageAdapter extends RecyclerView.Adapter<LoginPageImageAdapter.LoginPageImageAdapterVH> {

    ArrayList<TrendingRvModel> imageModel;
    Context context;

    public LoginPageImageAdapter(ArrayList<TrendingRvModel> imageModel, Context context) {
        this.imageModel = imageModel;
        this.context = context;
    }

    @NonNull
    @Override
    public LoginPageImageAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LoginPageImageAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.login_page_imagerv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LoginPageImageAdapterVH holder, int position) {

        holder.populate(imageModel.get(position));
    }

    @Override
    public int getItemCount() {
        return imageModel.size();
    }

    public class LoginPageImageAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        public LoginPageImageAdapterVH(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.login_pagerv_item_cardview_imgvw);
        }

        void populate(TrendingRvModel trendingRvModel)
        {
            imageView.setImageResource(trendingRvModel.getImageUrl());
        }
    }

}
