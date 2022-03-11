package com.br.Status;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectStatus;
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
@ManagedBean (name="StatusMB")
public class StatusBean implements Serializable {
    private List<Status> status= new ArrayList<>();
    private Status stats = new Status();
    private String statu;

    public List<Status> getStatus() {
        return Collections.unmodifiableList(status);
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public Status getStats() {
        return stats;
    }

    public void setStats(Status stats) {
        this.stats = stats;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
   
    
    private static final long serialVersionUID = 1L;
    
    
    public List<Status> getEstatus() {
        return Collections.unmodifiableList(status);
    }
 public String cadastraStatus() throws SQLException {

                ConnectStatus con = new  ConnectStatus();


                if (con.inserir(stats)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Status cadastrado com sucesso!", "Status cadastrado com sucesso!"));
                     stats = new Status();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de Status!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarStatus() throws SQLException {

               ConnectStatus con = new  ConnectStatus();


                if (con.alterar(stats)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Status de processo alterado com sucesso!", "Status de processo alterado com sucesso!"));
                       stats = new Status();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de Status!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirStatus() throws SQLException {

                ConnectStatus con = new  ConnectStatus();


                if (con.remover(stats)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Status de processo excluido com sucesso!", "Status de processo excluido com sucesso!"));
                      stats = new Status();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr deStatus!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
