package com.pravinsingh.foodie1.Categories;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pravinsingh.foodie1.Adapters.BurgerAdapter;
import com.pravinsingh.foodie1.Modules.BurgerModule;

import java.util.ArrayList;

import foodie1.databinding.ActivityBurgerBinding;

public class Burger extends AppCompatActivity {

    ActivityBurgerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBurgerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );


        ProgressDialog progressDialog;

        ArrayList<BurgerModule> Burgerlist = new ArrayList<>();
        BurgerAdapter burgerAdapter = new BurgerAdapter(Burgerlist,this);
        binding.burgerrecyle.setAdapter(burgerAdapter);


        FirebaseDatabase.getInstance().getReference().child("CategoryBurger").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Burgerlist.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    BurgerModule burgerModule = snapshot1.getValue(BurgerModule.class);
                    Burgerlist.add(burgerModule);
                }
                burgerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        binding.burgerrecyle.setLayoutManager(gridLayoutManager);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.burgerrecyle.setLayoutManager(linearLayoutManager);






    }
}