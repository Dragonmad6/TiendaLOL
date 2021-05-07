/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button tomercado;
    
    @FXML
    public void loadImage1() {
        Image img = new Image(getClass().getResourceAsStream("/images/mates.png"));
        image.setImage(img);
    }
    
    @FXML
    private void atras2() throws IOException {
        App.setRoot("mercado");
    }
}
