package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    public GymAdapter(Context context, ArrayList<TrendingRvModel> imageModels, int code, ArrayList<VideoModel> videoModels, ArrayList<GymActivitiesModel> gymActivitiesModels) {
        this.context = context;
        this.imageModels = imageModels;
        this.code = code;
        this.videoModels = videoModels;
        this.gymActivitiesModels = gymActivitiesModels;
    }

    public GymAdapter(Context context, int code, ArrayList<GymFacilityModel> facilityModels, ArrayList<GymOfferingModel> offeringModels, ArrayList<ReviewModel> reviewModels) {
        this.context = context;
        this.code = code;
        this.facilityModels = facilityModels;
        this.offeringModels = offeringModels;
        this.reviewModels = reviewModels;
    }

    @NonNull
    @Override
    public GymAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(code==1)
        return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trialcard_imagerv_xml,parent,false));

        else if(code==2)
            return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));

        else if(code ==3)
            return new GymAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_activity_rv_item,parent,false));

        else if (code==4)
            return new GymAdapterVH((LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_offerings_rv_item,parent,false)));
        else if(code==5)
            return new GymAdapterVH((LayoutInflater.from(parent.getContext()).inflate(R.layout.gym_facility_rv_item,parent,false)));
        else
            return new GymAdapterVH((LayoutInflater.from(parent.getContext()).inflate(R.layout.review_rv_item,parent,false)));




    }

    @Override
    public void onBindViewHolder(@NonNull GymAdapterVH holder, int position) {

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
        else
            holder.reviewPopulate(reviewModels.get(position));


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
        else
            return reviewModels.size();
    }

    public class GymAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView gymImage, gymVideo;
        TextView gymActivity,offeringName,oneClassName,oneClassPtsBefore,oneClassPtsAfter,oneMonthPriceBefore,oneMonhPriceAfter;
        TextView facility,reviewProduct,reviewPerson,reviewDesc;
        Button bookOneClass,bookOneMonth;

        public GymAdapterVH(@NonNull View itemView) {
            super(itemView);

            if (code==1)
                gymImage=itemView.findViewById(R.id.rv_item_trailcard_imgvw);

            else if(code==2)
                gymVideo=itemView.findViewById(R.id.home_fitness_at_work_video);

            else if(code==3)
             gymActivity=itemView.findViewById(R.id.gym_activity_rv_activity);

            else if(code==4)
            {
                offeringName = itemView.findViewById(R.id.offering_rv_item_name);
                oneClassName = itemView.findViewById(R.id.offering_1_class);
                oneClassPtsBefore = itemView.findViewById(R.id.offering_pt_before);
                oneClassPtsAfter = itemView.findViewById(R.id.offering_pt_after);
                oneMonthPriceBefore = itemView.findViewById(R.id.offering_price_before);
                oneMonhPriceAfter = itemView.findViewById(R.id.offering_price_after);
                bookOneClass = itemView.findViewById(R.id.offering_item_1_day_btn);
                bookOneMonth = itemView.findViewById(R.id.offering_item_1_month_btn);
            }
            else if(code==5)
                facility = itemView.findViewById(R.id.gym_facility_name);
            else
            {
                reviewPerson = itemView.findViewById(R.id.review_name);
                reviewProduct = itemView.findViewById(R.id.review_product);
                reviewDesc = itemView.findViewById(R.id.review_desc);
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
            oneClassName.setText(gymOfferingModel.getOneClassName());
            oneClassPtsBefore.setText(gymOfferingModel.getOneClassPtsBefore()+" Pts");
            oneClassPtsAfter.setText(gymOfferingModel.getOneClassPtsAfter());
            oneMonthPriceBefore.setText(gymOfferingModel.getOneMonthPriceBefore());
            oneMonhPriceAfter.setText(gymOfferingModel.getOneMonthPriceAfter());
        }

        public void facilityPopulate(GymFacilityModel gymFacilityModel) {
            facility.setText(gymFacilityModel.getFacility());
        }

        public void reviewPopulate(ReviewModel reviewModel) {
            reviewPerson.setText(reviewModel.getName());
            reviewProduct.setText(reviewModel.getProduct());
            reviewDesc.setText(reviewModel.getDescription());
        }
    }
}
