package com.example.fitness2020.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fitness2020.fragments.HomeExploreTab;
import com.example.fitness2020.fragments.HomeFitnessatWorkTab;
import com.example.fitness2020.fragments.HomeFreeTrialTab;

public class HomePageAdapter extends FragmentPagerAdapter {

    private int noOfTabs;
    Context context;

    public HomePageAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs) {
        super(fm, behavior);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:return new HomeExploreTab();
            case 1:return new HomeFitnessatWorkTab();
            case 2:return new HomeFreeTrialTab();
            default:return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
