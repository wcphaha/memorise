package com.example.memorise.threads;

import android.widget.TextView;

import com.example.memorise.StaticVar.Variable;
import com.example.memorise.object.Vocabulary;

public class FreshHome extends Thread {
    TextView vocab;
    TextView mean;

    //构造方法
    public FreshHome(TextView textView ,TextView mean){
        this.vocab = textView;
        this.mean = mean;
    }

    @Override
    public void run() {
        super.run();
        freshtext();//调用刷新方法
    }
    public void freshtext(){
        vocab.setText(Variable.vocabularies[0].vocab);
        mean.setText(Variable.vocabularies[0].mean);
    }
}
