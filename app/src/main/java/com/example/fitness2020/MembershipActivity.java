package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitness2020.Adapters.BookingsAdapter;
import com.example.fitness2020.Models.MembershipModel;

import java.util.ArrayList;

public class MembershipActivity extends AppCompatActivity {
    RecyclerView membershipRV;
    ArrayList<MembershipModel> membershipModels = new ArrayList<>();
    BookingsAdapter membershipAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        membershipRV = findViewById(R.id.membership_rv);
        membershipRV.setLayoutManager(new LinearLayoutManager(MembershipActivity.this,LinearLayoutManager.VERTICAL,false));
        membershipAdapter = new BookingsAdapter(membershipModels,MembershipActivity.this);
        addData();
        membershipRV.setAdapter(membershipAdapter);
        membershipAdapter.notifyDataSetChanged();
    }

    private void addData() {
        for (int i=0;i<5;i++)
            membershipModels.add(new MembershipModel(R.drawable.gym_photo,"2020 Lite","22 March,2020","10000012","4800","-0","4800","Trials: Unlimited","20","20 Sep,2020","20 Sep,2020"));
    }
}
