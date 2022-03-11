package com.br.ControleTreinamento;

import com.br.Departamento.Departamento;
import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.PDF.Pdf;
import com.br.Utilitarios.UtilRelatorios;
import com.br.model.database.ConnectControle;
import com.br.model.database.ConnectPdf;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author v103760
 */

@Named(value="ConsultaEspecificaControleBean")
@SessionScoped
public class ConsultaEspecificaControleBean implements Serializable {

     private static final long serialVersionUID = 1L;
     

      

   private String teste;

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public List<ControleCurso> getControles() throws SQLException {
       
        
        return controles;
    }

    public void setControles(List<ControleCurso> controles) {
        this.controles = controles;
    }
     private  List<ControleCurso> controles;
     private  List<ControleCurso> controles2;

    public List<ControleCurso> getControles2() throws SQLException {
        ConnectControle con = new ConnectControle();
        controles2 = con.carregarControle();
        return controles2;
    }

    public void setControles2(List<ControleCurso> controles2) {
        this.controles2 = controles2;
    }
     private Pdf selectPdf; 

    public Pdf getSelectPdf() {
        return selectPdf;
    }

    public void setSelectPdf(Pdf selectPdf) {
        this.selectPdf = selectPdf;
    }
    private List<Pdf> ima= new ArrayList<>();
        
    public List<Pdf> getIma() throws SQLException {
        ConnectPdf pd = new ConnectPdf();
        ima = pd.carregarPdf(Texto1Buscar);
        return ima;
    }

    public void setIma(List<Pdf> ima) {
        this.ima = ima;
    }
  

    public List<ControleCurso> getFilteredControle() {
        return filteredControle;
    }

    public void setFilteredControle(List<ControleCurso> filteredControle) {
        this.filteredControle = filteredControle;
    }

   
      private List<ControleCurso> filteredControle;
      
     
     @SuppressWarnings("FieldMayBeFinal")
    private String Texto1Buscar;
    private String Texto2Buscar;
    private static String registroTreinamento;

    public static String getRegistroTreinamento() {
        return registroTreinamento;
    }

    public static void setRegistroTreinamento(String registroTreinamento) {
        ConsultaEspecificaControleBean.registroTreinamento = registroTreinamento;
    }

    public String getTexto1Buscar() {
        return Texto1Buscar;
    }

    public void setTexto1Buscar(String Texto1Buscar) {
   //     System.out.println("Numero Treinamento"+Texto1Buscar);
        NomeTreinamento.setNumeroTreinamento(Texto1Buscar);
        this.Texto1Buscar = Texto1Buscar;
    }

    public String getTexto2Buscar() {
        return Texto2Buscar;
    }

    public void setTexto2Buscar(String Texto2Buscar) {
        this.Texto2Buscar = Texto2Buscar;
    }

    public ControleCurso getSelectControle() {
        return selectControle;
    }

    
    public List<ControleCurso> getListaControle() throws SQLException {
       
        return Collections.unmodifiableList(listaControle);
    }

    public void setListaControle(List<ControleCurso> listaControle) {
        this.listaControle = listaControle;
    }
    private ControleCurso selectControle;
    private List<ControleCurso> listaControle=new ArrayList<>();
    
    public ConsultaEspecificaControleBean() {
    }
    
   
    
   public void ordenarSubProcesso() throws SQLException{
       ConnectControle con = new ConnectControle();
       listaControle = con.obterControleBusca("Mapa",Texto2Buscar);
   }
   
   public void onRowSelect(SelectEvent event){
       FacesMessage msg = new FacesMessage("Departamento selecionado", ((ControleCurso) event.getObject()).getNome());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
       
   }
   public void onRowUnselect(UnselectEvent event){
       FacesMessage msg = new FacesMessage("Funcionario selecionado", ((Departamento) event.getObject()).getUnidade());
       FacesContext.getCurrentInstance().addMessage("adadadad", msg);
   }
 
   public void carregarTudo() throws SQLException{
       ConnectControle con = new ConnectControle();
       controles = con.carregarControle();
   }
   public void buscarNumeroTreinamento() throws SQLException{
//       registroTreinamento = Texto1Buscar;
       selectPdf = new Pdf();
       ConnectControle con = new ConnectControle();
       controles = con.obterControleBusca("RegistroTreinamento",Texto1Buscar);
       
       
   }
public void testeImagem(){
  //  System.out.println("Teste");
}
public void imprimeLista() throws SQLException{
//       ConnectControle con = new ConnectControle();
//       controles = con.carregarControle();
       System.out.println(controles.get(0).getCodigoObt());
       HashMap parametros = new HashMap();
       UtilRelatorios.imprimeRelatorio("ListaPresenca", parametros, controles);

//         Relatorio relatorio = new Relatorio();
//         relatorio.getRelatorio(controles);
   }

 public void excluirAnexo(){
     PesisteDadosJPA jpa = new PesisteDadosJPA();
     
     System.out.println("Codigo "+selectPdf.getCodigo());
     
     if(jpa.deleteAnexo(selectPdf.getCodigo())==true){
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Arquivo excluido com sucesso!!"));
     }else{
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Erro ao excluir")); 
     }
     
 }
}
