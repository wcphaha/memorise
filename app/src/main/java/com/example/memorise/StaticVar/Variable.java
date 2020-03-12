package com.example.memorise.StaticVar;
import com.example.memorise.object.User;
import com.example.memorise.object.Vocabulary;

public class Variable {

    public static int progress_max = 30;
    public static int progress;
    public static int do_not_fresh_home = 0;
    public static int[] mem = {0,5,10};
    public static int[] history;
    public static User user = new User(
            "神秘人",
            "123123",
            "https://s1.ax1x.com/2020/03/12/8e9b1s.jpg",
            "火星",
            "这个人很神秘，什么都没留下",
            "123@qqq.com",
            30);
    public static Vocabulary[] vocabularies = {
            new Vocabulary()
    };
    public static int[] getHistory(){
        history = new int[]{0,0,0,0,0,0,progress};
        return history;
    }
    public static String search_vocab ;
}
