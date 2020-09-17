package sv.edu.udb.entites;
// Generated 16-sep-2020 19:45:19 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipoexamenes generated by hbm2java
 */
public class Tipoexamenes  implements java.io.Serializable {


     private int idTipo;
     private String tipo;
     private Set<Examenes> exameneses = new HashSet<Examenes>(0);

    public Tipoexamenes() {
    }

	
    public Tipoexamenes(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }
    public Tipoexamenes(int idTipo, String tipo, Set<Examenes> exameneses) {
       this.idTipo = idTipo;
       this.tipo = tipo;
       this.exameneses = exameneses;
    }
   
    public int getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Set<Examenes> getExameneses() {
        return this.exameneses;
    }
    
    public void setExameneses(Set<Examenes> exameneses) {
        this.exameneses = exameneses;
    }




}


