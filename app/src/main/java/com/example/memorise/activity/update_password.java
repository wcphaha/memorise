package com.example.memorise.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.memorise.R;

public class update_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        getSupportActionBar().setTitle("修改密码");
    }
}
