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
import sv.edu.udb.entites.Citas;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Paciente;

/**
 *
 * @author HP Probook
 */
public class CitasDAO {

    public List<Citas> getCitasByMedico(String idMedico) {
        List<Citas> citas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas where idMedico = :idMedico";
            Query query = ses.createQuery(queryString);
            query.setParameter("idMedico", idMedico);
            citas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return citas;
    }

    public void addCita(Citas cita) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Citas datos = new Citas();
            datos.setMedicos(cita.getMedicos());
            datos.setPaciente(cita.getPaciente());
            datos.setFecha(cita.getFecha());
            datos.setHora(cita.getHora());
            datos.setExamen(cita.getExamen());
            datos.setTipExamen(cita.getTipExamen());
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

    public Citas obtenerCita(int idCita) {
        Citas cita = new Citas();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas where idCita= :idCita";
            Query query = ses.createQuery(queryString);
            query.setParameter("idCita", idCita);
            cita = (Citas) query.uniqueResult();
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
        return cita;
    }

    public void updateCita(int idCita, Citas cita) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            Citas editCita = (Citas) ses.load(Citas.class, idCita);
            editCita.setFecha(cita.getFecha());
            editCita.setHora(cita.getHora());
            editCita.setExamen(cita.getExamen());
            editCita.setTipExamen(cita.getTipExamen());
            ses.update(editCita);
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

    //Metodo DAO para listar Diagnosticos del paciente
    public List<Citas> obtenerCitas() {
        List<Citas> cita = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas";
            Query query = ses.createQuery(queryString);
            cita = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return cita;
    }
}
