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

import com.pravinsingh.foodie1.Detailed.DetailedActivity;
import com.pravinsingh.foodie1.Modules.Mostorders;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import foodie1.R;

public class MostorderAdapter extends RecyclerView.Adapter<MostorderAdapter.Mostorderviewholder> {

    public MostorderAdapter(ArrayList<Mostorders> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    ArrayList<Mostorders> list2 = new ArrayList<Mostorders>();
    Context context;


    @NonNull
    @Override
    public Mostorderviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mostorder_sample, parent, false);
        return new MostorderAdapter.Mostorderviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mostorderviewholder holder, int position) {

        Mostorders mostorders = list2.get(position);

        Picasso.get().
                load(mostorders.getmImg())
                .into(holder.mimg);

        holder.mname.setText(mostorders.getmName());
        holder.mprice.setText(mostorders.getmPrice());
        holder.mResturant.setText(mostorders.getmResturant());
        holder.preptime.setText(mostorders.getPreptime());
        holder.Rating.setText(mostorders.getRating());
        holder.fdescription.setText(mostorders.getFdescription());



        holder.mimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedActivity.class);

                intent.putExtra("fname",mostorders.getmName());
                intent.putExtra("fimg",mostorders.getmImg());
                intent.putExtra("fprice",mostorders.getmPrice());
                intent.putExtra("ResturantName",mostorders.getmResturant());
                intent.putExtra("preptime",mostorders.getPreptime());
                intent.putExtra("Rating",mostorders.getRating());
                intent.putExtra("fdescription",mostorders.getFdescription());


                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class Mostorderviewholder extends RecyclerView.ViewHolder{

        ImageView mimg;
        TextView mname,mprice,mResturant,preptime,Rating,fdescription;

        public Mostorderviewholder(@NonNull View itemView) {
            super(itemView);

            mimg = itemView.findViewById(R.id.Mfoodimg);
            mname = itemView.findViewById(R.id.Mfoodname);
            mprice = itemView.findViewById(R.id.Mfoodprice);
            mResturant = itemView.findViewById(R.id.MResturantName);
            preptime = itemView.findViewById(R.id.MprepTime);
            Rating = itemView.findViewById(R.id.MRating);
            fdescription = itemView.findViewById(R.id.MFooddetail);


        }
    }

}
