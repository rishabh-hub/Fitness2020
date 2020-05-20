package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.BookingsModel;
import com.example.fitness2020.Models.MembershipModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class BookingsAdapter extends RecyclerView.Adapter<BookingsAdapter.BookingsAdaperVH> {

    ArrayList<BookingsModel> bookingsModels;
    ArrayList<MembershipModel> membershipModels;
    Context context;
    int code;



    public BookingsAdapter(ArrayList<BookingsModel> bookingsModels, Context context, int code) {
        this.bookingsModels = bookingsModels;
        this.context = context;
        this.code = code;
    }

    public BookingsAdapter(ArrayList<MembershipModel> membershipModels, Context context) {
        this.membershipModels = membershipModels;
        this.context = context;
        this.code = code;
    }

    @NonNull
    @Override
    public BookingsAdaperVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code==1)
            return new BookingsAdaperVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings_rv_item,parent,false));
        else
            return new BookingsAdaperVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.membership_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookingsAdaperVH holder, int position) {

        //use if else acc to code
        if(code==1)
            holder.bookingsPopulate(bookingsModels.get(position));
        else
            holder.membershipsPopulate(membershipModels.get(position));
    }

    @Override
    public int getItemCount() {

        //insert if else according to code
        if(code==1)
            return bookingsModels.size();
        else
            return membershipModels.size();
    }

    public class BookingsAdaperVH extends RecyclerView.ViewHolder
    {
        ImageView gymImage,memberGymImage;
        TextView productName,purchaseDate,bookingCode,bookingId,status,address1,address2,contact1,contact2,purchaseDetails;
        TextView memberPurchaseDate,memberGymName,memberOrderID,memberAmount,memberDiscount,memberPayableAmount,memberPoints,memberPointsExpiry,memberType,memberTypeExpiry;

        public BookingsAdaperVH(@NonNull View itemView) {
            super(itemView);
            //use if else
            if(code==1)
            {
                gymImage=itemView.findViewById(R.id.bookings_rv_item_imgvw);
                productName=itemView.findViewById(R.id.bookings_rv_item_product_name);
                purchaseDate=itemView.findViewById(R.id.bookings_rv_item_date);
                bookingCode=itemView.findViewById(R.id.bookings_rv_item_code);
                bookingId=itemView.findViewById(R.id.bookings_rv_item_orderid);
                status=itemView.findViewById(R.id.bookings_rv_item_status);
                address1=itemView.findViewById(R.id.bookings_rv_item_address1);
                address2=itemView.findViewById(R.id.bookings_rv_item_address2);
                contact1=itemView.findViewById(R.id.bookings_rv_item_contact1);
                contact2=itemView.findViewById(R.id.bookings_rv_item_contact2);
                purchaseDetails=itemView.findViewById(R.id.bookings_rv_item_purchase_detail);
            }
            else
            {
                memberGymImage = itemView.findViewById(R.id.membership_gym_photo);
                memberPurchaseDate = itemView.findViewById(R.id.membership_gym_purchased);
                memberGymName = itemView.findViewById(R.id.membership_gym_name);
                memberOrderID = itemView.findViewById(R.id.membership_gym_order);
                memberAmount = itemView.findViewById(R.id.membership_amount);
                memberDiscount = itemView.findViewById(R.id.membership_discount);
                memberPayableAmount = itemView.findViewById(R.id.membership_payable_amount);
                memberPoints = itemView.findViewById(R.id.membership_points);
                memberPointsExpiry = itemView.findViewById(R.id.membership_points_expiry);
                memberType = itemView.findViewById(R.id.membership_type);
                memberTypeExpiry = itemView.findViewById(R.id.membership_type_expiry);
            }

        }

        void bookingsPopulate(BookingsModel bookingsModel)
        {
            gymImage.setImageResource(bookingsModel.getImageId());
            productName.setText(bookingsModel.getProductName());
            purchaseDate.setText(bookingsModel.getPurchaseDate());
            bookingCode.setText(bookingsModel.getCode());
            bookingId.setText(Integer.toString(bookingsModel.getBookingId()));
            status.setText(bookingsModel.getStatus());
            address1.setText(bookingsModel.getAddress1());
            address2.setText(bookingsModel.getAddress2());
            contact1.setText(bookingsModel.getContact1());
            contact2.setText(bookingsModel.getContact2());
            purchaseDetails.setText(bookingsModel.getPurchaseDetails());

        }

        public void membershipsPopulate(MembershipModel membershipModel) {
            memberGymImage.setImageResource(membershipModel.getImageID());
            memberGymName.setText(membershipModel.getGymName());
            memberPurchaseDate.setText(membershipModel.getPurchaseDate());
            memberOrderID.setText(membershipModel.getOrder());
            memberAmount.setText(membershipModel.getAmount());
            memberDiscount.setText(membershipModel.getDiscount());
            memberPayableAmount.setText(membershipModel.getAmountPayable());
            memberPoints.setText("Points: "+membershipModel.getPoints());
            memberPointsExpiry.setText("Expiry: "+membershipModel.getPointsExpiry());
            memberType.setText(membershipModel.getMembershipType());
            memberTypeExpiry.setText("Expiry: "+membershipModel.getMembershipTypeExpiry());

        }
    }
}
