/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
    
    public List<Expediente> getExpediente() {
        ExpedienteDAO expedienteDao = new ExpedienteDAO();
        List<Expediente> lista = expedienteDao.obtenerExpdiente();
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
