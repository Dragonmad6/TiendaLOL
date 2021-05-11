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
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Carlos C
 */
public class AdminController{
    
    @FXML
    private TextField type;
    @FXML
    private TextField name;
    @FXML
    private TextField price;
    @FXML
    private TextArea descript;
    @FXML
    private TextField vimage;
    @FXML
    private ImageView image;
    
    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/images/Garen.png"));
        image.setImage(img);
    }
    
    @FXML
    public void atras3() throws IOException, SQLException{
        App.loadMercadoAdmin();
    }
    @FXML
    public void insertar() throws SQLException{
       TiendaDAO tienda = new TiendaDAO();
       Objeto o = new Objeto();
                    
     
            try{
            o = new Objeto(type.getText(), name.getText(), price.getText(), descript.getText(), vimage.getText());
            tienda.conectar();
            tienda.InsertarObjeto(o);
            AlertaUtil.mostrarInfo("Se ha insertado el objeto correctamente.");
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

   
//   public void eliminar() throws SQLException{
//       TiendaDAO tienda = new TiendaDAO();
//       Objeto o = new Objeto();
//       
//        try{
//            o = new Objeto(name.getText());
//            tienda.conectar();
//            tienda.EliminarObjeto(o);
//            AlertaUtil.mostrarInfo("El objeto ha sido eliminado correctamente");
//        }catch{
//            AlertaUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
//        }
//        tienda.desconectar();
//   }

   @FXML
   public void eliminar() throws SQLException, ClassNotFoundException, IOException{
       TiendaDAO tienda = new TiendaDAO();
       Objeto o = new Objeto();
       
        try{
            tienda.conectar();
            o.setNombre(name.getText());
            tienda.EliminaridObjeto(tienda.EliminarObjeto(o));
            
            AlertaUtil.mostrarInfo("El objeto ha sido eliminado correctamente");
 
        }catch (ClassNotFoundException cnfe){
                AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
        }catch (IOException ioe){
                AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
        }finally{
            tienda.desconectar();
        }
   }

}
