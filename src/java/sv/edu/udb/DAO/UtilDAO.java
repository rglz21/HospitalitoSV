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

    public int contarString(String entidad, String idName) {
        int cont2 = 0;
        String top;
        String[] split;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "SELECT "+idName+" FROM " + entidad +" ORDER BY "+idName+" DESC";
            Query query = ses.createQuery(queryString);
            query.setMaxResults(1);
            top = (String) query.uniqueResult();
            split = top.split("-");
            cont2=Integer.parseInt(split[1]);
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
    public int contarString1(String entidad, String idName) {
        int cont2 = 0;
        String top;
        String[] split;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "SELECT "+idName+" FROM " + entidad +" ORDER BY "+idName+" DESC";
            Query query = ses.createQuery(queryString);
            query.setMaxResults(1);
            top = (String) query.uniqueResult();
            cont2=Integer.parseInt(top);
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
    public int contar(String entidad, String idName) {
        int cont2 = 0;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "SELECT "+idName+" FROM " + entidad +" ORDER BY "+idName+" DESC";
            Query query = ses.createQuery(queryString);
            query.setMaxResults(1);
            cont2 = (int) query.uniqueResult();
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
