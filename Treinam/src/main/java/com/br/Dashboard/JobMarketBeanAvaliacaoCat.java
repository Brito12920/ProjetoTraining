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
import com.br.AvaliacaoTreinador.Avaliacao;
import com.br.model.database.ConnectAvaliacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.model.chart.PieChartModel;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class JobMarketBeanAvaliacaoCat {
    
    private List<Avaliacao> avaliacao= new ArrayList<>();
    ArrayList<String> ListaAvaliacao = new ArrayList<>();
    public static String unit;

    public static String getUnit() {
        return unit;
    }

    public static void setUnit(String unit) {
        JobMarketBeanAvaliacaoCat.unit = unit;
    }
   
  private int TotalGeral;
  private PieChartModel model;
   
  @PostConstruct
  public void init() {
      model = new PieChartModel();
    
     carregar();
      
      
      
     for(int i=0;i < ListaAvaliacao.size();i++){
          try {
             
              model.set(ListaAvaliacao.get(i)+" - "+this.Pontuacao(ListaAvaliacao.get(i)), this.Pontuacao(ListaAvaliacao.get(i)));//jobs in thousands 
          } catch (SQLException ex) {
              Logger.getLogger(JobMarketBeanAvaliacaoCat.class.getName()).log(Level.SEVERE, null, ex);
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
      model.setTitle(ano+"Categorias Avaliadas "+model.getDiameter());
      //set legend position to 'e' (east), other values are 'w', 's' and 'n'
      model.setLegendPosition("w");
      //enable tooltips
      model.setShowDatatip(true);
      //show labels inside pie chart
      model.setShowDataLabels(true);
      //show label text  as 'value' (numeric) , others are 'label', 'percent' (default). Only one can be used.
      model.setDataFormat("percent");
      //format: %d for 'value', %s for 'label', %d%% for 'percent'
      model.setDataLabelFormatString("%d%%");
      //pie sector colors
   //   model.setSeriesColors("aaf,afa,faa,ffa,aff,faf,ddd");
      
   //   model.
  }

  public PieChartModel getModel() {
      return model;
  }
   public int Pontuacao(String aval) throws SQLException{
        ConnectAvaliacao con = new ConnectAvaliacao();
        JobMarketBeanAvaliacao uni = new JobMarketBeanAvaliacao();
        avaliacao = con.carregarAvaliacaoUnidade2(aval,"descricao",JobMarketBeanAvaliacaoCat.unit); 
        
        
    //    System.out.println();
        int pontuacao = 0;
        for(Avaliacao resultados:avaliacao){
     //    System.out.println(resultados.getStatus());
//           if(resultados.getStatus().equals("Ativo") && resultados.getUnidade().equals(unidade)){
//                quantidadeFuncionario++;
//                
//          //      System.out.println(quantidadeFuncionario);
//           } 
          pontuacao += resultados.getNota();
          
      }
   //    TotalGeral += quantidadeFuncionario;
       return pontuacao;
    }
   
   public void carregar(){
          try {
     
        ConnectAvaliacao con;
     
            con = new ConnectAvaliacao();
            avaliacao = con.carregarAvaliacao();
        
       
        
        for(Avaliacao resultados:avaliacao){
         
          
                ListaAvaliacao.add(resultados.getDescricao()); 
             
            //    System.out.println(resultados.getUnidade());
         
          
      }
     } catch (SQLException ex) {
            Logger.getLogger(JobMarketBeanAvaliacaoCat.class.getName()).log(Level.SEVERE, null, ex);
        }   
   }
}
