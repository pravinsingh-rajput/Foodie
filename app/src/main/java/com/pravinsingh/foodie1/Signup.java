package com.pravinsingh.foodie1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;
import com.pravinsingh.foodie1.Modules.User;

import foodie1.R;
import foodie1.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {

    ActivitySignupBinding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    GoogleSignInClient mGoogleSignInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        getSupportActionBar().hide();


        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );




        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

        progressDialog = new ProgressDialog(Signup.this);
        progressDialog.setTitle("Creating user ");
        progressDialog.setMessage("Creating your foodie account.  ");


        CountryCodePicker ccp = binding.countryCodePicker;

        ccp.registerCarrierNumberEditText(binding.editnumber);

        String Number;
        Number = ccp.getFullNumberWithPlus().replace("","");



//        binding.btnsignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!validatename() | !validateemail() | !validatpassword() | !validatnumber() ){
//                    return;
//                }
//                Toast.makeText(Signup.this, "OTP sent Successfully", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Signup.this,OtpVerification.class);
//                intent.putExtra("testnumber",ccp.getFullNumberWithPlus().replace("",""));
//                intent.putExtra("name",binding.username.getEditText().getText().toString());
//                intent.putExtra("password",binding.password.getEditText().getText().toString());
//                intent.putExtra("email",binding.useremail.getEditText().getText().toString());
//                startActivity(intent);
//                finish();
//
//            }
//        });



        binding.btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validatename() | !validateemail() | !validatpassword() | !validatnumber() ){
                    return;
                }
                progressDialog.show();
                mAuth.createUserWithEmailAndPassword(binding.useremail.getEditText().getText().toString(),
                        binding.password.getEditText().getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            User user = new User(binding.username.getEditText().getText().toString(),
                                    binding.useremail.getEditText().getText().toString(),
                                    binding.mnumber.getEditText().getText().toString(),
                                    binding.password.getEditText().getText().toString());



                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);

                            Toast.makeText(Signup.this, "User Created Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Signup.this,MainActivity.class);
                            startActivity(intent);
                            finish();


                        }
                        else{
                            Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });



        binding.google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

    }



    private boolean validatename(){

        String Val = binding.username.getEditText().getText().toString().trim();
        if (Val.isEmpty()){
            binding.username.setError("Field cannot be empty");
            return false;
        }else {
            binding.username.setError(null);
            binding.username.setErrorEnabled(false);
            return true ;
        }
    }
    private boolean validateemail(){

        String Val = binding.useremail.getEditText().getText().toString().trim();
        String checkemail = "[a-zA=Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (Val.isEmpty()){
            binding.useremail.setError("Field cannot be empty");
            return false;
        }else if(!Val.matches(checkemail)){
            binding.useremail.setError("Invalid Email");
            return false;

        }else {
            binding.useremail.setError(null);
            binding.useremail.setErrorEnabled(false);
            return true ;
        }
    }
    private boolean  validatpassword(){

        String Val = binding.password.getEditText().getText().toString().trim();
        String checkpassword = "^"+"(?=\\S+$)"+".{5,}"+"$";
        if (Val.isEmpty()){
            binding.password.setError("Field cannot be empty");
            return false;
        }else if(!Val.matches(checkpassword)){
            binding.password.setError("Password should contain 4 Character & no white spaces");
            return false;

        }else {
            binding.password.setError(null);
            binding.password.setErrorEnabled(false);
            return true ;
        }
    }
    private boolean  validatnumber(){

        String Val = binding.mnumber.getEditText().getText().toString().trim();
        if (Val.isEmpty()){
            binding.mnumber.setError("Field cannot be empty");
            return false;
        }else if(Val.length()!=11){
            binding.mnumber.setError("Invalid Number");
            return false;
        }else {
            binding.mnumber.setError(null);
            binding.mnumber.setErrorEnabled(false);
            return true ;
        }
    }






    int RC_SIGN_IN = 30;
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("TAG", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            User user1 = new User();
                            user1.setUserId(user.getUid());
                            user1.setUsername((user.getDisplayName()));
                            user1.setProfilepic(user.getPhotoUrl().toString());
                            database.getReference().child("Users").child(user.getUid()).setValue(user1);

                            Intent intent = new Intent(Signup.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(Signup.this, "Signed in with Google", Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());

                        }
                    }
                });
        }



    }


