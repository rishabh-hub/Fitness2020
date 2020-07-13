package com.example.fitness2020.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitness2020.Adapters.FitnessFragmentFreeTrialAdapter;
import com.example.fitness2020.Adapters.NewCorrectionAdapter;
import com.example.fitness2020.Adapters.SubscriptionCardsAdapter;
import com.example.fitness2020.Adapters.VideosAdapter;
import com.example.fitness2020.Models.FaqModel;
import com.example.fitness2020.Adapters.HomePageClientAdapter;
import com.example.fitness2020.Models.ClientModel;
import com.example.fitness2020.Models.FitnessFragmentFreeTrialModel;
import com.example.fitness2020.Models.PackModel;
import com.example.fitness2020.Models.TopTrainersModel;
import com.example.fitness2020.Models.TrendingRvModel;
import com.example.fitness2020.Models.VideoModel;
import com.example.fitness2020.R;
import com.example.fitness2020.TopFitnessCentres;
import com.example.fitness2020.TrialCardActivity;
import com.example.fitness2020.VideosActivity;
import com.example.fitness2020.WebinarTabActivity;

import java.util.ArrayList;

public class PassFragment extends Fragment {

    View view;
    TextView faqTv;
    TextView textView;
    RecyclerView membershipRV;
    SubscriptionCardsAdapter membershipAdapter;
    ArrayList<PackModel> packModels;
    NewCorrectionAdapter workoutsForDayAdapter;
    ArrayList <TrendingRvModel> workoutFotDayModels,trendingRvModels;
    RecyclerView workoutForDayRv;
    TextView workoutForDayViewMoreButton;

    RecyclerView clientRV;
    ArrayList<ClientModel> clients = new ArrayList<>();
    HomePageClientAdapter clientAdapter;

    RecyclerView topTrainerRv;
    ArrayList<TopTrainersModel> topTrainerModels;

    RecyclerView faqRv;
    ArrayList<FaqModel> faqs;
    SubscriptionCardsAdapter faqAdapter;


    RecyclerView topfitnessRv;
    ArrayList<FitnessFragmentFreeTrialModel> fragmentFreeTrialModels;

    RecyclerView liveWorkoutsRv;
    ArrayList<FitnessFragmentFreeTrialModel> liveWorkoutModels;

    RecyclerView videoRV;
    ArrayList<VideoModel> videos,dailyWorkoutVideos,studioVideos,corporateVideos,membership;
    VideosAdapter videoAdapter;

    FitnessFragmentFreeTrialAdapter fragmentFreeTrialAdapter, topTrainerAdapter,liveWorkoutsAdapter;
    Context context;
    CardView trialCard,workoutCard,validityCard;

    ArrayList<TrendingRvModel> imageModels;
    TextView liveWorkoutViewMore;


    Button buyFitnessPasssButton;
    TextView topFitnessViewMore;

