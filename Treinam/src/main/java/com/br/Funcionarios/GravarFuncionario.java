package com.br.Funcionarios;


import Conexao.conexaoSQL;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author v103760
 */
public class GravarFuncionario {
conexaoSQL con_sql;
    public GravarFuncionario() {
    }
    public void Gravar(String registro,String nome, String funcao, String departamento, String Unidade, String Imagem){
         con_sql = new conexaoSQL(); 
         con_sql.conecta();
         con_sql.executeSQL("select * from Funcionario");           
                   try
                       
                       
                       
    {
        
        
        
         String sqlinsert ="insert into Funcionario (registro,"
                 + "Nome,"
                 + "Funcao,"
                 + "Departamento,"
                 + "Unidade,"
                
                 + "Imagem) values ('"+
                 
                    registro+"','"+
                    nome+"','"+
                    funcao+"','"+
                    departamento+"','"+
                    Unidade+"','"+
                    Imagem+"')"; 
                 
                   
                 con_sql.statement.executeUpdate(sqlinsert);         
    //        showMessageDialog(null,"Gravação realizado com sucesso!");
      
     
  //    tf_cal_obtido.setText("");
     con_sql.executeSQL("select * from Unidade");
  
   //  con_reporta.resultset.first(); //posiciona no primeiro registro
     
      
              }
catch (SQLException | NumberFormatException erro)
{
            showMessageDialog(null,"Erro "+erro);

     }
        }
    public void GravarLista(String registro,String nome, String departamento, String Unidade, String lista){
         con_sql = new conexaoSQL(); 
         con_sql.conecta();
         con_sql.executeSQL("select * from ListaFunc");           
                   try
                       
                       
                       
    {
        
        
        
         String sqlinsert ="insert into ListaFunc (registro,"
                 + "Nome,"
                 + "Departamento,"
                 + "Unidade,"
                 + "lista) values ('"+
                 
                    registro+"','"+
                    nome+"','"+
                    departamento+"','"+
                    Unidade+"','"+
                    lista+"')"; 
                 
                   
                 con_sql.statement.executeUpdate(sqlinsert);         
    //        showMessageDialog(null,"Gravação realizado com sucesso!");
      
     
  //    tf_cal_obtido.setText("");
     con_sql.executeSQL("select * from Unidade");
  
   //  con_reporta.resultset.first(); //posiciona no primeiro registro
     
      
              }
catch (SQLException | NumberFormatException erro)
{
            showMessageDialog(null,"Erro "+erro);

     }
        }
}
