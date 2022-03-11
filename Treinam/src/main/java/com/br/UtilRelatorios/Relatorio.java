/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UtilRelatorios;

import com.br.ControleTreinamento.ControleCurso;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author V103760
 */
public class Relatorio {
    
    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream bacs;
    private InputStream stream;
    
    public Relatorio(){
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
            }
   
     public void getRelatorio(List<ControleCurso> lista){
         
         stream = this.getClass().getResourceAsStream("/report/ListaPresenca.jasper");
         Map<String, Object> params = new HashMap<String, Object>();
         bacs = new ByteArrayOutputStream();
         
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            
            JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(lista));
            JasperExportManager.exportReportToPdfStream(print, bacs);
            
            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(bacs.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
            response.getOutputStream().write(bacs.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            context.responseComplete();
            
        } catch (JRException | IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
