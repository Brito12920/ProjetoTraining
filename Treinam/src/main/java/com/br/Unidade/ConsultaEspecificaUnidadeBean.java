package com.br.Unidade;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectUnidade;
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

@Named(value="ConsultaEspecificaUnidadeBean")
@SessionScoped
public class ConsultaEspecificaUnidadeBean implements Serializable {

     private static final long serialVersionUID = 1L;
    
     @SuppressWarnings("FieldMayBeFinal")
    private String UnidadeBuscar="";

    public String getUnidadeBuscar() {
        return UnidadeBuscar;
    }

    public void setUnidadeBuscar(String UnidadeBuscar) {
        this.UnidadeBuscar = UnidadeBuscar;
    }
    private Unidade selectUnidade;

    public Unidade getSelectUnidade() {
        return selectUnidade;
    }

    public void setSelectUnidade(Unidade selectUnidade) {
        this.selectUnidade = selectUnidade;
    }

  

  
     @SuppressWarnings("FieldMayBeFinal")
    private List<Unidade> listaUnidade=new ArrayList<>();

   

    public List<Unidade> getListaUnidade() {
        return listaUnidade;
    }

    public void setListaUnidade(List<Unidade> listaUnidade) {
        this.listaUnidade = listaUnidade;
    }
     
    
   
    public ConsultaEspecificaUnidadeBean() {
    }
    
   public void ordenarUnidade() throws SQLException{
       ConnectUnidade con = new ConnectUnidade();
       listaUnidade = con.obterUnidadeBusca("unidade",UnidadeBuscar);
   }
    
//   public void ordenarProcesso() throws SQLException{
//       ConnectProcesso con = new ConnectProcesso();
//       listaProcesso = con.obterProcessoBusca("Processo",ProcessoBuscar);
//   }
   
   public void onRowSelect(SelectEvent event){
       FacesMessage msg = new FacesMessage("Departamento selecionado", ((Departamento) event.getObject()).getDepartamento());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
       
   }
   public void onRowUnselect(UnselectEvent event){
       FacesMessage msg = new FacesMessage("Funcionario selecionado", ((Departamento) event.getObject()).getUnidade());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
   }
   
//   public void onRowSelect(SelectEvent event) {
//    	 
//       
//         Departamento us = ((Departamento) event.getObject());
//    	 setDepartamento(((Departamento) event.getObject()).getCodigo(),((Departamento) event.getObject()).getDepartamento(),((Departamento) event.getObject()).getUnidade()); 
//         
//         System.out.println("Depat "+((Departamento) event.getObject()).getDepartamento());
//   }
//  public void setDepartamento(String codigo,String departa,String unidade) { 
//          Departamento dep = new Departamento();
//         System.out.println("Depat "+departa);
//          dep.setCodigo(codigo);
//          dep.setDepartamento(departa);
//          dep.setUnidade(unidade);
//    	// this.selectDepartamento = departamento;
//     }
}
