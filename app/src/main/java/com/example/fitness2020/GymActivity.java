package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitness2020.Adapters.GymAdapter;
import com.example.fitness2020.Models.GymActivitiesModel;
import com.example.fitness2020.Models.GymFacilityModel;
import com.example.fitness2020.Models.GymOfferingModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;

public class GymActivity extends AppCompatActivity {

    RecyclerView reviewRv;
    ArrayList<ReviewModel> reviewModels = new ArrayList<>();
    GymAdapter reviewAdapter;
    ArrayList<GymFacilityModel> facilityModels = new ArrayList<>();
    ArrayList<GymOfferingModel> offeringModels = new ArrayList<>();

    RecyclerView gymActivityRv,gymPhotosRv,gymVideosRv;
    ArrayList<TrendingRvModel> imageModels;
    ArrayList<VideoModel> videoModels;
    ArrayList<GymActivitiesModel> gymActivitiesModels;
    GymAdapter gymPhotosAdapter;
    GymAdapter gymVideosAdapter,gymActivityAdapter;

    Button gymBookButton,mapsButton;
    TextView gymAddress;
    public CustomDialogClass customDialogClass;
    private String address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        attachId();


        reviewRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.HORIZONTAL,false));
        gymPhotosRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.HORIZONTAL,false));
        gymVideosRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.HORIZONTAL,false));
        gymActivityRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.HORIZONTAL,false));


        imageModels=new ArrayList<>(3);
        videoModels=new ArrayList<>(3);
        gymActivitiesModels=new ArrayList<>(3);
        reviewModels=new ArrayList<>(3);

        addData();

        reviewAdapter=new GymAdapter(GymActivity.this,6,facilityModels,offeringModels,reviewModels);
        gymPhotosAdapter =new GymAdapter(GymActivity.this,imageModels,1,videoModels,gymActivitiesModels);
        gymVideosAdapter=new GymAdapter(GymActivity.this,imageModels,2,videoModels,gymActivitiesModels);
        gymActivityAdapter=new GymAdapter(GymActivity.this,imageModels,3,videoModels,gymActivitiesModels);

        reviewRv.setAdapter(reviewAdapter);
        gymPhotosRv.setAdapter(gymPhotosAdapter);
        gymVideosRv.setAdapter(gymVideosAdapter);
        gymActivityRv.setAdapter(gymActivityAdapter);


        reviewAdapter.notifyDataSetChanged();
        gymPhotosAdapter.notifyDataSetChanged();
        gymVideosAdapter.notifyDataSetChanged();
        gymActivityAdapter.notifyDataSetChanged();

        gymBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialogClass=new CustomDialogClass(GymActivity.this,1);
                customDialogClass.setCancelable(true);
                customDialogClass.show();
            }
        });

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address=gymAddress.getText().toString();
                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }

    void attachId()
    {

        gymActivityRv=findViewById(R.id.gym_tab_activity_rv);
        gymPhotosRv=findViewById(R.id.gym_photos_rv);
        gymVideosRv=findViewById(R.id.gym_tab_videos_rv);
        reviewRv=findViewById(R.id.gym_tab_reviews_rv);
        gymBookButton=findViewById(R.id.gym_tab_pass_btn);
//        mapsButton=findViewById(R.id);
        gymAddress=findViewById(R.id.gym_tab_address);
    }

    void addData()
    {
        for (int i=0;i<=5;i++)
        {
            reviewModels.add(new ReviewModel("XYZ", "ABC", "Very Good Product"));
            imageModels.add(new TrendingRvModel(R.drawable.gym_dummy));
            videoModels.add(new VideoModel(R.drawable.gym_video_dummy));
        }


        for(int i=0;i<=8;i++)
            gymActivitiesModels.add(new GymActivitiesModel("Crossfit"));

    }

}
