package com.example.fitness2020.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fitness2020.fragments.EveningFragmentTab;
import com.example.fitness2020.fragments.EventsFragment;
import com.example.fitness2020.fragments.HomeAtTheStudioTab;
import com.example.fitness2020.fragments.HomeLiveTab;
import com.example.fitness2020.fragments.MorningFragmentTab;
import com.example.fitness2020.fragments.SignupSlider1;
import com.example.fitness2020.fragments.SignupSlider2;
import com.example.fitness2020.fragments.SignupSlider3;

public class WebinarTabAdapter extends FragmentPagerAdapter {

    private int noOfTabs;

    public WebinarTabAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs) {
        super(fm, behavior);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0: {
                return new MorningFragmentTab();
            }

            case 1: {
                return new EveningFragmentTab();
            }
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
