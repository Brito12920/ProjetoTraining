package com.br.ControleTreinamento;

import com.br.Alternativa.Alternativa;
import com.br.Departamento.Departamento;
import com.br.Funcionarios.AlteraPessoa;
import com.br.Funcionarios.Funcionario;
import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.ListaFunc.ListaFunc;
import com.br.MapaProcesso.Processo;
import com.br.MapaSubProcesso.SubProcesso;
import com.br.Modelo.Modelo;
import com.br.NumeroDocumento.NumeroDocumento;
import com.br.Resposansavel.Responsavel;
import com.br.Status.Status;
import com.br.Tipo.Tipo;
import com.br.TipoTreinamento.TipoTreinamento;
import com.br.Treinamento.Treinamento;
import com.br.Unidade.Unidade;
import com.br.Usuario.Permissao;
import com.br.UtilRelatorios.Relatorio;
import com.br.Utilitarios.RequestScoped;
import com.br.Utilitarios.UtilRelatorios;
import com.br.model.database.ConnectAlternativa;
import com.br.model.database.ConnectConsultaControle;
import com.br.model.database.ConnectControle;
import com.br.model.database.ConnectDepartamento;
import com.br.model.database.ConnectFuncionario;
import com.br.model.database.ConnectLista;
import com.br.model.database.ConnectModelo;
import com.br.model.database.ConnectNumeroDocumento;
import com.br.model.database.ConnectProcesso;
import com.br.model.database.ConnectResponsavel;
import com.br.model.database.ConnectStatus;
import com.br.model.database.ConnectSubProcesso;
import com.br.model.database.ConnectTipo;
import com.br.model.database.ConnectTipoTreinamento;
import com.br.model.database.ConnectTreinamento;
import com.br.model.database.ConnectUnidade;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;

import javax.faces.context.FacesContext;



@ManagedBean (name="ControleMB")
@RequestScoped
public class ControleBean implements Serializable {
    private List<ControleCurso> controles= new ArrayList<>();
    private List<Processo> mapaProcesso= new ArrayList<>();
    private List<Responsavel> gestor= new ArrayList<>();
    private List<Departamento> departamento= new ArrayList<>();
    private List<Modelo> modelo= new ArrayList<>();
    private List<Treinamento> treinamento= new ArrayList<>();
    private List<Alternativa> obt= new ArrayList<>();
    private List<Funcionario> listaFuncionario=new ArrayList<>();
    private List<ListaFunc> listaFunc=new ArrayList<>();
    private List<ListaFunc> listaFunc2=new ArrayList<>();
    private List<NumeroTreinamento> numeroTreinamento= new ArrayList<>();
    private ListaFunc selectedFun;
    private String adicionarNumero;

    @SuppressWarnings("unchecked")
    ArrayList<String> ListaMapaProcesso = new ArrayList<>();
    @SuppressWarnings("unchecked")
    ArrayList<String> ListaSubprocesso = new ArrayList<>();
    ArrayList<String> ListaDepartamento = new ArrayList<>();
    ArrayList<String> ListaUnidade = new ArrayList<>();

    public ArrayList<String> getListaUnidade() throws SQLException {
        ConnectUnidade con = new ConnectUnidade();
        unidade = con.carregarUnidade();
        
        for(Unidade resultados:unidade){
         
           if(ListaUnidade.contains(resultados.getUnidade())){
               
           }else{
              ListaUnidade.add(resultados.getUnidade());
           }
           
      }
        
        return ListaUnidade;
    }

    public void setListaUnidade(ArrayList<String> ListaUnidade) {
        this.ListaUnidade = ListaUnidade;
    }
    
    public ArrayList<String> getListaDepartamento() throws SQLException {
        ConnectDepartamento con = new ConnectDepartamento();
      departamento = con.carregarDepartamento();
      for(Departamento resultados:departamento){
         
           ListaDepartamento.add(resultados.getDepartamento());
      }
        return ListaDepartamento;
    }

    public void setListaDepartamento(ArrayList<String> ListaDepartamento) {
        this.ListaDepartamento = ListaDepartamento;
    }
    @SuppressWarnings("unchecked")
    ArrayList<String> ListaGestor = new ArrayList();

    public ArrayList<String> getListaGestor() throws SQLException {
        
          ConnectResponsavel con = new ConnectResponsavel();
          gestor = con.carregarResponsavel();
      
            for(Responsavel resultados:gestor){
         
         ListaGestor.add(resultados.getNome());
      }
        return ListaGestor;
    }

    public void setListaGestor(ArrayList<String> ListaGestor) {
        this.ListaGestor = ListaGestor;
    }

