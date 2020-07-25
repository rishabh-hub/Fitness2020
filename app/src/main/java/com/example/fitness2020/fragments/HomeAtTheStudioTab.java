package com.example.fitness2020.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.ActivityDialog;
import com.example.fitness2020.Adapters.ActivityAdapter;
import com.example.fitness2020.Adapters.CarousalsAdapter1;
import com.example.fitness2020.Adapters.CollectionsAdapter;
import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Adapters.NewCorrectionAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.CustomDialogClass;
import com.example.fitness2020.GymActivity;
import com.example.fitness2020.MainActivity;
import com.example.fitness2020.Models.ActivityModel;
import com.example.fitness2020.Models.CollectionsModel;
import com.example.fitness2020.Models.CompanyModel;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.PopularRvModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.Models.WebinarModel;
import com.example.fitness2020.PopularActivity;
import com.example.fitness2020.R;
import com.example.fitness2020.VideosActivity;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;

import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;

public class HomeAtTheStudioTab extends Fragment {

    View view;
    Context context;
    RecyclerView recyclerView;
    HomeTrendingRVAdapter adapter;
    HomeTrendingRVAdapter banner2Adapter,topBannerAdapter;
    HomePopularRVAdapter homePopularRVAdapter,adapter2;
    CarousalsAdapter1 voucherAdapter,companyAdapter;
    CollectionsAdapter videoAdapter,collectionsAdapter;
    RecyclerView trendingRv;
    RecyclerView banner2Rv;
    RecyclerView popularRv;
    RecyclerView popularVerticalRv,popularVerticalRV2,popularRV3,popularRV4;
    RecyclerView companyRv,vouchersRv;
    RecyclerView topBannerRv;
    RecyclerView collectionsRv;
    RecyclerView videoRv;
    ArrayList<PopularRvModel> popularRvModels;
    ArrayList<PackModel> packModels;
    ArrayList<PopularHorizontalRvModel> popularHorizontalRvModels;
    ArrayList<WebinarModel> webinarModels;
    ArrayList<VouchersModel> vouchersModels;
    ArrayList<CompanyModel> companyModels;
    ArrayList<TrendingRvModel> topBannerModel;
    ArrayList<CollectionsModel> collectionsModels;
    ArrayList<VideoModel> videoModels;
    Spinner filterSpinner;
    TextView vouchersViewMoreButton,popularViewMoreButton,videosViewMoreButton;
    NewCorrectionAdapter newCorrectionAdapter;
    ArrayList<TrendingRvModel> trendingRvModels,webinarVideos;
    CardView getFitNow;
    LinearLayout viewMoreActivity;
    ActivityDialog activityDialog;
    RecyclerView activityRv;
    ArrayList<ActivityModel> activityModels,activityModels1;
    ActivityAdapter activityAdapter;

