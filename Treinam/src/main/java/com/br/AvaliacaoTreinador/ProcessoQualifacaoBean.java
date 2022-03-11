
package com.br.AvaliacaoTreinador;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectProcessoQualificacao;
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

@ManagedBean (name="ProcessoQualifacaoMB")
@RequestScoped
public class ProcessoQualifacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ProcessoQualificacao> processoQualificacao= new ArrayList<>();

    public List<ProcessoQualificacao> getProcessoQualificacao() {
        return processoQualificacao;
    }

    public void setProcessoQualificacao(List<ProcessoQualificacao> processoQualificacao) {
        this.processoQualificacao = processoQualificacao;
    }

    public ProcessoQualificacao getProcessoQualif() {
        return processoQualif;
    }

    public void setProcessoQualif(ProcessoQualificacao processoQualif) {
        this.processoQualif = processoQualif;
    }
    private ProcessoQualificacao processoQualif = new ProcessoQualificacao();

   
 public String cadastraDepartamento() throws SQLException {

                ConnectProcessoQualificacao con = new ConnectProcessoQualificacao();


                if (con.insertProcessoQualificacao(processoQualif)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Departamento cadastrado com sucesso!", "Departamento cadastrado com sucesso!"));
                     processoQualif = new ProcessoQualificacao();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
 
}
