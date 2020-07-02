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

import com.example.fitness2020.MainActivity;
import com.example.fitness2020.NameFragment;
import com.example.fitness2020.R;

public class OtpVerificationFragment extends Fragment {

    View view;
    ImageView backButton;
    Button confirmButton;
    EditText otp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_otpverification,container,false);

        attachId();

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new NameFragment());
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new PhoneNumberFragment());
            }
        });
        return view;
    }

    private void attachId() {
        backButton=view.findViewById(R.id.verify_page_back_btn);
        confirmButton=view.findViewById(R.id.verify_button);
        otp=view.findViewById(R.id.verify_otp);

    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.verification_activity_frame,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
