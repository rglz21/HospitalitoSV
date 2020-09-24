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
import sv.edu.udb.entites.Paciente;

/**
 *
 * @author jonat
 */
public class PacienteDAO {

    //Metodo DAO para listar Diagnosticos del paciente
    public List<Paciente> obtenerPaciente() {
        List<Paciente> paciente = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra = ses.beginTransaction();
            String queryString = "from Paciente";
            Query query = ses.createQuery(queryString);
            paciente = query.list();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tra != null) {
                tra.rollback();
            }
        } finally {
            ses.flush();
            ses.close();
        }
        return paciente;
    }
}
