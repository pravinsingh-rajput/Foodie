package com.pravinsingh.foodie1.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pravinsingh.foodie1.Categories.Burger;
import com.pravinsingh.foodie1.Categories.Cake;
import com.pravinsingh.foodie1.Categories.Drink;
import com.pravinsingh.foodie1.Categories.Fries;
import com.pravinsingh.foodie1.Categories.Nonveg;
import com.pravinsingh.foodie1.Categories.Pizza;
import com.pravinsingh.foodie1.Categories.Veg;
import com.pravinsingh.foodie1.Modules.CategoriesModules;

import java.util.ArrayList;

import foodie1.R;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.catviewHolder>  {

//    ProgressDialog progressDialog;
    RecyclerView pizzarecylerview,burgerrecyle;




    public CategoriesAdapter(ArrayList<CategoriesModules> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    ArrayList<CategoriesModules> list1 = new ArrayList<CategoriesModules>();
    Context context;



    @NonNull
    @Override
    public catviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_view, parent, false);
        return new catviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull catviewHolder holder, @SuppressLint("RecyclerView") int position) {
        CategoriesModules categoriesModules = list1.get(position);

        holder.catimg.setImageResource(categoriesModules.getCat_Image());
        holder.catname.setText(categoriesModules.getCat_name());

//        progressDialog = new ProgressDialog(context);
//        progressDialog.setTitle("Login");
//        progressDialog.setMessage("Logging to your account");


        holder.catimg.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                switch (position){

                    case 0:
                        Intent intent = new Intent(context, Pizza.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, Burger.class);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context, Fries.class);
                        context.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(context, Drink.class);
                        context.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(context, Cake.class);
                        context.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(context, Veg.class);
                        context.startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(context, Nonveg.class);
                        context.startActivity(intent6);
                        break;

                    default:
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }



    public class catviewHolder extends RecyclerView.ViewHolder {

        ImageView catimg;
        TextView catname;
        String data;
        public catviewHolder(@NonNull View itemView) {
            super(itemView);

            catimg = itemView.findViewById(R.id.cat_image);
            catname = itemView.findViewById(R.id.cat_name);
            String data = catname.getText().toString();


        }
    }
}
