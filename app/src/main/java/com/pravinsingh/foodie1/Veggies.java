package com.pravinsingh.foodie1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pravinsingh.foodie1.Adapters.VeggiesAdapter;
import com.pravinsingh.foodie1.Modules.VeggiesModule;

import java.util.ArrayList;

import foodie1.R;

public class Veggies extends AppCompatActivity {

    ViewFlipper viewFlipper;
    FirebaseDatabase database;
    DatabaseReference reference;
    RecyclerView veggiesview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veggies);

        database = FirebaseDatabase.getInstance();

        veggiesview = findViewById(R.id.veggiesview);


        getSupportActionBar().hide();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        int imgArray[] = {R.drawable.veggies1, R.drawable.veggies2, R.drawable.veggies3};
        viewFlipper = findViewById(R.id.imageflipper);


        for (int i = 0; i < imgArray.length; i++)
            showimage(imgArray[i]);

        ArrayList<VeggiesModule> Veggislist = new ArrayList<>();
        VeggiesAdapter veggiesAdapter = new VeggiesAdapter(Veggislist,this);
        veggiesview.setAdapter(veggiesAdapter);

        FirebaseDatabase.getInstance().getReference().child("Veggies").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Veggislist.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    VeggiesModule veggiesModule = snapshot1.getValue(VeggiesModule.class);
                    Veggislist.add(veggiesModule);
                }
                veggiesAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        veggiesview.setLayoutManager(gridLayoutManager);

        veggiesview.setNestedScrollingEnabled(false);


//        tabLayout = findViewById(R.id.VeggiesTab);
//        viewPager = findViewById(R.id.VeggiesPager);
//
//        tabLayout.setupWithViewPager(viewPager);
//
//        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        vpAdapter.addfragment(new veggie(),"Veggies");
//
//        viewPager.setAdapter(vpAdapter);








    }


    public void showimage(int img) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(img);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);


    }


}