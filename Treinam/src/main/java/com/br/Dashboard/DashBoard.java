package com.br.Dashboard;

import com.br.ControleTreinamento.ControleCurso;
import com.br.Funcionarios.Funcionario;
import com.br.model.database.ConnectControle;
import com.br.model.database.ConnectFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;


/**
 *
 * @author v103760
 */

@ManagedBean (name="DashBoard")
@ViewScoped
public class DashBoard {
    
  private int quantidadeFuncionario;  
  private int quantidadeAvaliacao;
  private LineChartModel lineModel;

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public int getQuantidadeAvaliacao() {
        return quantidadeAvaliacao;
    }

    public void setQuantidadeAvaliacao(int quantidadeAvaliacao) {
        this.quantidadeAvaliacao = quantidadeAvaliacao;
    }

    public int getQuantidadeAvConcluida() {
        return quantidadeAvConcluida;
    }

    public void setQuantidadeAvConcluida(int quantidadeAvConcluida) {
        this.quantidadeAvConcluida = quantidadeAvConcluida;
    }

    public int getQuantidadeAvProgra() {
        return quantidadeAvProgra;
    }

    public void setQuantidadeAvProgra(int quantidadeAvProgra) {
        this.quantidadeAvProgra = quantidadeAvProgra;
    }

    public int getQuantidadeAvCanc() {
        return quantidadeAvCanc;
    }

    public void setQuantidadeAvCanc(int quantidadeAvCanc) {
        this.quantidadeAvCanc = quantidadeAvCanc;
    }
  private int quantidadeAvConcluida;
  private int quantidadeAvProgra;
  private int quantidadeAvCanc;
  
  private List<Funcionario> listFuncionario = new ArrayList<>();
  private List<ControleCurso> listControle = new ArrayList<>();

    
    public int getQuantidadeFuncionario() {
        return quantidadeFuncionario;
    }

    public void setQuantidadeFuncionario(int quantidadeFuncionario) {
        this.quantidadeFuncionario = quantidadeFuncionario;
    }
    
    public void quantFunc() throws SQLException{
        ConnectFuncionario con = new ConnectFuncionario();
        listFuncionario = con.listFuncionario(); 
        
        
    //   System.out.println();
        
        for(Funcionario resultados:listFuncionario){
     //    System.out.println(resultados.getStatus());
           if(resultados.getStatus().equals("Ativo")){
                quantidadeFuncionario++;
           } 
          
          
      }
        quantAvalicao(); 
    }
    public void quantAvalicao() throws SQLException{
            ConnectControle con = new ConnectControle();
            listControle = con.listControle();
            
            for(ControleCurso resultado: listControle){
                
                quantidadeAvaliacao++;
               
            }
            
        }
    
    public void createLineModel() {
        lineModel = new LineChartModel();
        ChartData data = new ChartData();

        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        dataSet.setData(values);
        dataSet.setFill(false);
        dataSet.setLabel("My First Dataset");
        dataSet.setBorderColor("rgb(75, 192, 192)");
       // dataSet.setLineTension(0.1);
        data.addChartDataSet(dataSet);

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);

        //Options
        LineChartOptions options = new LineChartOptions();
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Line Chart");
        options.setTitle(title);

        
    }

}
