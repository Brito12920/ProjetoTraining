package com.br.MapaSubProcesso;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectSubProcesso;
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
@ManagedBean (name="SubProcessoMB")
public class MapaSubProcessoBean implements Serializable {
    private List<SubProcesso> processos= new ArrayList<>();
    private List<SubProcesso> subprocessos= new ArrayList<>();
    private SubProcesso process = new SubProcesso();

    public SubProcesso getProcess() {
        return process;
    }

    public void setProcess(SubProcesso process) {
        this.process = process;
    }

    public SubProcesso getSubProcesso() {
        return process;
    }

    public void setSubProcesso(SubProcesso process) {
        this.process = process;
    }
    private String processo;

    public String getProcesso() throws SQLException {
         ConnectSubProcesso con = new  ConnectSubProcesso();
         processos = con.carregarSubProcesso(process.getMapa());
        
        return processo;
    }

    public void setProcesso(String SubProcesso) {
        this.processo = processo;
    }
    private static final long serialVersionUID = 1L;
    
    
    public List<SubProcesso> getProcessos() throws SQLException {
         ConnectSubProcesso con = new  ConnectSubProcesso();
         processos = con.carregarSubProcesso(process.getMapa());
        return Collections.unmodifiableList(processos);
    }
 public String cadastraSubProcesso() throws SQLException {

                ConnectSubProcesso con = new  ConnectSubProcesso();


                if (con.inserir(process)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Processo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                     process = new SubProcesso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarProcesso() throws SQLException {

               ConnectSubProcesso con = new  ConnectSubProcesso();


                if (con.alterar(process)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Mapa de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                      process = new SubProcesso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirProcesso() throws SQLException {

                ConnectSubProcesso con = new  ConnectSubProcesso();


                if (con.remover(process)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Mapa de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                     process = new SubProcesso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }
 public List<String> MapaSubProcesso(String consulta) throws SQLException{
      
       ConnectSubProcesso con = new  ConnectSubProcesso();
        subprocessos = con.carregarSubProcesso(process.getSubprocesso());
      
      List<String> resultados = new ArrayList<String>();
      
        for(int i=0;i < subprocessos.size();i++){
         resultados.add(subprocessos.get(i).getSubprocesso());
        
  }
      
      return resultados;
  }
}
