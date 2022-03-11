/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.model.database;

/**
 *
 * @author V103760
 */
import static java.lang.Class.forName;
import java.sql.*;
import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.CONCUR_READ_ONLY;
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;
import static javax.swing.JOptionPane.showMessageDialog;



public class conexaoSQL
{
       
    final private String driver =  "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  
 //   private final String host = "BRCDSQL01\\SQLEXPRESS";
    private final String host = "10.51.3.26\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
        
    
        private Connection conexao;
        public Statement statement;
        public ResultSet resultset;
        
       public boolean conecta()
       {
            boolean result = true;
            try 
            {
                forName(driver);
                conexao = getConnection(url, usuario, senha);
           //    JOptionPane.showMessageDialog(null,"conectou");
            }
            catch(ClassNotFoundException Driver) 
            {
             // showMessageDialog(null,"Driver não localizado: "+Driver);
               result = false;
            }
            catch(SQLException Fonte) 
            {
//                showMessageDialog(null,"Deu erro na conexão "+
//                        "com a fonte de dados: "+Fonte);
                result = false;
            }
            return result; 
       }
       
       public void desconecta()
       {
            boolean result = true;
            try 
            {
                conexao.close();
                showMessageDialog(null,"banco fechado");
            }
            catch(SQLException fecha) 
            {
//               showMessageDialog(null,"Não foi possivel "+
//                       "fechar o banco de dados: "+fecha);
                result = false;
            }

       }
       
       public void executeSQL(String sql)
       {
            try 
            {
                statement = conexao.createStatement(TYPE_SCROLL_SENSITIVE, CONCUR_READ_ONLY);
                resultset = statement.executeQuery(sql);
            }
            catch(SQLException sqlex) 
            {
//              showMessageDialog(null,"Não foi possível "+
//                     "executar o comando sql,"+sqlex+", o sql passado foi "+sql);
            }

       }
       


} 