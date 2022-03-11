package com.br.AvaliacaoTreinador;

import com.br.Departamento.Departamento;
import com.br.Quiz.SelectBooleanView;
import com.br.Usuario.Permissao;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectAvaliacao;
import com.br.model.database.ConnectDescricaoAvaliacao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author v103760
 */

@ManagedBean (name="CadastroDecAvalicaoMB")
@RequestScoped
public class CadastroDecAvalicaoBean implements Serializable {

     private static final long serialVersionUID = 1L;
     private String buscar;
     private String unidade;
     private static String nomeAvalicao;

    public static String getNomeAvalicao() {
        return nomeAvalicao;
    }

    public static void setNomeAvalicao(String nomeAvalicao) {
        CadastroDecAvalicaoBean.nomeAvalicao = nomeAvalicao;
    }

        
     Avaliacao avaliacao = new Avaliacao();

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

   

    public String getUnidade() {
        unidade = Permissao.getUnidade();
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
     
    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }
     private List<DescricaoAval> descricaoAvalicacoes= new ArrayList<>();
    private  ArrayList<String> ListaAvaliacoes = new ArrayList<>();

    public ArrayList<String> getListaAvaliacoes() throws SQLException {
        
        
          ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();
       descricaoAvalicacoes = con.ListarDescricaoAvaliacao();
      
           
       for(DescricaoAval resultados: descricaoAvalicacoes){
         
         if(ListaAvaliacoes.contains(resultados.getNomeAvaliacao()))  {
             
         }else{
             ListaAvaliacoes.add(resultados.getNomeAvaliacao());
         }
          
      }
        
        return ListaAvaliacoes;
    }

    public void setListaAvaliacoes(ArrayList<String> ListaAvaliacoes) {
        this.ListaAvaliacoes = ListaAvaliacoes;
    }
     
     
    public List<DescricaoAval> getDescricaoAvalicacoes() throws SQLException {
         ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();
        descricaoAvalicacoes = con.carregarDescricaoAvaliacao(SelectBooleanView.getTipoAvaliacao());
        return Collections.unmodifiableList(descricaoAvalicacoes);
    }

    public void setDescricaoAvalicacoes(List<DescricaoAval> descricaoAvalicacoes) throws SQLException {
       
        this.descricaoAvalicacoes = descricaoAvalicacoes;
    }

    public DescricaoAval getDescricaoAvaliacao() {
        return descricaoAvaliacao;
    }

    public void setDescricaoAvaliacao(DescricaoAval descricaoAvaliacao) {
         
        this.descricaoAvaliacao = descricaoAvaliacao;
    }
     private DescricaoAval descricaoAvaliacao = new DescricaoAval();
    
   
    public CadastroDecAvalicaoBean() {
    }
    
    
    
    public String cadastraDescricaoAvaliacao() throws SQLException {

                ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();


                if (con.inserir(descricaoAvaliacao)) {
                     FacesContext.getCurrentInstance().addMessage(
                      "messagesLogin", new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Cadastrado efetuado com sucesso!", "Cadastrado efetuado com sucesso!"));
                     descricaoAvaliacao = new DescricaoAval();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarDescricaoAvaliacao() throws SQLException {

                 ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();


                if (con.alterar(descricaoAvaliacao)) {
                     FacesContext.getCurrentInstance().addMessage(
                       "messagesLogin", new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Alteração efetuada com sucesso!", "Alteração efetuada com sucesso!"));
                      descricaoAvaliacao = new DescricaoAval();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirDescricaoAvaliacao() throws SQLException {

                 ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();


                if (con.remover(descricaoAvaliacao)) {
                     FacesContext.getCurrentInstance().addMessage(
                      "messagesLogin", new FacesMessage(FacesMessage.SEVERITY_WARN,
                      "Exclusão efetuada com sucesso!", "Exclusão efetuada com sucesso!"));
                     descricaoAvaliacao = new DescricaoAval();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
    
    
    
   public void ordenarCadastroAvalicao() throws SQLException{
       ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();
       descricaoAvalicacoes = con.DescricaoAvaliacaoBusca("unidade",Permissao.getUnidade());
   }
    
   
   public void onRowSelect(SelectEvent event){
       FacesMessage msg = new FacesMessage("Departamento selecionado", ((Departamento) event.getObject()).getDepartamento());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
       
   }
   public void onRowUnselect(UnselectEvent event){
       FacesMessage msg = new FacesMessage("Funcionario selecionado", ((Departamento) event.getObject()).getUnidade());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
   }
   
  public void buscar() throws SQLException{
      System.out.println("Coduigo"+buscar);
      ConnectDescricaoAvaliacao con = new ConnectDescricaoAvaliacao();
      descricaoAvalicacoes = con.DescricaoAvaliacaoBusca("nomeAvaliacao",buscar);
      
   
      
//    for(DescricaoAvaliacao strings : descricaoAvalicacoes){
//        descricaoAvaliacao.setCodigo(strings.getCodigo());
//        descricaoAvaliacao.setDescricao(strings.getDescricao());
//        descricaoAvaliacao.setNomeAvaliacao(strings.getNomeAvaliacao());
//        descricaoAvaliacao.setCategoria(strings.getCategoria());
//        descricaoAvaliacao.setDesc_categoria(strings.getDesc_categoria());
//        descricaoAvaliacao.setUnidade(strings.getUnidade());
//        descricaoAvaliacao.setCodigoObt(strings.getCodigoObt());
//    }
      
  }
  public String gravarAvaliacao() throws SQLException{
      
        ConnectAvaliacao con = new ConnectAvaliacao();
       for(DescricaoAval strings : descricaoAvalicacoes){
        
         
         String codigoObt = SelectBooleanView.getCodigoObt();
         String descricao = strings.getDescricao();
         int nota = strings.getNota();
         String avaliacao = SelectBooleanView.getNomeAvaliacao();
         String treinamento = SelectBooleanView.getTreinador();
         String unidade = strings.getUnidade();
         String categoria = strings.getCategoria();
         
           con.gravar(codigoObt,descricao,nota,avaliacao,treinamento,unidade,categoria);
         
//         System.out.println("Codigo Obt "+SelectBooleanView.getCodigoObt());
//         System.out.println("Desc Categoria"+strings.getDesc_categoria()); 
//       
//         System.out.println("Categoria "+strings.getCategoria());
//         
//         System.out.println("Codigo "+strings.getCodigo());
//         
//        
//      //   System.out.println("Descricao"+strings.getDescricao()); 
//         System.out.println("Nome Avaliacao"+SelectBooleanView.getNomeAvaliacao());
//         System.out.println("Treinamento"+SelectBooleanView.getTreinador());  
//         System.out.println("Unidade"+strings.getUnidade()); 
         
       }
        return "/app/Obt?faces-redirect=true";
  }
   
}
