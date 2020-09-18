/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sv.edu.udb.hibernate;
/**
*
* @author Rafael Torres
*/
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sv.edu.udb.entites.HibernateUtil;
import sv.edu.udb.entites.Usuario;
public class Test {
 /**
 * @param args the command line arguments
 */
 public static void main(String[] args) {
 // TODO code application logic here
 SessionFactory sesFact=HibernateUtil.getSessionFactory();
 Session ses=sesFact.openSession();
 ArrayList<Usuario> listaUsers=new ArrayList<Usuario>();
 String sql="from Usuario";
 listaUsers= (ArrayList<Usuario>) ses.createQuery(sql).list();
 for(int i=0;i<listaUsers.size();i++){
 Usuario user=(Usuario)listaUsers.get(i);
 System.out.println(user.getUsuario() + " " + user.getCorreo() + " " +user.getContrasena() );
 }
 }

}

