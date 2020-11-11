package sv.edu.udb.security.config;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CUAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) throws IOException, ServletException {
        handle(hsr, hsr1, a);
        //clearAuthenticationAttributes(hsr);
    }

    protected void handle(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException {

        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
        
    }

    protected String determineTargetUrl(Authentication authentication) {
        boolean isAdmin = false;
        boolean isPac = false;
        boolean isMed = false;
        boolean isLab = false;
        boolean isFar = false;
        boolean isSec = false;
        
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_Admin")) {
                isAdmin = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_Paciente")) {
                isPac = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_Farmacia")) {
                isFar = true;
                  break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_Medico")) {
                isMed = true;
                  break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_Laboratorio")) {
                isLab = true;
                  break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_Secretaria")) {
                isSec = true;
                  break;
            }
        }
        if (isAdmin) {
            return "/faces/Admin/indexAdnmin.xhtml";
        } else if(isPac){
            return "/faces/Paciente/indexPaciente.xhtml";
        }else if(isFar){
            return "/faces/Farmacia/indexFarmacia.xhtml";
        }else if(isMed){
            return "/faces/Medicos/indexMedicos.xhtml";
        }else if(isLab){
            return "/faces/Laboratorio/Examen.xhtml";
        }else if(isSec){
            return "/faces/Secretaria/indexSecretaria.xhtml";
        }else {
            throw new IllegalStateException();
        }
        
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

}
