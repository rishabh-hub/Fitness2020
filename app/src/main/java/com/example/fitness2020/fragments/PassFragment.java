package com.example.fitness2020.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.fitness2020.Adapters.FitnessFragmentFreeTrialAdapter;
import com.example.fitness2020.Adapters.FitnessVideoAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Adapters.VideosAdapter;
import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Adapters.HomePageClientAdapter;
import com.example.fitness2020.Models.ClientModel;
import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.Adapters.HomeTrendingRVAdapter;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.PopularHorizontalRvModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;

import java.util.ArrayList;

public class PassFragment extends Fragment {

    View view;
    TextView faqTv;
    TextView textView;
    RecyclerView membershipRV;
    SubscriptionCardsAdapter membershipAdapter;
    ArrayList<PackModel> packModels;

    RecyclerView clientRV;
    ArrayList<ClientModel> clients = new ArrayList<>();
    HomePageClientAdapter clientAdapter;

    RecyclerView fitnessPassRV;
    ArrayList<FitnessFragmentFreeTrialModel> fitnessPassModels ;

    RecyclerView faqRv;
    ArrayList<FaqModel> faqs;
    SubscriptionCardsAdapter faqAdapter;


    RecyclerView freeTrialRV;
    ArrayList<FitnessFragmentFreeTrialModel> fragmentFreeTrialModels;

    RecyclerView videoRV;
    ArrayList<VideoModel> videos,dailyWorkoutVideos,studioVideos,corporateVideos;
    VideosAdapter videoAdapter;

    FitnessFragmentFreeTrialAdapter fragmentFreeTrialAdapter,fitnessPassAdapter;
    Context context;
    CardView trialCard,workoutCard,validityCard;

    ArrayList<TrendingRvModel> imageModels;


    public PassFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_pass,container,false);

        attachId();

        clientRV.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
        freeTrialRV.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.HORIZONTAL,false));
        fitnessPassRV.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        videoRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        faqRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        membershipRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));



        fragmentFreeTrialModels=new ArrayList<>(3);
        fitnessPassModels = new ArrayList<>(3);
        videos = new ArrayList<>(3);
        faqs=new ArrayList<>(3);
        packModels = new ArrayList<>(3);

        addData();

        clientAdapter = new HomePageClientAdapter(clients,context);
        fragmentFreeTrialAdapter=new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,context,fitnessPassModels,1);
        fitnessPassAdapter = new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,context,fitnessPassModels,0);
        videoAdapter = new VideosAdapter(videos,dailyWorkoutVideos,studioVideos,corporateVideos,context,0);
        faqAdapter = new SubscriptionCardsAdapter(context,1,imageModels,faqs);
        membershipAdapter = new SubscriptionCardsAdapter(context,2,packModels);



        clientRV.setAdapter(clientAdapter);
        freeTrialRV.setAdapter(fragmentFreeTrialAdapter);
        fitnessPassRV.setAdapter(fitnessPassAdapter);
        videoRV.setAdapter(videoAdapter);
        faqRv.setAdapter(faqAdapter);
        membershipRV.setAdapter(membershipAdapter);


        clientAdapter.notifyDataSetChanged();
        fragmentFreeTrialAdapter.notifyDataSetChanged();
        fitnessPassAdapter.notifyDataSetChanged();
        videoAdapter.notifyDataSetChanged();
        faqAdapter.notifyDataSetChanged();
        membershipAdapter.notifyDataSetChanged();



        return view;
    }

    void addData() {

        for (int i = 0; i < 10; i++)
        {
            fragmentFreeTrialModels.add(new FitnessFragmentFreeTrialModel(R.drawable.trending_activity,"One More Rep","Mumbai,Maharashtra ,400022","Crossfit, Zumba"));

        }
        for (int i=0;i<5;i++)
        {
            fitnessPassModels.add(new FitnessFragmentFreeTrialModel(R.drawable.trending_activity,"Gym name","Gym Category","Crossfit, Zumba"));
            videos.add(new VideoModel(R.mipmap.ic_launcher));
            faqs.add(new FaqModel("Q. Some Question about MemberShip?","A. Corresponding answer about MemberShip"));

        }
        for (int i = 0;i<10;i++)
            clients.add(new ClientModel(R.drawable.ic_person_outline_black_24dp));
        for (int i=0;i<6;i++)
        {
            packModels.add(new PackModel("Unlimited Workouts",99));
        }
    }

    void attachId()
    {
        freeTrialRV=view.findViewById(R.id.pass_fragment_fitness_pass_rv);
        fitnessPassRV = view.findViewById(R.id.fitness_pass_banner2_rv);
        videoRV = view.findViewById(R.id.fitness_pass_video_rv);
        trialCard=view.findViewById(R.id.trial_card);
        membershipRV=view.findViewById(R.id.pass_membership_rv);
        faqRv =view.findViewById(R.id.fitness_pass_faq_rv);
        faqTv=view.findViewById(R.id.fitness_pass_faq_rv_heading);
        clientRV = view.findViewById(R.id.fitness_at_work_clients_rv);
    }
}
