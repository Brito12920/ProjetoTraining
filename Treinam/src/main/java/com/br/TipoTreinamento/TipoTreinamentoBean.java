package com.br.TipoTreinamento;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectTipoTreinamento;
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
@ManagedBean (name="TipoTreinamenMB")
public class TipoTreinamentoBean implements Serializable {
    private List<TipoTreinamento> tipos= new ArrayList<>();

    public List<TipoTreinamento> getTipos() {
        return Collections.unmodifiableList(tipos);
    }

    public void setTipos(List<TipoTreinamento> tipos) {
        this.tipos = tipos;
    }

    public TipoTreinamento getTip() {
        return tip;
    }

    public void setTip(TipoTreinamento tip) {
        this.tip = tip;
    }

    public String getTipoTreinamento() {
        return tipoTreinamento;
    }

    public void setTipoTreinamento(String tipoTreinamento) {
        this.tipoTreinamento = tipoTreinamento;
    }
    private TipoTreinamento tip = new TipoTreinamento();

   
   
    private String tipoTreinamento;

  
    private static final long serialVersionUID = 1L;
    
    
    
 public String cadastraTipoTreinamento() throws SQLException {

               ConnectTipoTreinamento con = new ConnectTipoTreinamento();


                if (con.inserir(tip)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                     tip = new TipoTreinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarTipoTreinamento() throws SQLException {

               ConnectTipoTreinamento con = new ConnectTipoTreinamento();


                if (con.alterar(tip)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                       tip = new TipoTreinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirTipoTreinamento() throws SQLException {

                 ConnectTipoTreinamento con = new ConnectTipoTreinamento();


                if (con.remover(tip)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                        tip = new TipoTreinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
