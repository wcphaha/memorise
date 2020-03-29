package com.example.memorise.threads;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.StaticVar.variable;
import com.example.memorise.sql.my_data_base;
/**
 * 初始化用户数据线程
 */
public class InitUser extends Thread {
    SQLiteDatabase db;

    public InitUser(SQLiteDatabase db){
        this.db = db;
    }
    @Override
    public void run() {
        super.run();
        init();
    }
    public void init(){
        String name,password,headpath,address,dayplan,sign,sum,email,islogin;
        my_data_base mdb = new my_data_base(db);
        name =  mdb.query("name","select name from user")[0];
        variable.user.name = name;

        password = mdb.query("password","select password from user")[0];
        variable.user.password = password;

        headpath = mdb.query("headpath","select headpath from user")[0];
        variable.user.headpath = headpath;

        address = mdb.query("address","select address from user")[0];
        variable.user.address = address;

        dayplan = mdb.query("dayplan","select dayplan from user")[0];
        variable.user.dayplan = Integer.valueOf(dayplan);

        sign = mdb.query("sign","select sign from user")[0];
        variable.user.sign = sign;

        sum = mdb.query("sum","select sum from user")[0];
        variable.user.sumvocab = Integer.valueOf(sum);

        email = mdb.query("email","select email from user")[0];
        variable.user.email = email;

        islogin = mdb.query("islogin","select islogin from user")[0];
        variable.user.islogin = islogin;

        String d1,d2,d3,d4,d5,d6,d7;
        d1 = mdb.query("one","select one from history")[0];
        d2 = mdb.query("two","select two from history")[0];
        d3 = mdb.query("three","select three from history")[0];
        d4 = mdb.query("four","select four from history")[0];
        d5 = mdb.query("five","select five from history")[0];
        d6 = mdb.query("six","select six from history")[0];
        d7 = mdb.query("seven","select seven from history")[0];
        variable.history[0] = Integer.valueOf(d1);
        variable.history[1] = Integer.valueOf(d2);
        variable.history[2] = Integer.valueOf(d3);
        variable.history[3] = Integer.valueOf(d4);
        variable.history[4] = Integer.valueOf(d5);
        variable.history[5] = Integer.valueOf(d6);
    }
}
