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
import com.example.memorise.MainActivity;
import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;
import com.example.memorise.threads.HomeGet;
import com.example.memorise.webactivity;

public class HomeFragment extends Fragment {

    public RequestQueue mQueue;//一个请求队列，发请求时，将请求添加进来
    private HomeViewModel homeViewModel;//未使用

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView mean = root.findViewById(R.id.mean);
        final TextView tip1 = root.findViewById(R.id.tip1);
        final TextView tip2 = root.findViewById(R.id.tip2);
        final LinearLayout btns = root.findViewById(R.id.btns);
        final Button know = root.findViewById(R.id.know);
        final FrameLayout frameLayout = root.findViewById(R.id.shows);
        final ProgressBar progressBar = root.findViewById(R.id.progress);
        final TextView elaborate = root.findViewById(R.id.elaborate);
        mQueue = Volley.newRequestQueue(getActivity());
        progressBar.setMax(Variable.user.dayplan);
        progressBar.setProgress(Variable.progress);

        elaborate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Variable.search_vocab = (String) textView.getText();
                Intent intent = new Intent(getActivity(), webactivity.class);
                startActivity(intent);
            }
        });

        know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeGet h1 = new HomeGet(mQueue,textView,mean);
                h1.run();
                Variable.progress +=1;
                Variable.mem[0]+=1;
                progressBar.setProgress(Variable.progress);
                if (Variable.progress == Variable.user.dayplan){
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
        if (Variable.do_not_fresh_home == 0){
            //调用线程刷新界面
            HomeGet g1 = new HomeGet(mQueue,textView,mean);
            g1.run();
            Variable.do_not_fresh_home = 1;
        }else {
            //刷新显示Text
            textView.setText(Variable.vocabularies[0].vocab);
            mean.setText(Variable.vocabularies[0].mean);
        }

        ///
        return root;
    }
}