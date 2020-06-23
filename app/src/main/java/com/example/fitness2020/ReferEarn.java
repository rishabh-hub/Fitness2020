package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ReferEarn extends AppCompatActivity {
    ImageButton facebookbutton,instagramButton,gmailButton,smsButton,whatsappButton;
    TextView referralCode;
    ImageView backButton;
    ImageView copyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_earn);


        attachId();

        facebookbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, referralCode.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData=ClipData.newPlainText("code",referralCode.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(ReferEarn.this,"Code has been copied",Toast.LENGTH_SHORT).show();
            }
        });

    }

    void attachId()
    {
        facebookbutton=findViewById(R.id.ref_earn_fb_btn);
        instagramButton=findViewById(R.id.ref_earn_insta_btn);
        gmailButton=findViewById(R.id.ref_earn_email_btn);
        smsButton=findViewById(R.id.ref_earn_sms_btn);
        whatsappButton=findViewById(R.id.ref_earn_whatsapp_btn);
        referralCode=findViewById(R.id.ref_earn_code);
        backButton=findViewById(R.id.activity_refer_earn_back_btn);
//        copyButton=findViewById(R.id.);
    }
}
