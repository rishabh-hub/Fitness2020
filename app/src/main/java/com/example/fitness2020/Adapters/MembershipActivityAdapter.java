package com.example.fitness2020.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.DetailsDialog;
import com.example.fitness2020.Models.Fitness2020Model;
import com.example.fitness2020.Models.GymMembershipModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class MembershipActivityAdapter extends RecyclerView.Adapter<MembershipActivityAdapter.MembershipActivityRvVH> {

    int code;
    Context context;
    ArrayList<GymMembershipModel> gymMembershipModels;
    ArrayList<Fitness2020Model> fitness2020Models;
    String phno;
    String phno1;

    public MembershipActivityAdapter(int code, ArrayList<GymMembershipModel> gymMembershipModels, ArrayList<Fitness2020Model> fitness2020Models) {
        this.code = code;
        this.gymMembershipModels = gymMembershipModels;
        this.fitness2020Models = fitness2020Models;
    }

    @NonNull
    @Override
    public MembershipActivityRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        {
            return new MembershipActivityRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness2020_membership_rv_item,parent,false));
        }

        else
        {
            return new MembershipActivityRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_membership_rv_item,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MembershipActivityRvVH holder, int position) {

        if (code==0)
        {
            holder.populateFitness2020(fitness2020Models.get(position));
        }

        else
        {
            holder.populateGym(gymMembershipModels.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (code==0)
        {
            return fitness2020Models.size();
        }

        else
        {
            return gymMembershipModels.size();
        }
    }

    public class MembershipActivityRvVH extends RecyclerView.ViewHolder
    {
        ImageView gymImage,fitnessImage;
        TextView fitness2020Membershipame,gymMembershipName,gymPrice,gymName,gymStartDate,gymEndDate,fitness2020Price,freeTrialExpiry,webinarExpiry,voucherExpiry,pointsExpiry,autoDebitDate,gymAddress,detailsButton;
        Button fitness2020ContactButton,gymContactButton,stopPaymentbutton;
        TextView gymMembershipViewMoreButton;

        public MembershipActivityRvVH(@NonNull final View itemView) {
            super(itemView);
            if (code==0)
            {
                fitnessImage=itemView.findViewById(R.id.membership_gym_photo);
                fitness2020Membershipame=itemView.findViewById(R.id.fitness2020_membership_name);
                fitness2020Price=itemView.findViewById(R.id.membership_gym_price);
                freeTrialExpiry=itemView.findViewById(R.id.fitness2020_free_trial_expiry);
                webinarExpiry=itemView.findViewById(R.id.fitness2020_live_workout_expiry);
                voucherExpiry=itemView.findViewById(R.id.fitness2020_voucher_expiry);
                pointsExpiry=itemView.findViewById(R.id.fitness2020_points_expiry);
                autoDebitDate=itemView.findViewById(R.id.fitness2020_debit_date);
                fitness2020ContactButton=itemView.findViewById(R.id.fitness2020_membership_support_btn);
                detailsButton =itemView.findViewById(R.id.fitness2020_membership_refund_button);
                stopPaymentbutton=itemView.findViewById(R.id.stop_fitness2020_membership_btn);
                detailsButton.setPaintFlags(detailsButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                detailsButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DetailsDialog detailsDialog=new DetailsDialog(itemView.getContext(),R.style.Theme_MaterialComponents_Dialog,1);
                        detailsDialog.setCancelable(true);
                        detailsDialog.show();
                    }
                });

                fitness2020ContactButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri number= Uri.parse("tel:"+phno);
                        Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
                        itemView.getContext().startActivity(callIntent);
                    }
                });
            }

            else
            {
                gymImage = itemView.findViewById(R.id.gym_membership_image);
                gymMembershipName = itemView.findViewById(R.id.gym_membership_name);
                gymPrice = itemView.findViewById(R.id.gym_membership_price);
                gymName = itemView.findViewById(R.id.gym_membership_gym_name);
                gymStartDate = itemView.findViewById(R.id.gym_membership_gym_start_date);
                gymEndDate = itemView.findViewById(R.id.gym_membership_gym_end_date);
                gymAddress = itemView.findViewById(R.id.gym_membership_gym_address);
                gymContactButton = itemView.findViewById(R.id.gym_membership_call_btn);
                gymMembershipViewMoreButton=itemView.findViewById(R.id.gym_membership_view_more_btn);
                gymMembershipViewMoreButton.setPaintFlags(gymMembershipViewMoreButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                gymContactButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri number= Uri.parse("tel:"+phno1);
                        Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
                        itemView.getContext().startActivity(callIntent);
                    }
                });

                gymMembershipViewMoreButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DetailsDialog detailsDialog=new DetailsDialog(itemView.getContext(),R.style.Theme_MaterialComponents_Dialog,2);
                        detailsDialog.setCancelable(true);
                        detailsDialog.show();
                    }
                });
            }
        }


        public void populateFitness2020(Fitness2020Model fitness2020Model) {

            fitnessImage.setImageResource(fitness2020Model.getImageId());
            fitness2020Membershipame.setText(fitness2020Model.getMembershipName());
            fitness2020Price.setText(fitness2020Model.getPrice());
            freeTrialExpiry.setText(fitness2020Model.getFreeTrialExpiry());
            webinarExpiry.setText(fitness2020Model.getWebinarExpiry());
            voucherExpiry.setText(fitness2020Model.getVouchersExpiry());
            pointsExpiry.setText(fitness2020Model.getPointsExpiry());
            autoDebitDate.setText(fitness2020Model.getAutoDebitDate());
            phno=fitness2020Model.getContactNo();

//            fitness2020RefundButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            stopPaymentbutton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }

        public void populateGym(GymMembershipModel gymMembershipModel) {

            gymImage.setImageResource(gymMembershipModel.getImageId());
            gymMembershipName.setText(gymMembershipModel.getMemberShipName());
            gymPrice.setText(gymMembershipModel.getPrice());
            gymName.setText(gymMembershipModel.getGymName());
            gymStartDate.setText(gymMembershipModel.getStartDate());
            gymEndDate.setText(gymMembershipModel.getEndDate());
            gymAddress.setText(gymMembershipModel.getGymAddress());
            phno1=gymMembershipModel.getContactNo();


        }
    }
}
