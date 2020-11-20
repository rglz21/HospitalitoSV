/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.DAO.CitasDAO;
import sv.edu.udb.DAO.ExamenesDAO;
import sv.edu.udb.DAO.MedicosDAO;
import sv.edu.udb.DAO.UtilDAO;
import sv.edu.udb.entites.Areas;
import sv.edu.udb.entites.Citas;
import sv.edu.udb.entites.Consulta;
import sv.edu.udb.entites.Examenes;
import sv.edu.udb.entites.Laboratorio;
import sv.edu.udb.entites.Medicos;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Tipoexamenes;

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
    private String paciente;
    private String medico;
    private Areas area;
    private int idArea;
    private String estado;
    private List<Citas> listCita;
    private List<Examenes> exams=new ArrayList<Examenes>();
    private int[] exs;
    private Tipoexamenes tipo=new Tipoexamenes();
    private Consulta con=new Consulta();
    @ManagedProperty(value="#{consultaBean}")
    private ConsultaBean conBean;
    @ManagedProperty(value="#{recetasBean}")
    private RecetasBean recBean;

    /**
     * Creates a new instance of CitasBean
     */
    public CitasBean() {
    }
    public String guardarCita(){
        CitasDAO citasDao=new CitasDAO();
        UtilDAO utilDao=new UtilDAO();
        Citas cita=citasDao.obtenerCita(idCita);
        conBean.obtenerConsulta(idCita);
        Examenes ex=new Examenes();
        ExamenesDAO examDao=new ExamenesDAO();
        Laboratorio lab=new Laboratorio();
        lab.setIdLab(1);
        
        int cexam=utilDao.contarString("Examenes","idExam");
        int nexam=++cexam;
         for(int tip: exs){
            ex.setIdExam("EXAM-"+nexam);
            ex.setCitas(cita);
            tipo.setIdTipo(tip);
            ex.setTipoexamenes(tipo);
            ex.setLaboratorio(lab);
            exams.add(ex);
            ++cexam;
         }
        examDao.addExamenes(exams);
        if(conBean.getDescripcion()==null){
            conBean.addConsulta(cita);
        }else{
            conBean.updateConsulta(cita);
        }
        return "seguimiento";
    }
    public String finalizarCita(){
        CitasDAO citasDao=new CitasDAO();
        citasDao.updateEstadoCita(idCita,"Finalizada");
        return "indexMedicos";
    }
    public String obtenerCitaId(int idCita) throws IOException{
        CitasDAO citasDao=new CitasDAO();
        Citas cita=citasDao.obtenerCita(idCita);
        if(cita != null){
            setIdCita(cita.getIdCita());
            setIdMedico(cita.getMedicos());
            setIdPaciente(cita.getPaciente());
            setFechaCita(cita.getFecha());
            setHora(cita.getHora());
            MedicosDAO medicosDao=new MedicosDAO();
            Medicos medico=medicosDao.getMedicos1(idMedico.getIdMedico());
            area=medico.getAreas();
            conBean.obtenerConsulta(idCita);
            recBean.obtenerReceta(idCita);
            recBean.setIdCita(idCita);
            return "citaOpen";
        }else{
            setIdCita(0);
            setIdMedico(null);
            setIdPaciente(null);
            setFechaCita(new java.util.Date());
            setHora("");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cita NO especificada"));
            return "";
        }
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
            MedicosDAO medicosDao=new MedicosDAO();
            Medicos medico=medicosDao.getMedicos1(idMedico.getIdMedico());
            area=medico.getAreas();
            recBean.setIdCita(idCita);
            citasDao.updateEstadoCita(idCita,"Abierta");
            return "citaOpen";
        }else{
            setIdCita(0);
            setIdMedico(null);
            setIdPaciente(null);
            setFechaCita(new java.util.Date());
            setHora("");
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cita NO especificada"));
            return "indexSecretaria";
        }
    }
    public String updateCita(){
        CitasDAO citasDao=new CitasDAO();
        Citas cita=citasDao.obtenerCita(getIdCita());
         Medicos medic=new Medicos();
        Paciente pacient= new Paciente();
        medic.setIdMedico(getMedico());
        pacient.setIdPaciente(getPaciente());
        
        if(cita != null){
            Citas editCita=new Citas(idCita, medic, pacient,fechaCita,hora,"No abierta");
            citasDao.updateCita(getIdCita(), editCita);
             
            return "indexSecretaria";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cita NO especificada"));
            return "editarCita";
        }
    }
    public String addCita(){
        UtilDAO utilDao=new UtilDAO();
        CitasDAO citasDao=new CitasDAO();
        Medicos medic=new Medicos();
        Paciente pacient= new Paciente();
        medic.setIdMedico(getMedico());
        pacient.setIdPaciente(getPaciente());
        
        int ccitas=utilDao.contar("Citas","idCita");
        int ncita=++ccitas;
        setIdCita(ncita);
        
        Citas cita=new Citas(idCita, medic, pacient,fechaCita,hora,"No abierta");
        citasDao.addCita(cita);
        
        return "indexSecretaria";
    }
    
    public List<Citas>getCitasByMedicos(String idMedico){
        CitasDAO citasDao=new CitasDAO();
        List<Citas> lista=citasDao.getCitasByMedico(idMedico);
        return lista;
    }
    public List<Citas>getCitasAbiertas(String idMedico){
        CitasDAO citasDao=new CitasDAO();
        List<Citas> lista=citasDao.getCitasAbiertas(idMedico);
        return lista;
    }
    public List<Citas>getCitasPerdidas(String idMedico){
        CitasDAO citasDao=new CitasDAO();
        List<Citas> lista=citasDao.getCitasPerdidas(idMedico);
        return lista;
    }
    
    public List<Citas>getCitasByPacientes(String idPaciente){
        CitasDAO citasDao=new CitasDAO();
        List<Citas> lista=citasDao.getCitasByPaciente1(idPaciente);
        return lista;
    }

     public void getCitas(String estado){
        CitasDAO citasDao=new CitasDAO();
       listCita = citasDao.getCitasB(estado);
       
    }

     
     
    public List<Citas> getListCita() {
        return listCita;
    }

    /**
     * @return the idCita
     */
    public void setListCita(List<Citas> listCita) {
        this.listCita = listCita;
    }

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
    public Areas getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Areas area) {
        this.area = area;
    }

    /**
     * @return the idArea
     */
    public int getIdArea() {
        return idArea;
    }

    /**
     * @param idArea the idArea to set
     */
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the conBean
     */
    public ConsultaBean getConBean() {
        return conBean;
    }

    /**
     * @param conBean the conBean to set
     */
    public void setConBean(ConsultaBean conBean) {
        this.conBean = conBean;
    }

    /**
     * @return the con
     */
    public Consulta getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Consulta con) {
        this.con = con;
    }

    /**
     * @return the recBean
     */
    public RecetasBean getRecBean() {
        return recBean;
    }

    /**
     * @param recBean the recBean to set
     */
    public void setRecBean(RecetasBean recBean) {
        this.recBean = recBean;
    }

    /**
     * @return the exams
     */
    public List<Examenes> getExams() {
        return exams;
    }

    /**
     * @param exams the exams to set
     */
    public void setExams(List<Examenes> exams) {
        this.exams = exams;
    }

    /**
     * @return the tipo
     */
    public Tipoexamenes getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipoexamenes tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the exs
     */
    public int[] getExs() {
        return exs;
    }

    /**
     * @param exs the exs to set
     */
    public void setExs(int[] exs) {
        this.exs = exs;
    }

    
}
