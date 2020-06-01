package com.example.fitness2020.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fitness2020.fragments.EventsFragment;
import com.example.fitness2020.fragments.HomeAtTheStudioTab;
import com.example.fitness2020.fragments.HomeFitnessatWorkTab;
import com.example.fitness2020.fragments.HomeLiveTab;
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
                return new HomeLiveTab();
                else
                    return new SignupSlider1();}

            case 1:
                {if(code==0)
                return new HomeAtTheStudioTab();
                else
                    return new SignupSlider2();}
            case 2:
                {if(code==0)
                    return new EventsFragment();
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
