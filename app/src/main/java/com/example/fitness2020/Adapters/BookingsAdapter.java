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
import com.example.fitness2020.R;

import java.util.ArrayList;

public class BookingsAdapter extends RecyclerView.Adapter<BookingsAdapter.BookingsAdaperVH> {

    ArrayList<BookingsModel> bookingsModels;
    Context context;
    int code;



    public BookingsAdapter(ArrayList<BookingsModel> bookingsModels, Context context, int code) {
        this.bookingsModels = bookingsModels;
        this.context = context;
        this.code = code;
    }

    @NonNull
    @Override
    public BookingsAdaperVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //use if else acc to code
        return new BookingsAdaperVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookingsAdaperVH holder, int position) {

        //use if else acc to code

        holder.bookingsPopulate(bookingsModels.get(position));
    }

    @Override
    public int getItemCount() {

        //insert if else according to code
        return bookingsModels.size();
    }

    public class BookingsAdaperVH extends RecyclerView.ViewHolder
    {
        ImageView gymImage;
        TextView productName,purchaseDate,code,bookingId,status,address1,address2,contact1,contact2,purchaseDetails;

        public BookingsAdaperVH(@NonNull View itemView) {
            super(itemView);
            //use if else

            gymImage=itemView.findViewById(R.id.bookings_rv_item_imgvw);
            productName=itemView.findViewById(R.id.bookings_rv_item_product_name);
            purchaseDate=itemView.findViewById(R.id.bookings_rv_item_date);
            code=itemView.findViewById(R.id.bookings_rv_item_code);
            bookingId=itemView.findViewById(R.id.bookings_rv_item_orderid);
            status=itemView.findViewById(R.id.bookings_rv_item_status);
            address1=itemView.findViewById(R.id.bookings_rv_item_address1);
            address2=itemView.findViewById(R.id.bookings_rv_item_address2);
            contact1=itemView.findViewById(R.id.bookings_rv_item_contact1);
            contact2=itemView.findViewById(R.id.bookings_rv_item_contact2);
            purchaseDetails=itemView.findViewById(R.id.bookings_rv_item_purchase_detail);

        }

        void bookingsPopulate(BookingsModel bookingsModel)
        {
            gymImage.setImageResource(bookingsModel.getImageId());
            productName.setText(bookingsModel.getProductName());
            purchaseDate.setText(bookingsModel.getPurchaseDate());
            code.setText(bookingsModel.getCode());
            bookingId.setText(bookingsModel.getBookingId());
            status.setText(bookingsModel.getStatus());
            address1.setText(bookingsModel.getAddress1());
            address2.setText(bookingsModel.getAddress2());
            contact1.setText(bookingsModel.getContact1());
            contact2.setText(bookingsModel.getContact2());
            purchaseDetails.setText(bookingsModel.getPurchaseDetails());

        }

    }
}
