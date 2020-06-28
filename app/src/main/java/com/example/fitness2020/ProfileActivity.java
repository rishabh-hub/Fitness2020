package com.example.fitness2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    ImageView backButton,profilePhoto;
    TextView logoutButton;
    EditText emailId,phoneNo,profileName,anniversary,dateOfBirth,age;
    Spinner gender;
    Button updateButton;
    Calendar calendar=Calendar.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        attachId();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logout of the current user account
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update the details and return to the previous screen

                Toast.makeText(ProfileActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        final DatePickerDialog.OnDateSetListener aniversary = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel1();
            }

        };

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(ProfileActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        anniversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ProfileActivity.this, aniversary, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        populateGenderSpinner();
        gender.setOnItemSelectedListener(this);

//        also check how to disable check on the other gender if one gender is selected

    }



    void attachId()
    {
        backButton=findViewById(R.id.profile_page_back_btn);
        logoutButton=findViewById(R.id.profile_page_logout_tv);
        emailId=findViewById(R.id.profile_page_email_et);
        phoneNo=findViewById(R.id.profile_page_mobile_et);
        profileName=findViewById(R.id.profile_page_name_et);
        anniversary=findViewById(R.id.profile_page_anniversary_et);
        dateOfBirth=findViewById(R.id.profile_page_bday_et);
        age=findViewById(R.id.profile_page_age_et);
        gender=findViewById(R.id.gender_spinner);
        updateButton=findViewById(R.id.profile_update_button);
        profilePhoto = findViewById(R.id.profile_page_photo);
    }
    private void updateLabel1() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        anniversary.setText(sdf.format(calendar.getTime()));
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateOfBirth.setText(sdf.format(calendar.getTime()));
    }

    void populateGenderSpinner()
    {
        ArrayList<String> genderData=new ArrayList<>();
        genderData.add("Male");
        genderData.add("Female");
        genderData.add("Custom");
        genderData.add("Prefer not to say");
        ArrayAdapter<String> genderAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,genderData);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId()==R.id.gender_spinner)
        {
            Toast.makeText(this, "Selected "+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
