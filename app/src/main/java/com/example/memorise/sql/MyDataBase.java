package com.example.memorise.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * 自己封装的数据库操作类，提供了对数据库的增删改查功能
 * 使用时需要向构造函数传入要操作的数据库对象
 */
public class MyDataBase {
    SQLiteDatabase db;

    public MyDataBase(SQLiteDatabase database) {//构造函数初始化
        this.db = database;
    }

    public void cleartable(String table) {//清除一个表中的所有数据
        String SQL = "delete from " + table;
        db.execSQL(SQL);
    }

    public void droptable(String table) {//删除表

    }

    public void createtable(String table) {//新建一个表
        String SQL = "CREATE TABLE " + table + "( name VARCHAR );";
        db.execSQL(SQL);
    }

    public void addcol(String col, String table) {//对指定表添加一个字段
        String SQL = "ALTER TABLE " + table + " ADD COLUMN " + col + " VARCHAR;";
        db.execSQL(SQL);
    }

    public void update(String sql) {//对指定表的指定字段添加数据
        String SQL = sql;
        db.execSQL(SQL);
    }

    public void delete( String sql ){
        String SQL = sql;
        db.execSQL(SQL);
    }
    public void insert(String sql){
        String SQL = sql;
        db.execSQL(SQL);
    }
    public String[] query(String key,String sql) {//
        String SQL = sql;

        Cursor cursor = db.rawQuery(SQL,null);
        String[] data = new String[cursor.getCount()];
//判断游标是否为空
        if (cursor.moveToFirst()) {
//遍历游标
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.move(i);
                data[i] = cursor.getString(cursor.getColumnIndex(key));
            }
        }
        return data;
    }


}
