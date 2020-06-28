package com.example.fitness2020.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.BookingsEventsModel;
import com.example.fitness2020.Models.BookingsLiveModel;
import com.example.fitness2020.Models.BookingsModel;
import com.example.fitness2020.Models.BookingsVoucherModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class BookingsActivityAdapter extends RecyclerView.Adapter<BookingsActivityAdapter.BookingsActivityAdapterRvVH> {

    Context context;
    int code;
    ArrayList<BookingsModel> studioModels;
    ArrayList<BookingsLiveModel> liveModels;
    ArrayList<BookingsVoucherModel> voucherModels;
    ArrayList<BookingsEventsModel> eventsModels;

    public BookingsActivityAdapter(Context context, int code, ArrayList<BookingsModel> studioModels, ArrayList<BookingsLiveModel> liveModels, ArrayList<BookingsVoucherModel> voucherModels, ArrayList<BookingsEventsModel> eventsModels) {
        this.context = context;
        this.code = code;
        this.studioModels = studioModels;
        this.liveModels = liveModels;
        this.voucherModels = voucherModels;
        this.eventsModels = eventsModels;
    }

    @NonNull
    @Override
    public BookingsActivityAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (code==0)
        {
            return new BookingsActivityAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_live_rv_item,parent,false));
        }
        else if (code==1)
        {
            return new BookingsActivityAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings_studio_rv_item,parent,false));
        }
        else if (code==2)
        {
            return new BookingsActivityAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_event_rv_item,parent,false));
        }
        else
        {
            return new BookingsActivityAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_voucher_rv_item,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BookingsActivityAdapterRvVH holder, int position) {

        if (code==0)
        {
            holder.populateLive(liveModels.get(position));
        }
        else if (code==1)
        {
            holder.populateStudio(studioModels.get(position));
        }
        else if (code==2)
        {
            holder.populateEvent(eventsModels.get(position));
        }
        else
        {
            holder.populateVoucher(voucherModels.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (code==0)
        {
            return liveModels.size();
        }
        else if (code==1)
        {
            return studioModels.size();
        }
        else if (code==2)
        {
            return eventsModels.size();
        }
        else
        {
            return voucherModels.size();
        }
    }

    public class BookingsActivityAdapterRvVH extends RecyclerView.ViewHolder
    {
        ImageView liveImage,studioImage,studioDirection;
        TextView liveCategory,liveName,liveTime,liveDate,liveClassType,liveZoomId,liveZoomPassword,liveSeats;
        TextView studioNameTop,studioDate,studioTime,studioActivity,studioCode,studioOrderId,studioStatus,studioAddress,studioPurchaseDetail;
        Button studioCall,studioViewDetails;
        Button liveIcon;
        public BookingsActivityAdapterRvVH(@NonNull View itemView) {
            super(itemView);

            if (code==0)
            {
                liveCategory=itemView.findViewById(R.id.booking_live_privilege);
                liveImage=itemView.findViewById(R.id.booking_live_image);
                liveName=itemView.findViewById(R.id.booking_live_name);
                liveTime=itemView.findViewById(R.id.booking_live_time);
                liveDate=itemView.findViewById(R.id.booking_live_date);
                liveClassType=itemView.findViewById(R.id.booking_live_class_type);
                liveZoomId=itemView.findViewById(R.id.booking_live_zoom_id);
                liveZoomPassword=itemView.findViewById(R.id.booking_live_zoom_password);
                liveSeats=itemView.findViewById(R.id.booking_live_no_of_seats);
                liveIcon=itemView.findViewById(R.id.booking_live_start_button);


                liveClassType.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent sendIntent
                        //add intent to send to zoom or instagram
                    }
                });
                liveIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent sendIntent

                        //add intent to send to zoom or instagram.
                    }
                });

            }
            else if (code==1)
            {
                studioImage=itemView.findViewById(R.id.bookings_rv_item_imgvw);
                studioDirection=itemView.findViewById(R.id.booking_locate_btn);
                studioNameTop=itemView.findViewById(R.id.bookings_rv_item_product_name);
                studioDate=itemView.findViewById(R.id.bookings_rv_item_date);
                studioTime=itemView.findViewById(R.id.bookings_rv_item_time);
                studioActivity=itemView.findViewById(R.id.bookings_rv_item_activity);
                studioCode=itemView.findViewById(R.id.bookings_rv_item_code);
                studioOrderId=itemView.findViewById(R.id.bookings_rv_item_orderid);
                studioStatus=itemView.findViewById(R.id.bookings_rv_item_status);
                studioAddress=itemView.findViewById(R.id.bookings_rv_item_address2);
                studioPurchaseDetail=itemView.findViewById(R.id.bookings_rv_item_purchase_detail);
                studioCall=itemView.findViewById(R.id.booking_call_button);
                studioViewDetails=itemView.findViewById(R.id.booking_details_button);
            }
            else if (code==2)
            {

            }
            else
            {

            }
        }


        public void populateLive(BookingsLiveModel bookingsLiveModel) {
            liveCategory.setText(bookingsLiveModel.getCategory());
            liveImage.setImageResource(bookingsLiveModel.getImageId());
            liveName.setText(bookingsLiveModel.getName());
            liveTime.setText(bookingsLiveModel.getTime());
            liveDate.setText(bookingsLiveModel.getDate());
            liveClassType.setText(bookingsLiveModel.getClassType());
            liveZoomId.setText(bookingsLiveModel.getZoomId());
            liveZoomPassword.setText(bookingsLiveModel.getZoomPassword());
            liveSeats.setText(bookingsLiveModel.getActivity());


        }

        public void populateStudio(final BookingsModel bookingsModel) {

            studioImage.setImageResource(bookingsModel.getImageId());
            studioNameTop.setText(bookingsModel.getProductName());
            studioDate.setText(bookingsModel.getPurchaseDate());
            studioTime.setText(bookingsModel.getTime());
            studioActivity.setText(bookingsModel.getActivity());
            studioCode.setText(bookingsModel.getCode());
            studioOrderId.setText(Integer.toString(bookingsModel.getBookingId()));
            studioStatus.setText(bookingsModel.getStatus());
            studioAddress.setText(bookingsModel.getAddress2());
            studioPurchaseDetail.setText(bookingsModel.getPurchaseDetails());
            studioCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent callIntent
                }
            });
            studioViewDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent viewIntent
                }
            });
            studioDirection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String address=bookingsModel.getAddress2();
                    Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    if (mapIntent.resolveActivity(itemView.getContext().getPackageManager()) != null) {
                        itemView.getContext().startActivity(mapIntent);
                    } else{
                        Toast.makeText(itemView.getContext(),"Please install Google maps to use this feature",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        public void populateEvent(BookingsEventsModel bookingsEventsModel) {
        }

        public void populateVoucher(BookingsVoucherModel bookingsVoucherModel) {
        }
    }
}
