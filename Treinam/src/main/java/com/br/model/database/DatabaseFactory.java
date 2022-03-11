
package com.br.model.database;

import java.sql.Connection;
import java.sql.SQLException;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author fschi
 */
public class DatabaseFactory {
    
    //método para escolher o tipo de banco de dados 
    //neste caso poderá optar por mySql ou postgreSql
    public static Database getDatabase(String nome)
    {
        if(nome.equals("postgresql"))
        {
            return (Database) new DatabasePostgreSQL();
        }
        else if (nome.equals("mysql"))
        {
            return (Database) new DatabaseMySQL() {
                @Override
                public void desconectar(Connection conn) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        getLogger(DatabaseFactory.class.getName()).log(SEVERE, null, ex);
                    }
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };             
        }
        
        return null;
    }
    
}
