package com.br.Treinamento;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectTreinamento;
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

@Named(value="ConsultaEspecificaTreinamentoBean")
@SessionScoped
public class ConsultaEspecificaTreinamentoBean implements Serializable {

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
   
    private Treinamento selectTreinamento;

    public Treinamento getSelectTreinamento() {
        return selectTreinamento;
    }

    public void setSelectTreinamento(Treinamento selectTreinamento) {
        this.selectTreinamento = selectTreinamento;
    }

    public List<Treinamento> getListaTreinamento() {
        return Collections.unmodifiableList(listaTreinamento);
    }

    public void setListaTreinamento(List<Treinamento> listaTreinamento) {
        this.listaTreinamento = listaTreinamento;
    }
    private List<Treinamento> listaTreinamento=new ArrayList<>();
    
    public ConsultaEspecificaTreinamentoBean() {
    }
    
   public void ordenarNome() throws SQLException{
       ConnectTreinamento con = new ConnectTreinamento();
       listaTreinamento = con.obterTreinamentoBusca("nome",Texto1Buscar);
   }
    
   public void ordenarFuncao() throws SQLException{
     ConnectTreinamento con = new ConnectTreinamento();
      listaTreinamento = con.obterTreinamentoBusca("funcao",Texto2Buscar);
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
