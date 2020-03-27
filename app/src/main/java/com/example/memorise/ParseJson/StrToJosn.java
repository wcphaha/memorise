package com.example.memorise.ParseJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 自己封装的JOSN字符创转JSON对象类
 */
public  class StrToJosn {
    //JSON数组字符串
    public static JSONObject ParseJsonArray( String str){
        JSONArray list = JSON.parseArray(str);
        System.out.println(str+"123");
        JSONObject json = list.getJSONObject(0);
        return json;
    }
    //JOSN对象字符串
    public static JSONObject ParseJson(String str){
        JSONObject json = JSON.parseObject(str);
        return json;
    }
}
