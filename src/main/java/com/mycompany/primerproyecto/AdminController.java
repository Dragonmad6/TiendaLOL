/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Carlos C
 */
public class AdminController{

    @FXML
    private ImageView image;
    
    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/images/Garen.png"));
        image.setImage(img);
    }
    
    @FXML
    public void atras3() throws IOException, SQLException{
        App.loadMercadoAdmin();
    }
}
