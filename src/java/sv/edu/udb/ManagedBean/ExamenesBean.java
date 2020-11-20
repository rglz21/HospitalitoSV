/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.edu.udb.DAO.ExamenesDAO;
import sv.edu.udb.entites.Examenes;
import sv.edu.udb.entites.Laboratorio;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Tipoexamenes;

/**
 *
 * @author jonat
 */
@ManagedBean
@RequestScoped
public class ExamenesBean {
    
    private String idExam;
     private Laboratorio laboratorio = new Laboratorio();
     private Tipoexamenes tipoexamenes;
     private String idPaciente;
     private String descripcion;
     private Date fechaRealizado;
     private Paciente paciente;
    /**
     * Creates a new instance of ExamenesBean
     */
    public ExamenesBean() {
        
    }
    
    public List<Examenes> getExamen() {
        ExamenesDAO examenDao = new ExamenesDAO();
        List<Examenes> lista = examenDao.obtenerExamen();
        return lista;
    }
    public List<Tipoexamenes> getTipos(){
        ExamenesDAO examenDao= new ExamenesDAO();
        List<Tipoexamenes> tipo=examenDao.obtenerTipos();
        return tipo;
    }
    
     
    public List<Examenes> getExamenesByCita(int idCita) {
        ExamenesDAO examenDao = new ExamenesDAO();
        List<Examenes> lista = (List<Examenes>) examenDao.ObtenerExamenes(idCita);
        return lista;
    }
    
    public String getIdExam() {
        return idExam;
    }

    public void setIdExam(String idExam) {
        this.idExam = idExam;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Tipoexamenes getTipoexamenes() {
        return tipoexamenes;
    }

    public void setTipoexamenes(Tipoexamenes tipoexamenes) {
        this.tipoexamenes = tipoexamenes;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    
}
