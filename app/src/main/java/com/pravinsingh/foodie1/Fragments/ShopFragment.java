package com.pravinsingh.foodie1.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pravinsingh.foodie1.Adapters.ResturantAdapter;
import com.pravinsingh.foodie1.Modules.ResturantModel;
import com.pravinsingh.foodie1.Veggies;

import java.util.ArrayList;

import foodie1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
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

    ViewFlipper viewFlipper;
    RecyclerView RecView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        int imgArray[] = {R.drawable.veggies1, R.drawable.veggies2,R.drawable.veggies3};
        viewFlipper = view.findViewById(R.id.imageflipper);

        for (int i=0;i < imgArray.length; i++)
            showimage(imgArray[i]);


        RecView = view.findViewById(R.id.ResREC);
        ArrayList<ResturantModel> Reslist = new ArrayList<>();
        ResturantAdapter resturantAdapter = new ResturantAdapter(Reslist,getContext());
        RecView.setAdapter(resturantAdapter);

        FirebaseDatabase.getInstance().getReference().child("Resturant").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Reslist.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    ResturantModel resturantModel = snapshot1.getValue(ResturantModel.class);
                    Reslist.add(resturantModel);
                }
                resturantAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager
//                (getContext());
//        RecView.setLayoutManager(linearLayoutManager2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        RecView.setLayoutManager(gridLayoutManager);

        RecView.setNestedScrollingEnabled(false);


        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Veggies.class );

                getContext().startActivity(intent);

            }
        });




        return view;

    }

    public void showimage(int img){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(img);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);


    }

}


