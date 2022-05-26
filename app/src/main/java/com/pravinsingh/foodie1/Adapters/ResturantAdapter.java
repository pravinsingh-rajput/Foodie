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

import com.pravinsingh.foodie1.Detailed.ResturantsDetails;
import com.pravinsingh.foodie1.Modules.ResturantModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import foodie1.R;

public class ResturantAdapter extends RecyclerView.Adapter<ResturantAdapter.ResturantViewHolder>{

    public ResturantAdapter(ArrayList<ResturantModel> Reslist, Context context) {
        this.Reslist = Reslist;
        this.context = context;
    }

    ArrayList<ResturantModel> Reslist = new ArrayList<>();
    Context context;


    @NonNull
    @Override
    public ResturantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_resturant_sample,parent,false);
        return new ResturantAdapter.ResturantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResturantViewHolder holder, int position) {

        ResturantModel resturantModel = Reslist.get(position);

        Picasso.get().load(resturantModel.getResImg()).into(holder.ResImg);
        holder.ResNam.setText(resturantModel.getResNam());
        holder.ResRat.setText(resturantModel.getResRat());
        holder.ResDetail.setText(resturantModel.getResDetail());

        holder.ResImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ResturantsDetails.class);

                intent.putExtra("ResImg",resturantModel.getResImg());
                intent.putExtra("ResNam",resturantModel.getResNam());
                intent.putExtra("ResRat",resturantModel.getResRat());
                intent.putExtra("ResDetail",resturantModel.getResDetail());
                context.startActivity(intent);


            }
        });



    }

    @Override
    public int getItemCount() {
        return Reslist.size();
    }

    public class ResturantViewHolder extends RecyclerView.ViewHolder {

        ImageView ResImg;
        TextView ResNam,ResRat,ResDetail;

        public ResturantViewHolder(@NonNull View itemView) {
            super(itemView);

            ResImg = itemView.findViewById(R.id.ResImg);
            ResRat = itemView.findViewById(R.id.ResRat);
            ResNam = itemView.findViewById(R.id.ResNam);
            ResDetail = itemView.findViewById(R.id.ResDetail);

        }
    }

}
