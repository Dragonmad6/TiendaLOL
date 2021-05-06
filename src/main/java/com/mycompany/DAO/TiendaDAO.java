/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.entidades.Objeto;
import com.mycompany.entidades.Usuario;
import com.mycompany.primerproyecto.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Carlos C
 */
public class TiendaDAO {
    
    private Connection conexion;
    

    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        
        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    
    public void desconectar() throws SQLException{
        conexion.close();
    }
    
    /*INSERTS para el usuario*/
    
    public void InsertarUsuario(Usuario u) throws SQLException,ClassNotFoundException, IOException{
        String sql = "INSERT INTO tiendalol.login (nombre,contrasena,email) VALUES(?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getNombre());
        sentencia.setString(2, u.getPassword());
        sentencia.setString(3, u.getEmail());
        sentencia.executeUpdate();
    }
    /*SELECT del usuario para logearse*/
    
    public boolean LogearUsuario (Usuario u) throws SQLException,ClassNotFoundException, IOException{
        String sql = "SELECT * FROM tiendalol.login WHERE nombre = ? AND contrasena = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getNombre());
        sentencia.setString(2, u.getPassword());
        sentencia.executeUpdate();
         
        ResultSet result = sentencia.executeQuery();
        boolean resultado = false;
        while (result.next()){
            resultado = true;
        }
        return resultado;
    }
    /*SELECTS de la lista de objetos que hay en la base de datos*/
    
    public List<Objeto> items() throws SQLException{
        List<Objeto> objetosExterno = new ArrayList<>();
        String sql = "SELECT t.tipo,i.nombre,i.precio,i.descripcion,i.foto FROM items i INNER JOIN tipoitem t ON i.tipo = t.idtipo";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        /*Bucle para mostrar todos los objetos*/
        while (resultado.next()){
            Objeto objetoInterno = new Objeto();
            objetoInterno.setTipo(resultado.getString(1));
            objetoInterno.setNombre(resultado.getString(2));
            objetoInterno.setPrecio(resultado.getString(3));
            objetoInterno.setDescripcion(resultado.getString(4));
            objetoInterno.setImagen(resultado.getString(5));
            objetosExterno.add(objetoInterno);
        }
        return objetosExterno;
    }
    
}
