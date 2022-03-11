
package com.br.QuantidadeFuncionarios;

import com.br.Departamento.Departamento;
import com.br.model.database.ConnectQuantidadeFunc;
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

@Named(value="ConsultaEspecificaQtFuncBean")
@SessionScoped
public class ConsultaEspecificaQtFuncBean implements Serializable {

     private static final long serialVersionUID = 1L;
    
     @SuppressWarnings("FieldMayBeFinal")
    private String Texto1Buscar="";
    private String Texto2Buscar="";

   
    private QuantidadeFunc selectModelo;

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

    public QuantidadeFunc getSelectModelo() {
        return selectModelo;
    }

    public void setSelectModelo(QuantidadeFunc selectModelo) {
        this.selectModelo = selectModelo;
    }

    public List<QuantidadeFunc> getListaModelo() {
        return listaModelo;
    }

    public void setListaModelo(List<QuantidadeFunc> listaModelo) {
        this.listaModelo = listaModelo;
    }
    private List<QuantidadeFunc> listaModelo=new ArrayList<>();
    
    public ConsultaEspecificaQtFuncBean() {
    }
    
   public void ordenarUnidade() throws SQLException{
       ConnectQuantidadeFunc con = new ConnectQuantidadeFunc();
       listaModelo = con.obterControleBusca("unidade",Texto1Buscar);
   }
    
   public void ordenarSubProcesso() throws SQLException{
       ConnectQuantidadeFunc con = new ConnectQuantidadeFunc();
       listaModelo = con.obterControleBusca("Mapa",Texto2Buscar);
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
