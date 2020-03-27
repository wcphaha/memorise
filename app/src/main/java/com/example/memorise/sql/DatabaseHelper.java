package com.example.memorise.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.memorise.StaticVar.Variable;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //初始化一个数据库，只在第一次调用时运行
        //不同设备第一次运行程序时，会调用这个函数，初始化数据库
        //之后调用此类不会运行这个函数
        String SQL;
        SQL = "create table user ( name VARCHAR(50),password VARCHAR(50),headpath VARCHAR(50),address VARCHAR(50),sign VARCHAR(50),email VARCHAR(50),sum INT,dayplan INT,islogin VARCHAR(50))";
        db.execSQL(SQL);
        String insert = "insert into user (name,password,headpath,address,sign,email,sum,dayplan,islogin) values ('神秘人','123456','https://s1.ax1x.com/2020/03/12/8e9b1s.jpg','火星','这个人很神秘，什么都没留下','快去登录吧',0,20,'false');";
        db.execSQL(insert);
        String create = "create table history (one INT,two INT,three INT,four INT,five INT,six INT,seven INT )";
        db.execSQL(create);
        String insert1 = "insert into history ( one,two,three,four,five,six,seven ) values (12,23,32,23,9,50,0)";
        db.execSQL(insert1);
        String create2 = "create table mem ( date VARCHAR(50),know INT,unclear INT,forget INT )";
        db.execSQL(create2);
        Date date = new Date();
        String d = date.toString().substring(0,10);
        String insert2 = "insert into mem (date,know,unclear,forget) values ('"+ d +"',0,0,0)";
        db.execSQL(insert2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}