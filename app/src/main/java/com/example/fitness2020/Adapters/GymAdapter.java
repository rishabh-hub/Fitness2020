package com.example.fitness2020.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.CustomDialogClass;
import com.example.fitness2020.GymActivity;
import com.example.fitness2020.GymBookingFinalPage;
import com.example.fitness2020.Models.AddressModel;
import com.example.fitness2020.Models.GymActivitiesModel;
import com.example.fitness2020.Models.GymFacilityModel;
import com.example.fitness2020.Models.GymOfferingModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GymAdapter extends RecyclerView.Adapter<GymAdapter.GymAdapterVH> {

    Context context;
    ArrayList<TrendingRvModel> imageModels;
    int code;
    ArrayList<VideoModel> videoModels;
    ArrayList<GymActivitiesModel> gymActivitiesModels;
    ArrayList<GymFacilityModel> facilityModels;
    ArrayList<GymOfferingModel> offeringModels;
    ArrayList<ReviewModel> reviewModels;
    ArrayList<AddressModel> addressModels;
    CustomDialogClass customDialogClass;

    public GymAdapter(Context context, ArrayList<TrendingRvModel> imageModels, int code, ArrayList<VideoModel> videoModels, ArrayList<GymActivitiesModel> gymActivitiesModels) {
        this.context = context;
        this.imageModels = imageModels;
        this.code = code;
        this.videoModels = videoModels;
        this.gymActivitiesModels = gymActivitiesModels;
    }

    public GymAdapter(Context context, int code, ArrayList<GymFacilityModel> facilityModels, ArrayList<GymOfferingModel> offeringModels, ArrayList<ReviewModel> reviewModels,ArrayList<AddressModel> addressModels) {
        this.context = context;
        this.code = code;
        this.facilityModels = facilityModels;
        this.offeringModels = offeringModels;
        this.reviewModels = reviewModels;
        this.addressModels=addressModels;

    }

    @NonNull
    @Override
    public GymAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code==1)
        return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_description_image_rv_item,parent,false));

        else if(code==2)
            return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));

        else if(code ==3)
            return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_activity_rv_item,parent,false));

        else if (code==4)
            return new GymAdapterVH((LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_offerings_rv_item,parent,false)));
        else if(code==5)
            return new GymAdapterVH((LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_facility_rv_item,parent,false)));
        else if (code==6)
            return new GymAdapterVH((LayoutInflater.from(parent.getContext()).inflate(R.layout.review_rv_item,parent,false)));

        else
            return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_address_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final GymAdapterVH holder, int position) {

        if (code==1)
            holder.imagePopulate(imageModels.get(position));
        else if(code==2)
            holder.videoPopulate(videoModels.get(position));
        else if(code==3)
            holder.gymActivityPopulate(gymActivitiesModels.get(position));
        else if(code==4)
            holder.offerPopulate(offeringModels.get(position));
        else if(code==5)
            holder.facilityPopulate(facilityModels.get(position));
        else if (code ==6)
            holder.reviewPopulate(reviewModels.get(position));

        else
            {
            holder.addressPopulate(addressModels.get(position));
        }


    }

    @Override
    public int getItemCount() {
        if (code ==1)
        return imageModels.size();
        else if(code==2)
            return  videoModels.size();
        else if(code==3)
            return gymActivitiesModels.size();
        else if(code==4)
            return offeringModels.size();
        else if (code==5)
            return facilityModels.size();
        else if (code==6)
            return reviewModels.size();
        else
            return addressModels.size();
    }

    public class GymAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView gymImage, gymVideo;
        TextView gymActivity,offeringName,offeringPrice,offeringActivityName,gymAddress;
        TextView facility,reviewProduct,reviewPerson,reviewDesc;
        Button offeringBookBtn;

        public GymAdapterVH(@NonNull final View itemView) {
            super(itemView);

            if (code==1)
                gymImage=itemView.findViewById(R.id.rv_item_gym_offerings_imgvw);

            else if(code==2)
                gymVideo=itemView.findViewById(R.id.home_fitness_at_work_video);

            else if(code==3)
             gymActivity=itemView.findViewById(R.id.gym_activity_rv_activity);

            else if(code==4)
            {
                offeringName = itemView.findViewById(R.id.offering_rv_item_name);
                offeringPrice = itemView.findViewById(R.id.offering_price);
                offeringActivityName = itemView.findViewById(R.id.offering_name);
                offeringBookBtn = itemView.findViewById(R.id.offering_book_btn);

                offeringBookBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent gymFinalBookingPageIntent=new Intent(itemView.getContext(), GymBookingFinalPage.class);
                        itemView.getContext().startActivity(gymFinalBookingPageIntent);
                    }
                });
            }
            else if(code==5)
                facility = itemView.findViewById(R.id.gym_facility_name);
            else if (code==6)
            {
                reviewPerson = itemView.findViewById(R.id.review_name);
                reviewProduct = itemView.findViewById(R.id.review_product);
                reviewDesc = itemView.findViewById(R.id.review_desc);
            }
            else
                {
                gymAddress = itemView.findViewById(R.id.gym_address_dialog_item);

                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String address=gymAddress.getText().toString();
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
        }

        void imagePopulate(TrendingRvModel trendingRvModel)
        {
            gymImage.setImageResource(trendingRvModel.getImageUrl());
        }

        void videoPopulate(VideoModel videoModel)
        {
            gymVideo.setImageResource(videoModel.getVideoImageResource());
        }

        void gymActivityPopulate(GymActivitiesModel gymActivitiesModel)
        {
            gymActivity.setText(gymActivitiesModel.getActivity());
        }

        public void offerPopulate(GymOfferingModel gymOfferingModel) {
            offeringName.setText(gymOfferingModel.getOfferingName());
            offeringPrice.setText(gymOfferingModel.getOfferingPrice());
            offeringActivityName.setText(gymOfferingModel.getOfferingActivity());
        }

        public void facilityPopulate(GymFacilityModel gymFacilityModel) {
            facility.setText(gymFacilityModel.getFacility());
        }

        public void reviewPopulate(ReviewModel reviewModel) {
            reviewPerson.setText(reviewModel.getName());
            reviewProduct.setText(reviewModel.getProduct());
            reviewDesc.setText(reviewModel.getDescription());
        }

        public void addressPopulate(AddressModel addressModel)
        {
            gymAddress.setText(addressModel.getAddress());
        }
    }
}
