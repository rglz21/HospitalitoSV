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
import sv.edu.udb.entites.Areas;
import sv.edu.udb.entites.HibernateUtil;

/**
 *
 * @author HP Probook
 */
public class AreasDAO {
    
    public List<Areas> getAreas(){
        List<Areas> areas=null;
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="from Areas";
            Query query=ses.createQuery(queryString);
            areas=query.list();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return areas;
    }
}