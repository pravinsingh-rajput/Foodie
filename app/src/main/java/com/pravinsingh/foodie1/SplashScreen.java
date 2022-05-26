package com.pravinsingh.foodie1;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import foodie1.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        getSupportActionBar().hide();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );


        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashScreen.this,Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();



    }
}