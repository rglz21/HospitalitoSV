/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Recetas;
import sv.edu.udb.util.logger;

/**
 *
 * @author HP Probook
 */
public class RecetasDAO {

    logger log = new logger();

    public List<Recetas> getRecetasByMedico(String idMedico) throws IOException {
        List<Recetas> recetas = new ArrayList<Recetas>();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Recetas where idMedico=:idMedico";
            Query query = ses.createQuery(queryString);
            query.setParameter("idMedico", idMedico);
            recetas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            log.InfoLog(e + "", "ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return recetas;
    }

    public void insertReceta(Recetas receta) throws IOException {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Recetas newRec = new Recetas();
            newRec.setIdReceta(receta.getIdReceta());
            newRec.setMedicos(receta.getMedicos());
            newRec.setPaciente(receta.getPaciente());
            ses.save(newRec);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            log.InfoLog(e + "", "ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }

    public Recetas obtenerReceta(int idReceta) throws IOException {
        Recetas receta = new Recetas();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Recetas where idReceta=:idReceta";
            Query query = ses.createQuery(queryString);
            query.setParameter("idReceta", idReceta);
            receta = (Recetas) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            log.InfoLog(e + "", "ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return receta;
    }

    public void updateReceta(int idReceta, Recetas receta) throws IOException {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Recetas editRecet = (Recetas) ses.load(Recetas.class, idReceta);
            editRecet.setIdReceta(receta.getIdReceta());
            editRecet.setMedicos(receta.getMedicos());
            editRecet.setPaciente(receta.getPaciente());
            editRecet.setMedicinas(receta.getMedicinas());
            ses.update(editRecet);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //log.InfoLog(e+"","ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }
}
