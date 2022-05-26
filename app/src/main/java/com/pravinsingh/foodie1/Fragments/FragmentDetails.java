package com.pravinsingh.foodie1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import foodie1.R;


public class FragmentDetails extends Fragment {

    TextView Resturantname, Rdetails;
    String ResturantName,RDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);


        ResturantName=getActivity().getIntent().getStringExtra("ResNam");
        RDetails = getActivity().getIntent().getStringExtra("ResDetail");

        Resturantname = view.findViewById(R.id.ResName);
        Rdetails = view.findViewById(R.id.Resdetails);

        Resturantname.setText(ResturantName);
        Rdetails.setText(RDetails);




        return view;

    }
}