package com.br.Resposansavel;

import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Usuario.Permissao;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectResponsavel;
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
@ManagedBean (name="ResponsavelMB")
public class ResponsavelBean implements Serializable {
    private List<Responsavel> responsaveis= new ArrayList<>();
    private Responsavel resp = new Responsavel();

   
 
    private String responsavel;

    public List<Responsavel> getResponsaveis() {
       PesisteDadosJPA jpa = new PesisteDadosJPA();
        responsaveis = jpa.loadGestor("from Responsavel where Unidade = '"+Permissao.getUnidade()+"'");
        return Collections.unmodifiableList(responsaveis);
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public Responsavel getResp() {
        return resp;
    }

    public void setResp(Responsavel resp) {
        this.resp = resp;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

   

   
    private static final long serialVersionUID = 1L;
    
    
  
 public String cadastraResponsavel() throws SQLException {

                PesisteDadosJPA jpa = new PesisteDadosJPA();

                resp.setUnidade(Permissao.getUnidade());
                if (jpa.Insert(resp)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                      resp = new Responsavel();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                             

          return "";
     }    
  public String alterarProcesso() throws SQLException {

                PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.updateGestor(resp)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                        resp = new Responsavel();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                             

          return "";
     } 
 public String excluirProcesso() throws SQLException {

                PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.deleteGestor(resp.getCodigo())) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                       resp = new Responsavel(); //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                              

          return "";
     }     
}
