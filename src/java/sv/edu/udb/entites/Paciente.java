package sv.edu.udb.entites;
// Generated 11-10-2020 10:37:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Paciente generated by hbm2java
 */
public class Paciente  implements java.io.Serializable {


     private String idPaciente;
     private String nombre;
     private String apellido;
     private String dui;
     private String telefono;
     private String direccion;
     private Set<Prediagnostico> prediagnosticos = new HashSet<Prediagnostico>(0);
     private Set<Citas> citases = new HashSet<Citas>(0);
     private Set<Expediente> expedientes = new HashSet<Expediente>(0);

    public Paciente() {
    }

	
    public Paciente(String idPaciente, String nombre, String apellido, String dui, String telefono, String direccion) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Paciente(String idPaciente, String nombre, String apellido, String dui, String telefono, String direccion, Set<Prediagnostico> prediagnosticos, Set<Citas> citases, Set<Expediente> expedientes) {
       this.idPaciente = idPaciente;
       this.nombre = nombre;
       this.apellido = apellido;
       this.dui = dui;
       this.telefono = telefono;
       this.direccion = direccion;
       this.prediagnosticos = prediagnosticos;
       this.citases = citases;
       this.expedientes = expedientes;
    }
   
    public String getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
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
    public String getDui() {
        return this.dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set<Prediagnostico> getPrediagnosticos() {
        return this.prediagnosticos;
    }
    
    public void setPrediagnosticos(Set<Prediagnostico> prediagnosticos) {
        this.prediagnosticos = prediagnosticos;
    }
    public Set<Citas> getCitases() {
        return this.citases;
    }
    
    public void setCitases(Set<Citas> citases) {
        this.citases = citases;
    }
    public Set<Expediente> getExpedientes() {
        return this.expedientes;
    }
    
    public void setExpedientes(Set<Expediente> expedientes) {
        this.expedientes = expedientes;
    }




}


