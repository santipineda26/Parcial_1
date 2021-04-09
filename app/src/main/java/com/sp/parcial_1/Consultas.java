package com.sp.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Clases.Producto;

public class Consultas extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<Producto> listadoConsultas = new ArrayList();

    private Button btnIva;
    private Button btnSinIva;
    private Button btnCaros;
    private Button btnBaratos;
    private Button btnPromedio;
    private Button btnInicio;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        AgregarAlimento agregar = new AgregarAlimento();
        listadoConsultas = agregar.productos;
        btnIva = findViewById(R.id.btnIva);
        btnSinIva = findViewById(R.id.btnSinIva);
        btnCaros = findViewById(R.id.btnCaros);
        btnBaratos = findViewById(R.id.btnBaratos);
        btnPromedio = findViewById(R.id.btnPromedio);
        btnInicio = findViewById(R.id.btnInicio);
        txtResultado = findViewById(R.id.txtResultado);
        btnIva.setOnClickListener(this);
        btnSinIva.setOnClickListener(this);
        btnCaros.setOnClickListener(this);
        btnBaratos.setOnClickListener(this);
        btnPromedio.setOnClickListener(this);
        btnInicio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnIva) {
            productoIva(listadoConsultas);
        }
        if (v.getId() == R.id.btnSinIva) {
            productoSinIva(listadoConsultas);
        }
        if (v.getId() == R.id.btnCaros) {
            productosCaros(listadoConsultas);
        }
        if (v.getId() == R.id.btnBaratos) {
            productosBaratos(listadoConsultas);
        }
        if (v.getId() == R.id.btnPromedio) {
            promedioProductos(listadoConsultas);
        }
        if (v.getId() == R.id.btnInicio) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

    }

    public void productoIva(List<Producto> lista){
        for (int i=0;i<lista.size();i++){
            if(lista.get(i).getIva().equals("S")){
                String producto= lista.get(i).getNombre()+" "+lista.get(i).getValor();
                txtResultado.setText(txtResultado.getText().toString()+"\n"+producto);
            }
        }
    }

    public void productoSinIva(List<Producto> lista){
        for (int i=0;i<lista.size();i++){
            if(lista.get(i).getIva().equals("N")){
                String producto= lista.get(i).getNombre()+" "+lista.get(i).getValor();
                txtResultado.setText(txtResultado.getText().toString()+"\n"+producto);
            }
        }
    }

    public void productosCaros(List<Producto> lista){
        List<Producto> precios = new ArrayList();
        Collections.sort(lista, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return new Integer(o2.getValor()).compareTo(new Integer(o1.getValor()));
            }
        });

        for (int i=0;i<lista.size();i++){
            String producto= lista.get(i).getNombre()+" "+lista.get(i).getValor();
            txtResultado.setText(txtResultado.getText().toString()+"\n"+producto);
        }
        precios = lista;

    }

    public void productosBaratos(List<Producto> lista){
        List<Producto> precios = new ArrayList();
        Collections.sort(lista, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return new Integer(o1.getValor()).compareTo(new Integer(o2.getValor()));
            }
        });

        for (int i=0;i<lista.size();i++){
            String producto= lista.get(i).getNombre()+" "+lista.get(i).getValor();
            txtResultado.setText(txtResultado.getText().toString()+"\n"+producto);
        }
        precios = lista;

    }

    public void promedioProductos(List<Producto> list){
        int valor = 0;
        int promedio = 0;
        for (int i=0;i<list.size();i++){
            promedio = promedio + list.get(i).getValor();
        }
        int tamaño = list.size();
        int prom = promedio / tamaño;
        String resultado = "Promedio \n"+ " $ "+prom;
        txtResultado.setText(resultado);
    }
}
