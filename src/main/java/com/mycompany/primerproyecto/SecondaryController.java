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
    /**
     * Metodo para cambiar de Ventana a PRIMARY
     */
    private void inicio() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML    
    /**
     * Metodo para cargar la imagen según la Ruta
     */
    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/images/register1.png"));
        imagen.setImage(img);
    }
    
    @FXML
    /**
     * Metodo de Registrarse como usuario nuevo
     * Rellenar los TextFields
     * Cumpliendo con los requisitos
     */
    public void registrarse() throws SQLException{
       TiendaDAO tienda = new TiendaDAO();
       Usuario u = new Usuario();
       
        boolean pruebanombre;
        boolean pruebapassword;
        boolean pruebaemail;

    
    
        if(u.nombreUsuario(name.getText())){
           pruebanombre = true; 
        }else{
           pruebanombre = false;
           AlertaUtil.mostrarError("Error en el nombre de usuario: Debe tener + de 4 caracteres.");
        }
        if(u.passwordtrue(pass.getText())){
            pruebapassword = true;
        }else{
            pruebapassword = false;
            AlertaUtil.mostrarError("Error en la contraseña: Menor de 11 caracteres.");
        }
        if(u.emailVerificado(correo.getText())){
            pruebaemail = true;
        }else{
            pruebaemail = false;
            AlertaUtil.mostrarError("Error de correo: Recuerda introducirlo con el simbolo de @ y no introducir otro tipo de caracteres especiales.");
        }
        
        if(pruebanombre && pruebapassword && pruebaemail){
            try{
            u = new Usuario(name.getText(), pass.getText(), correo.getText());
            tienda.conectar();
            tienda.InsertarUsuario(u);
            AlertaUtil.mostrarInfo("Usuario registrado.");
            }catch (SQLException sqle){
            AlertaUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
            }catch (ClassNotFoundException cnfe){
                AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
            }catch (IOException ioe){
                AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
            }finally {
                tienda.desconectar();
            }
        }
   }
}