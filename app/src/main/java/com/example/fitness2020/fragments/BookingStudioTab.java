package com.example.fitness2020.fragments;

import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.BookingsActivityAdapter;
import com.example.fitness2020.Models.BookingsEventsModel;
import com.example.fitness2020.Models.BookingsLiveModel;
import com.example.fitness2020.Models.BookingsModel;
import com.example.fitness2020.Models.BookingsVoucherModel;
import com.example.fitness2020.R;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class BookingStudioTab extends Fragment {
    View view;
    Context context;
    RecyclerView bookingsStudioRv;
    Chip all,cancelled,past,upcoming;
    ArrayList<BookingsModel> bookingsModels;
    ArrayList<BookingsLiveModel> bookingsLiveModels;
    ArrayList<BookingsEventsModel> bookingsEventsModels;
    ArrayList<BookingsVoucherModel> bookingsVoucherModels;
    BookingsActivityAdapter bookingsStudioAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_booking_studio_tab,container,false);

        attachId();

        setLayout();

        initArrayList();

        addData();

        initAdapter();

        attachAdapter();

        updateAdapter();

        return view;
    }

    private void addData() {
        bookingsModels.add(new BookingsModel(R.drawable.gym_dummy,100010,"55BC02R5","!5 April","New Product","Redeemed","221 Baker Street Bombay","7466678363","Crossfit","15:00-16:00","Free Trial"));
    }

    private void updateAdapter() {
        bookingsStudioAdapter.notifyDataSetChanged();
    }

    private void attachAdapter() {
        bookingsStudioRv.setAdapter(bookingsStudioAdapter);
    }

    private void initAdapter() {
        bookingsStudioAdapter=new BookingsActivityAdapter(view.getContext(),1,bookingsModels,bookingsLiveModels,bookingsVoucherModels,bookingsEventsModels);
    }

    private void initArrayList() {
        bookingsModels=new ArrayList<>(3);
    }

    private void setLayout() {
        bookingsStudioRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void attachId() {

        bookingsStudioRv=view.findViewById(R.id.booking_studio_RV);
        all=view.findViewById(R.id.bookings_chip_all);
        cancelled=view.findViewById(R.id.bookings_chip_cancelled);
        past=view.findViewById(R.id.bookings_chip_past);
        upcoming=view.findViewById(R.id.bookings_chip_upcoming);
    }
}