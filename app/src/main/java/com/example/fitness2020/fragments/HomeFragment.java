package com.example.fitness2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

//import com.example.fitness2020.Adapters.HomePageAdapter;
import com.example.fitness2020.Adapters.HomePageAdapter;
import com.example.fitness2020.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    View view;
    SearchView searchView;
//    HomeTrendingRVAdapter adapter;
//    HomeTrendingRVAdapter banner2Adapter;
//    HomePopularRVAdapter homePopularRVAdapter;
//    RecyclerView trendingRv;
//    RecyclerView banner2Rv;
    Context context;
//    RecyclerView popularRv;
//    ArrayList<TrendingRvModel> trendingRvModels;
//    ArrayList<PopularRvModel> popularRvModels;
    TabLayout tabLayout;
    TabItem homeExploreTab,homeFitnessWorkTab,homeFreeTrialsTab;
    ViewPager viewPager;
    Fragment fragment;
    HomePageAdapter homePageAdapter;


    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        searchView=view.findViewById(R.id.home_search);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });

        /*
        trendingRv=view.findViewById(R.id.home_trending_rv);
        popularRv=view.findViewById(R.id.home_popular_rv);
        banner2Rv=view.findViewById(R.id.home_banner2_rv);
*/

        tabLayout=view.findViewById(R.id.home_tab_layout);
        homeExploreTab=view.findViewById(R.id.home_tab_explore);
        homeFitnessWorkTab=view.findViewById(R.id.home_tab_fitness_work);
        homeFreeTrialsTab=view.findViewById(R.id.home_tab_freetrials);
        viewPager=view.findViewById(R.id.home_viewpager);

        homePageAdapter=new HomePageAdapter(getChildFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount(),0);
        viewPager.setAdapter(homePageAdapter);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


                switch(tab.getPosition())
                {
                    case 0: fragment=new HomeLiveTab();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new HomeAtTheStudioTab();
                        loadFragment(fragment);
                        break;
                    case 2: fragment=new EventsFragment();
                        loadFragment(fragment);
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }


        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


//        banner2Rv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
//        popularRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
//        trendingRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
//

       /* popularRvModels=new ArrayList<>(3);
        trendingRvModels=new ArrayList<TrendingRvModel>(3);

        addData();
*/
//        homePopularRVAdapter=new HomePopularRVAdapter(popularRvModels,context);
//        adapter=new HomeTrendingRVAdapter(trendingRvModels,context,1);
//        banner2Adapter=new HomeTrendingRVAdapter(trendingRvModels,context,2);
//
//        popularRv.setAdapter(homePopularRVAdapter);
//        trendingRv.setAdapter(adapter);
//        banner2Rv.setAdapter(banner2Adapter);

        return view;

    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

    }




    /*  void addData()//when using api, add data from api here.
    {
        for(int i=0;i<6;i++)
        {

            trendingRvModels.add(new TrendingRvModel(R.mipmap.ic_launcher));

            popularRvModels.add(new PopularRvModel(R.mipmap.ic_launcher,"Gym name","Category"," Gym Address"));
        }

    }

*/
}
