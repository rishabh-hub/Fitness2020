package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitness2020.Adapters.BookingsAdapter;
import com.example.fitness2020.Models.BookingsModel;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class BookingsActivity extends AppCompatActivity {

    RecyclerView bookingsRv;
    Chip all,cancelled,past,upcoming;
    ArrayList<BookingsModel> bookingsModels;
    BookingsAdapter bookingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        attachId();

        bookingsRv.setLayoutManager(new LinearLayoutManager(BookingsActivity.this,LinearLayoutManager.VERTICAL,false));

        bookingsModels=new ArrayList<>(3);

        addData();

        bookingsAdapter=new BookingsAdapter(bookingsModels,BookingsActivity.this,1);

        bookingsRv.setAdapter(bookingsAdapter);

        bookingsAdapter.notifyDataSetChanged();

    }

    void attachId()
    {
        bookingsRv=findViewById(R.id.bookings_rv);
        all=findViewById(R.id.bookings_chip_all);
        cancelled=findViewById(R.id.bookings_chip_cancelled);
        past=findViewById(R.id.bookings_chip_past);
        upcoming=findViewById(R.id.bookings_chip_upcoming);
    }

    void addData()
    {
        for(int i=0;i<=5;i++) {
            bookingsModels.add(new BookingsModel(10081, "FIT394AB849Z",
                    "14 march 2019", "TEST APP NEW", "Redeemed", "Jayh", "Mankhurd",
                    "7466678363", "8846677888", "1 Trial pass", R.mipmap.ic_launcher));
        }
    }
}
