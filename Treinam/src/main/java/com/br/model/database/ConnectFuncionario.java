package com.br.model.database;

import com.br.Funcionarios.Funcionario;
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


public class ConnectFuncionario {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectFuncionario() throws SQLException {

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
     public List<Funcionario> listFuncionario() {

          ArrayList<Funcionario> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Funcionario ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Funcionario funcionario = new Funcionario();
                     funcionario.setCodigo(rs.getInt(1));
                     funcionario.setRegistro(rs.getString(2));
                     funcionario.setNome(rs.getString(3));
                     funcionario.setFuncao(rs.getString(4));
                     funcionario.setDepartamento(rs.getString(5));
                     funcionario.setUnidade(rs.getString(6)); 
                     funcionario.setStatus(rs.getString(8)); 
                  //   usuario.setDataCadastro(rs.getDate(5));
                     lista.add(funcionario);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
      public List<Funcionario> listFuncionarioGraf(String unidade) {

          ArrayList<Funcionario> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Funcionario where Unidade = '"+unidade+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {

                     Funcionario funcionario = new Funcionario();
                     funcionario.setCodigo(rs.getInt(1));
                     funcionario.setRegistro(rs.getString(2));
                     funcionario.setNome(rs.getString(3));
                     funcionario.setFuncao(rs.getString(4));
                     funcionario.setDepartamento(rs.getString(5));
                     funcionario.setUnidade(rs.getString(6)); 
                     funcionario.setStatus(rs.getString(8)); 
                     funcionario.setData(rs.getString(9)); 
                     lista.add(funcionario);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                System.out.println(ex);

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
                     Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                     System.out.println(ex);
                }
          }
          return lista;
     }
       public boolean inserir(Funcionario funcionario)
    {
        String sql = "INSERT INTO Funcionario (registro, Nome,Funcao,Departamento,Unidade,Imagem,status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getRegistro());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getFuncao());
            stmt.setString(4, funcionario.getDepartamento());
            stmt.setString(5, funcionario.getUnidade());
            stmt.setString(6, funcionario.getImagem());
            stmt.setString(7, "Ativo");
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            //showMessageDialog(null, "Não foi possível inserir do banco: " + ex);
            System.out.println(ex);
            return false;  
        }
        
    }
    
    //método para alterar
    public boolean alterar(Funcionario funcionario)
    {
        
        String sql = "UPDATE Funcionario SET registro = ?, Nome = ?, Funcao= ?, Departamento=?, Unidade=?, imagem=?, status=?, data=? WHERE registro = ?";
        String datahj = ""+java.time.LocalDate.now();
        try
        {   
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getRegistro());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getFuncao());
            stmt.setString(4, funcionario.getDepartamento());
            stmt.setString(5, funcionario.getUnidade());
            stmt.setString(6, funcionario.getImagem());
            stmt.setString(7, funcionario.getStatus());
            stmt.setString(8, datahj);
            stmt.setString(9, funcionario.getRegistro());           
            
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            System.out.println(ex);
            return false;  
        }
    }
    
    //método para remover
    public boolean remover(Funcionario funcionario)
    {
        String sql = "DELETE FROM Funcionario WHERE registro = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getRegistro()); 
            
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
        String sql = "SELECT * FROM Funcionario";
        
        List<Funcionario> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodigo(resultado.getInt("codigo"));
                funcionario.setRegistro(resultado.getString("registro"));
                funcionario.setNome(resultado.getString("Nome"));
                funcionario.setFuncao(resultado.getString("Funcao"));
                funcionario.setDepartamento(resultado.getString("Departamento"));
                funcionario.setUnidade(resultado.getString("Unidade"));
                funcionario.setImagem(resultado.getString("Imagem"));
                funcionario.setStatus(resultado.getString("Status"));
                funcionario.setData(resultado.getString("data"));
                //vamos adicionando a liss retorno
                retorno.add(funcionario);
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
                funcionario.setData(resultado.getString("funcionario.data"));
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
    
    public boolean SearchFuncionarios(Funcionario funcionario)
    {
//        String sql = "SELECT * FROM Funcionario WHERE Registro = "+funcionario.getRegistro()+"";
//        
//       
//       System.out.println("usuario t"+sql);
//        Funcionario retorno = new Funcionario();
//        
//        try
//        {
//            PreparedStatement stmt = con.prepareStatement(sql);
//           
//            ResultSet resultado = stmt.executeQuery();
//            
//            if(resultado.next())
//            {
//                funcionario.setCodigo(resultado.getInt("codigo"));
//                funcionario.setRegistro(resultado.getString("registro"));
//                funcionario.setNome(resultado.getString("Nome"));
//                funcionario.setFuncao(resultado.getString("Funcao"));
//                funcionario.setDepartamento(resultado.getString("Departamento"));
//                funcionario.setUnidade(resultado.getString("Unidade"));
//                funcionario.setImagem(resultado.getString("Imagem"));
//                funcionario.setStatus(resultado.getString("Status"));
//                funcionario.setData(resultado.getString("data"));
//                retorno = funcionario;
//                return true; 
//            }
//            
//        }
//        catch(SQLException ex)
//        { 
//           // showMessageDialog(null, "Não foi possível buscar do banco: " + ex);
//              System.out.println("Não foi possível buscar do banco: ");
//              
//        }
        
        return false; 
        
    }
    //método para buscar
    public  Funcionario buscar(Funcionario funcionario)
    {
          
        String sql = "SELECT * FROM Funcionario WHERE Registro = "+funcionario.getRegistro()+"";
       System.out.println("usuario t"+sql);
        Funcionario retorno = new Funcionario();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
           
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
                funcionario.setStatus(resultado.getString("Status"));
                funcionario.setData(resultado.getString("data"));
                retorno = funcionario;
            }
            
        }
        catch(SQLException ex)
        { 
           // showMessageDialog(null, "Não foi possível buscar do banco: " + ex);
              System.out.println("Não foi possível buscar do banco: ");
        }
        
        return retorno;
    }
    
    public List<Funcionario> obterFuncionarioBusca(String campo, String busca){
       ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Funcionario where "+campo+" like'%"+busca+"%'";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Funcionario funcionario = new Funcionario();
                     funcionario.setCodigo(rs.getInt(1));
                     funcionario.setRegistro(rs.getString(2));
                     funcionario.setNome(rs.getString(3));
                     funcionario.setFuncao(rs.getString(4));
                     funcionario.setDepartamento(rs.getString(5));
                     funcionario.setUnidade(rs.getString(6)); 
                     funcionario.setStatus(rs.getString(8)); 
                     funcionario.setData(rs.getString(9)); 
                     lista.add(funcionario);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
     public List<Funcionario> obterFuncionario(String nome){
       ArrayList<Funcionario> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Funcionario where nome like '%"+nome+"%' and unidade ='"+Permissao.getUnidade()+"' order by nome asc";
                System.out.println(sql);
               rs = st.executeQuery(sql);

                while (rs.next()) {
                       System.out.println(rs.getString(3));
                     Funcionario funcionario = new Funcionario();
                     funcionario.setCodigo(rs.getInt(1));
                     funcionario.setRegistro(rs.getString(2));
                     funcionario.setNome(rs.getString(3));
                     funcionario.setFuncao(rs.getString(4));
                     funcionario.setDepartamento(rs.getString(5));
                     funcionario.setUnidade(rs.getString(6));
                     funcionario.setStatus(rs.getString(7)); 
                  //   usuario.setDataCadastro(rs.getDate(5));
                     lista.add(funcionario);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectFuncionario.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
}