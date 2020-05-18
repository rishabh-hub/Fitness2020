package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.ClientModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class HomePageClientAdapter extends RecyclerView.Adapter<HomePageClientAdapter.ClientVH> {
    ArrayList<ClientModel> clients = new ArrayList<>();
    ArrayList<ReviewModel> reviewModels;
    int code=0;
    Context context;

    public HomePageClientAdapter(ArrayList<ClientModel> clients,Context context) {
        this.clients = clients;
        this.context = context;
    }

    public HomePageClientAdapter(ArrayList<ReviewModel> reviewModels, Context context,int code) {
        this.reviewModels = reviewModels;
        this.context = context;
        this.code = code;
    }

    @NonNull
    @Override
    public HomePageClientAdapter.ClientVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code == 1)
            return new ClientVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.review_rv_item,parent,false));
        else
            return new ClientVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.our_client_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageClientAdapter.ClientVH holder, int position) {
        if(code == 1)
            holder.populateReviews(reviewModels.get(position));
        else
            holder.populate(clients.get(position));
    }

    @Override
    public int getItemCount() {
        if(code==1)
            return reviewModels.size();
        else
            return clients.size();
    }

    public class ClientVH extends RecyclerView.ViewHolder {
        ImageView clientImage;
        TextView name,product,desc;
        public ClientVH(@NonNull View itemView) {
            super(itemView);
            if(code==1)
            {
                name = itemView.findViewById(R.id.review_name);
                product = itemView.findViewById(R.id.review_product);
                desc = itemView.findViewById(R.id.review_desc);
            }
            else
                clientImage = itemView.findViewById(R.id.client_image);
        }

        public void populate(ClientModel clientModel) {
            clientImage.setImageResource(clientModel.getClientImageResource());
        }

        public void populateReviews(ReviewModel reviewModel) {
            name.setText(reviewModel.getName());
            product.setText(reviewModel.getProduct());
            desc.setText(reviewModel.getDescription());
        }
    }
}
