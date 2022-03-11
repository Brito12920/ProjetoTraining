package com.br.model.database;

import com.br.AvaliacaoTreinador.DescricaoAval;
import com.br.Usuario.Permissao;
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


public class ConnectDescricaoAvaliacao {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectDescricaoAvaliacao() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             //   System.out.println("Instalou driver");
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
     public List<DescricaoAval> listModelo() {

          ArrayList<DescricaoAval> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from descricaoAvaliacao ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     DescricaoAval dados = new DescricaoAval();
                     dados.setCodigo(rs.getString(1));
                     dados.setDescricao(rs.getString(2));
                     dados.setNomeAvaliacao(rs.getString(3));
                     dados.setDescricao(rs.getString(4));
                     dados.setDesc_categoria(rs.getString(5)); 
                     dados.setUnidade(rs.getString(5));
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectDescricaoAvaliacao.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectDescricaoAvaliacao.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(DescricaoAval dados)
    {
        String sql = "INSERT INTO descricaoAvaliacao (descricao,nomeAvaliacao,categoria,desc_categoria,unidade) VALUES (?,?,?,?,?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getDescricao());
            stmt.setString(2, dados.getNomeAvaliacao());
            stmt.setString(3, dados.getCategoria());
            stmt.setString(4, dados.getDesc_categoria());
            stmt.setString(5, Permissao.getUnidade());
                       
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
    public boolean alterar(DescricaoAval dados)
    {
        String sql = "UPDATE descricaoAvaliacao SET  descricao = ?, nomeAvaliacao = ?, categoria = ?, desc_categoria = ? , unidade = ?  WHERE codigo = ?";
         
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getDescricao());
            stmt.setString(2, dados.getNomeAvaliacao());
            stmt.setString(3, dados.getCategoria());
            stmt.setString(4, dados.getDesc_categoria());
            stmt.setString(5, dados.getUnidade());
            stmt.setString(6, dados.getCodigo());
            System.out.println("codigo "+dados.getCodigo());
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
    public boolean remover(DescricaoAval dados)
    {
        String sql = "DELETE FROM descricaoAvaliacao WHERE codigo = ?";
        
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
        String sql = "SELECT * FROM descricaoAvaliacao";
        
        List<DescricaoAval> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               DescricaoAval dados = new DescricaoAval();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNomeAvaliacao(resultado.getString("nomeAvaliacao"));
                dados.setCategoria(resultado.getString("categoria"));
                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                dados.setUnidade(resultado.getString("unidade"));
                
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
    
      
    
    //método para buscar
   
    
    public List<DescricaoAval> DescricaoAvaliacaoBusca(String campo, String busca){
     ArrayList<DescricaoAval> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from descricaoAvaliacao where "+campo+" ='"+busca+"'";
               rs = st.executeQuery(sql);
               System.out.println("SQL "+sql);
                while (rs.next()) {

                    DescricaoAval dados = new DescricaoAval();

                    dados.setCodigo(rs.getString("codigo"));
                    dados.setDescricao(rs.getString("descricao"));
                    dados.setNomeAvaliacao(rs.getString("nomeAvaliacao"));
                    dados.setCategoria(rs.getString("categoria"));
                    dados.setDesc_categoria(rs.getString("desc_categoria"));
                    dados.setUnidade(rs.getString("unidade"));
                    
                    
                     lista.add(dados);
                }
                 
          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectDescricaoAvaliacao.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectDescricaoAvaliacao.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<DescricaoAval> carregarDescricaoAvaliacao(String Avaliacao) throws SQLException{
            
        {
        String sql = "SELECT * FROM descricaoAvaliacao where nomeAvaliacao ='"+Avaliacao+"'";
        
        List<DescricaoAval> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               DescricaoAval dados = new DescricaoAval();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNomeAvaliacao(resultado.getString("nomeAvaliacao"));
                dados.setCategoria(resultado.getString("categoria"));
                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                dados.setUnidade(resultado.getString("unidade"));
             
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
    public List<DescricaoAval> ListarDescricaoAvaliacao() throws SQLException{
            
        {
        String sql = "SELECT * FROM descricaoAvaliacao";
        
        List<DescricaoAval> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               DescricaoAval dados = new DescricaoAval();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNomeAvaliacao(resultado.getString("nomeAvaliacao"));
                dados.setCategoria(resultado.getString("categoria"));
                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                dados.setUnidade(resultado.getString("unidade"));
             
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