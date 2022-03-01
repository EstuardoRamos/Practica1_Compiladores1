package com.example.practica1_compiladores1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Graficas2Activity extends AppCompatActivity {
    BarChart graficBarra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficas2);
        graficBarra = findViewById(R.id.barras2);
        List <BarEntry> entradas = new ArrayList<>();
        entradas.add(new BarEntry(0f ,3));
        entradas.add(new BarEntry(1f ,4));
        entradas.add(new BarEntry(2f ,8));

        BarDataSet datos = new BarDataSet(entradas, "prueba");
        BarData data = new BarData(datos);

        datos.setColors(ColorTemplate.COLORFUL_COLORS);
        data.setBarWidth(0.9f);

        graficBarra.setData(data);
        graficBarra.setFitBars(true);
        graficBarra.invalidate();

    }
}