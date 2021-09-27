package idat.edu.pe.daa2.controladores;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idat.edu.pe.daa2.entidades.Perfil;
import idat.edu.pe.daa2.entidades.Usuario;
import idat.edu.pe.daa2.entidades.Zapatilla;
import idat.edu.pe.daa2.servicio.ZapatillaServiceImpl;
import idat.edu.pe.daa2.servicio.db.UsuarioServiceJpa;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceJpa usuarioService;

	@GetMapping("/listar")
	public String mostrarUsuario(Model model) {

		List<Usuario> usuarios = usuarioService.buscarTodos();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/listUsuarios";

	}

	@GetMapping("/login")
	public String loguearUsuario(Usuario usuario) {

		return "login/formLogin";
	}

	@GetMapping("/registrar")
	public String registrarUsuario(Usuario usuario) {

		return "usuarios/formRegistro";

	}

	
	
	@PostMapping("/save")
	public String guardarRegistro(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes, Model model) {
		
		if(result.hasErrors()) {
			
			return "usuarios/formRegistro";
		}
		
		
		// Recuperamos el password en texto plano
		String pwdPlano = usuario.getPassword();
		 
		// Hacemos un set al atributo password (ya viene encriptado)
		usuario.setPassword("{noop}" + pwdPlano);	
		
		usuario.setFechaRegistro(new Date()); 
		
		
		Perfil perfil = new Perfil();
		perfil.setId(3);
		usuario.agregar(perfil);
		
		
		usuarioService.guardar(usuario);
				
		attributes.addFlashAttribute("msg", "Has sido registrado. ¡Ahora puedes ingresar al sistema!");
		
		return "redirect:/usuario/login";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(name = "id") int idUsuario, RedirectAttributes attributes) {

		usuarioService.eliminar(idUsuario);

		attributes.addFlashAttribute("msg", "Usuario Eliminado");

		return "redirect:/usuario/listar";
	}

	

}
