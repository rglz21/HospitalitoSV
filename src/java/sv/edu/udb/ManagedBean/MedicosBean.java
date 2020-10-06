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
import sv.edu.udb.DAO.MedicosDAO;
import sv.edu.udb.entites.Areas;
import sv.edu.udb.entites.Medicos;

/**
 *
 * @author jonat
 */
@ManagedBean
@RequestScoped
public class MedicosBean {

    private String idMedico;
    private Areas idareas;
    private String jvpm;
    private String nombre;
    private String apellido;
    private String horaIn;
    private String horaOut;
    private int areas;

    /**
     * Creates a new instance of MedicosBean
     */
    public MedicosBean() {
    }

    public String addMedico() {
        MedicosDAO medicoDao = new MedicosDAO();
        Areas area = new Areas();
        area.setIdArea(getAreas());
        Medicos medico = new Medicos(idMedico, area, jvpm, nombre, apellido, horaIn, horaOut);
        medicoDao.addinfoMedico(medico);

        return "VerMedicos";
    }

    public List<Medicos> getMedico() {
        MedicosDAO medicoDao = new MedicosDAO();
        List<Medicos> lista = medicoDao.obtenerMedico();
        return lista;
    }

    public List<Areas> getArea() {
        AreasDAO areasDao = new AreasDAO();
        List<Areas> lista = areasDao.getAreas();
        return lista;
    }

    public String returnMedicos(String id) {
        MedicosDAO medicoDao = new MedicosDAO();
        Medicos medico = medicoDao.getMedicos1(id);
        Areas area = new Areas();
        area.setIdArea(getAreas());
        if (medico != null) {

            setIdMedico(medico.getIdMedico());
            setAreas(medico.getAreas().getIdArea());
            setJvpm(medico.getJvpm());
            setNombre(medico.getNombre());
            setApellido(medico.getApellido());
            setHoraIn(medico.getHoraIn());
            setHoraOut(medico.getHoraOut());

        } else {
            setIdMedico("");
            setAreas(0);
            setJvpm("");
            setNombre("");
            setApellido("");
            setHoraIn("");
            setHoraOut("");

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico NO especificado"));
        }
        return "EditarMedico";
    }

    public String updateExamenes(String id) {
        MedicosDAO medicoDao = new MedicosDAO();
        Medicos medico = medicoDao.getMedicos1(id);

        if (medico != null) {
            Areas area = new Areas();
            area.setIdArea(getAreas());
            Medicos medic = new Medicos(idMedico, area, jvpm, nombre, apellido, horaIn, horaOut);
            medicoDao.updateMedico(id, medic);

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico con ID " + id + " Actualizado"));
        } else {

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico con ID " + id + " NO encontrado"));
        }

        return "VerMedicos";

    }

    public String deleteMedicos(String id) {
        MedicosDAO medicoDao = new MedicosDAO();
        Medicos medico = medicoDao.getMedicos1(id);

        if (medico != null) {
            medicoDao.deleteMedicos(id);
            setIdMedico("");
            setAreas(0);
            setJvpm("");
            setNombre("");
            setApellido("");
            setHoraIn("");
            setHoraOut("");
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico con ID " + id + " Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("medico con ID " + id + " NO encontrado"));
        }

        return "VerMedicos";

    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public Areas getIdareas() {
        return idareas;
    }

    public void setIdareas(Areas idareas) {
        this.idareas = idareas;
    }

    public String getJvpm() {
        return jvpm;
    }

    public void setJvpm(String jvpm) {
        this.jvpm = jvpm;
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

    public String getHoraIn() {
        return horaIn;
    }

    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    public String getHoraOut() {
        return horaOut;
    }

    public void setHoraOut(String horaOut) {
        this.horaOut = horaOut;
    }

    public int getAreas() {
        return areas;
    }

    public void setAreas(int areas) {
        this.areas = areas;
    }

}
