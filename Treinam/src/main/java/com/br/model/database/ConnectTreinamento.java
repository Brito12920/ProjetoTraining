package com.br.model.database;

import com.br.Funcionarios.Funcionario;
import com.br.Treinamento.Treinamento;
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


public class ConnectTreinamento {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectTreinamento() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           //     System.out.println("Instalou driver");
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
     public List<Treinamento> listTreinamento() {

          ArrayList<Treinamento> lista = new ArrayList<Treinamento>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Treinamento ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Treinamento dados = new Treinamento();
                     dados.setCodigo(rs.getInt(1));
                     dados.setNome(rs.getString(2));
                     dados.setFuncao(rs.getString(3));
                    
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectTreinamento.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectTreinamento.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(Treinamento dados)
    {
        String sql = "INSERT INTO Treinamento (nome,funcao) VALUES (?,?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getNome());
            stmt.setString(2, dados.getFuncao());
            
                       
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
    public boolean alterar(Treinamento dados)
    {
        String sql = "UPDATE Treinamento SET  nome = ?, funcao = ? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getNome());
            stmt.setString(2, dados.getFuncao());
            stmt.setInt(3, dados.getCodigo());  
            
            
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
    public boolean remover(Treinamento dados)
    {
        String sql = "DELETE FROM Treinamento WHERE codigo = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dados.getCodigo()); 
            
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
        String sql = "SELECT * FROM Treinamento";
        
        List<Treinamento> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Treinamento dados = new Treinamento();
                
                dados.setCodigo(resultado.getInt("codigo"));
                dados.setNome(resultado.getString("nome"));
                dados.setFuncao(resultado.getString("funcao"));
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
            showMessageDialog(null, "N??o foi poss??vel listar do banco: " + ex);
            return false;   
        }
        
        return true; 
        
    }
    
    //m??todo para buscar
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
            showMessageDialog(null, "N??o foi poss??vel buscar do banco: " + ex);
             
        }
        
        return retorno;
    }
    
    public List<Treinamento> obterTreinamentoBusca(String campo, String busca){
     ArrayList<Treinamento> lista = new ArrayList<Treinamento>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Treinamento where "+campo+" like'%"+busca+"%'";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                    Treinamento dados = new Treinamento();
                     dados.setCodigo(rs.getInt(1));
                     dados.setNome(rs.getString(2));
                     dados.setFuncao(rs.getString(3));
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectTreinamento.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectTreinamento.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<Treinamento> carregarTreinamento() throws SQLException{
            
        {
        String sql = "SELECT * FROM Treinamento where unidade ='"+Permissao.getUnidade()+"'";
        
        List<Treinamento> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Treinamento dados = new Treinamento();
                
                dados.setCodigo(resultado.getInt("codigo"));
                dados.setNome(resultado.getString("nome"));
                dados.setFuncao(resultado.getString("funcao"));
                
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