package com.br.TipoTreinamento;

import com.br.Tipo.*;
import com.br.Departamento.Departamento;
import com.br.model.database.ConnectTipoTreinamento;
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

@Named(value="ConsultaEspecificaTipoTreinamentoBean")
@SessionScoped
public class ConsultaEspecificaTipoTreinamentoBean implements Serializable {

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

 

     @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
   
    private Tipo selectTipoTreinamento;

    public Tipo getSelectTipoTreinamento() {
        return selectTipoTreinamento;
    }

    public void setSelectTipoTreinamento(Tipo selectTipoTreinamento) {
        this.selectTipoTreinamento = selectTipoTreinamento;
    }

    public List<TipoTreinamento> getListaTipoTreinamento() {
        return Collections.unmodifiableList(listaTipoTreinamento);
    }

    public void setListaTipoTreinamento(List<TipoTreinamento> listaTipoTreinamento) {
        this.listaTipoTreinamento = listaTipoTreinamento;
    }

    

   
    private List<TipoTreinamento> listaTipoTreinamento=new ArrayList<>();
    
    public ConsultaEspecificaTipoTreinamentoBean() {
    }
    
   public void ordenarTipo() throws SQLException{
       ConnectTipoTreinamento con = new ConnectTipoTreinamento();
       listaTipoTreinamento = con.obterTipoTreinamentoBusca("tipoTreinamento",Texto1Buscar);
   }
    
   public void ordenarSubProcesso() throws SQLException{
      ConnectTipoTreinamento con = new ConnectTipoTreinamento();
       listaTipoTreinamento = con.obterTipoTreinamentoBusca("tipoTreinamento",Texto2Buscar);
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
