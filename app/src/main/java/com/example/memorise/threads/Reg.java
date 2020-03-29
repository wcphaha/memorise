package com.example.memorise.threads;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.memorise.ParseJson.JsonToObject;
import com.example.memorise.ParseJson.StrToJosn;
import com.example.memorise.StaticVar.variable;
import com.example.memorise.model.Message;

/**
 * 注册线程
 */
public class Reg extends Thread {
    public RequestQueue mQueue;//一个请求队列，发请求时，将请求添加进来
    public StringRequest stringRequest;//一个请求
    public String Lname;
    public String Lpassword;

    public Reg(RequestQueue mQueue,String name,String password){
        this.mQueue = mQueue;
        this.Lname = name;
        this.Lpassword = password;
    }

    @Override
    public void run() {
        super.run();
        log();
    }
    public void log(){
        stringRequest  = new StringRequest(
                "http://139.199.187.245:9130/reg/?name="+ Lname +"&password="+ Lpassword +"",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Message message = JsonToObject.toMessageObject(StrToJosn.ParseJson(response));
                        variable.tip = message.msg;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("222222222222！！！");
                    }
                }
        );//一个请求
        mQueue.add(stringRequest);
    }
}
