package com.sp.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAgregar;
    private Button btnListado;
    private Button btnConsultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnListado = findViewById(R.id.btnListado);
        btnConsultas = findViewById(R.id.btnConsultas);
        btnAgregar.setOnClickListener(this);
        btnListado.setOnClickListener(this);
        btnConsultas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar) {
            Intent intent= new Intent(this,AgregarAlimento.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnListado) {
            Intent intent= new Intent(this,ListarAlimentos.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnConsultas) {
            Intent intent= new Intent(this,Consultas.class);
            startActivity(intent);
        }

    }
}
