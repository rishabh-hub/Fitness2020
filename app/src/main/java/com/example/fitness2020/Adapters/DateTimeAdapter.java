package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.DateModel;
import com.example.fitness2020.Models.TimeModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class DateTimeAdapter extends RecyclerView.Adapter<DateTimeAdapter.DateTimeAdapterVH> {

    Context context;
    int code;
    ArrayList<DateModel> dateModels;
    ArrayList<TimeModel> timeModels;

    public DateTimeAdapter(Context context, int code, ArrayList<DateModel> dateModels, ArrayList<TimeModel> timeModels) {
        this.context = context;
        this.code = code;
        this.dateModels = dateModels;
        this.timeModels = timeModels;
    }

    @NonNull
    @Override
    public DateTimeAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if(code==0)
//        return new DateTimeAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.,parent,false));
//        else
//            return new DateTimeAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.,parent,false));
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DateTimeAdapterVH holder, int position) {

        if (code==0)
            holder.populateDate(dateModels.get(position));
        else
            holder.populateTime(timeModels.get(position));

    }

    @Override
    public int getItemCount() {
        if (code==0)
        return dateModels.size();
        else
            return timeModels.size();
    }

    public class DateTimeAdapterVH extends RecyclerView.ViewHolder
    {
        TextView date,time;

        public DateTimeAdapterVH(@NonNull View itemView) {
            super(itemView);

            if (code==0)
            {
//                date=itemView.findViewById(R.id.);
            }
            else
            {
//                time=itemView.findViewById(R.id.);
            }

        }

        void populateDate(DateModel dateModel)
        {
            date.setText(dateModel.getDate());
        }

        void  populateTime(TimeModel timeModel)
        {
            time.setText(timeModel.getTime());
        }
    }
}
