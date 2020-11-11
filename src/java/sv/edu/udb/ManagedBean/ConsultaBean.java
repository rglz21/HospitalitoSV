/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sv.edu.udb.DAO.ConsultaDAO;
import sv.edu.udb.DAO.ExpedienteDAO;
import sv.edu.udb.DAO.MedicosDAO;
import sv.edu.udb.DAO.UtilDAO;
import sv.edu.udb.entites.Citas;
import sv.edu.udb.entites.Consulta;
import sv.edu.udb.entites.Expediente;
import sv.edu.udb.entites.Medicos;

/**
 *
 * @author HP Probook
 */
@ManagedBean
@SessionScoped
public class ConsultaBean {
    private int idConsulta;
    private Expediente idExpe;
    private String descripcion;
    private Date fecha=new Date();
    private String diagnostico;
    private Medicos idMedico;
    private int cita;
    /**
     * Creates a new instance of ConsultaBean
     */
    public ConsultaBean() {
    }
    public void addConsulta(Citas citaO, Consulta consulta){
        UtilDAO utilDao=new UtilDAO();
        ConsultaDAO conDao=new ConsultaDAO();
        MedicosDAO medDao=new MedicosDAO();
        ExpedienteDAO expDao=new ExpedienteDAO();
        String idPac=citaO.getPaciente().getIdPaciente();
        System.out.println(idPac);
        idExpe=expDao.obtenerExpdiente(citaO.getPaciente().getIdPaciente());
        idMedico=medDao.getMedicos1(citaO.getMedicos().getIdMedico());
        int ccon=utilDao.contar("Consulta","idConsulta");
        int ncon=++ccon;
        Consulta con=new Consulta(ncon, idExpe, consulta.getDescripcion(), fecha, consulta.getDiagnostico(), idMedico.getIdMedico(), citaO.getIdCita());
        conDao.addConsulta(con);
    }
    /**
     * @return the idConsulta
     */
    public int getIdConsulta() {
        return idConsulta;
    }

    /**
     * @param idConsulta the idConsulta to set
     */
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    /**
     * @return the idExpe
     */
    public Expediente getIdExpe() {
        return idExpe;
    }

    /**
     * @param idExpe the idExpe to set
     */
    public void setIdExpe(Expediente idExpe) {
        this.idExpe = idExpe;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the idMedico
     */
    public Medicos getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(Medicos idMedico) {
        this.idMedico = idMedico;
    }
    
}
