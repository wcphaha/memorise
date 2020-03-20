package com.example.memorise.threads;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.StaticVar.Variable;
import com.example.memorise.sql.MyDataBase;

public class SaveUser extends Thread {
    SQLiteDatabase db;

    public SaveUser(SQLiteDatabase db){
        this.db = db;
    }
    @Override
    public void run() {
        super.run();
        init();
    }
    void init(){
        MyDataBase mdb = new MyDataBase(db);

        mdb.update("update user set password = '"+ Variable.user.password +"'");

        mdb.update("update user set name = '"+ Variable.user.name +"'");

        mdb.update("update user set dayplan = '"+ Variable.user.dayplan +"'");

        mdb.update("update user set email = '"+ Variable.user.email +"'");

        mdb.update("update user set sign = '"+ Variable.user.sign +"'");

        mdb.update("update user set address = '"+ Variable.user.address +"'");

        mdb.update("update user set islogin = '"+ Variable.user.islogin +"'");

    }
}