    public ArrayList<String> getListaTreinamento() throws SQLException {
        ConnectTreinamento con = new ConnectTreinamento();
      treinamento = con.carregarTreinamento();
      
        for(Treinamento resultados:treinamento){
         
          ListaTreinamento.add(resultados.getNome());
      }
        return ListaTreinamento;
    }

    public void setListaTreinamento(ArrayList<String> ListaTreinamento) {
        this.ListaTreinamento = ListaTreinamento;
    }

    public ArrayList<String> getListaTipoTreinamento() throws SQLException {
       ConnectTipoTreinamento con = new ConnectTipoTreinamento();
      tipoTreinamento = con.carregarTipoTreinamento();
      
     

        
      for(TipoTreinamento resultados:tipoTreinamento){

            ListaTipoTreinamento.add(resultados.getTipoTreinamento());
      }
        return ListaTipoTreinamento;
    }

    public void setListaTipoTreinamento(ArrayList<String> ListaTipoTreinamento) {
        this.ListaTipoTreinamento = ListaTipoTreinamento;
    }

    public ArrayList<String> getListaNomeTreinamento() throws SQLException {
      
      ConnectAlternativa con = new ConnectAlternativa();
      obt = con.carregarAlternativa();
      
           
       for(Alternativa resultados:obt){
         
         if(ListaNomeTreinamento.contains(resultados.getCod_obt()))  {
             
         }else{
             ListaNomeTreinamento.add(resultados.getCod_obt());
         }
          
      }
        return ListaNomeTreinamento;
    }

    public void setListaNomeTreinamento(ArrayList<String> ListaNomeTreinamento) {
        this.ListaNomeTreinamento = ListaNomeTreinamento;
    }

    public ArrayList<String> getListaTipo() throws SQLException {
         ConnectTipo con = new ConnectTipo();
      tipo = con.carregarTipo();
      
    
      for(Tipo resultados:tipo){
          
          ListaTipo.add(resultados.getTipo());
      }
        return ListaTipo;
    }

    public void setListaTipo(ArrayList<String> ListaTipo) {
        this.ListaTipo = ListaTipo;
    }

    public ArrayList<String> getListaModelo() throws SQLException {
       
        ConnectModelo con = new ConnectModelo();
        modelo = con.carregarModelo();
      
      List<String> resultado = new ArrayList<String>();
 
      for(Modelo resultados:modelo){

          ListaModelo.add(resultados.getTipo());
      }
        return ListaModelo;
    }

    public void setListaModelo(ArrayList<String> ListaModelo) {
        this.ListaModelo = ListaModelo;
    }
    @SuppressWarnings("unchecked")
    ArrayList<String> ListaTreinamento = new ArrayList(); 
    @SuppressWarnings("unchecked")
    ArrayList<String> ListaTipoTreinamento = new ArrayList();  
    @SuppressWarnings("unchecked")
    ArrayList<String> ListaNomeTreinamento = new ArrayList();  
    @SuppressWarnings("unchecked")
    ArrayList<String> ListaTipo = new ArrayList();  
    @SuppressWarnings("unchecked")
    ArrayList<String> ListaModelo = new ArrayList();  
    
    
    
    
    
    
    public ArrayList<String> getListaSubprocesso() throws SQLException {
        
        
      ConnectSubProcesso con = new ConnectSubProcesso();
       mapaSubProcesso = con.carregarSubProcesso(control.getMapaProcesso());
      
            

      for(SubProcesso resultados: mapaSubProcesso){
          
          ListaSubprocesso.add(resultados.getSubprocesso());
      }
        
        return ListaSubprocesso;
    }

    public void setListaSubprocesso(ArrayList<String> ListaSubprocesso) {
        this.ListaSubprocesso = ListaSubprocesso;
    }
     
    
    public ArrayList<String> getListaMapaProcesso() throws SQLException {
        
         
      ConnectProcesso con = new ConnectProcesso();
      mapaProcesso = con.carregarProcesso();
      
      List<String> resultados = new ArrayList<String>();
      
            for(Processo resultado: mapaProcesso){
           ListaMapaProcesso.add(resultado.getMapa()+" -"+resultado.getProcesso());
         
      } 
                           
        return ListaMapaProcesso;
    }

    public void setListaMapaProcesso(ArrayList<String> ListaMapaProcesso) {
        this.ListaMapaProcesso = ListaMapaProcesso;
    }
    
    public String getAdicionarNumero() {
       
        return adicionarNumero;
    }

    public void setAdicionarNumero(String adicionarNumero) {
     
        this.adicionarNumero = adicionarNumero;
    }
    
    public ListaFunc getSelectedFun() {
        return selectedFun;
    }

