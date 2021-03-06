/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.IOException;
import java.text.ParseException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.DAO.SintomasDAO;
import sv.edu.udb.entites.Prediagnostico;
import sv.edu.udb.entites.Sintomas;

/**
 *
 * @author jonat
 */
@ManagedBean
@RequestScoped
public class SintomasBean {

    private int idSintoma;
    private Prediagnostico prediagnostico;
    private String sintoma;
    private String descripcion;
    private String duracion;
    private int prediag;
    private int predi;

    /**
     * Creates a new instance of SintomasBean
     */
    public SintomasBean() {
    }

    public String addSintomas(String idPacient) throws IOException, ParseException {
        PrediagBean metodo = new PrediagBean();
        SintomasDAO sintomaDao = new SintomasDAO();
        Prediagnostico predia = new Prediagnostico();
        predia.setIdPrediag(getPredi());
        Sintomas sintomaa = new Sintomas(idSintoma, predia, sintoma, descripcion, duracion);
        sintomaDao.addSintomas(sintomaa);

        return "VerExpediente";
    }
    
    public String returnSintomas(int id) {
        SintomasDAO sintomaDao = new SintomasDAO();
        Sintomas sintomaa = sintomaDao.getSintomas1(id);
        Prediagnostico prediagnost = new Prediagnostico();
        prediagnost.setIdPrediag(getPredi());
        if (sintomaa != null) {
            setIdSintoma(sintomaa.getIdSintoma());
            setPredi(sintomaa.getPrediagnostico().getIdPrediag());
            setSintoma(sintomaa.getSintoma());
            setDescripcion(sintomaa.getDescripcion());
            setDuracion(sintomaa.getDuracion());
        } else {
            setIdSintoma(0);
            setPredi(0);
            setSintoma("");
            setDescripcion("");
            setDuracion("");

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico NO especificado"));
        }
        return "editarPrediag";
    }

    public String updateSintomas(int id) {
        SintomasDAO sintomaDao = new SintomasDAO();
        Sintomas sintomas = sintomaDao.getSintomas1(id);

        if (sintomas != null) {
            Prediagnostico predia = new Prediagnostico();
            predia.setIdPrediag(getPredi());
            Sintomas sint = new Sintomas(idSintoma, predia, sintoma, descripcion, duracion);
            sintomaDao.updateSintomas(id, sint);

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico con ID " + id + " Actualizado"));
        } else {

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico con ID " + id + " NO encontrado"));
        }

        return "VerExpediente";

    }

    public String deleteSintomas(int id) {
        SintomasDAO sintomasDao = new SintomasDAO();
        Sintomas sintoma = sintomasDao.getSintomas1(id);

        if (sintoma != null) {
            sintomasDao.deleteSintomas(id);
            setIdSintoma(0);
            setPredi(0);
            setSintoma("");
            setDescripcion("");
            setDuracion("");
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Medico con ID " + id + " Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("medico con ID " + id + " NO encontrado"));
        }

        return "VerExpediente";
    }

    public int getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(int idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Prediagnostico getPrediagnostico() {
        return prediagnostico;
    }

    public void setPrediagnostico(Prediagnostico prediagnostico) {
        this.prediagnostico = prediagnostico;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getPrediag() {
        return prediag;
    }

    public void setPrediag(int prediag) {
        this.prediag = prediag;
    }
    
    public int getPredi() {
        return predi;
    }

    public void setPredi(int predi) {
        this.predi = predi;
    }
}
