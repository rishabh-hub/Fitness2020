package com.example.fitness2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class SubscriptionCardsAdapter extends RecyclerView.Adapter<SubscriptionCardsAdapter.SubscriptionCardsAdapterVH> {

    Context context;
    int code;
    ArrayList<TrendingRvModel> imageModels;
    ArrayList<FaqModel> faqs;
    ArrayList<PackModel> packModels;
    //add your arraylist of type whatever model class


    public SubscriptionCardsAdapter(Context context, int code, ArrayList<TrendingRvModel> imageModels,ArrayList<FaqModel> faqModels) {
        this.context = context;
        this.code = code;
        this.imageModels = imageModels;
        this.faqs = faqModels;
    }

    public SubscriptionCardsAdapter(Context context, int code, ArrayList<PackModel> packModels) {
        this.context = context;
        this.code = code;
        this.packModels = packModels;
    }

//delete this constructor and remake one after adding the global variables

    @NonNull
    @Override
    public SubscriptionCardsAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//write if else block
        if(code==1)
            return new SubscriptionCardsAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_item,parent,false));
        else
            return new SubscriptionCardsAdapterVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.trialcard_imagerv_xml,parent,false));

        //replace the above with else if(code==0)

        //add the layout file in inflator
        //else
          //  return new SubscriptionCardsAdapterVH(LayoutInflater.from(parent.getContext()).inflate(,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionCardsAdapterVH holder, int position) {
//write if else block
        if(code==1)
            holder.populatefaq(faqs.get(position));
        else if (code==0)
            holder.populate(imageModels.get(position));
        else
            holder.populatePack(packModels.get(position));

    }

    @Override
    public int getItemCount() {
        //write if else block
        if (code == 1)
            return faqs.size();
        else if (code==0)
            return imageModels.size();
        else
            return packModels.size();
    }

    public class SubscriptionCardsAdapterVH extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        //define your data types
        TextView question,answer;
        TextView packName,packPrice;

        public SubscriptionCardsAdapterVH(@NonNull View itemView) {
            super(itemView);
            //write if else block to link ids wrt the corresponding codes received
            if (code==1){
                question = itemView.findViewById(R.id.trial_card_faq_question);
                answer = itemView.findViewById(R.id.trial_card_faq_answer);
            }
                imageView=itemView.findViewById(R.id.rv_item_trailcard_imgvw);

        }
      //make a separate populate func which receives your class type object as arguments

        void populate(TrendingRvModel imageModel)
        {
            imageView.setImageResource(imageModel.getImageUrl());
        }

        public void populatefaq(FaqModel faqModel) {
            question.setText(faqModel.getQuestion());
            answer.setText(faqModel.getAnswer());
        }

        public void populatePack(PackModel packModel)
        {
            packName.setText(packModel.getPackName());
            packPrice.setText(packModel.getPackPrice());
        }
    }
}
