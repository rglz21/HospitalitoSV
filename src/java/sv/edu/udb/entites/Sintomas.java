package sv.edu.udb.entites;
// Generated 11-10-2020 10:37:52 PM by Hibernate Tools 4.3.1



/**
 * Sintomas generated by hbm2java
 */
public class Sintomas  implements java.io.Serializable {


     private int idSintoma;
     private Prediagnostico prediagnostico;
     private String sintoma;
     private String descripcion;
     private String duracion;

    public Sintomas() {
    }

    public Sintomas(int idSintoma, Prediagnostico prediagnostico, String sintoma, String descripcion, String duracion) {
       this.idSintoma = idSintoma;
       this.prediagnostico = prediagnostico;
       this.sintoma = sintoma;
       this.descripcion = descripcion;
       this.duracion = duracion;
    }
   
    public int getIdSintoma() {
        return this.idSintoma;
    }
    
    public void setIdSintoma(int idSintoma) {
        this.idSintoma = idSintoma;
    }
    public Prediagnostico getPrediagnostico() {
        return this.prediagnostico;
    }
    
    public void setPrediagnostico(Prediagnostico prediagnostico) {
        this.prediagnostico = prediagnostico;
    }
    public String getSintoma() {
        return this.sintoma;
    }
    
    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDuracion() {
        return this.duracion;
    }
    
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }




}


