/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Quiz;

import Conexao.conexaoSQL;
import com.br.model.database.ConnectObt;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author v103760
 */
public class Nota {
   conexaoSQL con_sql;
   
    public void apontaNota(String codigoObt,int tot) throws SQLException{
     //  System.out.println("Contar");
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from questionario where codigoObt = '"+codigoObt+"'");
      
        System.out.println("select * from questionario where codigoObt = '"+codigoObt+"'");
                
        int total = tot; 
        float nota;
        float notaT = 0;
        try
        {
                 
            while (con_sql.resultset.next()) {
             
             String respCorreta = con_sql.resultset.getString("respostaCorreta");
             String respodeu = con_sql.resultset.getString("respondeu");
             
             if(respCorreta.equals(respodeu)){
                 
                 
                 double a = 10;
                 double b = 25;
                 nota = (float) (a / b);

                 notaT += nota;
                 System.out.println("Nota " + notaT);
                 System.out.println("Total " + total);
             }
                        
            }
          
            if(notaT > 9.9){
                notaT = 10;
            }
            
      ConnectObt obt = new ConnectObt();
      obt.alterarNota(codigoObt, notaT);
            
               }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar no JTable3 "+erro);
}
      
      }
    
   public int totalQuestao(String codigoObt) throws SQLException{
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from obt where codigoObt = '"+codigoObt+"'");
       int total = 0;
       while (con_sql.resultset.next()) {
             
            
             total = Integer.parseInt(con_sql.resultset.getString("quantPeguntas"));
                        
            
       } 
      return total;
   }
}
