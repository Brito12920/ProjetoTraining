package com.br.model.database;

import com.br.Funcionarios.Funcionario;
import com.br.QuantidadeFuncionarios.QuantidadeFunc;
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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static javax.swing.JOptionPane.showMessageDialog;


public class ConnectQuantidadeFunc {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectQuantidadeFunc() throws SQLException {

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
     public List<QuantidadeFunc> listQuantidadeFunc() {

          ArrayList<QuantidadeFunc> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from QuantidadeFuncionarios ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     QuantidadeFunc dados = new QuantidadeFunc();
                     dados.setCodigo(rs.getString(1));
                     dados.setUnidade(rs.getString(2));
                     dados.setDepartamento(rs.getString(3));
                     dados.setData(rs.getString(4));
                     dados.setQuantidade(rs.getString(5));
                     dados.setTotalCh(rs.getString(6));
                     dados.setMes(rs.getString(7));
                     
                     
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectQuantidadeFunc.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectQuantidadeFunc.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(QuantidadeFunc dados)
    {
        String sql = "INSERT INTO QuantidadeFuncionarios (unidade,departamento,data,quantidade,TotalCh,mes) VALUES (?,?,?,?,?,?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getUnidade());
            stmt.setString(2, dados.getDepartamento());
            stmt.setString(3, dados.getData());
            stmt.setString(4, dados.getQuantidade());
            stmt.setString(5, dados.getTotalCh());
            stmt.setString(6, dados.getMes());
            
            
            
                       
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
         //   showMessageDialog(null, "Não foi possível inserir do banco: " + ex);
            System.out.println(ex);
            return false;  
        }
        
    }
    
    //método para alterar
    public boolean alterar(QuantidadeFunc dados)
    {
        String sql = "UPDATE QuantidadeFuncionarios SET  unidade = ?, departamento = ?, data = ?, quantidade = ?, TotalCh = ?, mes=?  WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getUnidade());
            stmt.setString(2, dados.getDepartamento());
            stmt.setString(3, dados.getData());
            stmt.setInt(4, Integer.parseInt(dados.getQuantidade()));
            stmt.setDouble(5, Double.parseDouble(dados.getTotalCh()));
            stmt.setString(6, dados.getMes());
            stmt.setString(7, dados.getCodigo());
             
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
           System.out.println(ex);
           FacesMessage msg = new FacesMessage("", ""+ex) ;
           FacesContext.getCurrentInstance().addMessage("Erro ao "+ex, msg);
            return false;  
        }
    }
    
    //método para remover
    public boolean remover(QuantidadeFunc dados)
    {
        String sql = "DELETE FROM QuantidadeFuncionarios WHERE codigo = ?";
        
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
        String sql = "SELECT * FROM QuantidadeFuncionarios";
        
        List<QuantidadeFunc> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               QuantidadeFunc dados = new QuantidadeFunc();
                     dados.setCodigo(rs.getString(1));
                     dados.setUnidade(rs.getString(2));
                     dados.setDepartamento(rs.getString(3));
                     dados.setData(rs.getString(4));
                     dados.setQuantidade(rs.getString(5));
                     dados.setTotalCh(rs.getString(6));
                     dados.setMes(rs.getString(7));
               
                
                
                
                
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
    public boolean listaFuncionarios()
    {
        String sql = "SELECT funcionario.codigo, funcionario.registro, funcionario.Nome, funcionario.Funcao,funcionario.Departamento,funcionario.Unidade,funcionario.Imagem"
                + " FROM Funcionarios " ;
        
        List<Funcionario> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodigo(resultado.getInt("funcionario.codigo"));
                funcionario.setRegistro(resultado.getString("funcionario.registro"));
                funcionario.setNome(resultado.getString("funcionario.Nome"));
                funcionario.setFuncao(resultado.getString("funcionario.Funcao"));
                funcionario.setDepartamento(resultado.getString("funcionario.Departamento"));
                funcionario.setUnidade(resultado.getString("funcionario.Unidade"));
                funcionario.setImagem(resultado.getString("funcionario.Imagem"));
                //vamos adicionando a liss retorno
                retorno.add(funcionario);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível listar do banco: " + ex);
            return false;   
        }
        
        return true; 
        
    }
    
    //método para buscar
    public Funcionario buscar(Funcionario funcionario)
    {
        String sql = "SELECT * FROM Funcionario WHERE Registro = ?";
        
        Funcionario retorno = new Funcionario();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setString(1, funcionario.getRegistro());
            stmt.setString(2, funcionario.getNome());
            
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next())
            {
                funcionario.setCodigo(resultado.getInt("codigo"));
                funcionario.setRegistro(resultado.getString("registro"));
                funcionario.setNome(resultado.getString("Nome"));
                funcionario.setFuncao(resultado.getString("Funcao"));
                funcionario.setDepartamento(resultado.getString("Departamento"));
                funcionario.setUnidade(resultado.getString("Unidade"));
                funcionario.setImagem(resultado.getString("Imagem"));
                retorno = funcionario;
            }
            
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível buscar do banco: " + ex);
             
        }
        
        return retorno;
    }
    
    public List<QuantidadeFunc> obterControleBusca(String campo, String busca){
     ArrayList<QuantidadeFunc> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from QuantidadeFuncionarios where "+campo+" like'%"+busca+"%'";
                rs = st.executeQuery(sql);

                while (rs.next()) {

                     QuantidadeFunc dados = new QuantidadeFunc();
                     dados.setCodigo(rs.getString(1));
                     dados.setUnidade(rs.getString(2));
                     dados.setDepartamento(rs.getString(3));
                     dados.setData(rs.getString(4));
                     dados.setQuantidade(rs.getString(5));
                     dados.setTotalCh(rs.getString(6));
                     dados.setMes(rs.getString(7));
                    
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectQuantidadeFunc.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectQuantidadeFunc.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<QuantidadeFunc> carregarControle() throws SQLException{
            
        {
        String sql = "SELECT * FROM QuantidadeFuncionarios";
        
        List<QuantidadeFunc> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
              
                
                     QuantidadeFunc dados = new QuantidadeFunc();
                     dados.setCodigo(rs.getString(1));
                     dados.setUnidade(rs.getString(2));
                     dados.setDepartamento(rs.getString(3));
                     dados.setData(rs.getString(4));
                     dados.setQuantidade(rs.getString(5));
                     dados.setTotalCh(rs.getString(6));
                     dados.setMes(rs.getString(7));
               
             
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