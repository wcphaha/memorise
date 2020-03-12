package com.example.memorise.StaticVar;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.object.User;
import com.example.memorise.object.Vocabulary;

public class Variable {

    public static int progress_max = 30;
    public static int progress;
    public static int do_not_fresh_home = 0;
    public static int[] mem = {82,3,15};
    public static User user;
    public static Vocabulary[] vocabularies = {
            new Vocabulary()

    };
    public static String search_vocab ;
}
