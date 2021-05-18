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
public abstract class Cosa {
    private String nombre;
    private String precio;
    private String descripcion;

    /**
     * Constructor VACIO
     */
    public Cosa() {
    }
    
    /**
     * Constructor con PARAMETROS
     * @param nombre
     * @param precio
     * @param descripcion 
     */
    public Cosa(String nombre, String precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    /**
     * GETTERS & SETTERS
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
