package com.br.Departamento;

import com.br.Funcionarios.*;
import com.br.model.database.ConnectDepartamento;
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

@Named(value="ConsultaEspecificaDepbean")
@SessionScoped
public class ConsultaEspecificaDepbean implements Serializable {

     private static final long serialVersionUID = 1L;
    
     @SuppressWarnings("FieldMayBeFinal")
    private String textoBuscar="";
    private String registroBuscar="";
    private Departamento selectDepartamento;

    public Departamento getSelectDepartamento() {
        return selectDepartamento;
    }

    public void setSelectDepartamento(Departamento selectDepartamento) {
        this.selectDepartamento = selectDepartamento;
    }

    public String getRegistroBuscar() {
        return registroBuscar;
    }

    public void setRegistroBuscar(String registroBuscar) {
        this.registroBuscar = registroBuscar;
    }
     @SuppressWarnings("FieldMayBeFinal")
    private List<Departamento> listaDepartamento=new ArrayList<>();

    public String getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaDepartamento = listaDepartamento;
    }
     
    
   
    public ConsultaEspecificaDepbean() {
    }
    
   public void ordenarDepartamento() throws SQLException{
       ConnectDepartamento con = new ConnectDepartamento();
       listaDepartamento = con.obterDepartamentoBusca("Departamento",registroBuscar);
   }
    
   public void ordenarUnidade() throws SQLException{
       ConnectDepartamento con = new ConnectDepartamento();
       listaDepartamento = con.obterDepartamentoBusca("Unidade",textoBuscar);
   }
   
//   public void onRowSelect(SelectEvent event){
//       FacesMessage msg = new FacesMessage("Departamento selecionado", ((Departamento) event.getObject()).getDepartamento());
//       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
//       
//   }
   public void onRowUnselect(UnselectEvent event){
       FacesMessage msg = new FacesMessage("Funcionario selecionado", ((Departamento) event.getObject()).getUnidade());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
   }
   
   public void onRowSelect(SelectEvent event) {
    	 
       
         Departamento us = ((Departamento) event.getObject());
    	 setDepartamento(((Departamento) event.getObject()).getCodigo(),((Departamento) event.getObject()).getDepartamento(),((Departamento) event.getObject()).getUnidade()); 
         
     //    System.out.println("Depat "+((Departamento) event.getObject()).getDepartamento());
   }
  public void setDepartamento(String codigo,String departa,String unidade) { 
          Departamento dep = new Departamento();
     //    System.out.println("Depat "+departa);
          dep.setCodigo(codigo);
          dep.setDepartamento(departa);
          dep.setUnidade(unidade);
    	// this.selectDepartamento = departamento;
     }
}
