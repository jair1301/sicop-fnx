/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sicopFnx.usuarios.dao;

import com.sicopFnx.usuarios.bean.UsuarioBean;
import com.sicopFnx.utileria.conexionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Enrique
 */
public class UsuarioDAO {
    
public static String SqlAltaUsuario = "INSERT INTO usuario VALUES ( null, ?, ?, ?, ?);";
    public static String SqlBajaUsuario = "DELETE FROM usuario WHERE idusuario=?;";
    public static String SqlModificarUsuario = "UPDATE usuario SET nombre=?, apellido=?, sexo=?, password=?, usuario=? WHERE idusuario=?;";
    public static String SqlSelectTodosUsuario = "SELECT * FROM usuario";

    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    
    public UsuarioBean ConsultaUsuarioIndividual(int UsuarioId){
    
            UsuarioBean uno = new UsuarioBean();
    
        try {
            con = conexionMySql.getConnection();
            pstm = con.prepareStatement(SqlSelectTodosUsuario+" where idusuario=?;");
            pstm.setInt(1, UsuarioId);
            
            rs=pstm.executeQuery();
            while(rs.next()){
            
            uno.setIdUsuario(rs.getInt("idusuario"));
            uno.setNombre(rs.getString("nombre"));
            uno.setApellido(rs.getString("apellido"));
            uno.setPassword(rs.getString("password"));
            uno.setLogin(rs.getString("login"));
            
            System.out.println(uno.getIdUsuario());
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return uno;
    }

    public boolean altaUsuario(UsuarioBean BeanUsuario) {

        boolean respuesta = false;

        try {
            con = conexionMySql.getConnection();
            pstm = con.prepareStatement(SqlAltaUsuario);
            pstm.setString(1, BeanUsuario.getNombre());
            pstm.setString(2, BeanUsuario.getApellido());
            pstm.setString(3, BeanUsuario.getLogin());
            pstm.setString(4, BeanUsuario.getPassword());
            
            respuesta=pstm.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
    
    public boolean bajaUsuario(int x){
    
    
        boolean respuesta = false;

        try {
            con = conexionMySql.getConnection();
            pstm = con.prepareStatement(SqlBajaUsuario);
            pstm.setInt(1, x);
            
            respuesta=pstm.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
    
    public List consultaUsuario(){
       
        List <UsuarioBean> respuesta= new ArrayList();
        try {
            con = conexionMySql.getConnection();
            pstm = con.prepareStatement(SqlSelectTodosUsuario);
            
            rs=pstm.executeQuery();
            while(rs.next()){
            
            UsuarioBean uno = new UsuarioBean();
            uno.setIdUsuario(rs.getInt("idusuario"));
            uno.setNombre(rs.getString("nombre"));
            uno.setApellido(rs.getString("apellido"));
             uno.setPassword(rs.getString("password"));
            uno.setLogin(rs.getString("usuario"));
            
            respuesta.add(uno);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    
    
    }
    
    public boolean modificarUsuario(UsuarioBean BeanUsuario){
    
        boolean respuesta = false;

        try {
            con = conexionMySql.getConnection();
            pstm = con.prepareStatement(SqlModificarUsuario);
            pstm.setString(1, BeanUsuario.getNombre());
            pstm.setString(2, BeanUsuario.getApellido());
            pstm.setString(4, BeanUsuario.getPassword());
            pstm.setString(5, BeanUsuario.getLogin());
            pstm.setInt(6, BeanUsuario.getIdUsuario());
            respuesta=pstm.execute();
            
            System.out.println(pstm);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
        
    
    }
    
    
    
    public static void main(String[] args) {
           }
    

}
