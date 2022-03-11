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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.br.Imagem.Local;
import com.br.Usuario.Permissao;
import static javax.swing.JOptionPane.showMessageDialog;

public class Connect {
private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    conexaoSQL con_sql;
    
     Connection con = null;

     public Connect() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           //     System.out.println("Instalou driver");
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

     public boolean insertLocal(Local local) {


          try {

                PreparedStatement preparedStatement = con.prepareStatement("insert into Imagem(Modelo,unidade,nomeImagem) values(?,?,?)");
                preparedStatement.setBytes(1, local.getModelo());
                preparedStatement.setString(2, Permissao.getUnidade());
                preparedStatement.setString(3, local.getNomeImagem());
               

                preparedStatement.execute();
                return true;
          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Connect.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                return false;

          }
     }

     public List<Local> listaImagem(String nome) {
System.out.println("aQUI");
          ArrayList<Local> lista = new ArrayList<Local>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Imagem where nomeImagem = '"+nome+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
              //       System.out.println("Erro "+rs.getString(5));
                  
                     Local local = new Local();
                     local.setCodigo(rs.getInt(1));
                     local.setImagem(rs.getString(4));
                     local.setUnidade(rs.getString(3));
                     local.setNomeImagem(rs.getString(5));
                     local.setModelo(rs.getBytes(2));
                     lista.add(local);
                    
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Connect.class.getName());
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
                     Logger lgr = Logger.getLogger(Connect.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          return lista;
     }
     public List<Local> listaImagemGeral() {
System.out.println("aQUI");
          ArrayList<Local> lista = new ArrayList<Local>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Imagem where unidade = '"+Permissao.getUnidade()+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
              //       System.out.println("Erro "+rs.getString(5));
                  
                     Local local = new Local();
                     local.setCodigo(rs.getInt("codigo"));
                     local.setModelo(rs.getBytes("Modelo"));
                     local.setImagem(rs.getString("Imagem"));
                     local.setNomeImagem(rs.getString("NomeImagem"));
                     local.setUnidade(rs.getString("Unidade"));
                     lista.add(local);
                    
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Connect.class.getName());
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
                     Logger lgr = Logger.getLogger(Connect.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          return lista;
     }
      public byte[] imagem() {
System.out.println("Entrou aqui imagem ");   
        byte[] img = null;
          Statement st = null;
          ResultSet rs = null;
          try {
                st = con.createStatement();
                String sql = "select * from Imagem";
                rs = st.executeQuery(sql);

                while (rs.next()) {
                   
                    System.out.println("Tem "+rs.getBytes("Modelo"));
              
                      img = rs.getBytes("Modelo");
                    
                     
                    
                }

          } catch (SQLException ex) {
//                Logger lgr = Logger.getLogger(Connect.class.getName());
//                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                
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
                     Logger lgr = Logger.getLogger(Connect.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          return img;
     }
      public List<Local> listaImagemUnica(String imagem) {
System.out.println("aQUI");
          ArrayList<Local> lista = new ArrayList<Local>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Imagem where NomeImagem = '"+imagem+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
              //       System.out.println("Erro "+rs.getString(5));
                  
                     Local local = new Local();
                     local.setCodigo(rs.getInt("codigo"));
                     local.setModelo(rs.getBytes("Modelo"));
                     local.setImagem(rs.getString("Imagem"));
                     local.setNomeImagem(rs.getString("NomeImagem"));
                     local.setUnidade(rs.getString("Unidade"));
                     lista.add(local);
                    
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Connect.class.getName());
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
                     Logger lgr = Logger.getLogger(Connect.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          return lista;
     }
      public boolean remover(Local local)
    {
        String sql = "DELETE FROM Imagem WHERE codigo = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, local.getCodigo()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
      
    public void AlteracaoGeral(String tabela,String campo,String valor,String parametro,String codigo,String parametro2,String codigo2){
       
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from "+tabela+"");
      
            try
       {
             String sql ="UPDATE "+tabela+" SET "+campo+" = '"+valor+"' where "+parametro+" = '"+codigo+"' and "+parametro2+" =  '"+codigo2+"'"; 
      
             System.out.println(sql);
                    con_sql.statement.executeUpdate(sql);
                 //  showMessageDialog(null,"Altera��o realizado com sucesso!");
            
            //atualiza o ResultSet
            con_sql.executeSQL("Select * from "+tabela+"");
           // atualiza_combo_box_cliente();
            con_sql.resultset.next(); //posiciona no primeiro registro
       //     mostrar_dados(); //ir� chamar a fun��o em que ir� mstrar os dados no form
            
      
          
           
//            verifica_jTable();
       }
catch (SQLException erro)
{
          //  showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
}  
      }     
}
