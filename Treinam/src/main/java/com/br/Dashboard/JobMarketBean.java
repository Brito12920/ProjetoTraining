/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Dashboard;

/**
 *
 * @author v103760
 */
import com.br.Funcionarios.Funcionario;
import com.br.Unidade.Unidade;
import com.br.model.database.ConnectFuncionario;
import com.br.model.database.ConnectUnidade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.chart.PieChartModel;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class JobMarketBean {
    
    private List<Unidade> unidade= new ArrayList<>();
    ArrayList<String> ListaUnidade = new ArrayList<>();
    public List<Funcionario> getListFuncionario() {
        return listFuncionario;
    }

    public void setListFuncionario(List<Funcionario> listFuncionario) {
        this.listFuncionario = listFuncionario;
    }
   
  private int TotalGeral;
  private PieChartModel model;
  private List<Funcionario> listFuncionario = new ArrayList<>();
  @PostConstruct
  public void init() {
      model = new PieChartModel();
    
     carregar();
      
      
      
     for(int i=0;i < ListaUnidade.size();i++){
          try {
             
              model.set(ListaUnidade.get(i), this.quantFunc(ListaUnidade.get(i)));//jobs in thousands 
          } catch (SQLException ex) {
              Logger.getLogger(JobMarketBean.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
        
//      model.set(unidade, this.quantFunc("PTG"));//jobs in thousands
    //      model.set(resultados.getUnidade(), this.quantFunc(resultados.getUnidade()));//jobs in thousands 
//      model.set("Python", 46);
//      model.set("JavaScript", 38);
//      model.set("C++", 31);
//      model.set("C#", 27);
//      model.set("PHP", 14);
//      model.set("Perl", 14);

      
      //followings are some optional customizations:
      //set title
      String  ano = ""+java.time.LocalDate.now().getYear();
      model.setTitle(ano+" Total de funcinários "+TotalGeral);
      //set legend position to 'e' (east), other values are 'w', 's' and 'n'
      model.setLegendPosition("e");
      //enable tooltips
      model.setShowDatatip(true);
      //show labels inside pie chart
      model.setShowDataLabels(true);
      //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
      model.setDataFormat("value");
      //format: %d for 'value', %s for 'label', %d%% for 'percent'
      model.setDataLabelFormatString("%d");
      //pie sector colors
      model.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
  }

  public PieChartModel getModel() {
      return model;
  }
   public int quantFunc(String unidade) throws SQLException{
        ConnectFuncionario con = new ConnectFuncionario();
        listFuncionario = con.listFuncionarioGraf(unidade); 
        
        
    //    System.out.println();
        int quantidadeFuncionario = 0;
        for(Funcionario resultados:listFuncionario){
     //    System.out.println(resultados.getStatus());
           if(resultados.getStatus().equals("Ativo") && resultados.getUnidade().equals(unidade)){
                quantidadeFuncionario++;
                
          //      System.out.println(quantidadeFuncionario);
           } 
          
          
      }
        TotalGeral += quantidadeFuncionario;
       return quantidadeFuncionario;
    }
   
   public void carregar(){
          try {
     
        ConnectUnidade con;
     
            con = new ConnectUnidade();
            unidade = con.carregarUnidade();
        
       
        
        for(Unidade resultados:unidade){
         
           if(ListaUnidade.contains(resultados.getUnidade()) || resultados.getUnidade().equals("SANTANA DO PARNAIBA") || resultados.getUnidade().equals("SALTO") || resultados.getUnidade().equals("PONTA GROSSA") || resultados.getUnidade().equals("ITAPEVI")) {
               
           }else{
                ListaUnidade.add(resultados.getUnidade()); 
             
            //    System.out.println(resultados.getUnidade());
           }
          
      }
     } catch (SQLException ex) {
            Logger.getLogger(JobMarketBean.class.getName()).log(Level.SEVERE, null, ex);
        }   
   }
}
