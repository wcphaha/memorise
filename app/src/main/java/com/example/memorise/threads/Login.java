package com.example.memorise.threads;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.memorise.ParseJson.JsonToObject;
import com.example.memorise.ParseJson.StrToJosn;
import com.example.memorise.StaticVar.Variable;
import com.example.memorise.object.Message;
import com.example.memorise.object.User;
/**
 * 登录线程
 */
public class Login extends Thread {

    public RequestQueue mQueue;//一个请求队列，发请求时，将请求添加进来
    public StringRequest stringRequest;//一个请求
    public String Lname;
    public String Lpassword;

    public Login(RequestQueue mQueue,String name,String password){
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
                "http://139.199.187.245:9130/login/?name="+ Lname +"&password="+ Lpassword +"",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        User tempuser = JsonToObject.toUserObject(StrToJosn.ParseJson(response));
                        if (tempuser.name == null){
                            Message message = JsonToObject.toMessageObject(StrToJosn.ParseJson(response));
                            Variable.tip = message.msg;
                        }else {
                            Variable.tip = "登录成功！";
                            Variable.user = tempuser;
                        }
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
