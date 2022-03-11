package com.br.Dashboard;

/**
 *
 * @author v103760
 */
import Conexao.conexaoSQL;
import com.br.Funcionarios.Funcionario;
import com.br.model.database.ConnectFuncionario;
import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.JOptionPane;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

@ManagedBean(name="GraficoLinhaMB")
@ViewScoped
public class GraficoLinha implements Serializable {
    JobMarketBean job = new JobMarketBean();
    private int quantidadeFuncionario;
    private double horaTotal; 
    private double horaTotalGeral;
    private int totalFuncionarioTreinados;
    private int totalFuncionarioTreinadosGeral;
    private double totalCh;
    private long totalChGeral;
    private int totalAvaliacao;
    private int totalAvaliacaoAplicada;
    private int totalAvaliacaoGeral;
    private int totalStatusGeral;
    private int totalStatusPlan;
    private int totalStatusConc;
    private int totalStatusCanc;
    private boolean graf1;
    private boolean graf2;
    private boolean graf3;
    private boolean graf4;

    public boolean isGraf1() {
        return graf1;
    }

    public void setGraf1(boolean graf1) {
        this.graf1 = graf1;
    }

    public boolean isGraf2() {
        return graf2;
    }

    public void setGraf2(boolean graf2) {
        this.graf2 = graf2;
    }

    public boolean isGraf3() {
        return graf3;
    }

    public void setGraf3(boolean graf3) {
        this.graf3 = graf3;
    }

    public boolean isGraf4() {
        return graf4;
    }

    public void setGraf4(boolean graf4) {
        this.graf4 = graf4;
    }

    public boolean isGraf5() {
        return graf5;
    }

    public void setGraf5(boolean graf5) {
        this.graf5 = graf5;
    }

    public boolean isGraf6() {
        return graf6;
    }

    public void setGraf6(boolean graf6) {
        this.graf6 = graf6;
    }

    public boolean isGraf7() {
        return graf7;
    }

    public void setGraf7(boolean graf7) {
        this.graf7 = graf7;
    }

    public boolean isGraf8() {
        return graf8;
    }

    public void setGraf8(boolean graf8) {
        this.graf8 = graf8;
    }

    public boolean isGraf9() {
        return graf9;
    }

    public void setGraf9(boolean graf9) {
        this.graf9 = graf9;
    }

    public boolean isGraf10() {
        return graf10;
    }

    public void setGraf10(boolean graf10) {
        this.graf10 = graf10;
    }
    private boolean graf5;
    private boolean graf6;
    private boolean graf7;
    private boolean graf8;
    private boolean graf9;
    private boolean graf10;
    private int range=1;
    private String grafico1 = "height:350px;width:800px";
    private String grafico2 = "height:350px;width:800px";

    public String getGrafico2() {
        return grafico2;
    }

    public void setGrafico2(String grafico2) {
        this.grafico2 = grafico2;
    }

    public String getGrafico3() {
        return grafico3;
    }

    public void setGrafico3(String grafico3) {
        this.grafico3 = grafico3;
    }

    public String getGrafico4() {
        return grafico4;
    }

    public void setGrafico4(String grafico4) {
        this.grafico4 = grafico4;
    }

    public String getGrafico5() {
        return grafico5;
    }

