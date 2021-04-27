/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
        String dbname = "blockbuster";
        String username = "root";
        String password = "01478520";
        
        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + 
                dbname+ "?serverTimezone=UTC",username,password);
    }
    
    public void desconectar() throws SQLException{
        conexion.close();
    }
}
