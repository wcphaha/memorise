package com.example.memorise.StaticVar;
import com.example.memorise.object.User;
import com.example.memorise.object.Vocabulary;

public class Variable {

    public static int progress_max = 30;
    public static int progress;
    public static int do_not_fresh_home = 0;
    public static int[] mem = {0,5,10};
    public static int[] history;
    public static User user;
    public static Vocabulary[] vocabularies = {
            new Vocabulary()

    };
    public static int[] getHistory(){
        history = new int[]{0,0,0,0,0,0,progress};
        return history;
    }
    public static String search_vocab ;
}
