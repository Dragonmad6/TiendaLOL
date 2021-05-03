/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.entidades.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos C
 */
public class TiendaDAO {
    
    private Connection conexion;
    
    public void conectar() throws ClassNotFoundException, SQLException, IOException{
        String host = "localhost";
        String port = "3306";
        String dbname = "tiendalol";
        String username = "root";
        String password = "01478520";
            conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + dbname + "?serverTimezone=UTC",
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
}
