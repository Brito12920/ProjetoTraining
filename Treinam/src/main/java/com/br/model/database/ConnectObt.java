package com.br.model.database;

import com.br.Funcionarios.Funcionario;
import com.br.Obt.Obt;
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


public class ConnectObt {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    private static String obtModelo;
    public static String getObtModelo() {
        return obtModelo;
    }

    public static void setObtModelo(String obtModelo) {
        ConnectObt.obtModelo = obtModelo;
    }

   
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectObt() throws SQLException {

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
     public List<Obt> listObt() {

          ArrayList<Obt> lista = new ArrayList<Obt>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Obt ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Obt dados = new Obt();
                     dados.setCodigo(rs.getString(1));
                     dados.setObtModelo(rs.getString(2));
                     dados.setRegistroTreinamento(rs.getString(3));
                     dados.setData(rs.getString(4)); 
                     dados.setHora(rs.getString(5)); 
                     dados.setTempo(rs.getString(6));
                     dados.setRe(rs.getString(7));
                     dados.setNome(rs.getString(8));
                     dados.setCargo(rs.getString(9));
                     dados.setDepartamento(rs.getString(10));
                     dados.setTipo(rs.getString(11));
                     dados.setCodigoObt(rs.getString(12)); 
                     dados.setNota(rs.getString(13));
                     dados.setMedia(rs.getString(14));
                     dados.setQuantPeguntas(rs.getString(15)); 
                     dados.setQuantErros(rs.getString(16));
                     dados.setAssinaturaFac(rs.getString(17));
                     dados.setAprovaFac(rs.getString(18));
                     dados.setRevisao(rs.getString(19));
                     dados.setUnidade(rs.getString(20));
                     dados.setStatus(rs.getString(21));
                     dados.setAssinaturaFac(rs.getString(22));
                     dados.setAssinaturaSup(rs.getString(23));
                     
                     
                     
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectObt.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectObt.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(Obt dados)
    {
        String sql = "insert into obt (obtModelo,"
                    
                    + " RegistroTreinamento,"
                    + " data,"
                    + " hora,"
                    + " re,"
                    + " nome,"
                    + " cargo,"
                    + " departamento,"
                    + " Tipo,"
                    + " codigoObt,"
                    + " nota,"
                    + " media,"
                    + " quantPeguntas,"
                    + " assinturaFunc,"
                    + " aprovaFac,"
                    + " revisao,"
                    + " unidade,"
                    + " tempo,"
                    + "status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getObtModelo());
            stmt.setString(2, dados.getRegistroTreinamento());
            stmt.setString(3, dados.getData());
            stmt.setString(4, dados.getHora());
            stmt.setString(5, dados.getRe());
            stmt.setString(6, dados.getNome());
            stmt.setString(7, dados.getCargo());
            stmt.setString(8, dados.getDepartamento());
            stmt.setString(9, dados.getTipo());
            stmt.setString(10, dados.getCodigoObt());
            stmt.setString(11, dados.getNota());
            stmt.setString(12, dados.getMedia());
            stmt.setString(13, dados.getQuantPeguntas());
            stmt.setString(14, dados.getAssinaturaFac());
            stmt.setString(15, dados.getAprovaFac());
            stmt.setString(16, dados.getRevisao());
            stmt.setString(17, dados.getUnidade());
            stmt.setString(18, dados.getTempo());
            stmt.setString(19, dados.getStatus());
            
          
            
            
                       
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
    public boolean alterar(Obt dados)
    {
        String sql = "UPDATE obt SET obtModelo = ?,"
                    + " data= ?,"
                    + " re= ?,"
                    + " nome= ?,"
                    + " departamento= ?,"
                    + " Tipo= ?,"
                    + " nota= ?,"
                    + " quantPeguntas= ?,"
                    + " assinturaFunc= ?,"
                    + " assinaturaFac= ?,"
                    + " assinaturaSup= ?,"
                    + "revisao= ? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getObtModelo());
            stmt.setString(2, dados.getData());
            stmt.setString(3, dados.getRe());
            stmt.setString(4, dados.getNome());
            stmt.setString(5, dados.getDepartamento());
            stmt.setString(6, dados.getTipo());
            stmt.setString(7, dados.getNota());
            stmt.setString(8, dados.getQuantPeguntas());
            stmt.setString(9, dados.getAssinturaFunc());
            stmt.setString(10, dados.getAssinaturaFac());
            stmt.setString(11, dados.getAssinaturaSup());
            stmt.setString(12, dados.getRevisao());
            stmt.setString(13, dados.getCodigo());
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
         //   showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            System.out.println(ex);
            return false;  
        }
    }
    
    //método para remover
    public boolean remover(Obt dados)
    {
        System.out.println("Excluir "+dados.getCodigo());
        String sql = "DELETE FROM Obt WHERE codigo = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getCodigo()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
         //   showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
     public boolean removerAvaliacao(Obt dados)
    {
        String sql = "DELETE FROM Obt WHERE RegistroTreinamento = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getRegistroTreinamento()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
     public void removerObt(String dados)
    {
        String sql = "DELETE FROM Obt WHERE codigoObt = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados); 
            
            stmt.execute();
            
         
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível remover do banco: " + ex);
           
        }
    }
    //método para listar
    public boolean lista()
    {
        String sql = "SELECT * FROM Obt";
        
        List<Obt> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
               
                     Obt dados = new Obt();
                     dados.setCodigo(rs.getString(1));
                     dados.setObtModelo(rs.getString(2));
                     dados.setRegistroTreinamento(rs.getString(3));
                     dados.setData(rs.getString(4)); 
                     dados.setHora(rs.getString(5)); 
                     dados.setTempo(rs.getString(6));
                     dados.setRe(rs.getString(7));
                     dados.setNome(rs.getString(8));
                     dados.setCargo(rs.getString(9));
                     dados.setDepartamento(rs.getString(10));
                     dados.setTipo(rs.getString(11));
                     dados.setCodigoObt(rs.getString(12)); 
                     dados.setNota(rs.getString(13));
                     dados.setMedia(rs.getString(14));
                     dados.setQuantPeguntas(rs.getString(15)); 
                     dados.setQuantErros(rs.getString(16));
                     dados.setAssinaturaFac(rs.getString(17));
                     dados.setAprovaFac(rs.getString(18));
                     dados.setRevisao(rs.getString(19));
                     dados.setUnidade(rs.getString(20));
                     dados.setStatus(rs.getString(21));
                     dados.setAssinaturaFac(rs.getString(22));
                     dados.setAssinaturaSup(rs.getString(23));
               
                
                
                
                
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
    
    public List<Obt> obterObtBusca(String campo, String busca){
     ArrayList<Obt> lista = new ArrayList<Obt>();

          Statement st = null;
          ResultSet rs = null;
       
          try {
                st = con.createStatement();
                String sql = "select * from Obt where "+campo+" like'%"+busca+"%' and unidade ='"+Permissao.getUnidade()+"'";
               rs = st.executeQuery(sql);
               
                while (rs.next()) {
                     String data = rs.getString(4).substring(8)+"/"+rs.getString(4).substring(5,7)+"/"+rs.getString(4).substring(0,4); 
                     String datahj = ""+java.time.LocalDate.now();
                     
                     boolean bot;
                     
                     if(data.equals(datahj)){
                        bot = true ;
                     }else{
                        bot = false ;  
                     }
                     
                     Obt dados = new Obt();
                     dados.setCodigo(rs.getString(1));
                     dados.setObtModelo(rs.getString(2));
                     dados.setRegistroTreinamento(rs.getString(3));
                     dados.setData(data); 
                     dados.setHora(rs.getString(5)); 
                     dados.setTempo(rs.getString(6));
                     dados.setRe(rs.getString(7));
                     dados.setNome(rs.getString(8));
                     dados.setCargo(rs.getString(9));
                     dados.setDepartamento(rs.getString(10));
                     dados.setTipo(rs.getString(11));
                     dados.setCodigoObt(rs.getString(12)); 
                     dados.setNota(rs.getString(13));
                     dados.setMedia(rs.getString(14));
                     dados.setQuantPeguntas(rs.getString(15)); 
                     dados.setQuantErros(rs.getString(16));
                     dados.setAssinaturaFac(rs.getString(17));
                     dados.setAprovaFac(rs.getString(18));
                     dados.setRevisao(rs.getString(19));
                     dados.setUnidade(rs.getString(20));
                     dados.setStatus(rs.getString(21));
                     dados.setAssinaturaFac(rs.getString(22));
                     dados.setAssinaturaSup(rs.getString(23));
                     dados.setBotao(bot);
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectObt.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectObt.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<Obt> carregarObt() throws SQLException{
            
        {
        String sql = "SELECT * FROM obt where unidade = '"+Permissao.getUnidade()+"'";
        
        List<Obt> retorno = new ArrayList<>();
        
        try
        {
           PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
             
                     String data = resultado.getString("data").substring(8)+"/"+resultado.getString("data").substring(5,7)+"/"+resultado.getString("data").substring(0,4);
                     Obt dados = new Obt();
                       
                     dados.setCodigo(resultado.getString("codigo"));
                     dados.setObtModelo(resultado.getString("obtModelo"));
                     dados.setRegistroTreinamento(resultado.getString("RegistroTreinamento"));
                     dados.setData(data); 
                     dados.setHora(resultado.getString("hora")); 
                     dados.setTempo(resultado.getString("tempo"));
                     dados.setRe(resultado.getString("re"));
                     dados.setNome(resultado.getString("nome"));
                     dados.setCargo(resultado.getString("cargo"));
                     dados.setDepartamento(resultado.getString("departamento"));
                     dados.setTipo(resultado.getString("tipo"));
                     dados.setCodigoObt(resultado.getString("codigoObt")); 
                     dados.setNota(resultado.getString("nota"));
                     dados.setMedia(resultado.getString("media"));
                     dados.setQuantPeguntas(resultado.getString("quantPeguntas")); 
                     dados.setQuantErros(resultado.getString("quantErros"));
                     dados.setAssinaturaFac(resultado.getString("assinturaFunc"));
                     dados.setAprovaFac(resultado.getString("aprovaFac"));
                     dados.setRevisao(resultado.getString("revisao"));
                     dados.setUnidade(resultado.getString("unidade"));
                     dados.setStatus(resultado.getString("status"));
                     dados.setAssinaturaFac(resultado.getString("assinaturaFac"));
                     dados.setAssinaturaSup(resultado.getString("assinaturaSup"));
             
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
    public void buscarObt(String userConf) {

         
          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from obt where CodigoObt = '"+userConf+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
                                
              
                    obtModelo = rs.getString("obtModelo");
                    
                    
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectUsuario.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectUsuario.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          
     }
    public List<Obt> obterObtSerch(String campo, String busca){
     ArrayList<Obt> lista = new ArrayList<Obt>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Obt where "+campo+" = '"+busca+"'";
               rs = st.executeQuery(sql);

                while (rs.next()) {
                     String data = rs.getString(4).substring(8)+"/"+rs.getString(4).substring(5,7)+"/"+rs.getString(4).substring(0,4); 
                     String datahj = ""+java.time.LocalDate.now();
                     
                     boolean bot;
                     
                     if(rs.getString(4).equals(datahj)){
                        bot = true ;
                     }else{
                        bot = false ;  
                     }
                     Obt dados = new Obt();
                     dados.setCodigo(rs.getString(1));
                     dados.setObtModelo(rs.getString(2));
                     dados.setRegistroTreinamento(rs.getString(3));
                     dados.setData(data); 
                     dados.setHora(rs.getString(5)); 
                     dados.setTempo(rs.getString(6));
                     dados.setRe(rs.getString(7));
                     dados.setNome(rs.getString(8));
                     dados.setCargo(rs.getString(9));
                     dados.setDepartamento(rs.getString(10));
                     dados.setTipo(rs.getString(11));
                     dados.setCodigoObt(rs.getString(12)); 
                     dados.setNota(rs.getString(13));
                     dados.setMedia(rs.getString(14));
                     dados.setQuantPeguntas(rs.getString(15)); 
                     dados.setQuantErros(rs.getString(16));
                     dados.setAssinaturaFac(rs.getString(17));
                     dados.setAprovaFac(rs.getString(18));
                     dados.setRevisao(rs.getString(19));
                     dados.setUnidade(rs.getString(20));
                     dados.setStatus(rs.getString(21));
                     dados.setAssinaturaFac(rs.getString(22));
                     dados.setAssinaturaSup(rs.getString(23));
                     dados.setBotao(bot);
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectObt.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectObt.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public void alterarNota(String codigoObt, double nota)
    {
        String sql = "UPDATE obt SET nota = ? WHERE codigoObt = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDouble(1, nota);
            stmt.setString(2, codigoObt);
                       
            stmt.execute();
            
           
        }
        catch(SQLException ex)
        { 
         //   showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            System.out.println(ex);
           
        }
    }
    public String findObt(String userConf) {

        String nota = null;
         
          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from obt where CodigoObt = '"+userConf+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
                                
              
                  
                    nota = rs.getString("nota");
                    
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectUsuario.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectUsuario.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          return nota;
     }
} 