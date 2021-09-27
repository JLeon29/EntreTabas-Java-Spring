package idat.edu.pe.daa2.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idat.edu.pe.daa2.entidades.Solicitud;
import idat.edu.pe.daa2.entidades.Usuario;
import idat.edu.pe.daa2.entidades.Zapatilla;
import idat.edu.pe.daa2.servicio.ISolicitudService;
import idat.edu.pe.daa2.servicio.IUsuarioService;
import idat.edu.pe.daa2.servicio.IZapatillaService;
import idat.edu.pe.daa2.util.Utileria;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {
	
	@Value("${EntreTabasMVC.ruta.imagenes}")
	private String ruta;

	@Autowired
	@Qualifier("solicitudServiceJpa")
	private ISolicitudService solicitudService;

	@Autowired
	@Qualifier("zapatillaServiceJpa")
	private IZapatillaService zapatillaService;

	@Autowired
	@Qualifier("usuarioServiceJpa")
	private IUsuarioService usuarioService;

	
	
	@GetMapping("/listar")
	public String mostrar(Model model) {

		List<Solicitud> solicitud = solicitudService.mostrar();

		model.addAttribute("solicitudes", solicitud);

		return "solicitudes/listar";
	}

	

	@PostMapping("/save")
	public String guardarSolicitud(@Valid Solicitud solicitud, BindingResult result, HttpSession session,
			Authentication authentication, Zapatilla zapatilla, Model model) {

		String username = authentication.getName();

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());

				return "detalle";

			}

		}
		
		
		Usuario usuario = usuarioService.buscarPorUsername(username);
		solicitud.setUsuario(usuario);
		solicitud.setFecha(new Date());
		solicitudService.guardar(solicitud);
		return "redirect:/solicitudes/listar";

	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(name="id") int idSolicitud, RedirectAttributes attributes) {
		
		
		
		solicitudService.eliminar(idSolicitud);
		attributes.addFlashAttribute("msg", "Solicitud Eliminada");
		
		return "redirect:/solicitudes/listar";
	}

	@ModelAttribute
	public void setGenericos(Model model) {

		model.addAttribute("zapatilla", zapatillaService.mostrar());

	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
