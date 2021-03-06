package com.example.memorise.threads;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.StaticVar.variable;
import com.example.memorise.sql.my_data_base;

import java.util.Date;
/**
 * 保存界面数据线程
 */
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
        my_data_base mdb = new my_data_base(db);
        int m1,m2,m3;
        m1 = variable.mem[0];
        m2 = variable.mem[1];
        m3 = variable.mem[2];
        Date date = new Date();
        String now = date.toString().substring(0,10);
        mdb.update("update mem set know = "+ m1 +" where date = '"+ now +"'");
        mdb.update("update mem set unclear = "+ m2 +" where date = '"+ now +"'");
        mdb.update("update mem set forget = "+ m3 +" where date = '"+ now +"'");


        //保存history今日进度
        int daysum = variable.progress;
        mdb.update("update history set seven = "+ daysum +"");
        String t = mdb.query("seven","select seven from history")[0];

        //更新记单词总数
        int sum = variable.user.sumvocab;
        mdb.update("update user set sum = "+ sum +"");

    }
}
