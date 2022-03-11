package com.br.model.database;

/**
 *
 * @author v103760
 */
import com.br.AvaliacaoTreinador.MedidasTreinamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class ConnectMedidasTreinamento {
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

     public ConnectMedidasTreinamento() throws SQLException {

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

     public boolean insertMedidasTrein(MedidasTreinamento med) {


          try {

                PreparedStatement preparedStatement = con.prepareStatement("insert into MedidasTreinamento(data,codigoObt,obtModelo,demostDominioPostoTrab,linguagemFacilEntendimento,oportPerguntarDuvias,esclarecimentoDuvidas,demostEntusiasmoMotivIncPart,"
                        + "                  apresentFluxoProcesso,realizouAtivNaExplicacao,organizaNoDecorrerTrein,aprendizadoDuranteTreinamento) values(?,?,?,?,?,?,?,?,?,?,?,?)");
              preparedStatement.setString(1, med.getData());
              preparedStatement.setString(2, med.getCodigoObt());
              preparedStatement.setString(3, med.getObtModelo());
              preparedStatement.setInt(4, med.getDemostDominioPostoTrab());
              preparedStatement.setInt(5, med.getLinguagemFacilEntendimento());
              preparedStatement.setInt(6, med.getOportPerguntarDuvias());
              preparedStatement.setInt(7, med.getEsclarecimentoDuvidas());
              preparedStatement.setInt(8, med.getDemostEntusiasmoMotivIncPart());
              preparedStatement.setInt(9, med.getApresentFluxoProcesso());
              preparedStatement.setInt(10, med.getRealizouAtivNaExplicacao());
              preparedStatement.setInt(11, med.getOrganizaNoDecorrerTrein());
              preparedStatement.setInt(12, med.getAprendizadoDuranteTreinamento());

                preparedStatement.execute();
                return true;
          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectMedidasTreinamento.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                return false;

          }
     }

  
       
    //método para remover
  
      public List<MedidasTreinamento> carregarMedidasTreinamento() throws SQLException{
            
        {
        String sql = "SELECT * FROM MedidasTreinamento";
        
        List<MedidasTreinamento> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               MedidasTreinamento dados = new MedidasTreinamento();
                
                dados.setId(resultado.getInt("id"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setObtModelo(resultado.getString("obtModelo"));
               
                dados.setDemostDominioPostoTrab(resultado.getInt("demostDominioPostoTrab"));
                dados.setLinguagemFacilEntendimento(resultado.getInt("linguagemFacilEntendimento"));
                dados.setOportPerguntarDuvias(resultado.getInt("oportPerguntarDuvias"));
                dados.setEsclarecimentoDuvidas(resultado.getInt("esclarecimentoDuvidas"));
                dados.setDemostEntusiasmoMotivIncPart(resultado.getInt("demostEntusiasmoMotivIncPart"));
                dados.setApresentFluxoProcesso(resultado.getInt("apresentFluxoProcesso"));
                dados.setRealizouAtivNaExplicacao(resultado.getInt("realizouAtivNaExplicacao"));
                dados.setOrganizaNoDecorrerTrein(resultado.getInt("organizaNoDecorrerTrein"));
                dados.setAprendizadoDuranteTreinamento(resultado.getInt("aprendizadoDuranteTreinamento"));
                
                
                
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
