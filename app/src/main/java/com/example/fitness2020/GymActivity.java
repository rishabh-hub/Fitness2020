package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness2020.Adapters.GymAdapter;
import com.example.fitness2020.Models.AddressModel;
import com.example.fitness2020.Models.GymActivitiesModel;
import com.example.fitness2020.Models.GymFacilityModel;
import com.example.fitness2020.Models.GymOfferingModel;
import com.example.fitness2020.Models.GymReviewModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;

public class GymActivity extends AppCompatActivity {

    RecyclerView reviewRv;
    ArrayList<GymReviewModel> reviewModels = new ArrayList<>();
    GymAdapter reviewAdapter;
    ArrayList<GymFacilityModel> facilityModels = new ArrayList<>();
    ArrayList<GymOfferingModel> offeringModels = new ArrayList<>();

    RecyclerView gymActivityRv,gymPhotosRv,gymVideosRv;
    ArrayList<TrendingRvModel> imageModels;
    ArrayList<VideoModel> videoModels;
    ArrayList<GymActivitiesModel> gymActivitiesModels;
    GymAdapter gymPhotosAdapter;
    GymAdapter gymVideosAdapter,gymActivityAdapter;

    Button gymBookButton;
    View view;
    ImageButton mapsButton;
    TextView gymAddress;
    public CustomDialogClass customDialogClass,customDialogClass1;
    private Boolean rvIsOpen = false;

    ImageButton backButton;
    LinearLayout addressContainer;

    TextView desc,thingsToRemember;
    TextView descViewMore,ttrViewMore,addressViewMore;

    RecyclerView gymAddressViewMore;
    GymAdapter addressAdapter;
    ArrayList<AddressModel> addressModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        attachId();


        reviewRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.VERTICAL,false));
        gymPhotosRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.HORIZONTAL,false));
        gymVideosRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.HORIZONTAL,false));
        gymActivityRv.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.HORIZONTAL,false));
        gymAddressViewMore.setLayoutManager(new LinearLayoutManager(GymActivity.this,LinearLayoutManager.VERTICAL,false));



        imageModels=new ArrayList<>(3);
        videoModels=new ArrayList<>(3);
        gymActivitiesModels=new ArrayList<>(3);
        reviewModels=new ArrayList<>(3);
        addressModels=new ArrayList<>(3);

        addData();

        reviewAdapter=new GymAdapter(GymActivity.this,6,facilityModels,offeringModels,reviewModels,addressModels);
        gymPhotosAdapter =new GymAdapter(GymActivity.this,imageModels,1,videoModels,gymActivitiesModels);
        gymVideosAdapter=new GymAdapter(GymActivity.this,imageModels,2,videoModels,gymActivitiesModels);
        gymActivityAdapter=new GymAdapter(GymActivity.this,imageModels,3,videoModels,gymActivitiesModels);
        addressAdapter=new GymAdapter(GymActivity.this,7,facilityModels,offeringModels,reviewModels,addressModels);


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
                customDialogClass1=new CustomDialogClass(GymActivity.this,1);
                customDialogClass1.setCancelable(true);
                customDialogClass1.show();
            }
        });

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialogClass=new CustomDialogClass(GymActivity.this,2);
                customDialogClass.setCancelable(true);
                customDialogClass.show();

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(GymActivity.this,MainActivity.class);
                startActivity(backIntent);
            }
        });

        addressViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleRVViewExpansion(gymAddressViewMore,addressViewMore);

            }
        });

        ttrViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleTextViewExpansion(thingsToRemember,ttrViewMore);
            }
        });

        descViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cycleTextViewExpansion(desc,descViewMore);
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
        mapsButton=findViewById(R.id.gym_map_btn);
        gymAddress=findViewById(R.id.gym_tab_address);
        backButton=findViewById(R.id.gym_activity_back_btn);
        gymAddressViewMore=findViewById(R.id.gym_address_rv);
        addressViewMore = findViewById(R.id.gym_more_address_btn);
        descViewMore = findViewById(R.id.gym_more_desc_btn);
        ttrViewMore = findViewById(R.id.gym_more_ttr_btn);
        desc = findViewById(R.id.gym_tab_desc);
        thingsToRemember = findViewById(R.id.gym_tab_ttr);
        addressContainer = findViewById(R.id.address_container);
   }

    void addData()
    {
        for (int i=0;i<=5;i++)
        {
            reviewModels.add(new GymReviewModel("Rishabh Singh","Lukhnow Fitness Center","4.5","21//07/202","Some long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long review"));
            imageModels.add(new TrendingRvModel(R.drawable.gym_dummy));
            videoModels.add(new VideoModel(R.drawable.gym_video_dummy));
            addressModels.add(new AddressModel("Silver Sunshine, 101, 9th Rd, Ram Krishna Nagar, Khar West, Mumbai, Maharashtra 400052"));

        }


        for(int i=0;i<=8;i++)
            gymActivitiesModels.add(new GymActivitiesModel("Crossfit"));

    }

    private void cycleTextViewExpansion(TextView tv,TextView txt){
        int collapsedMaxLines = 4;
        String text = tv.getMaxLines()==collapsedMaxLines?"Less":"More";
        ObjectAnimator animation = ObjectAnimator.ofInt(tv, "maxLines", tv.getMaxLines() == collapsedMaxLines? tv.getLineCount() : collapsedMaxLines);
        txt.setText(text);
        animation.setDuration(150).start();
    }
    private void cycleRVViewExpansion(RecyclerView rv,TextView txt){
        String less = "less";
        String more = "more";
        if(!rvIsOpen)
        {
            gymAddress.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
            rv.setAdapter(addressAdapter);
            rv.scheduleLayoutAnimation();
            addressAdapter.notifyDataSetChanged();
            txt.setText("Less");
        }
        else {
            gymAddress.setVisibility(View.VISIBLE);
            txt.setText("More");
            rv.setVisibility(View.GONE);
        }
        rvIsOpen = !rvIsOpen;
    }

}
