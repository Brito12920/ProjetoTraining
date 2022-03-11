package com.br.QuantidadeFuncionarios;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectQuantidadeFunc;
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
@ManagedBean (name="QuantidadeFuncionarioMB")
public class QuantidadeFuncionariosBean implements Serializable {
    private List<QuantidadeFunc> quantidade= new ArrayList<>();

    public List<QuantidadeFunc> getQuantidade() {
        return Collections.unmodifiableList(quantidade);
    }

    public void setQuantidade(List<QuantidadeFunc> quantidade) {
        this.quantidade = quantidade;
    }

    public QuantidadeFunc getQuant() {
        return quant;
    }

    public void setQuant(QuantidadeFunc quant) {
        this.quant = quant;
    }

    public String getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(String quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
    private QuantidadeFunc quant = new QuantidadeFunc();
    private String quantidadeFuncionarios;
    private static final long serialVersionUID = 1L;
    
    
   
 public String cadastraQuantidadeFunc() throws SQLException {

               ConnectQuantidadeFunc con = new ConnectQuantidadeFunc();


                if (con.inserir(quant)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Quantidade cadastrado com sucesso!", "Quantidade cadastrado com sucesso!"));
                     quant = new QuantidadeFunc();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarQuantidadeFunc() throws SQLException {

                ConnectQuantidadeFunc con = new ConnectQuantidadeFunc();


                if (con.alterar(quant)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Quantidade de processo alterado com sucesso!", "Quantidade de processo alterado com sucesso!"));
                       quant = new QuantidadeFunc();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirQuantidadeFunc() throws SQLException {

                 ConnectQuantidadeFunc con = new ConnectQuantidadeFunc();


                if (con.remover(quant)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Quantidade de processo excluido com sucesso!", "Quantidade de processo excluido com sucesso!"));
                      quant = new QuantidadeFunc();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
