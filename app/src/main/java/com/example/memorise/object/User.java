package com.example.memorise.object;

public class User {
    public String name;
    public String password;
    public String headpath;
    public String address;
    public String sign;
    public String email;
    public int sumvocab;
    public int dayplan;


    public User(String name, String password, String headpath, String address, String sign, String email,int sum, int dayplan) {
        this.address = address;
        this.password = password;
        this.headpath = headpath;
        this.name = name;
        this.dayplan = dayplan;
        this.sign = sign;
        this.sumvocab = sum;
        this.email = email;
    }

    public User() {

    }
}
