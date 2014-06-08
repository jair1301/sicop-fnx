/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sicopFnx.utileria;

/**
 *
 * @author Enrique
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexionMySql {

    private static String ipAddress;
    private static String dbName;
    private static String user;
    private static String password;
    private static String service;
    private static ResourceBundle propiedadesBD;
    public static Connection con;

    /**
     * M�todo que carga el driver, establece la conexi�n.
     *
     * @ return Connection
     *
     */
    public static Connection getConnection() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println(e);
            }

            if (propiedadesBD == null) {
                propiedadesBD = ResourceBundle.getBundle("mysql_sic");
                ipAddress = propiedadesBD.getString("ip_address");
                dbName = propiedadesBD.getString("db_name");
                user = propiedadesBD.getString("user");
                password = propiedadesBD.getString("password");
                service = propiedadesBD.getString("service");
            }
            con = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + service + "/" + dbName, user, password);

        } catch (SQLException ex) {
            Logger.getLogger(conexionMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public static void main(String[] args) {
        System.out.println(conexionMySql.getConnection());
    }

}
