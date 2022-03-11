package com.br.model.database;

import com.br.MapaProcesso.Processo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;


public class ConnectProcesso {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectProcesso() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          //      System.out.println("Instalou driver");
          } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }

        
          con = DriverManager.getConnection(url, usuario, senha);
     }

          
     public void closeConnection() throws SQLException {

          con.close();
     }

     // cadastral no banco um usuario passado como parametro
     public List<Processo> listProcesso() {

          ArrayList<Processo> lista = new ArrayList<Processo>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from MapaProcesso ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Processo dados = new Processo();
                     dados.setCodigo(rs.getString(1));
                     dados.setMapa(rs.getString(2));
                     dados.setProcesso(rs.getString(3));
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectProcesso.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

          } finally {
                try {
                     if (rs != null) {
                          rs.close();
                     }
                     if (st != null) {
                          st.close();
                     }
                     if (con != null) {
                          con.close();
                     }

                } catch (SQLException ex) {
                     Logger lgr = Logger.getLogger(ConnectProcesso.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(Processo dados)
    {
        String sql = "INSERT INTO MapaProcesso (mapa, Processo) VALUES (?, ?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getMapa());
            stmt.setString(2, dados.getProcesso());
                       
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível inserir do banco: " + ex);
            return false;  
        }
        
    }
    
    //método para alterar
    public boolean alterar(Processo dados)
    {
        String sql = "UPDATE MapaProcesso SET mapa = ?, Processo = ? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getMapa());
            stmt.setString(2, dados.getProcesso());
            stmt.setString(3, dados.getCodigo());           
            
            System.out.println("Unidade "+dados.getCodigo());
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            return false;  
        }
    }
    
    //método para remover
    public boolean remover(Processo dados)
    {
        String sql = "DELETE FROM MapaProcesso WHERE codigo = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getCodigo()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
    
    //método para listar
    public boolean lista()
    {
        String sql = "SELECT * FROM MapaProcesso";
        
        List<Processo> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Processo dados = new Processo();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setMapa(resultado.getString("mapa"));
                dados.setProcesso(resultado.getString("Processo"));
                                
                //vamos adicionando a liss retorno
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        
       return true; 
        
    }
    
    //método para listar cidades e estado pela sigla do estado com inner join
   
    
    //método para buscar
   
    
    public List<Processo> obterProcessoBusca(String campo, String busca){
     ArrayList<Processo> lista = new ArrayList<Processo>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from MapaProcesso where "+campo+" like'%"+busca+"%'";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Processo dados = new Processo();
                     dados.setCodigo(rs.getString(1));
                     dados.setMapa(rs.getString(2));
                     dados.setProcesso(rs.getString(3));
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectProcesso.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

          } finally {
                try {
                     if (rs != null) {
                          rs.close();
                     }
                     if (st != null) {
                          st.close();
                     }
                     if (con != null) {
                          con.close();
                     }

                } catch (SQLException ex) {
                     Logger lgr = Logger.getLogger(ConnectProcesso.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<Processo> carregarProcesso() throws SQLException{
            
        {
        String sql = "SELECT * FROM MapaProcesso";
        
        List<Processo> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Processo dados = new Processo();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setMapa(resultado.getString("mapa"));
                dados.setProcesso(resultado.getString("Processo"));
                                
                //vamos adicionando a liss retorno
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        return retorno;
    }

    }
} 