package com.example.memorise.StaticVar;
import com.example.memorise.object.User;
import com.example.memorise.object.Vocabulary;

public class Variable {

    public static int progress_max = 30;
    public static int progress;
    public static int do_not_fresh_home = 0;
    public static int[] mem = {0,0,0};
    public static int[] history = new int[7];
    public static User user = new User(
            "神秘人",
            "123123",
            "https://s1.ax1x.com/2020/03/12/8e9b1s.jpg",
            "火星",
            "这个人很神秘，什么都没留下",
            "123@qqq.com",
            0,
            30);
    public static Vocabulary[] vocabularies = {
            new Vocabulary()
    };
    public static int[] getHistory(){
        int[] h = new int[]{history[0],history[1],history[2],history[3],history[4],history[5],progress};
        return h;
    }
    public static String search_vocab ;
}
