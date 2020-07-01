package com.example.fitness2020.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.BenefitsModel;
import com.example.fitness2020.Models.MembershipInternalModel;
import com.example.fitness2020.R;
import com.example.fitness2020.TrialCardActivity;
import com.example.fitness2020.TrialMembershipBooking;

import java.util.ArrayList;

public class MembershipInternalAdapter extends RecyclerView.Adapter<MembershipInternalAdapter.MembershipInternalAdapterRvVH> {

    int code;
    ArrayList<MembershipInternalModel> membershipInternalModels;
    ArrayList<BenefitsModel> benefitsModels;

    public MembershipInternalAdapter(int code, ArrayList<MembershipInternalModel> membershipInternalModels, ArrayList<BenefitsModel> benefitsModels) {
        this.code = code;
        this.membershipInternalModels = membershipInternalModels;
        this.benefitsModels = benefitsModels;
    }

    @NonNull
    @Override
    public MembershipInternalAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        {
            return new MembershipInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.membership_internal_rv_item_layout,parent,false));

        }

        else
        {
            return new MembershipInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.benefits_rv_item_layout,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final MembershipInternalAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populateMemberships(membershipInternalModels.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(holder.itemView.getContext(), TrialMembershipBooking.class);
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        }

        else
        {
            holder.populateBenefits(benefitsModels.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (code==0)
            return membershipInternalModels.size();
        else
            return benefitsModels.size();
    }

    public class MembershipInternalAdapterRvVH extends RecyclerView.ViewHolder
    {
        TextView membershipHeading,membershipPrice;
        TextView benefitsText;

        public MembershipInternalAdapterRvVH(@NonNull View itemView) {
            super(itemView);
            if (code==0)
            {
                membershipHeading=itemView.findViewById(R.id.membership_name);
                membershipPrice=itemView.findViewById(R.id.membership_price);
            }
            else
                benefitsText=itemView.findViewById(R.id.benefit);
        }

        public void populateMemberships(MembershipInternalModel membershipInternalModel) {

            membershipHeading.setText(membershipInternalModel.getHeading());
            membershipPrice.setText(membershipInternalModel.getPrice());
        }

        public void populateBenefits(BenefitsModel benefitsModel) {
            benefitsText.setText(benefitsModel.getBenefits());
        }
    }
}
