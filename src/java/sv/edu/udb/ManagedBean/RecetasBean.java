/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.DAO.MedicinaDAO;
import sv.edu.udb.DAO.RecetasDAO;
import sv.edu.udb.DAO.UtilDAO;
import sv.edu.udb.entites.Citas;
import sv.edu.udb.entites.Medicina;
import sv.edu.udb.entites.Medicos;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Recetas;
import sv.edu.udb.util.logger;

/**
 *
 * @author HP Probook
 */
@ManagedBean
@SessionScoped
public class RecetasBean {
    private int idRecetas;
    private Citas cita;
    private int idCita;
    private Medicina medicina=new Medicina();
    private String nombreM;
    private String mgM;
    private int cantM;
    private String dosisM;
    /**
     * Creates a new instance of RecetasBean
     */
    public RecetasBean() {
    }
    public List<Medicina> getMedicinaByReceta(int idReceta)throws IOException{
        MedicinaDAO medicinaDao=new MedicinaDAO();
        List<Medicina> medicina=medicinaDao.getMedicinasByReceta(idReceta);
        return medicina;
    }
    public void obtenerReceta(int idCita) throws IOException{
        RecetasDAO recetasDao=new RecetasDAO();
        Recetas receta=recetasDao.getRecetaByCita(idCita);
        if(receta!=null){
            setIdRecetas(receta.getIdReceta());
            setCita(receta.getCitas());
        }
        //logger log = new logger();
        //log.InfoLog("Nueva Receta insertada","INFO");
    }
    public void obtenerMedicina(String idMedicina) throws IOException{
        MedicinaDAO medicinaDao=new MedicinaDAO();
        Medicina medi= medicinaDao.getMedicina(idMedicina);
        if(medi!=null){
            medicina.setIdMedicina(medi.getIdMedicina());
            setNombreM(medi.getNombre());
            setCantM(medi.getCantidad());
            setMgM(medi.getMg());
            setDosisM(medi.getDosis());
        }
        //logger log = new logger();
        //log.InfoLog("Nueva Receta insertada","INFO");
    }
    public void updateMedicina() throws IOException{
        MedicinaDAO medicinaDao=new MedicinaDAO();
        Citas ncita=new Citas();
        ncita.setIdCita(idCita);
        Recetas receta=new Recetas(idRecetas,ncita);
        medicina.setRecetas(receta);
        medicina.setNombre(getNombreM());
        medicina.setMg(getMgM());
        medicina.setCantidad(getCantM());
        medicina.setDosis(getDosisM());
        medicinaDao.updateMedicamento(medicina.getIdMedicina(),medicina);
        //logger log = new logger();
        //log.InfoLog("Nueva Receta insertada","INFO");
    }
    public void guardarReceta() throws IOException{
        RecetasDAO recetasDao=new RecetasDAO();
        Recetas rec=recetasDao.getRecetaByCita(idCita);
        MedicinaDAO medicinaDao=new MedicinaDAO();
        
        if(rec==null){
            insertReceta();
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medicina agregada"));
        }
        Medicina medi=medicinaDao.getMedicinaByNombre(nombreM, idRecetas);
        if(medi!=null){
            updateMedicina();
        }else{
            insertMedicina();
        } 
        setNombreM("");
        setMgM("");
        setCantM(0);
        setDosisM("");
    }
    
    public void insertReceta() throws IOException{
        UtilDAO utilDao=new UtilDAO();
        RecetasDAO recetasDao=new RecetasDAO();
        
        Citas ncita=new Citas();
        ncita.setIdCita(idCita);
        int count=utilDao.contar("Recetas","idReceta");
        int newidR=++count;
        setIdRecetas(newidR);
        Recetas receta=new Recetas(idRecetas,ncita);
        recetasDao.insertReceta(receta); 
        //logger log = new logger();
        //log.InfoLog("Nueva Receta insertada","INFO");
    }
    public void insertMedicina(){
        UtilDAO utilDao=new UtilDAO();
        Citas ncita=new Citas();
        ncita.setIdCita(idCita);
        Recetas receta=new Recetas(idRecetas,ncita);
        MedicinaDAO medicinaDao=new MedicinaDAO();
        
        int count2=utilDao.contarString1("Medicina","idMedicina");
        int id=++count2;
        String newidM= String.valueOf(id);
        System.out.println(newidM);
        medicina.setIdMedicina(newidM);
        medicina.setRecetas(receta);
        medicina.setNombre(getNombreM());
        medicina.setMg(getMgM());
        medicina.setCantidad(getCantM());
        medicina.setDosis(getDosisM());
        medicinaDao.insertMedicina(medicina);
    }
    public void deleteMedicina(String id) {
        MedicinaDAO medicinaDao = new MedicinaDAO();
        Medicina medi=medicinaDao.getMedicina(id);
        if (medi != null) {
            medicinaDao.deleteMedicina(id);
            medicina.setIdMedicina("");
            setNombreM("");
            setCantM(0);
            setMgM("");
            setDosisM("");
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medicina Eliminada"));
        } else {
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medicina NO encontrada"));
        }

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
     * @return the medicina
     */
    public Medicina getMedicina() {
        return medicina;
    }

    /**
     * @param medicina the medicina to set
     */
    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
    }

    /**
     * @return the nombreM
     */
    public String getNombreM() {
        return nombreM;
    }

    /**
     * @param nombreM the nombreM to set
     */
    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    /**
     * @return the mgM
     */
    public String getMgM() {
        return mgM;
    }

    /**
     * @param mgM the mgM to set
     */
    public void setMgM(String mgM) {
        this.mgM = mgM;
    }

    /**
     * @return the cantM
     */
    public int getCantM() {
        return cantM;
    }

    /**
     * @param cantM the cantM to set
     */
    public void setCantM(int cantM) {
        this.cantM = cantM;
    }

    /**
     * @return the dosisM
     */
    public String getDosisM() {
        return dosisM;
    }

    /**
     * @param dosisM the dosisM to set
     */
    public void setDosisM(String dosisM) {
        this.dosisM = dosisM;
    }

    /**
     * @return the cita
     */
    public Citas getCita() {
        return cita;
    }

    /**
     * @param cita the cita to set
     */
    public void setCita(Citas cita) {
        this.cita = cita;
    }

    /**
     * @return the idCita
     */
    public int getIdCita() {
        return idCita;
    }

    /**
     * @param idCita the idCita to set
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
    
}
