package com.br.model.database;

import com.br.AvaliacaoTreinador.Avaliacao;
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


public class ConnectAvaliacao {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectAvaliacao() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              //  System.out.println("Instalou driver");
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
     public List<Avaliacao> listModelo() {

          ArrayList<Avaliacao> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Avaliacao ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Avaliacao dados = new Avaliacao();
                     dados.setCodigo(rs.getString(1));
                     dados.setData(rs.getString(2));
                     dados.setCodigoObt(rs.getString(3));
                     dados.setDescricao(rs.getString(4));
                     dados.setNota(rs.getInt(5));
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectAvaliacao.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectAvaliacao.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(Avaliacao dados)
    {
        String sql = "INSERT INTO Avaliacao (data,codigoObt,descricao,nota) VALUES (?,?,?,?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getData());
            stmt.setString(2, dados.getCodigoObt());
            stmt.setString(3, dados.getDescricao());
            stmt.setInt(4, dados.getNota());
            
                       
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível inserir do banco: " + ex);
            return false;  
        }
        
    }
    
        public void gravar(String codigoObt,String descricao, int nota, String avaliacao, String treinamento, String unidade, String categoria)
    {
        String sql = "INSERT INTO Avaliacao (data,codigoObt,descricao,nota,avaliacao,treinamento,unidade,categoria) VALUES (?,?,?,?,?,?,?,?)";
        String data = "" + java.time.LocalDate.now();
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, data);
            stmt.setString(2, codigoObt);
            stmt.setString(3, descricao);
            stmt.setInt(4, nota);
            stmt.setString(5, avaliacao);
            stmt.setString(6, treinamento);           
            stmt.setString(7, unidade); 
            stmt.setString(8, categoria);
            
