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
import com.pravinsingh.foodie1.Modules.PizzaModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import foodie1.R;

public class PizzaaAdapter extends RecyclerView.Adapter<PizzaaAdapter.viewHolder> {

    public PizzaaAdapter (ArrayList<PizzaModule> Pizzalist, Context context){
        this.Pizzalist = Pizzalist;
        this.context = context;
    }
    ArrayList<PizzaModule> Pizzalist = new ArrayList<>();
    Context context;



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_view_sample,parent,false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        PizzaModule module = Pizzalist.get(position) ;

        Picasso.get().load(module.getCVPImg()).into(holder.CVPImg);


        holder.CVPName.setText(module.getCVPName());
        holder.CVPPrice.setText(module.getCVPPrice());
        holder.CVPResturant.setText(module.getCVPResturant());
        holder.CVPPreptime.setText(module.getCVPPreptime());
        holder.CVPRating.setText(module.getCVPRating());
        holder.CVPDescription.setText(module.getCVPdescription());


        holder.CVPImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedActivity.class);

                intent.putExtra("fname",module.getCVPName());
                intent.putExtra("fimg",module.getCVPImg());
                intent.putExtra("fprice",module.getCVPPrice());
                intent.putExtra("ResturantName",module.getCVPResturant());
                intent.putExtra("preptime",module.getCVPPreptime());
                intent.putExtra("Rating",module.getCVPRating());
                intent.putExtra("fdescription",module.getCVPdescription());

                context.startActivity(intent);

            }
        });



    }


    @Override
    public int getItemCount() {
        return Pizzalist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView CVPImg;
        TextView CVPName,CVPPrice,CVPResturant,CVPPreptime,CVPRating,CVPDescription;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            CVPImg = itemView.findViewById(R.id.Cfoodimg);

            CVPName = itemView.findViewById(R.id.Cfoodname);
            CVPPrice = itemView.findViewById(R.id.Cfoodprice);
            CVPResturant = itemView.findViewById(R.id.CResturantName);
            CVPPreptime = itemView.findViewById(R.id.CprepTime);
            CVPRating = itemView.findViewById(R.id.CRating);
            CVPDescription = itemView.findViewById(R.id.CFooddetail);


        }
    }


}
