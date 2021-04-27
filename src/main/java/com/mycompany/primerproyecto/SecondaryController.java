package com.mycompany.primerproyecto;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SecondaryController {
    
    @FXML
    private TextField name;
    @FXML
    private Label resusuario;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField correo;
    @FXML
    private ImageView imagen;
    
    @FXML
    private void inicio() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void registar() throws IOException {
    }
    
    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/images/register1.png"));
        imagen.setImage(img);
    }
}