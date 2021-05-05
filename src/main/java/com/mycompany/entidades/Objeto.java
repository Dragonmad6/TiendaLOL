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
public class Objeto {
    private String tipo;
    private String nombre;

    public Objeto() {
    }
    
    public Objeto(String nombre, String tipo){
        this.nombre  = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Objeto{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
}
