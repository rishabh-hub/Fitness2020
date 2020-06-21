package com.example.fitness2020.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fitness2020.fragments.BookingEventTab;
import com.example.fitness2020.fragments.BookingLiveTab;
import com.example.fitness2020.fragments.BookingStudioTab;
import com.example.fitness2020.fragments.BookingVoucherTab;
import com.example.fitness2020.fragments.EventsFragment;
import com.example.fitness2020.fragments.HomeAtTheStudioTab;
import com.example.fitness2020.fragments.HomeLiveTab;
import com.example.fitness2020.fragments.SignupSlider1;
import com.example.fitness2020.fragments.SignupSlider2;
import com.example.fitness2020.fragments.SignupSlider3;

public class BookingsPagerAdapter extends FragmentPagerAdapter {

    private int noOfTabs;
    int code;

    public BookingsPagerAdapter(@NonNull FragmentManager fm, int behavior, int noOfTabs, int code) {
        super(fm, behavior);
        this.noOfTabs = noOfTabs;
        this.code = code;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0:
                return new BookingLiveTab();
            case 1:
                return new BookingStudioTab();
            case 2:
                return new BookingEventTab();
            case 3:
                return new BookingVoucherTab();

            default:return null;
        }


    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
