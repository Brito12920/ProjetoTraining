package com.br.Alternativa;

import com.br.AvaliacaoTreinador.DescricaoAval;
import com.br.model.database.ConnectAlternativa;
import com.br.model.database.ConnectDescricaoAvaliacao;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author v103760
 */
@ManagedBean (name="CrudAlternativa")
@ViewScoped
public class CrudAlternativa implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Alternativa> alternativas;

     private List<DescricaoAval> descAvaliacao;
   

     ArrayList<String> nomeAliacao = new ArrayList();

    public ArrayList<String> getNomeAliacao() throws SQLException {
      
         ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();
        
        descAvaliacao= con.listModelo();
        
        
        for(int i=0; i < descAvaliacao.size();i++){
            
            if(nomeAliacao.contains(descAvaliacao.get(i).getNomeAvaliacao())){
                
            }else{
                nomeAliacao.add(""+descAvaliacao.get(i).getNomeAvaliacao()); 
            }
           
        }
        
        return nomeAliacao;
    }

    public void setNomeAliacao(ArrayList<String> nomeAliacao) {
        this.nomeAliacao = nomeAliacao;
    }
   

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

   

    public List<DescricaoAval> getDescAvaliacao() throws SQLException {
      
        return descAvaliacao;
    }

    public void setDescAvaliacao(List<DescricaoAval> descAvaliacao) {
        this.descAvaliacao = descAvaliacao;
    }
    
    private Alternativa selectedAlternativa;

    private String teste; 

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
    
    private List<Alternativa> selectedAlternativas;

    public List<Alternativa> getSelectedAlternativas() {
        return selectedAlternativas;
    }

    public void setSelectedAlternativas(List<Alternativa> selectedAlternativas) {
        this.selectedAlternativas = selectedAlternativas;
    }

   
   
    public List<Alternativa> getAlternativas() throws SQLException {
        ConnectAlternativa alter = new ConnectAlternativa();
        alternativas = alter.carregarAlternativa();
        return alternativas;
    }

    public Alternativa getSelectedAlternativa() {
       
        return selectedAlternativa;
    }

    public void setSelectedAlternativa(Alternativa selectedAlternativa) {
        this.selectedAlternativa = selectedAlternativa;
    }

    

    public void setSelectedProducts(List<Alternativa> selectedAlternativas) {
        this.selectedAlternativas = selectedAlternativas;
    }

    public void openNew() {
        this.selectedAlternativa = new Alternativa();
    }

    public String update() throws SQLException {
         ConnectAlternativa con = new ConnectAlternativa();


                if (con.alterar(selectedAlternativa)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                       selectedAlternativa = new Alternativa();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

         

//        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
         return "";
    }

     public String updateGlobal() throws SQLException {
         ConnectAlternativa con = new ConnectAlternativa();


                if (con.alterarGlobal(selectedAlternativa)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                       selectedAlternativa = new Alternativa();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

         

//        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
         return "";
    }
    public void deleteProduct() {
//        this.products.remove(this.selectedProduct);
//        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedAlternativas.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }

    public boolean hasSelectedProducts() {
        return this.selectedAlternativas != null && !this.selectedAlternativas.isEmpty();
    }

    public void deleteSelectedProducts() {
//        this.products.removeAll(this.selectedProducts);
//        this.selectedProducts = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }
     public void onRowSelect(SelectEvent<Alternativa> event) throws SQLException, IOException {
        FacesMessage msg = new FacesMessage("Image Selected", String.valueOf(event.getObject().getCod_obt())+" Click on the <button> for show ");
        FacesContext.getCurrentInstance().addMessage("messages", msg);
        System.out.println("Nome 1"+event.getObject().getDesc_obt());
        
    }

    public void onRowUnselect(UnselectEvent<Alternativa> event) {
        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject().getCod_obt()));
        FacesContext.getCurrentInstance().addMessage("messages", msg);
    }
}
