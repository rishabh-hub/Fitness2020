package com.example.fitness2020;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ConcurrentModificationException;

public class ReviewDialogClass extends Dialog {

    ImageView personImage;
    TextView personName,fitnessCenterName,rating,date,reviewText;
    int code;

    public ReviewDialogClass(@NonNull Context context, int code) {
        super(context);
        this.code = code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (code==0)
        {
            setContentView(R.layout.gym_review_dialog_layout);

            attachId();
        }

    }

    void attachId()
    {
        if (code==0) {
            personImage = findViewById(R.id.gym_review_user_pic);
            personName = findViewById(R.id.gym_review_user_name);
            fitnessCenterName=findViewById(R.id.review_gym_name);
            rating=findViewById(R.id.review_gym_rating);
            date=findViewById(R.id.review_gym_date);
            reviewText=findViewById(R.id.review_gym_review);
        }
    }
}
