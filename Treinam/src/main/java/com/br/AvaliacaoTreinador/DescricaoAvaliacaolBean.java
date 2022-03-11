package com.br.AvaliacaoTreinador;

import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Usuario.Permissao;
import com.br.Utilitarios.RequestScoped;
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
@ManagedBean (name="DescricaoAvalicaoBean")
public class DescricaoAvaliacaolBean implements Serializable {
    private List<descricaoAvaliacao> descricoes= new ArrayList<>();
    private descricaoAvaliacao avaliacao = new descricaoAvaliacao();

    public List<descricaoAvaliacao> getDescricoes() {
        
         PesisteDadosJPA jpa = new PesisteDadosJPA();
         descricoes = jpa.loadDecricao("from descricaoAvaliacao");
                
        return Collections.unmodifiableList(descricoes);
    }

    public void setDescricoes(List<descricaoAvaliacao> descricoes) {
        this.descricoes = descricoes;
    }

    public descricaoAvaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(descricaoAvaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getNomeAv() {
        return nomeAv;
    }

    public void setNomeAv(String nomeAv) {
        this.nomeAv = nomeAv;
    }
    private String nomeAv;

    
   

   
    private static final long serialVersionUID = 1L;
    
    
  
 public String cadastra() throws SQLException {

                PesisteDadosJPA jpa = new PesisteDadosJPA();

                avaliacao.setUnidade(Permissao.getUnidade());
                if (jpa.Insert(avaliacao)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                      avaliacao = new descricaoAvaliacao();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                             

          return "";
     }    
  public String alterarProcesso() throws SQLException {

                PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.updateDescr(avaliacao)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                        avaliacao = new descricaoAvaliacao();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                             

          return "";
     } 
 public String excluirProcesso() throws SQLException {

                PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.deleteDescr(avaliacao.getCodigo())) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                        avaliacao = new descricaoAvaliacao();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                              

          return "";
     }  
 
  public void filttraAvaliacao(){
      PesisteDadosJPA jpa = new PesisteDadosJPA();
      descricoes = jpa.loadDecricao("from descricaoAvaliacao where nomeAvaliacao = '"+this.getNomeAv()+"' and unidade = '"+Permissao.getUnidade()+"'");
  }
}
