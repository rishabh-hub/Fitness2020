package com.example.fitness2020.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fitness2020.fragments.GymAboutTab;
import com.example.fitness2020.fragments.GymOfferTab;

public class GymPageAdapter extends FragmentPagerAdapter {

    private int noOfTabs;

    public GymPageAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs) {
        super(fm, behavior);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:return new GymAboutTab();
            case 1:return new GymOfferTab();
            default:return null;

        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

}