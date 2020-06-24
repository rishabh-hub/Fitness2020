package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.fitness2020.Adapters.HomePageAdapter;
import com.example.fitness2020.fragments.SignupSlider1;
import com.example.fitness2020.fragments.SignupSlider2;
import com.example.fitness2020.fragments.SignupSlider3;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Random;

public class SignupNewActivity extends AppCompatActivity {

    TabLayout signUpTab;
    TabItem login1,login2,login3;
    ViewPager sliderVp;
    Fragment fragment;
    HomePageAdapter homePageAdapter;
    FrameLayout frameLayout;
    Button signupButton;
//    final int one = new Random().nextInt(3)+1;
//    int two = 4- one;
//    int three = 6- one - two;
    Random r=new Random();
    int random=r.nextInt(2)+1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_new);

        attachId();

        Toast.makeText(SignupNewActivity.this, ""+random, Toast.LENGTH_SHORT).show();

        homePageAdapter=new HomePageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,signUpTab.getTabCount(),1);
        sliderVp.setAdapter(homePageAdapter);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent=new Intent(SignupNewActivity.this,MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

        signUpTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                sliderVp.setCurrentItem(tab.getPosition());


                switch(random)
                {
                    case 3: fragment=new SignupSlider1();
                        loadFragment(fragment);
                        break;
                    case 1: fragment=new SignupSlider2();
                        loadFragment(fragment);
                        break;
                    case 2: fragment=new SignupSlider3();
                        loadFragment(fragment);
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        sliderVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(signUpTab));

    }

    void attachId()
    {
        //link tabLayout,tabitems and viewPager
        signUpTab=findViewById(R.id.login_slider_tab_layout);
        login1=findViewById(R.id.login_1);
        login2=findViewById(R.id.login_2);
        login3=findViewById(R.id.login_3);
        sliderVp=findViewById(R.id.login_view_pager);
        frameLayout=findViewById(R.id.login_frame_layout);
        signupButton=findViewById(R.id.mobile_btn);

    }

    void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.login_frame_layout,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
