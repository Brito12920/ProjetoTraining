package com.br.Funcionarios;

import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.model.dao.FuncionarioDAO;
import com.br.model.database.ConnectFuncionario;
import com.br.model.database.Database;
import static com.br.model.database.DatabaseFactory.getDatabase;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;


@ManagedBean (name="FuncionarioBean")
@ViewScoped
public class FuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private UploadedFile file;
    private UploadedFiles files;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFiles getFiles() {
        return files;
    }

    public void setFiles(UploadedFiles files) {
        this.files = files;
    }
    
    
    private Funcionario funcionarios = new Funcionario();
    private final Database database = getDatabase("mysql");
    private final Connection connection = database.conectar();
     
    private final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
     ArrayList<String> ListaStatus = new ArrayList();

    public ArrayList<String> getListaStatus() {
        
        if(!ListaStatus.contains("Ativo") || !ListaStatus.contains("Inativo")){
           ListaStatus.add("Ativo"); 
           ListaStatus.add("Inativo");
                 
        }
        
        return ListaStatus;
    }

    public void setListaStatus(ArrayList<String> ListaStatus) {
        this.ListaStatus = ListaStatus;
    }
    
    
    public Funcionario getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionarios) {
        this.funcionarios = funcionarios;
    }

    private List<Funcionario> listFuncionario = new ArrayList<>();

    public List<Funcionario> getListFuncionario() throws SQLException {
        ConnectFuncionario con = new ConnectFuncionario();
        listFuncionario = con.listFuncionario(); 
        
        return listFuncionario;
    }

    public void setListFuncionario(List<Funcionario> listFuncionario) {
        this.listFuncionario = listFuncionario;
    }
    
    
    public List<Funcionario> getFunc() throws SQLException {

          ConnectFuncionario con = new ConnectFuncionario();
          List<Funcionario> listaFuncionario = con.listFuncionario();

          return listaFuncionario;
     }

    public void adicionarObjetoAlist(){
        listFuncionario.add(funcionarios);
        funcionarios = new Funcionario();
        
    }

   public String cadastraFuncionario() throws SQLException {

                PesisteDadosJPA con = new PesisteDadosJPA();


                if (con.Insert(funcionarios)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Funcionário cadastrado com sucesso!", "Funcionário cadastrado com sucesso!"));
                     funcionarios = new Funcionario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
            //    con.closeConnection();

               

          return "";
     }    
     public String alterarFuncionario() throws SQLException {

                PesisteDadosJPA con = new PesisteDadosJPA();


                if (con.update(funcionarios)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Funcionário alterado com sucesso!", "Funcionário alterado com sucesso!"));
                     funcionarios = new Funcionario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
             //   con.closeConnection();

               

          return "";
     } 
      public String excluirFuncionario() throws SQLException {

                PesisteDadosJPA con = new PesisteDadosJPA();
                
              
                if (con.deleteFuncionario(funcionarios.getCodigo(),"Funcionario")) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Funcionário excluido com sucesso!", "Funcionário excluido com sucesso!"));
                     funcionarios = new Funcionario();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
              

               

          return "";
     }   
      
      public void buscarFuncionario(){
          PesisteDadosJPA con = new PesisteDadosJPA();
          con.load();
      }
     public void buscar() throws SQLException{
      // BuscaUsuario();
      System.out.println(funcionarios.getNome());
    }
      public void editar(Funcionario e)
    {
        funcionarios = e;
    }
     public String sobre()
  {
    return "CadastroFuncionarios";
  } 
    public  String BuscaUsuario() throws SQLException {

                ConnectFuncionario con = new ConnectFuncionario();


                if (con.lista()) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Sucesso!", "Usuário excluido com sucesso!"));
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
    
  public void AdicionarArquivo(FileUploadEvent event) throws FileNotFoundException, SQLException {
         UploadedFile file = event.getFile();
         String nome_anexo = event.getFile().getFileName();
        if (incluirArquivo(file)) {
            FacesMessage msg = new FacesMessage("Arquivo", event.getFile().getFileName() + " Anexado com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
}  

    private boolean incluirArquivo(UploadedFile file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
   
   public List<ListaFuncionario> getFuncExcel() throws SQLException, IOException {
         
          CaminhoArquivo cam = new CaminhoArquivo();
          cam.setNomeArquivo("C:/Treinamento/Funcionarios.xls");
          DadosFuncionario dados = new DadosFuncionario();
          dados.buscar(cam.getNomeArquivo());
          List<ListaFuncionario> listaFuncionario = dados.getListaFuncionario();

          return listaFuncionario;
     }
   
    public List<ListaFuncionario> getGravaExcel() throws SQLException, IOException {

          DadosFuncionario dados = new DadosFuncionario();
        //  dados.gravar();
          List<ListaFuncionario> listaFuncionario = dados.getListaFuncionario();

          return listaFuncionario;
     }
    public void salvar() throws IOException{
          DadosFuncionario dados = new DadosFuncionario();
          dados.buscar("");
          GravarFuncionario gravar = new GravarFuncionario();
                      AlteraPessoa alt = new AlteraPessoa();
          List<ListaFuncionario> listaFuncionario = dados.getListaFuncionario();
        
         for(int i=0;i < listaFuncionario.size();i++){
            System.out.println(listaFuncionario.get(i).getNome());
       
                    String REGISTRO = listaFuncionario.get(i).getRegistro();
                    String NOME =listaFuncionario.get(i).getNome();
                    String FUNCAO = listaFuncionario.get(i).getFuncao();
                    String DEPARTAMENTO = listaFuncionario.get(i).getDepartamento();
                    String UNIDADE = listaFuncionario.get(i).getUnidade();
                     
                     
    
                                        
 
                    if(NOME.equals("NOME FUNCIONARIO")){
                        
                    }else{
                          gravar.Gravar(REGISTRO, NOME,FUNCAO, DEPARTAMENTO, UNIDADE,""); 
                          alt.AlteracaoGeral("Funcionario","imagem", "", "imagem", "null", "registro",REGISTRO);
                    }
         
         
         }
        FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Lista carregada com sucesso!", "Lista carregada com sucesso!"));
}
    public List<ListaFuncionario> getFuncExcelVazio() throws SQLException, IOException {

          
       //   List<ListaFuncionario> listaFuncionario = dados.getListaFuncionario();

          return null;
     }
public void upload() {
    BucarArquivo busca = new BucarArquivo();
busca.cria();      
}
public void save() throws SQLException {
    boolean outcome = false;
   
        cadastraFuncionario();
  
        PrimeFaces.current().ajax().update("tabela");
    
}
public void update() throws SQLException {
 
   
        alterarFuncionario();
  
        PrimeFaces.current().ajax().update("tabela");
    
}

}
