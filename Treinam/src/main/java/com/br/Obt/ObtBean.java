
package com.br.Obt;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectControle;
import com.br.model.database.ConnectObt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;


/**
 *
 * @author v103760
 */

@RequestScoped
@ManagedBean (name="ObtMB")
public class ObtBean implements Serializable {
    
        
    private List<Obt> listaObt = new ArrayList<>();
    private static String nomeAvalicao;
    private static String codObt;
    private static String treinador;
    private boolean botaoConsultar;
    private String data;

    public String getData() {
       data = ""+java.time.LocalDate.now();
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public boolean isBotaoConsultar() {
        return botaoConsultar;
    }

    public void setBotaoConsultar(boolean botaoConsultar) {
        
                
        this.botaoConsultar = botaoConsultar;
    }
    
    public static String getTreinador() {
        return treinador;
    }

    public static void setTreinador(String treinador) {
        ObtBean.treinador = treinador;
    }

      
   private Obt selectedObt;

    private String dataHj;

    public String getDataHj() {
        
        return dataHj;
    }

    public void setDataHj(String dataHj) {
        this.dataHj = dataHj;
    }
    
     public Obt getSelectedObt() {
        return selectedObt;
    }

    public void setSelectedObt(Obt selectedObt) {
        this.selectedObt = selectedObt;
    }

    public String getCodObt() {
        return codObt;
    }

    public  void setCodObt(String codObt) {
        ObtBean.codObt = codObt;
    }
     
    public String getNomeAvalicao() {
        return nomeAvalicao;
    }

    public void setNomeAvalicao(String nomeAvalicao) {
        this.nomeAvalicao = nomeAvalicao;
    }

    
    
    public List<Obt> getListaObt() throws SQLException {
        ConnectObt con = new ConnectObt();
        listaObt = con.carregarObt();
        
        return listaObt;
    }

    public void setListaObt(List<Obt> listaObt) {
        this.listaObt = listaObt;
    }

    public Obt getObt() {
        return obt;
    }

    public void setObt(Obt obt) {
        System.out.println("teste"+obt.getObtModelo());
        nomeAvalicao = obt.getObtModelo();
         codObt = obt.getCodigoObt();
         treinador = obt.getAprovaFac();
         System.out.println("nomeAvalicao "+nomeAvalicao);
        this.obt = obt;
    }

  
    private Obt obt = new Obt();
    private static final long serialVersionUID = 1L;
    
   
   public void deleteSelectedFunc() throws SQLException {
             
//        this.ListaFuncionarios.remove(this.selectedFun);
//        this.selectedFun = null;
       System.out.println("Codigo "+codObt);
       
         ConnectObt lista = new ConnectObt();
         lista.removerObt(codObt);
          
         ConnectControle control = new ConnectControle();
         control.removerControle(codObt);
       
         FacesContext.getCurrentInstance().addMessage("MessageLista", new FacesMessage  (FacesMessage.SEVERITY_INFO,"Registro Excluido!", "Avaliação excluida com Sucesso!"));
         this.refresh();
    }
 public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
 public String update() throws SQLException {
         ConnectObt con = new ConnectObt();


                if (con.alterar(obt)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Dados alterado com sucesso!", "Dados alterado com sucesso!"));
                       obt = new Obt();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

         

//        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
         return "";
    }
 
 public String delete() throws SQLException {
         ConnectObt con = new ConnectObt();


                if (con.remover(obt)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Registro excluido com sucesso!", "Registro excluido com sucesso!"));
                       obt = new Obt();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

         

//        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
         return "";
    }
 public String deleteAvaliacao() throws SQLException {
         ConnectObt con = new ConnectObt();


                if (con.removerAvaliacao(obt)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Dados alterado com sucesso!", "Dados alterado com sucesso!"));
                       obt = new Obt();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

         

//        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
         return "";
    }
 public void teste(){
     System.out.println(obt.getCodigo());
 }
}
