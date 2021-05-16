    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import com.mycompany.DAO.TiendaDAO;
import com.mycompany.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Carlos C
 */
public class OpcionesController {

    @FXML
    private ImageView image;
    @FXML
    private TextField anti;
    @FXML
    private TextField newcontra;
    @FXML
    private TextField name;

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
    private void Hyper(ActionEvent e) {
        Hyperlink link = new Hyperlink("/Formulario/Formulario.html");
        App.class.getResource("/Formulario/Formulario.html");
    }

    @FXML
    private void actualiza() throws IOException, SQLException {
        TiendaDAO tienda = new TiendaDAO();
        Usuario u = new Usuario();
        String contrasenaAntigua = anti.getText();
        try {
            tienda.conectar();
            u.setNombre(name.getText());
            u.setPassword(newcontra.getText());
            tienda.ActualizarContra(u, contrasenaAntigua);
            if (anti.getText() == "") {
                AlertaUtil.mostrarError("Debe rellenar los siguientes campos (establecer contraseña).");
            }
            if (newcontra.getText() == "") {
                AlertaUtil.mostrarError("Debe rellenar los siguientes campos (Debe rellenar este campo (Nueva contraseña)).");
            } else {
                AlertaUtil.mostrarInfo("La contraseña ha sido actualizado");
            }

        } catch (ClassNotFoundException cnfe) {
            AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
        } catch (SQLException sqle) {
            AlertaUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
        } catch (IOException ioe) {
            AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
        } finally {
            tienda.desconectar();
        }
    }

    @FXML
    public void eliminarUsuario() throws SQLException, ClassNotFoundException, IOException {
        TiendaDAO tienda = new TiendaDAO();
        Usuario u = new Usuario();

        try {
            tienda.conectar();
            if (name.getText() == "") {
                AlertaUtil.mostrarError("Debe de completar el campo 'Nombre de usuario'");
            } else {
                u.setNombre(name.getText());
                tienda.EliminarUSUARIO(tienda.SelectIdUsuario(u));
                AlertaUtil.mostrarInfo("El usuario ha sido eliminado correctamente");
                App.setRoot("primary");
            }

        } catch (ClassNotFoundException cnfe) {
            AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
        } catch (IOException ioe) {
            AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
        } finally {
            tienda.desconectar();
        }
    }
}
