/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;

/**
 *
 * @author HP Probook
 */
public class UtilDAO {

    public int contar(String entidad) {
        int cont2 = 0;
        Long cont;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "select count(*) from " + entidad;
            Query query = ses.createQuery(queryString);
            cont = (Long) query.uniqueResult();
            cont2 = cont.intValue();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }

        return cont2;
    }
}
