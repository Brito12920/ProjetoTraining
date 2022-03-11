
package com.br.model.database;

import static java.lang.Class.forName;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author fschi
 */
public class DatabasePostgreSQL {
    
     private Connection connection;
    
    public Connection conectar()
    {
        try
        {
            forName("org.postgresql.Driver");
            this.connection = getConnection("jdbc:postgresql://", "usuario", "senha");
            return this.connection;
            
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            showMessageDialog(null, "Não foi possível conectar ao banco MySql: " + ex);
            return null;
        }
    }
    
    public Connection desconectar(Connection connection)
    {
        try
        {
            connection.close();
            
        }
        catch(SQLException ex)
        {
            showMessageDialog(null, "Não foi possível desconectar do banco MySql: " + ex);
            return null;
        }
        return null;
    }
    
}
