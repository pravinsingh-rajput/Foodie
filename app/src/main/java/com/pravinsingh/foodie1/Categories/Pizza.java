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
import com.pravinsingh.foodie1.Adapters.PizzaaAdapter;
import com.pravinsingh.foodie1.Modules.PizzaModule;

import java.util.ArrayList;

import foodie1.databinding.ActivityPizzaBinding;

public class Pizza extends AppCompatActivity {

    ActivityPizzaBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPizzaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );


        ProgressDialog progressDialog;

        ArrayList<PizzaModule> Pizzalist = new ArrayList<>();
        PizzaaAdapter pizzaaAdapter = new PizzaaAdapter(Pizzalist,this);
        binding.pizzarecylerview.setAdapter(pizzaaAdapter);


        FirebaseDatabase.getInstance().getReference().child("CategoryPizza").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Pizzalist.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    PizzaModule pizzaModule = snapshot1.getValue(PizzaModule.class);
                    Pizzalist.add(pizzaModule);
                }
                pizzaaAdapter.notifyDataSetChanged();

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        LinearLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        binding.pizzarecylerview.setLayoutManager(gridLayoutManager);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.pizzarecylerview.setLayoutManager(linearLayoutManager);












    }
}