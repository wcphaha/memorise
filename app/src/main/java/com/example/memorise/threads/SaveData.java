package com.example.memorise.threads;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.StaticVar.Variable;
import com.example.memorise.sql.MyDataBase;

import java.util.Date;

public class SaveData extends Thread {
    SQLiteDatabase db;

    public SaveData(SQLiteDatabase db){
        this.db = db;
    }
    @Override
    public void run() {
        super.run();
        init();
    }
    void init(){
        //先向mem中保存，m1,m2,m3
        MyDataBase mdb = new MyDataBase(db);
        int m1,m2,m3;
        m1 = Variable.mem[0];
        m2 = Variable.mem[1];
        m3 = Variable.mem[2];
        Date date = new Date();
        String now = date.toString().substring(0,10);
        mdb.update("update mem set know = "+ m1 +" where date = '"+ now +"'");
        mdb.update("update mem set unclear = "+ m2 +" where date = '"+ now +"'");
        mdb.update("update mem set forget = "+ m3 +" where date = '"+ now +"'");


        //保存history今日进度
        int daysum = Variable.progress;
        mdb.update("update history set seven = "+ daysum +"");
        String t = mdb.query("seven","select seven from history")[0];
        System.out.println("111111"+t);

        //更新记单词总数
        int sum = Variable.user.sumvocab;
        mdb.update("update user set sum = "+ sum +"");

    }
}
