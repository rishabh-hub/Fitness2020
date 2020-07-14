package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.CompanyModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.Models.WebinarModel;
import com.example.fitness2020.R;
import com.example.fitness2020.WebinarBookDialog;

import java.util.ArrayList;

public class    CarousalsAdapter1 extends RecyclerView.Adapter<CarousalsAdapter1.CarouslasAdapter1VH> {
    Context context;
    ArrayList<CompanyModel> companyModels;
    ArrayList<VouchersModel> vouchersModels;
    ArrayList<WebinarModel> webinarModels;
    int code,code2;

    public CarousalsAdapter1(Context context, ArrayList<CompanyModel> companyModels, ArrayList<VouchersModel> vouchersModels, ArrayList<WebinarModel> webinarModels,int code) {
        this.context = context;
        this.companyModels = companyModels;
        this.vouchersModels = vouchersModels;
        this.webinarModels = webinarModels;
        this.code = code;
    }

    public CarousalsAdapter1(Context context, ArrayList<CompanyModel> companyModels, ArrayList<VouchersModel> vouchersModels, ArrayList<WebinarModel> webinarModels,int code,int code2) {
        this.context = context;
        this.companyModels = companyModels;
        this.vouchersModels = vouchersModels;
        this.webinarModels = webinarModels;
        this.code = code;
        this.code2=code2;
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
        TextView webinarHead,webinarTiming,webinarLevel,webinarActivity,voucherTheme,voucherCompany, noOfCoupons,voucherValidity,voucherPrice,webinarRating,webinarBookings;
        Button webinarBookBtn;
        RelativeLayout card;
        LinearLayout rating,booking;

        public CarouslasAdapter1VH(@NonNull final View itemView) {
            super(itemView);
            if (code==0)
            {
                webinarImage=itemView.findViewById(R.id.webinar_card_back_image);
                webinarHead=itemView.findViewById(R.id.webinar_head);
                webinarTiming=itemView.findViewById(R.id.webinar_timing);
                webinarLevel=itemView.findViewById(R.id.webinar_level);
                webinarActivity=itemView.findViewById(R.id.webinar_activities);
                card = itemView.findViewById(R.id.card);
                webinarBookBtn = itemView.findViewById(R.id.webinar_book_btn);
                webinarRating = itemView.findViewById(R.id.webinar_rating);
                rating = itemView.findViewById(R.id.webinar_rating_linlay);
                webinarBookings = itemView.findViewById(R.id.webinar_bookings_made);
                booking = itemView.findViewById(R.id.booking_number_container);

                webinarBookBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WebinarBookDialog webinarBookDialog=new WebinarBookDialog(itemView.getContext());
                        webinarBookDialog.setCancelable(true);
                        webinarBookDialog.show();
                    }
                });
            }

            else if (code==1)
            {
                partnersImage=itemView.findViewById(R.id.partner_item_logo);
            }

            else
            {
                voucherImage=itemView.findViewById(R.id.voucher_card_back_image);
                voucherCompany=itemView.findViewById(R.id.voucher_company);
                voucherPrice=itemView.findViewById(R.id.voucher_price);
                voucherTheme=itemView.findViewById(R.id.voucher_theme);
                noOfCoupons =itemView.findViewById(R.id.voucher_number);
                voucherValidity=itemView.findViewById(R.id.voucher_validity);
            }
        }

        void populateWebinar(WebinarModel webinarModel)
        {
            if(code2==1)
               { webinarImage.setVisibility(View.GONE);
               rating.setVisibility(View.GONE);
               booking.setVisibility(View.GONE);
               }
            else {
                webinarImage.setImageResource(webinarModel.getWebinarImageUrl());
                webinarRating.setText(webinarModel.getRating());
                webinarBookings.setText(Integer.toString(webinarModel.getBookings())+" people have booked so far");
            }
            webinarActivity.setText(webinarModel.getActivity());
            webinarTiming.setText(webinarModel.getTiming());
            webinarHead.setText(webinarModel.getHeader());
            webinarLevel.setText(webinarModel.getLevel());
        }

        void populateVoucher(VouchersModel vouchersModel)
        {
            voucherImage.setImageResource(vouchersModel.getVoucherImageUrl());
            voucherValidity.setText(vouchersModel.getValidity());
            noOfCoupons.setText(vouchersModel.getNoOfCoupons());
            voucherCompany.setText(vouchersModel.getCompanyName());
            voucherPrice.setText(vouchersModel.getVoucherPrice());
            voucherTheme.setText(vouchersModel.getOffer());
        }

        void populatePartners(CompanyModel companyModel)
        {
            partnersImage.setImageResource(companyModel.getCompanyImageUrl());
        }
    }
}
