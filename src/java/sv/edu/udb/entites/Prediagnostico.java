package sv.edu.udb.entites;
// Generated 10-30-2020 09:21:46 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Prediagnostico generated by hbm2java
 */
public class Prediagnostico  implements java.io.Serializable {


     private int idPrediag;
     private Estadopre estadopre;
     private Paciente paciente;
     private Date fechaPre;
     private Set<Sintomas> sintomases = new HashSet<Sintomas>(0);

    public Prediagnostico() {
    }

	
    public Prediagnostico(int idPrediag, Estadopre estadopre, Paciente paciente, Date fechaPre) {
        this.idPrediag = idPrediag;
        this.estadopre = estadopre;
        this.paciente = paciente;
        this.fechaPre = fechaPre;
    }
    public Prediagnostico(int idPrediag, Estadopre estadopre, Paciente paciente, Date fechaPre, Set<Sintomas> sintomases) {
       this.idPrediag = idPrediag;
       this.estadopre = estadopre;
       this.paciente = paciente;
       this.fechaPre = fechaPre;
       this.sintomases = sintomases;
    }
   
    public int getIdPrediag() {
        return this.idPrediag;
    }
    
    public void setIdPrediag(int idPrediag) {
        this.idPrediag = idPrediag;
    }
    public Estadopre getEstadopre() {
        return this.estadopre;
    }
    
    public void setEstadopre(Estadopre estadopre) {
        this.estadopre = estadopre;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Date getFechaPre() {
        return this.fechaPre;
    }
    
    public void setFechaPre(Date fechaPre) {
        this.fechaPre = fechaPre;
    }
    public Set<Sintomas> getSintomases() {
        return this.sintomases;
    }
    
    public void setSintomases(Set<Sintomas> sintomases) {
        this.sintomases = sintomases;
    }




}


