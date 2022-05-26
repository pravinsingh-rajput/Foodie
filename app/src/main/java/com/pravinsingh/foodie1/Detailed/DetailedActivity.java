package com.pravinsingh.foodie1.Detailed;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.pravinsingh.foodie1.Modules.CartModule;
import com.squareup.picasso.Picasso;

import foodie1.R;

public class DetailedActivity extends AppCompatActivity {


    ImageView Foodimg;
    TextView Foodprice, Foodname, ResturantName, preTime, rating, fdescription, Quantity,test;
    String fname, fimg, fprice, resturaantname, preptime, raTing, Fdescp;
    Button addtocart, plusbtn, minusbtn;
    private int numberorder = 1;
    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseStorage storage;
    DatabaseReference reference;
    int totalQty = 1;
    int totalPrice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        getSupportActionBar().hide();


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();

        addtocart = findViewById(R.id.AddtoCart1);


        fname = getIntent().getStringExtra("fname");
        fimg = getIntent().getStringExtra("fimg");
        fprice = getIntent().getStringExtra("fprice");
        resturaantname = getIntent().getStringExtra("ResturantName");
        preptime = getIntent().getStringExtra("preptime");
        raTing = getIntent().getStringExtra("Rating");
        Fdescp = getIntent().getStringExtra("fdescription");

        intitView();
        setdata();

        test.setText(fimg);

        String num1 = Foodprice.getText().toString();
        String num2 = Quantity.getText().toString();


        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalQty < 10){
                    totalQty++;
                    Quantity.setText(String.valueOf(totalQty));
                }

            }
        });
        minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalQty > 1){
                    totalQty--;
                    Quantity.setText(String.valueOf(totalQty));
                }

            }
        });


//        onActivityResult(Uri.parse("fimg"));


//        Uri uri = Uri.parse("fimg");
//        Foodimg.setImageURI(uri);

//        addtocart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final StorageReference reference =storage.getReference().child("ADDTOCART")
//                        .child(FirebaseAuth.getInstance().getUid());
//                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                            @Override
//                            public void onSuccess(Uri uri) {
//                                CartModule cartModule = new CartModule();
//                                cartModule.setImage(uri.toString());
//                                cartModule.setName(Foodname.getText().toString());
//                                cartModule.setPrice(Foodprice.getText().toString());
//                                cartModule.setQuantity(Quantity.getText().toString());
//
//                                database.getReference().child("CartChech")
//                                        .push()
//                                        .setValue(cartModule) .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void unused) {
//                                        Toast.makeText(DetailedActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
//
//                                    }
//                                });
//
//                            }
//                        });
//
//                    }
//                });
//
//            }
//        });
//
//

//        addtocart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction(Foodimg.toString());
//                intent.setType(Foodimg.toString());
//                Uri uri = Uri.parse(Foodimg.toString());
////                Foodimg.setImageURI(uri);
//                startActivityForResult(intent,11);
//            }
//        });

        reference = FirebaseDatabase.getInstance().getReference().child("Addtocart").child(FirebaseAuth.getInstance().getUid());

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usercartdata();
            }
        });



    }

    private void usercartdata() {
        String foodname = Foodname.getText().toString();
        String foodprice = Foodprice.getText().toString();
        String foodqty = Quantity.getText().toString();
        String foodimg = test.getText().toString();

        CartModule cartModule = new CartModule(foodname,foodprice,foodqty,foodimg);
        reference.push().setValue(cartModule);
        Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();


    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Uri uri = data.getData();
////        Foodimg.setImageURI(uri);
//
//        final StorageReference reference = storage.getReference().child("AddTOCART").child(FirebaseAuth.getInstance().getUid());
//        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                Toast.makeText(DetailedActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();
////                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
////                    @Override
////                    public void onSuccess(Uri uri) {
////                        database.getReference().child("Addtocart").child(auth.getUid()).child("profilepic").setValue(uri.toString());
////                        Toast.makeText(DetailedActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();
////
////
////
////                    }
////
////                });
//
//            }
//        });
//
//    }






    public void setdata(){
        try {
            Picasso.get().load(fimg).into((ImageView) Foodimg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Foodprice.setText(fprice);
        Foodname.setText(fname);
        ResturantName.setText(resturaantname);
        preTime.setText(preptime);
        rating.setText(raTing);
        fdescription.setText(Fdescp);
    }

    private void intitView(){
        Foodprice = findViewById(R.id.price);
        Foodname = findViewById(R.id.foodname);
        Foodimg = findViewById(R.id.foodImage);
        ResturantName = findViewById(R.id.ResName);
        preTime = findViewById(R.id.PreTime);
        rating = findViewById(R.id.ResRating);
        fdescription = findViewById(R.id.fdescription);
        Quantity = findViewById(R.id.numberoffood);
        plusbtn = findViewById(R.id.plusbtn);
        minusbtn = findViewById(R.id.minusbtn);
        test = findViewById(R.id.test);
    }



}