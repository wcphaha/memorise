package com.example.memorise.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.memorise.StaticVar.Variable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//初始化一个数据库，只在第一次调用时运行
        //不同设备第一次运行程序时，会调用这个函数，初始化数据库
        //之后调用此类不会运行这个函数
        String SQL;
        SQL = "create table user ( name VARCHAR(50),password VARCHAR(50),headpath VARCHAR(50),address VARCHAR(50),sign VARCHAR(50),email VARCHAR(50),dayplan INT )";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}