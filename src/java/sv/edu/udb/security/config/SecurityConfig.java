package sv.edu.udb.security.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    Context ctx = null;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/faces/Farmacia/**").access("hasRole('ROLE_Farmacia')").
                antMatchers("/faces/Paciente/**").access("hasRole('ROLE_Paciente')").
                antMatchers("/faces/Medicos/**").access("hasRole('ROLE_Medico')").
                antMatchers("/faces/Laboratorio/**").access("hasRole('ROLE_Laboratorio')").
                antMatchers("/faces/Admin/**").access("hasRole('ROLE_Admin')").
                antMatchers("/faces/Secretaria/**").access("hasRole('ROLE_Secretaria')").
                and().formLogin(). //login configuration
                loginPage("/faces/login.xhtml").
                loginProcessingUrl("/appLogin").
                usernameParameter("app_username").
                passwordParameter("app_password").
                successHandler(new CUAuthenticationSuccessHandler()).
                and().logout(). //logout configuration
                logoutUrl("/appLogout").
                logoutSuccessUrl("/faces/login.xhtml")
                ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws
            Exception {
        ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/mysql");
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery( "select usuario,Contrasena, idTipo from usuario where usuario =  ?")
            .authoritiesByUsernameQuery("select u.usuario,t.Tipo from usuario u, tipousuario t where u.idTipo=t.idTipo and u.Verificar='Verificado' AND usuario= ?");
        //select user,Tipo from tipousuario where user= ?
        auth.eraseCredentials(false);
    }
}

