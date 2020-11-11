package sv.edu.udb.entites;
// Generated 11-10-2020 10:37:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Medicos generated by hbm2java
 */
public class Medicos  implements java.io.Serializable {


     private String idMedico;
     private Areas areas;
     private String jvpm;
     private String nombre;
     private String apellido;
     private String horaIn;
     private String horaOut;
     private Set<Citas> citases = new HashSet<Citas>(0);

    public Medicos() {
    }

	
    public Medicos(String idMedico, Areas areas, String jvpm, String nombre, String apellido, String horaIn, String horaOut) {
        this.idMedico = idMedico;
        this.areas = areas;
        this.jvpm = jvpm;
        this.nombre = nombre;
        this.apellido = apellido;
        this.horaIn = horaIn;
        this.horaOut = horaOut;
    }
    public Medicos(String idMedico, Areas areas, String jvpm, String nombre, String apellido, String horaIn, String horaOut, Set<Citas> citases) {
       this.idMedico = idMedico;
       this.areas = areas;
       this.jvpm = jvpm;
       this.nombre = nombre;
       this.apellido = apellido;
       this.horaIn = horaIn;
       this.horaOut = horaOut;
       this.citases = citases;
    }
   
    public String getIdMedico() {
        return this.idMedico;
    }
    
    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }
    public Areas getAreas() {
        return this.areas;
    }
    
    public void setAreas(Areas areas) {
        this.areas = areas;
    }
    public String getJvpm() {
        return this.jvpm;
    }
    
    public void setJvpm(String jvpm) {
        this.jvpm = jvpm;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getHoraIn() {
        return this.horaIn;
    }
    
    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }
    public String getHoraOut() {
        return this.horaOut;
    }
    
    public void setHoraOut(String horaOut) {
        this.horaOut = horaOut;
    }
    public Set<Citas> getCitases() {
        return this.citases;
    }
    
    public void setCitases(Set<Citas> citases) {
        this.citases = citases;
    }




}


