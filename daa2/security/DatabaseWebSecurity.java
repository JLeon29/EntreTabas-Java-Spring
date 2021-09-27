package idat.edu.pe.daa2.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, estatus from usuario where username=?")
				.authoritiesByUsernameQuery("select u.username, p.perfil from usuarioperfil up "
						+ "inner join usuario u on u.id = up.idUsuario " + "inner join perfil p on p.id = up.idPerfil "
						+ "where u.username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				
				.antMatchers("/css/**", "/images/**", "/js/**", "/logos/**").permitAll()
				
				.antMatchers("/zapatilla/", "/zapatilla/mostrar", "/usuario/registrar", "/usuario/save","/solicitudes/listar","/rest/categoria/{id}", "/rest/categoria",
						"/rest/zapatilla/**","/rest/zapatilla/{id}", "/rest/marca/**")
				
				.permitAll()
				
				.antMatchers(HttpMethod.DELETE, "/rest/marca/{id}").permitAll()
				
				
				
				.antMatchers("/marca/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
				.antMatchers("/categoria/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
				.antMatchers("/zapatilla/listar", "/zapatilla/crear", "/zapatilla/save","/zapatilla/actualizar/**","/zapatilla/eliminar/**").hasAnyAuthority("ADMINISTRADOR", "SUPERVISOR")
				.antMatchers("/usuario/**").hasAnyAuthority("ADMINISTRADOR", "SUPERVISOR")
				.antMatchers("/zapatilla/view/**").hasAnyAuthority("ADMINISTRADOR", "SUPERVISOR","USUARIO")
				
				
				
				// . . . .
				
				.anyRequest().authenticated()
				
				.and().formLogin().loginPage("/usuario/login").permitAll()
				.and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/403");
				
				
				
	}
	
	
	
	
}