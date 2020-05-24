package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fitness2020.Adapters.HomePageAdapter;
import com.example.fitness2020.fragments.SignupSlider1;
import com.example.fitness2020.fragments.SignupSlider2;
import com.example.fitness2020.fragments.SignupSlider3;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class SignupNewActivity extends AppCompatActivity {

    TabLayout signUpTab;
    TabItem item1,item2,item3;
    ViewPager sliderVp;
    Fragment fragment;
    HomePageAdapter homePageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_new);

        attachId();

        homePageAdapter=new HomePageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,signUpTab.getTabCount(),1);
        sliderVp.setAdapter(homePageAdapter);

        signUpTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                sliderVp.setCurrentItem(tab.getPosition());

                switch(tab.getPosition())
                {
                    case 0: fragment=new SignupSlider1();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new SignupSlider2();
                        loadFragment(fragment);
                        break;
                    case 2: fragment=new SignupSlider3();
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

        sliderVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(signUpTab));

    }

    void attachId()
    {
        //link tabLayout,tabitems and viewPager
    }

    void loadFragment(Fragment fragment)
    {

    }
}