    public HomeAtTheStudioTab() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.home_fragment_explore_tab,container,false);

        trendingRv=view.findViewById(R.id.home_trending_rv);
        popularRv=view.findViewById(R.id.home_trending_rv_1);
        banner2Rv=view.findViewById(R.id.home_banner2_rv);
        filterSpinner=view.findViewById(R.id.filter_spinner);
        popularVerticalRv=view.findViewById(R.id.home_popular_vertical_rv);
        popularVerticalRV2 = view.findViewById(R.id.home_trending_rv_3);
        popularRV3 = view.findViewById(R.id.home_trending_rv_4);
        popularRV4 = view.findViewById(R.id.home_trending_rv_5);
        vouchersRv=view.findViewById(R.id.explore_voucher_rv);
        companyRv=view.findViewById(R.id.explore_partners_rv);
        topBannerRv=view.findViewById(R.id.explore_workout_rv);
        collectionsRv=view.findViewById(R.id.explore_main_offer_card_rv);
        videoRv=view.findViewById(R.id.explore_brand_videos_rv);
        popularViewMoreButton=view.findViewById(R.id.home_fragment_explore_tab_more_popular_btn);
        vouchersViewMoreButton=view.findViewById(R.id.home_fragment_explore_tab_more_voucher_btn);
        videosViewMoreButton=view.findViewById(R.id.home_fragment_explore_tab_more_videos_btn);
        getFitNow=view.findViewById(R.id.popular_gym_start_card);
        viewMoreActivity=view.findViewById(R.id.view_more_activity);
        activityRv=view.findViewById(R.id.activity_filter_rv);

        populateFilterSpinner();

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Context context1=parent.getContext();
                if(parent.getId()==R.id.filter_spinner)
                {
//                    Toast.makeText(context1, "Selected "+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        banner2Rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        popularRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        popularRV3.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        popularRV4.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        trendingRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        popularVerticalRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        popularVerticalRV2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        companyRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        vouchersRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        topBannerRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        collectionsRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        videoRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        activityRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));


        popularRvModels=new ArrayList<>(3);
        trendingRvModels=new ArrayList<TrendingRvModel>(3);
        webinarVideos=new ArrayList<>(3);
        popularHorizontalRvModels=new ArrayList<>(3);
        packModels = new ArrayList<>(3);
        companyModels=new ArrayList<>(3);
        vouchersModels=new ArrayList<>(3);
        topBannerModel=new ArrayList<>(3);
        collectionsModels=new ArrayList<>(3);
        videoModels=new ArrayList<>(3);
        activityModels1=new ArrayList<>(3);

        addData();

        //the next few lines are a masterpiece
        homePopularRVAdapter=new HomePopularRVAdapter(popularRvModels,context);
        newCorrectionAdapter=new NewCorrectionAdapter(1,webinarVideos,trendingRvModels);
        adapter2=new HomePopularRVAdapter(popularRvModels,context);
        banner2Adapter=new HomeTrendingRVAdapter(trendingRvModels,context,2,popularHorizontalRvModels);
        voucherAdapter=new CarousalsAdapter1(context,companyModels,vouchersModels,webinarModels,2);
        companyAdapter=new CarousalsAdapter1(context,companyModels,vouchersModels,webinarModels,1);
        topBannerAdapter=new HomeTrendingRVAdapter(topBannerModel,context,1,popularHorizontalRvModels);
        collectionsAdapter=new CollectionsAdapter(context,0,collectionsModels,videoModels);
        videoAdapter=new CollectionsAdapter(context,1,collectionsModels,videoModels);
        activityAdapter=new ActivityAdapter(activityModels,activityModels1,1);

        popularRv.setAdapter(homePopularRVAdapter);
        popularRV3.setAdapter(homePopularRVAdapter);
        popularRV4.setAdapter(homePopularRVAdapter);
        trendingRv.setAdapter(newCorrectionAdapter);
        banner2Rv.setAdapter(banner2Adapter);
        popularVerticalRv.setAdapter(homePopularRVAdapter);
        popularVerticalRV2.setAdapter(adapter2);
        vouchersRv.setAdapter(voucherAdapter);
        companyRv.setAdapter(companyAdapter);
        topBannerRv.setAdapter(topBannerAdapter);
        collectionsRv.setAdapter(collectionsAdapter);
        videoRv.setAdapter(videoAdapter);
        activityRv.setAdapter(activityAdapter);

        homePopularRVAdapter.notifyDataSetChanged();
        newCorrectionAdapter.notifyDataSetChanged();
        banner2Adapter.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
        voucherAdapter.notifyDataSetChanged();
        companyAdapter.notifyDataSetChanged();
        topBannerAdapter.notifyDataSetChanged();
        collectionsAdapter.notifyDataSetChanged();
        videoAdapter.notifyDataSetChanged();
        activityAdapter.notifyDataSetChanged();

        popularViewMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popularIntent=new Intent(view.getContext(), PopularActivity.class);
                startActivity(popularIntent);
            }
        });

        vouchersViewMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voucherIntent=new Intent(view.getContext(), MainActivity.class);
                voucherIntent.putExtra("code",1);
                startActivity(voucherIntent);
            }
        });

        videosViewMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent=new Intent(view.getContext(), VideosActivity.class);
                startActivity(videoIntent);
            }
        });

        getFitNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().loadFragment(new PassFragment());
                MainActivity.getInstance().bottomNavigationView.setSelectedItemId(R.id.fitness_pass);
            }
        });

        viewMoreActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityDialog=new ActivityDialog(view.getContext());
                activityDialog.setCancelable(true);
                activityDialog.show();
            }
        });

        return view;
    }



    void addData()//when using api, add data from api here.
    {
        for(int i=0;i<5;i++)
        {

            trendingRvModels.add(new TrendingRvModel(R.drawable.trending_activity));

            popularRvModels.add(new PopularRvModel(R.drawable.gym_photo,"One More Rep","Crossfit, Zumba","Mumbai,Maharashtra ,400022","50 % OFF","4.9"));
            popularHorizontalRvModels.add(new PopularHorizontalRvModel(R.drawable.gym_dummy,"Danceout by Burzin Engineer","Dance, Aerobics","Tue-Fri 9:00 AM","4.9"));

            collectionsModels.add(new CollectionsModel(R.drawable.webinar,"Fitnes @99","17 Places"));
            videoModels.add(new VideoModel(R.drawable.brand_video_dummy));
//             webinarModels.add(new WebinarModel("Functional Training","9:00 AM - 10:00 AM","INTERMEDIATE","Zumba/Crossfit",R.drawable.gym_dummy));
             vouchersModels.add(new VouchersModel("Flat 50% OFF","Gym Company","4","Till Jun '20",R.drawable.gym_voucher,"FREE"));
             companyModels.add(new CompanyModel(R.drawable.company_logo));
            packModels.add(new PackModel("Unlimited Workouts",4000,2499,"Free webinar sessions"));
            topBannerModel.add(new TrendingRvModel(R.drawable.workout_carousel_dummy));

            activityModels1.add(new ActivityModel("Zumba",R.drawable.ic_rhythmic_gymnastics));
        }

    }

    void populateFilterSpinner()
    {
        ArrayList<String> spinnerData=new ArrayList<>();
        spinnerData.add("Filter 1");
        spinnerData.add("Filter 2");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,spinnerData);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(adapter);
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
