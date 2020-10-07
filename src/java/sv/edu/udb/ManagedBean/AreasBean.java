/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sv.edu.udb.DAO.AreasDAO;
import sv.edu.udb.entites.Areas;

/**
 *
 * @author HP Probook
 */
@ManagedBean
@RequestScoped
public class AreasBean {
     private int idArea;
     private String area;
    /**
     * Creates a new instance of AreasBean
     */
    public AreasBean() {
    }
     
    public List<Areas>getAreas(){
        AreasDAO areasDao=new AreasDAO();
        List<Areas> lista=areasDao.getAreas();
        return lista;
    }
    
    /**
     * @return the idArea
     */
    public int getIdArea() {
        return idArea;
    }

    /**
     * @param idArea the idArea to set
     */
    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    
}
