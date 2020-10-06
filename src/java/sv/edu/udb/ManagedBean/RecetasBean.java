/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.edu.udb.DAO.RecetasDAO;
import sv.edu.udb.entites.Medicos;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Recetas;
import sv.edu.udb.util.logger;

/**
 *
 * @author HP Probook
 */
@ManagedBean
@RequestScoped
public class RecetasBean {
    private int idRecetas;
    private Medicos medico;
    private Paciente paciente;
    private String idMedic;
    private String idPacient;
    /**
     * Creates a new instance of RecetasBean
     */
    public RecetasBean() {
    }
    public void insertReceta() throws IOException{
        RecetasDAO recetasDao=new RecetasDAO();
        Medicos medic=new Medicos();
        Paciente pacient= new Paciente();
        medic.setIdMedico(getIdMedic());
        pacient.setIdPaciente(getIdPacient());
        Recetas receta=new Recetas(idRecetas, medic, pacient);
        recetasDao.insertReceta(receta);
         logger log = new logger();
        log.InfoLog("Nueva Receta insertada","INFO");
    }
    /**
     * @return the idRecetas
     */
    public int getIdRecetas() {
        return idRecetas;
    }

    /**
     * @param idRecetas the idRecetas to set
     */
    public void setIdRecetas(int idRecetas) {
        this.idRecetas = idRecetas;
    }

    /**
     * @return the medico
     */
    public Medicos getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the idMedic
     */
    public String getIdMedic() {
        return idMedic;
    }

    /**
     * @param idMedic the idMedic to set
     */
    public void setIdMedic(String idMedic) {
        this.idMedic = idMedic;
    }

    /**
     * @return the idPacient
     */
    public String getIdPacient() {
        return idPacient;
    }

    /**
     * @param idPacient the idPacient to set
     */
    public void setIdPacient(String idPacient) {
        this.idPacient = idPacient;
    }
    
}
