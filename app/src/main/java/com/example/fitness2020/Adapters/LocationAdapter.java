package com.example.fitness2020.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.AddressModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationAdapterRvVH> {

    ArrayList<AddressModel> addressModels;

    public LocationAdapter(ArrayList<AddressModel> addressModels) {
        this.addressModels = addressModels;
    }

    @NonNull
    @Override
    public LocationAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.address_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapterRvVH holder, int position) {

        holder.populateLocations(addressModels.get(position));
    }

    @Override
    public int getItemCount() {
        return addressModels.size();
    }

    public class LocationAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView locationText;
        public LocationAdapterRvVH(@NonNull View itemView) {
            super(itemView);
            locationText=itemView.findViewById(R.id.location_address_item);
        }

        public void populateLocations(AddressModel addressModel) {
            locationText.setText(addressModel.getAddress());
        }
    }
}
