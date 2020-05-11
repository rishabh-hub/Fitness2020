package com.example.fitness2020.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitness2020.R;

import org.w3c.dom.Text;

public class VouchersFragment extends Fragment {
    View view;
    TextView textView;
    public VouchersFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_vouchers,container,false);
        textView=view.findViewById(R.id.vouchers_tv);

        return view;
    }
}
