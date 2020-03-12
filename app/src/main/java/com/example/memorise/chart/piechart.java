package com.example.memorise.chart;

import android.graphics.Color;
import android.graphics.Typeface;

import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

public class piechart {
    private PieChartView chart;
    private PieChartData data;

    private boolean hasLabels = true;//是否在薄片上显示label
    private boolean hasLabelsOutside = false;//是否在薄片外显示label
    private boolean hasCenterCircle = false;//是否中间掏空一个圈
    private boolean hasCenterText1 = true;//掏空圈是的title1
    private boolean hasCenterText2 = true;//掏空圈是的title2
    private boolean isExploded = false;//薄片是否分离
    private boolean hasLabelForSelected = false;


    public piechart(PieChartView pieChartView) {
        this.chart = pieChartView;
    }

    public void show() {
        generateData();
        chart.setCircleFillRatio(1);
    }


    private void generateData() {
        int numValues = 3;
        int sum = 0;
        List<SliceValue> values = new ArrayList<SliceValue>();
        String[] colorArray = {"#008577","#D81B60","#F39D21"};
        for (int i=0;i<3;i++){
            sum += Variable.mem[i];
        }
        NumberFormat num = NumberFormat.getPercentInstance();
        num.setMaximumIntegerDigits(3);
        num.setMaximumFractionDigits(2);
        String p1 = num.format((double)Variable.mem[0] / sum);
        String p2 = num.format((double)Variable.mem[1] / sum);
        String p3 = num.format((double)Variable.mem[2] / sum);

        SliceValue sliceValue1 = new SliceValue((float) Variable.mem[0]);
        sliceValue1.setLabel("认识"+p1);//设置label
        sliceValue1.setColor(Color.parseColor(colorArray[0]));
        values.add(sliceValue1);
        SliceValue sliceValue2 = new SliceValue((float) Variable.mem[1]);
        sliceValue2.setLabel("模糊"+p2);//设置label
        sliceValue2.setColor(Color.parseColor(colorArray[1]));
        values.add(sliceValue2);
        SliceValue sliceValue3 = new SliceValue((float) Variable.mem[2]);
        sliceValue3.setLabel("忘记"+p3);//设置label
        sliceValue3.setColor(Color.parseColor(colorArray[2]));
        values.add(sliceValue3);


        data = new PieChartData(values);
        data.setHasLabels(hasLabels);
        data.setHasLabelsOnlyForSelected(hasLabelForSelected);
        data.setHasLabelsOutside(hasLabelsOutside);
        data.setHasCenterCircle(hasCenterCircle);

        if (isExploded) {
            data.setSlicesSpacing(24);//设置分离距离
        }

        if (hasCenterText1) {
            data.setCenterText1("Hello!");

        }

        if (hasCenterText2) {
            data.setCenterText2("Charts (Roboto Italic)");
        }

        chart.setPieChartData(data);
        chart.setCircleFillRatio(0.5f);//设置放大缩小范围
    }


}
