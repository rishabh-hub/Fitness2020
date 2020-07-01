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

public class WebinarBookDialog extends Dialog {

    Button yesButton,noButton;
    Context context;

    public WebinarBookDialog(@NonNull Context context) {
        super(context);
        context=this.context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check if the user has a fitness pass only then open the activity
        //otherwise display the other dialog box.which has xml name webinar_not_a_member_dialog

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        setContentView(R.layout.);

        attachId();

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webinarBookingItent=new Intent(context,WebinarBookingConfirmationActivity.class);
                context.startActivity(webinarBookingItent);
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
        yesButton=findViewById(R.id.);
        noButton=findViewById(R.id.);
    }
}
