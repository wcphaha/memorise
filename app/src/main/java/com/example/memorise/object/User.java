package com.example.memorise.object;

public class User {
    public String name;
    public String password;
    public String headpath;
    public String address;

    public User(String name,String password,String headpath,String address){
        this.address = address;
        this.password = password;
        this.headpath = headpath;
        this.name = name;
    }
    public User(){

    }
}
