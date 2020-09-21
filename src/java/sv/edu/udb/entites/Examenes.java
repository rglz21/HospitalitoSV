package sv.edu.udb.entites;
// Generated 09-20-2020 11:06:04 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Examenes generated by hbm2java
 */
public class Examenes  implements java.io.Serializable {


     private String idExam;
     private Laboratorio laboratorio;
     private Tipoexamenes tipoexamenes;
     private String idPaciente;
     private String descripcion;
     private Date fechaRealizado;

    public Examenes() {
    }

    public Examenes(String idExam, Laboratorio laboratorio, Tipoexamenes tipoexamenes, String idPaciente, String descripcion, Date fechaRealizado) {
       this.idExam = idExam;
       this.laboratorio = laboratorio;
       this.tipoexamenes = tipoexamenes;
       this.idPaciente = idPaciente;
       this.descripcion = descripcion;
       this.fechaRealizado = fechaRealizado;
    }
   
    public String getIdExam() {
        return this.idExam;
    }
    
    public void setIdExam(String idExam) {
        this.idExam = idExam;
    }
    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }
    
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
    public Tipoexamenes getTipoexamenes() {
        return this.tipoexamenes;
    }
    
    public void setTipoexamenes(Tipoexamenes tipoexamenes) {
        this.tipoexamenes = tipoexamenes;
    }
    public String getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaRealizado() {
        return this.fechaRealizado;
    }
    
    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }




}


