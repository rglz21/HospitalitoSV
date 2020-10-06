/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.DAO.AreasDAO;
import sv.edu.udb.DAO.ClinicaDAO;
import sv.edu.udb.entites.Areas;
import sv.edu.udb.entites.Clinica;

/**
 *
 * @author HP Probook
 */
@ManagedBean
@RequestScoped
public class AreasBean {

    private Areas areas = new Areas();
    private int idArea;
    private Clinica clinica;
    private String nombre;
    private int clinic;

    /**
     * Creates a new instance of AreasBean
     */
    public AreasBean() {
    }

    public List<Areas> getArea() {
        AreasDAO areasDao = new AreasDAO();
        List<Areas> lista = areasDao.getAreas();
        return lista;
    }
    
    public List<Clinica> getClinicas() {
        ClinicaDAO clinicaDao = new ClinicaDAO();
        List<Clinica> lista = clinicaDao.obtenerClinica();
        return lista;
    }
    
    public String addAreas() {
        AreasDAO areasDao = new AreasDAO();
        Clinica clinicas = new Clinica();
        clinicas.setIdClinic(getClinic());
        Areas area = new Areas(idArea, clinicas, nombre);
        areasDao.addAreas(area);

        return "VerAreas";
    }
    
    public String returnAreas(int id) {
        AreasDAO areaDao = new AreasDAO();
        Areas areass = areaDao.getAreas1(id);
        Clinica clinicas = new Clinica();
        clinicas.setIdClinic(getClinic());
        if (areass != null) {
            setIdArea(areass.getIdArea());
            setClinic(areass.getClinica().getIdClinic());
            setNombre(areass.getNombre());
        } else {
            setIdArea(0);
            setClinic(0);
            setNombre("");;

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Area NO especificada"));
        }
        return "EditarArea";
    }
    
     public String updateAreas(int id) {
        AreasDAO areaDao = new AreasDAO();
        Areas area = areaDao.getAreas1(id);

        if (area != null) {
            Clinica clinicas = new Clinica();
            clinicas.setIdClinic(getClinic());
            Areas are = new Areas(idArea, clinicas, nombre);
            areaDao.updateAreas(id, are);

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Area con ID " + id + " Actualizado"));
        } else {

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Area con ID " + id + " NO encontrado"));
        }

        return "VerAreas";

    }
     
     public String deleteMedicos(int id) {
        AreasDAO areasDao = new AreasDAO();
        Areas area = areasDao.getAreas1(id);

        if (area != null) {
            areasDao.deleteAreas(id);
            setIdArea(0);
            setClinic(0);
            setNombre("");
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Area con ID " + id + " Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Area con ID " + id + " NO encontrado"));
        }

        return "VerAreas";
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClinic() {
        return clinic;
    }

    public void setClinic(int clinic) {
        this.clinic = clinic;
    }
   
}
