package com.example.fitness2020;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.GymAdapter;
import com.example.fitness2020.Models.AddressModel;
import com.example.fitness2020.Models.GymFacilityModel;
import com.example.fitness2020.Models.GymOfferingModel;
import com.example.fitness2020.Models.GymReviewModel;
import com.example.fitness2020.Models.ReviewModel;

import java.util.ArrayList;

public class CustomDialogClass extends Dialog {

    public Context context;
    public Dialog dialog;
    int code;
    public Button continueBtn;
    public EditText nameEt,emailET,phoneET,addressET;
    RecyclerView offeringsRv,gymAddressesRv;
    ArrayList<GymOfferingModel> gymOfferingModels=new ArrayList<>();
    ArrayList<GymFacilityModel> facilityModels = new ArrayList<>();
    ArrayList<GymReviewModel> reviewModels = new ArrayList<>();
    ArrayList<AddressModel> addressModels=new ArrayList<>();
    GymAdapter offeringsAdapter;
    GymAdapter addressAdapter;

    public CustomDialogClass(@NonNull Context context,int code) {
        super(context);
        this.context = context;
        this.code = code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if(code == 0)
          {
              setContentView(R.layout.details_dialog);
              attachId();

              continueBtn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent gymFinalBookingPageIntent=new Intent(context,GymBookingFinalPage.class);
                      context.startActivity(gymFinalBookingPageIntent);
                  }
              });
          }

        else if (code==1){
            setContentView(R.layout.offering_dialog);
            attachId();

            offeringsRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

            gymOfferingModels=new ArrayList<>(3);

            addData();

            offeringsAdapter=new GymAdapter(context,4,facilityModels,gymOfferingModels,reviewModels,addressModels);

            offeringsRv.setAdapter(offeringsAdapter);

            offeringsAdapter.notifyDataSetChanged();
        }

        else
        {
            setContentView(R.layout.address_dialog_layout);

            attachId();

            gymAddressesRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

            addressModels=new ArrayList<>(3);
            addData();

            addressAdapter=new GymAdapter(context,7,facilityModels,gymOfferingModels,reviewModels,addressModels);

            gymAddressesRv.setAdapter(addressAdapter);

            addressAdapter.notifyDataSetChanged();
        }


    }

    void attachId()
    {
        if (code==1)
            offeringsRv=findViewById(R.id.offerings_rv);
        else if(code==0)
        {
            nameEt = findViewById(R.id.details_name);
            phoneET = findViewById(R.id.details_ph);
            emailET = findViewById(R.id.details_email);
            addressET = findViewById(R.id.details_address);
            continueBtn = findViewById(R.id.details_continue_btn);
        }
        else
            gymAddressesRv = findViewById(R.id.gym_address_dialog_rv);
    }

    void addData()
    {
        for (int i=0;i<=6;i++)
            {gymOfferingModels.add(new GymOfferingModel("Free Trial","Rs 499","Yoga Fit"));
        addressModels.add(new AddressModel("Silver Sunshine, 101, 9th Rd, Ram Krishna Nagar, Khar West, Mumbai, Maharashtra 400052"));}
    }
}
