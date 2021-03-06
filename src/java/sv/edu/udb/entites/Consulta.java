package sv.edu.udb.entites;
// Generated 11-10-2020 10:37:52 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Consulta generated by hbm2java
 */
public class Consulta  implements java.io.Serializable {


     private int idConsulta;
     private Expediente expediente;
     private String descripcion;
     private Date fecha;
     private String diagnostico;
     private String idMedico;
     private int idCita;

    public Consulta() {
    }

    public Consulta(int idConsulta, Expediente expediente, String descripcion, Date fecha, String diagnostico, String idMedico, int idCita) {
       this.idConsulta = idConsulta;
       this.expediente = expediente;
       this.descripcion = descripcion;
       this.fecha = fecha;
       this.diagnostico = diagnostico;
       this.idMedico = idMedico;
       this.idCita = idCita;
    }
   
    public int getIdConsulta() {
        return this.idConsulta;
    }
    
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    public Expediente getExpediente() {
        return this.expediente;
    }
    
    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getIdMedico() {
        return this.idMedico;
    }
    
    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }
    public int getIdCita() {
        return this.idCita;
    }
    
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }




}


