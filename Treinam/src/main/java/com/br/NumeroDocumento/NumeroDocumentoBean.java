package com.br.NumeroDocumento;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectNumeroDocumento;
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
@ManagedBean (name="NumeroDocumentoBeanMB")
public class NumeroDocumentoBean implements Serializable {
    private List<NumeroDocumento> numeroDocumento2= new ArrayList<>();
    private NumeroDocumento docu = new NumeroDocumento();

    public NumeroDocumento getDocu() {
        return docu;
    }

    public void setDocu(NumeroDocumento docu) {
        this.docu = docu;
    }

   
    public void setNumeroDocumento(NumeroDocumento docu) {
        this.docu =docu;
    }
    private String numeroDocumento;

    public String getModelo() throws SQLException {
         ConnectNumeroDocumento con = new  ConnectNumeroDocumento();
         numeroDocumento2 = con.carregarNumeroDocumento();
        
        return numeroDocumento;
    }

    
    private static final long serialVersionUID = 1L;
    
    
    public List<NumeroDocumento> getModelos() {
        return Collections.unmodifiableList(numeroDocumento2);
    }
 public String cadastraNumeroDocumento() throws SQLException {

                 ConnectNumeroDocumento con = new  ConnectNumeroDocumento();


                if (con.inserir(docu)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "NumeroDocumento cadastrado com sucesso!", "NumeroDocumento cadastrado com sucesso!"));
                     docu = new NumeroDocumento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarNumeroDocumento() throws SQLException {

               ConnectNumeroDocumento con = new  ConnectNumeroDocumento();


                if (con.alterar(docu)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "NumeroDocumento de processo alterado com sucesso!", "NumeroDocumento de processo alterado com sucesso!"));
                       docu = new NumeroDocumento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirNumeroDocumento() throws SQLException {

                ConnectNumeroDocumento con = new  ConnectNumeroDocumento();


                if (con.remover(docu)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "NumeroDocumento de processo excluido com sucesso!", "NumeroDocumento de processo excluido com sucesso!"));
                      docu = new NumeroDocumento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
