/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Recetas;

/**
 *
 * @author HP Probook
 */
public class RecetasDAO {
    
    public void insertReceta(Recetas receta){
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            Recetas newRec=new Recetas();
            newRec.setIdReceta(receta.getIdReceta());
            newRec.setMedicos(receta.getMedicos());
            newRec.setPaciente(receta.getPaciente());
            ses.save(newRec);
            ses.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
    }
    public Recetas obtenerReceta(int idReceta){
        Recetas receta=new Recetas();
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Recetas where idReceta=:idReceta";
            Query query=ses.createQuery(queryString);
            query.setParameter("idReceta", idReceta);
            receta=(Recetas) query.uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return receta;
    }
    public void updateReceta(int idReceta, Recetas receta){
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            Recetas editRecet=(Recetas)ses.load(Recetas.class, idReceta);
            editRecet.setIdReceta(receta.getIdReceta());
            editRecet.setMedicos(receta.getMedicos());
            editRecet.setPaciente(receta.getPaciente());
            editRecet.setMedicinas(receta.getMedicinas());
            ses.update(editRecet);
            ses.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
    }
}
