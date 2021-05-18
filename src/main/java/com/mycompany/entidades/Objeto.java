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
    
    /**
     * Constructor VACIO
     */
    public Objeto() {
    }
    
    /**
     * Constructor con PARAMETROS
     * @param tipo
     * @param id
     * @param imagen 
     */
    public Objeto(String tipo,int id,String imagen) {
        this.tipo = tipo;
        this.id = id;
        this.imagen = imagen;
    }
    /**
     * Constructor con PARAMETROS
     * @param tipo
     * @param nombre
     * @param precio
     * @param descripcion
     * @param imagen 
     */
    public Objeto(String tipo,String nombre , String precio,String descripcion,String imagen) {
        super(nombre, precio, descripcion);
        this.tipo = tipo;
        this.imagen = imagen;
    }
    /**
     * GETTERS & SETTERS
     * @return 
     */
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
    
    /**
     * To STRING
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(tipo);
        sb.append(" | ").append(getNombre());
        return sb.toString();
    }

}
