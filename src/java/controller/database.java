/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author viresh
 */
public class database {

    public static Connection getMySQLConnection()
         throws ClassNotFoundException, SQLException {
     // Note: Change the connection parameters accordingly.
     String hostName = "localhost";
     String dbName = "optiek_rs";
     String userName = "root";
     String password = "";
     return getMySQLConnection(hostName, dbName, userName, password);
 }
  
 public static Connection getMySQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
    
     Class.forName("com.mysql.jdbc.Driver");
  
     
     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
  
     Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }

}