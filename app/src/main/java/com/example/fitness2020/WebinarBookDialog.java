package com.example.fitness2020;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.google.android.material.chip.ChipGroup;

public class WebinarBookDialog extends Dialog {

    Button yesButton,noButton;
    Context context;


    public WebinarBookDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check if the user has a fitness pass only then open the activity
        //otherwise display the other dialog box.which has xml name webinar_not_a_member_dialog

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.webinar_confirmation_dialog);

        attachId();

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebinarBookDateTimeDialog webinarBookDateTimeDialog=new WebinarBookDateTimeDialog(context,R.style.Theme_MaterialComponents_NoActionBar);
                webinarBookDateTimeDialog.setCancelable(true);
                webinarBookDateTimeDialog.show();
                dismiss();
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void attachId() {
        yesButton=findViewById(R.id.webinar_confirm_positive_btn);
        noButton=findViewById(R.id.webinar_confirm_negative_btn);
    }
}
