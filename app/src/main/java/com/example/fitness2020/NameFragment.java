package com.example.fitness2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class NameFragment extends Fragment {

    View view;
    EditText firstName,lastName;
    Button nextButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_login_name,container,false);

        attachId();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((lastName.getText().toString().isEmpty())||(firstName.getText().toString().isEmpty())) {

                    if (firstName.getText().toString().equals(""))
                    {
                        firstName.setError("Required");
                    }
                    if (lastName.getText().toString().equals(""))
                    {
                        lastName.setError("Required");
                    }
                }
                else {
                    Intent mainIntent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(mainIntent);
                }
            }
        });

        return view;
    }

    private void attachId() {
        firstName=view.findViewById(R.id.first_name_et);
        lastName=view.findViewById(R.id.last_name_et);
        nextButton=view.findViewById(R.id.submit_name_button);

    }
}