    public void setGrafico5(String grafico5) {
        this.grafico5 = grafico5;
    }
    private String grafico3 = "height:350px;width:800px";
    private String grafico4 = "height:350px;width:800px";
    private String grafico5 = "height:350px;width:800px";
    private boolean value1;

    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }
    private boolean value2;
    
    public String getGrafico1() {
        return grafico1;
    }

    public void setGrafico1(String grafico1) {
        this.grafico1 = grafico1;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    
    DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
    private List<Funcionario> listFuncionario = new ArrayList<>();
    private static final long serialVersionUID = 1L;
    conexaoSQL con_sql;
    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private LineChartModel lineModel3;
    private LineChartModel lineModel4;
    private LineChartModel lineModel5;
    
    private LineChartModel lineModel6;
    private LineChartModel lineModel7;
    private LineChartModel lineModel8;
    private LineChartModel lineModel9;
    private LineChartModel lineModel10;
    private LineChartModel lineModel11;
    private LineChartModel lineModel12;
    private LineChartModel lineModel13;
    private LineChartModel lineModel14;
    private LineChartModel lineModel15;
    
    private String unidade;
    private String unidade2;
    private String unidade3;

    public String getUnidade3() {
        return unidade3;
    }

    public void setUnidade3(String unidade3) {
        this.unidade3 = unidade3;
    }

    public String getUnidade4() {
        return unidade4;
    }

    public void setUnidade4(String unidade4) {
        this.unidade4 = unidade4;
    }

    public String getUnidade5() {
        return unidade5;
    }

    public void setUnidade5(String unidade5) {
        this.unidade5 = unidade5;
    }

    public String getUnidade6() {
        return unidade6;
    }

    public void setUnidade6(String unidade6) {
        this.unidade6 = unidade6;
    }

    public String getUnidade7() {
        return unidade7;
    }

    public void setUnidade7(String unidade7) {
        this.unidade7 = unidade7;
    }

    public String getUnidade8() {
        return unidade8;
    }

    public void setUnidade8(String unidade8) {
        this.unidade8 = unidade8;
    }

    public String getUnidade9() {
        return unidade9;
    }

    public void setUnidade9(String unidade9) {
        this.unidade9 = unidade9;
    }

    public String getUnidade10() {
        return unidade10;
    }

    public void setUnidade10(String unidade10) {
        this.unidade10 = unidade10;
    }
    private String unidade4;
    private String unidade5;
    private String unidade6;
    private String unidade7;
    private String unidade8;
    private String unidade9;
    private String unidade10;
    
    public String getUnidade2() {
        return unidade2;
    }

    public void setUnidade2(String unidade2) {
        this.unidade2 = unidade2;
    }
    
    public String getUnidade() {
    
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getAno() {
        ano = ""+java.time.LocalDate.now().getYear();
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    private String ano;
    
   @PostConstruct
    public void init() {
        createLineModels();
        createLineModels2();
        try {
            createLineModels3();
        } catch (SQLException ex) {
            Logger.getLogger(GraficoLinha.class.getName()).log(Level.SEVERE, null, ex);
        }
        createLineModels4();
        createLineModels5(); 
        
        createLineModels6(); 
        
        createLineModels7(); 
        
        createLineModels8(); 
        
        createLineModels9(); 
        
        createLineModels10(); 
        
        createLineModels11(); 
        
        createLineModels12(); 
        
        createLineModels13(); 
        
        createLineModels14(); 
         
    }

    public CartesianChartModel getLineModel1() {
        return lineModel1;
    }
    public CartesianChartModel getLineModel2() {
        return lineModel2;
    }

    public CartesianChartModel getLineModel3() {
        return lineModel3;
    }
    
     public CartesianChartModel getLineModel4() {
        return lineModel4;
    }
    
     public CartesianChartModel getLineModel5() {
        return lineModel5;
    } 
    
      public CartesianChartModel getLineModel6() {
        return lineModel6;
    } 
      public CartesianChartModel getLineModel7() {
        return lineModel7;
    }  
     public CartesianChartModel getLineModel8() {
        return lineModel8;
    }

    public CartesianChartModel getLineModel9() {
        return lineModel9;
    }

    public CartesianChartModel getLineModel10() {
        return lineModel10;
    }

    public CartesianChartModel getLineModel11() {
        return lineModel11;
    }

    public CartesianChartModel getLineModel12() {
        return lineModel12;
    }

    public CartesianChartModel getLineModel13() {
        return lineModel13;
    }

    public CartesianChartModel getLineModel14() {
        return lineModel14;
    }

    public CartesianChartModel getLineModel15() {
        return lineModel15;
    }
    
    private void createLineModels() {
       lineModel1 = initLinearModel();
         lineModel1.setTitle("Total de Horas de Treinamento");
        lineModel1.setLegendPosition("e");
        lineModel1.setShowPointLabels(true);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("TotalGeral "+decimalFormat.format(horaTotalGeral/60)));
        lineModel1.setZoom(true);
        lineModel1.setAnimate(true);
       
        
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Minutos");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());
        if(this.isValue1()==true){
             grafico1 = "height:550px;width:1000px";
             grafico2 = "height:550px;width:1000px";
             grafico3 = "height:550px;width:1000px";
             grafico4 = "height:550px;width:1000px";
             grafico5 = "height:550px;width:1000px"; 
        }else{
             grafico1 = "height:350px;width:800px";
             grafico2 = "height:350px;width:800px";
             grafico3 = "height:350px;width:800px";
             grafico4 = "height:350px;width:800px";
             grafico5 = "height:350px;width:800px";
             
        }
       
        
    }

    
     private void createLineModels2() {
        lineModel2 = initLinearModel2();
        lineModel2.setTitle("Total de Funcionarios Treinados");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("TotalGeral "+totalFuncionarioTreinados));
        lineModel2.setZoom(true);
        lineModel2.setAnimate(true);
        
        Axis yAxis = lineModel2.getAxis(AxisType.Y);
//        yAxis.setLabel("% Funcionarios Treinados");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    }
    
     
      private void createLineModels3() throws SQLException {
        lineModel3 = initLinearModel3();
        lineModel3.setTitle("Homem x Horas");
        lineModel3.setLegendPosition("e");
        lineModel3.setShowPointLabels(true);
        lineModel3.getAxes().put(AxisType.X, new CategoryAxis("Total "+decimalFormat.format(totalChGeral/60)));
        lineModel3.setZoom(true);
        lineModel3.setAnimate(true);
        
        Axis yAxis = lineModel3.getAxis(AxisType.Y);
        yAxis.setLabel("Minutos");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    }
      
     private void createLineModels4() {
        lineModel4 = initLinearModel4();
        lineModel4.setTitle("Total de Avaliações aplicadas ");
        lineModel4.setLegendPosition("e");
        lineModel4.setShowPointLabels(true);
        lineModel4.getAxes().put(AxisType.X, new CategoryAxis("Total "+totalAvaliacaoAplicada));
        lineModel4.setZoom(true);
        lineModel4.setAnimate(true);

        Axis yAxis = lineModel4.getAxis(AxisType.Y);
//        yAxis.setLabel("Total de Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    }  
     
    //------------------------------------------------------------------------------------------ 
     
     private void createLineModels5() {
        lineModel5 = initLinearModel5();
        lineModel5.setTitle("Total de Avaliações Concluidas X Planejadas de: "+unidade);
        lineModel5.setLegendPosition("e");
        lineModel5.setShowPointLabels(true);
        lineModel5.getAxes().put(AxisType.X, new CategoryAxis("Total "+totalStatusGeral));
        lineModel5.setZoom(true);
        lineModel5.setAnimate(true); 

        Axis yAxis = lineModel5.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
   
     private void createLineModels6() {
        lineModel6 = initLinearModel6();
        lineModel6.setTitle("Total de Avaliações Concluidas X Planejadas de: "+unidade2);
        lineModel6.setLegendPosition("e");
        lineModel6.setShowPointLabels(true);
        lineModel6.getAxes().put(AxisType.X, new CategoryAxis("Total "+totalStatusGeral));
        lineModel6.setZoom(true);
        lineModel6.setAnimate(true); 

        Axis yAxis = lineModel6.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax((yAxis.getMax()));
   
         
    } 
     
    private void createLineModels7() {
        lineModel7 = initLinearModel7();
        lineModel7.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade3);
        lineModel7.setLegendPosition("e");
        lineModel7.setShowPointLabels(true);
        lineModel7.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel7.setZoom(true);
        lineModel7.setAnimate(true); 

        Axis yAxis = lineModel7.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
    
    private void createLineModels8() {
        lineModel8 = initLinearModel8();
        lineModel8.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade4);
        lineModel8.setLegendPosition("e");
        lineModel8.setShowPointLabels(true);
        lineModel8.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel8.setZoom(true);
        lineModel8.setAnimate(true); 

        Axis yAxis = lineModel8.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
    
    private void createLineModels9() {
        lineModel9 = initLinearModel9();
        lineModel9.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade5);
        lineModel9.setLegendPosition("e");
        lineModel9.setShowPointLabels(true);
        lineModel9.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel9.setZoom(true);
        lineModel9.setAnimate(true); 

        Axis yAxis = lineModel9.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
    
    private void createLineModels10() {
        lineModel10 = initLinearModel10();
        lineModel10.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade6);
        lineModel10.setLegendPosition("e");
        lineModel10.setShowPointLabels(true);
        lineModel10.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel10.setZoom(true);
        lineModel10.setAnimate(true); 

        Axis yAxis = lineModel10.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
    
    private void createLineModels11() {
        lineModel11 = initLinearModel11();
        lineModel11.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade7);
        lineModel11.setLegendPosition("e");
        lineModel11.setShowPointLabels(true);
        lineModel11.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel11.setZoom(true);
        lineModel11.setAnimate(true); 

        Axis yAxis = lineModel11.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
    
    private void createLineModels12() {
        lineModel12 = initLinearModel12();
        lineModel12.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade8);
        lineModel12.setLegendPosition("e");
        lineModel12.setShowPointLabels(true);
        lineModel12.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel12.setZoom(true);
        lineModel12.setAnimate(true); 

        Axis yAxis = lineModel12.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
    
    private void createLineModels13() {
        lineModel13 = initLinearModel13();
        lineModel13.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade9);
        lineModel13.setLegendPosition("e");
        lineModel13.setShowPointLabels(true);
        lineModel13.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel13.setZoom(true);
        lineModel13.setAnimate(true); 

        Axis yAxis = lineModel13.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
    
    private void createLineModels14() {
        lineModel14 = initLinearModel14();
        lineModel14.setTitle("Total de Avaliações Concluidas X Planejadas : "+unidade10);
        lineModel14.setLegendPosition("e");
        lineModel14.setShowPointLabels(true);
        lineModel14.getAxes().put(AxisType.X, new CategoryAxis("Pesquisas"));
        lineModel14.setZoom(true);
        lineModel14.setAnimate(true); 

        Axis yAxis = lineModel14.getAxis(AxisType.Y);
//        yAxis.setLabel("% Avaliações");
        yAxis.setMin(0);
        yAxis.setMax(yAxis.getMax());

    } 
     
   //-------------------------------------------------------------------------------------------------------  
     
    private LineChartModel initLinearModel() {
      horaTotal=0; 
        LineChartModel model = new LineChartModel();

     ChartSeries series1 = new ChartSeries();
  
       

        
        series1.set("Jan", this.countHour(1,ano, unidade));
        series1.set("Fev", this.countHour(2,ano, unidade));
        series1.set("Mar", this.countHour(3,ano, unidade));
        series1.set("Abril", this.countHour(4,ano, unidade));
        series1.set("Maio", this.countHour(5,ano, unidade));
        series1.set("Jun", this.countHour(6,ano, unidade));
        series1.set("Jul", this.countHour(7,ano, unidade));
        series1.set("Ago", this.countHour(8,ano, unidade));
        series1.set("Set", this.countHour(9,ano, unidade));
        series1.set("Out", this.countHour(10,ano, unidade));
        series1.set("Nov", this.countHour(11,ano, unidade));
        series1.set("Dez", this.countHour(12,ano, unidade)); 
     
        series1.setLabel(unidade+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series1);
     try{
    
       if(unidade2.length()>0){
           graf2=true;
           horaTotal=0; 
           ChartSeries series2 = new ChartSeries();  
    

        series2.set("Jan", this.countHour(1,ano, unidade2));
        series2.set("Fev", this.countHour(2,ano, unidade2));
        series2.set("Mar", this.countHour(3,ano, unidade2));
        series2.set("Abril", this.countHour(4,ano, unidade2));
        series2.set("Maio", this.countHour(5,ano, unidade2));
        series2.set("Jun", this.countHour(6,ano, unidade2));
        series2.set("Jul", this.countHour(7,ano, unidade2));
        series2.set("Ago", this.countHour(8,ano, unidade2));
        series2.set("Set", this.countHour(9,ano, unidade2));
        series2.set("Out", this.countHour(10,ano, unidade2));
        series2.set("Nov", this.countHour(11,ano, unidade2));
        series2.set("Dez", this.countHour(12,ano, unidade2)); 
        series2.setLabel(unidade2+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series2);
     }
     
     if(unidade3.length()>0){
          horaTotal=0; 
         ChartSeries series3 = new ChartSeries();  
//       series3.setLabel(unidade3+" - Total de Horas");

        series3.set("Jan", this.countHour(1,ano, unidade3));
        series3.set("Fev", this.countHour(2,ano, unidade3));
        series3.set("Mar", this.countHour(3,ano, unidade3));
        series3.set("Abril", this.countHour(4,ano, unidade3));
        series3.set("Maio", this.countHour(5,ano, unidade3));
        series3.set("Jun", this.countHour(6,ano, unidade3));
        series3.set("Jul", this.countHour(7,ano, unidade3));
        series3.set("Ago", this.countHour(8,ano, unidade3));
        series3.set("Set", this.countHour(9,ano, unidade3));
        series3.set("Out", this.countHour(10,ano, unidade3));
        series3.set("Nov", this.countHour(11,ano, unidade3));
        series3.set("Dez", this.countHour(12,ano, unidade3)); 
        series3.setLabel(unidade3+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series3);
     }  
    
     if(unidade4.length()>0){
          horaTotal=0; 
         ChartSeries series4 = new ChartSeries();  
//       series4.setLabel(unidade4+" - Total de Horas");

        series4.set("Jan", this.countHour(1,ano, unidade4));
        series4.set("Fev", this.countHour(2,ano, unidade4));
        series4.set("Mar", this.countHour(3,ano, unidade4));
        series4.set("Abril", this.countHour(4,ano, unidade4));
        series4.set("Maio", this.countHour(5,ano, unidade4));
        series4.set("Jun", this.countHour(6,ano, unidade4));
        series4.set("Jul", this.countHour(7,ano, unidade4));
        series4.set("Ago", this.countHour(8,ano, unidade4));
        series4.set("Set", this.countHour(9,ano, unidade4));
        series4.set("Out", this.countHour(10,ano, unidade4));
        series4.set("Nov", this.countHour(11,ano, unidade4));
        series4.set("Dez", this.countHour(12,ano, unidade4)); 
        series4.setLabel(unidade4+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series4);
     }
     
     if(unidade5.length()>0){
          horaTotal=0; 
         ChartSeries series5 = new ChartSeries();  
//       series5.setLabel(unidade5+" - Total de Horas");

        series5.set("Jan", this.countHour(1,ano, unidade5));
        series5.set("Fev", this.countHour(2,ano, unidade5));
        series5.set("Mar", this.countHour(3,ano, unidade5));
        series5.set("Abril", this.countHour(4,ano, unidade5));
        series5.set("Maio", this.countHour(5,ano, unidade5));
        series5.set("Jun", this.countHour(6,ano, unidade5));
        series5.set("Jul", this.countHour(7,ano, unidade5));
        series5.set("Ago", this.countHour(8,ano, unidade5));
        series5.set("Set", this.countHour(9,ano, unidade5));
        series5.set("Out", this.countHour(10,ano, unidade5));
        series5.set("Nov", this.countHour(11,ano, unidade5));
        series5.set("Dez", this.countHour(12,ano, unidade5)); 
        series5.setLabel(unidade5+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series5);
     }
     
     
     if(unidade6.length()>0){
          horaTotal=0; 
         ChartSeries series6 = new ChartSeries();  
//       series6.setLabel(unidade6+" - Total de Horas");

        series6.set("Jan", this.countHour(1,ano, unidade6));
        series6.set("Fev", this.countHour(2,ano, unidade6));
        series6.set("Mar", this.countHour(3,ano, unidade6));
        series6.set("Abril", this.countHour(4,ano, unidade6));
        series6.set("Maio", this.countHour(5,ano, unidade6));
        series6.set("Jun", this.countHour(6,ano, unidade6));
        series6.set("Jul", this.countHour(7,ano, unidade6));
        series6.set("Ago", this.countHour(8,ano, unidade6));
        series6.set("Set", this.countHour(9,ano, unidade6));
        series6.set("Out", this.countHour(10,ano, unidade6));
        series6.set("Nov", this.countHour(11,ano, unidade6));
        series6.set("Dez", this.countHour(12,ano, unidade6)); 
        series6.setLabel(unidade6+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series6);
     }
     
     if(unidade7.length()>0){
          horaTotal=0; 
         ChartSeries series7 = new ChartSeries();  
//       series7.setLabel(unidade7+" - Total de Horas");

        series7.set("Jan", this.countHour(1,ano, unidade7));
        series7.set("Fev", this.countHour(2,ano, unidade7));
        series7.set("Mar", this.countHour(3,ano, unidade7));
        series7.set("Abril", this.countHour(4,ano, unidade7));
        series7.set("Maio", this.countHour(5,ano, unidade7));
        series7.set("Jun", this.countHour(6,ano, unidade7));
        series7.set("Jul", this.countHour(7,ano, unidade7));
        series7.set("Ago", this.countHour(8,ano, unidade7));
        series7.set("Set", this.countHour(9,ano, unidade7));
        series7.set("Out", this.countHour(10,ano, unidade7));
        series7.set("Nov", this.countHour(11,ano, unidade7));
        series7.set("Dez", this.countHour(12,ano, unidade7)); 
        series7.setLabel(unidade7+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series7);
     }
     
     if(unidade8.length()>0){
          horaTotal=0; 
         ChartSeries series8 = new ChartSeries();  
       series8.setLabel(unidade8+" - Total de Horas");

        series8.set("Jan", this.countHour(1,ano, unidade8));
        series8.set("Fev", this.countHour(2,ano, unidade8));
        series8.set("Mar", this.countHour(3,ano, unidade8));
        series8.set("Abril", this.countHour(4,ano, unidade8));
        series8.set("Maio", this.countHour(5,ano, unidade8));
        series8.set("Jun", this.countHour(6,ano, unidade8));
        series8.set("Jul", this.countHour(7,ano, unidade8));
        series8.set("Ago", this.countHour(8,ano, unidade8));
        series8.set("Set", this.countHour(9,ano, unidade8));
        series8.set("Out", this.countHour(10,ano, unidade8));
        series8.set("Nov", this.countHour(11,ano, unidade8));
        series8.set("Dez", this.countHour(12,ano, unidade8)); 
        series8.setLabel(unidade8+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series8);
     }
     
     
     if(unidade9.length()>0){
          horaTotal=0; 
         ChartSeries series9 = new ChartSeries();  
//       series9.setLabel(unidade9+" - Total de Horas");

        series9.set("Jan", this.countHour(1,ano, unidade9));
        series9.set("Fev", this.countHour(2,ano, unidade9));
        series9.set("Mar", this.countHour(3,ano, unidade9));
        series9.set("Abril", this.countHour(4,ano, unidade9));
        series9.set("Maio", this.countHour(5,ano, unidade9));
        series9.set("Jun", this.countHour(6,ano, unidade9));
        series9.set("Jul", this.countHour(7,ano, unidade9));
        series9.set("Ago", this.countHour(8,ano, unidade9));
        series9.set("Set", this.countHour(9,ano, unidade9));
        series9.set("Out", this.countHour(10,ano, unidade9));
        series9.set("Nov", this.countHour(11,ano, unidade9));
        series9.set("Dez", this.countHour(12,ano, unidade9)); 
        series9.setLabel(unidade9+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series9);
     }
     
     
     if(unidade10.length()>0){
         horaTotal=0; 
         ChartSeries series10 = new ChartSeries();  
//       series10.setLabel(unidade10+" - Total de Horas");

        series10.set("Jan", this.countHour(1,ano, unidade10));
        series10.set("Fev", this.countHour(2,ano, unidade10));
        series10.set("Mar", this.countHour(3,ano, unidade10));
        series10.set("Abril", this.countHour(4,ano, unidade10));
        series10.set("Maio", this.countHour(5,ano, unidade10));
        series10.set("Jun", this.countHour(6,ano, unidade10));
        series10.set("Jul", this.countHour(7,ano, unidade10));
        series10.set("Ago", this.countHour(8,ano, unidade10));
        series10.set("Set", this.countHour(9,ano, unidade10));
        series10.set("Out", this.countHour(10,ano, unidade10));
        series10.set("Nov", this.countHour(11,ano, unidade10));
        series10.set("Dez", this.countHour(12,ano, unidade10)); 
        series10.setLabel(unidade10+" - Total de Horas "+decimalFormat.format(horaTotal/60));
        model.addSeries(series10);
     }
     
     
     }catch(NullPointerException e){
         
     }
   
        
        
       
        
        
        
       

        return model;
    }

 
    private LineChartModel initLinearModel2() {
     LineChartModel model = new LineChartModel();
        totalFuncionarioTreinados =0;
            
        ChartSeries series1 = new ChartSeries();
       

        series1.set("Jan", this.countAvaliacaoFunc(1,ano, unidade));
        series1.set("Fev", this.countAvaliacaoFunc(2,ano, unidade));
        series1.set("Mar", this.countAvaliacaoFunc(3,ano, unidade));
        series1.set("Abril", this.countAvaliacaoFunc(4,ano, unidade));
        series1.set("Maio", this.countAvaliacaoFunc(5,ano, unidade));
        series1.set("Jun", this.countAvaliacaoFunc(6,ano, unidade));
        series1.set("Jul", this.countAvaliacaoFunc(7,ano, unidade));
        series1.set("Ago", this.countAvaliacaoFunc(8,ano, unidade));
        series1.set("Set", this.countAvaliacaoFunc(9,ano, unidade));
        series1.set("Out", this.countAvaliacaoFunc(10,ano, unidade));
        series1.set("Nov", this.countAvaliacaoFunc(11,ano, unidade));
        series1.set("Dez", this.countAvaliacaoFunc(12,ano, unidade)); 
        series1.setLabel(unidade+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series1);
        
        try{
                  
          if(unidade2.length()>0){
            
           totalFuncionarioTreinados =0;
           ChartSeries series2 = new ChartSeries();  
    

        series2.set("Jan", this.countAvaliacaoFunc(1,ano, unidade2));
        series2.set("Fev", this.countAvaliacaoFunc(2,ano, unidade2));
        series2.set("Mar", this.countAvaliacaoFunc(3,ano, unidade2));
        series2.set("Abril", this.countAvaliacaoFunc(4,ano, unidade2));
        series2.set("Maio", this.countAvaliacaoFunc(5,ano, unidade2));
        series2.set("Jun", this.countAvaliacaoFunc(6,ano, unidade2));
        series2.set("Jul", this.countAvaliacaoFunc(7,ano, unidade2));
        series2.set("Ago", this.countAvaliacaoFunc(8,ano, unidade2));
        series2.set("Set", this.countAvaliacaoFunc(9,ano, unidade2));
        series2.set("Out", this.countAvaliacaoFunc(10,ano, unidade2));
        series2.set("Nov", this.countAvaliacaoFunc(11,ano, unidade2));
        series2.set("Dez", this.countAvaliacaoFunc(12,ano, unidade2)); 
        series2.setLabel(unidade2+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series2);
     }   
            
          if(unidade3.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series3 = new ChartSeries();  
    

        series3.set("Jan", this.countAvaliacaoFunc(1,ano, unidade3));
        series3.set("Fev", this.countAvaliacaoFunc(2,ano, unidade3));
        series3.set("Mar", this.countAvaliacaoFunc(3,ano, unidade3));
        series3.set("Abril", this.countAvaliacaoFunc(4,ano, unidade3));
        series3.set("Maio", this.countAvaliacaoFunc(5,ano, unidade3));
        series3.set("Jun", this.countAvaliacaoFunc(6,ano, unidade3));
        series3.set("Jul", this.countAvaliacaoFunc(7,ano, unidade3));
        series3.set("Ago", this.countAvaliacaoFunc(8,ano, unidade3));
        series3.set("Set", this.countAvaliacaoFunc(9,ano, unidade3));
        series3.set("Out", this.countAvaliacaoFunc(10,ano, unidade3));
        series3.set("Nov", this.countAvaliacaoFunc(11,ano, unidade3));
        series3.set("Dez", this.countAvaliacaoFunc(12,ano, unidade3)); 
        series3.setLabel(unidade3+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series3);
     }   
            
          if(unidade4.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series4 = new ChartSeries();  
    

        series4.set("Jan", this.countAvaliacaoFunc(1,ano, unidade4));
        series4.set("Fev", this.countAvaliacaoFunc(2,ano, unidade4));
        series4.set("Mar", this.countAvaliacaoFunc(3,ano, unidade4));
        series4.set("Abril", this.countAvaliacaoFunc(4,ano, unidade4));
        series4.set("Maio", this.countAvaliacaoFunc(5,ano, unidade4));
        series4.set("Jun", this.countAvaliacaoFunc(6,ano, unidade4));
        series4.set("Jul", this.countAvaliacaoFunc(7,ano, unidade4));
        series4.set("Ago", this.countAvaliacaoFunc(8,ano, unidade4));
        series4.set("Set", this.countAvaliacaoFunc(9,ano, unidade4));
        series4.set("Out", this.countAvaliacaoFunc(10,ano, unidade4));
        series4.set("Nov", this.countAvaliacaoFunc(11,ano, unidade4));
        series4.set("Dez", this.countAvaliacaoFunc(12,ano, unidade4)); 
        series4.setLabel(unidade4+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series4);
     }   
            
          if(unidade5.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series5 = new ChartSeries();  
    

        series5.set("Jan", this.countAvaliacaoFunc(1,ano, unidade5));
        series5.set("Fev", this.countAvaliacaoFunc(2,ano, unidade5));
        series5.set("Mar", this.countAvaliacaoFunc(3,ano, unidade5));
        series5.set("Abril", this.countAvaliacaoFunc(4,ano, unidade5));
        series5.set("Maio", this.countAvaliacaoFunc(5,ano, unidade5));
        series5.set("Jun", this.countAvaliacaoFunc(6,ano, unidade5));
        series5.set("Jul", this.countAvaliacaoFunc(7,ano, unidade5));
        series5.set("Ago", this.countAvaliacaoFunc(8,ano, unidade5));
        series5.set("Set", this.countAvaliacaoFunc(9,ano, unidade5));
        series5.set("Out", this.countAvaliacaoFunc(10,ano, unidade5));
        series5.set("Nov", this.countAvaliacaoFunc(11,ano, unidade5));
        series5.set("Dez", this.countAvaliacaoFunc(12,ano, unidade5)); 
        series5.setLabel(unidade5+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series5);
     }   
            
          if(unidade6.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series6 = new ChartSeries();  
    

        series6.set("Jan", this.countAvaliacaoFunc(1,ano, unidade6));
        series6.set("Fev", this.countAvaliacaoFunc(2,ano, unidade6));
        series6.set("Mar", this.countAvaliacaoFunc(3,ano, unidade6));
        series6.set("Abril", this.countAvaliacaoFunc(4,ano, unidade6));
        series6.set("Maio", this.countAvaliacaoFunc(5,ano, unidade6));
        series6.set("Jun", this.countAvaliacaoFunc(6,ano, unidade6));
        series6.set("Jul", this.countAvaliacaoFunc(7,ano, unidade6));
        series6.set("Ago", this.countAvaliacaoFunc(8,ano, unidade6));
        series6.set("Set", this.countAvaliacaoFunc(9,ano, unidade6));
        series6.set("Out", this.countAvaliacaoFunc(10,ano, unidade6));
        series6.set("Nov", this.countAvaliacaoFunc(11,ano, unidade6));
        series6.set("Dez", this.countAvaliacaoFunc(12,ano, unidade6)); 
        series6.setLabel(unidade6+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series6);
     }   
            
          if(unidade7.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series7 = new ChartSeries();  
    

        series7.set("Jan", this.countAvaliacaoFunc(1,ano, unidade7));
        series7.set("Fev", this.countAvaliacaoFunc(2,ano, unidade7));
        series7.set("Mar", this.countAvaliacaoFunc(3,ano, unidade7));
        series7.set("Abril", this.countAvaliacaoFunc(4,ano, unidade7));
        series7.set("Maio", this.countAvaliacaoFunc(5,ano, unidade7));
        series7.set("Jun", this.countAvaliacaoFunc(6,ano, unidade7));
        series7.set("Jul", this.countAvaliacaoFunc(7,ano, unidade7));
        series7.set("Ago", this.countAvaliacaoFunc(8,ano, unidade7));
        series7.set("Set", this.countAvaliacaoFunc(9,ano, unidade7));
        series7.set("Out", this.countAvaliacaoFunc(10,ano, unidade7));
        series7.set("Nov", this.countAvaliacaoFunc(11,ano, unidade7));
        series7.set("Dez", this.countAvaliacaoFunc(12,ano, unidade7)); 
        series7.setLabel(unidade7+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series7);
     }   
            
          if(unidade8.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series8 = new ChartSeries();  
    

        series8.set("Jan", this.countAvaliacaoFunc(1,ano, unidade8));
        series8.set("Fev", this.countAvaliacaoFunc(2,ano, unidade8));
        series8.set("Mar", this.countAvaliacaoFunc(3,ano, unidade8));
        series8.set("Abril", this.countAvaliacaoFunc(4,ano, unidade8));
        series8.set("Maio", this.countAvaliacaoFunc(5,ano, unidade8));
        series8.set("Jun", this.countAvaliacaoFunc(6,ano, unidade8));
        series8.set("Jul", this.countAvaliacaoFunc(7,ano, unidade8));
        series8.set("Ago", this.countAvaliacaoFunc(8,ano, unidade8));
        series8.set("Set", this.countAvaliacaoFunc(9,ano, unidade8));
        series8.set("Out", this.countAvaliacaoFunc(10,ano, unidade8));
        series8.set("Nov", this.countAvaliacaoFunc(11,ano, unidade8));
        series8.set("Dez", this.countAvaliacaoFunc(12,ano, unidade8)); 
        series8.setLabel(unidade8+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series8);
     }   
            
          if(unidade9.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series9 = new ChartSeries();  
    

        series9.set("Jan", this.countAvaliacaoFunc(1,ano, unidade9));
        series9.set("Fev", this.countAvaliacaoFunc(2,ano, unidade9));
        series9.set("Mar", this.countAvaliacaoFunc(3,ano, unidade9));
        series9.set("Abril", this.countAvaliacaoFunc(4,ano, unidade9));
        series9.set("Maio", this.countAvaliacaoFunc(5,ano, unidade9));
        series9.set("Jun", this.countAvaliacaoFunc(6,ano, unidade9));
        series9.set("Jul", this.countAvaliacaoFunc(7,ano, unidade9));
        series9.set("Ago", this.countAvaliacaoFunc(8,ano, unidade9));
        series9.set("Set", this.countAvaliacaoFunc(9,ano, unidade9));
        series9.set("Out", this.countAvaliacaoFunc(10,ano, unidade9));
        series9.set("Nov", this.countAvaliacaoFunc(11,ano, unidade9));
        series9.set("Dez", this.countAvaliacaoFunc(12,ano, unidade9)); 
        series9.setLabel(unidade9+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series9);
     }   
            
          if(unidade10.length()>0){
         
           totalFuncionarioTreinados =0;
           ChartSeries series10 = new ChartSeries();  
    

        series10.set("Jan", this.countAvaliacaoFunc(1,ano, unidade10));
        series10.set("Fev", this.countAvaliacaoFunc(2,ano, unidade10));
        series10.set("Mar", this.countAvaliacaoFunc(3,ano, unidade10));
        series10.set("Abril", this.countAvaliacaoFunc(4,ano, unidade10));
        series10.set("Maio", this.countAvaliacaoFunc(5,ano, unidade10));
        series10.set("Jun", this.countAvaliacaoFunc(6,ano, unidade10));
        series10.set("Jul", this.countAvaliacaoFunc(7,ano, unidade10));
        series10.set("Ago", this.countAvaliacaoFunc(8,ano, unidade10));
        series10.set("Set", this.countAvaliacaoFunc(9,ano, unidade10));
        series10.set("Out", this.countAvaliacaoFunc(10,ano, unidade10));
        series10.set("Nov", this.countAvaliacaoFunc(11,ano, unidade10));
        series10.set("Dez", this.countAvaliacaoFunc(12,ano, unidade10)); 
        series10.setLabel(unidade10+" - Total de FuncionariosTreinados "+totalFuncionarioTreinados);
        model.addSeries(series10);
     }   
            
         
         }catch(NullPointerException e){
         
         }
        return model;
    }
    
    
     private LineChartModel initLinearModel3() throws SQLException {
     LineChartModel model = new LineChartModel();
       totalCh = 0;
       totalChGeral=0;
        ChartSeries series1 = new ChartSeries();
        

        series1.set("Jan", this.countManHour(1,ano, unidade));
        series1.set("Fev", this.countManHour(2,ano, unidade));
        series1.set("Mar", this.countManHour(3,ano, unidade));
        series1.set("Abril", this.countManHour(4,ano, unidade));
        series1.set("Maio", this.countManHour(5,ano, unidade));
        series1.set("Jun", this.countManHour(6,ano, unidade));
        series1.set("Jul", this.countManHour(7,ano, unidade));
        series1.set("Ago", this.countManHour(8,ano, unidade));
        series1.set("Set", this.countManHour(9,ano, unidade));
        series1.set("Out", this.countManHour(10,ano, unidade));
        series1.set("Nov", this.countManHour(11,ano, unidade));
        series1.set("Dez", this.countManHour(12,ano, unidade)); 
        series1.setLabel(unidade +" Ch "+decimalFormat.format(totalCh/60));
       
        model.addSeries(series1);
       
        try{
      
            if(unidade2.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series2 = new ChartSeries();  
    

        series2.set("Jan", this.countManHour(1,ano, unidade2));
        series2.set("Fev", this.countManHour(2,ano, unidade2));
        series2.set("Mar", this.countManHour(3,ano, unidade2));
        series2.set("Abril", this.countManHour(4,ano, unidade2));
        series2.set("Maio", this.countManHour(5,ano, unidade2));
        series2.set("Jun", this.countManHour(6,ano, unidade2));
        series2.set("Jul", this.countManHour(7,ano, unidade2));
        series2.set("Ago", this.countManHour(8,ano, unidade2));
        series2.set("Set", this.countManHour(9,ano, unidade2));
        series2.set("Out", this.countManHour(10,ano, unidade2));
        series2.set("Nov", this.countManHour(11,ano, unidade2));
        series2.set("Dez", this.countManHour(12,ano, unidade2)); 
        series2.setLabel(unidade2 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series2);
     }    
          
        if(unidade3.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series3 = new ChartSeries();  
    

        series3.set("Jan", this.countManHour(1,ano, unidade3));
        series3.set("Fev", this.countManHour(2,ano, unidade3));
        series3.set("Mar", this.countManHour(3,ano, unidade3));
        series3.set("Abril", this.countManHour(4,ano, unidade3));
        series3.set("Maio", this.countManHour(5,ano, unidade3));
        series3.set("Jun", this.countManHour(6,ano, unidade3));
        series3.set("Jul", this.countManHour(7,ano, unidade3));
        series3.set("Ago", this.countManHour(8,ano, unidade3));
        series3.set("Set", this.countManHour(9,ano, unidade3));
        series3.set("Out", this.countManHour(10,ano, unidade3));
        series3.set("Nov", this.countManHour(11,ano, unidade3));
        series3.set("Dez", this.countManHour(12,ano, unidade3)); 
        series3.setLabel(unidade3 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series3);
     }    
        
         if(unidade4.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series4 = new ChartSeries();  
    

        series4.set("Jan", this.countManHour(1,ano, unidade4));
        series4.set("Fev", this.countManHour(2,ano, unidade4));
        series4.set("Mar", this.countManHour(3,ano, unidade4));
        series4.set("Abril", this.countManHour(4,ano, unidade4));
        series4.set("Maio", this.countManHour(5,ano, unidade4));
        series4.set("Jun", this.countManHour(6,ano, unidade4));
        series4.set("Jul", this.countManHour(7,ano, unidade4));
        series4.set("Ago", this.countManHour(8,ano, unidade4));
        series4.set("Set", this.countManHour(9,ano, unidade4));
        series4.set("Out", this.countManHour(10,ano, unidade4));
        series4.set("Nov", this.countManHour(11,ano, unidade4));
        series4.set("Dez", this.countManHour(12,ano, unidade4)); 
        series4.setLabel(unidade4 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series4);
     }    
         
          if(unidade5.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series5 = new ChartSeries();  
    

        series5.set("Jan", this.countManHour(1,ano, unidade5));
        series5.set("Fev", this.countManHour(2,ano, unidade5));
        series5.set("Mar", this.countManHour(3,ano, unidade5));
        series5.set("Abril", this.countManHour(4,ano, unidade5));
        series5.set("Maio", this.countManHour(5,ano, unidade5));
        series5.set("Jun", this.countManHour(6,ano, unidade5));
        series5.set("Jul", this.countManHour(7,ano, unidade5));
        series5.set("Ago", this.countManHour(8,ano, unidade5));
        series5.set("Set", this.countManHour(9,ano, unidade5));
        series5.set("Out", this.countManHour(10,ano, unidade5));
        series5.set("Nov", this.countManHour(11,ano, unidade5));
        series5.set("Dez", this.countManHour(12,ano, unidade5)); 
        series5.setLabel(unidade5 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series5);
     }    
          
           if(unidade6.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series6 = new ChartSeries();  
    

        series6.set("Jan", this.countManHour(1,ano, unidade6));
        series6.set("Fev", this.countManHour(2,ano, unidade6));
        series6.set("Mar", this.countManHour(3,ano, unidade6));
        series6.set("Abril", this.countManHour(4,ano, unidade6));
        series6.set("Maio", this.countManHour(5,ano, unidade6));
        series6.set("Jun", this.countManHour(6,ano, unidade6));
        series6.set("Jul", this.countManHour(7,ano, unidade6));
        series6.set("Ago", this.countManHour(8,ano, unidade6));
        series6.set("Set", this.countManHour(9,ano, unidade6));
        series6.set("Out", this.countManHour(10,ano, unidade6));
        series6.set("Nov", this.countManHour(11,ano, unidade6));
        series6.set("Dez", this.countManHour(12,ano, unidade6)); 
        series6.setLabel(unidade6 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series6);
     }    
           
            if(unidade7.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series7 = new ChartSeries();  
    

        series7.set("Jan", this.countManHour(1,ano, unidade7));
        series7.set("Fev", this.countManHour(2,ano, unidade7));
        series7.set("Mar", this.countManHour(3,ano, unidade7));
        series7.set("Abril", this.countManHour(4,ano, unidade7));
        series7.set("Maio", this.countManHour(5,ano, unidade7));
        series7.set("Jun", this.countManHour(6,ano, unidade7));
        series7.set("Jul", this.countManHour(7,ano, unidade7));
        series7.set("Ago", this.countManHour(8,ano, unidade7));
        series7.set("Set", this.countManHour(9,ano, unidade7));
        series7.set("Out", this.countManHour(10,ano, unidade7));
        series7.set("Nov", this.countManHour(11,ano, unidade7));
        series7.set("Dez", this.countManHour(12,ano, unidade7)); 
        series7.setLabel(unidade7 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series7);
     }    
            
             if(unidade8.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series8 = new ChartSeries();  
    

        series8.set("Jan", this.countManHour(1,ano, unidade8));
        series8.set("Fev", this.countManHour(2,ano, unidade8));
        series8.set("Mar", this.countManHour(3,ano, unidade8));
        series8.set("Abril", this.countManHour(4,ano, unidade8));
        series8.set("Maio", this.countManHour(5,ano, unidade8));
        series8.set("Jun", this.countManHour(6,ano, unidade8));
        series8.set("Jul", this.countManHour(7,ano, unidade8));
        series8.set("Ago", this.countManHour(8,ano, unidade8));
        series8.set("Set", this.countManHour(9,ano, unidade8));
        series8.set("Out", this.countManHour(10,ano, unidade8));
        series8.set("Nov", this.countManHour(11,ano, unidade8));
        series8.set("Dez", this.countManHour(12,ano, unidade8)); 
        series8.setLabel(unidade8 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series8);
     }    
             
              if(unidade9.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series9 = new ChartSeries();  
    

        series9.set("Jan", this.countManHour(1,ano, unidade9));
        series9.set("Fev", this.countManHour(2,ano, unidade9));
        series9.set("Mar", this.countManHour(3,ano, unidade9));
        series9.set("Abril", this.countManHour(4,ano, unidade9));
        series9.set("Maio", this.countManHour(5,ano, unidade9));
        series9.set("Jun", this.countManHour(6,ano, unidade9));
        series9.set("Jul", this.countManHour(7,ano, unidade9));
        series9.set("Ago", this.countManHour(8,ano, unidade9));
        series9.set("Set", this.countManHour(9,ano, unidade9));
        series9.set("Out", this.countManHour(10,ano, unidade9));
        series9.set("Nov", this.countManHour(11,ano, unidade9));
        series9.set("Dez", this.countManHour(12,ano, unidade9)); 
        series9.setLabel(unidade9 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series9);
     }    
              
               if(unidade10.length()>0){
           totalChGeral=0;
           totalCh =0;
           ChartSeries series10 = new ChartSeries();  
    

        series10.set("Jan", this.countManHour(1,ano, unidade10));
        series10.set("Fev", this.countManHour(2,ano, unidade10));
        series10.set("Mar", this.countManHour(3,ano, unidade10));
        series10.set("Abril", this.countManHour(4,ano, unidade10));
        series10.set("Maio", this.countManHour(5,ano, unidade10));
        series10.set("Jun", this.countManHour(6,ano, unidade10));
        series10.set("Jul", this.countManHour(7,ano, unidade10));
        series10.set("Ago", this.countManHour(8,ano, unidade10));
        series10.set("Set", this.countManHour(9,ano, unidade10));
        series10.set("Out", this.countManHour(10,ano, unidade10));
        series10.set("Nov", this.countManHour(11,ano, unidade10));
        series10.set("Dez", this.countManHour(12,ano, unidade10)); 
        series10.setLabel(unidade10 +" Ch "+decimalFormat.format(totalCh/60));
        model.addSeries(series10);
     }    
            
            
         }catch(NullPointerException e){
         
         }

        return model;
    }
    
    
     private LineChartModel initLinearModel4() {
     LineChartModel model = new LineChartModel();

  
         totalAvaliacaoAplicada = 0;

        ChartSeries series1 = new ChartSeries();
        series1.setLabel("Total avaliações aplicadas");

        series1.set("Jan", this.countAvaliacao(1,ano, unidade));
        series1.set("Fev", this.countAvaliacao(2,ano, unidade));
        series1.set("Mar", this.countAvaliacao(3,ano, unidade));
        series1.set("Abril", this.countAvaliacao(4,ano, unidade));
        series1.set("Maio", this.countAvaliacao(5,ano, unidade));
        series1.set("Jun", this.countAvaliacao(6,ano, unidade));
        series1.set("Jul", this.countAvaliacao(7,ano, unidade));
        series1.set("Ago", this.countAvaliacao(8,ano, unidade));
        series1.set("Set", this.countAvaliacao(9,ano, unidade));
        series1.set("Out", this.countAvaliacao(10,ano, unidade));
        series1.set("Nov", this.countAvaliacao(11,ano, unidade));
        series1.set("Dez", this.countAvaliacao(12,ano, unidade)); 
        series1.setLabel(unidade+" Total avaliações "+totalAvaliacao);
        model.addSeries(series1);
       
        try{
      
              if(unidade2.length()>0){
         
         totalAvaliacaoAplicada = 0;

        ChartSeries series2 = new ChartSeries();
       

        series2.set("Jan", this.countAvaliacao(1,ano, unidade2));
        series2.set("Fev", this.countAvaliacao(2,ano, unidade2));
        series2.set("Mar", this.countAvaliacao(3,ano, unidade2));
        series2.set("Abril", this.countAvaliacao(4,ano, unidade2));
        series2.set("Maio", this.countAvaliacao(5,ano, unidade2));
        series2.set("Jun", this.countAvaliacao(6,ano, unidade2));
        series2.set("Jul", this.countAvaliacao(7,ano, unidade2));
        series2.set("Ago", this.countAvaliacao(8,ano, unidade2));
        series2.set("Set", this.countAvaliacao(9,ano, unidade2));
        series2.set("Out", this.countAvaliacao(10,ano, unidade2));
        series2.set("Nov", this.countAvaliacao(11,ano, unidade2));
        series2.set("Dez", this.countAvaliacao(12,ano, unidade2)); 
        series2.setLabel(unidade2+" Total avaliações "+totalAvaliacao);
        model.addSeries(series2);
            
              }
        
            if(unidade3.length()>0){
         
          totalAvaliacaoAplicada = 0;

        ChartSeries series3 = new ChartSeries();
       

        series3.set("Jan", this.countAvaliacao(1,ano, unidade3));
        series3.set("Fev", this.countAvaliacao(2,ano, unidade3));
        series3.set("Mar", this.countAvaliacao(3,ano, unidade3));
        series3.set("Abril", this.countAvaliacao(4,ano, unidade3));
        series3.set("Maio", this.countAvaliacao(5,ano, unidade3));
        series3.set("Jun", this.countAvaliacao(6,ano, unidade3));
        series3.set("Jul", this.countAvaliacao(7,ano, unidade3));
        series3.set("Ago", this.countAvaliacao(8,ano, unidade3));
        series3.set("Set", this.countAvaliacao(9,ano, unidade3));
        series3.set("Out", this.countAvaliacao(10,ano, unidade3));
        series3.set("Nov", this.countAvaliacao(11,ano, unidade3));
        series3.set("Dez", this.countAvaliacao(12,ano, unidade3)); 
        series3.setLabel(unidade3+" Total avaliações "+totalAvaliacao);
        model.addSeries(series3);
            
              }
        
             if(unidade4.length()>0){
         
         totalAvaliacaoAplicada = 0;

        ChartSeries series4 = new ChartSeries();
        

        series4.set("Jan", this.countAvaliacao(1,ano, unidade4));
        series4.set("Fev", this.countAvaliacao(2,ano, unidade4));
        series4.set("Mar", this.countAvaliacao(3,ano, unidade4));
        series4.set("Abril", this.countAvaliacao(4,ano, unidade4));
        series4.set("Maio", this.countAvaliacao(5,ano, unidade4));
        series4.set("Jun", this.countAvaliacao(6,ano, unidade4));
        series4.set("Jul", this.countAvaliacao(7,ano, unidade4));
        series4.set("Ago", this.countAvaliacao(8,ano, unidade4));
        series4.set("Set", this.countAvaliacao(9,ano, unidade4));
        series4.set("Out", this.countAvaliacao(10,ano, unidade4));
        series4.set("Nov", this.countAvaliacao(11,ano, unidade4));
        series4.set("Dez", this.countAvaliacao(12,ano, unidade4)); 
        series4.setLabel(unidade4+" Total avaliações "+totalAvaliacao);
        model.addSeries(series4);
            
              }
        
              if(unidade5.length()>0){
         
          totalAvaliacaoAplicada = 0;

        ChartSeries series5 = new ChartSeries();
       

        series5.set("Jan", this.countAvaliacao(1,ano, unidade5));
        series5.set("Fev", this.countAvaliacao(2,ano, unidade5));
        series5.set("Mar", this.countAvaliacao(3,ano, unidade5));
        series5.set("Abril", this.countAvaliacao(4,ano, unidade5));
        series5.set("Maio", this.countAvaliacao(5,ano, unidade5));
        series5.set("Jun", this.countAvaliacao(6,ano, unidade5));
        series5.set("Jul", this.countAvaliacao(7,ano, unidade5));
        series5.set("Ago", this.countAvaliacao(8,ano, unidade5));
        series5.set("Set", this.countAvaliacao(9,ano, unidade5));
        series5.set("Out", this.countAvaliacao(10,ano, unidade5));
        series5.set("Nov", this.countAvaliacao(11,ano, unidade5));
        series5.set("Dez", this.countAvaliacao(12,ano, unidade5)); 
        series5.setLabel(unidade5+" Total avaliações "+totalAvaliacao);
        model.addSeries(series5);
            
              }
        
               if(unidade6.length()>0){
         
          totalAvaliacaoAplicada = 0;

        ChartSeries series6 = new ChartSeries();
        

        series6.set("Jan", this.countAvaliacao(1,ano, unidade6));
        series6.set("Fev", this.countAvaliacao(2,ano, unidade6));
        series6.set("Mar", this.countAvaliacao(3,ano, unidade6));
        series6.set("Abril", this.countAvaliacao(4,ano, unidade6));
        series6.set("Maio", this.countAvaliacao(5,ano, unidade6));
        series6.set("Jun", this.countAvaliacao(6,ano, unidade6));
        series6.set("Jul", this.countAvaliacao(7,ano, unidade6));
        series6.set("Ago", this.countAvaliacao(8,ano, unidade6));
        series6.set("Set", this.countAvaliacao(9,ano, unidade6));
        series6.set("Out", this.countAvaliacao(10,ano, unidade6));
        series6.set("Nov", this.countAvaliacao(11,ano, unidade6));
        series6.set("Dez", this.countAvaliacao(12,ano, unidade6)); 
        series6.setLabel(unidade6+" Total avaliações "+totalAvaliacao);
        model.addSeries(series6);
            
              }
        
                if(unidade7.length()>0){
         
         totalAvaliacaoAplicada = 0;

        ChartSeries series7 = new ChartSeries();
        

        series7.set("Jan", this.countAvaliacao(1,ano, unidade7));
        series7.set("Fev", this.countAvaliacao(2,ano, unidade7));
        series7.set("Mar", this.countAvaliacao(3,ano, unidade7));
        series7.set("Abril", this.countAvaliacao(4,ano, unidade7));
        series7.set("Maio", this.countAvaliacao(5,ano, unidade7));
        series7.set("Jun", this.countAvaliacao(6,ano, unidade7));
        series7.set("Jul", this.countAvaliacao(7,ano, unidade7));
        series7.set("Ago", this.countAvaliacao(8,ano, unidade7));
        series7.set("Set", this.countAvaliacao(9,ano, unidade7));
        series7.set("Out", this.countAvaliacao(10,ano, unidade7));
        series7.set("Nov", this.countAvaliacao(11,ano, unidade7));
        series7.set("Dez", this.countAvaliacao(12,ano, unidade7)); 
        series7.setLabel(unidade7+" Total avaliações "+totalAvaliacao);
        model.addSeries(series7);
            
              }
        
                 if(unidade8.length()>0){
         
          totalAvaliacaoAplicada = 0;

        ChartSeries series8 = new ChartSeries();
        series8.setLabel("Total avaliações");

        series8.set("Jan", this.countAvaliacao(1,ano, unidade8));
        series8.set("Fev", this.countAvaliacao(2,ano, unidade8));
        series8.set("Mar", this.countAvaliacao(3,ano, unidade8));
        series8.set("Abril", this.countAvaliacao(4,ano, unidade8));
        series8.set("Maio", this.countAvaliacao(5,ano, unidade8));
        series8.set("Jun", this.countAvaliacao(6,ano, unidade8));
        series8.set("Jul", this.countAvaliacao(7,ano, unidade8));
        series8.set("Ago", this.countAvaliacao(8,ano, unidade8));
        series8.set("Set", this.countAvaliacao(9,ano, unidade8));
        series8.set("Out", this.countAvaliacao(10,ano, unidade8));
        series8.set("Nov", this.countAvaliacao(11,ano, unidade8));
        series8.set("Dez", this.countAvaliacao(12,ano, unidade8)); 
        series8.setLabel(unidade8+" Total avaliações "+totalAvaliacao);
        model.addSeries(series8);
            
              }
        
                  if(unidade9.length()>0){
         
          totalAvaliacaoAplicada = 0;

        ChartSeries series9 = new ChartSeries();
        series9.setLabel("Total avaliações");

        series9.set("Jan", this.countAvaliacao(1,ano, unidade9));
        series9.set("Fev", this.countAvaliacao(2,ano, unidade9));
        series9.set("Mar", this.countAvaliacao(3,ano, unidade9));
        series9.set("Abril", this.countAvaliacao(4,ano, unidade9));
        series9.set("Maio", this.countAvaliacao(5,ano, unidade9));
        series9.set("Jun", this.countAvaliacao(6,ano, unidade9));
        series9.set("Jul", this.countAvaliacao(7,ano, unidade9));
        series9.set("Ago", this.countAvaliacao(8,ano, unidade9));
        series9.set("Set", this.countAvaliacao(9,ano, unidade9));
        series9.set("Out", this.countAvaliacao(10,ano, unidade9));
        series9.set("Nov", this.countAvaliacao(11,ano, unidade9));
        series9.set("Dez", this.countAvaliacao(12,ano, unidade9)); 
        series9.setLabel(unidade9+" Total avaliações "+totalAvaliacao);
        model.addSeries(series9);
            
              }
        
                   if(unidade10.length()>0){
         
          totalAvaliacaoAplicada = 0;

        ChartSeries series10 = new ChartSeries();
        series10.setLabel("Total avaliações");

        series10.set("Jan", this.countAvaliacao(1,ano, unidade10));
        series10.set("Fev", this.countAvaliacao(2,ano, unidade10));
        series10.set("Mar", this.countAvaliacao(3,ano, unidade10));
        series10.set("Abril", this.countAvaliacao(4,ano, unidade10));
        series10.set("Maio", this.countAvaliacao(5,ano, unidade10));
        series10.set("Jun", this.countAvaliacao(6,ano, unidade10));
        series10.set("Jul", this.countAvaliacao(7,ano, unidade10));
        series10.set("Ago", this.countAvaliacao(8,ano, unidade10));
        series10.set("Set", this.countAvaliacao(9,ano, unidade10));
        series10.set("Out", this.countAvaliacao(10,ano, unidade10));
        series10.set("Nov", this.countAvaliacao(11,ano, unidade10));
        series10.set("Dez", this.countAvaliacao(12,ano, unidade10)); 
        series10.setLabel(unidade10+" Total avaliações "+totalAvaliacao);
        model.addSeries(series10);
            
              }
        
                 
        }catch(NullPointerException e){
         
         }
        
        return model;
    } 
    
     
      private LineChartModel initLinearModel5() {
     LineChartModel model = new LineChartModel();

         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
     
     ChartSeries series1 = new ChartSeries();
        

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade,"Programado"));
        series1.setLabel(unidade+" Status - Programado"+totalStatusPlan );
        ChartSeries series2 = new ChartSeries();
        

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade,"Concluido"));
        series2.setLabel(unidade+" Status - Concluido "+totalStatusConc);
        
        ChartSeries series3 = new ChartSeries();
        

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade,"Cancelado")); 
        series3.setLabel(unidade+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
       

        return model;
    }

      
     private LineChartModel initLinearModel6() {
     LineChartModel model = new LineChartModel();

         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
         
       ChartSeries series1 = new ChartSeries();
       ChartSeries series2 = new ChartSeries();
       ChartSeries series3 = new ChartSeries();
       
       
        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade2,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade2,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade2,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade2,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade2,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade2,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade2,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade2,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade2,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade2,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade2,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade2,"Programado"));
        series1.setLabel(unidade2+" Status - Programado"+totalStatusPlan );
       
       

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade2,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade2,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade2,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade2,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade2,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade2,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade2,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade2,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade2,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade2,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade2,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade2,"Concluido"));
        series2.setLabel(unidade2+" Status - Concluido"+totalStatusPlan );
        
        

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade2,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade2,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade2,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade2,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade2,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade2,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade2,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade2,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade2,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade2,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade2,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade2,"Cancelado")); 
        series3.setLabel(unidade2+" Status - Cancelado"+totalStatusPlan );
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
       
