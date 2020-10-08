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
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Labmedicinas;
import sv.edu.udb.entites.Medicamentos;

/**
 *
 * @author rgonz
 */
public class FarmaciaDAO {

    public List<Medicamentos> obtenerMedicamentos() {
        List<Medicamentos> empleados = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicamentos";
            Query query = ses.createQuery(queryString);
            empleados = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return empleados;
    }

    public void addMedicamento(Medicamentos medicina) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicamentos datos = new Medicamentos();
            datos.setIdMedicamento(medicina.getIdMedicamento());
            datos.setLabmedicinas(medicina.getLabmedicinas());
            datos.setNombre(medicina.getNombre());
            datos.setDescripcion(medicina.getDescripcion());
            datos.setMg(medicina.getMg());
            datos.setCantidadDisp(medicina.getCantidadDisp());
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

    public void deleteMedicamento(String idMedi) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicamentos medi = (Medicamentos) ses.get(Medicamentos.class, idMedi);
            ses.delete(medi);
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

    public void updateMedicamento(String idMedi, Medicamentos medicina) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicamentos datos = (Medicamentos) ses.load(Medicamentos.class, idMedi);
            datos.setIdMedicamento(medicina.getIdMedicamento());
            datos.setLabmedicinas(medicina.getLabmedicinas());
            datos.setNombre(medicina.getNombre());
            datos.setDescripcion(medicina.getDescripcion());
            datos.setMg(medicina.getMg());
            datos.setCantidadDisp(medicina.getCantidadDisp());

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

    public Medicamentos getMedicamentoID(String idmedi) {
        Medicamentos medicina = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicamentos where idMedicamento = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", idmedi);
            medicina = (Medicamentos) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }

        return medicina;
    }

    public Medicamentos getMedicamentoID1(String idmedi) {
        Medicamentos medicina = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Medicamentos where nombre = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", idmedi);
            medicina = (Medicamentos) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }

        return medicina;
    }

    public List<Labmedicinas> obtenerLab() {
        List<Labmedicinas> empleados = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Labmedicinas";
            Query query = ses.createQuery(queryString);
            empleados = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return empleados;
    }

    public void updateMedicamento1(String idMedi, Medicamentos medicina) {
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            Medicamentos datos = (Medicamentos) ses.load(Medicamentos.class, idMedi);
            datos.setCantidadDisp(medicina.getCantidadDisp());
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
}
