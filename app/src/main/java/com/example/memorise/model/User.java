package com.example.memorise.model;
/**
 * 用户对象
 * 包含用户的基本信息
 */
public class User {
    public String name;
    public String password;
    public String headpath;
    public String address;
    public String sign;
    public String email;
    public int sumvocab;
    public int dayplan;
    public String islogin;

    public User(String name, String password, String headpath, String address, String sign, String email,int sum, int dayplan,String islogin) {
        this.address = address;
        this.password = password;
        this.headpath = headpath;
        this.name = name;
        this.dayplan = dayplan;
        this.sign = sign;
        this.sumvocab = sum;
        this.email = email;
        this.islogin = islogin;
    }

    public User() {

    }
}
