/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primerproyecto;

import com.mycompany.DAO.TiendaDAO;
import com.mycompany.entidades.Objeto;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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
    
    /**
     * Metodo para cargar la imagen del ImageView
     */
    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/images/Garen.png"));
        image.setImage(img);
    }
    
    @FXML
    /**
     * Metodo para cargar la ventana de MERCADOADMIN
     */
    public void atras3() throws IOException, SQLException{
        App.loadMercadoAdmin();
    }
    @FXML
    /**
     * Metodo para INSERTAR un objeto nuevo
     * Rellena los TextField
     */
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


   @FXML
   /**
    * Metodo para ELIMINAR un Objeto de la BD
    * Con poner su nombre en el TextField
    */
   public void eliminar() throws SQLException, ClassNotFoundException, IOException{
       TiendaDAO tienda = new TiendaDAO();
       Objeto o = new Objeto();
       
        try{
            tienda.conectar();
            o.setNombre(name.getText());
            tienda.EliminarObjeto(tienda.SelectId(o));
            
            AlertaUtil.mostrarInfo("El objeto ha sido eliminado correctamente");
 
        }catch (ClassNotFoundException cnfe){
                AlertaUtil.mostrarError("Error al iniciar la aplicación" + cnfe.getMessage());
        }catch (IOException ioe){
                AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
        }finally{
            tienda.desconectar();
        }
   }
   @FXML
   /**
    * Metodo para Editar un Objeto segun su PRECIO
    * Poner el nombre del OBJETO y su PRECIO
    */
   public void editar() throws SQLException, ClassNotFoundException, IOException{
       TiendaDAO tienda = new TiendaDAO();
       Objeto o = new Objeto();
       int id = 0;
       try{
            tienda.conectar();
            o.setNombre(name.getText());
            o.setPrecio(price.getText());
            id = tienda.SelectId(o);
            tienda.EditarPrecioObjeto(o,id);
            if(name.getText() == ""){
                AlertaUtil.mostrarError("Debe rellenar los siguientes campos (nombre y precio).");
            }
            if(price.getText() == ""){
                AlertaUtil.mostrarError("Debe rellenar los siguientes campos (nombre y precio).");
            }else{
                AlertaUtil.mostrarInfo("El precio ha sido actualizado");
            }         
 
        }catch (ClassNotFoundException cnfe) {
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
   /**
    * Metodo para leer un FICHERO
    * Seleccionar el archivo y se guarda en su RUTA
    */
    public void leerFicheroImagen(){

        FileChooser dialogoFichero1 = new FileChooser();
        dialogoFichero1.setTitle("Selecciona un fichero");
        File fAbrir1 = dialogoFichero1.showOpenDialog(null);

        if (fAbrir1 != null) {
            vimage.setText("/objetoimagenes/"+fAbrir1.getName());
            try {
                Files.copy(fAbrir1.toPath(), (new File(System.getProperty("user.dir")+"/src/main/resources/objetoimagenes/" + fAbrir1.getName())).toPath(),
                        StandardCopyOption.REPLACE_EXISTING); //copia
            } catch (IOException ioe) {
                AlertaUtil.mostrarError("Error al cargar la aplicación" + ioe.getMessage());
            }
        } 
    }
}
