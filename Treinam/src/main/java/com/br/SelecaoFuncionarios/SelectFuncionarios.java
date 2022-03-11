package com.br.SelecaoFuncionarios;

import com.br.Funcionarios.Funcionario;
import com.br.model.database.ConnectFuncionario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author v103760
 */

@Named("SelectFuncionarios")
@ViewScoped
public class SelectFuncionarios implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Funcionario> funcionario;
    private String textoBuscar="";

    public String getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }
    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }
   
    private Funcionario selectedProduct;
    private List<Funcionario> selectedProducts;
    private List<Funcionario> listaFuncionario=new ArrayList<>();

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    @Inject
  //  private funcionarioService service;

    @PostConstruct
    public void init() {
//        products1 = service.getProducts(10);
//        products2 = service.getProducts(10);
//        products3 = service.getProducts(10);
//        products4 = service.getProducts(10);
//        products5 = service.getProducts(10);
//        products6 = service.getProducts(10);
    }

    

    public Funcionario getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Funcionario selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Funcionario> getSelectedProducts() throws SQLException {
        
         ConnectFuncionario con = new ConnectFuncionario();
         con.listFuncionario();
        
        return Collections.unmodifiableList(selectedProducts);
    }

    public void setSelectedProducts(List<Funcionario> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void onRowSelect(SelectEvent<Funcionario> event) {
        FacesMessage msg = new FacesMessage("Product Selected", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent<Funcionario> event) {
        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject().getNome()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     public void ordenarFuncionario() throws SQLException{
       ConnectFuncionario con = new ConnectFuncionario();
       listaFuncionario = con.obterFuncionarioBusca("Registro",textoBuscar);
       System.out.println("Entrou aqui");
   }
}