package com.pravinsingh.foodie1.Detailed;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.pravinsingh.foodie1.Adapters.VPAdapter;
import com.pravinsingh.foodie1.Fragments.FragmentDetails;
import com.pravinsingh.foodie1.Fragments.FragmentMenu;
import com.squareup.picasso.Picasso;

import foodie1.R;

public class ResturantsDetails extends AppCompatActivity {


    ImageView Resturantimg;
    TextView Resturantname,Resrating,Rdetails;
    String ResturantName,ResRating,ResImage,ResDetail;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturants_details);

        getSupportActionBar().hide();


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );


        ResImage = getIntent().getStringExtra("ResImg");
        ResturantName=getIntent().getStringExtra("ResNam");
        ResRating=getIntent().getStringExtra("ResRat");
        ResDetail = getIntent().getStringExtra("ResDetail");


        Resturantimg = findViewById(R.id.Resimg);
        Resturantname = findViewById(R.id.ResName);
        Resrating = findViewById(R.id.ResRating);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        Rdetails = findViewById(R.id.Rdetails);


        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addfragment(new FragmentDetails(),"Detail");
        vpAdapter.addfragment(new FragmentMenu(),"Menu");

        viewPager.setAdapter(vpAdapter);





        try {
            Picasso.get().load(ResImage).into((ImageView) Resturantimg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Resturantname.setText(ResturantName);
        Resrating.setText(ResRating);
        Rdetails.setText(ResDetail);


    }
}