package com.example.memorise.threads;

import android.widget.TextView;

import com.example.memorise.object.Vocabulary;

public class FreshHome extends Thread {
    TextView vocab;
    TextView mean;
    Vocabulary vocabulary;

    //构造方法
    public FreshHome(TextView textView ,TextView mean, Vocabulary vocabulary){
        this.vocab = textView;
        this.vocabulary = vocabulary;
        this.mean = mean;
    }

    @Override
    public void run() {
        super.run();
        freshtext();//调用刷新方法
    }
    public void freshtext(){
        vocab.setText(vocabulary.vocab);
        mean.setText(vocabulary.mean);
    }
}
