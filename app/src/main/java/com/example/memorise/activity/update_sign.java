package com.example.memorise.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.memorise.R;

public class update_sign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sign);
        getSupportActionBar().setTitle("修改签名");
    }
}