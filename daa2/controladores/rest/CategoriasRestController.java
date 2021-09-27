package idat.edu.pe.daa2.controladores.rest;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.daa2.entidades.Categoria;
import idat.edu.pe.daa2.servicio.db.CategoriaServiceJpa;

@RestController

@RequestMapping("/rest/categoria")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class CategoriasRestController {
	
	@Autowired
	private CategoriaServiceJpa categoriaService;
	
	@GetMapping
	
	public ResponseEntity<Object> buscarTodo(){
		
		List<Categoria> lista = categoriaService.mostrar();
		return new ResponseEntity<Object>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	
	@ResponseBody
	public ResponseEntity<Object> buscarPorId (@PathVariable("id") int idCategoria){
		
		Categoria categoria = categoriaService.buscarPorId(idCategoria);
		if(categoria == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Función no encontrada, id proporcionado no es correcto !!");
		
		return new ResponseEntity<>(categoria,HttpStatus.OK);
		
	}
	
	@PostMapping
	
	public ResponseEntity<Object> crear(@RequestBody Categoria categoriaNueva){
		
		categoriaService.guardar(categoriaNueva);
		Map<String, String> mapRespuesta = new HashMap<>();
		mapRespuesta.put("codigo", "00" );
		mapRespuesta.put("mensaje", "Nueva categoria creada correctamente");
		
		return new ResponseEntity<>(mapRespuesta, HttpStatus.CREATED);

	}
	
	@PatchMapping(value="/{id}")
	
	public ResponseEntity<Object> actualizar (@PathVariable("id") int idCategoria, @RequestBody Categoria categoria){
		
		categoriaService.actualizarCategoria(categoria);
		
		return new ResponseEntity<Object>("Categoria actualizada correctamente", HttpStatus.ACCEPTED);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> borrar(@PathVariable("id") int idCategoria){
		
		
		categoriaService.eliminar(idCategoria);
		return new ResponseEntity<Object>("Categoria eliminada correctamente",HttpStatus.OK);
		
	}
	

}
