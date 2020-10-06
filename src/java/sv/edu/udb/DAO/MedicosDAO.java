/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import static java.lang.Math.log;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Medicos;
import sv.edu.udb.util.logger;

/**
 *
 * @author HP Probook
 */
public class MedicosDAO {

    public List<Medicos> getMedicosByArea(int idArea) {
        List<Medicos> medicos = new ArrayList<Medicos>();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicos where idArea=:idArea";
            Query query = ses.createQuery(queryString);
            query.setParameter("idArea", idArea);
            medicos = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return medicos;
    }

    public void addinfoMedico(Medicos medico) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicos datos = new Medicos();
            datos.setIdMedico(medico.getIdMedico());
            datos.setAreas(medico.getAreas());
            datos.setJvpm(medico.getJvpm());
            datos.setNombre(medico.getNombre());
            datos.setApellido(medico.getApellido());
            datos.setHoraIn(medico.getHoraIn());
            datos.setHoraOut(medico.getHoraOut());
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

    public List<Medicos> obtenerMedico() {
        List<Medicos> medico = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicos";
            Query query = ses.createQuery(queryString);
            medico = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return medico;
    }
    
     public void deleteMedicos(String id){
         
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicos medicos = (Medicos) ses.get(Medicos.class, id);
            ses.delete(medicos);
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
     
     public void updateMedico(String id, Medicos newMedico) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicos medicos = (Medicos) ses.load(Medicos.class, id);
            medicos.setIdMedico(newMedico.getIdMedico());
            medicos.setAreas(newMedico.getAreas());
            medicos.setJvpm(newMedico.getJvpm());
            medicos.setNombre(newMedico.getNombre());
            medicos.setApellido(newMedico.getApellido());
            medicos.setHoraIn(newMedico.getHoraIn());
            medicos.setHoraOut(newMedico.getHoraOut());

            ses.update(medicos);
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
     
      public Medicos getMedicos1(String id) {
        Medicos examenes = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicos where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", id);
            examenes = (Medicos) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return examenes;
  }
}
