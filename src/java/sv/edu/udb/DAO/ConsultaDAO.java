/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.Consulta;
import sv.edu.udb.entites.HibernateUtil;

/**
 *
 * @author HP Probook
 */
public class ConsultaDAO {
     public void addConsulta(Consulta con) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Consulta datos = new Consulta();
            datos.setIdConsulta(con.getIdConsulta());
            datos.setExpediente(con.getExpediente());
            datos.setDescripcion(con.getDescripcion());
            datos.setFecha(con.getFecha());
            datos.setDiagnostico(con.getDiagnostico());
            datos.setIdMedico(con.getIdMedico());
            datos.setIdCita(con.getIdCita());
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
    public List<Consulta> ObtenerConsulta(int idCita) {
        List<Consulta> citas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Consulta where idCita = :idCita";
            Query query = ses.createQuery(queryString);
            query.setParameter("idCita", idCita);
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
    public Consulta ObtenerConsultaByCita (int idCita) {
        Consulta con = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Consulta where idCita = :idCita";
            Query query = ses.createQuery(queryString);
            query.setParameter("idCita", idCita);
            con = (Consulta)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return con;
    }
}
