/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
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
    private String jvpm;
    private String nombre;
    private String apellido;
    private String horaIn;
    private String horaOut;
    private Areas area;
    private List<Medicos> medicoArea;
    private List horario;
    /**
     * Creates a new instance of MedicosBean
     */
    public MedicosBean() {
    }
    public void getMedicos(int idArea){
        MedicosDAO medicosDao=new MedicosDAO();
        medicoArea=medicosDao.getMedicosByArea(idArea);
    }
    public void getHoraMedico(String idMedico){
        System.out.println(idMedico);
        MedicosDAO medicosDao=new MedicosDAO();
        setHorario(new ArrayList());
        if(!idMedico.isEmpty()){
            Medicos medico=medicosDao.getHoraMedico(idMedico);
            if(medico!=null){
                String horaInArray=medico.getHoraIn();
                String[] horaInA=horaInArray.split(":");
                String horaOutArray=medico.getHoraOut();
                String[] horaOutA=horaOutArray.split(":");
                int horaIn=Integer.parseInt(horaInA[0]);
                int horaOut=Integer.parseInt(horaOutA[0]);

                for(int i=horaIn;i<=horaOut;i++){
                    getHorario().add(i+":00");
                }
            }
        }
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
    
}
