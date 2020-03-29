package com.example.memorise.threads;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.StaticVar.variable;
import com.example.memorise.sql.my_data_base;
        /**
        * 保存用户数据线程
        */
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
        my_data_base mdb = new my_data_base(db);

        mdb.update("update user set password = '"+ variable.user.password +"'");

        mdb.update("update user set name = '"+ variable.user.name +"'");

        mdb.update("update user set dayplan = '"+ variable.user.dayplan +"'");

        mdb.update("update user set email = '"+ variable.user.email +"'");

        mdb.update("update user set sign = '"+ variable.user.sign +"'");

        mdb.update("update user set address = '"+ variable.user.address +"'");

        mdb.update("update user set islogin = '"+ variable.user.islogin +"'");

    }
}
