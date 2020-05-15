package com.example.fitness2020.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitness2020.R;

public class ValidityCardActivity extends AppCompatActivity {

    RecyclerView imageRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validity_card);

        attachId();

        imageRv.setLayoutManager(new LinearLayoutManager(ValidityCardActivity.this,LinearLayoutManager.HORIZONTAL,false));


    }

    void attachId()
    {
        imageRv=findViewById(R.id.validity_card_imagerv);
    }
}
