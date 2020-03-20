package com.example.memorise.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.memorise.R;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("关于");
    }
}
