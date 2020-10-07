/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sv.edu.udb.DAO.MedicinaDAO;
import sv.edu.udb.DAO.RecetasDAO;
import sv.edu.udb.DAO.UtilDAO;
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
    private Medicos medico;
    private Paciente paciente;
    private String idMedic;
    private String idPacient;
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
    public List<Recetas> getRecetasByMedic(String idMedico)throws IOException{
        RecetasDAO recetasDao=new RecetasDAO();
        List<Recetas> recetas=recetasDao.getRecetasByMedico(idMedico);
        return recetas;
    }
    public void obtenerReceta(int idReceta) throws IOException{
        RecetasDAO recetasDao=new RecetasDAO();
        Recetas receta=recetasDao.obtenerReceta(idReceta);
        MedicinaDAO medicinaDao=new MedicinaDAO();
        
        setIdRecetas(receta.getIdReceta());
        setMedico(receta.getMedicos());
        setPaciente(receta.getPaciente());
        
        Medicina medicin=medicinaDao.getMedicinasByReceta1(idReceta);
        medicina.setIdMedicina(medicin.getIdMedicina());
        medicina.setRecetas(medicin.getRecetas());
        setNombreM(medicin.getNombre());
        setMgM(medicin.getMg());
        setCantM(medicin.getCantidad());
        setDosisM(medicin.getDosis());
        setIdMedic(medico.getIdMedico());
        setIdPacient(paciente.getIdPaciente());
        //logger log = new logger();
        //log.InfoLog("Nueva Receta insertada","INFO");
    }
    public void updateReceta() throws IOException{
        RecetasDAO recetasDao=new RecetasDAO();
        MedicinaDAO medicinaDao=new MedicinaDAO();
        Medicos medic=new Medicos();
        Paciente pacient= new Paciente();
        
        medic.setIdMedico(getIdMedic());
        pacient.setIdPaciente(getIdPacient());
        Recetas receta=new Recetas(idRecetas, medic, pacient);
        recetasDao.updateReceta(idRecetas,receta);
        
        medicina.setRecetas(receta);
        medicina.setNombre(getNombreM());
        medicina.setMg(getMgM());
        medicina.setCantidad(getCantM());
        medicina.setDosis(getDosisM());
        System.out.println(medicina.getIdMedicina());
        medicinaDao.updateMedicamento(medicina.getIdMedicina(),medicina);
        
        //logger log = new logger();
        //log.InfoLog("Nueva Receta insertada","INFO");
    }
    
    public void insertReceta() throws IOException{
        UtilDAO utilDao=new UtilDAO();
        RecetasDAO recetasDao=new RecetasDAO();
        MedicinaDAO medicinaDao=new MedicinaDAO();
        Medicos medic=new Medicos();
        Paciente pacient= new Paciente();
        
        medic.setIdMedico(getIdMedic());
        pacient.setIdPaciente(getIdPacient());
        int count=utilDao.contar("Recetas");
        int newidR=++count;
        setIdRecetas(newidR);
        Recetas receta=new Recetas(idRecetas, medic, pacient);
        recetasDao.insertReceta(receta);
        
        int count2=utilDao.contar("Medicina");
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
        
        //logger log = new logger();
        //log.InfoLog("Nueva Receta insertada","INFO");
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
    
}
