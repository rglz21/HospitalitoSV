/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.io.IOException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
            log.InfoLog(e + "", "ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }

    public void addUsuarioGeneral(Usuario user) throws IOException {
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
            log.InfoLog(e + "", "ERROR");
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
            log.InfoLog(e + "", "ERROR");
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
    }

    public List<Usuario> getUsuario() {
        List<Usuario> areas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Usuario";
            Query query = ses.createQuery(queryString);
            areas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return areas;
    }

    public void deleteUsuario(String id) {

        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Usuario medicos = (Usuario) ses.get(Usuario.class, id);
            ses.delete(medicos);
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

    public void updateUsuario(String id, Usuario newUsuario) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Usuario usuario = (Usuario) ses.load(Usuario.class, id);
            usuario.setUsuario(newUsuario.getUsuario());
            usuario.setContrasena(newUsuario.getContrasena());
            usuario.setCorreo(newUsuario.getCorreo());
            usuario.setTipousuario(newUsuario.getTipousuario());
            usuario.setVerificar(newUsuario.getVerificar());

            ses.update(usuario);
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

    public Usuario getUsuario1(String id) {
        Usuario examenes = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Usuario where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", id);
            examenes = (Usuario) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return examenes;
    }
}
