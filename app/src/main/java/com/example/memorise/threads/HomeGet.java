package com.example.memorise.threads;

import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.memorise.ParseJson.JsonToObject;
import com.example.memorise.ParseJson.StrToJosn;
import com.example.memorise.StaticVar.variable;
/**
 * GET请求单词线程
 */
public class HomeGet extends Thread {

    public StringRequest stringRequest;
    public RequestQueue mQueue;
    TextView vocab;
    TextView mean;
    public HomeGet(RequestQueue mQueue, TextView textView , TextView mean){
        this.mQueue = mQueue;
        this.vocab = textView;
        this.mean = mean;
    }
    @Override
    public void run() {
        super.run();
        init();
    }
    private void init(){

        stringRequest  = new StringRequest(
                "http://139.199.187.245:9003/vocab",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject json = StrToJosn.ParseJsonArray(response);
                        variable.vocabularies[0]= JsonToObject.toVocabularyObject(json);

                        //刷新显示Text
                        vocab.setText(variable.vocabularies[0].vocab);
                        mean.setText(variable.vocabularies[0].mean);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("出了点问题!!!");
                    }
                }
        );//一个请求
        mQueue.add(stringRequest);
    }
}
