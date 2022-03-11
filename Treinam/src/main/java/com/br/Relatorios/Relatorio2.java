package com.br.Relatorios;

/**
 *
 * @author v103760
 */

import com.br.ControleTreinamento.ControleCurso;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Rafael Nobre
 */
public class Relatorio2 {

    private final HttpServletResponse response;
    private final FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;
    private Connection con;
    private final String host = "VHDB001\\SQLEXPRESS";
    private final String usuario = "ctptgmon";
    private final String senha =  "Paulo2022";
    private final String database = "CT_OBT";
    private final String portNumber = "1433";

    public Relatorio2() {
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }

    public void getRelatotio(List<ControleCurso> lista) {
        stream = this.getClass().getResourceAsStream("C:\\JavaWeb\\SistemaOBT\\WebSystemTraining\\src\\java\\Rel\\listaPresenca.jrxml");
        Map<String, Object> params = new HashMap<String, Object>();
        baos = new ByteArrayOutputStream();

       // params.put("idDocumento", id);
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            JasperPrint print = JasperFillManager.fillReport(report, null, getConexao());
            JasperExportManager.exportReportToPdfStream(print, baos);
            response.reset();
            response.setContentType("aplication/pdf");
            response.setContentLength(baos.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf"); //se quiser forçar o download do relatorio mudar de inline para attachment
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            context.responseComplete();
            fecharConexao();
        } catch (JRException | IOException ex) {
            new RuntimeException("Exceção no metodo GetRelatorio do Relatorio");
        }
    }

    public Connection getConexao() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://"+host+":" +portNumber + ";databaseName=" +database);
            return con;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exceção na conexao");
        }

        return con;
    }

    public void fecharConexao() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exceção ao fechar conexao");
        }
    }

}