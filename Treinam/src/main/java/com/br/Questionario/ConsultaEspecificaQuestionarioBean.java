package com.br.Questionario;

import com.br.Modelo.*;
import com.br.Departamento.Departamento;
import com.br.model.database.ConnectModelo;
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

@Named(value="ConsultaEspecificaQuestionarioBean")
@SessionScoped
public class ConsultaEspecificaQuestionarioBean implements Serializable {

     private static final long serialVersionUID = 1L;
    
     @SuppressWarnings("FieldMayBeFinal")
    private String Texto1Buscar="";
    private final String Texto2Buscar="";
    private Modelo selectModelo;
    private List<Modelo> listaModelo=new ArrayList<>();
    
    public ConsultaEspecificaQuestionarioBean() {
    }
    
   public void ordenarMapa() throws SQLException{
       ConnectModelo con = new ConnectModelo();
       listaModelo = con.obterModeloBusca("Mapa",Texto1Buscar);
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
