package com.example.memorise.ui.Info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.memorise.R;
import com.example.memorise.chart.line_chart;
import com.example.memorise.chart.pie_chart;

import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

public class InfoFragment extends Fragment {

    private InfoViewModel infoViewModel;
    private LineChartView line;
    private PieChartView pie;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoViewModel =
                ViewModelProviders.of(this).get(InfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_info, container, false);
        //实例化折线图对象，显示折线图
        line = root.findViewById(R.id.line_chart);
        line_chart chart1 = new line_chart(line);
        chart1.show();
        //实例化饼状图对象，显示饼状图
        pie = root.findViewById(R.id.pie_chart);
        pie_chart chart2 = new pie_chart(pie);
        chart2.show();
        return root;
    }

}