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

    // lo cambie un poco para filtrar los id recetas que no se haya reclamado, esto en farmacia
    public List<Medicina> getMedicinasByReceta(int idReceta) {
        List<Medicina> medicinas = new ArrayList<Medicina>();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicina where idReceta= :idRec and estado != :estado";
            Query query = ses.createQuery(queryString);
            query.setParameter("idRec", idReceta);
            query.setParameter("estado","Reclamado");
            medicinas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return medicinas;
    }

    // para farmacias
    public Medicina getMedicinasByReceta1(int idReceta) {
        Medicina medicinas = new Medicina();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicina where idReceta= :idRec";
            Query query = ses.createQuery(queryString);
            query.setParameter("idRec", idReceta);
            medicinas = (Medicina) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return medicinas;
    }
    public Medicina getMedicina(String idMedicina) {
        Medicina medicinas = new Medicina();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicina where idMedicina= :idMedicina";
            Query query = ses.createQuery(queryString);
            query.setParameter("idMedicina", idMedicina);
            medicinas = (Medicina) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return medicinas;
    }
    public Medicina getMedicinaByNombre(String Nombre, int idReceta) {
        Medicina medicinas = new Medicina();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicina where nombre= :nombre and idReceta=:idReceta";
            Query query = ses.createQuery(queryString);
            query.setParameter("nombre", Nombre);
            query.setParameter("idReceta", idReceta);
            medicinas = (Medicina) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return medicinas;
    }

    public void insertMedicina(Medicina medicina) {
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
            datos.setEstado("Recetada");
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
    
     public void updateEstadoMedicamento(String idMedi, Medicina medicina) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicina datos = (Medicina) ses.load(Medicina.class, idMedi);
            datos.setEstado(medicina.getEstado());
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

    public Medicina getMedicinasByReceta1(String idReceta) {
        Medicina medicinas = new Medicina();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicina where idMedicina= :idRec";
            Query query = ses.createQuery(queryString);
            query.setParameter("idRec", idReceta);
            medicinas = (Medicina) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return medicinas;
    }
    public void deleteMedicina(String idMedicina) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicina med = (Medicina) ses.get(Medicina.class, idMedicina);
            ses.delete(med);
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
}
