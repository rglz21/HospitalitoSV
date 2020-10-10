/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.IOException;
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
import sv.edu.udb.util.logger;

/**
 *
 * @author rgonz
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String verificar;
    private LoginDAO loginDao = new LoginDAO();

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public void countPaciente(String dui) throws SQLException {
        if (loginDao.findByDui(dui) > 0) {
            FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usted ya posee un expediente en esta clinica", "Paciente"));
        }
    }
    public void contarUsuario(String usuario){
     if (loginDao.findByuser(usuario) > 0) {
            FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usted ya posee un expediente en esta clinica", "Paciente"));
        }
    }

    public String sesionUser() throws IOException {
         logger log = new logger();
        
        LoginDAO usuarioDao = new LoginDAO();
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage("Porfavor llene los campos"));
            //log.InfoLog("Campos Vacios","ERROR");
            return "login";
            
        } 
            Usuario user = usuarioDao.getUsuarioID(getUsuario());
            int tipoUsuario = user.getTipousuario().getIdTipo();
            String newUser = user.getUsuario();
            String contra = user.getContrasena();
            String veri = user.getVerificar();

            if (user != null) {
// Cuando el usuario ya esta verificado
                if (newUser.equals(usuario) && contra.equals(contrasena) && veri.equals("Verificado") && tipoUsuario == 1) {
                    //log.InfoLog("Usuario:"+usuario+" ha ingresado","INFO");
                    return "Paciente/indexPaciente";
                } else if (newUser.equals(usuario) && contra.equals(contrasena) && veri.equals("Verificado") && tipoUsuario == 2) {
                   //log.InfoLog("Usuario:"+usuario+" ha ingresado","INFO");
                    return "Medicos/indexMedicos";
                } else if (newUser.equals(usuario) && contra.equals(contrasena) && veri.equals("Verificado") && tipoUsuario == 3) {
                    //log.InfoLog("Usuario:"+usuario+" ha ingresado","INFO");
                    return "Farmacia/indexFarmacia";
                } else if (newUser.equals(usuario) && contra.equals(contrasena) && veri.equals("Verificado") && tipoUsuario == 4) {
                    //log.InfoLog("Usuario:"+usuario+" ha ingresado","INFO");
                    return "Laboratorio/Examen";
                } else {
// cuando el usuario no esta verificado
                    if (user.getUsuario().equals(usuario) && user.getContrasena().equals(contrasena)) {
                        return "index";
                    } else {
                        // Cuando la contraseña esta mal
                        FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage("Contrasena Equivocada"));
                        return "login";
                    }

                }

            } else {

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Usuario NO existe, asegure de escribirlo bien"));
                return "login";
            }

        
        
    }

    public String registro() {
        return "Registro/registro";
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
