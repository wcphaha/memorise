package com.example.memorise.StaticVar;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.memorise.ParseJson.JsonToObject;
import com.example.memorise.ParseJson.StrToJosn;
import com.example.memorise.object.Vocabulary;
import com.example.memorise.threads.FreshHome;

public class Variable {
    public static int do_not_fresh_home = 0;
    public static Vocabulary[] vocabularies = {
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary()
    };
    public static String search_vocab ;
}
