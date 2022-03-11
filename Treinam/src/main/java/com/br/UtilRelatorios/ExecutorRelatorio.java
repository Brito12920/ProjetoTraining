package com.br.UtilRelatorios;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.hibernate.jdbc.Work;



/**
 *
 * @author v103760
 */
public class ExecutorRelatorio implements Work {

    private final String caminhoRelatorio;

    public ExecutorRelatorio(String caminhoRelatorio, HttpServletResponse response, Map<String, Object> parametro, String nomeArquivoSaida) {
        this.caminhoRelatorio = caminhoRelatorio;
        this.response = response;
        this.parametro = parametro;
        this.nomeArquivoSaida = nomeArquivoSaida;
    }
    private final HttpServletResponse response;
    private final Map<String, Object> parametro;
    private final String nomeArquivoSaida;
    
    @Override
    public void execute(Connection cnctn) throws SQLException {
     
      
        try {
            InputStream relatorioStream = this.getClass().getResourceAsStream(this.caminhoRelatorio);
            JasperPrint print = JasperFillManager.fillReport(relatorioStream, this.parametro, cnctn);
            
          
            JRExporter exportador = new JRPdfExporter();
            exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            exportador.setParameter(JRExporterParameter.JASPER_PRINT, print);
            
            response.setContentType("application/pdf");
            exportador.exportReport();
            
        } catch (Exception ex) {
            Logger.getLogger(ExecutorRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public void imprimir() {
     
   }   
    }
    

