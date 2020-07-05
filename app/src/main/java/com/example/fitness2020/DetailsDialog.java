package com.example.fitness2020;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DetailsDialog extends Dialog {
    ImageView studioImage,fitnessImage,gymImage;
    TextView studioNameTop,studioDate,studioTime,studioActivity,studioCode,studioStatus,studioAddress,studioPurchaseDetail,studioOrderId;
    TextView fitness2020Membershipame,fitness2020Price,freeTrialExpiry,webinarExpiry,voucherExpiry,pointsExpiry,autoDebitDate;
    TextView gymMembershipName,gymPrice,gymName,gymStartDate,gymEndDate,gymAddress;
    Button callButton,fitness2020ContactButton,gymContactButton;
    TextView fitness2020RefundButton;
    ImageView studioCloseButton,fitness2020CloseButton,gymMembershipCloseButton;
    String studioPhno,fitness2020Phno,gymMembershipPhno;

    int code;

    public DetailsDialog(@NonNull Context context, int themeResId, int code) {
        super(context, themeResId);
        this.code = code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (code==0)
        {
            setContentView(R.layout.bookings_studio_details_dialog);

            attachId();

            studioCloseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            callButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri number= Uri.parse("tel:"+ studioPhno);
                    Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
                    getContext().startActivity(callIntent);
                }
            });


        }

        else if (code==1)
        {
            setContentView(R.layout.fitness2020_membership_dialog);

            attachId();

            fitness2020ContactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri number= Uri.parse("tel:"+ fitness2020Phno);
                    Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
                    getContext().startActivity(callIntent);
                }
            });

            fitness2020CloseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }

        else
        {
            setContentView(R.layout.gym_membership_dialog);

            attachId();

            gymMembershipCloseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            gymContactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Uri number= Uri.parse("tel:"+ gymMembershipPhno);
                    Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
                    getContext().startActivity(callIntent);
                }
            });
        }
    }

    private void attachId() {

        if (code==0)
        {
            studioCloseButton =findViewById(R.id.booking_dialog_cut_btn);
            callButton=findViewById(R.id.booking_dialog_call_button);
            studioImage=findViewById(R.id.bookings_diaolog_imgvw);
            studioNameTop=findViewById(R.id.bookings_dialog_product_name);
            studioDate=findViewById(R.id.bookings_dialog_date);
            studioTime=findViewById(R.id.bookings_dialog_time);
            studioActivity=findViewById(R.id.bookings_dialog_activity);
            studioCode=findViewById(R.id.bookings_dialog_code);
            studioStatus=findViewById(R.id.bookings_dialog_status);
            studioAddress=findViewById(R.id.bookings_dialog_address);
            studioPurchaseDetail=findViewById(R.id.bookings_dialog_purchase_detail);
            studioOrderId=findViewById(R.id.bookings_dialog_orderid);

        }

        else if (code==1)
        {
            fitnessImage=findViewById(R.id.membership_gym_photo_dialog);
            fitness2020Membershipame=findViewById(R.id.fitness2020_membership_name_dialog);
            fitness2020Price=findViewById(R.id.membership_gym_price_dialog);
            freeTrialExpiry=findViewById(R.id.fitness2020_free_trial_expiry_dialog);
            webinarExpiry=findViewById(R.id.fitness2020_live_workout_expiry_dialog);
            voucherExpiry=findViewById(R.id.fitness2020_voucher_expiry_dialog);
            pointsExpiry=findViewById(R.id.fitness2020_points_expiry_dialog);
            autoDebitDate=findViewById(R.id.fitness2020_debit_date_dialog);
            fitness2020ContactButton=findViewById(R.id.fitness2020_membership_support_btn_dialog);
            fitness2020RefundButton=findViewById(R.id.fitness2020_membership_refund_btn_dialog);
            fitness2020CloseButton=findViewById(R.id.fitness2020_membership_dialog_cut_btn);

            fitness2020RefundButton.setPaintFlags(fitness2020RefundButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        }

        else
        {
            gymImage = findViewById(R.id.gym_membership_image_dialog);
            gymMembershipName =findViewById(R.id.gym_membership_name_dialog);
            gymPrice = findViewById(R.id.gym_membership_price_dialog);
            gymName = findViewById(R.id.gym_membership_gym_name_dialog);
            gymStartDate = findViewById(R.id.gym_membership_gym_start_date_dialog);
            gymEndDate = findViewById(R.id.gym_membership_gym_end_date_dialog);
            gymAddress = findViewById(R.id.gym_membership_gym_address_dialog);
            gymContactButton = findViewById(R.id.gym_membership_call_btn_dialog);
            gymMembershipCloseButton=findViewById(R.id.gym_membership_dialog_cut_btn);


        }
    }
}
