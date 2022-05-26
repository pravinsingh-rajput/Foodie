package com.pravinsingh.foodie1;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pravinsingh.foodie1.Fragments.CartFragment;
import com.pravinsingh.foodie1.Fragments.HomeFragment;
import com.pravinsingh.foodie1.Fragments.ProfileFragment;
import com.pravinsingh.foodie1.Fragments.ShopFragment;

import foodie1.R;
import foodie1.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    BottomNavigationView bottomNavigation;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );




        if (!checkInternet()){
            Dialog dialog = new Dialog(MainActivity.this,R.style.NointernetDialog);
            dialog.setContentView(R.layout.no_internet);
            Button tryagain;
            tryagain = dialog.findViewById(R.id.tryagain);
            tryagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finishAffinity();
                }
            });
            dialog.show();

        }


        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new HomeFragment()).commit();
        binding.bottomNavigation.setSelectedItemId(R.id.home);


        binding.bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_cart:
                        fragment = new CartFragment();
                        break;
                    case R.id.nav_support:
                        fragment = new ShopFragment();
                        break;
                    case R.id.nav_user:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();
                return true;
            }


        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);






    }

    public boolean checkInternet() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnected()) {
            return false;
        }

        return true;
    }

}