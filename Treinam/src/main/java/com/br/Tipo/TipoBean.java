package com.br.Tipo;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectTipo;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;

/**
 *
 * @author v103760
 */

@RequestScoped
@ManagedBean (name="TipoMB")
public class TipoBean implements Serializable {
    private List<Tipo> tipos= new ArrayList<>();
    private Tipo tip = new Tipo();

    public Tipo getTip() {
        return tip;
    }

   
    public void setTipo(Tipo tip) {
        this.tip =tip;
    }
    private String tipo;

    public String getTipo() throws SQLException {
         ConnectTipo con = new ConnectTipo();
         tipos = con.carregarTipo();
        
        return tipo;
    }

    public void setTipo(String Tipo) {
        this.tipo = tipo;
    }
    private static final long serialVersionUID = 1L;
    
    
    public List<Tipo> getTipos() {
        return Collections.unmodifiableList(tipos);
    }
 public String cadastraTipo() throws SQLException {

               ConnectTipo con = new ConnectTipo();


                if (con.inserir(tip)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                     tip = new Tipo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarTipo() throws SQLException {

               ConnectTipo con = new ConnectTipo();


                if (con.alterar(tip)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                        tip = new Tipo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirTipo() throws SQLException {

                ConnectTipo con = new ConnectTipo();


                if (con.remover(tip)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                       tip = new Tipo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
