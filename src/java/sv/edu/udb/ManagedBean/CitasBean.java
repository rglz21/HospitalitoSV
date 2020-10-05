/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import sv.edu.udb.DAO.CitasDAO;
import sv.edu.udb.entites.Citas;
import sv.edu.udb.entites.Medicos;
import sv.edu.udb.entites.Paciente;

/**
 *
 * @author HP Probook
 */
@ManagedBean
@SessionScoped
public class CitasBean {
    private int idCita;
    private Medicos idMedico=new Medicos();
    private Paciente idPaciente;
    private Date fechaCita;
    private String hora;
    private String examenes;
    private String tipoExamen;
    private String paciente;
    private String medico;
    private int area;
    /**
     * Creates a new instance of CitasBean
     */
    public CitasBean() {
    }
    public String obtenerCitaById(int idCita){
        CitasDAO citasDao=new CitasDAO();
        Citas cita=citasDao.obtenerCita(idCita);
        if(cita != null){
            setIdCita(cita.getIdCita());
            setIdMedico(cita.getMedicos());
            setIdPaciente(cita.getPaciente());
            setFechaCita(cita.getFecha());
            setHora(cita.getHora());
            setExamenes(cita.getExamen());
            setTipoExamen(cita.getTipExamen());
            return "Medicos/editarCitas";
        }else{
            setIdCita(0);
            setIdMedico(null);
            setIdPaciente(null);
            setFechaCita(new java.util.Date());
            setHora("");
            setExamenes("");
            setTipoExamen("");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cita NO especificada"));
            return "editar1";
        }
    }
    public void updateCita(){
        CitasDAO citasDao=new CitasDAO();
        Citas cita=citasDao.obtenerCita(getIdCita());
        Medicos medic=new Medicos();
        Paciente pacient=new Paciente();
        medic.setIdMedico(medico);
        pacient.setIdPaciente(paciente);
        if(cita != null){
            Citas editCita=new Citas(idCita,medic,pacient,fechaCita,hora,examenes,tipoExamen);
            citasDao.updateCita(getIdCita(), editCita);
            cita=citasDao.obtenerCita(getIdCita());
            setIdCita(cita.getIdCita());
            setIdMedico(cita.getMedicos());
            setIdPaciente(cita.getPaciente());
            setFechaCita(cita.getFecha());
            setHora(cita.getHora());
            setExamenes(cita.getExamen());
            setTipoExamen(cita.getTipExamen());
        }else{
            setIdCita(0);
            setIdMedico(null);
            setIdPaciente(null);
            setFechaCita(new java.util.Date());
            setHora("");
            setExamenes("");
            setTipoExamen("");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cita NO especificada"));
        }
    }
    public void addCita(){
        CitasDAO citasDao=new CitasDAO();
        Medicos medic=new Medicos();
        Paciente pacient= new Paciente();
        medic.setIdMedico(getMedico());
        pacient.setIdPaciente(getPaciente());
        
        int ccitas=citasDao.contarCitas();
        int ncita=++ccitas;
        setIdCita(ncita);
        
        Citas cita=new Citas(idCita, medic, pacient,fechaCita,hora,examenes,tipoExamen);
        citasDao.addCita(cita);
    }
    public List<Citas>getCitasByMedicos(String idMedico){
        CitasDAO citasDao=new CitasDAO();
        List<Citas> lista=citasDao.getCitasByMedico(idMedico);
        return lista;
    }

    /**
     * @return the idCita
     */
    public int getIdCita() {
        return idCita;
    }

    /**
     * @param idCita the idCita to set
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    /**
     * @return the fechaCita
     */
    public Date getFechaCita() {
        return fechaCita;
    }

    /**
     * @param fechaCita the fechaCita to set
     */
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the examenes
     */
    public String getExamenes() {
        return examenes;
    }

    /**
     * @param examenes the examenes to set
     */
    public void setExamenes(String examenes) {
        this.examenes = examenes;
    }

    /**
     * @return the tipoExamen
     */
    public String getTipoExamen() {
        return tipoExamen;
    }

    /**
     * @param tipoExamen the tipoExamen to set
     */
    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    /**
     * @return the paciente
     */
    public String getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(String paciente) {
        this.paciente = paciente;
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

    /**
     * @return the idPaciente
     */
    public Paciente getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the medico
     */
    public String getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }

    /**
     * @return the area
     */
    public int getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(int area) {
        this.area = area;
    }
}
