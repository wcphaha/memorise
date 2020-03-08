package com.example.memorise.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.example.memorise.ParseJson.JsonToObject;
import com.example.memorise.ParseJson.StrToJosn;
import com.example.memorise.R;
import com.example.memorise.object.Vocabulary;
import com.example.memorise.threads.FreshHome;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private StringRequest stringRequest;
    Vocabulary vocabulary;//存一个单词

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView mean = root.findViewById(R.id.mean);
        final TextView tip1 = root.findViewById(R.id.tip1);
        final TextView tip2 = root.findViewById(R.id.tip2);
        final LinearLayout btns = root.findViewById(R.id.btns);
        final Button know = root.findViewById(R.id.know);
        final FrameLayout frameLayout = root.findViewById(R.id.shows);
        final RequestQueue mQueue = Volley.newRequestQueue(getActivity());

        know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQueue.add(stringRequest);//将请求放到请求队列里面
                btns.setVisibility(View.INVISIBLE);
                tip1.setVisibility(View.VISIBLE);
                tip2.setVisibility(View.VISIBLE);
                mean.setVisibility(View.INVISIBLE);

            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btns.setVisibility(View.VISIBLE);
                tip1.setVisibility(View.INVISIBLE);
                tip2.setVisibility(View.INVISIBLE);
                mean.setVisibility(View.VISIBLE);
//                mQueue.add(stringRequest);//将请求放到请求队列里面
            }
        });
        stringRequest = new StringRequest(
                "http://139.199.187.245:9003/vocab",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject json = StrToJosn.ParseJsonArray(response);
                        vocabulary = JsonToObject.toObject(json);
                        //调用刷新显示Text线程
                        FreshHome freshHome = new FreshHome(textView,mean,vocabulary);
                        freshHome.run();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("出了点问题!!!");
                    }
                }
        );
        mQueue.add(stringRequest);//将请求放到请求队列里面
        System.out.println("0000");

        return root;
    }
}