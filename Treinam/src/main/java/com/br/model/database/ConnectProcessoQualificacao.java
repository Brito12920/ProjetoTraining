package com.br.model.database;

/**
 *
 * @author v103760
 */
import com.br.AvaliacaoTreinador.ProcessoQualificacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class ConnectProcessoQualificacao {
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

     public ConnectProcessoQualificacao() throws SQLException {

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

     public boolean insertProcessoQualificacao(ProcessoQualificacao pro) {


          try {

                PreparedStatement preparedStatement = con.prepareStatement("insert into ProcessoQualificacao(data,codigoObt,obtModelo,apresentaPreRequisitosMch,respeitoTempoEtapaApresent,"
                        + "   liberacaoEtapasTreinamentos,nivelAptidaoTreinSegQualiProdutividade,liberacaoOperacaoTodasEtapas) values(?,?,?,?,?,?,?,?)");
              preparedStatement.setString(1, pro.getData());
              preparedStatement.setString(2, pro.getCodigoObt());
              preparedStatement.setString(3, pro.getObtModelo());
              preparedStatement.setInt(4, pro.getApresentaPreRequisitosMch());
              preparedStatement.setInt(5, pro.getApresentaPreRequisitosMch());
              preparedStatement.setInt(6, pro.getRespeitoTempoEtapaApresent());
              preparedStatement.setInt(7, pro.getNivelAptidaoTreinSegQualiProdutividade());
              preparedStatement.setInt(8, pro.getLiberacaoOperacaoTodasEtapas());

                preparedStatement.execute();
                return true;
          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectProcessoQualificacao.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
                return false;

          }
     }

     
         public List<ProcessoQualificacao> carregarProcessoQualificacao() throws SQLException{
            
        {
        String sql = "SELECT * FROM ProcessoQualificacao";
        
        List<ProcessoQualificacao> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               ProcessoQualificacao dados = new ProcessoQualificacao();
                
                dados.setId(resultado.getInt("id"));
                dados.setData(resultado.getString("data"));
                dados.setCodigoObt(resultado.getString("codigoObt"));
                dados.setObtModelo(resultado.getString("obtModelo"));
                dados.setApresentaPreRequisitosMch(resultado.getInt("apresentaPreRequisitosMch"));
                dados.setRespeitoTempoEtapaApresent(resultado.getInt("respeitoTempoEtapaApresent"));
                dados.setLiberacaoEtapasTreinamentos(resultado.getInt("liberacaoEtapasTreinamentos"));
                dados.setNivelAptidaoTreinSegQualiProdutividade(resultado.getInt("nivelAptidaoTreinSegQualiProdutividade"));
                dados.setLiberacaoOperacaoTodasEtapas(resultado.getInt("liberacaoOperacaoTodasEtapas"));
                
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
