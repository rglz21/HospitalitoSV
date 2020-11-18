/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.DAO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sv.edu.udb.entites.Citas;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Paciente;

/**
 *
 * @author HP Probook
 */
public class CitasDAO {

      public List<Citas> getCitasB(String estado) {
        List<Citas> citas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas where estado = :estado";
            Query query = ses.createQuery(queryString);
            query.setParameter("estado", estado);
            citas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return citas;
    }
      
    public List<Citas> getCitasByMedico(String idMedico) {
        List<Citas> citas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            LocalDateTime fecha1 = LocalDateTime.now().withHour(0);
            LocalDateTime fecha2 = LocalDateTime.now().withHour(23);
            DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
            String queryString = "from Citas where idMedico = :idMedico and Fecha between :fecha1 and :fecha2";
            Query query = ses.createQuery(queryString);
            query.setParameter("idMedico", idMedico);
            query.setParameter("fecha1", fecha1.format(isoFecha));
            query.setParameter("fecha2", fecha2.format(isoFecha));
            citas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return citas;
    }
    public List<Citas> getCitasPerdidas(String idMedico) {
        List<Citas> citas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            LocalDateTime fecha1 = LocalDateTime.now().withHour(0);
            DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
            String queryString = "from Citas where idMedico = :idMedico and Fecha < :fecha1 and estado=:estado";
            Query query = ses.createQuery(queryString);
            query.setParameter("idMedico", idMedico);
            query.setParameter("fecha1", fecha1.format(isoFecha));
            query.setParameter("estado", "No abierta");
            citas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return citas;
    }

    public List<Citas> getCitasByPaciente1(String idPaciente) {
        List<Citas> citas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas where idPaciente = :idPaciente";
            Query query = ses.createQuery(queryString);
            query.setParameter("idPaciente", idPaciente);
            citas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return citas;
    }

    public void addCita(Citas cita) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Citas datos = new Citas();
            datos.setIdCita(cita.getIdCita());
            datos.setMedicos(cita.getMedicos());
            datos.setPaciente(cita.getPaciente());
            datos.setFecha(cita.getFecha());
            datos.setHora(cita.getHora());
            datos.setEstado(cita.getEstado());
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

    public Citas obtenerCita(int idCita) {
        Citas cita = new Citas();
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas where idCita= :idCita";
            Query query = ses.createQuery(queryString);
            query.setParameter("idCita", idCita);
            cita = (Citas) query.uniqueResult();
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
        return cita;
    }


     public List<Citas> obtenerDoctorByCitas(String idMedico) {
         List<Citas> cita = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas where idMedico= :idMedico";
            Query query = ses.createQuery(queryString);
            query.setParameter("idMedico", idMedico);
            cita =  query.list();
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
        return cita;
    }

    
    public void updateCita(int idCita, Citas cita) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Citas datos = (Citas) ses.load(Citas.class, idCita);
            datos.setIdCita(cita.getIdCita());
            datos.setMedicos(cita.getMedicos());
            datos.setPaciente(cita.getPaciente());
            datos.setFecha(cita.getFecha());
            datos.setHora(cita.getHora());
            datos.setEstado(cita.getEstado()); 
            
            ses.update(datos);
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
public List<Citas> getCitasByPacientes(String idPacientes) {
        List<Citas> citas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Citas where idPaciente = :idPaciente";
            Query query = ses.createQuery(queryString);
            query.setParameter("idPaciente", idPacientes);
            citas = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return citas;
    }
}

//p
