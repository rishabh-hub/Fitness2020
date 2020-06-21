package com.example.fitness2020.fragments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitness2020.Adapters.BookingsActivityAdapter;
import com.example.fitness2020.Models.BookingsEventsModel;
import com.example.fitness2020.Models.BookingsLiveModel;
import com.example.fitness2020.Models.BookingsModel;
import com.example.fitness2020.Models.BookingsVoucherModel;
import com.example.fitness2020.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class BookingLiveTab extends Fragment {
    View view;
    RecyclerView bookingLiveRV;
    ArrayList<BookingsLiveModel> liveBookings;
    ArrayList<BookingsModel> dummy1;
    ArrayList<BookingsVoucherModel> dummy2;
    ArrayList<BookingsEventsModel> dummy3;
    Chip all,cancelled,past,upcoming;
    BookingsActivityAdapter liveBookingAdapter;
    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_booking_live_tab,container,false);
        attachId();

        setLayoutManager();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        updateData();



        return view;
    }

    private void updateData() {
        liveBookingAdapter.notifyDataSetChanged();
    }

    private void attachAdapter() {
        bookingLiveRV.setAdapter(liveBookingAdapter);
    }

    private void initAdapter() {
        liveBookingAdapter = new BookingsActivityAdapter(context,0,dummy1,liveBookings,dummy2,dummy3);
    }

    private void addData() {
        for (int i=0;i<6;i++)
            liveBookings.add(new BookingsLiveModel(R.drawable.gym_dummy,"Functional Training","21 August,2020","7:00 AM","Live on: Zoom","Gold","76 seats available","https://zoom.class","functrain@zoom.in","zomFunc"));
    }

    private void setLayoutManager() {
        bookingLiveRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
    }

    private void initArrayList() {
        liveBookings = new ArrayList<>();
        dummy1 = new ArrayList<>();
        dummy2 = new ArrayList<>();
        dummy3 = new ArrayList<>();
    }

    private void attachId() {
        bookingLiveRV = view.findViewById(R.id.booking_live_RV);
        all=view.findViewById(R.id.bookings_chip_all);
        cancelled=view.findViewById(R.id.bookings_chip_cancelled);
        past=view.findViewById(R.id.bookings_chip_past);
        upcoming=view.findViewById(R.id.bookings_chip_upcoming);
    }
}