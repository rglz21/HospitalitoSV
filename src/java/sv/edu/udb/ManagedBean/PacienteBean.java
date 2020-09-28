/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.edu.udb.DAO.PacienteDAO;
import sv.edu.udb.entites.Expediente;
import sv.edu.udb.entites.Paciente;

/**
 *
 * @author jonat
 */
@ManagedBean
@RequestScoped
public class PacienteBean {

    private String idPaciente;
    private String nombre;
    private String apellido;
    private String dui;
    private String telefono;
    private String direccion;
    private Expediente idExpe;

    /**
     * Creates a new instance of PacienteBean
     */
    public PacienteBean() {
    }

    public List<Paciente> getPaciente() {
        PacienteDAO pacienteDao = new PacienteDAO();
        List<Paciente> lista = pacienteDao.obtenerPaciente();
        return lista;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Expediente getIdExpe() {
        return idExpe;
    }

    public void setIdExpe(Expediente idExpe) {
        this.idExpe = idExpe;
    }
    
    

}
