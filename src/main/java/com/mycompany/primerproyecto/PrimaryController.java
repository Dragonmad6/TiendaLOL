package com.mycompany.primerproyecto;

import com.mycompany.DAO.TiendaDAO;
import com.mycompany.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private TextField name;
    @FXML
    private PasswordField pass;

    @FXML
    private void switchToSecondary() throws IOException {
        App.loadImage2();
    }
    @FXML
    private ImageView imagen;

    @FXML
    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/images/cliente3.jpg"));
        imagen.setImage(img);
    }
    @FXML
    public void mostrar(){
        Image img = new Image(getClass().getResourceAsStream("/images/cliente3.jpg"));
        imagen.setImage(img);
    }
    public void login() throws SQLException, ClassNotFoundException, IOException {
        TiendaDAO tienda = new TiendaDAO();
        Usuario u = new Usuario();

        u = new Usuario(name.getText(), pass.getText());
        try {
            tienda.conectar();
            Usuario us = new Usuario();
            us  = tienda.LogearUsuario(u);
            String nombre = "carlosc";
            String password = "01478520C";

            if(name.getText().equals(nombre) && pass.getText().equals(password)){
                App.loadMercadoAdmin();
            }
            else if(name.getText().equals(us.getNombre()) && pass.getText().equals(us.getPassword())){
              App.loadMercado();
            }
        else{
                AlertaUtil.mostrarError("Nombre de usuario o contraseña incorrecto.");
            }
//            boolean pruebalogin = tienda.LogearUsuario(u);
//            if (pruebalogin) {
//                App.loadMercado();
//            } else {
//                AlertaUtil.mostrarError("Nombre de usuario o contraseña incorrecto.");
//            }
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
