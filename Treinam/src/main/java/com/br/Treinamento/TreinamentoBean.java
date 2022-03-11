package com.br.Treinamento;

import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Usuario.Permissao;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectTreinamento;
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
@ManagedBean (name="TreinamentoMB")
public class TreinamentoBean implements Serializable {
     private static final long serialVersionUID = 1L;
    private List<Treinamento> treinamentos= new ArrayList<>();
    private Treinamento treina = new Treinamento();

    public List<Treinamento> getTreinamentos() {
       PesisteDadosJPA jpa = new PesisteDadosJPA();
        treinamentos = jpa.loadTreinamento("from Treinamento where Unidade = '"+Permissao.getUnidade()+"'");
        return Collections.unmodifiableList(treinamentos);
    }

    public void setTreinamentos(List<Treinamento> treinamentos) {
        this.treinamentos = treinamentos;
    }

    public Treinamento getTreina() {
        return treina;
    }

    public void setTreina(Treinamento treina) {
        this.treina = treina;
    }

    public String getTrinamento() {
        return trinamento;
    }

    public void setTrinamento(String trinamento) {
        this.trinamento = trinamento;
    }
    private String trinamento;
   
    
    
   
 public String cadastraTreinamento() throws SQLException {

              PesisteDadosJPA jpa = new PesisteDadosJPA();

                 treina.setUnidade(Permissao.getUnidade());
                if (jpa.Insert(treina)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                     treina = new Treinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
              
               

          return "";
     }    
  public String alterarTreinamento() throws SQLException {

                PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.updateTreinamento(treina)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                          treina = new Treinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                             

          return "";
     } 
 public String excluirTreinamento() throws SQLException {

                 PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.deleteTreinador(treina.getCodigo())) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Tipo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                         treina = new Treinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
              
               

          return "";
     }     
}
