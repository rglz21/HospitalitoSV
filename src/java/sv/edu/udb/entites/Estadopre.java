package sv.edu.udb.entites;
// Generated 11-10-2020 10:37:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estadopre generated by hbm2java
 */
public class Estadopre  implements java.io.Serializable {


     private int idEstado;
     private String estado;
     private Set<Prediagnostico> prediagnosticos = new HashSet<Prediagnostico>(0);

    public Estadopre() {
    }

	
    public Estadopre(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }
    public Estadopre(int idEstado, String estado, Set<Prediagnostico> prediagnosticos) {
       this.idEstado = idEstado;
       this.estado = estado;
       this.prediagnosticos = prediagnosticos;
    }
   
    public int getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set<Prediagnostico> getPrediagnosticos() {
        return this.prediagnosticos;
    }
    
    public void setPrediagnosticos(Set<Prediagnostico> prediagnosticos) {
        this.prediagnosticos = prediagnosticos;
    }




}


