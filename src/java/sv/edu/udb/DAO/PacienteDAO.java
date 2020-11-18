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
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Paciente;

/**
 *
 * @author jonat
 */
public class PacienteDAO {

    //Metodo DAO para listar Diagnosticos del paciente
    public List<Paciente> obtenerPaciente() {
        List<Paciente> paciente = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Paciente";
            Query query = ses.createQuery(queryString);
            paciente = query.list();

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
    //EXPEDIENTE 
    
  public List<Paciente> ObtenerCitas( String idPaciente) {
        List<Paciente> paciente = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Paciente where idPaciente=:idPac";
            Query query = ses.createQuery(queryString);
            query.setParameter("idPac", idPaciente);
            paciente = query.list();

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
  public List<Paciente> ObtenerExamenes( String idCita) {
        List<Paciente> paciente = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Examenes where idCita=:idPac";
            Query query = ses.createQuery(queryString);
            query.setParameter("idPac", idCita);
            paciente = query.list();

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

    public Paciente obtenerPacienteById(String idPaciente) {
        Paciente paciente = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Paciente where idPaciente=:idPac";
            Query query = ses.createQuery(queryString);
            query.setParameter("idPac", idPaciente);
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
}
