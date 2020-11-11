/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.security.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author maiku
 */
@ManagedBean
@RequestScoped
public class UserInfoMB {

    Authentication auth;

    public UserInfoMB() {
        auth = SecurityContextHolder.getContext().getAuthentication();
    }

    public String getUserName() {

        String name = auth.getName(); //get logged in username
        return name;
    }

    public ArrayList<String> getUserRole() {
        ArrayList<String> list = new ArrayList();
        Collection<? extends GrantedAuthority> authorities
                = auth.getAuthorities();

        for (GrantedAuthority grantedAuthority : authorities) {
            list.add(grantedAuthority.getAuthority());
        }
        return list;
    }
}
