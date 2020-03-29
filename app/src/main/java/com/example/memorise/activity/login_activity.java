package com.example.memorise.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.memorise.R;
import com.example.memorise.StaticVar.variable;
import com.example.memorise.threads.Login;
import com.example.memorise.threads.Reg;

import java.util.Timer;
import java.util.TimerTask;

public class login_activity extends AppCompatActivity {


    public RequestQueue mQueue;//一个请求队列，发请求时，将请求添加进来

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("登录");

        final Button log_btn = findViewById(R.id.logbtn);
        final Button reg_btn = findViewById(R.id.regbtn);
        final EditText name = findViewById(R.id.log_name);
        final EditText password = findViewById(R.id.log_password);

        mQueue = Volley.newRequestQueue(getBaseContext());
        //点击登录按钮事件处理
        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用Login线程处理登录请求
                Login login = new Login(mQueue,name.getText().toString(),password.getText().toString());
                login.run();
                //定时器，延迟两秒读取提示信息并显示到界面上
                //因为线程异步请求数据，可能造成数据先读后写
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        //这里不能直接修改UI，需要使用runOnUiThread
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), variable.tip,Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                    }
                };
                timer.schedule(task, 2000);//等待两秒运行task代码
            }
        });
        //点击登录按钮事件处理
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建登录线程处理登录请求
                Reg reg = new Reg(mQueue,name.getText().toString(),password.getText().toString());
                reg.run();
                //定时器
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        //这里不能直接修改UI，需要使用runOnUiThread
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), variable.tip,Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                    }
                };
                timer.schedule(task, 2000);
            }
        });

    }
}