//     }

        return model;
    }
  
       private LineChartModel initLinearModel7() {
     LineChartModel model = new LineChartModel();

     
         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
    
         
       graf3 =true;  
       ChartSeries series1 = new ChartSeries();
       

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade3,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade3,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade3,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade3,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade3,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade3,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade3,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade3,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade3,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade3,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade3,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade3,"Programado"));
        series1.setLabel(unidade3+" Status - Programado"+totalStatusPlan );
        ChartSeries series2 = new ChartSeries();
     

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade3,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade3,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade3,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade3,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade3,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade3,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade3,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade3,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade3,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade3,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade3,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade3,"Concluido"));
        series2.setLabel(unidade3+" Status - Concluido"+totalStatusPlan );
        
        ChartSeries series3 = new ChartSeries();
       

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade3,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade3,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade3,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade3,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade3,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade3,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade3,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade3,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade3,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade3,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade3,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade3,"Cancelado")); 
        series3.setLabel(unidade3+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
     

        return model;
    }
     
        private LineChartModel initLinearModel8() {
     LineChartModel model = new LineChartModel();

         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
     
     
         
       graf4 =true;  
       ChartSeries series1 = new ChartSeries();
       

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade4,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade4,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade4,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade4,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade4,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade4,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade4,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade4,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade4,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade4,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade4,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade4,"Programado"));
        series1.setLabel(unidade4+" Status - Programado"+totalStatusPlan );
        ChartSeries series2 = new ChartSeries();
       

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade4,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade4,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade4,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade4,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade4,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade4,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade4,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade4,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade4,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade4,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade4,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade4,"Concluido"));
        series2.setLabel(unidade4+" Status - Concluido"+totalStatusPlan );
        
        ChartSeries series3 = new ChartSeries();
       

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade4,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade4,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade4,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade4,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade4,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade4,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade4,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade4,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade4,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade4,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade4,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade4,"Cancelado")); 
        series3.setLabel(unidade4+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
    

        return model;
    }
      
        
    private LineChartModel initLinearModel9() {
     LineChartModel model = new LineChartModel();

     
     totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
     
     
         
       graf5 =true;  
       ChartSeries series1 = new ChartSeries();
        

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade5,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade5,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade5,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade5,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade5,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade5,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade5,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade5,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade5,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade5,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade5,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade5,"Programado"));
        series1.setLabel(unidade5+" Status - Programado"+totalStatusPlan );
        ChartSeries series2 = new ChartSeries();
       

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade5,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade5,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade5,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade5,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade5,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade5,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade5,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade5,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade5,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade5,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade5,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade5,"Concluido"));
        series2.setLabel(unidade5+" Status - Concluido"+totalStatusPlan );
        ChartSeries series3 = new ChartSeries();
        

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade5,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade5,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade5,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade5,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade5,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade5,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade5,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade5,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade5,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade5,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade5,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade5,"Cancelado")); 
        series3.setLabel(unidade5+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
     

        return model;
    }     
     
    private LineChartModel initLinearModel10() {
     LineChartModel model = new LineChartModel();

     
         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
    
         
       graf6 =true;  
       ChartSeries series1 = new ChartSeries();
        

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade6,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade6,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade6,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade6,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade6,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade6,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade6,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade6,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade6,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade6,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade6,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade6,"Programado"));
        series1.setLabel(unidade6+" Status - Programado"+totalStatusPlan );
        ChartSeries series2 = new ChartSeries();
        series2.setLabel("Status - Concluido");

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade6,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade6,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade6,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade6,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade6,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade6,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade6,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade6,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade6,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade6,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade6,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade6,"Concluido"));
        series2.setLabel(unidade6+" Status - Concluido"+totalStatusPlan );
        ChartSeries series3 = new ChartSeries();
       

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade6,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade6,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade6,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade6,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade6,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade6,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade6,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade6,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade6,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade6,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade6,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade6,"Cancelado")); 
        series3.setLabel(unidade6+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
    

        return model;
    }     
    
    
    
    private LineChartModel initLinearModel11() {
     LineChartModel model = new LineChartModel();

         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
     
    
         
       graf7 =true;  
       ChartSeries series1 = new ChartSeries();
        

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade7,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade7,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade7,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade7,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade7,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade7,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade7,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade7,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade7,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade7,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade7,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade7,"Programado"));
        series1.setLabel(unidade7+" Status - Programado"+totalStatusPlan );
        ChartSeries series2 = new ChartSeries();
        series2.setLabel("Status - Concluido");

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade7,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade7,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade7,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade7,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade7,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade7,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade7,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade7,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade7,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade7,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade7,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade7,"Concluido"));
        series2.setLabel(unidade7+" Status - Concluido"+totalStatusPlan );
        
        ChartSeries series3 = new ChartSeries();
       

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade7,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade7,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade7,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade7,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade7,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade7,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade7,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade7,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade7,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade7,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade7,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade7,"Cancelado")); 
        series3.setLabel(unidade7+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
    

        return model;
    }     
    
    private LineChartModel initLinearModel12() {
     LineChartModel model = new LineChartModel();

     
         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
    
         
       graf8 =true;  
       ChartSeries series1 = new ChartSeries();
        series1.setLabel("Status - Programado");

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade8,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade8,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade8,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade8,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade8,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade8,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade8,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade8,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade8,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade8,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade8,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade8,"Programado"));
        series1.setLabel(unidade8+" Status - Programado"+totalStatusPlan );
        
        ChartSeries series2 = new ChartSeries();
       

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade8,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade8,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade8,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade8,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade8,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade8,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade8,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade8,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade8,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade8,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade8,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade8,"Concluido"));
        series2.setLabel(unidade8+" Status - Concluido"+totalStatusPlan );
        
        ChartSeries series3 = new ChartSeries();
        

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade8,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade8,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade8,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade8,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade8,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade8,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade8,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade8,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade8,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade8,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade8,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade8,"Cancelado")); 
        series3.setLabel(unidade8+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
    

        return model;
    }     
    
    private LineChartModel initLinearModel13() {
     LineChartModel model = new LineChartModel();

     
         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
    
         
       graf9 =true;  
       ChartSeries series1 = new ChartSeries();
        series1.setLabel("Status - Programado");

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade9,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade9,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade9,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade9,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade9,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade9,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade9,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade9,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade9,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade9,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade9,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade9,"Programado"));
        series1.setLabel(unidade9+" Status - Programado"+totalStatusPlan );
        
        ChartSeries series2 = new ChartSeries();
       

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade9,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade9,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade9,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade9,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade9,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade9,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade9,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade9,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade9,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade9,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade9,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade9,"Concluido"));
        series2.setLabel(unidade9+" Status - Concluido"+totalStatusPlan );
        
        ChartSeries series3 = new ChartSeries();
       

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade9,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade9,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade9,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade9,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade9,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade9,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade9,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade9,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade9,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade9,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade9,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade9,"Cancelado")); 
        series3.setLabel(unidade9+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
    

        return model;
    }     
    
    private LineChartModel initLinearModel14() {
     LineChartModel model = new LineChartModel();

     
         totalStatusGeral =0;
         totalStatusPlan= 0; 
         totalStatusConc= 0; 
         totalStatusCanc= 0; 
     
    
         
       graf10 =true;  
       ChartSeries series1 = new ChartSeries();
        series1.setLabel("Status - Programado");

        series1.set("Jan", this.countAvaliacaoStatus(1,ano, unidade10,"Programado"));
        series1.set("Fev", this.countAvaliacaoStatus(2,ano, unidade10,"Programado"));
        series1.set("Mar", this.countAvaliacaoStatus(3,ano, unidade10,"Programado"));
        series1.set("Abril", this.countAvaliacaoStatus(4,ano, unidade10,"Programado"));
        series1.set("Maio", this.countAvaliacaoStatus(5,ano, unidade10,"Programado"));
        series1.set("Jun",this.countAvaliacaoStatus(6,ano, unidade10,"Programado"));
        series1.set("Jul", this.countAvaliacaoStatus(7,ano, unidade10,"Programado"));
        series1.set("Ago", this.countAvaliacaoStatus(8,ano, unidade10,"Programado"));
        series1.set("Set", this.countAvaliacaoStatus(9,ano, unidade10,"Programado"));
        series1.set("Out", this.countAvaliacaoStatus(10,ano, unidade10,"Programado"));
        series1.set("Nov", this.countAvaliacaoStatus(11,ano, unidade10,"Programado"));
        series1.set("Dez", this.countAvaliacaoStatus(12,ano, unidade10,"Programado"));
        series1.setLabel(unidade10+" Status - Programado"+totalStatusPlan );
        
        ChartSeries series2 = new ChartSeries();
       

        series2.set("Jan", this.countAvaliacaoStatus(1,ano, unidade10,"Concluido"));
        series2.set("Fev", this.countAvaliacaoStatus(2,ano, unidade10,"Concluido"));
        series2.set("Mar", this.countAvaliacaoStatus(3,ano, unidade10,"Concluido"));
        series2.set("Abril", this.countAvaliacaoStatus(4,ano, unidade10,"Concluido"));
        series2.set("Maio", this.countAvaliacaoStatus(5,ano, unidade10,"Concluido"));
        series2.set("Jun", this.countAvaliacaoStatus(6,ano, unidade10,"Concluido"));
        series2.set("Jul", this.countAvaliacaoStatus(7,ano, unidade10,"Concluido"));
        series2.set("Ago", this.countAvaliacaoStatus(8,ano, unidade10,"Concluido"));
        series2.set("Set", this.countAvaliacaoStatus(9,ano, unidade10,"Concluido"));
        series2.set("Out", this.countAvaliacaoStatus(10,ano, unidade10,"Concluido"));
        series2.set("Nov", this.countAvaliacaoStatus(11,ano, unidade10,"Concluido"));
        series2.set("Dez", this.countAvaliacaoStatus(12,ano, unidade10,"Concluido"));
        series2.setLabel(unidade3+" Status - Concluido"+totalStatusPlan );
        
        ChartSeries series3 = new ChartSeries();
       

        series3.set("Jan", this.countAvaliacaoStatus(1,ano, unidade10,"Cancelado"));
        series3.set("Fev", this.countAvaliacaoStatus(2,ano, unidade10,"Cancelado"));
        series3.set("Mar", this.countAvaliacaoStatus(3,ano, unidade10,"Cancelado"));
        series3.set("Abril", this.countAvaliacaoStatus(4,ano, unidade10,"Cancelado"));
        series3.set("Maio", this.countAvaliacaoStatus(5,ano, unidade10,"Cancelado"));
        series3.set("Jun", this.countAvaliacaoStatus(6,ano, unidade10,"Cancelado"));
        series3.set("Jul", this.countAvaliacaoStatus(7,ano, unidade10,"Cancelado"));
        series3.set("Ago", this.countAvaliacaoStatus(8,ano, unidade10,"Cancelado"));
        series3.set("Set", this.countAvaliacaoStatus(9,ano, unidade10,"Cancelado"));
        series3.set("Out", this.countAvaliacaoStatus(10,ano, unidade10,"Cancelado"));
        series3.set("Nov", this.countAvaliacaoStatus(11,ano, unidade10,"Cancelado"));
        series3.set("Dez", this.countAvaliacaoStatus(12,ano, unidade10,"Cancelado")); 
        series3.setLabel(unidade10+" Status - Cancelado "+totalStatusCanc);
       
        
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
    

        return model;
    }     
    
   
        
    public double  countHour(int month, String year, String unidade){
     //  System.out.println("Contar");
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from ControleCurso where MONTH(Data_inclusao) = "+month+" and year(Data_inclusao)= "+year+"  and status = 'Concluido'  and unidade = '"+unidade+"'");
      
      
        double total=0;
       
        try
        {
            
            while (con_sql.resultset.next()) {
             
              String tempo = con_sql.resultset.getString("tempo");
                           
              total += Double.parseDouble(tempo);
              // System.out.println(total);
            }
             
               }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar no JTable3 "+erro);
}
     horaTotal += total;
     horaTotalGeral += total;
     return total;   
      }
    
    public double  countAvaliacaoFunc(int month, String year, String unidade){
   //    System.out.println("Contar");
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from ControleCurso where MONTH(Data_inclusao) = "+month+" and year(Data_inclusao)= "+year+" and status = 'Concluido'  and unidade = '"+unidade+"'");
      
      
        double total=0;
       
        try
        {
            
            while (con_sql.resultset.next()) {
             
          //    String tempo = con_sql.resultset.getString("tempo");
             
              total += 1;
          //     System.out.println(total);
            }
       
               }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar no JTable3 "+erro);
}
     totalFuncionarioTreinados +=total;   
     totalFuncionarioTreinadosGeral +=total;
     return total;   
      }
    
     public double  countHourMax(String year, String unidade){
     //  System.out.println("Contar");
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from ControleCurso where year(Data_inclusao)= "+year+" and unidade = '"+unidade+"'");
      
      
        double total=0;
       
        try
        {
            
            while (con_sql.resultset.next()) {
             
              String tempo = con_sql.resultset.getString("tempo");
             
              total += Double.parseDouble(tempo);
            //   System.out.println(total);
            }
       
               }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar no JTable3 "+erro);
}
        
     return total;   
      }
     
     public double  countManHour(int month, String year, String unidade) throws SQLException{
   //    System.out.println("Contar");
     
        
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from ControleCurso where MONTH(Data_inclusao) = "+month+" and year(Data_inclusao)= "+year+"  and status = 'Concluido' and unidade = '"+unidade+"'");
        //quantidadeFuncionario=0;
      //  quantFunc(unidade,month,year);
        double total=0;
       
        try
        {
            
            while (con_sql.resultset.next()) {
             
              String tempo = con_sql.resultset.getString("tempo");
             
              total += Double.parseDouble(tempo);
            //   System.out.println(total);
            }
       
               }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar no JTable3 "+erro);
}
       
       int total_func = this.quantFuncionario(unidade ,month, year); 
       totalCh +=  total/total_func; 
       totalChGeral += total/total_func;
       
   
 System.out.println("Ano"+month +" "+"Quantidade "+this.quantFuncionario(unidade ,month, year)+"Total "+total);
 System.out.println("Total "+this.quantFuncionario(unidade ,month, year) /total);
   return (total/total_func);   
      }
    
     public double  countAvaliacao(int month, String year, String unidade){
    //   System.out.println("Contar");
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from ControleCurso where MONTH(Data_inclusao) = "+month+" and year(Data_inclusao)= "+year+" and unidade = '"+unidade+"'");
      
         List<String> controle= new ArrayList<>();
        
        double total=0;
       
        try
        {
            
            while (con_sql.resultset.next()) {
             
             String avaliacao = con_sql.resultset.getString("obtModelo");
             
             if(controle.contains(avaliacao)){
                 
             }else{
                 controle.add(avaliacao); 
             }
            
            }
       
              for(int i=0; i < controle.size();i++){
         
              total++;
              
      }
            
               }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar no JTable3 "+erro);
}
        totalAvaliacao +=total;
        totalAvaliacaoGeral +=total;
        totalAvaliacaoAplicada += total;
     return total;   
      }
     public double  countAvaliacaoStatus(int month, String year, String unidade, String estatus){
  //     System.out.println("Contar");
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from ControleCurso where MONTH(Data_inclusao) = "+month+" and year(Data_inclusao)= "+year+" and unidade = '"+unidade+"'");
      
         List<String> controle= new ArrayList<>();
        
       int total=0;
       int totalprog=0;
       int totalconcluido=0;
       int totalcancelado=0;
        try
        {
            
            while (con_sql.resultset.next()) {
             
             String status = con_sql.resultset.getString("status");
             
             if(status.equals(estatus)){
                 
               total++;
               
               if(status.equals("Programado")){
                   totalprog++;
               }else if(status.equals("Concluido")){
                   totalconcluido++;
               }else if(status.equals("Cancelado")){
                   totalcancelado++;
               }
            
            }
       
               
            
          
      }
            
               }
catch (SQLException erro){
  //  JOptionPane.showMessageDialog(null,"Erro ao listar no JTable3 "+erro);
}
         totalStatusGeral += total;
         totalStatusPlan += totalprog; 
         totalStatusConc += totalconcluido; 
         totalStatusCanc += totalcancelado; 
        
     
        return total;   
      }
     public void quantFunc(String unidade, int mes, String ano) throws SQLException{
        ConnectFuncionario con = new ConnectFuncionario();
        listFuncionario = con.listFuncionarioGraf(unidade); 
        quantidadeFuncionario = 0;
        
    
              
        for(Funcionario resultados:listFuncionario){

           if(resultados.getData() == null){
              
           }else{
               
             String mesConsulta = this.casasZer(mes);
             String anoConsulta = ano;
             String mesBd = resultados.getData().substring(5, 7);
             String anoBd = resultados.getData().substring(0, 4);
             
                  if(mesConsulta.equals(mesBd) && anoConsulta.equals(anoBd)){
                     quantidadeFuncionario++;
                  }
             
//                System.out.println(this.casasZer(mes));
//               
//                System.out.println(ano);
//                
//                System.out.println(resultados.getData().substring(5, 7));
//                System.out.println(resultados.getData().substring(0, 4));
           }
           

          if(resultados.getStatus().equals("Ativo") && resultados.getUnidade().equals(unidade)){
                quantidadeFuncionario++;
                
         //       System.out.println(quantidadeFuncionario);
           } 
          
          
      }
       
    }
     public void carregarGrafico() throws SQLException{
         zerar();        
         showHiddenGrafic();
         this.createLineModels();
         this.createLineModels2();
         this.createLineModels3();
         this.createLineModels4();
         this.createLineModels5();
         this.createLineModels6();
         this.createLineModels7();
         this.createLineModels8();
         this.createLineModels9();
         this.createLineModels10();
         this.createLineModels11();
         this.createLineModels12();
         this.createLineModels13();
         this.createLineModels14();
         
         
     
     }
     
     public String aumentaGrafico1(){
         
         grafico1 = "height:550px;width:1000px";
         
         return grafico1;
     }
     public void showHiddenGrafic(){
         graf2=false;
         
        
         if(unidade2.length()>0){
            this.setGraf2(true);
             System.out.println("Unidade2"+graf2);
         }else if (unidade3.length()>0){
             graf3=true;
         }
         
         System.out.println("Unidade "+graf2);
     }
     
     public void zerar(){
         quantidadeFuncionario=0;
         horaTotal=0; 
         horaTotalGeral=0;
         totalFuncionarioTreinados=0;
         totalFuncionarioTreinadosGeral=0;
         totalCh=0;
         totalChGeral=0;
         totalAvaliacao=0;
         totalAvaliacaoGeral=0;
         totalStatusGeral=0;
         totalStatusPlan=0;
         totalStatusConc=0;
         totalStatusCanc=0;
     }
     
     public String casasZer(int valor){
         String mes = null;
         if(valor < 10){
             mes = "0"+valor;
         }else{
           mes = ""+valor;  
         }
         
      return  mes; 
     }
     
      public int quantFuncionario(String unidade, int mes, String ano) throws SQLException{
        ConnectFuncionario con = new ConnectFuncionario();
        listFuncionario = con.listFuncionarioGraf(unidade); 
       int quantidadeF = 0;
        
    
              
        for(Funcionario resultados:listFuncionario){

           if(resultados.getData() == null){
              
           }else{
               
             String mesConsulta = this.casasZer(mes);
             String anoConsulta = ano;
             String mesBd = resultados.getData().substring(5, 7);
             String anoBd = resultados.getData().substring(0, 4);
             
                  if(mesConsulta.equals(mesBd) && anoConsulta.equals(anoBd)){
                     quantidadeF++;
                  }
             
//                System.out.println(this.casasZer(mes));
//               
//                System.out.println(ano);
//                
//                System.out.println(resultados.getData().substring(5, 7));
//                System.out.println(resultados.getData().substring(0, 4));
           }
           

          if(resultados.getStatus().equals("Ativo") && resultados.getUnidade().equals(unidade)){
                quantidadeF++;
                
         //       System.out.println(quantidadeFuncionario);
           } 
          
          
      }
       return quantidadeF;
    }
}
