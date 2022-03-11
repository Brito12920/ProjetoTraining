package com.br.Questionario;

import com.br.Modelo.*;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectModelo;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;

/**
 *
 * @author v103760
 */

@RequestScoped
@ManagedBean (name="QuestionarioBeanMB")
public class QuestionarioBean implements Serializable {
    private final List<Modelo> modelos= new ArrayList<>();
    private Modelo model = new Modelo();
    private String modelo;
    private static final long serialVersionUID = 1L;
    
    
   
 public String cadastraModelo() throws SQLException {

               ConnectModelo con = new ConnectModelo();


                if (con.inserir(model)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                     model = new Modelo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarProcesso() throws SQLException {

               ConnectModelo con = new ConnectModelo();


                if (con.alterar(model)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                       model = new Modelo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirProcesso() throws SQLException {

                ConnectModelo con = new ConnectModelo();


                if (con.remover(model)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                      model = new Modelo();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
