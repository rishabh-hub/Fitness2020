package com.example.fitness2020;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness2020.fragments.EventsFragment;
import com.example.fitness2020.fragments.HomeFitnessatWorkTab;
import com.example.fitness2020.fragments.HomeFragment;
import com.example.fitness2020.fragments.PassFragment;
import com.example.fitness2020.fragments.VouchersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class MainActivity extends AppCompatActivity{

    FrameLayout frameLayout;
    ImageView userImage;
    DrawerLayout drawerLayout;
    public BottomNavigationView bottomNavigationView;
    TextView location;
    private static  MainActivity instance;

    @Override
    public void onBackPressed() {
        int seletedItemId = bottomNavigationView.getSelectedItemId();
        if (R.id.home != seletedItemId) {
            setHomeItem(MainActivity.this);
        } else {
            super.onBackPressed();
        }
    }
    public  void setHomeItem(Activity activity) {
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        instance=this;
        attachId();

        if (getIntent().getIntExtra("code",0)==1)

        {
            loadFragment(new VouchersFragment());
            bottomNavigationView.setSelectedItemId(R.id.vouchers);
        }
        else
        loadFragment(new HomeFragment());//needs to be configured so that once user logins only then this fragment is loaded

        bottomNavigationView.setItemIconTintList(null);

        Intent intent = new Intent(this, GymActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        //we can pass only bitmap image in bigPicture
        //setAutoCancel removes notification when it is clicked

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.brand_video_dummy);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"Fitness 2020")
                .setSmallIcon(R.mipmap.ic_launcher_round).setContentTitle("Title")
                .setContentText("Hello World").setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap)).setContentIntent(pendingIntent).setAutoCancel(true);

        createNotificationChannel();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        int notificationId=12345;
// notificationId is a unique int for each notification that you must define
        notificationManager.notify(notificationId, builder.build());


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

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationIntent=new Intent(MainActivity.this,LocationActivity.class);
                startActivity(locationIntent);
            }
        });

    }

    void attachId()
    {
        frameLayout=findViewById(R.id.frame_layout);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        drawerLayout=findViewById(R.id.drawer);
        location=findViewById(R.id.location_txt);
        userImage=findViewById(R.id.user_image_imgvw);
    }



    public  void drawerClose(MenuItem menuItem)
    {
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }

    public void openProfile(MenuItem menuItem)
    {
        Intent profileIntent=new Intent(MainActivity.this,ProfileActivity.class);
        drawerLayout.closeDrawer(Gravity.RIGHT);
        startActivity(profileIntent);
    }

    public void openBookings(MenuItem menuItem)
    {
        Intent bookingsIntent = new Intent(MainActivity.this,BookingsActivity.class);
        drawerLayout.closeDrawer(Gravity.RIGHT);
        startActivity(bookingsIntent);
    }




    public void loadFragment(Fragment fragment)
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

    public static MainActivity getInstance(){
        return instance;
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Fitness";
            String description = "Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Fitness 2020", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
