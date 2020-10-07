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
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Sintomas;

/**
 *
 * @author HP Probook
 */
public class SintomasDAO {
    
    public List<Sintomas> getSintomasByPrediag(int idPrediag){
        List<Sintomas> sintomas=null;
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Sintomas where idPrediag = :idPrediag";
            Query query=ses.createQuery(queryString);
            query.setParameter("idPrediag", idPrediag);
            sintomas=query.list();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return sintomas;
    }
    
    public void addSintomas(Sintomas sintoma) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Sintomas datos = new Sintomas();
            datos.setIdSintoma(sintoma.getIdSintoma());
            datos.setPrediagnostico(sintoma.getPrediagnostico());
            datos.setSintoma(sintoma.getSintoma());
            datos.setDescripcion(sintoma.getDescripcion());
            datos.setDuracion(sintoma.getDuracion());
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
