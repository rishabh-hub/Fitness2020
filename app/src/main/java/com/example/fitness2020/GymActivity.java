package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fitness2020.Adapters.GymPageAdapter;
import com.example.fitness2020.fragments.GymAboutTab;
import com.example.fitness2020.fragments.GymOfferTab;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class GymActivity extends AppCompatActivity {

    TabLayout gymTabLayout;
    TabItem descriptionTab,offeringsTab;
    ViewPager gymViewPager;
    GymPageAdapter gymPageAdapter;
    Fragment gymFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        attachId();

        gymPageAdapter=new GymPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,gymTabLayout.getTabCount());

        gymViewPager.setAdapter(gymPageAdapter);

        gymTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                gymViewPager.setCurrentItem(tab.getPosition());


                switch(tab.getPosition())
                {
                    case 0: gymFragment=new GymAboutTab();
                        loadFragment(gymFragment);
                        break;
                    case 1: gymFragment=new GymOfferTab();
                        loadFragment(gymFragment);
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

        gymViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(gymTabLayout));

    }

    void attachId()
    {
        gymTabLayout=findViewById(R.id.gym_tab_layout);
        descriptionTab=findViewById(R.id.gym_description);
        offeringsTab=findViewById(R.id.gym_offerings);
        gymViewPager=findViewById(R.id.gym_view_pager);

    }

    void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.gym_frame_layout,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

    }
}
