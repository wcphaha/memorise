package com.example.memorise.ParseJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.memorise.object.Vocabulary;

public class JsonToObject {
    public static Vocabulary toObject(JSONObject json){
        Vocabulary vocab = JSON.toJavaObject(json,Vocabulary.class);
        return vocab;
    }
}
