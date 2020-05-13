package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.PopularRvModel;
import com.example.fitness2020.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomePopularRVAdapter extends RecyclerView.Adapter<HomePopularRVAdapter.HomePopularRVAdapterVH> {

    ArrayList<PopularRvModel> popularRvModels;
    Context context;

    public HomePopularRVAdapter(ArrayList<PopularRvModel> popularRvModels, Context context) {
        this.popularRvModels = popularRvModels;
        this.context = context;
    }

    @NonNull
    @Override
    public HomePopularRVAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomePopularRVAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_rv_xml,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final HomePopularRVAdapterVH holder, int position) {

        holder.populate(popularRvModels.get(position));

    }

    @Override
    public int getItemCount() {
        return popularRvModels.size();
    }

    public class HomePopularRVAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView gymName,category,address,recommended,rating;

        public HomePopularRVAdapterVH(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.popular_rv_xml_imgvw);
            gymName=itemView.findViewById(R.id.popular_rv_xml_name);
            category=itemView.findViewById(R.id.popular_rv_xml_cat);
            address=itemView.findViewById(R.id.popular_rv_xml_address);
            recommended=itemView.findViewById(R.id.popular_rv_xml_recommended);
            rating=itemView.findViewById(R.id.popular_rv_xml_rating);

        }

        void populate(PopularRvModel popularRvModel)
        {
                imageView.setImageResource(popularRvModel.getId());
                gymName.setText(popularRvModel.getGymName());
                category.setText(popularRvModel.getCategory());
                address.setText(popularRvModel.getGymAddress());
                recommended.setText(popularRvModel.getRecommended());
                rating.setText(popularRvModel.getRating());
        }
    }
}
