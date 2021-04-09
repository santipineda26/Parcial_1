package Clases;

public class Producto {

    private String Nombre;
    private String Codigo;
    private int Valor;
    private String Iva;
    private String Descripcion;
    private String Categoria;

    public Producto(){

    }

    public Producto(String nombre, String codigo, int valor, String iva, String descripcion, String categoria) {
        Nombre = nombre;
        Codigo = codigo;
        Valor = valor;
        Iva = iva;
        Descripcion = descripcion;
        Categoria = categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int valor) {
        Valor = valor;
    }

    public String getIva() {
        return Iva;
    }

    public void setIva(String iva) {
        Iva = iva;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
