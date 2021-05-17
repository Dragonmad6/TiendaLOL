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
    
    public Usuario LogearUsuario (Usuario u) throws SQLException,ClassNotFoundException, IOException{
        String sql = "SELECT * FROM tiendalol.login WHERE nombre = ? AND contrasena = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getNombre());
        sentencia.setString(2, u.getPassword());
        ResultSet resultado = sentencia.executeQuery();
        Usuario us = new Usuario();

        while(resultado.next()){
            us.setNombre(resultado.getString(2));
            us.setPassword(resultado.getString(3));
        }
        return us;
    }
    /*Coger el id*/
    public int SelectIdUsuario (Usuario u) throws SQLException{
        String sql = "SELECT idusuario FROM tiendalol.login WHERE nombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getNombre());
        ResultSet resultado = sentencia.executeQuery();
        int idusuario = 0;
        while(resultado.next()){
            idusuario = resultado.getInt(1);
        }
        return idusuario;        
    }
    /*UPDATE de la contraseña del usuario normal*/
    public void ActualizarContra (Usuario u, String contrasenaAntigua) throws SQLException{
        String sql = "UPDATE tiendalol.login SET contrasena = ? WHERE contrasena = ? AND nombre = ? ";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getPassword());
        sentencia.setString(2, contrasenaAntigua);
        sentencia.setString(3, u.getNombre());
        sentencia.executeUpdate();
    }
    /*DELETE usuario*/
    public void EliminarUSUARIO (int idusuario) throws SQLException{
        String sql = "DELETE FROM tiendalol.login WHERE idusuario = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, idusuario);
        sentencia.executeUpdate();
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
//   Inserta un objeto con sus caracteristicas en la BD
    public void InsertarObjeto (Objeto o) throws SQLException{
        String sql = "INSERT INTO tiendalol.items (tipo,nombre,precio,descripcion,foto) VALUES (?,?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, o.getTipo());
        sentencia.setString(2, o.getNombre());
        sentencia.setString(3, o.getPrecio());
        sentencia.setString(4, o.getDescripcion());
        sentencia.setString(5, o.getImagen());
        sentencia.executeUpdate();
    }
// Coger el id
    public int SelectId (Objeto o) throws SQLException{
        String sql = "SELECT id FROM items WHERE nombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, o.getNombre());
        ResultSet resultado = sentencia.executeQuery();
        int id = 0;
        while(resultado.next()){
            id = resultado.getInt(1);
        }
        return id;        
    }
    /*DELETE un objeto*/
    public void EliminarObjeto (int id) throws SQLException{
        String sql = "DELETE FROM tiendalol.items WHERE id = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        sentencia.executeUpdate();
    }
//    Update para editar el precio
    public void EditarPrecioObjeto (Objeto o, int id) throws SQLException{
        String sql = "UPDATE tiendalol.items SET precio = ? WHERE id = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, o.getPrecio());
        sentencia.setInt(2, id);
        sentencia.executeUpdate();
    }
    
//   Buscador de Objeto
    public Objeto BuscarObjeto (String nombre) throws SQLException{
        String sql = "SELECT * FROM tiendalol.items WHERE nombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        Objeto o = new Objeto();
        while(resultado.next()){
            o.setId(resultado.getInt(1));
            o.setTipo(resultado.getString(2));
            o.setNombre(resultado.getString(3));
            o.setDescripcion(resultado.getString(4));
            o.setImagen(resultado.getString(5));
        }
        return o;  
    }
}
