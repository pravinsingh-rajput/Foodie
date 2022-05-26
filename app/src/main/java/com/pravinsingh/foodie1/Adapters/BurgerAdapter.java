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
import com.pravinsingh.foodie1.Modules.BurgerModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import foodie1.R;

public class BurgerAdapter extends RecyclerView.Adapter<BurgerAdapter.viewHolder> {

    public BurgerAdapter (ArrayList<BurgerModule> Burgerlist, Context context){
        this.Burgerlist = Burgerlist;
        this.context = context;
    }
    ArrayList<BurgerModule> Burgerlist = new ArrayList<>();
    Context context;



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_view_sample,parent,false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        BurgerModule module = Burgerlist.get(position) ;

        Picasso.get().load(module.getCVBImg()).into(holder.CVBImg);


        holder.CVBName.setText(module.getCVBName());
        holder.CVBPrice.setText(module.getCVBPrice());
        holder.CVBResturant.setText(module.getCVBResturant());
        holder.CVBPreptime.setText(module.getCVBPreptime());
        holder.CVBRating.setText(module.getCVBRating());
        holder.CVBDescription.setText(module.getCVBdescription());


        holder.CVBImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedActivity.class);

                intent.putExtra("fname",module.getCVBName());
                intent.putExtra("fimg",module.getCVBImg());
                intent.putExtra("fprice",module.getCVBPrice());
                intent.putExtra("ResturantName",module.getCVBResturant());
                intent.putExtra("preptime",module.getCVBPreptime());
                intent.putExtra("Rating",module.getCVBRating());
                intent.putExtra("fdescription",module.getCVBdescription());

                context.startActivity(intent);

            }
        });



    }


    @Override
    public int getItemCount() {
        return Burgerlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView CVBImg;
        TextView CVBName,CVBPrice,CVBResturant,CVBPreptime,CVBRating,CVBDescription;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            CVBImg = itemView.findViewById(R.id.Cfoodimg);

            CVBName = itemView.findViewById(R.id.Cfoodname);
            CVBPrice = itemView.findViewById(R.id.Cfoodprice);
            CVBResturant = itemView.findViewById(R.id.CResturantName);
            CVBPreptime = itemView.findViewById(R.id.CprepTime);
            CVBRating = itemView.findViewById(R.id.CRating);
            CVBDescription = itemView.findViewById(R.id.CFooddetail);


        }
    }


}
