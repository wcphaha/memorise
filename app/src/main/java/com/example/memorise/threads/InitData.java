package com.example.memorise.threads;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.StaticVar.variable;
import com.example.memorise.sql.my_data_base;

import java.util.Date;
/**
 * 初始化界面数据线程
 */
public class InitData extends Thread {
    SQLiteDatabase db;

    public InitData(SQLiteDatabase db){
        this.db = db;
    }
    @Override
    public void run() {
        super.run();
        init();
    }
    void init(){
        //初始化进度
        variable.progress = variable.mem[0]+ variable.mem[1]+ variable.mem[2];

        my_data_base mdb = new my_data_base(db);
        //得到现在的日期
        Date now_date = new Date();
        //得到数据库的日期
        String old_date;
        old_date = mdb.query("date","select date from mem")[0];

        //比较日期，判断是否是新的一天
        //如果不是，直接将数据库内容读取到静态变量中
        //如果是，将昨天饼状图数据清空，折线图数据后移
        if ( now_date.toString().substring(0,10).compareTo(old_date.substring(0,10)) == 0 ){
            //数据mem加载进来
            String m1,m2,m3;
            m1 = mdb.query("know","select know from mem")[0];
            m2 = mdb.query("unclear","select unclear from mem")[0];
            m3 = mdb.query("forget","select forget from mem")[0];
            variable.mem[0] = Integer.valueOf(m1);
            variable.mem[1] = Integer.valueOf(m2);
            variable.mem[2] = Integer.valueOf(m3);
            //数据history加载进来
            String seven;
            seven = mdb.query("seven","select seven from history")[0];
            variable.progress = Integer.valueOf(seven);
        }else {
            //清空昨天的记忆表，更改日期
            mdb.delete("delete from mem where date = '"+ old_date +"'");
            mdb.insert("insert into mem (date,know,unclear,forget) values ('"+ now_date.toString().substring(0,10) +"',0,0,0)");
            //history数据前移一天
            String d1,d2,d3,d4,d5,d6,d7;
            d1 = mdb.query("one","select one from history")[0];
            d2 = mdb.query("two","select two from history")[0];
            d3 = mdb.query("three","select three from history")[0];
            d4 = mdb.query("four","select four from history")[0];
            d5 = mdb.query("five","select five from history")[0];
            d6 = mdb.query("six","select six from history")[0];
            d7 = mdb.query("seven","select seven from history")[0];
            d1 = d2;
            d2 = d3;
            d3 = d4;
            d4 = d5;
            d5 = d6;
            d6 = d7;
            mdb.delete("delete from history where seven = "+ d7 +"");
            mdb.insert("insert into history ( one,two,three,four,five,six,seven ) values ("+ d1 +","+ d2 +","+ d3 +","+ d4 +","+ d5 +"," +d6+ ",0)");
        }
    }
}
