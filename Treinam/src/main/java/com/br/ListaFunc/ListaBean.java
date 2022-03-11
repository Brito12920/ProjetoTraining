package com.br.ListaFunc;

import com.br.model.database.ConnectLista;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author v103760
 */


@ManagedBean (name="ListaBeanMB")
@ViewScoped
public class ListaBean implements Serializable {
    private List<ListaFunc> listas= new ArrayList<>();
    private ListaFunc lista = new ListaFunc();
    private List<ListaFunc> listaFuncionario= new ArrayList<>();
    @SuppressWarnings("unchecked")
    ArrayList<String> listaFunc = new ArrayList();

    
    
    public ArrayList<String> getListaFunc() throws SQLException {
        
          ConnectLista con = new ConnectLista();
          listaFuncionario = con.carregarListaComp();
      
            for(ListaFunc resultados:listaFuncionario){
         
                if(listaFunc.contains(resultados.getLista())){
                    
                }else{
                    listaFunc.add(resultados.getLista());
                }
                
      
            }
        return listaFunc;
    }
    
    public List<ListaFunc> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<ListaFunc> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    public List<ListaFunc> getListas() {
        return listas;
    }

    public void setListas(List<ListaFunc> listas) {
        this.listas = listas;
    }

    public ListaFunc getLista() {
        return lista;
    }

    public void setLista(ListaFunc lista) {
        this.lista = lista;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

   
    private String list;

   
   

    
    private static final long serialVersionUID = 1L;
    
    
  
 public String cadastraModelo() throws SQLException {

               ConnectLista con = new ConnectLista();


                if (con.inserir(lista)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
                    PrimeFaces.current().ajax().update("form:messages", "form:form_cadModelo");
                      lista = new ListaFunc();  //limpa a tela
                      listaFunc.clear();
                     return "/app/CadastroLista?faces-redirect=true";
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

                

           return "";
     }    
  public String alterarModelo() throws SQLException {

                ConnectLista con = new ConnectLista();


                if (con.alterar(lista)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo alterado com sucesso!", "Mapa de processo alterado com sucesso!"));
                       lista = new ListaFunc();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirLista() throws SQLException {
System.out.println("Excluir ");
                 ConnectLista con = new ConnectLista();


                if (con.remover(lista)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Lista de processo excluido com sucesso!", "Lista de processo excluido com sucesso!"));
                      lista = new ListaFunc();  //limpa a tela
                      return "/app/CadastroLista?faces-redirect=true"; 
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro ao excluir!"));

                }
                con.closeConnection();

               

           return "/app/CadastroLista?faces-redirect=true";   
     }  
  public List<String> completarLista(String consulta) throws SQLException{
      
    ConnectLista con = new ConnectLista();
      listaFuncionario = new ArrayList(new HashSet(con.carregarListaComp()));
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
       
      for(ListaFunc resultados:listaFuncionario){
          if(resultados.getLista().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getLista());
          }
      }
        
        
      return resultado;
  }  

}