            stmt.execute();
            
           
        }
        catch(SQLException ex)
        { 
           
        }
        
    }
    //método para alterar
    public boolean alterar(Avaliacao dados)
    {
        String sql = "UPDATE Avaliacao SET  data = ?, codigoObt = ?, decricao = ?, nota = ?  WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
          
            stmt.setString(1, dados.getData());
            stmt.setString(2, dados.getCodigoObt());
            stmt.setString(3, dados.getDescricao());
            stmt.setInt(4, dados.getNota());
            stmt.setString(5, dados.getCodigo());
            
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
    public boolean remover(Avaliacao dados)
    {
        String sql = "DELETE FROM Avaliacao WHERE codigo = ?";
        
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
        String sql = "SELECT * FROM Avaliacao";
        
        List<Avaliacao> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Avaliacao dados = new Avaliacao();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNota(resultado.getInt("nota"));
                
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
   
    
    public List<Avaliacao> AvaliacaoBusca(String campo, String busca){
     ArrayList<Avaliacao> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Avaliacao where "+campo+" like'%"+busca+"%'";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                    Avaliacao dados = new Avaliacao();
                     dados.setCodigo(rs.getString(1));
                     dados.setData(rs.getString(2));
                     dados.setCodigoObt(rs.getString(3));
                     dados.setDescricao(rs.getString(4));
                     dados.setNota(rs.getInt(5)); 
                    
                                        
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectAvaliacao.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectAvaliacao.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<Avaliacao> carregarAvaliacao() throws SQLException{
            
        {
        String sql = "SELECT * FROM Avaliacao ";
        
        List<Avaliacao> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Avaliacao dados = new Avaliacao();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNota(resultado.getInt("nota"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setAvaliacao(resultado.getString("avaliacao"));
                dados.setUnidade(resultado.getString("unidade"));
                dados.setCategoria(resultado.getString("categoria"));
                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                
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
      public List<Avaliacao> carregarAvaliacao2(String curso) throws SQLException{
            
        {
        String sql = "SELECT DISTINCT descricao FROM Avaliacao where avaliacao = '"+curso+"'";
        
        List<Avaliacao> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Avaliacao dados = new Avaliacao();
                
              //  dados.setCodigo(resultado.getString("codigo"));
//                dados.setData(resultado.getString("data"));
//                dados.setCodigoObt(resultado.getString("codigoObt"));
                  dados.setDescricao(resultado.getString("descricao"));
                  dados.setNota(this.carregarAvaliacaoCont(curso, resultado.getString("descricao")));
//                dados.setNota(resultado.getInt("nota"));
//                dados.setTreinamento(resultado.getString("treinamento"));
//                dados.setAvaliacao(resultado.getString("avaliacao"));
//                dados.setUnidade(resultado.getString("unidade"));
//                dados.setCategoria(resultado.getString("categoria"));
//                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                 System.out.println(resultado.getString("descricao"));
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
           // showMessageDialog(null, "Não foi possível listar do banco: " + ex);
            System.out.println(ex);
              
        }
        return retorno;
    }

    }
    public List<Avaliacao> carregarAvaliacaoUnidade(String avaliacao) throws SQLException{
            
        {
        String sql = "SELECT * FROM Avaliacao where avaliacao='"+avaliacao+"'";
        
        List<Avaliacao> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Avaliacao dados = new Avaliacao();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNota(resultado.getInt("nota"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setAvaliacao(resultado.getString("avaliacao"));
                dados.setUnidade(resultado.getString("unidade"));
                dados.setCategoria(resultado.getString("categoria"));
                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
           System.out.println(ex);
              
        }
        return retorno;
    }

    }
    public List<Avaliacao> carregarAvaliacaoNota(String curso, String descr) throws SQLException{
            
        {
        String sql = "SELECT * FROM Avaliacao where avaliacao = '"+curso+"' and  descricao = '"+descr+"'";
        
        List<Avaliacao> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Avaliacao dados = new Avaliacao();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNota(resultado.getInt("nota"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setAvaliacao(resultado.getString("avaliacao"));
                dados.setUnidade(resultado.getString("unidade"));
                dados.setCategoria(resultado.getString("categoria"));
                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
           System.out.println(ex);
              
        }
        return retorno;
    }

    }
     public int carregarAvaliacaoCont(String curso, String descr) throws SQLException{
        
         int valor = 0;
         int contador=0;
        {
        String sql = "SELECT * FROM Avaliacao where avaliacao = '"+curso+"' and  descricao = '"+descr+"'";
        
      
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                
                valor += resultado.getInt("nota");
//               Avaliacao dados = new Avaliacao();
//                
//              //  dados.setCodigo(resultado.getString("codigo"));
////                dados.setData(resultado.getString("data"));
////                dados.setCodigoObt(resultado.getString("codigoObt"));
//                dados.setDescricao(resultado.getString("descricao"));
////                dados.setNota(resultado.getInt("nota"));
////                dados.setTreinamento(resultado.getString("treinamento"));
////                dados.setAvaliacao(resultado.getString("avaliacao"));
////                dados.setUnidade(resultado.getString("unidade"));
////                dados.setCategoria(resultado.getString("categoria"));
////                dados.setDesc_categoria(resultado.getString("desc_categoria"));
//                 System.out.println(resultado.getString("descricao"));
//                retorno.add(dados);
               contador++;
            }        
                      
           
        }
        catch(SQLException ex)
        { 
           // showMessageDialog(null, "Não foi possível listar do banco: " + ex);
            System.out.println(ex);
              
        }
        return valor/contador;
    }

    }
      public List<Avaliacao> carregarAvaliacaoUnidade2(String avaliacao,String campo, String unidade) throws SQLException{
            
        {
        String sql = "SELECT * FROM Avaliacao where "+campo+"='"+avaliacao+"' and unidade = '"+unidade+"'";
        
        List<Avaliacao> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Avaliacao dados = new Avaliacao();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setDescricao(resultado.getString("descricao"));
                dados.setNota(resultado.getInt("nota"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setAvaliacao(resultado.getString("avaliacao"));
                dados.setUnidade(resultado.getString("unidade"));
                dados.setCategoria(resultado.getString("categoria"));
                dados.setDesc_categoria(resultado.getString("desc_categoria"));
                
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
           System.out.println(ex);
              
        }
        return retorno;
    }

    }
} 