    public void setSelectedFun(ListaFunc selectedFun) {
        this.selectedFun = selectedFun;
    }

    

   
   
    
  

    public List<Boolean> getHeaderChecks() {
        return headerChecks;
    }

    public void setHeaderChecks(List<Boolean> headerChecks) {
        this.headerChecks = headerChecks;
    }
    private List<Boolean> headerChecks = new ArrayList<>();
   

  
    public List<NumeroTreinamento> getNumeroTreinamento() {
        return numeroTreinamento;
    }

    public void setNumeroTreinamento(List<NumeroTreinamento> numeroTreinamento) {
        this.numeroTreinamento = numeroTreinamento;
    }
    
    public List<ListaFunc> getListaFunc2() {
        return listaFunc2;
    }

    public void setListaFunc2(List<ListaFunc> listaFunc2) {
        this.listaFunc2 = listaFunc2;
    }
    private String Texto1Buscar;

    public String getTexto1Buscar() {
        return Texto1Buscar;
    }

    public void setTexto1Buscar(String Texto1Buscar) {
        this.Texto1Buscar = Texto1Buscar;
    }
    public List<ListaFunc> getListaFunc() {
        return listaFunc;
    }

    public void setListaFunc(List<ListaFunc> listaFunc) {
        this.listaFunc = listaFunc;
    }

   

  

   
    public List<Funcionario> getListaFuncionario() throws SQLException {
        ConnectFuncionario con = new ConnectFuncionario();
        listaFuncionario = con.obterFuncionario("");
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
    public List<Alternativa> getObt() {
        return Collections.unmodifiableList(obt);
    }

   
    public void setObt(List<Alternativa> obt) {
        this.obt = obt;
    }

  
    
    public List<Treinamento> getTreinamento() {
        return Collections.unmodifiableList(treinamento);
    }

    public void setTreinamento(List<Treinamento> treinamento) {
        this.treinamento = treinamento;
    }
    
    public List<Responsavel> getGestor() {
        return gestor;
    }

    public void setGestor(List<Responsavel> gestor) {
        this.gestor = gestor;
    }

    public List<Departamento> getDepartamento() {
        return departamento;
    }

    public void setDepartamento(List<Departamento> departamento) {
        this.departamento = departamento;
    }

    public List<Modelo> getModelo() {
        return modelo;
    }

    public void setModelo(List<Modelo> modelo) {
        this.modelo = modelo;
    }

    public List<NumeroDocumento> getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(List<NumeroDocumento> numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public List<Tipo> getTipo() {
        return tipo;
    }

    public void setTipo(List<Tipo> tipo) {
        this.tipo = tipo;
    }

    public List<TipoTreinamento> getTipoTreinamento() {
        return tipoTreinamento;
    }

    public void setTipoTreinamento(List<TipoTreinamento> tipoTreinamento) {
        this.tipoTreinamento = tipoTreinamento;
    }

    public List<Unidade> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<Unidade> unidade) {
        this.unidade = unidade;
    }
    private List<NumeroDocumento> numeroDocumento= new ArrayList<>();
    private List<Status> status= new ArrayList<>();
    private List<Tipo> tipo= new ArrayList<>();
    private List<TipoTreinamento> tipoTreinamento= new ArrayList<>();
    private List<Unidade> unidade= new ArrayList<>();
    
    public List<Processo> getMapaProcesso() {
        return Collections.unmodifiableList(mapaProcesso);
    }

    public void setMapaProcesso(List<Processo> mapaProcesso) {
        this.mapaProcesso = mapaProcesso;
    }

    public List<SubProcesso> getMapaSubProcesso() {
        return Collections.unmodifiableList(mapaSubProcesso);
    }

    public void setMapaSubProcesso(List<SubProcesso> mapaSubProcesso) {
        this.mapaSubProcesso = mapaSubProcesso;
    }
    private List<SubProcesso> mapaSubProcesso= new ArrayList<>();
    
    private ControleCurso control = new ControleCurso();
   
    public List<ControleCurso> getControles() throws SQLException {
         ConnectControle con = new ConnectControle();
         controles = con.carregarControle();
        
        return Collections.unmodifiableList(controles);
    }

    public void setControles(List<ControleCurso> controles) {
        this.controles = controles;
    }

    public ControleCurso getControl() {
        return control;
    }

    public void setControl(ControleCurso control) {
        this.control = control;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }
    private String controle;
    private static final long serialVersionUID = 1L;
    
    
   
 public String cadastraControle() throws SQLException {

               PesisteDadosJPA con = new PesisteDadosJPA();


                if (con.Insert(control)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo cadastrado com sucesso!", "Processo cadastrado com sucesso!"));
                     control = new ControleCurso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
           //     con.closeConnection();

               

          return "";
     }    
  public String alterarControle() throws SQLException {

                PesisteDadosJPA con = new PesisteDadosJPA();


                if (con.update(control)) {
                     FacesContext.getCurrentInstance().addMessage(
                      "messages", new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Dados da avaliação alterados com sucesso!", "Dados da avaliação alterados com sucesso!"));
                       control = new ControleCurso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
            //    con.closeConnection();

               

          return "";
     } 
  
   public String alterarControlePessoa() throws SQLException {

                PesisteDadosJPA con = new PesisteDadosJPA();


                if (con.update(control)) {
                     FacesContext.getCurrentInstance().addMessage(
                      "messages", new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Dados alterado com sucesso!", "Dados alterado com sucesso!"));
                       control = new ControleCurso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
             //   con.closeConnection();

               

          return "";
     } 
 public String excluirControleFunc() throws SQLException {

                ConnectControle con = new ConnectControle();
                


                if (con.remover(control)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Excluido com sucesso!", "Excluido com sucesso!"));
                     control = new ControleCurso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 
  public String excluirControle() throws SQLException {

                ConnectControle con = new ConnectControle();
                


                if (con.removerAvaliacao(control)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Excluido com sucesso!", "Excluido com sucesso!"));
                     control = new ControleCurso();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 
 
  public List<String> completarTexto(String consulta) throws SQLException{
      
      ConnectControle con = new ConnectControle();
      numeroTreinamento = con.carregarTreinamento();
      
      List<String> resultado = new ArrayList<>();

      for(NumeroTreinamento resultados: numeroTreinamento){
          if(resultados.getNumeroTreinamento().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getNumeroTreinamento());
          }
      }
        
        
      return resultado;
  }
   
  public List<String> completarMapa(String consulta) throws SQLException{
      
      ConnectProcesso con = new ConnectProcesso();
      mapaProcesso = con.carregarProcesso();
      
      List<String> resultados = new ArrayList<String>();
      
            for(Processo resultado: mapaProcesso){
          if(resultado.getMapa().toLowerCase().startsWith(consulta.toLowerCase())){
              resultados.add(resultado.getMapa()+" -"+resultado.getProcesso());
          }
      } 
        
      return resultados;
  }
  
   
    public List<String> completarSubMapa(String consulta) throws SQLException{
      
       ConnectSubProcesso con = new ConnectSubProcesso();
       mapaSubProcesso = con.carregarSubProcesso(consulta);
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(SubProcesso resultados: mapaSubProcesso){
          if(resultados.getSubprocesso().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getSubprocesso());
          }
      }
        
        
      return resultado;
  }
   
   
   
   public List<String> completarGestor(String consulta) throws SQLException{
      
      ConnectResponsavel con = new ConnectResponsavel();
      gestor = con.carregarResponsavel();
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(Responsavel resultados:gestor){
          if(resultados.getNome().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getNome());
          }
      }
        
        
      return resultado;
  }
   
     
   
   public List<String> completarDepartamento(String consulta) throws SQLException{
      
     ConnectDepartamento con = new ConnectDepartamento();
      departamento = con.carregarDepartamento();
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(Departamento resultados:departamento){
          if(resultados.getDepartamento().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getDepartamento());
          }
      }
        
        
      return resultado;
  } 
   
   
  
   
  public List<String> completarModelo(String consulta) throws SQLException{
      
     ConnectModelo con = new ConnectModelo();
      modelo = con.carregarModelo();
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(Modelo resultados:modelo){
//          if(resultados.getTipo().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getTipo());
//          }
      }
        
        
      return resultado;
  }  
   
   
     
   public List<String> completarNumeroDocumento(String consulta) throws SQLException{
      
     ConnectNumeroDocumento con = new ConnectNumeroDocumento();
      numeroDocumento = con.carregarNumeroDocumento();
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(NumeroDocumento resultados:numeroDocumento){
          if(resultados.getDocumento().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getDocumento()+" "+resultados.getDescricao()+" "+resultados.getRevisao());
          }
      }
        
        
      return resultado;
  }  
   
   
   public List<String> completarStatus(String consulta) throws SQLException{
      
     ConnectStatus con = new ConnectStatus();
      status = con.carregarStatus();
      
      List<String> resultado = new ArrayList<String>();
      
        
        for(Status resultados:status){
//          if(resultados.getTipo().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getStatus());
//          }
      }
        
      return resultado;
  }  
  
   
   
  
  public List<String> completarTipoTreinamento(String consulta) throws SQLException{
      
    ConnectTipoTreinamento con = new ConnectTipoTreinamento();
      tipoTreinamento = con.carregarTipoTreinamento();
      
      List<String> resultado = new ArrayList<String>();
      

        
      for(TipoTreinamento resultados:tipoTreinamento){
//          if(resultados.getTipo().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getTipoTreinamento());
//          }
      }
        
      return resultado;
  }  
  
  
      
   
    public List<String> completarTipo(String consulta) throws SQLException{
      
    ConnectTipo con = new ConnectTipo();
      tipo = con.carregarTipo();
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(Tipo resultados:tipo){
          if(resultados.getTipo().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getTipo());
          }
      }
        
        
      return resultado;
  }  
   
       
   public List<String> completarUnidade(String consulta) throws SQLException{
      
    ConnectUnidade con = new ConnectUnidade();
      unidade = con.carregarUnidade();
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(Unidade resultados:unidade){
          if(resultados.getUnidade().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getUnidade());
          }
      }
        
        
      return resultado;
  }    
    
      
   public List<String> completarTreinamento(String consulta) throws SQLException{
      
    ConnectTreinamento con = new ConnectTreinamento();
      treinamento = con.carregarTreinamento();
      
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      for(Treinamento resultados:treinamento){
          if(resultados.getNome().toLowerCase().startsWith(consulta.toLowerCase())){
              resultado.add(resultados.getNome());
          }
      }
        
        
      return resultado;
  }    
  
   
   public List<String> completarObt(String query) throws SQLException{
      
    String queryLowerCase = query.toLowerCase();   
    ConnectAlternativa con = new ConnectAlternativa();
      obt = con.carregarAlternativa();
      
      List<String> resultado = new ArrayList<String>();
      
       
       for(Alternativa resultados:obt){
         
             resultado.add(resultados.getCod_obt());
          
      }
        
        
      return resultado.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
  }   
   
   public List<String> completarNumeroTreinamento(String consulta) throws SQLException{
       
      ConnectConsultaControle con = new ConnectConsultaControle();
      numeroTreinamento = con.carregarTreinamento();
      
      List<String> resultados = new ArrayList<String>();
      
            for(NumeroTreinamento resultado: numeroTreinamento){
           if(resultado.getNumeroTreinamento().toLowerCase().startsWith(consulta.toLowerCase())){
              resultados.add(resultado.getNumeroTreinamento());
          }
      } 
        
      return resultados;
  } 
   public List<String> Carregardesc(String consulta) throws SQLException{
      
    ConnectAlternativa con = new ConnectAlternativa();
      obt = con.carregarAlternativa();
      
      List<String> resultado = new ArrayList<String>();
      

       
       for(Alternativa resultados:obt){
//          if(resultados.getTipo().toLowerCase().startsWith(consulta.toLowerCase())){
             resultado.add(resultados.getCod_obt());
//          }
      }
        
        
      return resultado;
  }   
   public void ordenarNome() throws SQLException{
    
       
       
       System.out.println("BuscardescricaoCurso");
        
        ConnectAlternativa con = new ConnectAlternativa();
        con.buscarDescricao(this.control.getNomeTrainamento());
        control.setDesc_treinamento(con.getDescricao());
        control.setRevisao(con.getRevisao());
   }

   
 
   public String salvar() throws IOException, SQLException{
     GravarCurso grava = new GravarCurso();
     grava.buscar();
       
    ConnectLista con = new ConnectLista();
    
    listaFunc = con.listFunc();
//    System.out.println("listaFunc"+ con.listFunc().get(0).getNome());
     String RegistroTreinamento = grava.getRegistroTreinamento();

     for(int i=0;i < listaFunc.size();i++){
           
//       
                    String REGISTRO =  listaFunc.get(i).getRegistro();
                    String NOME = listaFunc.get(i).getNome();
                    String DATAINCLUSAO = control.getData_inclusao();
                    String HORAINCLUSAO = "";
                    String DATACURSO = control.getData_curso();
                    String HORACURSO = "";
                    String TEMPO = control.getTempo();
                    String DATAVALIDADE = control.getDataValidade();
                    String NOMETREINAMENTO = control.getNomeTrainamento();
                    String SUBMODELO = "";
                    String CARGO = "";
                    String DEPARTAMENTO = listaFunc.get(i).getDepartamento();
                    String MAPAPROCESSO = control.getMapaProcesso();
                    String MAPASUBPROCESSO = control.getSubProcesso();
                    String UNIDADE = listaFunc.get(i).getUnidade();
                    String STATUS = "Programado";
                    String GESTOR = control.getGestor();
                    String TREINAMETO = control.getTreinamento();
                    String TIPOTREINAMETO = control.getTipoTreinamento();
                    String MODELO = control.getTipo();
                    
                    String DESCRICAOTREINAMENTO = control.getDesc_treinamento();
                    String TEMA = control.getTema();
                    String OBSERVACAO = control.getObs();
                    
                    String NUMERODOCUMENTO = adicionarNumero;
                    String CUSTOTREINAMENTO = control.getCustoTreinamento();
                    
                    
                    String FORNECEDOR = control.getFornecedor();
                    
                    
                    
                    String TIPO = control.getTipo();
                    String AVALIACAOREACAO = control.getAvaliacaoReacao();
                    String CRITERIO = control.getCriterio_kpi_avalicao_eficacia();
                    String AVALIACAOEFICACIA = control.getAvalicaoEficacia();
                    String DATAAVALIACAOEFICACIA = control.getDataAvaliaEficacia();
                    String CERTIFICADO = control.getCertificado();

                      if(UNIDADE.equals(Permissao.getUnidade())){

                 
         grava.GravarControle2(grava.getRandomPass(10),  
                              RegistroTreinamento,
                              REGISTRO,
                              NOME,
                              DATAINCLUSAO, 
                              HORAINCLUSAO,
                              DATACURSO,
                              HORACURSO,
                              TEMPO,
                              DATAVALIDADE,
                              NOMETREINAMENTO,
                              SUBMODELO,
                              CARGO,
                              DEPARTAMENTO,
                              MAPAPROCESSO,
                              MAPASUBPROCESSO,
                              UNIDADE,
                              STATUS, 
                              GESTOR,
                              TREINAMETO,
                              TIPOTREINAMETO,
                              DESCRICAOTREINAMENTO,
                              TEMA,
                              OBSERVACAO,
                              TIPO,
                              CUSTOTREINAMENTO,
                              FORNECEDOR,
                              TEMPO,
                              AVALIACAOREACAO,
                              CRITERIO,
                              AVALIACAOEFICACIA,
                              DATAAVALIACAOEFICACIA,
                              CERTIFICADO,
                              NUMERODOCUMENTO);
         
         }
     }
    //   salvarObt(RegistroTreinamento);
//    AlteraPessoa alt = new AlteraPessoa();
     
//    selectControles.stream().forEach((room) -> {
//          System.out.println(room.getNome());
//               alt.AlteracaoGeral("ControleCurso", "status", control.getStatus(),"RegistroTreinamento", room.getRegistroTreinamento(),"Registro", room.getRegistro());      
//        });
        FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Gravado com sucesso!", "Lista carregada com sucesso!"));
        return "/app/InclusaoControleAvaliacao?faces-redirect=true";
}  
 public void ordenarLista() throws SQLException{
       ConnectLista con = new ConnectLista();
       listaFunc = con.obterLista("lista",Texto1Buscar);
       
       listaFunc2 = listaFunc;
       System.out.println("listaFunc"+ this.listaFunc2.size());
   } 

    public void salvar2() throws IOException, SQLException{
//     GravarCurso grava = new GravarCurso();
//     grava.buscar();
//       
//    ConnectLista con = new ConnectLista();
//    
//    listaFunc = con.listFunc();
////    System.out.println("listaFunc"+ con.listFunc().get(0).getNome());
//     String RegistroTreinamento = grava.getRegistroTreinamento();
//
//     for(int i=0;i < listaFunc.size();i++){
//           
////       
//                    String REGISTRO =  listaFunc.get(i).getRegistro();
//                    String NOME = listaFunc.get(i).getNome();
//                    String DEPARTAMENTO = listaFunc.get(i).getDepartamento();
//                    String UNIDADE = listaFunc.get(i).getUnidade();
//                    String MAPAPROCESSO = control.getMapaProcesso();
//                    String MAPASUBPROCESSO = control.getSubProcesso();
//                    String GESTOR = control.getGestor();
//                    String TREINAMETO = control.getTreinamento();
//                    String TIPOTREINAMETO = control.getTipoTreinamento();
//                    String NOMETREINAMENTO = control.getNomeTrainamento();
//                    String DESCRICAOTREINAMENTO = control.getDesc_treinamento();
//                    String TEMA = control.getTema();
//                    String OBSERVACAO = control.getObs();
//                    String MODELO = control.getTipo();
//                    String NUMERODOCUMENTO = control.getNumeroDocumento();
//                    String CUSTOTREINAMENTO = control.getCustoTreinamento();
//                    String TEMPO = control.getTempo();
//                    String STATUS = "Programado";
//                    String FORNECEDOR = control.getFornecedor();
//                    String DATAINCLUSAO = control.getData_inclusao();
//                    String DATACURSO = control.getData_curso();
//                    String DATAVALIDADE = control.getDataValidade();
//                    String TIPO = control.getTipo();
//                    String AVALIACAOREACAO = control.getAvaliacaoReacao();
//                    String CRITERIO = control.getCriterio_kpi_avalicao_eficacia();
//                    String AVALIACAOEFICACIA = control.getAvalicaoEficacia();
//                    String DATAAVALIACAOEFICACIA = control.getDataAvaliaEficacia();
//                    String CERTIFICADO = control.getCertificado();
//
//                     
//
//                 
//         grava.GravarControle2(grava.getRandomPass(10),  
//                              RegistroTreinamento,
//                              REGISTRO,
//                              NOME,
//                              DATAINCLUSAO, 
//                              "",
//                              DATACURSO,
//                              "",
//                              TEMPO,
//                              DATAVALIDADE,
//                              MODELO,
//                              "",
//                              "",
//                              DEPARTAMENTO,
//                              MAPAPROCESSO,
//                              MAPASUBPROCESSO,
//                              UNIDADE,
//                              STATUS, 
//                              GESTOR,
//                              TREINAMETO,
//                              TIPOTREINAMETO,
//                              DESCRICAOTREINAMENTO,
//                              TEMA,
//                              OBSERVACAO,
//                              TIPO,
//                              CUSTOTREINAMENTO,
//                              FORNECEDOR,
//                              TEMPO,
//                              AVALIACAOREACAO,
//                              CRITERIO,
//                              AVALIACAOEFICACIA,
//                              DATAAVALIACAOEFICACIA,
//                              CERTIFICADO,
//                              NUMERODOCUMENTO);
//         
//         }
    AlteraPessoa alt = new AlteraPessoa();
     
              alt.AlteracaoGeral("ControleCurso", "status", control.getStatus(),"RegistroTreinamento", control.getRegistroTreinamento(),"Registro", control.getRegistro());      
      
        FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Lista carregada com sucesso!", "Lista carregada com sucesso!"));
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

public void salvarObt(String RegistroTreinamento) throws IOException, SQLException{
     GravarCurso grava = new GravarCurso();
     grava.buscar();
       
    ConnectLista con = new ConnectLista();
    
    listaFunc = con.listFunc();


     for(int i=0;i < listaFunc.size();i++){
           
//       
                    String registro =  listaFunc.get(i).getRegistro();
                    String nome = listaFunc.get(i).getNome();
                    String dep = listaFunc.get(i).getDepartamento();
                    String uni = listaFunc.get(i).getUnidade();
                    String mapaprocesso = control.getMapaProcesso();
                    String mapasubprocesso = control.getSubProcesso();
                    String gest = control.getGestor();
                    String trein = control.getTreinamento();
                    String tipotreinamento = control.getTipoTreinamento();
                    String nometreinamento = control.getNomeTrainamento();
                    String descricaoTreinamento = control.getDesc_treinamento();
                    String tema = control.getTema();
                    String observacao = control.getObs();
                    String mod = control.getTipo();
                    String numeroDoc = adicionarNumero;
                    String custoTrein = control.getCustoTreinamento();
                    String tempo = control.getTempo();
                    String stat = "Programado";
                    String fornecedor = control.getFornecedor();
                    String dataInclusao = control.getData_inclusao();
                    String dataCurso = control.getData_curso();
                    String DataValidade = control.getDataValidade();
                    String tip = control.getTipo();
                    String avaliacao = control.getAvaliacaoReacao();
                    String criterio = control.getCriterio_kpi_avalicao_eficacia();
                    String avaliacaoEficacia = control.getAvalicaoEficacia();
                    String dataAvEficacia = control.getDataAvaliaEficacia();
                    String certificado = control.getCertificado();
                    String revisao = control.getRevisao();
                     

                 
            
          if(uni.equals(Permissao.getUnidade())){
                    
                    grava.Gravar(nometreinamento,  
                              RegistroTreinamento,
                              registro,
                              nome,
                              dep,
                              tip,
                              grava.getRandomPass(10),
                              nome,
                              gest,
                              revisao,
                              uni,
                              tempo,
                              "Programado");
         
         }
     }   
  }
 public String salvarAvaliacao() throws IOException, SQLException{
     GravarCurso grava = new GravarCurso();
     grava.buscar();
       
        ConnectLista con = new ConnectLista();
       listaFunc = con.obterLista("lista",Texto1Buscar);
////    System.out.println("listaFunc"+ con.listFunc().get(0).getNome());
     String RegistroTreinamento = grava.getRegistroTreinamento();

     for(int i=0;i < listaFunc.size();i++){


                    String registro =  listaFunc.get(i).getRegistro();
                    String nome = listaFunc.get(i).getNome();
                    String dep = listaFunc.get(i).getDepartamento();
                    String uni = listaFunc.get(i).getUnidade();
                    String mapaprocesso = control.getMapaProcesso();
                    String mapasubprocesso = control.getSubProcesso();
                    String gest = control.getGestor();
                    String trein = control.getTreinamento();
                    String tipotreinamento = control.getTipoTreinamento();
                    String nometreinamento = control.getNomeTrainamento();
                    String descricaoTreinamento = control.getDesc_treinamento();
                    String tema = control.getTema();
                    String observacao = control.getObs();
                    String mod = control.getTipo();
                    String numeroDoc = adicionarNumero;
                    String custoTrein = control.getCustoTreinamento();
                    String tempo = control.getTempo();
                    String stat = "Programado";
                    String fornecedor = control.getFornecedor();
                    String dataInclusao = control.getData_inclusao();
                    String dataCurso = control.getData_curso();
                    String DataValidade = control.getDataValidade();
                    String tip = control.getTipo();
                    String avaliacao = control.getAvaliacaoReacao();
                    String criterio = control.getCriterio_kpi_avalicao_eficacia();
                    String avaliacaoEficacia = control.getAvalicaoEficacia();
                    String dataAvEficacia = control.getDataAvaliaEficacia();
                    String certificado = control.getCertificado();
                    String revisao = control.getRevisao();
                    String horaInclusao = "";  
                    String codigoObt = grava.getRandomPass(10);
                    String horaCurso = "";
                    String subModelo = "";
                    String cargo = "";
       
                    if(uni.equals(Permissao.getUnidade())){
                    grava.GravarControle2(codigoObt,  
                              RegistroTreinamento,
                              registro,
                              nome,
                              dataInclusao, 
                              horaInclusao,
                              dataCurso,
                              horaCurso,
                              tempo,
                              DataValidade,
                              nometreinamento,
                              subModelo,
                              cargo,
                              dep,
                              mapaprocesso,
                              mapasubprocesso,
                              uni,
                              stat, 
                              gest,
                              trein,
                              tipotreinamento,
                              descricaoTreinamento,
                              tema,
                              observacao,
                              tip,
                              custoTrein,
                              fornecedor,
                              tempo,
                              avaliacao,
                              criterio,
                              avaliacaoEficacia,
                              dataAvEficacia,
                              certificado,
                              numeroDoc);
         
                      grava.Gravar(nometreinamento,  
                              RegistroTreinamento,
                              registro,
                              nome,
                              dep,
                              tip,
                              codigoObt,
                              nome,
                              trein,
                              revisao,
                              uni,
                              tempo,
                              "Programado");
         
         }
     }
  
        FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Gravado com sucesso!", "Lista carregada com sucesso!"));
        return "/app/InclusaoControleAvaliacao?faces-redirect=true";
}  
  public void deleteSelectedFunc() throws SQLException {
             
//        this.ListaFuncionarios.remove(this.selectedFun);
//        this.selectedFun = null;
    //     System.out.println(this.selectedFun.getCodigo());
       
         ConnectLista lista = new ConnectLista();
         lista.remover(selectedFun);
              
       
         FacesContext.getCurrentInstance().addMessage("MessageLista", new FacesMessage  (FacesMessage.SEVERITY_WARN,"Be Warned!", "You did something wrong!"));
         this.refresh();
    }
   public void deleteLista() throws SQLException {
             
//        this.ListaFuncionarios.remove(this.selectedFun);
//        this.selectedFun = null;
    //     System.out.println(this.selectedFun.getCodigo());
       
         ConnectLista lista = new ConnectLista();
         lista.removerTudo(selectedFun);
              
       
         FacesContext.getCurrentInstance().addMessage("MessageLista", new FacesMessage  (FacesMessage.SEVERITY_WARN,"Be Warned!", "You did something wrong!"));
         this.refresh();
    }
   public void adicionarNumeroDoc(){
     //   adicionarNumero = "teste";
       
        if(adicionarNumero.isEmpty()){
            adicionarNumero = control.getNumeroDocumento();
        }else{
            adicionarNumero = adicionarNumero +", "+control.getNumeroDocumento();
        }
   }
   
   public void imprimeLista() throws SQLException, IOException{
//       ConnectControle con = new ConnectControle();
//       controles = con.carregarControle();
//       System.out.println(controles.get(0).getCodigoObt());
//       HashMap parametros = new HashMap();
//       UtilRelatorios.imprimeRelatorio("ListaPresenca", parametros, controles);
 FacesContext.getCurrentInstance().getExternalContext().redirect("Avaliacao.jsf");
//         Relatorio relatorio = new Relatorio();
//         relatorio.getRelatorio(controles);
   }
   
    public String redireciona() {
         return "/app/obt?faces-redirect=true";
    }
}   