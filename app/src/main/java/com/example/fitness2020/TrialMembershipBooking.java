package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;

public class TrialMembershipBooking extends AppCompatActivity {

    ImageView backButton;
    TextInputLayout promo;
    EditText promoCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_membership_booking);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        promo.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promo.clearFocus();
                promoCode.clearFocus();
                promoCode.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(promo.getWindowToken(), 0);

            }
        });

    }

    private void attachId() {

        backButton=findViewById(R.id.membership_booking_page_back_btn);
        promo=findViewById(R.id.promo_layout);
        promoCode=findViewById(R.id.final_booking_page_gym_promoET);

    }

}
