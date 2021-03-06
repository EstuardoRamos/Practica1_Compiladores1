package com.example.practica1_compiladores1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GraficasActivity extends AppCompatActivity {
    private PieChart pieChart;
    private BarChart barChart;
    private String[] itemsEjex = new String[]{"item1","item2", "item3"};
    private String[] itemsEjex2 = new String[]{"numero1","numero2", "numero3"};
    private int[] ejey = new int[]{3,4,5};
    private int[] colors = new int[]{Color.BLACK, Color.RED, Color.GREEN};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas);

        barChart=(BarChart) findViewById(R.id.barChart);
        pieChart=(PieChart) findViewById(R.id.pieChart);
        createCharts();
    }

    private Chart getSameChart(Chart chart, String description, int textColor, int background, int animation){
        chart.getDescription().setText(description);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animation);

        return chart;
    }

    private void legend(Chart chart){
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        ArrayList<LegendEntry> entries = new ArrayList<>();
        for (int i=0; i<itemsEjex.length; i++){
            LegendEntry entry = new LegendEntry();
            entry.formColor=colors[i];
            entry.label=itemsEjex[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }
    private ArrayList<BarEntry>getBarEntries() {
        ArrayList <BarEntry>entries = new ArrayList<>();
        for (int i = 0; i < itemsEjex.length; i++)
            entries.add(new BarEntry(i,ejey[i]));
        return entries;

    }
    private ArrayList<PieEntry> getPieEntries () {
        ArrayList <PieEntry>entries = new ArrayList<>();
        for (int i = 0; i < itemsEjex.length; i++)
            entries.add(new PieEntry(ejey[i]));
        return entries;
    }
    private void axisX(XAxis axis){
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(itemsEjex));
    }

    private void axisLeft(YAxis axis){
        axis.setSpaceTop(10);
        axis.setAxisMinimum(0);;
    }
    private void axisRight(YAxis axis){
        axis.setEnabled(false);
    }
    public void createCharts(){
        barChart=(BarChart)getSameChart(barChart, "series",Color.RED,Color.YELLOW,3000 );
        barChart.setDrawBarShadow(true);
        barChart.setDrawGridBackground(true);
        barChart.setData(getBarData());
        barChart.invalidate();

        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());

        pieChart=(PieChart) getSameChart(pieChart,"ventas",Color.BLUE, Color.MAGENTA,3000);
        pieChart.setHoleRadius(10);
        pieChart.setTransparentCircleRadius(10);
        pieChart.setData(getPieData());
        pieChart.invalidate();

    }

    private DataSet getData(DataSet dataSet){
        dataSet.setColors(colors);
        dataSet.setValueTextSize(10);
        dataSet.setValueTextColor(Color.RED);
        return dataSet;
    }

    private BarData getBarData(){
        BarDataSet barDataSet =(BarDataSet) getData(new BarDataSet(getBarEntries(),""));

        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }
    private PieData getPieData(){
        PieDataSet pieDataSet =(PieDataSet) getData(new PieDataSet(getPieEntries(),""));

        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueFormatter(new PercentFormatter());

        return new PieData(pieDataSet);
    }


}