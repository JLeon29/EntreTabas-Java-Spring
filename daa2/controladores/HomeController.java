package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.daa2.entidades.Zapatilla;
import idat.edu.pe.daa2.servicio.ICategoriaService;
import idat.edu.pe.daa2.servicio.IZapatillaService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("categoriaServiceJpa")
	private ICategoriaService categoriaService;
	
	@Autowired
	@Qualifier("zapatillaServiceJpa")
	private IZapatillaService zapatillaService;
	
	@GetMapping("/403")
	public String error403() {
		return "error403";
	}
	/*
	@GetMapping("buscar")
	public String buscar(@ModelAttribute("buscar") Zapatilla zapatilla, Model model) {
		
		System.out.println("Buscando por : " + zapatilla);
		
		Example<Zapatilla> example = Example.of(zapatilla);
		List<Zapatilla> lista = zapatillaService.buscarByExample(example);
		model.addAttribute("zapatillas", lista);
		
		return "shoes";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		
		Zapatilla zapatillaSerch = new Zapatilla();
		zapatillaSerch.reset();
		model.addAttribute("categorias", categoriaService.mostrar());
		model.addAttribute("buscar", zapatillaSerch);
		
	}*/

}
