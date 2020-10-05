/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import sv.edu.udb.DAO.ExpedienteDAO;
import sv.edu.udb.entites.Expediente;
import sv.edu.udb.entites.Paciente;

/**
 *
 * @author jonat
 */
@ManagedBean
@RequestScoped
public class ExpedienteBean {

    private String idExpe;
    private Paciente paciente;

    /**
     * Creates a new instance of ExpedienteBean
     */
    public ExpedienteBean() {
    }
    public void verExpediente(String idPaciente) throws Exception{
        Map<String, Object> parameters= new HashMap<String, Object>();
        parameters.put("idPaciente",idPaciente);
        System.out.println(idPaciente);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?zeroDateTimeBehavior=convertToNull","root", "");
        conn.setAutoCommit(false);
        
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/expediente.jasper"));     
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(),parameters, conn);
	HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0 , bytes.length);
        outStream.flush();
        outStream.close();
    }
    
    public Expediente getExpediente() {
        ExpedienteDAO expedienteDao = new ExpedienteDAO();
        Expediente lista = expedienteDao.obtenerExpdiente("RG-1");
        return lista;
    }

    public String getIdExpe() {
        return idExpe;
    }

    public void setIdExpe(String idExpe) {
        this.idExpe = idExpe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    

}
