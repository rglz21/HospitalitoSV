/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Usuario;
import sv.edu.udb.util.logger;

/**
 *
 * @author rgonz
 */
public class RegistroDAO {
     logger log = new logger();
    
      public void addUsuario(Usuario user) throws IOException {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
        Usuario datos = new Usuario();
        datos.setUsuario(user.getUsuario());
        datos.setContrasena(user.getContrasena());
        datos.setCorreo(user.getCorreo());
        datos.setTipousuario(user.getTipousuario());
        datos.setVerificar(user.getVerificar());
            ses.save(datos);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
             log.InfoLog(e+"","ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }
    
        public void addInformacion(Paciente nuevo) throws IOException {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
        Paciente datos = new Paciente();
        datos.setIdPaciente(nuevo.getIdPaciente());
        datos.setNombre(nuevo.getNombre());
        datos.setApellido(nuevo.getApellido());
        datos.setDui(nuevo.getDui());
        datos.setTelefono(nuevo.getTelefono());
        datos.setDireccion(nuevo.getDireccion());
            ses.save(datos);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
             log.InfoLog(e+"","ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }
}
