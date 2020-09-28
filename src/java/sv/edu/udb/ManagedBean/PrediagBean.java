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
import sv.edu.udb.DAO.PrediagDAO;
import sv.edu.udb.entites.Estadopre;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Prediagnostico;

/**
 *
 * @author jonat
 */
@ManagedBean
@RequestScoped
public class PrediagBean {

    private int idPrediag;
    private Estadopre estadopre;
    private Paciente paciente;
    private Date fechaPre;

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

     
}
