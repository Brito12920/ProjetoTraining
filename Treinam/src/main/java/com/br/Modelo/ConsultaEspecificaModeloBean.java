package com.br.Modelo;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectModelo;
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

@Named(value="ConsultaEspecificaModeloBean")
@SessionScoped
public class ConsultaEspecificaModeloBean implements Serializable {

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

    public Modelo getSelectModelo() {
        return selectModelo;
    }

    public void setSelectModelo(Modelo selectModelo) {
        this.selectModelo = selectModelo;
    }

    public List<Modelo> getListaModelo() {
        return Collections.unmodifiableList(listaModelo);
    }

     @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setListaModelo(List<Modelo> listaModelo) {
        this.listaModelo = listaModelo;
    }
    private Modelo selectModelo;
    private List<Modelo> listaModelo=new ArrayList<>();
    
    public ConsultaEspecificaModeloBean() {
    }
    
   public void ordenarTipo() throws SQLException{
       ConnectModelo con = new ConnectModelo();
       listaModelo = con.obterModeloBusca("Tipo",Texto1Buscar);
   }
    
   public void ordenarSubProcesso() throws SQLException{
       ConnectModelo con = new ConnectModelo();
       listaModelo = con.obterModeloBusca("Mapa",Texto2Buscar);
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
