/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.DAO.FarmaciaDAO;
import sv.edu.udb.DAO.MedicinaDAO;
import sv.edu.udb.entites.Labmedicinas;
import sv.edu.udb.entites.Medicamentos;
import sv.edu.udb.entites.Medicina;
import sv.edu.udb.entites.Recetas;

/**
 *
 * @author rgonz
 */
@ManagedBean
@RequestScoped
public class FarmaciaBean {
 
    // Tabla Medicamento
    private String idMedicamento;
    private Labmedicinas labmedicinas;
    private int lab;
    private String nombre;
    private String descripcion;
    private String mg;
    private int cantidadDisp;
   // tabla Receta
     private String idMedicina;
     private Recetas recetas;
     private int receta;
     private String nombre1;
     private int cantidad;
     private String dosis;
     private String mg1;

    /**
     * Creates a new instance of FarmaciaBean
     */
    public FarmaciaBean() {
    }
       public String addPro() {
        FarmaciaDAO farmaciaDao = new FarmaciaDAO();
        Labmedicinas nuevo = new Labmedicinas();
        nuevo.setIdLabMed(lab);
        Medicamentos farmacia = new Medicamentos(idMedicamento, nuevo, nombre,descripcion, mg,cantidadDisp);
        farmaciaDao.addMedicamento(farmacia);
        return "indexFarmacia";
    }

    public List<Medicamentos> getMedicina() {
        FarmaciaDAO mediDao = new FarmaciaDAO();
        List<Medicamentos> lista = mediDao.obtenerMedicamentos();
        return lista;
    }
    
      public String returnMediId(String id) {
        FarmaciaDAO farmaciaDao = new FarmaciaDAO();
        Medicamentos farmacia = farmaciaDao.getMedicamentoID(id);

        if (farmacia != null) {

            setIdMedicamento(farmacia.getIdMedicamento());
            setLab(farmacia.getLabmedicinas().getIdLabMed());
            setNombre(farmacia.getNombre());
            setDescripcion(farmacia.getDescripcion());
            setMg(farmacia.getMg());
            setCantidadDisp(farmacia.getCantidadDisp());
          
        } else {
            setIdMedicamento("");
            setLabmedicinas(null);
            setNombre("");
            setDescripcion("");
            setMg("");
            setCantidadDisp(0);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medica NO Encontrada"));
        }
        return "infoMedicina";
    }

        public List<Labmedicinas> getLaboratorio() {
        FarmaciaDAO producto = new FarmaciaDAO();
        List<Labmedicinas> lista = producto.obtenerLab();
        return lista;
    }
        
