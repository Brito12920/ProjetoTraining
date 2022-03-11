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
import com.br.PDF.Pdf;
import static javax.swing.JOptionPane.showMessageDialog;

public class ConnectPdf {
private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
     Connection con = null;

     public ConnectPdf() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("Instalou driver");
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

@SuppressWarnings("ImplicitArrayToString")
     public boolean insertLocal(Pdf local,String RegTreinamento,String nomePDF) {

         System.out.println(""+local.getArquivo());
         System.out.println("Nome Registro"+local.getRegistroTreinamento());

          try {

                PreparedStatement preparedStatement = con.prepareStatement("insert pdf(arquivo,nome,RegistroTreinamento) values(?,?,?)");
               
                preparedStatement.setBytes(1, local.getArquivo());
                preparedStatement.setString(2, nomePDF);
                preparedStatement.setString(3, RegTreinamento);
               
                
                
               preparedStatement.execute();
               alterarPessoa(RegTreinamento,RegTreinamento);
                return true;
          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectPdf.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                return false;

          }
       //  return true;
     }

     public List<Pdf> listaImagem(String nome) {
System.out.println("aQUI");
          ArrayList<Pdf> lista = new ArrayList<Pdf>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Pdf where RegistroTreinamento = '"+nome+"'";
                rs = st.executeQuery(sql);

                while (rs.next()) {
              //       System.out.println("Erro "+rs.getString(5));
                  
                     Pdf local = new Pdf();
                     local.setCodigo(rs.getInt(1));
                     local.setRegistroTreinamento(rs.getString(2));
                     local.setArquivo(rs.getBytes(3));
                     lista.add(local);
                    
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectPdf.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectPdf.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          return lista;
     }
     public List<Pdf> listaImagemGeral() {
System.out.println("aQUI");
          ArrayList<Pdf> lista = new ArrayList<Pdf>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from pdf";
                rs = st.executeQuery(sql);

                while (rs.next()) {
                     System.out.println("Nome "+rs.getString(2));
                  
                     Pdf local = new Pdf();
                     local.setCodigo(rs.getInt(1));
                     local.setArquivo(rs.getBytes(3));
                     local.setNome(rs.getString(2));
                     local.setRegistroTreinamento(rs.getString(4));
                     
                     lista.add(local);
                    
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectPdf.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectPdf.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                      System.out.println("Erro "+ex);
                }
          }
          return lista;
     }
     public List<Pdf> carregarPdf(String reg) throws SQLException{
            
        {
        String sql = "SELECT * FROM pdf where RegistroTreinamento = '"+reg+"'";
        
        List<Pdf> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Pdf dados = new Pdf();
                
                dados.setCodigo(resultado.getInt("codigo"));
                dados.setNome(resultado.getString("nome"));
                dados.setRegistroTreinamento(resultado.getString("RegistroTreinamento"));
             
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
     public boolean alterarPessoa(String anexo, String registroTreinamento)
    {
        String sql = "UPDATE ControleCurso SET  anexo= ?  WHERE RegistroTreinamento = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, "Sim");
            stmt.setString(2, registroTreinamento);
                       
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
//            showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            System.out.println(ex);
            return false;  
        }
    }
}
