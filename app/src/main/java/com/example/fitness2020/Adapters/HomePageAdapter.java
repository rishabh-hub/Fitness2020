package com.example.fitness2020.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fitness2020.fragments.HomeExploreTab;
import com.example.fitness2020.fragments.HomeFitnessatWorkTab;
import com.example.fitness2020.fragments.HomeFreeTrialTab;
import com.example.fitness2020.fragments.SignupSlider1;
import com.example.fitness2020.fragments.SignupSlider2;
import com.example.fitness2020.fragments.SignupSlider3;

public class HomePageAdapter extends FragmentPagerAdapter {

    private int noOfTabs;
    Context context;
    int code;

    public HomePageAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs,int code) {
        super(fm, behavior);
        this.noOfTabs = noOfTabs;
        this.code=code;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                {if (code==0)
                return new HomeExploreTab();
                else
                    return new SignupSlider1();}

            case 1:
                {if(code==0)
                return new HomeFitnessatWorkTab();
                else
                    return new SignupSlider2();}
            case 2:
                {if(code==0)
                    return new HomeFreeTrialTab();
                else
                    return new SignupSlider3();}

            default:return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
