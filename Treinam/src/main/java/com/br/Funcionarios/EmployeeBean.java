
package com.br.Funcionarios;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectFuncionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author v103760
 */
@ManagedBean (name="EmployeeBeanMB")
@ViewScoped
public class EmployeeBean {
  private List<Funcionario> employeeList = new ArrayList<>();
  private List<Funcionario2> ListaFuncionarios = new ArrayList<>();
  private Funcionario2 selectedFun;

    public Funcionario2 getSelectedFun() {
        return selectedFun;
    }

    public void setSelectedFun(Funcionario2 selectedFun) {
        this.selectedFun = selectedFun;
    }
  private String registro;
  private String lista;

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }
    public List<Funcionario2> getListaFuncionarios() {
        return ListaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario2> ListaFuncionarios) {
        this.ListaFuncionarios = ListaFuncionarios;
    }
  private Funcionario selectedEmployee;
  private List<Funcionario> selectedEmployees;

    public List<Funcionario> getSelectedEmployees() {
        return selectedEmployees;
    }

    public void setSelectedEmployees(List<Funcionario> selectedEmployees) {
        this.selectedEmployees = selectedEmployees;
    }
  private List<Funcionario> filteredEmployeeList;

   
    public List<Funcionario> getFilteredEmployeeList() {
        return filteredEmployeeList;
    }

    public void setFilteredEmployeeList(List<Funcionario> filteredEmployeeList) {
        this.filteredEmployeeList = filteredEmployeeList;
    }
  public void setSelectedEmployee(Funcionario selectedEmployee) {
  
      this.selectedEmployee = selectedEmployee;
      FacesMessage msg = new FacesMessage("Produto selecionado!", "Produto: " + selectedEmployee.getNome());
      msg.setSeverity(FacesMessage.SEVERITY_INFO);
      FacesContext.getCurrentInstance().addMessage(null, msg);
      
      this.selectedEmployee = selectedEmployee;
  }

  public Funcionario getSelectedEmployee() {
      return selectedEmployee;
  }

  public List<Funcionario> getEmployeeList() throws SQLException {
        ConnectFuncionario con = new ConnectFuncionario();
        employeeList = con.obterFuncionario("");
        return employeeList;
  }
  public void teste() { 
        
//
//       selectedEmployees.stream().forEach((room) -> {
//          System.out.println(room.getNome());
//          
//      });  
}
  public void onRowSelect(SelectEvent<Funcionario> event) {
        FacesMessage msg = new FacesMessage("Product Selected", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        registro = event.getObject().getRegistro();
    }

    public void onRowUnselect(UnselectEvent<Funcionario> event) {
        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
           this.selectedEmployees.remove(this.selectedEmployees.get(0));
    } 

    public void deleteProduct() {
       System.out.println(selectedEmployees.size());
      
  
          
      for(int i=0;i < selectedEmployees.size();i++){
      //    System.out.println(selectedEmployees.get(i).getRegistro());
         if(selectedEmployees.get(i).getRegistro().equals(registro)){
             this.selectedEmployees.remove(this.selectedEmployees.get(i));
         }
    }
       
       
       
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
  public void deleteSelectedProducts() {
             
        this.selectedEmployees.remove(this.selectedFun);
        this.selectedFun = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
        PrimeFaces.current().ajax().update("dt-products:msgs", "dt-products:checkboxDT2");
        
    }
  public void deleteSelectedFunc() {
             
//        this.ListaFuncionarios.remove(this.selectedFun);
//        this.selectedFun = null;
         System.out.println(this.selectedFun);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionario Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:checkboxDT2");
        
    }
  public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedEmployees.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }
  public boolean hasSelectedProducts() {
        return this.selectedEmployees != null && !this.selectedEmployees.isEmpty();
    }
public void salvar() throws IOException{
         
          GravarFuncionario gravar = new GravarFuncionario();
                  
        //  List<Funcionario> listaFuncionario = dados.getListaFuncionario();
        
         for(int i=0;i < selectedEmployees.size();i++){
           System.out.println(selectedEmployees.get(i).getNome());
       
                    String REGISTRO = selectedEmployees.get(i).getRegistro();
                    String NOME =selectedEmployees.get(i).getNome();
                    String DEPARTAMENTO = selectedEmployees.get(i).getDepartamento();
                    String UNIDADE = selectedEmployees.get(i).getUnidade();
                     
                     
    
                                        
 
                   
                          gravar.GravarLista(REGISTRO, NOME, DEPARTAMENTO, UNIDADE,lista); 
                       
                          
         
         }
       
         FacesMessage msg = new FacesMessage("Lista salva com sucesso", "");
         FacesContext.getCurrentInstance().addMessage("MessageId", msg);
         
         this.deleteSelectedProducts();
        
         this.refresh();
}
public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
public void buscarFunc() throws SQLException{
    ConnectFuncionario con = new ConnectFuncionario();
        employeeList = con.obterFuncionario("Ta");
}
}