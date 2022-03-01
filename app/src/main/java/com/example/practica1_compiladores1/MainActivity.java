package com.example.practica1_compiladores1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.practica1_compiladores1.analizadores.CounterLexer;
import com.example.practica1_compiladores1.analizadores.Sintactico;

import java.io.Reader;
import java.io.StringReader;


public class MainActivity extends AppCompatActivity {
    CounterLexer lexer;
    Sintactico parser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void cambium(View view ){
        EditText areaTexto = findViewById(R.id.entrada);
        String entrada = areaTexto.getText().toString();
        //Intent intent = new Intent(this, GraficasActivity.class);
        //startActivity(intent);

        Intent intent = new Intent(this, Graficas2Activity.class);
        startActivity(intent);
        Reader reader = new StringReader(entrada);
        lexer = new CounterLexer(reader);
        parser = new Sintactico(lexer);

        try {
            //sumasParser.parse();
            parser.parse();

        } catch (Exception e) {
            e.printStackTrace();
            // Aqui ustedes manejan de forma correcta el error.
        }

    }

    public void Cambiar() {
        Cambiar();
    }

    public void Cambiar(View view ){
        Intent intent = new Intent(this, GraficasActivity.class);
        startActivity(intent);

    }




}