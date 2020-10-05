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
import sv.edu.udb.entites.Tipoexamenes;

/**
 *
 * @author jonat
 */
public class ExamenesDAO {
    
    public List<Examenes> obtenerExamen() {
        List<Examenes> examen = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Examenes";
            Query query = ses.createQuery(queryString);
            examen = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return examen;
    }
    public List<Tipoexamenes> obtenerTipos(){
        List<Tipoexamenes> tipoExamen = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Tipoexamenes";
            Query query = ses.createQuery(queryString);
            tipoExamen = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return tipoExamen;
    }
}
