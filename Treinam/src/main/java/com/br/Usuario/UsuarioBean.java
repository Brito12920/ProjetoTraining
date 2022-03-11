package com.br.Usuario;

import com.br.Funcionarios.Funcionario;
import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.model.database.ConnectUsuario;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean (name="UsuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
   
    ArrayList<String> ListaTipo = new ArrayList(); 

    public ArrayList<String> getListaTipo() {
        
        
        if(!ListaTipo.contains("Padrao")){
           ListaTipo.add("Padrao"); 
           ListaTipo.add("Master");
           ListaTipo.add("Super");  
        }else if(!ListaTipo.contains("Master")){
           ListaTipo.add("Master"); 
        }else if(!ListaTipo.contains("Super")){
            ListaTipo.add("Super"); 
        }
        
        
        
       
        
        
        return ListaTipo;
    }

    public void setListaTipo(ArrayList<String> ListaTipo) {
        this.ListaTipo = ListaTipo;
    }
   
    private boolean telaCad=false; 

    private boolean telaCad2=false; 

    public boolean isTelaCad2() {
        return telaCad2;
    }

    public void setTelaCad2(boolean telaCad2) {
        this.telaCad2 = telaCad2;
    }
   
    public boolean isTelaCad() {
        return telaCad;
    }

    public void setTelaCad(boolean telaCad) {
        this.telaCad = telaCad;
    }
    private Usuario usuario = new Usuario();
    private Funcionario funcionario = new Funcionario();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    private List<Usuario> listUsuario = new ArrayList<>();

    public List<Usuario> getListUsuario() throws SQLException {
    
        System.out.println("Aqui Lista");
         ConnectUsuario con = new ConnectUsuario();
        listUsuario = con.carregarUsuario(Permissao.getUnidade());
         System.out.println("Aqui Lista"+listUsuario.size());
        return Collections.unmodifiableList(listUsuario);
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        
        
        this.listUsuario = listUsuario;
    }

    public Usuario getUsuario() {
       
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

  

   public String cadastraUsuario() throws SQLException {
                usuario.setUsuario(funcionario.getRegistro());
                usuario.setDepartamento(funcionario.getDepartamento());
                usuario.setUnidade(funcionario.getUnidade());
                usuario.setTipo("Padrao");
                PesisteDadosJPA jpa = new PesisteDadosJPA();
          //      ConnectUsuario con = new ConnectUsuario();


                if (jpa.Insert(usuario)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Usuario cadastrado com sucesso!", "Usuario cadastrado com sucesso!"));
                     usuario = new Usuario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
              //  con.closeConnection();

               

          return "";
     }    
     public String alterarFuncionario() throws SQLException {

                 ConnectUsuario con = new ConnectUsuario();


                if (con.alterar(usuario)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Usuario alterado com sucesso!", "Usuario alterado com sucesso!"));
                     usuario = new Usuario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
      public String excluirFuncionario() throws SQLException {

               ConnectUsuario con = new ConnectUsuario();


                if (con.remover(usuario)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Usuario excluido com sucesso!", "Usuario excluido com sucesso!"));
                     usuario = new Usuario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }   
    
    public  String BuscaUsuario() throws SQLException {

               ConnectUsuario con = new ConnectUsuario();


                if (con.listaUsuarios()) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Sucesso!", "Lista com sucesso!"));
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();



          return "";
     }
//    public void funcionarioExcel(){
//          BucarArquivo.cria();
//                             
//        DadosFuncionario dados = new DadosFuncionario();
//        dados.buscar(caminho);
//    }
   public void verificar() throws SQLException{
    //   ConnectFuncionario bus = new ConnectFuncionario();
       PesisteDadosJPA jpa = new PesisteDadosJPA();
       
       telaCad2 = jpa.findFunc("FROM Funcionario WHERE Registro = '"+funcionario.getRegistro()+"' and unidade = '"+funcionario.getUnidade()+"'",funcionario);
       System.out.println(telaCad2);
   } 
   public void habilitarTela(){
       telaCad = true;
   }
  public String cadastraUser() throws SQLException {
                  ConnectUsuario user = new ConnectUsuario(); 
                  System.out.println("Usuer "+funcionario.getRegistro());
     
                  if(user.verificarUsuario(funcionario.getRegistro())==true){
           FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Usuario já cadastrado favor contactar o superior ", "Usuario já cadastrado favor contactar o superior"));
       }else{
          PesisteDadosJPA jpa = new PesisteDadosJPA();
                usuario.setUsuario(funcionario.getRegistro());
                usuario.setDepartamento(funcionario.getDepartamento());
                usuario.setUnidade(funcionario.getUnidade());
                usuario.setTipo("Padrao");
                if (jpa.Insert(usuario)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Usuario cadastrado com sucesso!", "Usuario cadastrado com sucesso!"));
                     usuario = new Usuario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                } 
       }
                  
               
               
               

          return "";
     }    
   public String alterarUser() throws SQLException {

                 PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.update(usuario)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Usuario alterado com sucesso!", "Usuario alterado com sucesso!"));
                     usuario = new Usuario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
              

               

          return "";
}
   public String excluirUser() throws SQLException {

               PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.deleteFuncionario(usuario.getCodigo(),"Usuario")) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Usuario excluido com sucesso!", "Usuario excluido com sucesso!"));
                     usuario = new Usuario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
               
               

          return "";
     }   
}