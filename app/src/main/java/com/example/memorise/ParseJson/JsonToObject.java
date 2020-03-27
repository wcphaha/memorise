package com.example.memorise.ParseJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.memorise.object.Message;
import com.example.memorise.object.User;
import com.example.memorise.object.Vocabulary;
/**
 * 自己封装的JOSN对象处理类，可以将JOSN对象转化为java对象（单词，用户，提示信息）
 */
public class JsonToObject {
    public static Vocabulary toVocabularyObject(JSONObject json){
        Vocabulary vocab = JSON.toJavaObject(json,Vocabulary.class);
        return vocab;
    }
    public static User toUserObject(JSONObject json){
        User user = JSON.toJavaObject(json,User.class);
        return user;
    }
    public static Message toMessageObject(JSONObject json){
        Message message = JSON.toJavaObject(json,Message.class);
        return message;
    }
}
