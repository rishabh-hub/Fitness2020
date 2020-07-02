package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

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