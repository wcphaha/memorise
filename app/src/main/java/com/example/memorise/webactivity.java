package com.example.memorise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.memorise.StaticVar.Variable;

public class webactivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webactivity);
        // 创建WebView
        WebView webView = findViewById(R.id.web);
        // 设置支持JavaScript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // 加载网页
        webView.loadUrl("https://cn.bing.com/dict/"+ Variable.search_vocab);

    }
}
