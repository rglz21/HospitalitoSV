/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.Areas;
import sv.edu.udb.entites.HibernateUtil;

/**
 *
 * @author HP Probook
 */
public class AreasDAO {
    
    public List<Areas> getAreas(){
        List<Areas> areas=null;
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Areas";
            Query query=ses.createQuery(queryString);
            areas=query.list();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return areas;
    }
    
     public void addAreas(Areas area) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Areas datos = new Areas();
            datos.setIdArea(area.getIdArea());
            datos.setNombre(area.getNombre());
            datos.setClinica(area.getClinica());
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
     
     public void deleteAreas(int id) {

        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Areas areas = (Areas) ses.get(Areas.class, id);
            ses.delete(areas);
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

    public void updateAreas(int id, Areas newArea) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Areas areas = (Areas) ses.load(Areas.class, id);
            areas.setIdArea(newArea.getIdArea());
            areas.setClinica(newArea.getClinica());
            areas.setNombre(newArea.getNombre());

            ses.update(areas);
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

    public Areas getAreas1(int id) {
        Areas areas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Areas where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", id);
            areas = (Areas) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return areas;
    }
}
