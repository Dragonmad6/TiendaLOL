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
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String password;
    private String email;
    
    /**
     * Constructor VACIO
     */
    public Usuario(){
    }
    /**
     * Constructor con PARAMETROS
     * @param idUsuario
     * @param nombre
     * @param password
     * @param email 
     */
    public Usuario(int idUsuario,String nombre, String password, String email){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
        this.email  = email;
    }
    /**
     * Constructor con PARAMETROS
     * @param nombre
     * @param password
     * @param email 
     */
    public Usuario(String nombre, String password, String email){
        this.nombre = nombre;
        this.password = password;
        this.email  = email;
    }
    /**
     * Constructor con PARAMETROS
     * @param nombre
     * @param password 
     */
    public Usuario(String nombre, String password){
        this.nombre = nombre;
        this.password = password;
    }
    /**
     * GETTERS & SETTERS
     * @return 
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {    
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Metodo de caracteristicas que debe tener el NOMBRE DE USUARIO
     * @param nombre
     * @return 
     */
    public boolean nombreUsuario(String nombre){
        if (nombre.length()>=4){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Metodo de caracteristicas que debe tener la CONTRASEÑA
     * @param password
     * @return 
     */
    public boolean passwordtrue(String password){
        if(password.length() <= 10){
            if(password.matches(".*[A-Z].*")){
            }
            return true;
        }else{
            return false;
        }
        //tambien es posible con un "return email.matches(.*@.*) ? 0:1;"
    }
    /**
     * Metodo de VERIFICACION de las caracteristicas de un correo
     * @param email
     * @return 
     */
    public boolean emailVerificado(String email){
        if(email.matches("[-\\w\\.]+@\\w+\\.\\w+")){
            return true;
        }else{
            return false;
        }
    }
}
