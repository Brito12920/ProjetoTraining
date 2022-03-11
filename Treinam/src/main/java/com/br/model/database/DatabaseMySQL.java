/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.model.database;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author fschi
 */
public abstract class DatabaseMySQL implements Database{
    
    Connection connection;
    
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
    @Override
//    public Connection conectar()
//    {
//        try
//        {
//            forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = getConnection("jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database);
//            return connection;
//           
//        }
//        catch(SQLException | ClassNotFoundException ex)
//        {
//            showMessageDialog(null, "Não foi possível conectar ao banco MySql: " + ex);
//            return null;
//        }
//    }
    
   public Connection conectar()  {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           //     System.out.println("Instalou driver");
          } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }

       
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           return null;
     }

     public void closeConnection() throws SQLException {

          connection.close();
     }
    
}
