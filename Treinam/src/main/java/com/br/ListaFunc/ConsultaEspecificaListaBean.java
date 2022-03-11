package com.br.ListaFunc;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectLista;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
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

@Named(value="ConsultaEspecificaListaBean")
@SessionScoped
public class ConsultaEspecificaListaBean implements Serializable {

     private static final long serialVersionUID = 1L;
    
   
    private String Texto1Buscar;
    private String Texto2Buscar;

    public String getTexto1Buscar() {
        return Texto1Buscar;
    }

    public void setTexto1Buscar(String Texto1Buscar) {
        this.Texto1Buscar = Texto1Buscar;
    }

    public String getTexto2Buscar() {
        return Texto2Buscar;
    }

    public ListaFunc getSelectModelo() {
        return selectModelo;
    }

    public void setSelectModelo(ListaFunc selectModelo) {
        this.selectModelo = selectModelo;
    }

    public void setTexto2Buscar(String Texto2Buscar) {
        this.Texto2Buscar = Texto2Buscar;
    }

   

    public List<ListaFunc> getListaFunc() {
        return listaFunc;
    }

    public void setListaFunc(List<ListaFunc> listaFunc) {
        this.listaFunc = listaFunc;
    }
    private ListaFunc selectModelo;
    private List<ListaFunc> listaFunc=new ArrayList<>();
    
    public ConsultaEspecificaListaBean() {
    }
    
   public void ordenarLista() throws SQLException{
       ConnectLista con = new ConnectLista();
       listaFunc = con.obterLista("lista",Texto1Buscar);
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
