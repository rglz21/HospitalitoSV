package sv.edu.udb.entites;
// Generated 09-20-2020 11:06:04 AM by Hibernate Tools 4.3.1



/**
 * Medicina generated by hbm2java
 */
public class Medicina  implements java.io.Serializable {


     private String idMedicina;
     private Recetas recetas;
     private String nombre;
     private int cantidad;
     private String dosis;
     private String mg;

    public Medicina() {
    }

    public Medicina(String idMedicina, Recetas recetas, String nombre, int cantidad, String dosis, String mg) {
       this.idMedicina = idMedicina;
       this.recetas = recetas;
       this.nombre = nombre;
       this.cantidad = cantidad;
       this.dosis = dosis;
       this.mg = mg;
    }
   
    public String getIdMedicina() {
        return this.idMedicina;
    }
    
    public void setIdMedicina(String idMedicina) {
        this.idMedicina = idMedicina;
    }
    public Recetas getRecetas() {
        return this.recetas;
    }
    
    public void setRecetas(Recetas recetas) {
        this.recetas = recetas;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getDosis() {
        return this.dosis;
    }
    
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    public String getMg() {
        return this.mg;
    }
    
    public void setMg(String mg) {
        this.mg = mg;
    }




}


