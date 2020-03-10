package com.example.memorise.ui.set;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.memorise.R;


public class SetFragment extends Fragment {

    private SetViewModel setViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setViewModel =
                ViewModelProviders.of(this).get(SetViewModel.class);
        View root = inflater.inflate(R.layout.fragment_set, container, false);
//        final TextView textView = root.findViewById(R.id.text_set);
//        textView.setText("这里是设置界面");

        return root;
    }

}
