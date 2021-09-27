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
import idat.edu.pe.daa2.entidades.Zapatilla;
import idat.edu.pe.daa2.servicio.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	@Qualifier("categoriaServiceJpa")
	private ICategoriaService categoriaService;

	@GetMapping("/listar")
	public String mostrar(Model model) {
		List<Categoria> listaCategoria = categoriaService.mostrar();
		model.addAttribute("categoria", listaCategoria);
		
		return "categorias/listaCategoria";

	}
	
	@GetMapping("/crear")
	public String crearCategoria(Categoria categoria, Model model) {
		
		return "categorias/formCategoria";
	}
	
	@PostMapping("/save")
	public String guardarCategoria(Categoria categoria, Model model, RedirectAttributes attributes, BindingResult result) {
		
		categoriaService.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado");

		return "redirect:/categoria/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPelicula(@PathVariable(name = "id") int idCategoria, RedirectAttributes attributes)
	{
		
		categoriaService.eliminar(idCategoria);
		attributes.addFlashAttribute("msg","Categoria Eliminada !!");
		return "redirect:/categoria/listar";
		
	
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizar(@PathVariable(name="id") int idCategoria, Model model) {
		
		Categoria categoria = categoriaService.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}

}
 