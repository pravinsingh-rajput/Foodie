package com.pravinsingh.foodie1.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.pravinsingh.foodie1.Login;
import com.pravinsingh.foodie1.Modules.User;
import com.squareup.picasso.Picasso;

import foodie1.R;


public class ProfileFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfileFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    FirebaseAuth auth;
    Button Help,upload,editprofile,changepassword,myorder;
    ImageView profile,Signout;
    ActivityResultLauncher<String> gallerylauncher;
    TextView usernumber,useremail,name;
    FirebaseStorage storage;
    FirebaseDatabase database;
    ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        Signout = view.findViewById(R.id.logout);
        upload = view.findViewById(R.id.upload);
        profile = view.findViewById(R.id.profile);
        Help = view.findViewById(R.id.help);
        myorder = view.findViewById(R.id.myorder);
        name = view.findViewById(R.id.name);
        usernumber = view.findViewById(R.id.usernumber);
        useremail = view.findViewById(R.id.useremail);
        editprofile = view.findViewById(R.id.editprofile);
        changepassword = view.findViewById(R.id.changepassword);



        database.getReference().child("Users").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    User user = snapshot.getValue(User.class);
                    Picasso.get()
                            .load(user.getProfilepic())
                            .placeholder(R.drawable.profile)
                            .into(profile);
                    name.setText(user.getUsername());
                    useremail.setText(user.getEmail());
                    usernumber.setText(user.getMnumber());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        gallerylauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri uri) {

                profile.setImageURI(uri);

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,11);



            }
        });



        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HelpBS helpBS = new HelpBS();
                helpBS.show(getActivity().getSupportFragmentManager(), helpBS.getTag());

            }
        });



        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyorderBS myorderBS = new MyorderBS();
                myorderBS.show(getActivity().getSupportFragmentManager(), myorderBS.getTag());

            }
        });

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditprofileBS editprofileBS = new EditprofileBS();
                editprofileBS.show(getActivity().getSupportFragmentManager(), editprofileBS.getTag());

            }
        });

        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangepasswordBs changepasswordBS = new ChangepasswordBs();
                changepasswordBS.show(getActivity().getSupportFragmentManager(), changepasswordBS.getTag());

            }
        });






        return view;

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            Uri uri = data.getData();
            profile.setImageURI(uri);

            final StorageReference reference = storage.getReference().child("profilepic").child(FirebaseAuth.getInstance().getUid());
            reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getContext(), "Profile Updated", Toast.LENGTH_SHORT).show();
                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            database.getReference().child("Users").child(auth.getUid()).child("profilepic").setValue(uri.toString());
                            Toast.makeText(getContext(), "Profile Updated", Toast.LENGTH_SHORT).show();

                        }
                    });

                }
            });

    }




}