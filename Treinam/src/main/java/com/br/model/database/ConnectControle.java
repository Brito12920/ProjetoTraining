package com.br.model.database;

import com.br.ControleTreinamento.ControleCurso;
import com.br.ControleTreinamento.NumeroTreinamento;
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


public class ConnectControle {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectControle() throws SQLException {

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
     public List<ControleCurso> listControle() {

          ArrayList<ControleCurso> lista = new ArrayList<>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from ControleCurso ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     ControleCurso dados = new ControleCurso();
                     dados.setCodigo(rs.getInt(1));
                     dados.setRegistroTreinamento(rs.getString(2));
                     dados.setCodigoObt(rs.getString(3));
                     dados.setRegistro(rs.getString(4)); 
                     dados.setNome(rs.getString(5));
                     dados.setData_inclusao(rs.getString(6));
                     dados.setHora_inclusao(rs.getString(7));
                     dados.setData_curso(rs.getString(8));
                     dados.setHora_curso(rs.getString(9));
                     dados.setTempo(rs.getString(10));
                     dados.setDataValidade(rs.getString(11)); 
                     dados.setObtModelo(rs.getString(12));
                     dados.setObtModeloSub(rs.getString(13));
                     dados.setCargo(rs.getString(14)); 
                     dados.setDepartamento(rs.getString(15));
                     dados.setUnidade(rs.getString(16));
                     dados.setSubProcesso(rs.getString(17));
                     dados.setMapaProcesso(rs.getString(18));
                     dados.setStatus(rs.getString(19));
                     dados.setGestor(rs.getString(20));
                     dados.setTreinamento(rs.getString(21));
                     dados.setCentroCusto(rs.getString(22));
                     dados.setTipoTreinamento(rs.getString(23));
                     dados.setNomeTrainamento(rs.getString(24)); 
                     dados.setDesc_treinamento(rs.getString(25));
                     dados.setTema(rs.getString(26));
                     dados.setObs(rs.getString(27));
                     dados.setCustoTreinamento(rs.getString(28));
                     dados.setFornecedor(rs.getString(29));
                     dados.setCh(rs.getString(30));
                     dados.setAvaliacaoReacao(rs.getString(31));
                     dados.setCriterio_kpi_avalicao_eficacia(rs.getString(32));
                     dados.setAvalicaoEficacia(rs.getString(33));
                     dados.setDataAvaliaEficacia(rs.getString(34)); 
                     dados.setCertificado(rs.getString(35));
                     dados.setRevisao(rs.getString(36));
                     dados.setAnexo(rs.getString(37));
                     dados.setNumeroDocumento(rs.getString(38));
                     
                     
                     
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectControle.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectControle.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(ControleCurso dados)
    {
        String sql = "INSERT INTO ControleCurso (RegistroTreinamento"
                + "      ,CodigoObt"
                + "      ,Registro"
                + "      ,Nome"
                + "      ,Data_inclusao"
                + "      ,hora_inclusao"
                + "      ,Data_curso"
                + "      ,hora_curso"
                + "      ,Tempo"
                + "      ,dataValidade"
                + "      ,obtModelo"
                + "      ,obtModeloSub"
                + "      ,Cargo"
                + "      ,Departamento"
                + "      ,Unidade"
                + "      ,subProcesso"
                + "      ,mapaProcesso"
                + "      ,status"
                + "      ,gestor"
                + "      ,treinamento"
                + "      ,centroCusto"
                + "      ,TipoTreinamento"
                + "      ,NomeTrainamento"
                + "      ,desc_treinamento"
                + "      ,Tema"
                + "      ,obs"
                + "      ,Tipo"
                + "      ,CustoTreinamento"
                + "      ,Fornecedor"
                + "      ,Ch"
                + "      ,AvaliacaoReacao"
                + "      ,Criterio_kpi_avalicao_eficacia"
                + "      ,avalicaoEficacia"
                + "      ,dataAvaliaEficacia"
                + "      ,certificado"
                + "      ,revisao"
                + "      ,anexo"
                + "      ,numeroDocumento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getRegistroTreinamento());
            stmt.setString(2, dados.getCodigoObt());
            stmt.setString(3, dados.getRegistro());
            stmt.setString(4, dados.getNome());
            stmt.setString(5, dados.getData_inclusao());
            stmt.setString(6, dados.getHora_inclusao());
            stmt.setString(7, dados.getData_curso());
            stmt.setString(8, dados.getHora_curso());
            stmt.setString(9, dados.getTempo());
            stmt.setString(10, dados.getDataValidade());
            stmt.setString(11, dados.getObtModelo());
            stmt.setString(12, dados.getObtModeloSub());
            stmt.setString(13, dados.getCargo());
            stmt.setString(14, dados.getDepartamento());
            stmt.setString(15, dados.getUnidade());
            stmt.setString(16, dados.getSubProcesso());
            stmt.setString(17, dados.getMapaProcesso());
            stmt.setString(18, dados.getStatus());
            stmt.setString(19, dados.getGestor());
            stmt.setString(20, dados.getTreinamento());
            stmt.setString(21, dados.getCentroCusto());
            stmt.setString(22, dados.getTipoTreinamento());
            stmt.setString(23, dados.getNomeTrainamento());
            stmt.setString(24, dados.getDesc_treinamento());
            stmt.setString(25, dados.getTempo());
            stmt.setString(26, dados.getObs());
            stmt.setString(27, dados.getTipo());
            stmt.setString(28, dados.getCustoTreinamento());
            stmt.setString(29, dados.getFornecedor());
            stmt.setString(30, dados.getCh());
            stmt.setString(31, dados.getAvaliacaoReacao());
            stmt.setString(32, dados.getCriterio_kpi_avalicao_eficacia());
            stmt.setString(33, dados.getAvalicaoEficacia());
            stmt.setString(34, dados.getDataAvaliaEficacia());
            stmt.setString(35, dados.getCertificado());
            stmt.setString(36, dados.getRevisao());
            stmt.setString(36, dados.getAnexo());
            stmt.setString(37, dados.getNumeroDocumento());
          
            
            
                       
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
    public boolean alterar(ControleCurso dados)
    {
        String sql = "UPDATE ControleCurso SET   RegistroTreinamento = ?" +
"      ,CodigoObt = ?" +
"      ,Registro = ?" +
"      ,Nome = ?" +
"      ,Data_inclusao = ?" +
"      ,hora_inclusao = ?" +
"      ,Data_curso = ?" +
"      ,hora_curso = ?" +
"      ,Tempo = ?" +
"      ,dataValidade = ?" +
"      ,obtModelo = ?" +
"      ,obtModeloSub = ?" +
"      ,Cargo = ?" +
"      ,Departamento = ?" +
"      ,Unidade = ?" +
"      ,subProcesso = ?" +
"      ,mapaProcesso = ?" +
"      ,status = ?" +
"      ,gestor = ?" +
"      ,treinamento = ?" +
"      ,centroCusto = ?" +
"      ,TipoTreinamento = ?" +
"      ,NomeTrainamento = ?" +
"      ,desc_treinamento = ?" +
"      ,Tema = ?" +
"      ,obs = ?" +
"      ,Tipo = ?" +
"      ,CustoTreinamento = ?" +
"      ,Fornecedor = ?" +
"      ,Ch = ?" +
"      ,AvaliacaoReacao = ?" +
"      ,Criterio_kpi_avalicao_eficacia = ?" +
"      ,avalicaoEficacia = ?" +
"      ,dataAvaliaEficacia = ?" +
"      ,certificado = ?" +
"      ,numeroDocumento = ? WHERE RegistroTreinamento = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getRegistroTreinamento());
            stmt.setString(2, dados.getCodigoObt());
            stmt.setString(3, dados.getRegistro());
            stmt.setString(4, dados.getNome());
            stmt.setString(5, dados.getData_inclusao());
            stmt.setString(6, dados.getHora_inclusao());
            stmt.setString(7, dados.getData_curso());
            stmt.setString(8, dados.getHora_curso());
            stmt.setString(9, dados.getTempo());
            stmt.setString(10, dados.getDataValidade());
            stmt.setString(11, dados.getObtModelo());
            stmt.setString(12, dados.getObtModeloSub());
            stmt.setString(13, dados.getCargo());
            stmt.setString(14, dados.getDepartamento());
            stmt.setString(15, dados.getUnidade());
            stmt.setString(16, dados.getSubProcesso());
            stmt.setString(17, dados.getMapaProcesso());
            stmt.setString(18, dados.getStatus());
            stmt.setString(19, dados.getGestor());
            stmt.setString(20, dados.getTreinamento());
            stmt.setString(21, dados.getCentroCusto());
            stmt.setString(22, dados.getTipoTreinamento());
            stmt.setString(23, dados.getNomeTrainamento());
            stmt.setString(24, dados.getDesc_treinamento());
            stmt.setString(25, dados.getTempo());
            stmt.setString(26, dados.getObs());
            stmt.setString(27, dados.getTipo());
            stmt.setString(28, dados.getCustoTreinamento());
            stmt.setString(29, dados.getFornecedor());
            stmt.setString(30, dados.getCh());
            stmt.setString(31, dados.getAvaliacaoReacao());
            stmt.setString(32, dados.getCriterio_kpi_avalicao_eficacia());
            stmt.setString(33, dados.getAvalicaoEficacia());
            stmt.setString(34, dados.getDataAvaliaEficacia());
            stmt.setString(35, dados.getCertificado());
            stmt.setString(36, dados.getNumeroDocumento());
            stmt.setString(37, dados.getRegistroTreinamento());
            
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
    public boolean remover(ControleCurso dados)
    {
        String sql = "DELETE FROM ControleCurso WHERE codigo = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dados.getCodigo()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
    public boolean removerAvaliacao(ControleCurso dados)
    {
        String sql = "DELETE FROM ControleCurso WHERE RegistroTreinamento = ?";
        
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
     public void removerControle(String codigoObt)
    {
        String sql = "DELETE FROM ControleCurso WHERE CodigoObt = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, codigoObt); 
            
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
        String sql = "SELECT * FROM ControleCurso";
        
        List<ControleCurso> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                ControleCurso dados = new ControleCurso();
                dados.setCodigo(resultado.getInt("codigo"));
                dados.setRegistroTreinamento(resultado.getString("RegistroTreinamento"));
                dados.setCodigoObt(resultado.getString("CodigoObt"));
                dados.setRegistro(resultado.getString("Registro"));
                dados.setNome(resultado.getString("Nome"));
                dados.setData_inclusao(resultado.getString("Data_inclusao"));
                dados.setHora_inclusao(resultado.getString("hora_inclusao"));
                dados.setData_curso(resultado.getString("Data_curso"));
                dados.setHora_curso(resultado.getString("hora_curso"));
                dados.setTempo(resultado.getString("Tempo"));
                dados.setDataValidade(resultado.getString("dataValidade"));
                dados.setObtModelo(resultado.getString("obtModelo"));
                dados.setObtModeloSub(resultado.getString("obtModeloSub"));
                dados.setCargo(resultado.getString("Cargo"));
                dados.setDepartamento(resultado.getString("Departamento"));
                dados.setUnidade(resultado.getString("Unidade"));
                dados.setSubProcesso(resultado.getString("subProcesso"));
                dados.setMapaProcesso(resultado.getString("mapaProcesso"));
                dados.setStatus(resultado.getString("status"));
                dados.setGestor(resultado.getString("gestor"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setCentroCusto(resultado.getString("centroCusto"));
                dados.setTipoTreinamento(resultado.getString("TipoTreinamento"));
                dados.setNomeTrainamento(resultado.getString("NomeTrainamento"));
                dados.setDesc_treinamento(resultado.getString("desc_treinamento"));
                dados.setTema(resultado.getString("Tema"));
                dados.setObs(resultado.getString("obs"));
                dados.setTipo(resultado.getString("Tipo"));
                dados.setCustoTreinamento(resultado.getString("CustoTreinamento"));
                dados.setFornecedor(resultado.getString("Fornecedor"));
                dados.setCh(resultado.getString("Ch"));
                dados.setAvaliacaoReacao(resultado.getString("AvaliacaoReacao"));
                dados.setCriterio_kpi_avalicao_eficacia(resultado.getString("Criterio_kpi_avalicao_eficacia"));
                dados.setAvalicaoEficacia(resultado.getString("avalicaoEficacia"));
                dados.setDataAvaliaEficacia(resultado.getString("dataAvaliaEficacia"));
                dados.setCertificado(resultado.getString("certificado"));
                dados.setRevisao(resultado.getString("revisao"));
                dados.setAnexo(resultado.getString("anexo"));
                dados.setNumeroDocumento(resultado.getString("numeroDocumento"));
               
                
                
                
                
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
   
    public List<ControleCurso> obterControleBusca(String campo, String busca){
     ArrayList<ControleCurso> lista = new ArrayList<>();

          Statement st = null;
          ResultSet resultado = null;

          try {
                st = con.createStatement();
                String sql = "select * from ControleCurso where "+campo+" like'%"+busca+"%'";
               resultado = st.executeQuery(sql);

                while (resultado.next()) {

                     ControleCurso dados = new ControleCurso();
                    dados.setCodigo(resultado.getInt("codigo"));
                dados.setRegistroTreinamento(resultado.getString("RegistroTreinamento"));
                dados.setCodigoObt(resultado.getString("CodigoObt"));
                dados.setRegistro(resultado.getString("Registro"));
                dados.setNome(resultado.getString("Nome"));
                dados.setData_inclusao(resultado.getString("Data_inclusao"));
                dados.setHora_inclusao(resultado.getString("hora_inclusao"));
                dados.setData_curso(resultado.getString("Data_curso"));
                dados.setHora_curso(resultado.getString("hora_curso"));
                dados.setTempo(resultado.getString("Tempo"));
                dados.setDataValidade(resultado.getString("dataValidade"));
                dados.setObtModelo(resultado.getString("obtModelo"));
                dados.setObtModeloSub(resultado.getString("obtModeloSub"));
                dados.setCargo(resultado.getString("Cargo"));
                dados.setDepartamento(resultado.getString("Departamento"));
                dados.setUnidade(resultado.getString("Unidade"));
                dados.setSubProcesso(resultado.getString("subProcesso"));
                dados.setMapaProcesso(resultado.getString("mapaProcesso"));
                dados.setStatus(resultado.getString("status"));
                dados.setGestor(resultado.getString("gestor"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setCentroCusto(resultado.getString("centroCusto"));
                dados.setTipoTreinamento(resultado.getString("TipoTreinamento"));
                dados.setNomeTrainamento(resultado.getString("NomeTrainamento"));
                dados.setDesc_treinamento(resultado.getString("desc_treinamento"));
                dados.setTema(resultado.getString("Tema"));
                dados.setObs(resultado.getString("obs"));
                dados.setTipo(resultado.getString("Tipo"));
                dados.setCustoTreinamento(resultado.getString("CustoTreinamento"));
                dados.setFornecedor(resultado.getString("Fornecedor"));
                dados.setCh(resultado.getString("Ch"));
                dados.setAvaliacaoReacao(resultado.getString("AvaliacaoReacao"));
                dados.setCriterio_kpi_avalicao_eficacia(resultado.getString("Criterio_kpi_avalicao_eficacia"));
                dados.setAvalicaoEficacia(resultado.getString("avalicaoEficacia"));
                dados.setDataAvaliaEficacia(resultado.getString("dataAvaliaEficacia"));
                dados.setCertificado(resultado.getString("certificado"));
                dados.setRevisao(resultado.getString("revisao"));
                dados.setAnexo(resultado.getString("anexo"));
                dados.setNumeroDocumento(resultado.getString("numeroDocumento"));
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectControle.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);

          } finally {
                try {
                     if (resultado != null) {
                          resultado.close();
                     }
                     if (st != null) {
                          st.close();
                     }
                     if (con != null) {
                          con.close();
                     }

                } catch (SQLException ex) {
                     Logger lgr = Logger.getLogger(ConnectControle.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<ControleCurso> carregarControle() throws SQLException{
            
        {
        String sql = "SELECT * FROM ControleCurso where unidade = '"+Permissao.getUnidade()+"' order by codigo desc";
     //    String sql = "SELECT * FROM ControleCurso where unidade = '"+Permissao.getUnidade()+"'";
        List<ControleCurso> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               ControleCurso dados = new ControleCurso();
                
                dados.setCodigo(resultado.getInt("codigo"));
                dados.setRegistroTreinamento(resultado.getString("RegistroTreinamento"));
                dados.setCodigoObt(resultado.getString("CodigoObt"));
                dados.setRegistro(resultado.getString("Registro"));
                dados.setNome(resultado.getString("Nome"));
                dados.setData_inclusao(resultado.getString("Data_inclusao"));
                dados.setHora_inclusao(resultado.getString("hora_inclusao"));
                dados.setData_curso(resultado.getString("Data_curso"));
                dados.setHora_curso(resultado.getString("hora_curso"));
                dados.setTempo(resultado.getString("Tempo"));
                dados.setDataValidade(resultado.getString("dataValidade"));
                dados.setObtModelo(resultado.getString("obtModelo"));
                dados.setObtModeloSub(resultado.getString("obtModeloSub"));
                dados.setCargo(resultado.getString("Cargo"));
                dados.setDepartamento(resultado.getString("Departamento"));
                dados.setUnidade(resultado.getString("Unidade"));
                dados.setSubProcesso(resultado.getString("subProcesso"));
                dados.setMapaProcesso(resultado.getString("mapaProcesso"));
                dados.setStatus(resultado.getString("status"));
                dados.setGestor(resultado.getString("gestor"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setCentroCusto(resultado.getString("centroCusto"));
                dados.setTipoTreinamento(resultado.getString("TipoTreinamento"));
                dados.setNomeTrainamento(resultado.getString("NomeTrainamento"));
                dados.setDesc_treinamento(resultado.getString("desc_treinamento"));
                dados.setTema(resultado.getString("Tema"));
                dados.setObs(resultado.getString("obs"));
                dados.setTipo(resultado.getString("Tipo"));
                dados.setCustoTreinamento(resultado.getString("CustoTreinamento"));
                dados.setFornecedor(resultado.getString("Fornecedor"));
                dados.setCh(resultado.getString("Ch"));
                dados.setAvaliacaoReacao(resultado.getString("AvaliacaoReacao"));
                dados.setCriterio_kpi_avalicao_eficacia(resultado.getString("Criterio_kpi_avalicao_eficacia"));
                dados.setAvalicaoEficacia(resultado.getString("avalicaoEficacia"));
                dados.setDataAvaliaEficacia(resultado.getString("dataAvaliaEficacia"));
                dados.setCertificado(resultado.getString("certificado"));
                dados.setRevisao(resultado.getString("revisao"));
                dados.setAnexo(resultado.getString("anexo"));
                dados.setNumeroDocumento(resultado.getString("numeroDocumento"));
               
             
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
    public List<ControleCurso> AutoCompleControle(String reg) throws SQLException{
            
        {
        String sql = "SELECT * FROM ControleCurso where RegistroTreinamento ='%"+reg+"%'";
        
        List<ControleCurso> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
               ControleCurso dados = new ControleCurso();
                
                dados.setCodigo(resultado.getInt("codigo"));
                dados.setRegistroTreinamento(resultado.getString("RegistroTreinamento"));
                dados.setCodigoObt(resultado.getString("CodigoObt"));
                dados.setRegistro(resultado.getString("Registro"));
                dados.setNome(resultado.getString("Nome"));
                dados.setData_inclusao(resultado.getString("Data_inclusao"));
                dados.setHora_inclusao(resultado.getString("hora_inclusao"));
                dados.setData_curso(resultado.getString("Data_curso"));
                dados.setHora_curso(resultado.getString("hora_curso"));
                dados.setTempo(resultado.getString("Tempo"));
                dados.setDataValidade(resultado.getString("dataValidade"));
                dados.setObtModelo(resultado.getString("obtModelo"));
                dados.setObtModeloSub(resultado.getString("obtModeloSub"));
                dados.setCargo(resultado.getString("Cargo"));
                dados.setDepartamento(resultado.getString("Departamento"));
                dados.setUnidade(resultado.getString("Unidade"));
                dados.setSubProcesso(resultado.getString("subProcesso"));
                dados.setMapaProcesso(resultado.getString("mapaProcesso"));
                dados.setStatus(resultado.getString("status"));
                dados.setGestor(resultado.getString("gestor"));
                dados.setTreinamento(resultado.getString("treinamento"));
                dados.setCentroCusto(resultado.getString("centroCusto"));
                dados.setTipoTreinamento(resultado.getString("TipoTreinamento"));
                dados.setNomeTrainamento(resultado.getString("NomeTrainamento"));
                dados.setDesc_treinamento(resultado.getString("desc_treinamento"));
                dados.setTema(resultado.getString("Tema"));
                dados.setObs(resultado.getString("obs"));
                dados.setTipo(resultado.getString("Tipo"));
                dados.setCustoTreinamento(resultado.getString("CustoTreinamento"));
                dados.setFornecedor(resultado.getString("Fornecedor"));
                dados.setCh(resultado.getString("Ch"));
                dados.setAvaliacaoReacao(resultado.getString("AvaliacaoReacao"));
                dados.setCriterio_kpi_avalicao_eficacia(resultado.getString("Criterio_kpi_avalicao_eficacia"));
                dados.setAvalicaoEficacia(resultado.getString("avalicaoEficacia"));
                dados.setDataAvaliaEficacia(resultado.getString("dataAvaliaEficacia"));
                dados.setCertificado(resultado.getString("certificado"));
                dados.setRevisao(resultado.getString("revisao"));
                dados.setAnexo(resultado.getString("anexo"));
                dados.setNumeroDocumento(resultado.getString("numeroDocumento"));
               
             
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
   
  public List<NumeroTreinamento> carregarTreinamento() throws SQLException{
            System.out.println("Entrou aqui");
        {
        String sql = "SELECT * FROM ControleCurso";
        
        List<NumeroTreinamento> retorno = new ArrayList<>();
        
        try
        {
           PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
             
                
                      NumeroTreinamento dados = new NumeroTreinamento();
                     
                     dados.setNumeroTreinamento(resultado.getString("RegistroTreinamento"));
                     
             
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
   public List<NumeroTreinamento> carregarTreinamentoPesp(String valor) throws SQLException{
            
          
           System.out.println("Entrou aqui"+Permissao.getUnidade());
        {
//        String sql = "SELECT * FROM ControleCurso where unidade ='"+Permissao.getUnidade()+"' order by RegistroTreinamento";
        String sql = "SELECT DISTINCT RegistroTreinamento FROM ControleCurso where unidade ='"+Permissao.getUnidade()+"'";
        List<NumeroTreinamento> retorno = new ArrayList<>();
        
        try
        {
           PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
             
                
                      NumeroTreinamento dados = new NumeroTreinamento();
                     
                     dados.setNumeroTreinamento(resultado.getString("RegistroTreinamento"));
                     
             
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
} 