
package com.br.model.database;

import java.sql.Connection;

public interface Database {
    //método de conexão
    public Connection conectar();
    //método de desconectar
    public void desconectar(Connection conn);
    
}
