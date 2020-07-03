package com.example.fitness2020.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;
import com.example.fitness2020.VideoInternalPage;

import java.util.ArrayList;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideosAdapterRvVH> {

    ArrayList<VideoModel> fitnesspassVideos,dailyWorkoutVideos,studioVideos,corporateVideos,memberships;
    Context context;
    int code;


    public VideosAdapter(ArrayList<VideoModel> fitnesspassVideos, ArrayList<VideoModel> dailyWorkoutVideos, ArrayList<VideoModel> studioVideos, ArrayList<VideoModel> corporateVideos, ArrayList<VideoModel> memberships, Context context, int code) {
        this.fitnesspassVideos = fitnesspassVideos;
        this.dailyWorkoutVideos = dailyWorkoutVideos;
        this.studioVideos = studioVideos;
        this.corporateVideos = corporateVideos;
        this.memberships = memberships;
        this.context = context;
        this.code = code;
    }

    @NonNull
    @Override
    public VideosAdapterRvVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (code==0)
        return new VideosAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_large_layout,parent,false));//for video on fitness pass fragment
        //below this everything is for the videos on the videosActivity
        else if (code==1)
            return new VideosAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_large_layout,parent,false));
        else if (code==2)
            return new VideosAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));
        else if (code==3)
            return new VideosAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));
        else if (code==4)
            return new VideosAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_at_work_video_rv_item,parent,false));
        else
            return new VideosAdapterRvVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_large_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final VideosAdapterRvVH holder, int position) {

        if (code==0) {
            holder.populateFitnessPassFragment(fitnesspassVideos.get(position));
        }
        else if (code==1) {
            holder.populateFitnessPass(fitnesspassVideos.get(position));
        }
        else if (code==2) {
            holder.populateDailyWrokout(dailyWorkoutVideos.get(position));
        }
        else if (code==3) {
            holder.populateStudio(studioVideos.get(position));
        }
        else if (code==4){
            holder.populateCorporate(corporateVideos.get(position));
        }
        else
        {
            holder.populateMemberships(memberships.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (code==0)
        return fitnesspassVideos.size();
        else if (code==1)
            return fitnesspassVideos.size();
        else if (code==2)
            return dailyWorkoutVideos.size();
        else if (code==3)
            return studioVideos.size();
        else if (code==4)
            return corporateVideos.size();
        else
            return memberships.size();
    }

    public class VideosAdapterRvVH extends RecyclerView.ViewHolder
    {
        ImageView fitnessPassFragmentVideos,fitnessPassVideos,studioVideos,dailyWorkoutVideos,corporateVideos,memnershipImage;
        public VideosAdapterRvVH(@NonNull final View itemView) {
            super(itemView);

            if (code==0) {
                fitnessPassFragmentVideos = itemView.findViewById(R.id.video_large_item);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW,
//                                Uri.parse("https://youtu.be/N91yhOqCRQ0"));
//                        intent.putExtra("force_fullscreen",true);
//                        itemView.getContext().startActivity(intent);
                        Intent videoInternalIntent=new Intent(itemView.getContext(), VideoInternalPage.class);
                        itemView.getContext().startActivity(videoInternalIntent);
                    }
                });
            }
            else if (code==1) {
                fitnessPassVideos = itemView.findViewById(R.id.video_large_item);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent videoInternalIntent=new Intent(itemView.getContext(), VideoInternalPage.class);
                        itemView.getContext().startActivity(videoInternalIntent);
                    }
                });
            }
            else if (code==2) {
                dailyWorkoutVideos = itemView.findViewById(R.id.home_fitness_at_work_video);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent videoInternalIntent=new Intent(itemView.getContext(), VideoInternalPage.class);
                        itemView.getContext().startActivity(videoInternalIntent);
                    }
                });
            }
            else if (code==3) {
                studioVideos = itemView.findViewById(R.id.home_fitness_at_work_video);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent videoInternalIntent=new Intent(itemView.getContext(), VideoInternalPage.class);
                        itemView.getContext().startActivity(videoInternalIntent);
                    }
                });
            }
            else if (code==4){
                corporateVideos=itemView.findViewById(R.id.home_fitness_at_work_video);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent videoInternalIntent=new Intent(itemView.getContext(), VideoInternalPage.class);
                        itemView.getContext().startActivity(videoInternalIntent);
                    }
                });
            }
            else
            {
                memnershipImage=itemView.findViewById(R.id.video_large_item);
            }

        }

        void populateFitnessPassFragment(VideoModel videoModel)
        {
            fitnessPassFragmentVideos.setImageResource(videoModel.getVideoImageResource());
        }

        void populateFitnessPass(VideoModel videoModel)
        {
            fitnessPassVideos.setImageResource(videoModel.getVideoImageResource());
        }
        void populateDailyWrokout(VideoModel videoModel)
        {
            dailyWorkoutVideos.setImageResource(videoModel.getVideoImageResource());
        }

        void populateStudio(VideoModel videoModel)
        {
            studioVideos.setImageResource(videoModel.getVideoImageResource());
        }

        void populateCorporate(VideoModel videoModel)
        {
            corporateVideos.setImageResource(videoModel.getVideoImageResource());
        }

        public void populateMemberships(VideoModel videoModel) {
            memnershipImage.setImageResource(videoModel.getVideoImageResource());
        }
    }
}
