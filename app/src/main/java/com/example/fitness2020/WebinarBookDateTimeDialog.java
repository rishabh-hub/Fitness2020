package com.example.fitness2020;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

public class WebinarBookDateTimeDialog extends Dialog {

    Button confirmBtn;
    Context context;

    public WebinarBookDateTimeDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check if the user has a fitness pass only then open the activity
        //otherwise display the other dialog box.which has xml name webinar_not_a_member_dialog

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_webinar_booking_final);

        attachId();

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),WebinarBookingConfirmationActivity.class);
                getContext().startActivity(intent);
                dismiss();
            }
        });
    }

    private void attachId() {
        confirmBtn = findViewById(R.id.final_booking_page_webinar_book_btn);
    }
}
