package com.example.memorise.object;
/**
 * 单词对象
 * 记单词页面请求单词时返回的对象，包含一个单词的基本信息
 */
public class Vocabulary {
    public int count;
    public int id;
    public String mean;
    public  String vocab;

    public Vocabulary(int count,int id,String mean,String vocab){
        this.count = count;
        this.id = id;
        this.mean = mean;
        this.vocab = vocab;
    }
    public Vocabulary(){

    }

}
