package com.br.Status;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectStatus;
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

@Named(value="ConsultaEspecificaStatusBean")
@SessionScoped
public class ConsultaEspecificaStatusBean implements Serializable {

     private static final long serialVersionUID = 1L;
    
     @SuppressWarnings("FieldMayBeFinal")
    private String Texto1Buscar="";
    private String Texto2Buscar="";

    public String getTexto1Buscar() {
        return Texto1Buscar;
    }

    public void setTexto1Buscar(String Texto1Buscar) {
        this.Texto1Buscar = Texto1Buscar;
    }

    public String getTexto2Buscar() {
        return Texto2Buscar;
    }

    public void setTexto2Buscar(String Texto2Buscar) {
        this.Texto2Buscar = Texto2Buscar;
    }

    public Status getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(Status selectStatus) {
        this.selectStatus = selectStatus;
    }

    public List<Status> getListaStatus() {
        return Collections.unmodifiableList(listaStatus);
    }

     @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setListaStatus(List<Status> listaStatus) {
        this.listaStatus = listaStatus;
    }
    private Status selectStatus;
    private List<Status> listaStatus=new ArrayList<>();
    
    public ConsultaEspecificaStatusBean() {
    }
    
   public void ordenarStatus() throws SQLException{
       ConnectStatus con = new ConnectStatus();
       listaStatus = con.obterModeloStatus("status",Texto1Buscar);
   }
    
   public void ordenarSubProcesso() throws SQLException{
       ConnectStatus con = new ConnectStatus();
       listaStatus = con.obterModeloStatus("status",Texto2Buscar);
   }
   
   public void onRowSelect(SelectEvent event){
       FacesMessage msg = new FacesMessage("Departamento selecionado", ((Departamento) event.getObject()).getDepartamento());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
       
   }
   public void onRowUnselect(UnselectEvent event){
       FacesMessage msg = new FacesMessage("Funcionario selecionado", ((Departamento) event.getObject()).getUnidade());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
   }

}
