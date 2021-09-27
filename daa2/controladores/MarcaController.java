package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.entidades.Marca;

import idat.edu.pe.daa2.servicio.IMarcaService;

@Controller
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	@Qualifier("marcaServiceJpa")
	private IMarcaService marcaService;

	@GetMapping("/listar")
	public String mostrar(Model model) {
		List<Marca> listaMarca = marcaService.mostrar();
		model.addAttribute("marca", listaMarca);

		return "marcas/listaMarca";

	}

	@GetMapping("/crear")
	public String crearMarca(Marca marca) {

		return "marcas/formMarca";
	}

	@PostMapping("/save")
	public String guardarMarca(Marca marca, Model model, RedirectAttributes attributes, BindingResult result) {

		marcaService.guardar(marca);
		attributes.addFlashAttribute("msg", "Registro Guardado");

		return "redirect:/marca/listar";
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(name="id") int idMarca, Model model) {
		
		Marca marca = marcaService.buscarPorId(idMarca);
		model.addAttribute("marca", marca);
		return "marcas/formMarca";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPelicula(@PathVariable(name = "id") int idMarca, RedirectAttributes attributes)
	{
		System.out.println("Borrando categoria con id: " + idMarca);
		marcaService.eliminar(idMarca);
		attributes.addFlashAttribute("msg","Marca Eliminada");
		return "redirect:/marca/listar";
		
	
	}

}
  