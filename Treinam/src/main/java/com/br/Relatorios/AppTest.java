package com.br.Relatorios;

/**
 *
 * @author v103760
 */

 
import java.util.HashMap;
import java.util.Map;
 
/**
 * Unit test for simple App.
 */
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
 
/**
 * Unit test for simple App.
 */
public class AppTest{
 
	
	public void teste() throws JRException{
		//Obtem o valor atual do sistema
		long inicioContagem = System.currentTimeMillis();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tituloSeminario", "Seminário sobre Jasper Reports");
		
		//Compilacao no formato jasper para o jrprint
		JasperFillManager.fillReportToFile("Relatorios/listaPresenca.jasper", parameters, new JREmptyDataSource(1));
		System.err.println("Tempo de compilacao jasper -> jrprint: " + (System.currentTimeMillis() - inicioContagem));
		
		//Reinicia o contador
		inicioContagem = System.currentTimeMillis();
		
		//Geracao do PDF
		JasperExportManager.exportReportToPdfFile("reports/alunosInscritosSeminario.jrprint");
		System.err.println("Tempo de geracao do PDF: " + (System.currentTimeMillis() - inicioContagem));
	}
}