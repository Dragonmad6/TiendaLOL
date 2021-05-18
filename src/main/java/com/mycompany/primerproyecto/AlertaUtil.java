/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import javafx.scene.control.Alert;

/**
 * Metodo para mostrar Error e Info
 * En ventana emergente
 * @author Carlos C
 */
public class AlertaUtil {
    public static void mostrarError(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }
    
    public static void mostrarInfo(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
