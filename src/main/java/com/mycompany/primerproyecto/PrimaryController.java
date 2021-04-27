package com.mycompany.primerproyecto;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.mycompany.primerproyecto.Usuario;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private TextField name;
    @FXML
    private Label resusuario;
    @FXML
    private PasswordField pass;

    @FXML
    private void switchToSecondary() throws IOException {
        App.loadImage2();
    }
    @FXML
    private ImageView imagen;

    @FXML
    private void verificar() {
        String usuario = name.getText();
        String password = pass.getText();
        Usuario u = new Usuario();
        boolean comp = u.nombreUsuario(usuario);
        boolean comp2 = u.passwordtrue(password);

        if (comp) {
            resusuario.setText("Inicio de sesion correcto");
            if (comp2) {
                resusuario.setText("Contraseña correcta");
            } else {
                resusuario.setText("La contraseña es incorrecta");
            }
        } else {
            resusuario.setText("El nombre de usuario es incorrecto");
        }
    }

    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/images/cliente3.jpg"));
        imagen.setImage(img);
    }
}
