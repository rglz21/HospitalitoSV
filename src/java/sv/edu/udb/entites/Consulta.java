package sv.edu.udb.entites;
// Generated 09-20-2020 11:06:04 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Consulta generated by hbm2java
 */
public class Consulta  implements java.io.Serializable {


     private String idConsulta;
     private Expediente expediente;
     private String descripcion;
     private Date fecha;
     private String diagnostico;

    public Consulta() {
    }

    public Consulta(String idConsulta, Expediente expediente, String descripcion, Date fecha, String diagnostico) {
       this.idConsulta = idConsulta;
       this.expediente = expediente;
       this.descripcion = descripcion;
       this.fecha = fecha;
       this.diagnostico = diagnostico;
    }
   
    public String getIdConsulta() {
        return this.idConsulta;
    }
    
    public void setIdConsulta(String idConsulta) {
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




}


