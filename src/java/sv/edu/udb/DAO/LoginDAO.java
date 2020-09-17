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
import sv.edu.udb.entites.Usuario;
import sv.edu.udb.entites.HibernateUtil;
/**
 *
 * @author rgonz
 */
public class LoginDAO {
    
     public void addUsuario(Usuario user) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
        Usuario datos = new Usuario();
        datos.setUsuario(user.getUsuario());
        datos.setNombre(user.getNombre());
        datos.setApellido(user.getApellido());
        datos.setContrasena(user.getContrasena());
        datos.setVerificar(user.getVerificar());
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
     
      public Usuario getUsuarioID(String user) {
        Usuario empleado = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Usuario where usuario = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", user);
            empleado = (Usuario) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }

        return empleado;
    }
}
