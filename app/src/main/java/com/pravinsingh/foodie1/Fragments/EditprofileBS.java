package com.pravinsingh.foodie1.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import foodie1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditprofileBS#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditprofileBS extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditprofileBS() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditprofileBS.
     */
    // TODO: Rename and change types and number of parameters
    public static EditprofileBS newInstance(String param1, String param2) {
        EditprofileBS fragment = new EditprofileBS();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    TextInputLayout Name,Email,Mnumber;
    Button Change;



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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_editprofile_b_s, container, false);

        Name = view.findViewById(R.id.ChangeName);
        Email = view.findViewById(R.id.ChangeEmail);
        Mnumber = view.findViewById(R.id.ChangeNumber);
        Change = view.findViewById(R.id.confirmchange);

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validatnumber() | !validateemail() | !validatename()){
                    return;
                }

                String name = Name.getEditText().getText().toString();
                String email = Email.getEditText().getText().toString();
                String numner = Mnumber.getEditText().getText().toString();



                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid());
                reference.child("username").setValue(name);
                reference.child("email").setValue(email);
                reference.child("mnumber").setValue(numner);


                Toast.makeText(getContext(), "Updated Sucessfully", Toast.LENGTH_SHORT).show();
            }
        });




        return view;
    }


    private boolean validatename(){

        String Val = Name.getEditText().getText().toString().trim();
        if (Val.isEmpty()){
            Name.setError("Field cannot be empty");
            return false;
        }else {
            Name.setError(null);
            Name.setErrorEnabled(false);
            return true ;
        }
    }
    private boolean validateemail(){

        String Val = Email.getEditText().getText().toString().trim();
        String checkemail = "[a-zA=Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (Val.isEmpty()){
            Email.setError("Field cannot be empty");
            return false;
        }else if(!Val.matches(checkemail)){
            Email.setError("Invalid Email");
            return false;

        }else {
            Email.setError(null);
            Email.setErrorEnabled(false);
            return true ;
        }
    }
    private boolean  validatnumber(){

        String Val = Mnumber.getEditText().getText().toString().trim();
        if (Val.isEmpty()){
            Mnumber.setError("Field cannot be empty");
            return false;
        }else if(Val.length()!=10){
            Mnumber.setError("Invalid Number");
            return false;
        }else {
            Mnumber.setError(null);
            Mnumber.setErrorEnabled(false);
            return true ;
        }
    }
}