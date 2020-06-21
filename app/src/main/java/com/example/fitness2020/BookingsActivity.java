package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.fitness2020.Adapters.BookingsAdapter;
import com.example.fitness2020.Adapters.BookingsPagerAdapter;
import com.example.fitness2020.Models.BookingsModel;
import com.example.fitness2020.fragments.BookingEventTab;
import com.example.fitness2020.fragments.BookingLiveTab;
import com.example.fitness2020.fragments.BookingStudioTab;
import com.example.fitness2020.fragments.BookingVoucherTab;
import com.example.fitness2020.fragments.EventsFragment;
import com.example.fitness2020.fragments.HomeAtTheStudioTab;
import com.example.fitness2020.fragments.HomeLiveTab;
import com.google.android.material.chip.Chip;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BookingsActivity extends AppCompatActivity {

//    RecyclerView bookingsRv;
//    Chip all,cancelled,past,upcoming;
//    ArrayList<BookingsModel> bookingsModels;
//    BookingsAdapter bookingsAdapter;
    Fragment fragment;
    TabLayout bookingTab;
    TabItem bookingLiveTab,bookingEventTab,bookingVoucherTab,bookingStudioTab;
    ViewPager viewPager;
    BookingsPagerAdapter bookingsPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        attachId();

        bookingsPagerAdapter=new BookingsPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,bookingTab.getTabCount(),0);


        bookingTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch(tab.getPosition())
                {
                    case 0: fragment=new BookingLiveTab();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new BookingStudioTab();
                        loadFragment(fragment);
                        break;
                    case 2: fragment=new BookingEventTab();
                        loadFragment(fragment);
                        break;

                    case 3:fragment=new BookingVoucherTab();
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


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(bookingTab));

//        bookingsRv.setLayoutManager(new LinearLayoutManager(BookingsActivity.this,LinearLayoutManager.VERTICAL,false));
//
//        bookingsModels=new ArrayList<>(3);
//
//        addData();
//
//        bookingsAdapter=new BookingsAdapter(bookingsModels,BookingsActivity.this,1);
//
//        bookingsRv.setAdapter(bookingsAdapter);
//
//        bookingsAdapter.notifyDataSetChanged();

    }

    void attachId()
    {
        bookingTab=findViewById(R.id.bookings_activity_tab_layout);
        bookingEventTab=findViewById(R.id.bookings_activity_events);
        bookingLiveTab=findViewById(R.id.bookings_activity_live);
        bookingStudioTab=findViewById(R.id.bookings_activity_studio);
        bookingVoucherTab=findViewById(R.id.bookings_activity_vouchers);
        viewPager=findViewById(R.id.bookings_activity_viewpager);
//        bookingsRv=findViewById(R.id.bookings_rv);
//        all=findViewById(R.id.bookings_chip_all);
//        cancelled=findViewById(R.id.bookings_chip_cancelled);
//        past=findViewById(R.id.bookings_chip_past);
//        upcoming=findViewById(R.id.bookings_chip_upcoming);
    }

    void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.bookings_activity_frameLayout,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

//    void addData()
//    {
//        for(int i=0;i<=5;i++) {
//            bookingsModels.add(new BookingsModel(10081, "FIT394AB849Z",
//                    "14 march 2019", "TEST APP NEW", "Redeemed", "Jayh", "Mankhurd",
//                    "7466678363", "8846677888", "1 Trial pass", R.mipmap.ic_launcher));
//        }
//    }
}
