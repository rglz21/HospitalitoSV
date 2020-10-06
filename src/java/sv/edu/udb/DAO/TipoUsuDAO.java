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
import sv.edu.udb.entites.Tipousuario;

/**
 *
 * @author jonat
 */
public class TipoUsuDAO {
    
     public List<Tipousuario> getTipoUsu(){
        List<Tipousuario> tipoUsuario=null;
        SessionFactory sesFact=HibernateUtil.getSessionFactory();
        Session ses=sesFact.openSession();
        Transaction tra=null;
        try{
            tra=ses.beginTransaction();
            String queryString="FROM Tipousuario WHERE idtipo IN (2, 3, 4)";
            Query query=ses.createQuery(queryString);
            tipoUsuario=query.list();
        }catch(Exception e){
            e.printStackTrace();
            if(tra!=null){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }
        return tipoUsuario;
    }
}
