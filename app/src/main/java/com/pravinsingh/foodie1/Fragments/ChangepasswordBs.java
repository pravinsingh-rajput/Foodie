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
 * Use the {@link ChangepasswordBs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChangepasswordBs extends BottomSheetDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChangepasswordBs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChangepasswordBs.
     */
    // TODO: Rename and change types and number of parameters
    public static ChangepasswordBs newInstance(String param1, String param2) {
        ChangepasswordBs fragment = new ChangepasswordBs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    TextInputLayout Password,Confirmpassword;
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
        View view = inflater.inflate(R.layout.fragment_changepassword_bs, container, false);


        Confirmpassword = view.findViewById(R.id.Confirmpassword);
        Change = view.findViewById(R.id.confirmchange);

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( !validatpassword()){
                    return;
                }

                String password = Confirmpassword.getEditText().getText().toString();



                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid());
                reference.child("password").setValue(password);


                Toast.makeText(getContext(), "Password Updated", Toast.LENGTH_SHORT).show();
            }
        });





        return view;
    }

        private boolean  validatpassword(){

        String Val = Confirmpassword.getEditText().getText().toString().trim();
        String checkpassword = "^"+"(?=\\S+$)"+".{5,}"+"$";
        if (Val.isEmpty()){
            Confirmpassword.setError("Field cannot be empty");
            return false;
        }else if(!Val.matches(checkpassword)){
            Confirmpassword.setError("Password should contain 4 Character & no white spaces");
            return false;

        }else {
            Confirmpassword.setError(null);
            Confirmpassword.setErrorEnabled(false);
            return true ;
        }
    }


}