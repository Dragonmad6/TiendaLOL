/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import com.mycompany.DAO.TiendaDAO;
import com.mycompany.entidades.Objeto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Carlos C
 */
public class MercadoController{

    @FXML
    private ListView lista;
    @FXML
    private TextArea descrip;
    @FXML
    private TextField precio;
    
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
        precio.setText(obj.getPrecio());
        descrip.setText(obj.getDescripcion());
    }
    
    @FXML
    public void seleccionarObjeto(Event event) {
        objSel = (Objeto)lista.getSelectionModel().getSelectedItem();
        cargarObjeto(objSel);
    }
    
}
