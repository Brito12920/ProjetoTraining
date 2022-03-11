package com.br.ControleTreinamento;

import com.br.Funcionarios.AlteraPessoa;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectControle;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author v103760
 */
@RequestScoped
@ManagedBean (name="ConsultaControleMB")

public class ConsultaAvaliacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

  private final List<ControleCurso> controle = new ArrayList<>();
  private String registro;
  private String lista;


  
  private List<ControleCurso> numeroTreinamento= new ArrayList<>();
  ArrayList<String> listaNumeroDocumento = new ArrayList();

    public ArrayList<String> getListaNumeroDocumento() throws SQLException {
      
        ConnectControle con = new ConnectControle();
   
      numeroTreinamento = con.carregarControle();
      List<String> resultado = new ArrayList<>();
      numeroTreinamento.stream().forEach((resultados) -> {
       //   resultado.add(resultados.getNumeroTreinamento());
          
          if(listaNumeroDocumento.contains(resultados.getRegistroTreinamento())){
              
          }else{
              listaNumeroDocumento.add(resultados.getRegistroTreinamento());
          }
          
          
        });
        
        return listaNumeroDocumento;
    }

    public void setListaNumeroDocumento(ArrayList<String> listaNumeroDocumento) {
        this.listaNumeroDocumento = listaNumeroDocumento;
    }

   

  
      
  
  public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }
   
  private ControleCurso selectedControle;
  private List<ControleCurso> selectedControles;

    public List<ControleCurso> getSelectedControles() {
        return selectedControles;
    }

    public void setSelectedControles(List<ControleCurso> selectedControles) {
        this.selectedControles = selectedControles;
    }
  private List<ControleCurso> filteredControleList;

   
    public List<ControleCurso> getFilteredControleList() {
        return filteredControleList;
    }

    public void setFilteredEmployeeList(List<ControleCurso> filteredControleList) {
        this.filteredControleList = filteredControleList;
    }
  public void setSelectedControle(ControleCurso selectedControle) {
  
      this.selectedControle = selectedControle;
      FacesMessage msg = new FacesMessage("Produto selecionado!", "Produto: " + selectedControle.getNome());
      msg.setSeverity(FacesMessage.SEVERITY_INFO);
      FacesContext.getCurrentInstance().addMessage(null, msg);
      
      this.selectedControle = selectedControle;
  }

  public ControleCurso getSelectedControle() {
      return selectedControle;
  }

//  public List<Controle> getControleList() throws SQLException {
//        ConnectControle con = new  ConnectControle();
//        controleList = con.obterFuncionario();
//        return employeeList;
//  }
  public void statusConcluido() { 
        

       selectedControles.stream().forEach((room) -> {
        //  System.out.println(room.getNome());
           AlteraPessoa alt = new AlteraPessoa();
     
              alt.AlteracaoGeral("ControleCurso", "status","Concluido","RegistroTreinamento", room.getRegistroTreinamento(),"Registro", room.getRegistro());      
      
      
      });  
         FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Lista carregada com sucesso!", "Lista carregada com sucesso!"));
        this.refresh();
          
}
public void statusProgramado() throws SQLException { 
        

       selectedControles.stream().forEach((room) -> {
       //   System.out.println(room.getNome());
           AlteraPessoa alt = new AlteraPessoa();
     
              alt.AlteracaoGeral("ControleCurso", "status","Programado","RegistroTreinamento", room.getRegistroTreinamento(),"Registro", room.getRegistro());      
      
            selectedControle = new ControleCurso();  
      
      });  
         FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Lista carregada com sucesso!", "Lista carregada com sucesso!"));
     refresh();
          
}  
public void statusCancelado() { 
        

       selectedControles.stream().forEach((room) -> {
        //  System.out.println(room.getNome());
           AlteraPessoa alt = new AlteraPessoa();
     
              alt.AlteracaoGeral("ControleCurso", "status","Cancelado","RegistroTreinamento", room.getRegistroTreinamento(),"Registro", room.getRegistro());      
      
      
      });  
         FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Lista carregada com sucesso!", "Lista carregada com sucesso!"));
        this.refresh();
          
}
  public void onRowSelect(SelectEvent<ControleCurso> event) {
        FacesMessage msg = new FacesMessage("Product Selected", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        registro = event.getObject().getRegistro();
    }

    public void onRowUnselect(UnselectEvent<ControleCurso> event) {
        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
         //  this.selectedControle.remove(this.selectedControle.getCodigo());
    } 

    public void deleteProduct() {
//       System.out.println(selectedEmployees.size());
//      
//  
//          
//      for(int i=0;i < selectedEmployees.size();i++){
//          System.out.println(selectedEmployees.get(i).getRegistro());
//         if(selectedEmployees.get(i).getRegistro().equals(registro)){
//             this.selectedEmployees.remove(this.selectedEmployees.get(i));
//         }
    }
       
       
//       
//       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
//    }
//  public void deleteSelectedProducts() {
//       this.ListaFuncionarios.remove(this.selectedEmployees);
//        this.selectedEmployees = null;
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
//        PrimeFaces.current().executeScript("PF('selectedEmployee').clearFilters()");
//    }
//  public String getDeleteButtonMessage() {
//        if (hasSelectedProducts()) {
//            int size = this.selectedEmployees.size();
//            return size > 1 ? size + " products selected" : "1 product selected";
//        }
//
//        return "Delete";
//    }
  public boolean hasSelectedProducts() {
        return this.selectedControles != null && !this.selectedControles.isEmpty();
    }
//public void salvar() throws IOException{
//         
//          GravarFuncionario gravar = new GravarFuncionario();
//                  
//        //  List<Funcionario> listaFuncionario = dados.getListaFuncionario();
//        
//         for(int i=0;i < selectedEmployees.size();i++){
//           System.out.println(selectedEmployees.get(i).getNome());
//       
//                    String REGISTRO = selectedEmployees.get(i).getRegistro();
//                    String NOME =selectedEmployees.get(i).getNome();
//                    String DEPARTAMENTO = selectedEmployees.get(i).getDepartamento();
//                    String UNIDADE = selectedEmployees.get(i).getUnidade();
//                     
//                     
//    
//                                        
// 
//                   
//                          gravar.GravarLista(REGISTRO, NOME, DEPARTAMENTO, UNIDADE,lista); 
//                       
//                          
//         
//         }
//       
//         FacesMessage msg = new FacesMessage("Lista salva com sucesso", "");
//         FacesContext.getCurrentInstance().addMessage(null, msg);
//}

// public List<String> completarNumeroTreinamento(String consulta) throws SQLException{
// 
// String queryLowerCase = consulta.toLowerCase();
//              ConnectControle con = new ConnectControle();
//      numeroTreinamento = con.carregarTreinamentoPesp(consulta);
//      
//      List<String> resultado = new ArrayList<>();
//      numeroTreinamento.stream().forEach((resultados) -> {
//          resultado.add(resultados.getNumeroTreinamento());
//        });
//
//        return resultado.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
//  } 
public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	} 
}
