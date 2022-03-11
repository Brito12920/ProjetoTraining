package com.br.Relatorios;

import com.br.ControleTreinamento.ControleCurso;
import com.br.UtilRelatorios.ExecutorRelatorio;
import com.br.model.database.ConnectControle;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.hibernate.Session;

/**
 *
 * @author v103760
 */
@ManagedBean (name="RelatorioMB")
@SessionScoped
public class Relatoriobean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ControleCurso> controles= new ArrayList<>();
    
    private FacesContext facesContext;
    
    private HttpServletResponse response;
    
    private EntityManager manager;
    
    private JasperPrint jasperPrint;
    public List<ControleCurso> getControles() throws SQLException {
       ConnectControle con = new ConnectControle();
         controles = con.carregarControle();
        
        return Collections.unmodifiableList(controles);
    }

    public void setControles(List<ControleCurso> controles) {
        this.controles = controles;
    }
    private String registroTreinamento;

    public String getRegistroTreinamento() {
        return registroTreinamento;
    }

    public void setRegistroTreinamento(String registroTreinamento) {
        this.registroTreinamento = registroTreinamento;
    }
      
    
    public void emitir() throws JRException, SQLException{
  
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("", this);
        ExecutorRelatorio executor = new ExecutorRelatorio("C:\\PrimeFaces\\LoginTraining\\web\\ListaPresenca.jasper",
        this.response, parametros ,"Lista de Presença.pdf"    
        );
      
        Session session = manager.unwrap(Session.class);
        session.doWork(executor);
        facesContext.responseComplete();
       
    }
   
    public void relatorio() throws Exception{
        
    }
      
    public void teste() throws JRException{
		//Obtem o valor atual do sistema
		long inicioContagem = System.currentTimeMillis();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tituloSeminario", "Seminário sobre Jasper Reports");
		
		//Compilacao no formato jasper para o jrprint
		JasperFillManager.fillReportToFile("C:\\PrimeFaces\\LoginTraining\\web\\ListaPresenca.jasper", parameters, new JREmptyDataSource(1));
		System.err.println("Tempo de compilacao jasper -> jrprint: " + (System.currentTimeMillis() - inicioContagem));
		
		//Reinicia o contador
		inicioContagem = System.currentTimeMillis();
		
		//Geracao do PDF
		JasperExportManager.exportReportToPdfFile("reports/alunosInscritosSeminario.jrprint");
		System.err.println("Tempo de geracao do PDF: " + (System.currentTimeMillis() - inicioContagem));
	}
}
