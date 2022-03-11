package com.br.MapaProcesso;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectProcesso;
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
@ManagedBean (name="MapaProcessoMB")
public class MapaProcessoBean implements Serializable {
    private List<Processo> processos= new ArrayList<>();
    private Processo process = new Processo();

    public Processo getProcess() {
        return process;
    }

    public void setProcess(Processo process) {
        this.process = process;
    }
    private String processo;

    public String getProcesso(){
         
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }
    private static final long serialVersionUID = 1L;
    
    
    public List<Processo> getProcessos() throws SQLException {
         ConnectProcesso con = new  ConnectProcesso();
         processos = con.carregarProcesso();
        return Collections.unmodifiableList(processos);
    }
 public String cadastraProcesso() throws SQLException {

                ConnectProcesso con = new  ConnectProcesso();


                if (con.inserir(process)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Processo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                     process = new Processo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarProcesso() throws SQLException {

                ConnectProcesso con = new  ConnectProcesso();


                if (con.alterar(process)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Mapa de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                      process = new Processo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirProcesso() throws SQLException {

                 ConnectProcesso con = new  ConnectProcesso();


                if (con.remover(process)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Mapa de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                     process = new Processo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
