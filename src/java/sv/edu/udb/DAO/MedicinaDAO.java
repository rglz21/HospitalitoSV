/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Medicina;

/**
 *
 * @author HP Probook
 */
public class MedicinaDAO {
    public List<Medicina> getMedicinasByReceta(int idReceta){
        List<Medicina> medicinas=new ArrayList<Medicina>();
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Medicinas where idReceta= :idRec";
            Query query=ses.createQuery(queryString);
            query.setParameter("idRec", idReceta);
            medicinas=query.list();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return medicinas;
    }
}
