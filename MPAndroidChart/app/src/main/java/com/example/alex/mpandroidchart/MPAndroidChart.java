package com.example.alex.mpandroidchart;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

/**
 * Created by Alex on 10/04/2015.
 */
public class MPAndroidChart {

    public void PiePlot(PieChart pieChart) {

        int[] colors = {Color.BLUE, Color.YELLOW};
        Context context = pieChart.getContext();
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        Legend l;
        PieDataSet dataSet;
        PieData data;
        PieChart chart;

        // Set the basic information of the graph
        entries.add(new Entry((float) 20.0, 0));
        entries.add(new Entry((float) 30.0, 1));
        labels.add("January");
        labels.add("February");

        // Set the Pie Chart properties
        dataSet = new PieDataSet(entries, "Months");
        dataSet.setColors(colors);
        dataSet.setValueTextSize(18f);
        dataSet.setValueTextColor(Color.WHITE);

        // Set the Donut properties
        chart = new PieChart(context);
        chart.setHoleRadius(60f);
        chart.setHoleColor(Color.WHITE);
        chart.setHoleColorTransparent(false);
        chart.setDrawHoleEnabled(true);
        chart.setUsePercentValues(true);
        chart.setCenterText("Pie Plot");
        chart.setCenterTextSize(24f);
        chart.setDescription("Nueva Descripcion");
        chart.setDescriptionTextSize(18f);

        pieChart.addView(chart);

        data = new PieData(labels, dataSet);
        chart.setData(data);

        // Set the panel properties
        l = chart.getLegend();
        l.setPosition(LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextSize(18f);

    }
}
