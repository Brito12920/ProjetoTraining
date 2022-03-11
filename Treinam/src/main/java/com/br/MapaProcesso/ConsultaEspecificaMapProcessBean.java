package com.br.MapaProcesso;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectProcesso;
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

@Named(value="ConsultaEspecificaMapProcessBean")
@SessionScoped
public class ConsultaEspecificaMapProcessBean implements Serializable {

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
    private Processo selectProcesso;

    public Processo getSelectProcesso() {
        return selectProcesso;
    }

    public void setSelectDepartamento(Departamento selectDepartamento) {
        this.selectProcesso = selectProcesso;
    }

  

  
     @SuppressWarnings("FieldMayBeFinal")
    private List<Processo> listaProcesso=new ArrayList<>();

   

    public List<Processo> getListaProcesso() {
        return listaProcesso;
    }

    public void setListaProcesso(List<Processo> listaProcesso) {
        this.listaProcesso = listaProcesso;
    }
     
    
   
    public ConsultaEspecificaMapProcessBean() {
    }
    
   public void ordenarMapa() throws SQLException{
       ConnectProcesso con = new ConnectProcesso();
       listaProcesso = con.obterProcessoBusca("Mapa",MapaBuscar);
   }
    
   public void ordenarProcesso() throws SQLException{
       ConnectProcesso con = new ConnectProcesso();
       listaProcesso = con.obterProcessoBusca("Processo",ProcessoBuscar);
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
