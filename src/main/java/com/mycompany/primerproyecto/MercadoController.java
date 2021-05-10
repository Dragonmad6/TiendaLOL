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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MercadoController{

    
    @FXML
    private ListView lista;
    @FXML
    private TextArea descripcion;
    @FXML
    private TextField precio;
    @FXML
    private ImageView imagen;
    
    
    private static TiendaDAO a;
    private Objeto objSel;
    

    public void relleno() throws SQLException{
        TiendaDAO a = new TiendaDAO();
        try {
            a.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(MercadoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MercadoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MercadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Objeto> recursos = a.items();
        lista.setItems(FXCollections.observableList(recursos));
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
        objSel = (Objeto)lista.getSelectionModel().getSelectedItem();
        cargarObjeto(objSel);
    }
    @FXML
    private void atras() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void opciones() throws IOException {
        App.loadOpciones();
    }
    
}
