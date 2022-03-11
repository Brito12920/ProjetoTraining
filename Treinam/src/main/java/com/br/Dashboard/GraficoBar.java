/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Dashboard;

import Conexao.conexaoSQL;
import com.br.Funcionarios.Funcionario;
import com.br.model.database.ConnectFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author v103760
 */

@ManagedBean(name="GraficoBar")
public class GraficoBar {
    conexaoSQL con_sql;
    private BarChartModel testeGrafico;

    public BarChartModel getTesteGrafico() {
        return testeGrafico;
    }

    public void setTesteGrafico(BarChartModel testeGrafico) {
        this.testeGrafico = testeGrafico;
    }
     private List<Funcionario> listFuncionario = new ArrayList<>();
    
  @PostConstruct
    public void init() {
        try {
            createBarModels();
        } catch (SQLException ex) {
            Logger.getLogger(GraficoBar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

private void createBarModels() throws SQLException {

    testeGrafico = initBarModel2();
    testeGrafico.setTitle("Bar Charts");
    testeGrafico.setAnimate(true);
    testeGrafico.setLegendPosition("ne");

    Axis yAxis = testeGrafico.getAxis(AxisType.Y);
    yAxis.setMin(0);

}

private BarChartModel initBarModel2() throws SQLException {
    BarChartModel model2 = new BarChartModel();

//    
//     graficoA = curvaABCDAO.listaClientes();
//
//    graficoB = curvaABCDAO.listaClientesB();

    ChartSeries t1 = new ChartSeries();
    ChartSeries t2 = new ChartSeries();
    
    
    ConnectFuncionario con = new ConnectFuncionario();
        listFuncionario = con.listFuncionarioGraf("PTG"); 
        
        
     //   System.out.println();
        
        for(Funcionario resultados:listFuncionario){
     //    System.out.println(resultados.getStatus());
           if(resultados.getStatus().equals("Ativo") && resultados.getUnidade().equals("PTG")){
               // quantidadeFuncionario++;
                
                t1.setLabel(resultados.getUnidade());
                t1.set(resultados.getStatus(), resultados.getUnidade().length());

                
              //  System.out.println(quantidadeFuncionario);
           } 
          
          
      }
    
   

//    for (ChamadosEntity tc : graficoA) {
//        t1.setLabel(tc.getAbc());
//        t1.set(tc.getSolucao(), tc.getChamados());
//
//    }
//
//    for (ChamadosEntity tb : graficoB) {
//        t2.setLabel(tb.getAbc());
//        t2.set(tb.getSolucao(), tb.getChamados());
//
//    }

    model2.addSeries(t1);
    model2.addSeries(t2);
    return model2;
}
}
