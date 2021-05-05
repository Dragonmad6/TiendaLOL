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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Carlos C
 */
public class MercadoController{

    @FXML
    private ListView Items;
    private static TiendaDAO a;
    
    @FXML
    public void verLista() throws SQLException {
        Items.setItems(relleno());
        
    }     
    public ObservableList relleno() throws SQLException{
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
        ObservableList<Objeto> recursos = FXCollections.observableArrayList(a.items());
        
        return recursos;
    }
    
}
