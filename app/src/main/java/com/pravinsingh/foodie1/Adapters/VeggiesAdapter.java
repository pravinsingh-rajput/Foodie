package com.pravinsingh.foodie1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.pravinsingh.foodie1.Detailed.DetailedActivity;
import com.pravinsingh.foodie1.Modules.VeggiesModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import foodie1.R;

public class VeggiesAdapter extends RecyclerView.Adapter<VeggiesAdapter.VeggiesViewHolder> {

    int Qty = 1;
    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseStorage storage;
    DatabaseReference reference;



    public VeggiesAdapter(ArrayList<VeggiesModule> Veggieslist, Context context) {
        this.Veggieslist = Veggieslist;
        this.context = context;
    }

    ArrayList<VeggiesModule> Veggieslist = new ArrayList<>();
    Context context;


    @NonNull
    @Override
    public VeggiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         View view = LayoutInflater.from(context).inflate(R.layout.veggiessample,parent,false);
        return new VeggiesAdapter.VeggiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeggiesViewHolder holder, int position) {

        VeggiesModule veggiesModule = Veggieslist.get(position);

        Picasso.get().load(veggiesModule.getVeggieImg()).into(holder.VeggieImg);
        holder.VeggieName.setText(veggiesModule.getVeggieName());


        holder.VeggieImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedActivity.class);

                intent.putExtra("fname", veggiesModule.getVeggieName());
                intent.putExtra("fimg", veggiesModule.getVeggieImg());
                intent.putExtra("fprice", veggiesModule.getVeggiePrice());
//                intent.putExtra("ResturantName",module.getCVPResturant());
//                intent.putExtra("preptime",module.getCVPPreptime());
//                intent.putExtra("Rating",module.getCVPRating());
//                intent.putExtra("fdescription",module.getCVPdescription());

                context.startActivity(intent);



            }
        });


    }

    @Override
    public int getItemCount() {
        return Veggieslist.size();
    }

    public class VeggiesViewHolder extends RecyclerView.ViewHolder {
        TextView VeggieName,VeggiePrice;
        ImageView VeggieImg;

        public VeggiesViewHolder(@NonNull View itemView) {
            super(itemView);
            VeggieName = itemView.findViewById(R.id.VeggieName);
            VeggieImg = itemView.findViewById(R.id.VeggieImg);
            VeggiePrice = itemView.findViewById(R.id.veggieprice);



        }
    }

}
