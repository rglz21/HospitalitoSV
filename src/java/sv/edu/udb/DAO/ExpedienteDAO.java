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
import sv.edu.udb.entites.Expediente;
import sv.edu.udb.entites.HibernateUtil;

/**
 *
 * @author jonat
 */
public class ExpedienteDAO {
    
     //Metodo DAO para listar Diagnosticos del paciente
    public List<Expediente> obtenerExpdiente() {
        List<Expediente> expediente = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Expediente";
            Query query = ses.createQuery(queryString);
            expediente = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return expediente;
    }
}