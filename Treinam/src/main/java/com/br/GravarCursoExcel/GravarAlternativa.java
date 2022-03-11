package com.br.GravarCursoExcel;

import Conexao.conexaoSQL;
import java.sql.SQLException;

/**
 *
 * @author v103760
 */
public class GravarAlternativa {
conexaoSQL con_sql;
    public GravarAlternativa() {
    }
    public void Gravar(String cod_obt,
                       String desc_obt,
                       String Descricao,
                       String revisao,
                       String QuantPeguntas,
                       String alternativaEscolha,
                       String alternativaA,
                       String alternativaB,
                       String alternativaC,
                       String alternativaD,
                       String alternativaE,
                       String alternativaF,
                       String alternativaG,
                       String alternativaH,
                       String alternativaI,
                       String alternativaJ,
                 
                 
                       String corretoA,
                       String corretoB,
                       String corretoC,
                       String corretoD,
                       String corretoE,
                       String corretoF,
                       String corretoG,
                       String corretoH,
                       String corretoI,
                       String corretoJ,
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
                       String imagemPergunta,
                       String cod_perg1,
                       String unidade
    
    
    
    ){
         con_sql = new conexaoSQL(); 
         con_sql.conecta();
         con_sql.executeSQL("select * from Alternativa");           
                   try
                       
                       
                       
    {
        
        
         String sqlinsert ="insert into Alternativa (cod_obt,"
                 + "desc_obt,"
                 + "Descricao,"
                 + "revisao,"
                 + "QuantPeguntas,"
                 + "AlternativaEscolha,"
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
                 +  "imagemPerg,"  
                 +  "unidade,"  
                 + "cod_perg1) values ('"+
                 
               
                
                        
                    cod_obt+"','"+
                    desc_obt+"','"+
                    Descricao+"','"+
                    revisao+"','"+
                    QuantPeguntas+"','"+
                    alternativaEscolha+"','"+
                    alternativaA+"','"+
                    alternativaB+"','"+
                    alternativaC+"','"+
                    alternativaD+"','"+
                    alternativaE+"','"+
                    alternativaF+"','"+
                    alternativaG+"','"+
                    alternativaH+"','"+
                    alternativaI+"','"+
                    alternativaJ+"','"+
                   
                 
                    corretoA+"','"+
                    corretoB+"','"+
                    corretoC+"','"+
                    corretoD+"','"+
                    corretoE+"','"+
                    corretoF+"','"+
                    corretoG+"','"+
                    corretoH+"','"+
                    corretoI+"','"+
                    corretoJ+"','"+
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
                    imagemPergunta+"','"+
                    unidade+"','"+
                    cod_perg1+"')"; 
                   
                   con_sql.statement.executeUpdate(sqlinsert);         
        //    showMessageDialog(null,"Gravação realizado com sucesso!");
      
     
  //    tf_cal_obtido.setText("");
     con_sql.executeSQL("select * from Alternativa");
  
   //  con_reporta.resultset.first(); //posiciona no primeiro registro
     
      
              }
catch (SQLException | NumberFormatException erro)
{
        //    showMessageDialog(null,"Erro "+erro);
           System.out.println("ERRO "+erro);
     }
        }
}
