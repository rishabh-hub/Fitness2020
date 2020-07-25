package com.example.fitness2020;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.ActivityAdapter;
import com.example.fitness2020.Models.ActivityModel;

import java.util.ArrayList;

public class ActivityDialog extends Dialog {

    RecyclerView activityRv;
    ArrayList<ActivityModel> activityModels,activityModels1;
    ActivityAdapter activityAdapter;

    public ActivityDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_filter_dialog_layout);

        attachId();

        activityRv.setLayoutManager(new GridLayoutManager(getContext(),4));

        activityModels=new ArrayList<>(3);

        addData();

        activityAdapter=new ActivityAdapter(activityModels,activityModels1,0);

        activityRv.setAdapter(activityAdapter);

        activityAdapter.notifyDataSetChanged();
    }

    private void addData() {
        for (int i=0;i<9;i++)
        activityModels.add(new ActivityModel("Zumba",R.drawable.ic_rhythmic_gymnastics));
    }

    private void attachId() {
        activityRv=findViewById(R.id.activity_filter_dialog_rv);
    }


}
