package com.example.memorise.ui.set;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.memorise.R;
import com.example.memorise.activity.about_activity;
import com.example.memorise.activity.help_activity;
import com.example.memorise.activity.login_activity;


public class SetFragment extends Fragment {
    private SetViewModel setViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setViewModel =
                ViewModelProviders.of(this).get(SetViewModel.class);
        View root = inflater.inflate(R.layout.fragment_set, container, false);

        final LinearLayout login = root.findViewById(R.id.login);
        final LinearLayout update_id = root.findViewById(R.id.update_id);
        final LinearLayout update_sign = root.findViewById(R.id.update_sign);
        final LinearLayout update_email = root.findViewById(R.id.update_email);
        final LinearLayout update_plan = root.findViewById(R.id.update_plan);
        final LinearLayout update_address = root.findViewById(R.id.update_address);
        final LinearLayout update_password = root.findViewById(R.id.update_password);
        final LinearLayout about = root.findViewById(R.id.about);
        final LinearLayout help = root.findViewById(R.id.help);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), login_activity.class);
                startActivity(intent);

            }
        });
        update_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.memorise.activity.update_id.class);
                startActivity(intent);

            }
        });
        update_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.memorise.activity.update_sign.class);
                startActivity(intent);

            }
        });
        update_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.memorise.activity.update_email.class);
                startActivity(intent);

            }
        });
        update_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.memorise.activity.update_plan.class);
                startActivity(intent);

            }
        });
        update_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.memorise.activity.update_address.class);
                startActivity(intent);

            }
        });
        update_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.memorise.activity.update_password.class);
                startActivity(intent);

            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), about_activity.class);
                startActivity(intent);

            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), help_activity.class);
                startActivity(intent);

            }
        });


        return root;
    }

}
