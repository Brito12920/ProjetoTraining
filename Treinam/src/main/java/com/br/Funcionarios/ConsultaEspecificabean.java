
package com.br.Funcionarios;

import com.br.model.database.ConnectFuncionario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author v103760
 */

@Named(value="consultaEspecificabean")
@SessionScoped
public class ConsultaEspecificabean implements Serializable {

     private static final long serialVersionUID = 1L;
    
     @SuppressWarnings("FieldMayBeFinal")
    private String textoBuscar="";
    private String registroBuscar="";
    private Funcionario selectFuncionario;
    private Funcionario[] selectedFuncionarios;

    public Funcionario[] getSelectedFuncionarios() {
        return selectedFuncionarios;
    }

    public void setSelectedFuncionarios(Funcionario[] selectedFuncionarios) {
        this.selectedFuncionarios = selectedFuncionarios;
    }
    
    public Funcionario getSelectFuncionario() {
        return selectFuncionario;
    }

    public void setSelectFuncionario(Funcionario selectFuncionario) {
        this.selectFuncionario = selectFuncionario;
    }

    public String getRegistroBuscar() {
        return registroBuscar;
    }

    public void setRegistroBuscar(String registroBuscar) {
        this.registroBuscar = registroBuscar;
    }
    @SuppressWarnings("FieldMayBeFinal")
    private List<Funcionario> listaFuncionario=new ArrayList<>();

    public String getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }

    public List<Funcionario> getListaFuncionario() {
        return Collections.unmodifiableList(listaFuncionario);
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
     
    
   
    public ConsultaEspecificabean() {
    }
    
   public void ordenarFuncionario() throws SQLException{
       ConnectFuncionario con = new ConnectFuncionario();
       listaFuncionario = con.obterFuncionarioBusca("Registro",registroBuscar);
       System.out.println("Entrou aqui");
   }
    
   public void ordenarNome() throws SQLException{
       ConnectFuncionario con = new ConnectFuncionario();
       listaFuncionario = con.obterFuncionarioBusca("Nome",textoBuscar);
   }
   
   public void onRowSelect(SelectEvent event){
       FacesMessage msg = new FacesMessage("Funcionario selecionado", ((Funcionario) event.getObject()).getNome());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
   }
   public void onRowUnselect(UnselectEvent event){
       FacesMessage msg = new FacesMessage("Funcionario selecionado", ((Funcionario) event.getObject()).getNome());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
   }
    public void teste() { 
        
     
            
        for (Funcionario room : selectedFuncionarios) {   
            System.out.println(room.getNome());   
        }  
}
}