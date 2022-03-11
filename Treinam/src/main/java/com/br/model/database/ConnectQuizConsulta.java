package com.br.model.database;

import com.br.Alternativa.Alternativa;
import com.br.ControleTreinamento.ControleCurso;
import com.br.Funcionarios.Funcionario;
import com.br.Quiz.AlternativaConsulta;
import com.br.Quiz.NomeImagem;
import com.br.Usuario.Permissao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static javax.swing.JOptionPane.showMessageDialog;


public class ConnectQuizConsulta {
     Connection con = null;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
  
     final private String  url = "jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database;
  //   String conUrl = "jdbc:sqlserver://localhost:1433; databaseName=ctptgmon;user=ctptgmon;password=Paulo2022;";   
     
     public ConnectQuizConsulta() throws SQLException {

          try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("Instalou driver");
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
     public List<Alternativa> listAlternativa() {

          ArrayList<Alternativa> lista = new ArrayList<Alternativa>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Alternativa ";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Alternativa dados = new Alternativa();
                     dados.setCodigo(rs.getInt(1));
                     dados.setCod_obt(rs.getString(2));
                     dados.setDesc_obt(rs.getString(3));
                     dados.setDescricao(rs.getString(4)); 
                     dados.setPesoNota(rs.getString(5));
                     dados.setQuantPeguntas(rs.getString(6));
                     dados.setAlternativaA(rs.getString(7));
                     dados.setAlternativaB(rs.getString(8));
                     dados.setAlternativaC(rs.getString(9));
                     dados.setAlternativaD(rs.getString(10));
                     dados.setAlternativaE(rs.getString(11));
                     dados.setAlternativaF(rs.getString(12));
                     dados.setAlternativaG(rs.getString(13));
                     dados.setAlternativaH(rs.getString(14));
                     dados.setAlternativaI(rs.getString(15));
                     dados.setAlternativaJ(rs.getString(16));
                     dados.setAlternativaK(rs.getString(17));
                     dados.setAlternativaL(rs.getString(18));
                     dados.setAlternativaM(rs.getString(19));
                     dados.setAlternativaN(rs.getString(20));
                     dados.setAlternativaO(rs.getString(21));
                     dados.setAlternativaP(rs.getString(22));
                     dados.setAlternativaQ(rs.getString(23));
                     dados.setAlternativaR(rs.getString(24));
                     dados.setAlternativaS(rs.getString(25)); 
                     dados.setAlternativaT(rs.getString(26)); 
                     dados.setCorretoA(rs.getString(27)); 
                     dados.setCorretoB(rs.getString(28));
                     dados.setCorretoC(rs.getString(29));
                     dados.setCorretoD(rs.getString(30));
                     dados.setCorretoE(rs.getString(31));
                     dados.setCorretoF(rs.getString(32));
                     dados.setCorretoG(rs.getString(33));
                     dados.setCorretoH(rs.getString(34));
                     dados.setCorretoI(rs.getString(35));
                     dados.setCorretoJ(rs.getString(36));
                     dados.setCorretoK(rs.getString(37));
                     dados.setCorretoL(rs.getString(38));
                     dados.setCorretoM(rs.getString(39));
                     dados.setCorretoN(rs.getString(40));
                     dados.setCorretoO(rs.getString(41));
                     dados.setCorretoP(rs.getString(42));
                     dados.setCorretoQ(rs.getString(43));
                     dados.setCorretoR(rs.getString(44));
                     dados.setCorretoS(rs.getString(45));
                     dados.setCorretoT(rs.getString(46));
                     dados.setRevisao(rs.getString(47));
                     dados.setCod_perg1(rs.getString(48));
                     dados.setImagem1(rs.getString(49));        
                     dados.setImagem2(rs.getString(50)); 
                     dados.setImagem3(rs.getString(51)); 
                     dados.setImagem4(rs.getString(52)); 
                     dados.setImagem5(rs.getString(53)); 
                     dados.setImagem6(rs.getString(54)); 
                     dados.setImagem7(rs.getString(55)); 
                     dados.setImagem8(rs.getString(56)); 
                     dados.setImagem9(rs.getString(57)); 
                     dados.setImagem10(rs.getString(58)); 
                     dados.setUnidade(rs.getString(59)); 
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectQuizConsulta.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectQuizConsulta.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
     }
       public boolean inserir(Alternativa dados)
    {
        String sql = "insert into Alternativa (cod_obt,"
                 + "desc_obt,"
                 + "Descricao,"
                 + "revisao,"
                 + "QuantPeguntas,"
                 + "alternativaA,"
                 + "alternativaB,"
                 + "alternativaC,"
                 + "alternativaD,"
                 + "alternativaE,"
                 + "alternativaF,"
                 + "alternativaG,"
                 + "alternativaH,"
                 + "alternativaI,"
                 + "alternativaJ,"
                 + "corretoA,"
                 + "corretoB,"
                 + "corretoC,"
                 + "corretoD,"
                 + "corretoE,"
                 + "corretoF,"
                 + "corretoG,"
                 + "corretoH,"
                 + "corretoI,"
                 + "corretoJ,"
                 +  "imagem1,"
                 +  "imagem2,"
                 +  "imagem3,"
                 +  "imagem4,"
                 +  "imagem5,"
                 +  "imagem6,"
                 +  "imagem7,"
                 +  "imagem8,"
                 +  "imagem9," 
                 +  "imagem10,"  
                 +  "unidade,"  
                 + "cod_perg1) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, dados.getCod_obt());
            stmt.setString(2, dados.getDesc_obt());
            stmt.setString(3, dados.getDescricao());
            stmt.setString(4, dados.getRevisao());
            stmt.setString(5, dados.getQuantPeguntas());
            stmt.setString(6, dados.getAlternativaA());
            stmt.setString(7, dados.getAlternativaB());
            stmt.setString(8, dados.getAlternativaC());
            stmt.setString(9, dados.getAlternativaD());
            stmt.setString(10, dados.getAlternativaE());
            stmt.setString(11, dados.getAlternativaF());
            stmt.setString(12, dados.getAlternativaG());
            stmt.setString(13, dados.getAlternativaH());
            stmt.setString(14, dados.getAlternativaI());
            stmt.setString(15, dados.getAlternativaJ()); 
            stmt.setString(16, dados.getCorretoA()); 
            stmt.setString(17, dados.getCorretoB());  
            stmt.setString(18, dados.getCorretoC()); 
            stmt.setString(19, dados.getCorretoD()); 
            stmt.setString(20, dados.getCorretoE()); 
            stmt.setString(21, dados.getCorretoF()); 
            stmt.setString(22, dados.getCorretoG()); 
            stmt.setString(23, dados.getCorretoH()); 
            stmt.setString(24, dados.getCorretoI()); 
            stmt.setString(25, dados.getCorretoJ()); 
            stmt.setString(26, dados.getImagem1()); 
            stmt.setString(27, dados.getImagem2()); 
            stmt.setString(28, dados.getImagem3()); 
            stmt.setString(29, dados.getImagem4()); 
            stmt.setString(30, dados.getImagem5()); 
            stmt.setString(31, dados.getImagem6()); 
            stmt.setString(32, dados.getImagem7()); 
            stmt.setString(33, dados.getImagem8()); 
            stmt.setString(34, dados.getImagem9());  
            stmt.setString(35, dados.getImagem10()); 
            stmt.setString(36, dados.getUnidade()); 
            stmt.setString(37, dados.getCod_perg1()); 
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
    public boolean alterar(Alternativa dados)
    {
        String sql = "UPDATE Alternativa SET  codigo=?,"
                + "       codigoObt=?,"
                + "       pergunta=?,"
                + "       resposta_A=?,"
                + "       resposta_B=?,"
                + "       resposta_C=?,"
                + "       resposta_D=?,"
                + "       resposta_E=?,"
                + "       resposta_F=?,"
                + "       resposta_G=?,"
                + "       resposta_H=?,"
                + "       resposta_I=?,"
                + "       resposta_J=?,"
                + "       resposta_K=?,"
                + "       resposta_L=?,"
                + "       resposta_M=?,"
                + "       resposta_N=?,"
                + "       resposta_O=?,"
                + "       resposta_P=?,"
                + "       resposta_Q=?,"
                + "       resposta_R=?,"
                + "       resposta_S=?,"
                + "       resposta_T=?,"
                + "       imagem1=?,"
                + "       imagem2=?,"
                + "       imagem3=?,"
                + "       imagem4=?,"
                + "       imagem5=?,"
                + "       imagem6=?,"
                + "       imagem7=?,"
                + "       imagem8=?,"
                + "       imagem9=?,"
                + "       imagem10=?,"
                + "       respostaCorreta=?,"
                + "       nota=?,"
                + "       respondeu=?,"
                + "       cod_perg1=? WHERE codigo = ?";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dados.getCod_obt());
            stmt.setString(2, dados.getDesc_obt());
            stmt.setString(3, dados.getDescricao());
            stmt.setString(4, dados.getRevisao());
            stmt.setString(5, dados.getQuantPeguntas());
            stmt.setString(6, dados.getAlternativaA());
            stmt.setString(7, dados.getAlternativaB());
            stmt.setString(8, dados.getAlternativaC());
            stmt.setString(9, dados.getAlternativaD());
            stmt.setString(10, dados.getAlternativaE());
            stmt.setString(11, dados.getAlternativaF());
            stmt.setString(12, dados.getAlternativaG());
            stmt.setString(13, dados.getAlternativaH());
            stmt.setString(14, dados.getAlternativaI());
            stmt.setString(15, dados.getAlternativaJ());
            stmt.setString(16, dados.getCorretoA());
            stmt.setString(17, dados.getCorretoB());
            stmt.setString(18, dados.getCorretoC());
            stmt.setString(19, dados.getCorretoD());
            stmt.setString(20, dados.getCorretoE());
            stmt.setString(21, dados.getCorretoF());
            stmt.setString(22, dados.getCorretoG());
            stmt.setString(23, dados.getCorretoH());
            stmt.setString(24, dados.getCorretoI());
            stmt.setString(25, dados.getCorretoJ());
            stmt.setString(26, dados.getImagem1());
            stmt.setString(27, dados.getImagem2());
            stmt.setString(28, dados.getImagem3());
            stmt.setString(29, dados.getImagem4());
            stmt.setString(30, dados.getImagem5());
            stmt.setString(31, dados.getImagem6());
            stmt.setString(32, dados.getImagem7());
            stmt.setString(33, dados.getImagem8());
            stmt.setString(34, dados.getImagem9());
            stmt.setString(35, dados.getImagem10());
            stmt.setString(36, dados.getUnidade());
            stmt.setString(37, dados.getCod_perg1());
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
    public boolean remover(Alternativa dados)
    {
        String sql = "DELETE FROM Alternativa WHERE codigo = ?";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ""+dados.getCodigo()); 
            
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
        String sql = "SELECT * FROM ControleCurso";
        
        List<ControleCurso> retorno = new ArrayList<>();
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
    
    public List<Alternativa> obterControleBusca(String campo, String busca){
     ArrayList<Alternativa> lista = new ArrayList<Alternativa>();

          Statement st = null;
          ResultSet rs = null;

          try {
                st = con.createStatement();
                String sql = "select * from Alternativa where "+campo+" like'%"+busca+"%'";
               rs = st.executeQuery(sql);

                while (rs.next()) {

                     Alternativa dados = new Alternativa();
                     dados.setCodigo(rs.getInt(1));
                     dados.setCod_obt(rs.getString(2));
                     dados.setDesc_obt(rs.getString(3));
                     dados.setDescricao(rs.getString(4)); 
                     dados.setPesoNota(rs.getString(5));
                     dados.setQuantPeguntas(rs.getString(6));
                     dados.setAlternativaA(rs.getString(7));
                     dados.setAlternativaB(rs.getString(8));
                     dados.setAlternativaC(rs.getString(9));
                     dados.setAlternativaD(rs.getString(10));
                     dados.setAlternativaE(rs.getString(11));
                     dados.setAlternativaF(rs.getString(12));
                     dados.setAlternativaG(rs.getString(13));
                     dados.setAlternativaH(rs.getString(14));
                     dados.setAlternativaI(rs.getString(15));
                     dados.setAlternativaJ(rs.getString(16));
                     dados.setCorretoA(rs.getString(17)); 
                     dados.setCorretoB(rs.getString(18));
                     dados.setCorretoC(rs.getString(19));
                     dados.setCorretoD(rs.getString(20));
                     dados.setCorretoE(rs.getString(21));
                     dados.setCorretoF(rs.getString(22));
                     dados.setCorretoG(rs.getString(233));
                     dados.setCorretoH(rs.getString(24));
                     dados.setCorretoI(rs.getString(25));
                     dados.setCorretoJ(rs.getString(26));
                     dados.setRevisao(rs.getString(27));
                     dados.setCod_perg1(rs.getString(28));
                     dados.setImagem1(rs.getString(29));        
                     dados.setImagem2(rs.getString(30)); 
                     dados.setImagem3(rs.getString(31)); 
                     dados.setImagem4(rs.getString(32)); 
                     dados.setImagem5(rs.getString(33)); 
                     dados.setImagem6(rs.getString(34)); 
                     dados.setImagem7(rs.getString(35)); 
                     dados.setImagem8(rs.getString(36)); 
                     dados.setImagem9(rs.getString(37)); 
                     dados.setImagem10(rs.getString(38)); 
                     dados.setUnidade(rs.getString(39)); 
                    
                    
                     lista.add(dados);
                }

          } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(ConnectQuizConsulta.class.getName());
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
                     Logger lgr = Logger.getLogger(ConnectQuizConsulta.class.getName());
                     lgr.log(Level.WARNING, ex.getMessage(), ex);
                }
          }
          return lista;
    }
    public List<AlternativaConsulta> carregarAlternativa(String codigo) throws SQLException{
            
        {
        String sql = "SELECT * FROM questionario where codigoObt = '"+codigo+"'";
        
        System.out.println(sql);
        List<AlternativaConsulta> retorno = new ArrayList<>();
        NomeImagem img = new NomeImagem();
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
              
                
                     AlternativaConsulta dados = new AlternativaConsulta();
                     dados.setCodigo(resultado.getString("codigo"));
                     dados.setCodigoObt(resultado.getString("codigoObt"));
                     dados.setPergunta(resultado.getString("pergunta"));
                     dados.setResposta_A(resultado.getString("resposta_A")); 
                     dados.setResposta_B(resultado.getString("resposta_B"));
                     dados.setResposta_C(resultado.getString("resposta_C"));
                     dados.setResposta_D(resultado.getString("resposta_D"));
                     dados.setResposta_E(resultado.getString("resposta_E"));
                     dados.setResposta_F(resultado.getString("resposta_F"));
                     dados.setResposta_G(resultado.getString("resposta_G"));
                     dados.setResposta_H(resultado.getString("resposta_H"));
                     dados.setResposta_I(resultado.getString("resposta_I"));
                     dados.setResposta_J(resultado.getString("resposta_J"));
                     dados.setImagem1(resultado.getString("imagem1"));
                     dados.setImagem2(resultado.getString("imagem2"));
                     dados.setImagem3(resultado.getString("imagem3"));
                     dados.setImagem4(resultado.getString("imagem4"));
                     dados.setImagem5(resultado.getString("imagem5"));
                     dados.setImagem6(resultado.getString("imagem6"));
                     dados.setImagem7(resultado.getString("imagem7"));
                     dados.setImagem8(resultado.getString("imagem8"));
                     dados.setImagem9(resultado.getString("imagem9"));
                     dados.setImagem10(resultado.getString("imagem10"));
                     dados.setImagemPerg(resultado.getString("imagemPerg"));
                     dados.setRespostaCorreta(resultado.getString("respostaCorreta"));
                     dados.setNota(resultado.getString("nota"));
                     dados.setRespondeu(resultado.getString("respondeu"));
                    
                     
                      switch(resultado.getString("respostaCorreta")){
                        case "A":
                            dados.setCorretaA(true);
                            break;
                         case "B":
                            dados.setCorretaB(true);
                            break;
                         case "C":
                            dados.setCorretaC(true);
                            break;
                          case "D":
                            dados.setCorretaD(true);
                            break;
                          case "E":
                            dados.setCorretaE(true);
                            break;
                           case "F":
                            dados.setCorretaF(true);
                            break;
                            case "G":
                            dados.setCorretaG(true);
                            break;
                            case "H":
                            dados.setCorretaH(true);
                            break;
                            case "I":
                            dados.setCorretaI(true);
                            break;
                            case "J":
                            dados.setCorretaJ(true);
                            break; 
                        
                    }
                     
                     
                    switch(resultado.getString("respondeu")){
                        case "A":
                            dados.setRespA(true);
                            break;
                         case "B":
                            dados.setRespB(true);
                            break;
                         case "C":
                            dados.setRespC(true);
                            break;
                          case "D":
                            dados.setRespD(true);
                            break;
                          case "E":
                            dados.setRespE(true);
                            break;
                           case "F":
                            dados.setRespF(true);
                            break;
                            case "G":
                            dados.setRespG(true);
                            break;
                            case "H":
                            dados.setRespH(true);
                            break;
                            case "I":
                            dados.setRespI(true);
                            break;
                            case "J":
                            dados.setRespJ(true);
                            break; 
                        
                    }
                     
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
    
    
    
 public void buscarDescricao(String curso)
    {
        String sql = "select * from Alternativa where cod_obt = '"+curso+"'";
        
        
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
           
             ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next())
            {
              
                 
                  this.setDescricao(resultado.getString("desc_obt"));
            }
            
        }
        catch(SQLException ex)
        { 
         
           FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"+ex));
        }
        
     
    }  
// public List<Imagem> getImagem() {
//        String sql = "select * from tbl_imagem";
//        List<ImagemBean> lista = new ArrayList<ImagemBean>();
//        Imagem imagem = new Imagem();
//        try {
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                imagem.setCodigo(resultSet.getInt("codigo"));
//                imagem.setAlt(resultSet.getString("alt"));
//                imagem.setImagem(resultSet.getBytes("imagem"));
//                
//                imagem.setImagemStreamed(new DefaultStreamedContent(new ByteArrayInputStream(imagem.getImagem())));
//                System.out.println("ImagemStreamed: "+imagem.getImagemStreamed().getName());
//                lista.add(imagem);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(MostraImagemDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MostraImagemDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lista;
//    }   
     
} 