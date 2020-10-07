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
import sv.edu.udb.entites.Examenes;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Laboratorio;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Tipoexamenes;

/**
 *
 * @author javie
 */
public class ExamenDAO {

    public List<Examenes> obtener() {
        List<Examenes> examanes = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Examenes ";
            Query query = ses.createQuery(queryString);
            examanes = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return examanes;
    }

    public void addExamenes(Examenes examanes) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Examenes datos = new Examenes();
            datos.setIdPaciente(examanes.getIdPaciente());
            datos.setTipoexamenes(examanes.getTipoexamenes());
            datos.setIdExam(examanes.getIdExam());
            datos.setFechaRealizado(examanes.getFechaRealizado());
            datos.setDescripcion(examanes.getDescripcion());
            datos.setLaboratorio(examanes.getLaboratorio());

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

    public void deleteExamenes(String id) {

        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Examenes examanes = (Examenes) ses.get(Examenes.class, id);
            ses.delete(examanes);
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

    public void updateExamenes(String id, Examenes newExamenes) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Examenes examenes = (Examenes) ses.load(Examenes.class, id);
            examenes.setIdExam(newExamenes.getIdExam());
            examenes.setIdPaciente(newExamenes.getIdPaciente());
            examenes.setLaboratorio(newExamenes.getLaboratorio());
            examenes.setFechaRealizado(newExamenes.getFechaRealizado());
            examenes.setDescripcion(newExamenes.getDescripcion());
            examenes.setTipoexamenes(newExamenes.getTipoexamenes());

            ses.update(examenes);
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

    public Examenes getExamenes1(String id) {
        Examenes examenes = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Examenes where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", id);
            examenes = (Examenes) query.uniqueResult();
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
     
    public Paciente getPaciente(String id) {
        Paciente paciente = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Paciente where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", id);
            paciente = (Paciente) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }

        return paciente;
    }

    public List<Laboratorio> obtenerLab() {
        List<Laboratorio> lab = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Laboratorio";
            Query query = ses.createQuery(queryString);
            lab = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return lab;
    }

    public List<Tipoexamenes> obtenerExam() {
        List<Tipoexamenes> lab = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Tipoexamenes";
            Query query = ses.createQuery(queryString);
            lab = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return lab;
    }
    
}
