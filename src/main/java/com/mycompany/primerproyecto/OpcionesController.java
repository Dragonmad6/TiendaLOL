/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Carlos C
 */
public class OpcionesController{

    
    @FXML
    private ImageView image;
    
    
    @FXML
    public void loadImage1() {
        Image img = new Image(getClass().getResourceAsStream("/images/mates.png"));
        image.setImage(img);
    }
    
    @FXML
    private void atras2() throws IOException, SQLException {
        App.loadMercado();
    }
    
    @FXML
    private void Hyper(ActionEvent e){
        Hyperlink link = new Hyperlink("/Formulario/Formulario.html");
        App.class.getResource("/Formulario/Formulario.html");
        
    }
}
