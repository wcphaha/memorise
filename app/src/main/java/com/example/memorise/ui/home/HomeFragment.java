package com.example.memorise.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.memorise.R;
import com.example.memorise.StaticVar.variable;
import com.example.memorise.threads.HomeGet;
import com.example.memorise.activity.web_activity;

public class HomeFragment extends Fragment {

    public RequestQueue mQueue;//一个请求队列，发请求时，将请求添加进来
    private HomeViewModel homeViewModel;//未使用

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //获取页面元素
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView mean = root.findViewById(R.id.mean);
        final TextView tip1 = root.findViewById(R.id.tip1);
        final TextView tip2 = root.findViewById(R.id.tip2);
        final LinearLayout btns = root.findViewById(R.id.btns);
        final Button know = root.findViewById(R.id.know);
        final Button unclear = root.findViewById(R.id.unclear);
        final Button forget = root.findViewById(R.id.forget);
        final FrameLayout frameLayout = root.findViewById(R.id.shows);
        final ProgressBar progressBar = root.findViewById(R.id.progress);
        final TextView elaborate = root.findViewById(R.id.elaborate);
        //初始化请求队列
        mQueue = Volley.newRequestQueue(getActivity());
        //设置进度条信息
        progressBar.setMax(variable.user.dayplan);
        progressBar.setProgress(variable.progress);
        //单词详细信息
        elaborate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variable.search_vocab = (String) textView.getText();
                Intent intent = new Intent(getActivity(), web_activity.class);
                startActivity(intent);
            }
        });
        //点击认识
        know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeGet h1 = new HomeGet(mQueue,textView,mean);
                h1.run();
                variable.progress +=1;
                variable.mem[0]+=1;
                variable.user.sumvocab += 1;
                progressBar.setProgress(variable.progress);
                if (variable.progress >= variable.user.dayplan){
                    Toast.makeText(getActivity(),"今日任务完成",Toast.LENGTH_SHORT)
                            .show();
                }
                elaborate.setVisibility(View.INVISIBLE);
                btns.setVisibility(View.INVISIBLE);
                tip1.setVisibility(View.VISIBLE);
                tip2.setVisibility(View.VISIBLE);
                mean.setVisibility(View.INVISIBLE);

            }
        });
        //点击模糊
        unclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeGet h1 = new HomeGet(mQueue,textView,mean);
                h1.run();
                variable.progress +=1;
                variable.mem[1]+=1;
                progressBar.setProgress(variable.progress);
                if (variable.progress >= variable.user.dayplan){
                    Toast.makeText(getActivity(),"今日任务完成",Toast.LENGTH_SHORT)
                            .show();
                }
                elaborate.setVisibility(View.INVISIBLE);
                btns.setVisibility(View.INVISIBLE);
                tip1.setVisibility(View.VISIBLE);
                tip2.setVisibility(View.VISIBLE);
                mean.setVisibility(View.INVISIBLE);

            }
        });
        //点击忘记
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeGet h1 = new HomeGet(mQueue,textView,mean);
                h1.run();
                variable.progress +=1;
                variable.mem[2]+=1;
                progressBar.setProgress(variable.progress);
                if (variable.progress >= variable.user.dayplan){
                    Toast.makeText(getActivity(),"今日任务完成!",Toast.LENGTH_SHORT)
                            .show();
                }
                elaborate.setVisibility(View.INVISIBLE);
                btns.setVisibility(View.INVISIBLE);
                tip1.setVisibility(View.VISIBLE);
                tip2.setVisibility(View.VISIBLE);
                mean.setVisibility(View.INVISIBLE);

            }
        });
        //点击显示单词意思
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elaborate.setVisibility(View.VISIBLE);
                btns.setVisibility(View.VISIBLE);
                tip1.setVisibility(View.INVISIBLE);
                tip2.setVisibility(View.INVISIBLE);
                mean.setVisibility(View.VISIBLE);

            }
        });
        //通过设置flag解决了每次点击home切换单词
        // 当第一次进入home页面的时候，get单词；
        // 切换界面时到home只刷新一个UI，不重新get新单词
        if (variable.do_not_fresh_home == 0){
            //调用线程刷新界面
            HomeGet g1 = new HomeGet(mQueue,textView,mean);
            g1.run();
            variable.do_not_fresh_home = 1;
        }else {
            //刷新显示Text
            textView.setText(variable.vocabularies[0].vocab);
            mean.setText(variable.vocabularies[0].mean);
        }

        ///
        return root;
    }
}