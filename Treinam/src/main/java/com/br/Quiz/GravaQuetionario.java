package com.br.Quiz;

import Conexao.conexaoSQL;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author v103760
 */
public class GravaQuetionario {
  
    private double nota;
    private  int perguntas;
    private  int erros;
    conexaoSQL con_sql;
    public void Gravar2(            
                        String codObt,
                        String pergunta,
                        String respostaA,
                        String respostaB,
                        String respostaC,
                        String respostaD,
                        String respostaE,
                        String respostaF,
                        String respostaG,
                        String respostaH,
                        String respostaI,
                        String respostaJ,
                        String alternativa,
                        String respondeu,
                        String imagem1,
                        String imagem2,
                        String imagem3,
                        String imagem4,
                        String imagem5,
                        String imagem6,
                        String imagem7,
                        String imagem8,
                        String imagem9,
                        String imagem10,
                        String imagemPerg,
                        String subCurso,
                        double nota
    ){                  
      
      
        con_sql = new conexaoSQL(); 
         con_sql.conecta();
         con_sql.executeSQL("select * from questionario");            
        
        
             try
    {
        
        
         String sqlinsert ="insert into questionario (codigoObt,"
                 + "pergunta,"
                 + "resposta_A,"
                 + "resposta_B,"
                 + "resposta_C,"
                 + "resposta_D,"
                 + "resposta_E,"
                 + "resposta_F,"
                 + "resposta_G,"
                 + "resposta_H,"
                 + "resposta_I,"
                 + "resposta_J,"
                 + "respostaCorreta,"
                 + "respondeu,"
                 + "imagem1,"
                 + "imagem2,"
                 + "imagem3,"
                 + "imagem4,"
                 + "imagem5,"
                 + "imagem6,"
                 + "imagem7,"
                 + "imagem8,"
                 + "imagem9,"
                 + "imagem10,"
                 + "imagemPerg,"
                 + "cod_perg1,"
                 + "nota) values ('"+
                
                        
                   codObt+"','"+
                   pergunta+"','"+
                   respostaA+"','"+
                   respostaB+"','"+  
                   respostaC+"','"+
                   respostaD+"','"+
                   respostaE+"','"+
                   respostaF+"','"+
                   respostaG+"','"+
                   respostaH+"','"+
                   respostaI+"','"+
                   respostaJ+"','"+
                   alternativa+"','"+
                   respondeu+"','"+
                   imagem1+"','"+
                   imagem2+"','"+
                   imagem3+"','"+
                   imagem4+"','"+
                   imagem5+"','"+
                   imagem6+"','"+
                   imagem7+"','"+
                   imagem8+"','"+
                   imagem9+"','"+
                   imagem10+"','"+
                   imagemPerg+"','"+
                   subCurso+"','"+
                   nota+"')"; 
                   con_sql.statement.executeUpdate(sqlinsert);         
    //  JOptionPane.showMessageDialog(null,"Gravação realizado com sucesso!");
     
     
  //    tf_cal_obtido.setText("");
//     con_monitora.executeSQL("select * from obt");
//     if(cb_codMat.isVisible()==true){
//     gravaNota("UPDATE obt SET nota ='"+acumulaPontos+"' where codigoObt = '"+tf_codigoObt.getText()+"' and cod_perg1 = '"+cb_codMat.getSelectedItem()+"'");    
//     }else{
//     gravaNota("UPDATE obt SET nota ='"+acumulaPontos+"' where codigoObt = '"+tf_codigoObt.getText()+"'");    
//     }
//     
   
//  con_reporta.resultset.first(); //posiciona no primeiro registro
//   proximaPerg();
  
              }
catch (SQLException | NumberFormatException  | NullPointerException erro)
{
   JOptionPane.showMessageDialog(null,"Erro a tentar gravar o producao..."+erro);
  // Mensagem.mensagemErro("Banco questionario", "Erro ao gravar",""+erro);

      }
    
    
    
    
     }    
 
       
      public void atualizaObt(String codigoObt,String nota){
     
    
     contQuant(codigoObt);
       
     gravaNota("UPDATE obt SET nota ='"+nota+"', quantPeguntas = '"+perguntas+"' , data ='"+java.time.LocalDate.now()+"' , quantErros = '"+erros+"' ,status = 'Concluido' where codigoObt = '"+codigoObt+"'");    
    
    AtualizaMatriz("UPDATE ControleCurso SET status = 'Concluido' where codigoObt = '"+codigoObt+"'");    
 }  
       
 
public void contQuant(String codObt){
     
    
       perguntas=0;
       erros=0;
      try
        
        {
               
          //  String sql = consulta;
                    
              con_sql.executeSQL("select * from questionario where codigoObt = '"+codObt+"'");
                
                 
              while (con_sql.resultset.next()) {
              
//                nota += Double.parseDouble(con_sql.resultset.getString("nota"));
                perguntas++;
                
                if(!con_sql.resultset.getString("respostaCorreta").contains(con_sql.resultset.getString("respondeu"))){
                    erros++;
                }
                
                
            }
              
        }      
             catch(SQLException erro)
             {
            
             }
    
     
} 
 
public void gravaNota(String comando){
    
        con_sql = new conexaoSQL();
        con_sql.conecta();
       
      
      
    
       con_sql.executeSQL("select * from obt"); 
      
        try
       {
             String sql =comando; 
                
            con_sql.statement.executeUpdate(sql);
                      
           con_sql.executeSQL("Select * from obt");
           
            con_sql.resultset.next(); //posiciona no primeiro registro
            
    
            
         
       }
catch (SQLException erro)
{
         //   showMessageDialog(null,"Erro a tentar Alterar o registro OBT..."+erro);
         //   Mensagem.mensagemErro("Banco OBT", "Erro a alterar",""+erro);
}  
}
    
 public void AtualizaMatriz(String comando){
    
        con_sql = new conexaoSQL();
        con_sql.conecta();
       
      
      
    
       con_sql.executeSQL("select * from ControleCurso"); 
      
        try
       {
             String sql =comando; 
                
            con_sql.statement.executeUpdate(sql);
                      
           con_sql.executeSQL("Select * from ControleCurso");
           
            con_sql.resultset.next(); //posiciona no primeiro registro
            
    
            
         
       }
catch (SQLException erro)
{
           // showMessageDialog(null,"Erro a tentar Alterar o registro controle curso.."+erro);
        //    Mensagem.mensagemErro("Banco controle", "Erro a alterar",""+erro);
}  
}       
}