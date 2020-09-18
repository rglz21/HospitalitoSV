/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.DAO.LoginDAO;
import sv.edu.udb.entites.Usuario;

/**
 *
 * @author rgonz
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String verificar;
    private LoginDAO loginDao= new LoginDAO();
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public void countPaciente(String dui) throws SQLException{
        if(loginDao.findByDui(dui)>0){
            FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage(FacesMessage.SEVERITY_INFO,"Usted ya posee un expediente en esta clinica","Paciente"));
        }
    }

    public String sesionUser() {
        LoginDAO usuarioDao = new LoginDAO();
        Usuario user = usuarioDao.getUsuarioID(getUsuario());

        if (user != null) {
// Cuando el usuario ya esta verificado
            if (user.getUsuario().equals(usuario) && user.getContrasena().equals(contrasena) && user.getVerificar().equals("Verificado")) {
                 return "indexUser";
            } else {
// cuando el usuario no esta verificado
                if (user.getUsuario().equals(usuario) && user.getContrasena().equals(contrasena)) {
                       return "index";
                } else {
                    // Cuando la contraseña esta mal
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage("Contrasena Equivocada"));
                     return "login";
                }

            }

        } else {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Usuario NO existe, asegure de escribirlo bien"));
             return "login";
        }
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
    }

    /**
     * @return the loginDao
     */
    public LoginDAO getLoginDao() {
        return loginDao;
    }

    /**
     * @param loginDao the loginDao to set
     */
    public void setLoginDao(LoginDAO loginDao) {
        this.loginDao = loginDao;
    }

}
