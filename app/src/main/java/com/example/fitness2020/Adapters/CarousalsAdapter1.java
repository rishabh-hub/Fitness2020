package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.CompanyModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.Models.WebinarModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class    CarousalsAdapter1 extends RecyclerView.Adapter<CarousalsAdapter1.CarouslasAdapter1VH> {
    Context context;
    ArrayList<CompanyModel> companyModels;
    ArrayList<VouchersModel> vouchersModels;
    ArrayList<WebinarModel> webinarModels;
    int code;

    public CarousalsAdapter1(Context context, ArrayList<CompanyModel> companyModels, ArrayList<VouchersModel> vouchersModels, ArrayList<WebinarModel> webinarModels,int code) {
        this.context = context;
        this.companyModels = companyModels;
        this.vouchersModels = vouchersModels;
        this.webinarModels = webinarModels;
        this.code = code;
    }

    @NonNull
    @Override
    public CarouslasAdapter1VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code==0)
        return new CarouslasAdapter1VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.webinar_rv_item,parent,false));

        else if (code==1)
            return new CarouslasAdapter1VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.partners_rv_item,parent,false));

        else
            return new CarouslasAdapter1VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_rv_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull CarouslasAdapter1VH holder, int position) {
        if (code==0)
            holder.populateWebinar(webinarModels.get(position));
        else if (code==1)
            holder.populatePartners(companyModels.get(position));
        else
            holder.populateVoucher(vouchersModels.get(position));

    }

    @Override
    public int getItemCount() {
        if (code==0)
            return webinarModels.size();
        else if (code==1)
            return companyModels.size();
        else
            return vouchersModels.size();
    }

    public class CarouslasAdapter1VH extends RecyclerView.ViewHolder
    {
        ImageView partnersImage,voucherImage,webinarImage;
        TextView webinarHead,webinarTiming,webinarLevel,webinarActivity,voucherTag,voucherTheme,voucherCompany,voucherPromCode,voucherValidity;


        public CarouslasAdapter1VH(@NonNull View itemView) {
            super(itemView);
            if (code==0)
            {
                webinarImage=itemView.findViewById(R.id.webinar_card_back_image);
                webinarHead=itemView.findViewById(R.id.webinar_head);
                webinarTiming=itemView.findViewById(R.id.webinar_timing);
                webinarLevel=itemView.findViewById(R.id.webinar_level);
                webinarActivity=itemView.findViewById(R.id.webinar_activities);

            }

            else if (code==1)
            {
                partnersImage=itemView.findViewById(R.id.partner_item_logo);
            }

            else
            {
                voucherImage=itemView.findViewById(R.id.voucher_card_back_image);
                voucherCompany=itemView.findViewById(R.id.voucher_company);
                voucherTag=itemView.findViewById(R.id.voucher_tag);
                voucherTheme=itemView.findViewById(R.id.voucher_theme);
                voucherPromCode=itemView.findViewById(R.id.voucher_promocode);
                voucherValidity=itemView.findViewById(R.id.voucher_validity);
            }
        }

        void populateWebinar(WebinarModel webinarModel)
        {
            webinarActivity.setText(webinarModel.getActivity());
            webinarTiming.setText(webinarModel.getTiming());
            webinarHead.setText(webinarModel.getHeader());
            webinarImage.setImageResource(webinarModel.getWebinarImageUrl());
            webinarLevel.setText(webinarModel.getLevel());
        }

        void populateVoucher(VouchersModel vouchersModel)
        {
            voucherImage.setImageResource(vouchersModel.getVoucherImageUrl());
            voucherValidity.setText(vouchersModel.getValidity());
            voucherPromCode.setText(vouchersModel.getPromoCode());
            voucherCompany.setText(vouchersModel.getCompanyName());
            voucherTag.setText(vouchersModel.getOffer());
            voucherTheme.setText(vouchersModel.getVoucherTheme());
        }

        void populatePartners(CompanyModel companyModel)
        {
            partnersImage.setImageResource(companyModel.getCompanyImageUrl());
        }
    }
}
