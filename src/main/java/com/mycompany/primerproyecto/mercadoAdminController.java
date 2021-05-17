/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import com.mycompany.DAO.TiendaDAO;
import com.mycompany.entidades.Objeto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Carlos C
 */
public class mercadoAdminController {

    @FXML
    private ListView lista;
    @FXML
    private TextArea descripcion;
    @FXML
    private TextField precio;
    @FXML
    private ImageView imagen;
    @FXML
    private TextField look;

    private static TiendaDAO a;
    private Objeto objSel;
    private List<Objeto> recursos;

    public void relleno() throws SQLException {
        TiendaDAO a = new TiendaDAO();
        lista.getItems().clear();
        try {
            a.conectar();
            List<Objeto> recursos = a.items();
            lista.setItems(FXCollections.observableList(recursos));
        } catch (SQLException sqle) {
            AlertaUtil.mostrarError("El nombre o contraseña son incorrectos." + sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
        } catch (IOException ioe) {
            AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
        } finally {
            a.desconectar();
        }

    }

    @FXML
    private void cargarObjeto(Objeto obj) {
        Image img = new Image(getClass().getResourceAsStream(obj.getImagen()));
        precio.setText(obj.getPrecio());
        descripcion.setText(obj.getDescripcion());
        imagen.setImage(img);
    }

    @FXML
    public void seleccionarObjeto(Event event) {
        objSel = (Objeto) lista.getSelectionModel().getSelectedItem();
        cargarObjeto(objSel);
    }

    @FXML
    private void atras() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void opciones() throws IOException {
        App.loadAdmin();
        AlertaUtil.mostrarInfo("Recuerde que al eliminar un objeto solo requiere su nombre.");
    }

//    @FXML
//    private void search() throws IOException, SQLException {
//        TiendaDAO a = new TiendaDAO();
//        lista.getItems().clear();
//        try {
//            a.conectar();
//            look.getText();
//            List<Objeto> recursos = a.BuscarObjeto();
//            lista.setItems(FXCollections.observableList(recursos));
//        } catch (SQLException sqle) {
//            AlertaUtil.mostrarError("El nombre o contraseña son incorrectos." + sqle.getMessage());
//        } catch (ClassNotFoundException cnfe) {
//            AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
//        } catch (IOException ioe) {
//            AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
//        } finally {
//            a.desconectar();
//        }
//
//    }


}
