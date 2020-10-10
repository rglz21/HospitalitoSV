/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.DAO.AreasDAO;
import sv.edu.udb.DAO.LoginDAO;
import sv.edu.udb.DAO.RegistroDAO;
import sv.edu.udb.DAO.TipoUsuDAO;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Tipousuario;
import sv.edu.udb.entites.Usuario;
import sv.edu.udb.util.logger;

/**
 *
 * @author rgonz
 */
@ManagedBean
@SessionScoped
public class RegistroBean {

    private String usuario;
    private Tipousuario tipousuario;
    private String contrasena;
    private String correo;
    private String verificar;
    private int tipo;
    private int tiipo;
    private String idPaciente;
    private String nombre;
    private String apellido;
    private String dui;
    private String telefono;
    private String direccion;
    private LoginDAO loginDao = new LoginDAO();

    /**
     * Creates a new instance of RegistroBean
     */
    public RegistroBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public String addUsuario(String dui) throws IOException {
         if (loginDao.findByuser(dui) > 0) {
            FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usted ya posee un expediente en esta clinica", "Paciente"));
             return "registro";
        }else{
        RegistroDAO productoDao = new RegistroDAO();
        Tipousuario nuevo = new Tipousuario();
        nuevo.setIdTipo(1);
        Usuario pro = new Usuario(usuario, nuevo, contrasena, correo, "Verificado");
        productoDao.addUsuario(pro);
        logger log = new logger();
        log.InfoLog("Nueva persona Registrado", "INFO");
        return "informacion";
         }
       
    }
    
     public String addUsuarioGeneral() throws IOException {
        RegistroDAO productoDao = new RegistroDAO();
        Tipousuario nuevo = new Tipousuario();
        nuevo.setIdTipo(getTipo());
        Usuario pro = new Usuario(usuario, nuevo, contrasena, correo, "Verificado");
        productoDao.addUsuarioGeneral(pro);
        logger log = new logger();
        log.InfoLog("Nuevo Usuario Registrado", "INFO");
        return "VerUsuariosGenerales";
    }

    public String addUsuarioMedico() throws IOException {
    
        RegistroDAO productoDao = new RegistroDAO();
        Tipousuario nuevo = new Tipousuario();
        nuevo.setIdTipo(2);
        Usuario pro = new Usuario(usuario, nuevo, contrasena, correo, "Verificado");
        productoDao.addUsuario(pro);
        logger log = new logger();
        log.InfoLog("Nuevo usuario tipo Medico Registrado", "INFO");
        return "registromedico";
        
        
    }

    // falta aplicarlo a la vista.
    public String addInformacion(String id,String dui) throws IOException {
          if (loginDao.findByDui(dui) > 0) {
            FacesContext.getCurrentInstance().addMessage("errorMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usted ya posee un expediente en esta clinica", "Paciente"));
             return "informacion";
        }else{
        RegistroDAO productoDao = new RegistroDAO();
        Paciente pro = new Paciente(id, nombre, apellido, dui, telefono, direccion);
        productoDao.addInformacion(pro);
        return "/Paciente/indexPaciente";
          }
    }
    
    public List<Tipousuario> getTipos() {
        TipoUsuDAO tipousuDao = new TipoUsuDAO();
        List<Tipousuario> lista = tipousuDao.getTipoUsu();
        return lista;
    }
    
    public List<Usuario> getUsuarios() {
        RegistroDAO usuarioDao = new RegistroDAO();
        List<Usuario> lista = usuarioDao.getUsuario();
        return lista;
    }
    
    public String returnUsuarios(String id) {
        RegistroDAO usuarioDao = new RegistroDAO();
        Usuario usuarioo = usuarioDao.getUsuario1(id);
        Tipousuario tipousu = new Tipousuario();
        tipousu.setIdTipo(getTiipo());
        if (usuarioo != null) {
            setUsuario(usuarioo.getUsuario());
            setTiipo(usuarioo.getTipousuario().getIdTipo());
            setCorreo(usuarioo.getCorreo());
            setContrasena(usuarioo.getContrasena());
        } else {
            setUsuario("");
            setTipo(0);
            setCorreo("");
            setContrasena("");

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Usuario NO especificado"));
        }
        return "EditarUsuariosGenerales";
    }
    
    public String updateUsuarios(String id) {
        RegistroDAO usuarioDao = new RegistroDAO();
        Usuario usuarioo = usuarioDao.getUsuario1(id);

        if (usuarioo != null) {
            Tipousuario tipousu = new Tipousuario();
            tipousu.setIdTipo(tiipo);
            Usuario usu = new Usuario(usuario, tipousu, contrasena, correo, "Verificado");
            usuarioDao.updateUsuario(id, usu);

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Usuario con ID " + id + " Actualizado"));
        } else {

            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Usuario con ID " + id + " NO encontrado"));
        }

        return "VerUsuariosGenerales";

    }

    public String deleteUsuarios(String id) {
        RegistroDAO usuarioDao = new RegistroDAO();
        Usuario usu = usuarioDao.getUsuario1(id);

        if (usu != null) {
            usuarioDao.deleteUsuario(id);
            setUsuario("");
            setTipo(0);
            setCorreo("");
            setContrasena("");
            setVerificar("");
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("Usuario con ID " + id + " Eliminado"));
        } else {
            FacesContext.getCurrentInstance().addMessage("successMessage",
                    new FacesMessage("usuario con ID " + id + " NO encontrado"));
        }

        return "VerUsuariosGenerales";
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Tipousuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Tipousuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
    }

    public int getTiipo() {
        return tiipo;
    }

    public void setTiipo(int tiipo) {
        this.tiipo = tiipo;
    }
    
    
}
