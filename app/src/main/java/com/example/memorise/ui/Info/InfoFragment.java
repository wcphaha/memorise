package com.example.memorise.ui.Info;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.memorise.R;
import com.example.memorise.StaticVar.Variable;
import com.example.memorise.chart.linechart;
import com.example.memorise.chart.piechart;
import com.example.memorise.object.User;
import com.example.memorise.sql.DatabaseHelper;
import com.example.memorise.sql.MyDataBase;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
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

        line = root.findViewById(R.id.line_chart);
        linechart chart1 = new linechart(line);
        chart1.show();
        pie = root.findViewById(R.id.pie_chart);
        piechart chart2 = new piechart(pie);
        chart2.show();
        return root;
    }

}