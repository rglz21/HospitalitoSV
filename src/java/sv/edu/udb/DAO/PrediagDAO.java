/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Prediagnostico;

/**
 *
 * @author HP Probook
 */
public class PrediagDAO {

    public Prediagnostico getPrediagPaciente(int idPrediag) {
        Prediagnostico prediag = new Prediagnostico();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Prediagnostico where idPrediag= :idPrediag";
            Query query = ses.createQuery(queryString);
            query.setParameter("idPrediag", idPrediag);
            prediag = (Prediagnostico) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return prediag;
    }

    public List<Prediagnostico> getPrediagByEstado(int idEstado) {
        List<Prediagnostico> prediag = new ArrayList<Prediagnostico>();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Prediagnostico where idEstado=:idEstado";
            Query query = ses.createQuery(queryString);
            query.setParameter("idEstado", idEstado);
            prediag = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return prediag;
    }
    public void cambiarEstado(Prediagnostico prediag){
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            Prediagnostico editPre=(Prediagnostico) ses.load(Prediagnostico.class, prediag.getIdPrediag());
            editPre.setIdPrediag(prediag.getIdPrediag());
            editPre.setEstadopre(prediag.getEstadopre());
            editPre.setPaciente(prediag.getPaciente());
            editPre.setFechaPre(prediag.getFechaPre());
            ses.update(editPre);
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
    public List<Prediagnostico> obtenerDiagnostico() {
        List<Prediagnostico> diagnosticos = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Prediagnostico";
            Query query = ses.createQuery(queryString);
            diagnosticos = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return diagnosticos;
    }
    
    public void addPrediagnostico(Prediagnostico prediag) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Prediagnostico datos = new Prediagnostico();
            datos.setIdPrediag(prediag.getIdPrediag());
            datos.setFechaPre(prediag.getFechaPre());
            datos.setPaciente(prediag.getPaciente());
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
}
