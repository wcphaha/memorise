package com.example.memorise.ui.set;

import androidx.lifecycle.ViewModelProviders;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;
import com.example.memorise.object.User;
import com.example.memorise.sql.DatabaseHelper;


public class SetFragment extends Fragment {

    private SetViewModel setViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setViewModel =
                ViewModelProviders.of(this).get(SetViewModel.class);
        View root = inflater.inflate(R.layout.fragment_set, container, false);


        return root;
    }

}
