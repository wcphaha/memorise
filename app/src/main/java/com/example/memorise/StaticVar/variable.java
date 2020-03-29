package com.example.memorise.StaticVar;
import com.example.memorise.model.Message;
import com.example.memorise.model.User;
import com.example.memorise.model.Vocabulary;
/**
 * 静态数据
 * 从数据库得到数据
 * 向界面提供要展示的数据
 * 界面修改数据时，直接修改静态数据，然后保存到数据库
 */
public class variable {
    //提示信息对象
    public static Message message = new Message() ;
    //Toast展示的数据
    public static String tip = "";
    //数据库名
    public static String datebase = "user7_db";
    //记单词进度
    public static int progress;
    //刷新界面的控制变量flag
    public static int do_not_fresh_home = 0;
    //圆形统计图数据
    public static int[] mem = {0,0,0};
    //折线统计图数据
    public static int[] history = new int[7];
    //用户对象
    public static User user = new User();
    //单词对象数组
    public static Vocabulary[] vocabularies = {
            new Vocabulary()
    };
    //获取近7天数据方法
    public static int[] getHistory(){
        int[] h = new int[]{history[0],history[1],history[2],history[3],history[4],history[5],progress};
        return h;
    }
    //被搜索的单词
    public static String search_vocab ;
}
