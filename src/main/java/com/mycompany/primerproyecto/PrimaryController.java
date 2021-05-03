package com.mycompany.primerproyecto;

import com.mycompany.DAO.TiendaDAO;
import com.mycompany.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

    public void login() throws SQLException, ClassNotFoundException, IOException {
        TiendaDAO tienda = new TiendaDAO();
        Usuario u = new Usuario();

        u = new Usuario(name.getText(), pass.getText());
        try {
            tienda.conectar();
            boolean pruebalogin = tienda.LogearUsuario(u);
            if (pruebalogin) {
                App.setRoot("mercado");
            } else {
                AlertaUtil.mostrarError("Nombre de usuario o contraseña incorrecto.");
            }
        } catch (SQLException sqle) {
            AlertaUtil.mostrarError("El nombre o contraseña son incorrectos." + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
        } catch (IOException ioe) {
            AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
        } finally {
            tienda.desconectar();
        }
    }
}
