/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

/**
 *
 * @author Carlos C
 */
public class Objeto extends Cosa {
    private String tipo;
    private int id;
    private String imagen;
    
    public Objeto() {
    }

//    public Objeto(String tipo, String nombre, String precio, String descripcion, String imagen) {
//        this.tipo = tipo;
//        this.nombre = nombre;
//        this.precio = precio;
//        this.descripcion = descripcion;
//        this.imagen = imagen;
//    }

    public Objeto(String tipo,int id,String imagen) {
        this.tipo = tipo;
        this.id = id;
        this.imagen = imagen;
    }

    public Objeto(String tipo,String nombre , String precio,String descripcion,String imagen) {
        super(nombre, precio, descripcion);
        this.tipo = tipo;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(tipo);
        sb.append(" | ").append(getNombre());
        return sb.toString();
    }

}
