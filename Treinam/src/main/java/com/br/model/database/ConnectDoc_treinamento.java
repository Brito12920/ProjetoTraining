package com.br.model.database;

/**
 *
 * @author v103760
 */
import com.br.AvaliacaoTreinador.Doc_treinamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class ConnectDoc_treinamento {
private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
   

  

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    private String permissao;
    
    Connection con = null;

     public ConnectDoc_treinamento() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //    System.out.println("Instalou driver");
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

     public boolean insertDocTreinamento(Doc_treinamento doc) {


          try {

                PreparedStatement preparedStatement = con.prepareStatement("insert into Doc_treinamento(data,codigoObt,obtModelo,"
                        + "instrucaoTrabalho,"
                        + "planoControle,"
                        + "auxVisual,"
                        + "roteiroFisicoSap,"
                        + "fichaEfeito_fichaBoqueio,"
                        + "fichaAcomp_fichaIndMat,"
                        + "fichaLiberacao,"
                        + "LaiaPaeAprFispq,"
                        + "politicaAmbiental,"
                        + "politicaMeioAmbiente) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
              preparedStatement.setString(1, doc.getData());
              preparedStatement.setString(2, doc.getCodigoObt());
              preparedStatement.setString(3, doc.getObtModelo());
              preparedStatement.setInt(4, doc.getInstrucaoTrabalho());
              preparedStatement.setInt(5, doc.getPlanoControle());
              preparedStatement.setInt(6, doc.getAuxVisual());
              preparedStatement.setInt(7, doc.getRoteiroFisicoSap());
              preparedStatement.setInt(8, doc.getFichaEfeito_fichaBoqueio());
              preparedStatement.setInt(9, doc.getFichaAcomp_fichaIndMat());
              preparedStatement.setInt(10, doc.getFichaLiberacao());
              preparedStatement.setInt(11, doc.getLaiaPaeAprFispq());
              preparedStatement.setInt(12, doc.getPoliticaAmbiental());
              preparedStatement.setInt(13, doc.getPoliticaMeioAmbiente());

                preparedStatement.execute();
                return true;
          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectDoc_treinamento.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                return false;

          }
     }

     
  
    //método para remover
    public boolean remover(Doc_treinamento doc)
    {
        String sql = "DELETE FROM Doc_treinamento WHERE id = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, doc.getId()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
         //   showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
      
      public List<Doc_treinamento> carregarDocTreinamento() throws SQLException{
            
        {
        String sql = "SELECT * FROM Doc_treinamento";
        
        List<Doc_treinamento> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               Doc_treinamento dados = new Doc_treinamento();
                
                dados.setId(resultado.getInt("id"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setObtModelo(resultado.getString("obtModelo"));
                dados.setInstrucaoTrabalho(resultado.getInt("instrucaoTrabalho"));
                dados.setPlanoControle(resultado.getInt("planoControle"));
                dados.setAuxVisual(resultado.getInt("auxVisual"));
                dados.setRoteiroFisicoSap(resultado.getInt("roteiroFisicoSap"));
                dados.setFichaEfeito_fichaBoqueio(resultado.getInt("fichaEfeito_fichaBoqueio"));
                dados.setFichaAcomp_fichaIndMat(resultado.getInt("fichaAcomp_fichaIndMat"));
                dados.setFichaLiberacao(resultado.getInt("fichaLiberacao"));
                dados.setLaiaPaeAprFispq(resultado.getInt("LaiaPaeAprFispq"));
                dados.setPoliticaAmbiental(resultado.getInt("politicaAmbiental"));
                dados.setPoliticaMeioAmbiente(resultado.getInt("politicaMeioAmbiente"));
                
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
}
