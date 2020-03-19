package com.example.memorise.ParseJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public  class StrToJosn {

    public static JSONObject ParseJsonArray( String str){
        JSONArray list = JSON.parseArray(str);
        System.out.println(str+"123");
        JSONObject json = list.getJSONObject(0);
        return json;
    }
    public static JSONObject ParseJson(String str){
        JSONObject json = JSON.parseObject(str);
        return json;
    }
}
