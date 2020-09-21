/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.ManagedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sv.edu.udb.DAO.RegistroDAO;
import sv.edu.udb.entites.Paciente;
import sv.edu.udb.entites.Tipousuario;
import sv.edu.udb.entites.Usuario;

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
     private String idPaciente;
     private String nombre;
     private String apellido;
     private String dui;
     private String telefono;
     private String direccion;
    /**
     * Creates a new instance of RegistroBean
     */
    public RegistroBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    
    public String addUsuario() {
        RegistroDAO productoDao = new RegistroDAO();
         Tipousuario nuevo = new Tipousuario();
        nuevo.setIdTipo(1);
        Usuario pro = new Usuario(usuario,nuevo,contrasena,correo,"Verificado");
        productoDao.addUsuario(pro);
        return "informacion";
    }
    // falta aplicarlo a la vista.
     public String addInformacion(String id) {
        RegistroDAO productoDao = new RegistroDAO();
        Paciente pro = new Paciente(id,nombre,apellido,dui,telefono,direccion);
        productoDao.addInformacion(pro);
        return "/Paciente/indexPaciente";
        
        
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
    
}
