package com.example.fitness2020.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fitness2020.NumberVerificationActivity;
import com.example.fitness2020.R;
import com.example.fitness2020.SignupNewActivity;

public class PhoneNumberFragment extends Fragment {

    View view;
    ImageView backButton;
    Button nextButton;
    EditText phNo;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_phonenumber,container,false);

        attachId();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new OtpVerificationFragment());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent=new Intent(view.getContext(), SignupNewActivity.class);
                startActivity(backIntent);
            }
        });
        return view;
    }

    private void attachId() {
        backButton=view.findViewById(R.id.number_page_back_btn);
        nextButton=view.findViewById(R.id.continue_button);
        phNo=view.findViewById(R.id.phonenumber_number);

    }


    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.verification_activity_frame,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
