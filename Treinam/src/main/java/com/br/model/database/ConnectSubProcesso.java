package com.br.model.database;

import com.br.MapaProcesso.Processo;
import com.br.MapaSubProcesso.SubProcesso;
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


public class ConnectSubProcesso {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectSubProcesso() throws SQLException {

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
     public List<SubProcesso> listSubProcesso() {

          ArrayList<SubProcesso> lista = new ArrayList<SubProcesso>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from MapaSubProcesso ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     SubProcesso dados = new SubProcesso();
                     dados.setCodigo(rs.getString(1));
                     dados.setMapa(rs.getString(2));
                     dados.setSubprocesso(rs.getString(3));
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectSubProcesso.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectSubProcesso.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(SubProcesso dados)
    {
        String sql = "INSERT INTO MapaSubProcesso (mapa, SubProcesso) VALUES (?, ?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getMapa());
            stmt.setString(2, dados.getSubprocesso());
                       
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "N??o foi poss??vel inserir do banco: " + ex);
            return false;  
        }
        
    }
    
    //m??todo para alterar
    public boolean alterar(SubProcesso dados)
    {
        String sql = "UPDATE MapaSubProcesso SET mapa = ?, SubProcesso = ? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getMapa());
            stmt.setString(2, dados.getSubprocesso());
            stmt.setString(3, dados.getCodigo());           
            
            System.out.println("Unidade "+dados.getCodigo());
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "N??o foi poss??vel alterar do banco: " + ex);
            return false;  
        }
    }
    
    //m??todo para remover
    public boolean remover(SubProcesso dados)
    {
        String sql = "DELETE FROM MapaSubProcesso WHERE codigo = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getCodigo()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "N??o foi poss??vel remover do banco: " + ex);
            return false;  
        }
    }
    
    //m??todo para listar
    public boolean lista()
    {
        String sql = "SELECT * FROM MapaSubProcesso";
        
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
                dados.setProcesso(resultado.getString("SubProcesso"));
                                
                //vamos adicionando a liss retorno
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "N??o foi poss??vel listar do banco: " + ex);
              
        }
        
       return true; 
        
    }
    
    //m??todo para listar cidades e estado pela sigla do estado com inner join
   
    
    //m??todo para buscar
   
    
    public List<SubProcesso> obterProcessoBusca(String campo, String busca){
     ArrayList<SubProcesso> lista = new ArrayList<SubProcesso>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from MapaSubProcesso where "+campo+" like'%"+busca+"%'";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     SubProcesso dados = new SubProcesso();
                     dados.setCodigo(rs.getString(1));
                     dados.setMapa(rs.getString(2));
                     dados.setSubprocesso(rs.getString(3));
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectSubProcesso.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectSubProcesso.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }

    /**
     *
 
     * @return
     * @throws SQLException
     */
    public List<SubProcesso> carregarSubProcesso(String mapa) throws SQLException{
            
        {
            System.out.println("Mapa"+mapa);
             String sql = "SELECT * FROM MapaSubProcesso";
        
        List<SubProcesso> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                SubProcesso dados = new SubProcesso();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setMapa(resultado.getString("mapa"));
                dados.setSubprocesso(resultado.getString("SubProcesso"));
                                
                //vamos adicionando a liss retorno
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "N??o foi poss??vel listar do banco: " + ex);
              
        }
        return retorno;
    }

    }
} 