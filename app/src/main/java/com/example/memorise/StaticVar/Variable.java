package com.example.memorise.StaticVar;

import android.database.sqlite.SQLiteDatabase;

import com.example.memorise.object.User;
import com.example.memorise.object.Vocabulary;

public class Variable {

    public static int progress_max = 5;
    public static int progress;
    public static int do_not_fresh_home = 0;
    public static User user;
    public static Vocabulary[] vocabularies = {
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary(),
            new Vocabulary()
    };
    public static String search_vocab ;
}
