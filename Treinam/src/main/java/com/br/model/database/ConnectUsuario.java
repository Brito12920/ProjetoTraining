package com.br.model.database;

/**
 *
 * @author v103760
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.br.Usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class ConnectUsuario {
private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    private String user;
    private String password;
    private String unidade;

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    private String permissao;
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     Connection con = null;

     public ConnectUsuario() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //       System.out.println("Instalou driver");
          } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
          }

          String url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;;
          String user = "ctptgmon";
          String password = "Paulo2022";
          con = DriverManager.getConnection(url, user, password);
     }

     public void closeConnection() throws SQLException {
          con.close();
     }

     public boolean insertUsuario(Usuario user) {


          try {

                PreparedStatement preparedStatement = con.prepareStatement("insert into Usuario(usuario,departamento,Unidade,Tipo,Senha) values(?,?,?,?,?)");
                preparedStatement.setString(1, user.getUsuario());
                preparedStatement.setString(2, user.getDepartamento());
                preparedStatement.setString(3, user.getUnidade());
                preparedStatement.setString(4, user.getTipo());
                preparedStatement.setString(5, user.getSenha());

                preparedStatement.execute();
                return true;
          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectUsuario.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                return false;

          }
     }

     
     public boolean listaUsuarios()
    {
        String sql = "SELECT Usuario.codigo, Usuario.usuario, Usuario.departamento, Usuario.Unidade,Usuario.Tipo,Usuario.Senha"
                + " FROM Usuario " ;
        
        List<Usuario> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Usuario usuario = new Usuario();
                
                 usuario.setCodigo(resultado.getInt("Usuario.codigo"));
                 usuario.setUsuario(resultado.getString("Usuario.usuario"));
                 usuario.setDepartamento(resultado.getString("Usuario.departamento"));
                 usuario.setUnidade(resultado.getString("funcionario.Unidade"));
                 usuario.setTipo(resultado.getString("Usuario.Tipo"));
                 usuario.setSenha(resultado.getString("Usuario.Senha"));
                //vamos adicionando a liss retorno
                 retorno.add(usuario);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
          //  showMessageDialog(null, "Não foi possível listar do banco: " + ex);
            return false;   
        }
        
        return true; 
        
    }
      public boolean alterar(Usuario usuario)
    {
        String sql = "UPDATE Usuario SET usuario = ?, departamento = ?, Unidade= ?, Tipo=?, Senha=? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getDepartamento());
            stmt.setString(3, usuario.getUnidade());
            stmt.setString(4, usuario.getTipo());
            stmt.setString(5, usuario.getSenha());
            stmt.setInt(6, usuario.getCodigo());        
            
            
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
    public boolean remover(Usuario usuario)
    {
        String sql = "DELETE FROM Usuario WHERE usario = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
         //   showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
      public void buscarUsuario(String userConf) {

         
          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Usuario where usuario = '"+userConf+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
                                
                  System.out.println(rs.getString("usuario"));
                    user = rs.getString("usuario");
                    password = rs.getString("Senha");
                    unidade = rs.getString("Unidade");
                    permissao = rs.getString("Tipo");
                    
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
      public List<Usuario> carregarUsuario(String unidade) throws SQLException{
            
        {
        String sql = "SELECT * FROM Usuario where unidade = '"+unidade+"'";
        
        List<Usuario> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Usuario dados = new Usuario();
                
                dados.setCodigo(resultado.getInt("codigo"));
                dados.setUsuario(resultado.getString("usuario"));
                dados.setDepartamento(resultado.getString("departamento"));
                dados.setUnidade(resultado.getString("Unidade"));
                dados.setTipo(resultado.getString("Tipo"));
                dados.setSenha(resultado.getString("Senha"));
                
                retorno.add(dados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
        //    showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        return retorno;
    }

    }
      
      public boolean verificarUsuario(String userConf) {

         
          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Usuario where usuario = '"+userConf+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
                                
                 return true;
                    
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
          return false;
     }
}
