package com.example.alex.mpandroidchart;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;

/**
 * Created by Alex on 10/04/2015.
 */
public class MPAndroidChart {

    public void PiePlot(PieChart pieChart) {

        Context context = pieChart.getContext();
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        Legend l;
        PieDataSet dataSet;
        PieData data;
        PieChart chart;

        // Set the basic information of the graph
        entries.add(new Entry((float) 20.0, 0));
        entries.add(new Entry((float) 12.0, 1));
        entries.add(new Entry((float) 25.0, 2));
        entries.add(new Entry((float) 45.0, 3));
        entries.add(new Entry((float) 9.0, 4));
        entries.add(new Entry((float) 32.0, 5));
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        // Set different colors
        ArrayList<Integer> colors = setColors();

        // Set the Pie Chart properties
        dataSet = new PieDataSet(entries, "Months");
        dataSet.setColors(colors);
        dataSet.setValueTextSize(18f);
        dataSet.setValueTextColor(Color.WHITE);

        data = new PieData(labels, dataSet);
        data.setValueTypeface(Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf"));
        data.setValueFormatter(new PercentFormatter());

        // Set the Donut properties
        chart = new PieChart(context);
        chart.setHoleRadius(58f);
        chart.setTransparentCircleRadius(62f);
        chart.setHoleColor(Color.WHITE);
        chart.setHoleColorTransparent(false);
        chart.setDrawHoleEnabled(true);
        chart.setUsePercentValues(true);
        chart.setCenterText("Pie Plot");
        chart.setDrawCenterText(true);
        chart.setCenterTextTypeface(Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf"));
        chart.setCenterTextSize(24f);
        chart.setDescription("Nueva Descripcion");
        chart.setDescriptionTextSize(18f);
        chart.setData(data);

        // Set the panel properties
        l = chart.getLegend();
        l.setPosition(LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextSize(18f);

        pieChart.addView(chart);
    }

    private ArrayList<Integer> setColors() {

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        return colors;
    }
}
