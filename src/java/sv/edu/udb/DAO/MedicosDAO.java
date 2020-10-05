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
import sv.edu.udb.entites.Medicos;

/**
 *
 * @author HP Probook
 */
public class MedicosDAO {
    
    public List<Medicos> getMedicosByArea(int idArea){
        List<Medicos> medicos=new ArrayList<Medicos>();
        SessionFactory sesFact= HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Medicos where idArea=:idArea";
            Query query=ses.createQuery(queryString);
            query.setParameter("idArea", idArea);
            medicos=query.list();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return medicos;
    }
    public Medicos getHoraMedico(String idMedico){
        Medicos medico=new Medicos();
        SessionFactory sesFact= HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Medicos where idMedico=:idMedico";
            Query query=ses.createQuery(queryString);
            query.setParameter("idMedico", idMedico);
            medico=(Medicos)query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return medico;
    }
}
