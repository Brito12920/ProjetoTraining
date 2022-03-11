package com.br.Modelo;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectModelo;
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
@ManagedBean (name="ModeloBeanMB")
public class ModeloBean implements Serializable {
    private List<Modelo> modelos= new ArrayList<>();
    private Modelo model = new Modelo();

    public List<Modelo> getModelos() {
        return Collections.unmodifiableList(modelos);
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public Modelo getModel() {
        return model;
    }

    public void setModel(Modelo model) {
        this.model = model;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
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
  public String alterarModelo() throws SQLException {

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
 public String excluirModelo() throws SQLException {

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
