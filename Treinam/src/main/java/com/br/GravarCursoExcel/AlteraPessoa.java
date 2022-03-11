package com.br.GravarCursoExcel;

import Conexao.conexaoSQL;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author v103760
 */
public class AlteraPessoa {
    conexaoSQL con_sql;
    public void Alteração(String codigo,String tabela,String campo,String valor){
       
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from "+tabela+"");
      
            try
       {
             String sql ="UPDATE "+tabela+" SET "+campo+" = '"+valor+"' where codigo = '"+codigo+"'"; 
          //      System.out.println(sql);
                    con_sql.statement.executeUpdate(sql);
                 //  showMessageDialog(null,"Altera��o realizado com sucesso!");
            
            //atualiza o ResultSet
            con_sql.executeSQL("Select * from "+tabela+"");
           // atualiza_combo_box_cliente();
            con_sql.resultset.next(); //posiciona no primeiro registro
       //     mostrar_dados(); //ir� chamar a fun��o em que ir� mstrar os dados no form
            
      
          
           
//            verifica_jTable();
       }
catch (SQLException erro)
{
            showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
}  
      }
public void Alteracao(String codigo,String tabela,String campo,String valor){
       
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from "+tabela+"");
      
            try
       {
             String sql ="UPDATE "+tabela+" SET "+campo+" = '"+valor+"' where registro = '"+codigo+"'"; 
          //      System.out.println(sql);
                    con_sql.statement.executeUpdate(sql);
                 //  showMessageDialog(null,"Altera��o realizado com sucesso!");
            
            //atualiza o ResultSet
            con_sql.executeSQL("Select * from "+tabela+"");
           // atualiza_combo_box_cliente();
            con_sql.resultset.next(); //posiciona no primeiro registro
       //     mostrar_dados(); //ir� chamar a fun��o em que ir� mstrar os dados no form
            
      
          
           
//            verifica_jTable();
       }
catch (SQLException erro)
{
            showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
}  
      }   

public void AlteracaoTudo(String codigo,String tabela,String campo,String valor,String parametro){
       
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from "+tabela+"");
      
            try
       {
             String sql ="UPDATE "+tabela+" SET "+campo+" = '"+valor+"' where "+parametro+" = '"+codigo+"'"; 
              System.out.println(sql);
                    con_sql.statement.executeUpdate(sql);
                 //  showMessageDialog(null,"Altera��o realizado com sucesso!");
            
            //atualiza o ResultSet
            con_sql.executeSQL("Select * from "+tabela+"");
           // atualiza_combo_box_cliente();
            con_sql.resultset.next(); //posiciona no primeiro registro
       //     mostrar_dados(); //ir� chamar a fun��o em que ir� mstrar os dados no form
            
      
          
           
//            verifica_jTable();
       }
catch (SQLException erro)
{
            showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
}  
      }   

public void AlteracaoGeral(String tabela,String campo,String valor,String parametro,String codigo,String parametro2,String codigo2){
       
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from "+tabela+"");
      
            try
       {
             String sql ="UPDATE "+tabela+" SET "+campo+" = '"+valor+"' where "+parametro+" = '"+codigo+"' and "+parametro2+" =  '"+codigo2+"'"; 
      
             System.out.println(sql);
                    con_sql.statement.executeUpdate(sql);
                 //  showMessageDialog(null,"Altera��o realizado com sucesso!");
            
            //atualiza o ResultSet
            con_sql.executeSQL("Select * from "+tabela+"");
           // atualiza_combo_box_cliente();
            con_sql.resultset.next(); //posiciona no primeiro registro
       //     mostrar_dados(); //ir� chamar a fun��o em que ir� mstrar os dados no form
            
      
          
           
//            verifica_jTable();
       }
catch (SQLException erro)
{
            showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
}  
      }   

}
