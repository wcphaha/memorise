package com.example.memorise.StaticVar;
import com.example.memorise.object.Message;
import com.example.memorise.object.User;
import com.example.memorise.object.Vocabulary;

public class Variable {
    public static Message message = new Message() ;
    public static String tip = "";
    public static String datebase = "user7_db";
    public static int progress_max = 30;
    public static int progress;
    public static int do_not_fresh_home = 0;
    public static int[] mem = {0,0,0};
    public static int[] history = new int[7];
    public static User user = new User();
    public static Vocabulary[] vocabularies = {
            new Vocabulary()
    };
    public static int[] getHistory(){
        int[] h = new int[]{history[0],history[1],history[2],history[3],history[4],history[5],progress};
        return h;
    }
    public static String search_vocab ;
}
