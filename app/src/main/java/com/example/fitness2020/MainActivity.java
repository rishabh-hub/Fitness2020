package com.example.fitness2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fitness2020.fragments.EventsFragment;
import com.example.fitness2020.fragments.HomeFitnessatWorkTab;
import com.example.fitness2020.fragments.HomeFragment;
import com.example.fitness2020.fragments.PassFragment;
import com.example.fitness2020.fragments.VouchersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    FrameLayout frameLayout;
    ImageView userImage;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    Spinner locationSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachId();
        loadFragment(new HomeFragment());//needs to be configured so that once user logins only then this fragment is loaded

        populateLocationSpinner();
        locationSpinner.setOnItemSelectedListener(this);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.home:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.fitness_pass:
                        loadFragment(new PassFragment());
                        return true;
                    case R.id.vouchers:
                        loadFragment(new VouchersFragment());
                        return true;
                    case R.id.events:
                        loadFragment(new HomeFitnessatWorkTab());
                        return true;
                }

                return false;
            }
        });
    }

    void attachId()
    {
        frameLayout=findViewById(R.id.frame_layout);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        drawerLayout=findViewById(R.id.drawer);
        locationSpinner=findViewById(R.id.location_spinner);
        userImage=findViewById(R.id.user_image_imgvw);
    }

    void populateLocationSpinner()
    {
        ArrayList<String> locationData=new ArrayList<>();
        locationData.add("Location 1");
        locationData.add("Location 2");
        ArrayAdapter<String> locationAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,locationData);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);
    }

    public  void drawerClose(MenuItem menuItem)
    {
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }

    public void openProfile(MenuItem menuItem)
    {
        Intent profileIntent=new Intent(MainActivity.this,ProfileActivity.class);
        startActivity(profileIntent);
    }

    public void openBookings(MenuItem menuItem)
    {
        Intent bookingsIntent = new Intent(MainActivity.this,BookingsActivity.class);
        startActivity(bookingsIntent);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.location_spinner)
        {
            Toast.makeText(this, "Selected "+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void goMembership(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,MembershipActivity.class);
        startActivity(intent);
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }

    public void goRefEarn(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,ReferEarn.class);
        startActivity(intent);
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }

    public void changePassword(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,ChangePasswordActivity.class);
        startActivity(intent);
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }
}
