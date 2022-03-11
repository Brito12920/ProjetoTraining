package com.br.Obt;

import com.br.Departamento.Departamento;
import com.br.Usuario.UsuarioBuscar;
import com.br.model.database.ConnectObt;
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

@Named(value="ConsultaEspecificaObtBean")
@SessionScoped
public class ConsultaObtAlternativaBean implements Serializable {

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

   
    public List<Obt> getListaobt() {
        return listaobt;
    }

    public void setListaobt(List<Obt> listaobt) {
        this.listaobt = listaobt;
    }
    private List<Obt> listaobt=new ArrayList<>();
    
    public ConsultaObtAlternativaBean() {
    }
    
   public void ordenarObt() throws SQLException{
       ConnectObt con = new ConnectObt();
       listaobt = con.obterObtBusca("re",Texto1Buscar);
   }
    public void ordenarLogin() throws SQLException{
       ConnectObt con = new ConnectObt();
       listaobt = con.obterObtSerch("re",UsuarioBuscar.getUsuario());
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
