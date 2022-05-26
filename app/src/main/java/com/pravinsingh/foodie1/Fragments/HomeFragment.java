package com.pravinsingh.foodie1.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pravinsingh.foodie1.Adapters.CategoriesAdapter;
import com.pravinsingh.foodie1.Adapters.MostorderAdapter;
import com.pravinsingh.foodie1.Modules.CategoriesModules;
import com.pravinsingh.foodie1.Modules.Mostorders;
import com.pravinsingh.foodie1.Modules.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import foodie1.R;
import foodie1.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    RecyclerView recyclerViewcat, recyclerViewpop;
    ArrayList<CategoriesModules> list1 ;
    ArrayList<Mostorders> list2 ;
    FragmentHomeBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    TextView name;
    ImageView profile;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            

        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        name = view.findViewById(R.id.name);
        profile = view.findViewById(R.id.profile);

        database.getReference().child("Users").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    User user = snapshot.getValue(User.class);
                    Picasso.get()
                            .load(user.getProfilepic())
                            .placeholder(R.drawable.profile)
                            .into(profile);
                    name.setText(user.getUsername());
            }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        recyclerViewcat = view.findViewById(R.id.catRecView);
        ArrayList<CategoriesModules> list1 = new ArrayList<>();
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(list1,getContext());
        recyclerViewcat.setAdapter(categoriesAdapter);

        list1.add(new CategoriesModules(R.drawable.cat_pizza, "Pizza"));
        list1.add(new CategoriesModules(R.drawable.cat_burger, "Burger"));
        list1.add(new CategoriesModules(R.drawable.cat_fries, "Fries"));
        list1.add(new CategoriesModules(R.drawable.cat_drink, "Drink"));
        list1.add(new CategoriesModules(R.drawable.cat_cake, "Cake"));
        list1.add(new CategoriesModules(R.drawable.cat_panner, "Veg"));
        list1.add(new CategoriesModules(R.drawable.cat_chiken, "Non-Veg"));



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager
                (getContext(),LinearLayoutManager.HORIZONTAL,false );
        recyclerViewcat.setLayoutManager(linearLayoutManager);



        recyclerViewpop = view.findViewById(R.id.popRecView);
        ArrayList<Mostorders> list2 = new ArrayList<>();
        MostorderAdapter mostorderAdapter = new MostorderAdapter(list2,getContext());
        recyclerViewpop.setAdapter(mostorderAdapter);


        FirebaseDatabase.getInstance().getReference().child("Most Order").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Mostorders mostorders = snapshot1.getValue(Mostorders.class);
                    list2.add(mostorders);
                }
                mostorderAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager
                (getContext());
        recyclerViewpop.setLayoutManager(linearLayoutManager2);

        recyclerViewpop.setNestedScrollingEnabled(false);

        return view;




    }
}

