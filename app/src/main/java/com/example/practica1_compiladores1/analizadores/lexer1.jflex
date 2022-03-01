package com.example.practica1_compiladores1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.practica1_compiladores1.analizadores.CounterLexer;
import com.example.practica1_compiladores1.analizadores.Sintactico;

import java.io.Reader;
import java.io.StringReader;
%%

/*segunda seccion: configuracion*/


%class CounterLexer
%unicode
%line
%column
%cup
%public

L=[a-zA-Z_]+
D=[0-9]
PUNTO=[.]
COMA = ","

espacio=[ ]+
tab = [\t]+
salto = [\n]+
rot = [\r]+

comilla = [\"]
decimal = ({D}+{punto}{D}+)
entero = {D}+
cadena = {L}({L}|{D})*

//espacio=[ ,\t,\r,\n]+

%{
    public String lexeme;
%}

%%
   Def | def 	{return new Symbol(sym.DEF, yyline + 1, yycolumn + 1);}
Barras 	{return new Symbol(sym.BARRAS, yyline + 1, yycolumn + 1);}
Pie 		{return new Symbol(sym.PIE, yyline + 1, yycolumn + 1);}
titulo 	{return new Symbol(sym.TITULO, yyline + 1, yycolumn + 1, yytext());}
ejex 		{return new Symbol(sym.EJEX, yyline + 1, yycolumn + 1);}
ejey 		{return new Symbol(sym.EJEY, yyline + 1, yycolumn + 1);}
etiquetas 	{return new Symbol(sym.ETIQUETAS, yyline + 1, yycolumn + 1);}
valores 	{return new Symbol(sym.VALORES, yyline + 1, yycolumn + 1);}
unir 		{return new Symbol(sym.UNIR, yyline + 1, yycolumn + 1);}
tipo 		{return new Symbol(sym.TIPO, yyline + 1, yycolumn + 1);}
total 		{return new Symbol(sym.TOTAL, yyline + 1, yycolumn + 1);}
extra 		{return new Symbol(sym.EXTRA, yyline + 1, yycolumn + 1);}
Ejecutar	{return new Symbol(sym.EJECUTAR, yyline + 1, yycolumn + 1);}
Cantidad	{return new Symbol(sym.CANTIDAD, yyline + 1, yycolumn + 1);}
Porcentaje	{return new Symbol(sym.PORCENTAJE, yyline + 1, yycolumn + 1);}
{espacio}|{tab}|{salto}|{rot} {/*Ignore*/}
{COMA}          { return new Symbol(sym.COMA, yyline + 1, yycolumn + 1);  }
"#".* {/*Ignore*/}
"=" 		{ return new Symbol(sym.IGUAL, yyline + 1, yycolumn + 1);}
"+" 		{ return new Symbol(sym.SUMA, yyline + 1, yycolumn + 1, yytext());}
"-" 		{return new Symbol(sym.RESTA, yyline + 1, yycolumn + 1, yytext());}
"*" 		{return new Symbol(sym.MULTIPLICACION, yyline + 1, yycolumn + 1, yytext());}
"/" 		{return new Symbol(sym.DIVISION, yyline+1, yycolumn+1, yytext());}
"(" 		{ return new Symbol(sym.PARENTESIS_ABRE, yyline+1, yycolumn+1, yytext());}
")" 		{return new Symbol(sym.PARENTESIS_CIERRA, yyline+1, yycolumn+1, yytext());}
":" 		{return new Symbol(sym.DOS_PUNTOS, yyline+1, yycolumn+1, yytext());}
";" 		{return new Symbol(sym.PUNTO_COMA, yyline+1, yycolumn+1, yytext());}
"{" 		{return new Symbol(sym.LLAVE_ABRE, yyline+1, yycolumn+1, yytext());}
"}" 		{return new Symbol(sym.LLAVE_CIERRA, yyline+1, yycolumn+1, yytext());}
"[" 		{return new Symbol(sym.CORCHETE_ABRE, yyline+1, yycolumn+1, yytext());}
"]" 		{return new Symbol(sym.CORCHETE_CIERRA, yyline+1, yycolumn+1, yytext());}
{comilla}{L}({L}|{D}|{espacio})*{comilla} 	{ return new Symbol(sym.STRING, yyline + 1, yycolumn + 1, yytext());}
{D}+ 		{return new Symbol(sym.ENTERO, yyline + 1, yycolumn + 1, new Integer(yytext()));}
{D}+{PUNTO}{D}+ {return new Symbol(sym.DECIMAL, yyline + 1, yycolumn + 1, new Integer(yytext()));}
 {PUNTO} 	{return new Symbol(sym.PUNTO, yyline + 1, yycolumn + 1, new Integer(yytext()));}
 
[^]				{}
