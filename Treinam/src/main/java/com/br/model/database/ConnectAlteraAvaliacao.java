package com.br.model.database;

import com.br.ControleTreinamento.ControleCurso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectAlteraAvaliacao {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectAlteraAvaliacao() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              //  System.out.println("Instalou driver");
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
    
    
    //método para alterar
   
        public boolean alterar(ControleCurso dados)
    {
        String sql = "UPDATE ControleCurso SET Data_inclusao = ?" + //1
"      ,hora_inclusao = ?" +//2
"      ,Data_curso = ?" +//3
"      ,hora_curso = ?" +//4
"      ,Tempo = ?" +//5
"      ,dataValidade = ?" +//6
"      ,obtModelo = ?" +//7
"      ,obtModeloSub = ?" +//8
"      ,subProcesso = ?" +//9
"      ,mapaProcesso = ?" +//10
"      ,status = ?" +//11
"      ,gestor = ?" +//12
"      ,treinamento = ?" +//13
"      ,centroCusto = ?" +//14
"      ,TipoTreinamento = ?" +//15
"      ,NomeTrainamento = ?" +//16
"      ,desc_treinamento = ?" +//17
"      ,Tema = ?" +//18
"      ,obs = ?" +//19
"      ,Tipo = ?" +//20
"      ,CustoTreinamento = ?" +//21
"      ,Fornecedor = ?" +//22
"      ,AvaliacaoReacao = ?" +//23
"      ,Criterio_kpi_avalicao_eficacia = ?" +//24
"      ,avalicaoEficacia = ?" +//25
"      ,dataAvaliaEficacia = ?" +//26
"      ,certificado = ?" +//27
"      ,revisao = ?" +//28                
"      ,anexo = ?" +//29                
"      ,numeroDocumento = ? WHERE RegistroTreinamento = ?";//30 31
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setString(1, dados.getData_inclusao());
            stmt.setString(2, dados.getHora_inclusao());
            stmt.setString(3, dados.getData_curso());
            stmt.setString(4, dados.getHora_curso());
             try{
            stmt.setDouble(5, Double.parseDouble(dados.getTempo()));
            }catch(NumberFormatException e){
             stmt.setDouble(5, 0);   
            }
            stmt.setString(6, dados.getDataValidade());
            stmt.setString(7, dados.getObtModelo());
            stmt.setString(8, dados.getObtModeloSub());
            stmt.setString(9, dados.getSubProcesso());
            stmt.setString(10, dados.getMapaProcesso());
            stmt.setString(11, dados.getStatus());
            stmt.setString(12, dados.getGestor());
            stmt.setString(13, dados.getTreinamento());
            stmt.setString(14, dados.getCentroCusto());
            stmt.setString(15, dados.getTipoTreinamento());
            stmt.setString(16, dados.getNomeTrainamento());
            stmt.setString(17, dados.getDesc_treinamento());
            stmt.setString(18, dados.getTempo());
            stmt.setString(19, dados.getObs());
            stmt.setString(20, dados.getTipo());
            stmt.setString(21, dados.getCustoTreinamento());
            stmt.setString(22, dados.getFornecedor());
            stmt.setString(23, dados.getAvaliacaoReacao());
            stmt.setString(24, dados.getCriterio_kpi_avalicao_eficacia());
            stmt.setString(25, dados.getAvalicaoEficacia());
            stmt.setString(26, dados.getDataAvaliaEficacia());
            stmt.setString(27, dados.getCertificado());
            stmt.setString(28, dados.getRevisao());
            stmt.setString(29, dados.getAnexo());
            stmt.setString(30, dados.getNumeroDocumento());
            stmt.setString(31, dados.getRegistroTreinamento());
            
            stmt.execute();
            
            System.out.println("RegistroTreinamento "+dados.getData_curso());
            return true;
        }
        catch(SQLException ex)
        { 
//            showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            System.out.println(ex);
            return false;  
        }
    }
    
    
 public boolean alterarPessoa(ControleCurso dados)
    {
        String sql = "UPDATE ControleCurso SET  Nome= ?" +
"      ,Cargo = ?" +
"      ,Departamento = ?" +
"      ,Unidade = ? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getNome());
            stmt.setString(2, dados.getCargo());
            stmt.setString(3, dados.getDepartamento());
            stmt.setString(4, dados.getUnidade());
            stmt.setInt(5, dados.getCodigo());
            
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
  