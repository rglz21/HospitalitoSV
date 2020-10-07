/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Medicamentos;
import sv.edu.udb.entites.Medicina;

/**
 *
 * @author HP Probook
 */
public class MedicinaDAO {
    public List<Medicina> getMedicinasByReceta(int idReceta){
        List<Medicina> medicinas=new ArrayList<Medicina>();
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Medicinas where idReceta= :idRec";
            Query query=ses.createQuery(queryString);
            query.setParameter("idRec", idReceta);
            medicinas=query.list();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return medicinas;
    }
    // para farmacias
    public Medicina getMedicinasByReceta1(int idReceta){
        Medicina medicinas=new Medicina();
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Medicina where idReceta= :idRec";
            Query query=ses.createQuery(queryString);
            query.setParameter("idRec", idReceta);
            medicinas=(Medicina) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return medicinas;
    }
    public void insertMedicina(Medicina medicina){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicina datos = new Medicina();
            datos.setIdMedicina(medicina.getIdMedicina());
            datos.setRecetas(medicina.getRecetas());
            datos.setNombre(medicina.getNombre());
            datos.setCantidad(medicina.getCantidad());
            datos.setDosis(medicina.getDosis());
            datos.setMg(medicina.getMg());
 
            ses.save(datos);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }
    
    public void updateMedicamento(String idMedi, Medicina medicina) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicina datos = (Medicina) ses.load(Medicina.class, idMedi);
            datos.setIdMedicina(medicina.getIdMedicina());
            datos.setRecetas(medicina.getRecetas());
            datos.setNombre(medicina.getNombre());
            datos.setCantidad(medicina.getCantidad());
            datos.setDosis(medicina.getDosis());
            datos.setMg(medicina.getMg());
 
            ses.update(datos);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }
    
       public Medicina getMedicinasByReceta1(String idReceta){
        Medicina medicinas=new Medicina();
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Medicina where idReceta= :idRec";
            Query query=ses.createQuery(queryString);
            query.setParameter("idRec", idReceta);
            medicinas=(Medicina) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return medicinas;
    }
}
