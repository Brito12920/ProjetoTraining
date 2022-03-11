package com.br.MapaSubProcesso;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectSubProcesso;
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

@Named(value="ConsultaEspecificaMapSubProcessBean")
@SessionScoped
public class ConsultaEspecificaMapSubProcessBean implements Serializable {

     private static final long serialVersionUID = 1L;
    
     @SuppressWarnings("FieldMayBeFinal")
    private String MapaBuscar="";

    public String getMapaBuscar() {
        return MapaBuscar;
    }

    public void setMapaBuscar(String MapaBuscar) {
        this.MapaBuscar = MapaBuscar;
    }

    public String getProcessoBuscar() {
        return ProcessoBuscar;
    }

    public void setProcessoBuscar(String ProcessoBuscar) {
        this.ProcessoBuscar = ProcessoBuscar;
    }
    private String ProcessoBuscar="";
    private SubProcesso selectSubProcesso;

    public SubProcesso getSelectSubProcesso() {
        return selectSubProcesso;
    }

    public void setSelectSubProcesso(SubProcesso selectSubProcesso) {
        this.selectSubProcesso = selectSubProcesso;
    }

  

  
     @SuppressWarnings("FieldMayBeFinal")
    private List<SubProcesso> listaSubProcesso=new ArrayList<>();

   

    public List<SubProcesso> getListaProcesso() {
        return Collections.unmodifiableList(listaSubProcesso);
    }

    public void setListaProcesso(List<SubProcesso> listaSubProcesso) {
        this.listaSubProcesso = listaSubProcesso;
    }
     
    
   
    public ConsultaEspecificaMapSubProcessBean() {
    }
    
   public void ordenarMapa() throws SQLException{
       ConnectSubProcesso con = new ConnectSubProcesso();
       listaSubProcesso = con.obterProcessoBusca("Mapa",MapaBuscar);
   }
    
   public void ordenarSubProcesso() throws SQLException{
       ConnectSubProcesso con = new ConnectSubProcesso();
       listaSubProcesso = con.obterProcessoBusca("SubProcesso",ProcessoBuscar);
   }
   
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
