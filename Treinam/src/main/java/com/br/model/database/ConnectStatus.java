package com.br.model.database;

import com.br.Funcionarios.Funcionario;
import com.br.Status.Status;
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


public class ConnectStatus {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectStatus() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //        System.out.println("Instalou driver");
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
     public List<Status> listStatus() {

          ArrayList<Status> lista = new ArrayList<Status>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Status ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Status dados = new Status();
                     dados.setCodigo(rs.getString(1));
                     dados.setStatus(rs.getString(2));
                    
                    
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectStatus.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectStatus.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(Status dados)
    {
        String sql = "INSERT INTO Status (status) VALUES (?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getStatus());
            
            
                       
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
    public boolean alterar(Status dados)
    {
        String sql = "UPDATE Status SET  status = ? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getStatus());
            stmt.setString(2, dados.getCodigo());  
            
            
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
    public boolean remover(Status dados)
    {
        String sql = "DELETE FROM Status WHERE codigo = ?";
        
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
        String sql = "SELECT * FROM Status";
        
        List<Status> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
              Status dados = new Status();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setStatus(resultado.getString("status"));
               
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
    
    public List<Status> obterModeloStatus(String campo, String busca){
     ArrayList<Status> lista = new ArrayList<Status>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Status where "+campo+" like'%"+busca+"%'";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Status dados = new Status();
                     dados.setCodigo(rs.getString(1));
                     dados.setStatus(rs.getString(2));
                    
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectStatus.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectStatus.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<Status> carregarStatus() throws SQLException{
            
        {
        String sql = "SELECT * FROM Status";
        
        List<Status> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Status dados = new Status();
                
                dados.setCodigo(resultado.getString("codigo"));
                dados.setStatus(resultado.getString("Status"));
             
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