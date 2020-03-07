package com.example.memorise.ui.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.memorise.ParseJson.JsonToObject;
import com.example.memorise.ParseJson.StrToJosn;
import com.example.memorise.R;
import com.example.memorise.object.Vocabulary;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final ImageView imageView = root.findViewById(R.id.image);
        final RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(
                    "http://139.199.187.245:9003/vocab",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("我佛啦!!!"+response);
                            JSONObject json = StrToJosn.ParseJsonArray(response);
                            Vocabulary vocabulary = JsonToObject.toObject(json);
                            textView.setText(
                                    "单词："+vocabulary.vocab+"\n"+
                                            "意思："+vocabulary.mean+"\n"+
                                            "记忆次数："+vocabulary.count);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("出了点问题!!!");
                        }
                    }
            );
                mQueue.add(stringRequest);//将返回的请求放到请求队列里面
            }
        });
        Glide.with(this).load("https://s2.ax1x.com/2020/02/02/1YPDu8.jpg")
                .into(imageView);
        StringRequest stringRequest = new StringRequest(
                "http://139.199.187.245:9003/vocab",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("我佛啦!!!"+response);
                        JSONObject json = StrToJosn.ParseJsonArray(response);
                        Vocabulary vocabulary = JsonToObject.toObject(json);
                        textView.setText(
                                "单词："+vocabulary.vocab+"\n"+
                                "意思："+vocabulary.mean+"\n"+
                                "记忆次数："+vocabulary.count);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("出了点问题!!!");
                    }
                }
        );

        mQueue.add(stringRequest);//将返回的请求放到请求队列里面
        System.out.println("0000");

        return root;
    }
}