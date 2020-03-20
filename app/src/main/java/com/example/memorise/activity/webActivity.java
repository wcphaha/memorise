package com.example.memorise.activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;

public class webActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web);
        // 创建WebView
        WebView webView = findViewById(R.id.web);
        // 设置支持JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // 加载网页
        webView.loadUrl("https://cn.bing.com/dict/"+ Variable.search_vocab);

    }
}
