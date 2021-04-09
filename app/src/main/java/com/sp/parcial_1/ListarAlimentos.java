package com.sp.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Clases.Producto;

public class ListarAlimentos extends AppCompatActivity implements View.OnClickListener{

    public static ArrayList<Producto> listado = new ArrayList();

    private ListView txtLista;
    private Button btnVolver;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alimentos);
        AgregarAlimento agregar = new AgregarAlimento();
        listado = agregar.productos;
        txtLista = findViewById(R.id.txtLista);
        btnVolver = findViewById(R.id.btnVolver);
        btnInicio = findViewById(R.id.btnInicio);
        btnVolver.setOnClickListener(this);
        btnInicio.setOnClickListener(this);
        ArrayAdapter<Producto> adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,recorreLista(listado));
        txtLista.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnVolver) {
            Intent intent= new Intent(this,AgregarAlimento.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnInicio) {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

    public List<String> recorreLista(List<Producto> list){
        ArrayList<String> listadoProductos = new ArrayList();
        for (int i=0;i<list.size();i++){
            listadoProductos.add(list.get(i).getNombre()+" "+list.get(i).getCodigo()+" $ "+list.get(i).getValor()
                    +" "+list.get(i).getIva()+" "+list.get(i).getDescripcion()+" "+list.get(i).getCategoria());
        }
        return listadoProductos;
    }
}
