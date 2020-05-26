package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.CarousalsAdapter1;
import com.example.fitness2020.Adapters.HomePopularRVAdapter;
import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Models.CompanyModel;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.PopularRvModel;
import com.example.fitness2020.Models.ReviewModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VouchersModel;
import com.example.fitness2020.Models.WebinarModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class HomeExploreTab extends Fragment {

    View view;
    Context context;
    RecyclerView recyclerView;
    HomeTrendingRVAdapter adapter;
    HomeTrendingRVAdapter banner2Adapter;
    HomePopularRVAdapter homePopularRVAdapter,adapter2;
    SubscriptionCardsAdapter membershipAdapter;
    CarousalsAdapter1 webinarAdapter,voucherAdapter,companyAdapter;
    RecyclerView trendingRv;
    RecyclerView banner2Rv;
    RecyclerView popularRv;
    RecyclerView popularVerticalRv,popularVerticalRV2,popularRV3,popularRV4;
    RecyclerView membershipRV;
    RecyclerView companyRv,vouchersRv,webinarRv;
    ArrayList<TrendingRvModel> trendingRvModels;
    ArrayList<PopularRvModel> popularRvModels;
    ArrayList<ReviewModel> reviews;
    ArrayList<PackModel> packModels;
    ArrayList<PopularHorizontalRvModel> popularHorizontalRvModels;
    ArrayList<WebinarModel> webinarModels;
    ArrayList<VouchersModel> vouchersModels;
    ArrayList<CompanyModel> companyModels;
    Spinner filterSpinner;

    public HomeExploreTab() {
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
        membershipRV=view.findViewById(R.id.explore_membership_rv);
        filterSpinner=view.findViewById(R.id.filter_spinner);
        popularVerticalRv=view.findViewById(R.id.home_popular_vertical_rv);
        popularVerticalRV2 = view.findViewById(R.id.home_trending_rv_3);
        popularRV3 = view.findViewById(R.id.home_trending_rv_4);
        popularRV4 = view.findViewById(R.id.home_trending_rv_5);
        webinarRv=view.findViewById(R.id.explore_webinar_rv);
        vouchersRv=view.findViewById(R.id.explore_voucher_rv);
        companyRv=view.findViewById(R.id.explore_partners_rv);

        populateFilterSpinner();

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Context context1=parent.getContext();
                if(parent.getId()==R.id.filter_spinner)
                {
                    Toast.makeText(context1, "Selected "+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
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
        membershipRV.setLayoutManager(new GridLayoutManager(context,1,GridLayoutManager.HORIZONTAL,false));
        popularVerticalRV2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        companyRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        vouchersRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        webinarRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));



        popularRvModels=new ArrayList<>(3);
        trendingRvModels=new ArrayList<TrendingRvModel>(3);
        popularHorizontalRvModels=new ArrayList<>(3);
        packModels = new ArrayList<>(3);
        companyModels=new ArrayList<>(3);
        vouchersModels=new ArrayList<>(3);
        webinarModels=new ArrayList<>(3);

        addData();

        //the next few lines are a masterpiece
        homePopularRVAdapter=new HomePopularRVAdapter(popularRvModels,context);
        adapter=new HomeTrendingRVAdapter(trendingRvModels,context,1,popularHorizontalRvModels);
        adapter2=new HomePopularRVAdapter(popularRvModels,context);
        banner2Adapter=new HomeTrendingRVAdapter(trendingRvModels,context,2,popularHorizontalRvModels);
        membershipAdapter = new SubscriptionCardsAdapter(context,2,packModels);
        webinarAdapter=new CarousalsAdapter1(context,companyModels,vouchersModels,webinarModels,0);
        voucherAdapter=new CarousalsAdapter1(context,companyModels,vouchersModels,webinarModels,2);
        companyAdapter=new CarousalsAdapter1(context,companyModels,vouchersModels,webinarModels,1);



        popularRv.setAdapter(homePopularRVAdapter);
        popularRV3.setAdapter(homePopularRVAdapter);
        popularRV4.setAdapter(homePopularRVAdapter);
        trendingRv.setAdapter(adapter);
        banner2Rv.setAdapter(banner2Adapter);
        popularVerticalRv.setAdapter(homePopularRVAdapter);
        membershipRV.setAdapter(membershipAdapter);
        popularVerticalRV2.setAdapter(adapter2);
        webinarRv.setAdapter(webinarAdapter);
        vouchersRv.setAdapter(voucherAdapter);
        companyRv.setAdapter(companyAdapter);

        homePopularRVAdapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
        banner2Adapter.notifyDataSetChanged();
        membershipAdapter.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();
        webinarAdapter.notifyDataSetChanged();
        voucherAdapter.notifyDataSetChanged();
        companyAdapter.notifyDataSetChanged();

        return view;
    }



    void addData()//when using api, add data from api here.
    {
        for(int i=0;i<5;i++)
        {

            trendingRvModels.add(new TrendingRvModel(R.drawable.trending_activity));

            popularRvModels.add(new PopularRvModel(R.drawable.gym_photo,"One More Rep","Crossfit, Zumba","Mumbai,Maharashtra ,400022","50 % OFF","4.9"));
//            Gurukripa lane, Opposite SIES College
            popularHorizontalRvModels.add(new PopularHorizontalRvModel(R.drawable.gym_dummy,"Danceout by Burzin Engineer","Dance, Aerobics","Tue-Fri 9:00 AM"));


             webinarModels.add(new WebinarModel("Functional Training","9:00 AM - 10:00 AM","Live from Mumbai","Zumba/Crossfit",R.drawable.webinar));
             vouchersModels.add(new VouchersModel("Trending","Gym Company","GYM50","Till Jun '20",R.drawable.gym_voucher,"FLAT 50% OFF"));
             companyModels.add(new CompanyModel(R.drawable.company_logo,"OTIS Company"));
        }
        packModels.add(new PackModel("Unlimited Workouts",99));
        packModels.add(new PackModel("Unlimited Workouts",99));
        packModels.add(new PackModel("Unlimited Workouts",99));
        packModels.add(new PackModel("Unlimited Workouts",99));
        packModels.add(new PackModel("Unlimited Workouts",99));
        packModels.add(new PackModel("Unlimited Workouts",99));

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


}
