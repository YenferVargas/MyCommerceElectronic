package com.example.mycommerceelectronic.modelos;

public class NuevoProductoModelo {

    String descripcion;
    String nombre;
    String valoracion;
    int precio;
    String img_url;

    public NuevoProductoModelo(){

    }

    public NuevoProductoModelo(String descripcion, String nombre, String valoracion, int precio, String img_url) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.valoracion = valoracion;
        this.precio = precio;
        this.img_url = img_url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
