package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Adapters.LoginPageImageAdapter;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.TrendingRvModel;

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    RecyclerView imageRv;
    LoginPageImageAdapter imageAdapter;
    ArrayList<TrendingRvModel> imageModel;
    Button loginButton,signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        attachId();

        imageRv.setLayoutManager(new LinearLayoutManager(LoginPage.this,LinearLayoutManager.HORIZONTAL,false));

        imageModel=new ArrayList<>(3);

        addData();


        imageAdapter=new LoginPageImageAdapter(imageModel,LoginPage.this);

        imageRv.setAdapter(imageAdapter);

        imageAdapter.notifyDataSetChanged();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginInternalIntent=new Intent(LoginPage.this,LoginInternalActivity.class);
                startActivity(loginInternalIntent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupInternalIntent=new Intent(LoginPage.this,SignupInternalActivity.class);
                startActivity(signupInternalIntent);
            }
        });


    }

    void attachId()
    {
        imageRv=findViewById(R.id.login_image_rv);
        loginButton=findViewById(R.id.login_page_loginbtn);
        signupButton=findViewById(R.id.login_page_signupbtn);
    }

    void addData()
    {
        for(int i=0;i<=5;i++)
            imageModel.add(new TrendingRvModel(R.drawable.trending_activity));

    }
}
