package com.example.fitness2020.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MembershipActivityAdapter extends RecyclerView.Adapter<MembershipActivityAdapter.MembershipActivityRvVH> {

    @NonNull
    @Override
    public MembershipActivityRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MembershipActivityRvVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MembershipActivityRvVH extends RecyclerView.ViewHolder
    {
        public MembershipActivityRvVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
