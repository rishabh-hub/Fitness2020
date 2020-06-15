package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class VouchersInternalAdapter extends RecyclerView.Adapter<VouchersInternalAdapter.VouchersInternalAdapterRvVH> {

    Context context;
    int code;
    ArrayList<VouchersModel> pleasureModels,healthModels,experienceModels,shoppingModels,travelModels,offerZoneModels;
    ArrayList<VideoModel> voucherBannerModels;

    public VouchersInternalAdapter(Context context, int code, ArrayList<VouchersModel> pleasureModels, ArrayList<VouchersModel> healthModels,
                                   ArrayList<VouchersModel> experienceModels, ArrayList<VouchersModel> shoppingModels,
                                   ArrayList<VouchersModel> travelModels, ArrayList<VouchersModel> offerZoneModels,
                                   ArrayList<VideoModel> voucherBannerModels)
    {
        this.context = context;
        this.code = code;
        this.pleasureModels = pleasureModels;
        this.healthModels = healthModels;
        this.experienceModels = experienceModels;
        this.shoppingModels = shoppingModels;
        this.travelModels = travelModels;
        this.offerZoneModels = offerZoneModels;
        this.voucherBannerModels = voucherBannerModels;
    }


    @NonNull
    @Override
    public VouchersInternalAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
            return new VouchersInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_large_layout,parent,false));
        else if (code==1)
            return new VouchersInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_page_rv_item,parent,false));
        else if (code==2)
            return new VouchersInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_page_rv_item,parent,false));
        else if (code==3)
            return new VouchersInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_page_rv_item,parent,false));
        else if (code==4)
            return new VouchersInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_page_rv_item,parent,false));
        else if (code==5)
            return new VouchersInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_page_rv_item,parent,false));
        else
            return new VouchersInternalAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_page_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VouchersInternalAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populateVoucherBanner(voucherBannerModels.get(position));
        }

        else if (code==1)

        {
            holder.populatePleasure(pleasureModels.get(position));
        }
        else if (code==2)
        {
            holder.populateHealth(healthModels.get(position));
        }
        else if (code==3)
        {
            holder.populateExperience(experienceModels.get(position));
        }
        else if (code==4)
        {
            holder.populateShopping(shoppingModels.get(position));
        }
        else if (code==5)
        {
            holder.populateTravel(travelModels.get(position));
        }
        else
        {
            holder.populateOfferZone(offerZoneModels.get(position));
        }
    }

    @Override
    public int getItemCount() {

        if (code==0)
            return voucherBannerModels.size();
        else if (code==1)
            return pleasureModels.size();
        else if (code==2)
            return healthModels.size();
        else if (code==3)
            return experienceModels.size();
        else if (code==4)
            return shoppingModels.size();
        else if (code==5)
            return travelModels.size();
        else
            return offerZoneModels.size();

    }

    public class VouchersInternalAdapterRvVH extends RecyclerView.ViewHolder
    {
        ImageView voucherBannerImage,pleasureImage,healthImage,experienceImage,shoppingImage,travelImage,offerZoneImage;
        TextView pleasureCompany,healthCompany,experienceCompany,shoppingCompany,travelCompany,offerZoneCompany;
        TextView pleasureNoOfCoupons,healthNoOfCoupons,experienceNoOfCoupons,shoppingNoOfCoupons,travelNoOfCoupons,offerZoneNoOfCoupons;
        TextView pleasureValidity,healthValidity,experienceValidity,shoppingValidity,travelValidity,offerZoneValidity;
        TextView pleasurePrice,healthPrice,experiencePrice,shoppingPrice,travelPrice,offerZonePrice;
        TextView pleasureOffer,healthOffer, experienceOffer,shoppingOffer,travelOffer,offerZoneOffer;


        public VouchersInternalAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0)

            {
                voucherBannerImage=itemView.findViewById(R.id.video_large_item);
            }
        else if (code==1)

            {
                pleasureImage=itemView.findViewById(R.id.voucher_card_back_image);
                pleasureCompany=itemView.findViewById(R.id.voucher_company);
                pleasureNoOfCoupons=itemView.findViewById(R.id.voucher_number);
                pleasureValidity=itemView.findViewById(R.id.voucher_validity);
                pleasurePrice=itemView.findViewById(R.id.voucher_price);
                pleasureOffer=itemView.findViewById(R.id.voucher_theme);
            }
        else if (code==2)

            {
                healthImage=itemView.findViewById(R.id.voucher_card_back_image);
                healthCompany=itemView.findViewById(R.id.voucher_company);
                healthNoOfCoupons=itemView.findViewById(R.id.voucher_number);
                healthValidity=itemView.findViewById(R.id.voucher_validity);
                healthPrice=itemView.findViewById(R.id.voucher_price);
                healthOffer=itemView.findViewById(R.id.voucher_theme);
            }
        else if (code==3)

            {
                experienceImage=itemView.findViewById(R.id.voucher_card_back_image);
                experienceCompany=itemView.findViewById(R.id.voucher_company);
                experienceNoOfCoupons=itemView.findViewById(R.id.voucher_number);
                experienceValidity=itemView.findViewById(R.id.voucher_validity);
                experiencePrice=itemView.findViewById(R.id.voucher_price);
                experienceOffer =itemView.findViewById(R.id.voucher_theme);
            }
        else if (code==4)

            {
                shoppingImage=itemView.findViewById(R.id.voucher_card_back_image);
                shoppingCompany=itemView.findViewById(R.id.voucher_company);
                shoppingNoOfCoupons=itemView.findViewById(R.id.voucher_number);
                shoppingValidity=itemView.findViewById(R.id.voucher_validity);
                shoppingPrice=itemView.findViewById(R.id.voucher_price);
                shoppingOffer=itemView.findViewById(R.id.voucher_theme);
            }
        else if (code==5)

            {
                travelImage=itemView.findViewById(R.id.voucher_card_back_image);
                travelCompany=itemView.findViewById(R.id.voucher_company);
                travelNoOfCoupons=itemView.findViewById(R.id.voucher_number);
                travelValidity=itemView.findViewById(R.id.voucher_validity);
                travelPrice=itemView.findViewById(R.id.voucher_price);
                travelOffer=itemView.findViewById(R.id.voucher_theme);
            }
        else

            {
                offerZoneImage=itemView.findViewById(R.id.voucher_card_back_image);
                offerZoneCompany=itemView.findViewById(R.id.voucher_company);
                offerZoneNoOfCoupons=itemView.findViewById(R.id.voucher_number);
                offerZoneValidity=itemView.findViewById(R.id.voucher_validity);
                offerZonePrice=itemView.findViewById(R.id.voucher_price);
                offerZoneOffer=itemView.findViewById(R.id.voucher_theme);
            }
        }

        public void populateOfferZone(VouchersModel vouchersModel) {
            offerZoneImage.setImageResource(vouchersModel.getVoucherImageUrl());
            offerZoneCompany.setText(vouchersModel.getCompanyName());
            offerZoneNoOfCoupons.setText(vouchersModel.getNoOfCoupons());
            offerZoneValidity.setText(vouchersModel.getValidity());
            offerZonePrice.setText(vouchersModel.getVoucherPrice());
            offerZoneOffer.setText(vouchersModel.getOffer());

        }

        public void populateTravel(VouchersModel vouchersModel) {
            travelImage.setImageResource(vouchersModel.getVoucherImageUrl());
            travelCompany.setText(vouchersModel.getCompanyName());
            travelNoOfCoupons.setText(vouchersModel.getNoOfCoupons());
            travelValidity.setText(vouchersModel.getValidity());
            travelPrice.setText(vouchersModel.getVoucherPrice());
            travelOffer.setText(vouchersModel.getOffer());
        }

        public void populateShopping(VouchersModel vouchersModel) {
            shoppingImage.setImageResource(vouchersModel.getVoucherImageUrl());
            shoppingCompany.setText(vouchersModel.getCompanyName());
            shoppingNoOfCoupons.setText(vouchersModel.getNoOfCoupons());
            shoppingValidity.setText(vouchersModel.getValidity());
            shoppingPrice.setText(vouchersModel.getVoucherPrice());
            shoppingOffer.setText(vouchersModel.getOffer());
        }

        public void populateExperience(VouchersModel vouchersModel) {

            experienceImage.setImageResource(vouchersModel.getVoucherImageUrl());
            experienceCompany.setText(vouchersModel.getCompanyName());
            experienceNoOfCoupons.setText(vouchersModel.getNoOfCoupons());
            experienceValidity.setText(vouchersModel.getValidity());
            experiencePrice.setText(vouchersModel.getVoucherPrice());
            experienceOffer.setText(vouchersModel.getOffer());
        }

        public void populateHealth(VouchersModel vouchersModel) {

            healthImage.setImageResource(vouchersModel.getVoucherImageUrl());
            healthCompany.setText(vouchersModel.getCompanyName());
            healthNoOfCoupons.setText(vouchersModel.getNoOfCoupons());
            healthValidity.setText(vouchersModel.getValidity());
            healthPrice.setText(vouchersModel.getVoucherPrice());
            healthOffer.setText(vouchersModel.getOffer());
        }

        public void populatePleasure(VouchersModel vouchersModel) {

            pleasureImage.setImageResource(vouchersModel.getVoucherImageUrl());
            pleasureCompany.setText(vouchersModel.getCompanyName());
            pleasureNoOfCoupons.setText(vouchersModel.getNoOfCoupons());
            pleasureValidity.setText(vouchersModel.getValidity());
            pleasurePrice.setText(vouchersModel.getVoucherPrice());
            pleasureOffer.setText(vouchersModel.getOffer());
        }

        public void populateVoucherBanner(VideoModel videoModel) {
            voucherBannerImage.setImageResource(videoModel.getVideoImageResource());
        }
    }
}
