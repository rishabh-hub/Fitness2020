package com.example.fitness2020.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.CollectionInternalActivity;
import com.example.fitness2020.Models.CollectionsModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;
import com.example.fitness2020.VideoInternalPage;

import java.util.ArrayList;

public class CollectionsAdapter extends RecyclerView.Adapter<CollectionsAdapter.CollectionsAdapterVH> {

    Context context;
    int code;
    ArrayList<CollectionsModel> collectionsModels;
    ArrayList<VideoModel> videoModels;

    public CollectionsAdapter(Context context, int code, ArrayList<CollectionsModel> collectionsModels, ArrayList<VideoModel> videoModels) {
        this.context = context;
        this.code = code;
        this.collectionsModels = collectionsModels;
        this.videoModels = videoModels;
    }

    @NonNull
    @Override
    public CollectionsAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (code==0)
        return new CollectionsAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_offers_card_layout,parent,false));
        else {
            return new CollectionsAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsAdapterVH holder, int position) {

        if (code==0)
            holder.populateOffers(collectionsModels.get(position));
        else
            holder.populateVideo(videoModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (code==0)
        return collectionsModels.size();
        else
            return videoModels.size();
    }

    public class CollectionsAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView collectionImage,videoImage;
        TextView collectionHeading,collectionSubHeading;

        public CollectionsAdapterVH(@NonNull final View itemView) {
            super(itemView);

            if (code==0)
            {
                collectionImage=itemView.findViewById(R.id.main_offer_card_image);
                collectionHeading=itemView.findViewById(R.id.main_offer_card_heading);
                collectionSubHeading=itemView.findViewById(R.id.main_offer_card_subheading);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goToInternalPage = new Intent(itemView.getContext(), CollectionInternalActivity.class);
                        itemView.getContext().startActivity(goToInternalPage);
                    }
                });

            }

            else
                videoImage=itemView.findViewById(R.id.home_fitness_at_work_video);
        }

        void populateOffers(CollectionsModel collectionsModel)
        {
            collectionImage.setImageResource(collectionsModel.getImageUrl());
            collectionHeading.setText(collectionsModel.getCollectionHeading());
            collectionSubHeading.setText(collectionsModel.getPlaces());

        }

        void populateVideo(VideoModel videoModel)
        {
            videoImage.setImageResource(videoModel.getVideoImageResource());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent videoInternalIntent=new Intent(itemView.getContext(), VideoInternalPage.class);
                    itemView.getContext().startActivity(videoInternalIntent);
                }
            });

        }
    }
}
