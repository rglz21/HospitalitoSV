package sv.edu.udb.entites;
// Generated 09-17-2020 11:02:11 PM by Hibernate Tools 4.3.1



/**
 * Farmacia generated by hbm2java
 */
public class Farmacia  implements java.io.Serializable {


     private int idFarma;
     private String horaA;
     private String horaC;

    public Farmacia() {
    }

    public Farmacia(int idFarma, String horaA, String horaC) {
       this.idFarma = idFarma;
       this.horaA = horaA;
       this.horaC = horaC;
    }
   
    public int getIdFarma() {
        return this.idFarma;
    }
    
    public void setIdFarma(int idFarma) {
        this.idFarma = idFarma;
    }
    public String getHoraA() {
        return this.horaA;
    }
    
    public void setHoraA(String horaA) {
        this.horaA = horaA;
    }
    public String getHoraC() {
        return this.horaC;
    }
    
    public void setHoraC(String horaC) {
        this.horaC = horaC;
    }




}


