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
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.charts.scatter.ScatterChartModel;

@ManagedBean
public class ChartView implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private BarChartModel barModel;
    private ScatterChartModel scatterModel;

    public ScatterChartModel getScatterModel() {
        return scatterModel;
    }

    public void setScatterModel(ScatterChartModel scatterModel) {
        this.scatterModel = scatterModel;
    }

     private List<Avaliacao> avaliacao= new ArrayList<>();
    ArrayList<String> ListaAvaliacao = new ArrayList<>();
    ArrayList<String> ListaAvaliacao2 = new ArrayList<>();
    public static String unit;

    public static String getUnit() {
        return unit;
    }

    public static void setUnit(String unit) {
        ChartView.unit = unit;
    }

    @PostConstruct
    public void init() {
        createBarModels();
           }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Ranking de Avaliações");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Avaliações");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Pontuação");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("");
//        boys.set("2004", 120);
//        boys.set("2005", 100);
//        boys.set("2006", 44);
//        boys.set("2007", 150);
//        boys.set("2008", 25);

         carregar();
      
      
      
     for(int i=0;i < ListaAvaliacao.size();i++){
          try {
              boys.set(ListaAvaliacao.get(i), this.Pontuacao(ListaAvaliacao.get(i)));
            //  model.set(ListaAvaliacao.get(i), this.Pontuacao(ListaAvaliacao.get(i)));//jobs in thousands 
          } catch (SQLException ex) {
              Logger.getLogger(JobMarketBeanAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
        
//        ChartSeries girls = new ChartSeries();
//        girls.setLabel("rsrinivas@gmail.com");
//        girls.set("2004", 52);
//        girls.set("2005", 60);
//        girls.set("2006", 110);
//        girls.set("2007", 135);
//        girls.set("2008", 120);

        model.addSeries(boys);
//        model.addSeries(girls);

        return model;
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Item selected", "Item Index: "+  event.getSeriesIndex()
                        + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void carregar(){
          try {
     
        ConnectAvaliacao con;
     
            con = new ConnectAvaliacao();
            avaliacao = con.carregarAvaliacao();
        
       
        
        for(Avaliacao resultados:avaliacao){
         
              try{
               if(resultados.getAvaliacao().equals("null") || resultados.getAvaliacao().isEmpty()){
                   
               }else{
                    ListaAvaliacao.add(resultados.getAvaliacao()); 
               }
              }catch(NullPointerException e){
               //   ListaAvaliacao.add(resultados.getAvaliacao());
              }
             
            //    System.out.println(resultados.getUnidade());
         
          
      }
     } catch (SQLException ex) {
            Logger.getLogger(JobMarketBeanAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }   
   } 
    public int Pontuacao(String aval) throws SQLException{
        ConnectAvaliacao con = new ConnectAvaliacao();
        avaliacao = con.carregarAvaliacaoUnidade(aval); 
        
        
    //    System.out.println();
        int pontuacao = 0;
        for(Avaliacao resultados:avaliacao){

          pontuacao += resultados.getNota();

          
      }
   //    TotalGeral += quantidadeFuncionario;
       return pontuacao;
    } 
    
    
}
