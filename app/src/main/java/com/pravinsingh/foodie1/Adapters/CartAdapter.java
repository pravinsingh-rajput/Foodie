package com.pravinsingh.foodie1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pravinsingh.foodie1.Modules.CartModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import foodie1.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {

    String id;
    int totalQty = 1;
    int tprice = 0;

    public CartAdapter (ArrayList<CartModule> Cartlist, Context context){
        this.Cartlist = Cartlist;
        this.context = context;
    }
    ArrayList<CartModule> Cartlist = new ArrayList<>();
    Context context;




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_view_sample,parent,false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        CartModule module = Cartlist.get(position) ;

        Picasso.get().load(module.getImage()).into(holder.Image);


        holder.Name.setText(module.getName());
        holder.Price.setText(module.getPrice());
        holder.Quantity.setText(module.getQuantity());



        holder.Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra("aname",module.getName());
                intent.putExtra("aimage",module.getImage());
                intent.putExtra("aprice",module.getPrice());
                intent.putExtra("aquantity",module.getQuantity());
//                intent.putExtra("preptime",module.getCVBPreptime());
//                intent.putExtra("Rating",module.getCVBRating());
//                intent.putExtra("fdescription",module.getCVBdescription());

                context.startActivity(intent);

            }
        });

//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                deleterecord(id);
//            }
//        });
        String num2 = holder.Quantity.getText().toString();



        holder.increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalQty < 10){
                    totalQty++;
                    holder.Quantity.setText(String.valueOf(totalQty));
                    int totalva = Integer.parseInt(holder.Quantity.getText().toString())
                            * Integer.parseInt(holder.testprice.getText().toString());
                    holder.Price.setText(String.valueOf(totalva));

                }

            }
        });
        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalQty > 1){
                    totalQty--;
                    holder.Quantity.setText(String.valueOf(totalQty));
                    int totalva = Integer.parseInt(holder.Quantity.getText().toString())
                            * Integer.parseInt(holder.testprice.getText().toString());
                    holder.Price.setText(String.valueOf(totalva));
                }

            }
        });



    }


    @Override
    public int getItemCount() {
        return Cartlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView Image;
        Button increase,decrease,delete;
        TextView Name,Price,Quantity,testprice;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            Image = itemView.findViewById(R.id.OrderImg);
            Name = itemView.findViewById(R.id.OrderName);
            Price = itemView.findViewById(R.id.OrderPrice);
            testprice = itemView.findViewById(R.id.OrderPrice);
            Quantity = itemView.findViewById(R.id.OrderQuantity);

            increase = itemView.findViewById(R.id.incQty);
            decrease = itemView.findViewById(R.id.decQty);
            delete = itemView.findViewById(R.id.delete);



        }
    }

//    private void deleterecord(String id){
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(FirebaseAuth.getInstance().getUid()).child("");
//        Task<Void> mtask =reference.removeValue();
//        mtask.addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(context, "Error deleting Record", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }


}
