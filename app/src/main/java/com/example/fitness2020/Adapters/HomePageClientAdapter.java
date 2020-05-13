package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.ClientModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class HomePageClientAdapter extends RecyclerView.Adapter<HomePageClientAdapter.ClientVH> {
    ArrayList<ClientModel> clients = new ArrayList<>();
    Context context;

    public HomePageClientAdapter(ArrayList<ClientModel> clients,Context context) {
        this.clients = clients;
        this.context = context;
    }

    @NonNull
    @Override
    public HomePageClientAdapter.ClientVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClientVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.our_client_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageClientAdapter.ClientVH holder, int position) {
        holder.populate(clients.get(position));
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    public class ClientVH extends RecyclerView.ViewHolder {
        ImageView clientImage;
        public ClientVH(@NonNull View itemView) {
            super(itemView);
            clientImage = itemView.findViewById(R.id.client_image);
        }

        public void populate(ClientModel clientModel) {
            clientImage.setImageResource(clientModel.getClientImageResource());
        }
    }
}
