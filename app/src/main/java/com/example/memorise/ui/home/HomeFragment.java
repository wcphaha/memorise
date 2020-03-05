package com.example.memorise.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.memorise.MainActivity;
import com.example.memorise.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final ImageView imageView = root.findViewById(R.id.image);
        Glide.with(this).load("https://s2.ax1x.com/2020/02/02/1YPDu8.jpg")
                .into(imageView);
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest(
                "https://jsonplaceholder.typicode.com/posts/1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject json = JSONObject.parseObject(response);
                        textView.setText(json.getString("body"));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText(error.getMessage());
                    }
                }
        );
        mQueue.add(stringRequest);
        return root;
    }
}