        public String updateMedicina() {
        FarmaciaDAO farmaciaDao = new FarmaciaDAO();
        Medicamentos obtfarmacia = farmaciaDao.getMedicamentoID(getIdMedicamento());

        if (obtfarmacia != null) {
            
            Labmedicinas nuevo = new Labmedicinas();
            nuevo.setIdLabMed(lab);
            Medicamentos farmacia = new Medicamentos(idMedicamento, nuevo, nombre,descripcion, mg,cantidadDisp);

            farmaciaDao.updateMedicamento(getIdMedicamento(), farmacia);
//            obtfarmacia = farmaciaDao.getMedicamentoID(getIdMedicamento());
//            setIdMedicamento(obtfarmacia.getIdMedicamento());
//            setLab(obtfarmacia.getLabmedicinas().getIdLabMed());
//            setNombre(obtfarmacia.getNombre());
//            setDescripcion(obtfarmacia.getDescripcion());
//            setMg(obtfarmacia.getMg());
//            setCantidadDisp(obtfarmacia.getCantidadDisp());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medicamento con ID " + getIdMedicamento() + " Actualizado"));
        } else {
           setIdMedicamento("");
            setLabmedicinas(null);
            setNombre("");
            setDescripcion("");
            setMg("");
            setCantidadDisp(0);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medicamento con ID " + getIdMedicamento() + " NO encontrado"));
        }

        return "indexFarmacia";

    }
    // para mostrar las receta segun el id
        public void returnReceta(int id) {
        MedicinaDAO medicinaDao = new MedicinaDAO();
        Medicina farmacia1 = medicinaDao.getMedicinasByReceta1(id);

        if (farmacia1 != null) {

    Medicina farmacia = medicinaDao.getMedicinasByReceta1(id);
           
            setIdMedicina(farmacia.getIdMedicina());
            setReceta(farmacia.getRecetas().getIdReceta());
            setNombre1(farmacia.getNombre());
            setCantidad(farmacia.getCantidad());
            setDosis(farmacia.getDosis());
            setMg1(farmacia.getMg());
          
        } else {
           setIdMedicina("");
            setReceta(0);
            setNombre1("");
            setCantidad(0);
            setDosis("");
            setMg1("");
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medica NO Encontrada"));
        }
      
    }
         public String updateMedi() {
        MedicinaDAO medicinaDao = new MedicinaDAO();
        Medicina obtfarmacia = medicinaDao.getMedicinasByReceta1(getIdMedicina());

        if (obtfarmacia != null) {
            
            Recetas nuevo = new Recetas();
            nuevo.setIdReceta(obtfarmacia.getRecetas().getIdReceta());
            Medicina medi = new Medicina(idMedicina, nuevo, nombre1,cantidad, dosis,mg1);
            medicinaDao.updateMedicamento(getIdMedicina(), medi);

      FacesContext.getCurrentInstance().addMessage(null,
              new FacesMessage("Receta con ID " + getIdMedicamento() + " Actualizado"));
        } else {
          
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Receta con ID " + getIdMedicamento() + " NO encontrado"));
        }

        return "indexFarmacia";

    }
         // para actualizar la cantidad disponible
         public String updateMedicina1() {
        FarmaciaDAO farmaciaDao = new FarmaciaDAO();
        MedicinaDAO medicinaDao = new MedicinaDAO();
        Medicamentos obtfarmacia = farmaciaDao.getMedicamentoID1(getNombre1());
        Medicina obtfarmacia1 = medicinaDao.getMedicinasByReceta1(getIdMedicina());

        if (obtfarmacia != null) {
         
            int nue=obtfarmacia.getCantidadDisp()- obtfarmacia1.getCantidad();
            Medicamentos farmacia = new Medicamentos(nue);

            farmaciaDao.updateMedicamento1(obtfarmacia.getIdMedicamento(), farmacia);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medicamento con Nombre " + getNombre1() + " Actualizado"));
        } else {
         
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medicamento con Nombre " + getNombre1() + " NO encontrado"));
        }

        return "indexFarmacia";

    }
           public String deleteEmpleado(String id) {
        FarmaciaDAO farmaciaDao = new FarmaciaDAO();
        Medicamentos empleado = farmaciaDao.getMedicamentoID(id);

        if (empleado != null) {
            farmaciaDao.deleteMedicamento(id);
           
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medicamento con ID " + id + " Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Medicamento con ID " + id + " NO encontrado"));
        }

        return "indexFarmacia";

    }
         
        public String buscar(){
        return "buscarReceta";
        }

    public int getReceta() {
        return receta;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

        
    public String getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(String idMedicina) {
        this.idMedicina = idMedicina;
    }

    public Recetas getRecetas() {
        return recetas;
    }

    public void setRecetas(Recetas recetas) {
        this.recetas = recetas;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getMg1() {
        return mg1;
    }

    public void setMg1(String mg1) {
        this.mg1 = mg1;
    }
      
    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }
    
    public String getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(String idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Labmedicinas getLabmedicinas() {
        return labmedicinas;
    }

    public void setLabmedicinas(Labmedicinas labmedicinas) {
        this.labmedicinas = labmedicinas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public int getCantidadDisp() {
        return cantidadDisp;
    }

    public void setCantidadDisp(int cantidadDisp) {
        this.cantidadDisp = cantidadDisp;
    }

     
}
