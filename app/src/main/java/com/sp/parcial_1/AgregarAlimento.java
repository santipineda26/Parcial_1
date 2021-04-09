package com.sp.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;

import Clases.Producto;

import static java.lang.Integer.parseInt;

public class AgregarAlimento extends AppCompatActivity implements View.OnClickListener {

    Producto producto = new Producto();

    public static ArrayList<Producto> productos = new ArrayList();

    private Button btnAgregar;
    private Button btnInicio;
    private EditText txtNombre;
    private EditText txtCodigo;
    private EditText txtValor;
    private EditText txtIva;
    private EditText txtDescripcion;
    private EditText txtCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alimento);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnInicio = findViewById(R.id.btnInicio);
        txtNombre = findViewById(R.id.txtNombre);
        txtCodigo = findViewById(R.id.txtCodigo);
        txtValor = findViewById(R.id.txtValor);
        txtIva = findViewById(R.id.txtIva);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtCategoria = findViewById(R.id.txtCategoria);
        btnInicio.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar) {
            String nombre = txtNombre.getText().toString();
            String codigo = txtCodigo.getText().toString();
            String valor = txtValor.getText().toString();
            String iva = txtIva.getText().toString();
            String descripcion = txtDescripcion.getText().toString();
            String categoria = txtCategoria.getText().toString();
            if (nombre.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Error al validar el Nombre", R.layout.custom_toast).show();
                return;
            }
            if (codigo.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Error al validar el Código", R.layout.custom_toast).show();
                return;
            }
            if (valor.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Error al validar el Valor", R.layout.custom_toast).show();
                return;
            }
            if (iva.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Error al validar el IVA", R.layout.custom_toast).show();
                return;
            }
            if (descripcion.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Error al validar la Descripción", R.layout.custom_toast).show();
                return;
            }
            if (categoria.isEmpty()) {
                CustomToastView.makeErrorToast(this, "Error al validar la Categoría", R.layout.custom_toast).show();
                return;
            }

            Producto nuevoProducto;
            nuevoProducto = new Producto();
            nuevoProducto.setNombre(nombre);
            nuevoProducto.setCodigo(codigo);
            nuevoProducto.setValor(parseInt(valor));
            nuevoProducto.setIva(iva);
            nuevoProducto.setDescripcion(descripcion);
            nuevoProducto.setCategoria(categoria);

            productos.add(nuevoProducto);
            Intent intent = new Intent(this, ListarAlimentos.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnInicio) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }
}
