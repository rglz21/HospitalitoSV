/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sv.edu.udb.DAO.PacienteDAO;
import sv.edu.udb.DAO.PrediagDAO;
import sv.edu.udb.DAO.SintomasDAO;
import sv.edu.udb.entites.Estadopre;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Prediagnostico;
import sv.edu.udb.entites.Sintomas;

/**
 *
 * @author jonat
 */
@ManagedBean
@SessionScoped
public class PrediagBean {

    private int idPrediag;
    private Estadopre estadopre;
    private Paciente paciente;
    private Date fechaPre;
    private String pacient;
    private Sintomas sintomas = new Sintomas();

    //tabla simtomas
    private int idSintoma;
    private Prediagnostico prediagnostico;
    private String sintoma;
    private String descripcion;
    private String duracion;
    private int prediag;

    /**
     * Creates a new instance of PrediagBean
     */
    public PrediagBean() {
    }

    public List<Prediagnostico> getDiagnostico() {
        PrediagDAO prediagnDao = new PrediagDAO();
        List<Prediagnostico> lista = prediagnDao.obtenerDiagnostico();
        return lista;
    }

    public List<Sintomas> getSintomasByPrediag(int idPrediag) {
        SintomasDAO sintomasDao = new SintomasDAO();
        List<Sintomas> lista = sintomasDao.getSintomasByPrediag(idPrediag);
        return lista;
    }

    public List<Prediagnostico> getPrediagActivo() {
        PrediagDAO prediagDao = new PrediagDAO();
        List<Prediagnostico> lista = prediagDao.getPrediagByEstado(1);
        return lista;
    }

    public void getPrediagPaciente(int idPrediag) {
        PrediagDAO prediagDao = new PrediagDAO();
        PacienteDAO pacienteDao = new PacienteDAO();
        Prediagnostico prediag = prediagDao.getPrediagPaciente(idPrediag);
        this.idPrediag = prediag.getIdPrediag();
        paciente = prediag.getPaciente();
        fechaPre = prediag.getFechaPre();
        paciente = pacienteDao.obtenerPacienteById(paciente.getIdPaciente());

    }

    public String cambiarEstado() {
        PrediagDAO prediagDao = new PrediagDAO();
        Estadopre estadopred = new Estadopre();
        estadopred.setIdEstado(2);
        Prediagnostico pre = new Prediagnostico(idPrediag, estadopred, paciente, fechaPre);
        prediagDao.cambiarEstado(pre);
        return "crearCitas";
    }

    public String addPrediagnostico() {
        PrediagDAO prediagDao = new PrediagDAO();
//        Paciente pacientee = new Paciente();
//        pacientee.setIdPaciente(getPacient());
        Prediagnostico medico = new Prediagnostico(idPrediag, estadopre, fechaPre);
        prediagDao.addPrediagnostico(medico);

        return "VerExpediente";
    }

    public int getIdPrediag() {
        return idPrediag;
    }

    public void setIdPrediag(int idPrediag) {
        this.idPrediag = idPrediag;
    }

    public Estadopre getEstadopre() {
        return estadopre;
    }

    public void setEstadopre(Estadopre estadopre) {
        this.estadopre = estadopre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFechaPre() {
        return fechaPre;
    }

    public void setFechaPre(Date fechaPre) {
        this.fechaPre = fechaPre;
    }

    /**
     * @return the sintomas
     */
    public Sintomas getSintomas() {
        return sintomas;
    }

    /**
     * @param sintomas the sintomas to set
     */
    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    public String getPacient() {
        return pacient;
    }

    public void setPacient(String pacient) {
        this.pacient = pacient;
    }

    public int getPrediag() {
        return prediag;
    }

    public void setPrediag(int prediag) {
        this.prediag = prediag;
    }

    public int getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(int idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Prediagnostico getPrediagnostico() {
        return prediagnostico;
    }

    public void setPrediagnostico(Prediagnostico prediagnostico) {
        this.prediagnostico = prediagnostico;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    
}
