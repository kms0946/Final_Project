package com.google.mlkit.vision.demo.java;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.google.mlkit.vision.demo.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this,submain.class);
                startActivity(intent);
                finish();
            }
        },1000);


    }
}