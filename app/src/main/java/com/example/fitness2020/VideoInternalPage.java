package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class VideoInternalPage extends AppCompatActivity {

    ImageButton backButton;
    ImageView videoThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_internal_page);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String url = "https://img.youtube.com/vi/"+"N91yhOqCRQ0"+"/0.jpg";//in the second "" we have to put the youtube video id as N91yhOqCRQ0 in https://youtu.be/N91yhOqCRQ0
        Glide.with(this).load(url).into(videoThumbnail);


        videoThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://youtu.be/N91yhOqCRQ0"));
                        intent.putExtra("force_fullscreen",true);
                        startActivity(intent);
            }
        });

    }

    private void attachId() {
        backButton=findViewById(R.id.video_internal_page_back_btn);
        videoThumbnail=findViewById(R.id.video_internal_page_thumbnail);
    }
}