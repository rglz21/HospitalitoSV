/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.entites.Laboratorio;
import sv.edu.udb.entites.Tipoexamenes;
import sv.edu.udb.DAO.ExamenDAO;
import sv.edu.udb.DAO.UtilDAO;
import sv.edu.udb.entites.Examenes;
import sv.edu.udb.entites.Paciente;


/**
 *
 * @author javie
 */
@ManagedBean
@SessionScoped
public class ExamenBean {

    /**
     * Creates a new instance of ExamenBean
     */
    private String  idExam;
     private Laboratorio laboratorio;
     private int lab;
     private Tipoexamenes tipoexamenes;
     private int tipo;
     private String idPaciente;
     private String descripcion;
     private Date fechaRealizado;
     
     
    public ExamenBean() {
     
    }
     public List<Examenes> getExamenes() {
        ExamenDAO examen = new ExamenDAO();
        List<Examenes> lista = examen.obtener();
        return lista;
    }
     
     public List<Laboratorio> getLaboratorio1() {
        ExamenDAO producto = new ExamenDAO();
        List<Laboratorio> lista = producto.obtenerLab();
        return lista;
    }
     public List<Tipoexamenes> getExam1() {
        ExamenDAO producto = new ExamenDAO();
        List<Tipoexamenes> lista = producto.obtenerExam();
        return lista;
    }


     
    public  String  addExamenes() {
        UtilDAO utilDao=new UtilDAO();
        ExamenDAO examenesDao = new ExamenDAO();
        Laboratorio nuevo = new Laboratorio();
        Tipoexamenes tipo1 = new Tipoexamenes();
        nuevo.setIdLab(lab);
        tipo1.setIdTipo(tipo);
        int num = utilDao.contar("Examen");
        int num2 = ++num;
        setIdExam("EXAM-"+num2);
        Examenes exa = new Examenes( idExam, nuevo, tipo1 , idPaciente, descripcion, fechaRealizado);
        examenesDao.addExamenes(exa);
        
        return "Examen";
    } 
       
   public String  returnExamenes(String id) {
        ExamenDAO examenDao = new ExamenDAO();
        Examenes examen = examenDao.getExamenes1(id);
        Laboratorio nuevo = new Laboratorio();
        Tipoexamenes tipo1 = new Tipoexamenes();
        nuevo.setIdLab(lab);
        tipo1.setIdTipo(tipo);
        if (examen != null) {

            setIdExam(examen.getIdExam());
            setLab(examen.getLaboratorio().getIdLab());
            setTipo(examen.getTipoexamenes().getIdTipo());
            setIdPaciente(examen.getIdPaciente());
            setDescripcion(examen.getDescripcion());
            setFechaRealizado(examen.getFechaRealizado());
            
            
          
           
        } else {
            setIdExam("");
            setLab(0);
            setTipo(0);
            setIdPaciente("");
            setDescripcion("");
            setFechaRealizado(null);
            
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Examen NO especificado"));
        }
  return "EditarExamen";
    }
   public void returnCliente(String id) {
        ExamenDAO examenDao = new ExamenDAO();
        Examenes examen = examenDao.getExamenes1(id);
        Laboratorio nuevo = new Laboratorio();
        Tipoexamenes tipo1 = new Tipoexamenes();
        nuevo.setIdLab(lab);
        tipo1.setIdTipo(tipo);
        if (examen != null) {

            setIdExam(examen.getIdExam());
            setLab(examen.getLaboratorio().getIdLab());
            setTipo(examen.getTipoexamenes().getIdTipo());
            setIdPaciente(examen.getIdPaciente());
            setDescripcion(examen.getDescripcion());
            setFechaRealizado(examen.getFechaRealizado());
            
            
          
           
        } else {
            setIdExam("");
            setLab(0);
            setTipo(0);
            setIdPaciente("");
            setDescripcion("");
            setFechaRealizado(null);
            
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Examen NO especificado"));
        }
        

    }
   
  public int cont;
  

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
  
  
          
          
          
   public void returnPaciente(String id) {
       
        ExamenDAO pacienteDao = new ExamenDAO();
        Paciente paciente = pacienteDao.getPaciente(id);
      
        if (paciente != null) {

            setIdPaciente(paciente.getIdPaciente());
          
           
        } else {
            setIdPaciente("");
            
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Paciente NO encontrado"));
        }
   }
       public String deleteExamenes( String id) {
        ExamenDAO examenDao = new ExamenDAO();
        Examenes examen = examenDao.getExamenes1(id);

        if (examen != null) {
            examenDao.deleteExamenes(id);
            setIdExam("");
            setLab(0);
            setTipo(0);
            setIdPaciente("");
            setDescripcion("");
            setFechaRealizado(null);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Examen con ID " + id + " Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Examen con ID " + id + " NO encontrado"));
        }

        return "Examen";
        
    }
        public String updateExamenes( String id) {
        ExamenDAO examenDao = new ExamenDAO();
        Examenes obtexamen = examenDao.getExamenes1(id);

        if (obtexamen!= null) {
        Laboratorio nuevo = new Laboratorio();
        Tipoexamenes tipo1 = new Tipoexamenes();
        nuevo.setIdLab(lab);
        tipo1.setIdTipo(tipo);
             
        
          Examenes exa = new Examenes( id, nuevo, tipo1 , idPaciente, descripcion, fechaRealizado);

            examenDao.updateExamenes(id, exa);
     
           
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Examen con ID " + id + " Actualizado"));
        } else {
           
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Examen con ID " + id + " NO encontrado"));
        }

        return "Examen";

    }
           
           
        public List<Examenes> getExamenes1(){
        ExamenDAO examen = new ExamenDAO();
        List<Examenes> lista = examen.obtener();
        return lista;
    }
           

           
    public String getIdExam() {
        return idExam;
    }

    public void setIdExam(String idExam) {
        this.idExam = idExam;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int Lab) {
        this.lab = Lab;
    }

    public Tipoexamenes getTipoexamenes() {
        return tipoexamenes;
    }

    public void setTipoexamenes(Tipoexamenes tipoexamenes) {
        this.tipoexamenes = tipoexamenes;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int Tipo) {
        this.tipo = Tipo;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }
   
   
    
}



