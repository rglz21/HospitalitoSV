/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import sv.edu.udb.DAO.AreasDAO;
import sv.edu.udb.DAO.MedicosDAO;
import sv.edu.udb.entites.Areas;
import sv.edu.udb.entites.Medicos;

/**
 *
 * @author HP Probook
 */
@ManagedBean
@SessionScoped
public class MedicosBean {

    private String idMedico;
    private Areas idareas;
    private String jvpm;
    private String nombre;
    private String apellido;
    private String horaIn;
    private String horaOut;
    private int area;
    private List<Medicos> medicoArea;
    private List horario;

    /**
     * Creates a new instance of MedicosBean
     */
    public MedicosBean() {
    }

    public void getMedicos(int idArea) {
        MedicosDAO medicosDao = new MedicosDAO();
        medicoArea = medicosDao.getMedicosByArea(idArea);
    }
    public void getMedicoById(String idMedic){
        MedicosDAO medicosDao = new MedicosDAO();
        Medicos medico=medicosDao.getMedicos1(idMedic);
        if(medico!=null){
            setIdMedico(medico.getIdMedico());
            setNombre(medico.getNombre());
            setApellido(medico.getApellido());
            setIdareas(medico.getAreas());
            setJvpm(medico.getJvpm());
            setHoraIn(medico.getHoraIn());
            setHoraOut(medico.getHoraOut());
        }
    }
    public void getHoraMedico(String idMedico) {
        System.out.println(idMedico);
        MedicosDAO medicosDao = new MedicosDAO();
        setHorario(new ArrayList());
        if (!idMedico.isEmpty()) {
            Medicos medico = medicosDao.getHoraMedico(idMedico);
            if (medico != null) {
                String horaInArray = medico.getHoraIn();
                String[] horaInA = horaInArray.split(":");
                String horaOutArray = medico.getHoraOut();
                String[] horaOutA = horaOutArray.split(":");
                int horaIn = Integer.parseInt(horaInA[0]);
                int horaOut = Integer.parseInt(horaOutA[0]);

                for (int i = horaIn; i <= horaOut; i++) {
                    getHorario().add(i + ":00");
                }
            }
        }
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

    /**
     * @return the idMedico
     */
    public String getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return the jvpm
     */
    public String getJvpm() {
        return jvpm;
    }

    /**
     * @param jvpm the jvpm to set
     */
    public void setJvpm(String jvpm) {
        this.jvpm = jvpm;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the horaIn
     */
    public String getHoraIn() {
        return horaIn;
    }

    /**
     * @param horaIn the horaIn to set
     */
    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    /**
     * @return the horaOut
     */
    public String getHoraOut() {
        return horaOut;
    }

    /**
     * @param horaOut the horaOut to set
     */
    public void setHoraOut(String horaOut) {
        this.horaOut = horaOut;
    }

    /**
     * @return the medicoArea
     */
    public List<Medicos> getMedicoArea() {
        return medicoArea;
    }

    /**
     * @param medicoArea the medicoArea to set
     */
    public void setMedicoArea(List<Medicos> medicoArea) {
        this.medicoArea = medicoArea;
    }

    /**
     * @return the horario
     */
    public List getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(List horario) {
        this.horario = horario;
    }

    public int getAreas() {
        return area;
    }

    public void setAreas(int area) {
        this.area = area;
    }

    public Areas getIdareas() {
        return idareas;
    }

    public void setIdareas(Areas idareas) {
        this.idareas = idareas;
    }
}