    public PassFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_pass,container,false);

        attachId();

        clientRV.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false));
        topfitnessRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        topTrainerRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        videoRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        faqRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        membershipRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        liveWorkoutsRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
        workoutForDayRv.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));

        fragmentFreeTrialModels=new ArrayList<>(3);
        topTrainerModels = new ArrayList<>(3);
        videos = new ArrayList<>(3);
        faqs=new ArrayList<>(3);
        packModels = new ArrayList<>(3);
        liveWorkoutModels=new ArrayList<>(3);
        workoutFotDayModels=new ArrayList<>(3);

        addData();

        clientAdapter = new HomePageClientAdapter(clients,context);
        fragmentFreeTrialAdapter=new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,liveWorkoutModels, topTrainerModels,context,1);
        topTrainerAdapter = new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,liveWorkoutModels, topTrainerModels,context,2);
        videoAdapter = new VideosAdapter(videos,dailyWorkoutVideos,studioVideos,corporateVideos,membership,context,0);
        faqAdapter = new SubscriptionCardsAdapter(context,1,imageModels,faqs);
        membershipAdapter = new SubscriptionCardsAdapter(context,2,packModels);
        liveWorkoutsAdapter=new FitnessFragmentFreeTrialAdapter(fragmentFreeTrialModels,liveWorkoutModels, topTrainerModels,context,0);
        workoutsForDayAdapter=new NewCorrectionAdapter(0,workoutFotDayModels,trendingRvModels);

        clientRV.setAdapter(clientAdapter);
        topfitnessRv.setAdapter(fragmentFreeTrialAdapter);
        topTrainerRv.setAdapter(topTrainerAdapter);
        videoRV.setAdapter(videoAdapter);
        faqRv.setAdapter(faqAdapter);
        membershipRV.setAdapter(membershipAdapter);
        liveWorkoutsRv.setAdapter(liveWorkoutsAdapter);
        workoutForDayRv.setAdapter(workoutsForDayAdapter);

        clientAdapter.notifyDataSetChanged();
        fragmentFreeTrialAdapter.notifyDataSetChanged();
        topTrainerAdapter.notifyDataSetChanged();
        videoAdapter.notifyDataSetChanged();
        faqAdapter.notifyDataSetChanged();
        membershipAdapter.notifyDataSetChanged();
        liveWorkoutsAdapter.notifyDataSetChanged();
        workoutsForDayAdapter.notifyDataSetChanged();

        liveWorkoutViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webinarIntent=new Intent(view.getContext(), WebinarTabActivity.class);
                startActivity(webinarIntent);
            }
        });

        topFitnessViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topFitnessIntent=new Intent(view.getContext(), TopFitnessCentres.class);
                startActivity(topFitnessIntent);
            }
        });


        workoutForDayViewMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videosIntent=new Intent(getContext(), VideosActivity.class);
                startActivity(videosIntent);
            }
        });
        return view;
    }

    void addData() {

        for (int i = 0; i < 10; i++)
        {
            fragmentFreeTrialModels.add(new FitnessFragmentFreeTrialModel(R.drawable.trending_activity,"One More Rep","Mumbai,Maharashtra ,400022","Crossfit, Zumba","4.5"));
            liveWorkoutModels.add(new FitnessFragmentFreeTrialModel(R.drawable.trending_activity,"One More Rep","Mumbai,Maharashtra ,400022","Crossfit, Zumba","4.5"));
        }
        for (int i=0;i<5;i++)
        {
            workoutFotDayModels.add(new TrendingRvModel(R.drawable.trending_activity));
            topTrainerModels.add(new TopTrainersModel(R.drawable.webinar,"Paari"));
            videos.add(new VideoModel(R.drawable.gym_video_dummy));
            faqs.add(new FaqModel("Q. Some Question about MemberShip?","A. Corresponding answer about MemberShip"));
        }
        for (int i = 0;i<10;i++)
            clients.add(new ClientModel(R.drawable.ic_person_outline_black_24dp));
        for (int i=0;i<6;i++)
        {
            packModels.add(new PackModel("Unlimited Workouts",4000,2499,"Get unlimited webinar sessions"));
        }
    }

    void attachId()
    {
        topfitnessRv =view.findViewById(R.id.pass_fragment_top_fitness_rv);
        topTrainerRv = view.findViewById(R.id.fitness_pass_banner2_rv);
        videoRV = view.findViewById(R.id.fitness_pass_video_rv);
        trialCard=view.findViewById(R.id.trial_card);
        membershipRV=view.findViewById(R.id.pass_membership_rv);
        faqRv =view.findViewById(R.id.fitness_pass_faq_rv);
        faqTv=view.findViewById(R.id.fitness_pass_faq_rv_heading);
        clientRV = view.findViewById(R.id.fitness_at_work_clients_rv);
        liveWorkoutsRv=view.findViewById(R.id.pass_fragment_live_workout_rv);
        liveWorkoutViewMore=view.findViewById(R.id.live_workout_rv_more_btn);
        topFitnessViewMore = view.findViewById(R.id.top_fitness_rv_more_btn);
        workoutForDayRv=view.findViewById(R.id.pass_trending_rv);
        workoutForDayViewMoreButton=view.findViewById(R.id.pass_buzzing_viewmore_btn);
    }
}
